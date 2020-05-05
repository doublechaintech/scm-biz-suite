package com.terapico.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

import com.terapico.uccaf.BaseUserContext;

public class TaskUtil {
	protected static Map<String, Boolean> runningFlags = new HashMap<>();
	protected static Map<String, AtomicLong> jvmLocks = new HashMap<>();
	protected static Thread jvmLockCleanupThread = null;
	protected static final long IDLE_PERIOD_IN_MS = 10*DateTimeUtil.MINUTE_IN_MS;
	protected static ExecutorService executor = Executors.newCachedThreadPool();
	
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
		if (checkTaskRunning(taskName)) {
			throw new Exception("Task \"" + taskName + "\" is running now");
		}
		try {
			return task.get();
		} finally {
			markTaskFinished(taskName);
		}
	}
	
	public static void runSingletonTask(String taskName, Runnable task) throws Exception {
		if (checkTaskRunning(taskName)) {
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
	
	protected synchronized static boolean checkTaskRunning(String taskName) {
		synchronized(TaskUtil.class) {
			Boolean flag = runningFlags.get(taskName);
			runningFlags.put(taskName, true);
			if (flag == null) {
				return false;
			}
			return flag;
		}
	}

	public static void runAsync(Runnable runnable) {
		executor.execute(runnable);
	}
	
}
