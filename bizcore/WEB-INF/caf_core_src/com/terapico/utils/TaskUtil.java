package com.terapico.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

import com.terapico.uccaf.BaseUserContext;

public class TaskUtil {
	protected static class ScheduleTask extends Thread{
		boolean runningFlag;
		Runnable task;
		long intervalInMs;
		String name;

		@Override
		public void run() {
			while(executeTaskAndContinue());
		}

		protected boolean executeTaskAndContinue() {
			long targetTs = System.currentTimeMillis() + intervalInMs;
			task.run();
			long waitMs = Math.max(100L, targetTs - System.currentTimeMillis());
			synchronized (this) {
				try {
					this.wait(waitMs);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (!runningFlag) {
					return false;
				}
			}
			return true;
		}
	}
	protected static Map<String, Boolean> runningFlags = new HashMap<>();
	protected static Map<String, AtomicLong> jvmLocks = new HashMap<>();
	protected static Map<String, Semaphore> jvmTempLocks = new HashMap<>();
	protected static Thread jvmLockCleanupThread = null;
	protected static final long IDLE_PERIOD_IN_MS = 10*DateTimeUtil.MINUTE_IN_MS;
	protected static ExecutorService executor = Executors.newCachedThreadPool();
	protected static Map<String, ScheduleTask> runningScheduleTask = new HashMap<>();
	
	public static Object getLockByKey(BaseUserContext ctx, String key) {
		synchronized (jvmLocks) {
			AtomicLong ts = jvmLocks.get(key);
			if (ts != null) {
				ts.set(System.currentTimeMillis());
				return ts;
			}
			ensureJvmLockCleanTask(ctx);
			ts = new AtomicLong(System.currentTimeMillis());
			jvmLocks.put(key, ts);
			return ts;
		}
	}

	public static String waitLockByKey(BaseUserContext ctx, String key, long waitTime) throws InterruptedException {
		Semaphore obj = null;
		synchronized (jvmTempLocks) {
			obj = jvmTempLocks.get(key);
			if (obj == null) {
				obj = new Semaphore(1,true);
				jvmTempLocks.put(key, obj);
				System.out.print("初始化信号量");
			}else{
				System.out.print("等待信号量");
			}
		}
		obj.acquire();
		return key;
	}

	public static Object releaseLockByKey(BaseUserContext ctx, String key) throws InterruptedException {
		Semaphore obj = null;
		synchronized (jvmTempLocks) {
			obj = jvmTempLocks.get(key);
		}
		if (obj != null){
			obj.release();
		}

		return key;
	}

	private static void ensureJvmLockCleanTask(BaseUserContext ctx) {
		if (jvmLockCleanupThread != null) {
			return;
		}
		synchronized(TaskUtil.class) {
			if (jvmLockCleanupThread != null) {
				return;
			}
			jvmLockCleanupThread = new Thread(
				()->{
				for(;;) {
					Iterator<Entry<String, AtomicLong>> it = jvmLocks.entrySet().iterator();
					while(it.hasNext()) {
						Entry<String, AtomicLong> ent = it.next();
						AtomicLong ts = ent.getValue();
						if (System.currentTimeMillis() - ts.get() > IDLE_PERIOD_IN_MS) {
							it.remove();
						}
					}
					
					// 10秒检查一次
					try {
						Thread.sleep(10*DateTimeUtil.SECOND_IN_MS);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}, "TaskUtil_LocksCleanup");
			jvmLockCleanupThread.start();
		};
	}

	public static Object runSingletonTask(String taskName, Supplier<?> task) throws Exception {
		if (checkTaskRunning(taskName, true)) {
			throw new Exception("Task \"" + taskName + "\" is running now");
		}
		try {
			return task.get();
		} finally {
			markTaskFinished(taskName);
		}
	}
	
	public static void runSingletonTask(String taskName, Runnable task) throws Exception {
		if (checkTaskRunning(taskName, true)) {
			throw new Exception("Task \"" + taskName + "\" is already running");
		}
		try {
			task.run();
		} finally {
			markTaskFinished(taskName);
		}
	}

	public static void runSingletonTaskAsync(String taskName, Runnable task) throws Exception {
		runAsync(()->{
			try {
				runSingletonTask(taskName, task);
			} catch (Exception e) {
				// 异常打印出来,但是不中断当前线程
				e.printStackTrace();
			}
		});
	}

	
	protected static void markTaskFinished(String taskName) {
		synchronized(TaskUtil.class) {
			runningFlags.put(taskName, false);
		}
	}

	protected static void markTaskRunning(String taskName) {
		synchronized(TaskUtil.class) {
			runningFlags.put(taskName, true);
		}
	}
	
	public synchronized static boolean checkTaskRunning(String taskName) {
		return checkTaskRunning(taskName, false);
	}

	public synchronized static boolean checkTaskRunning(String taskName, boolean setRunning) {
		Boolean flag = runningFlags.get(taskName);
		if (setRunning) {
			runningFlags.put(taskName, true);
		}
		if (flag == null) {
			return false;
		}
		return flag;
	}

	public static void runAsync(Runnable runnable) {
		executor.execute(runnable);
	}
	public static <V> Future<V> runAsync(Callable<V> callable) {
		return executor.submit(callable);
	}

    public synchronized static String addScheduleTask(String taskName, long intervalInMs, Runnable runnable) {
		if (runningScheduleTask.containsKey(taskName)){
			return "already_running";
		}
		ScheduleTask sTask = new ScheduleTask();
		sTask.intervalInMs = intervalInMs;
		sTask.task = runnable;
		sTask.name = taskName;
		sTask.runningFlag = true;
		runningScheduleTask.put(taskName, sTask);
		sTask.start();
		return "started";
    }

    public synchronized static String removeScheduleTask(String taskName) {
		ScheduleTask task = runningScheduleTask.get(taskName);
		if (task == null) {
			return "not_found";
		}
		task.runningFlag = false;
		synchronized (task) {
			task.notifyAll();
		}
		runningScheduleTask.remove(taskName);
		return "removed";
	}
}
