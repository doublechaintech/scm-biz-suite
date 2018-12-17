package com.terapico.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 仅用于内部消息统一处理。内存队列，不持久化，不过滤。
 * @author clariones
 *
 */
public class BasicInternalEventCFS {
	public interface EventListener {
		void onEventArrived(String eventKey, Object[] eventParams, Date postTime, String fromClass, String fromMethod, String fromLine);
	}

	static class EventWrapper {
		String eventKey;
		Object[] eventParams;
		Date postTime;
		String fromClass;
		String fromMethod;
		String fromLine;
	}
	
	private static Thread pollingThread = null;
	private static BlockingQueue<EventWrapper> taskQueue = null;
	private static List<EventListener> listeners = null;
	
	private static void ensurePollingThread() {
		if (pollingThread != null) {
			return;
		}
		synchronized(BasicInternalEventCFS.class) {
			if (pollingThread != null) {
				return;
			}
			pollingThread = new Thread("InternalCFS") {
				public void run() {
					while(true) {
						try {
							taskPolling();
						} catch (InterruptedException e) {
							e.printStackTrace();
							break;
						}
					}
					pollingThread = null;
				}
			};
			taskQueue = new LinkedBlockingQueue<>(1000);
			pollingThread.start();
		}
	}

	private static void taskPolling() throws InterruptedException {
		long sts = System.currentTimeMillis();
		EventWrapper wrapper = taskQueue.poll(5, TimeUnit.MINUTES);
		if (wrapper == null) {
			String timeStr = DateTimeUtil.formatDuration(System.currentTimeMillis() - sts, null);
			System.out.println(DateTimeUtil.formatDate(new Date(), null) + "\tMore than "+timeStr+" idled.");
			return;
		}
		if (listeners == null || listeners.isEmpty()) {
			System.out.println("Drop event " + wrapper.eventKey + " because no any listener post at "
					+ DateTimeUtil.formatDate(wrapper.postTime, "yyyyMMdd-HH:mm:ss.SSS") + ": " + dumpEventParams(wrapper) +", from "
					+wrapper.fromClass+"::"+wrapper.fromMethod+"()@line"+wrapper.fromLine);
			return;
		}
		// 很简易的消息分发，每个listener都接到所有的消息。 需要过滤的，可以注册一个唯一的listener，这个listener啥也不干，只做消息过滤分发。
		// 另外这里是同步处理的，也就是保证事件是一个一个被“初步”处理完了以后才会继续处理下一个。 并发处理多个消息，可以注册一个唯一的listener...
		for(EventListener listener : listeners) {
			listener.onEventArrived(wrapper.eventKey, wrapper.eventParams, wrapper.postTime, wrapper.fromClass, wrapper.fromMethod, wrapper.fromLine);
		}
	}

	private static String dumpEventParams(EventWrapper wrapper) {
		if ( wrapper.eventParams == null ) {
			return "[no params]";
		}
		return String.join(",", Arrays.asList(wrapper.eventParams).stream().map(it->String.valueOf(it)).collect(Collectors.toList()));
	}
	
	public static void addListener(EventListener newListener) {
		ensureListeners();
		Iterator<EventListener> it = listeners.iterator();
		while(it.hasNext()) {
			EventListener listener = it.next();
			if (listener.getClass().equals(newListener.getClass())) {
				it.remove();// 每种listener只要一个
			}
		}
		listeners.add(newListener);
	}
	
	private static void ensureListeners() {
		if (listeners == null) {
			listeners = new ArrayList<>();
		}
	}

	public static void putTask(String eventKey, Object[] eventParams, Date postTime, String fromClass, String fromMethod, String fromLine) throws InterruptedException {
		EventWrapper wrapper = new EventWrapper();
		wrapper.eventKey = eventKey;
		wrapper.eventParams = eventParams;
		wrapper.postTime = postTime;
		
		wrapper.fromClass = fromClass;
		wrapper.fromMethod = fromMethod;
		wrapper.fromLine = fromLine;
		ensurePollingThread();
		taskQueue.put(wrapper);
	}
}
