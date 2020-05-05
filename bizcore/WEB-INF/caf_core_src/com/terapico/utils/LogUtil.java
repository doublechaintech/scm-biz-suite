package com.terapico.utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

import com.terapico.uccaf.BaseUserContext;

public class LogUtil {
	protected static final int MAX_FILE_SIZE = 100*1024*1024;
	protected static final int MAX_FILE_ROLL = 100;
	protected static class LogPackage {
		String loggerKey;
		BaseUserContext userContext;
		Level level;
		String[] headers;
		Object[] values;
		LocalDateTime time;
		
		public LogPackage(String loggerKey, BaseUserContext userContext, Level level, String[] headers, Object[] values) {
			super();
			this.loggerKey = loggerKey;
			this.userContext = userContext;
			this.level = level;
			this.headers = headers;
			this.values = values;
			this.time = LocalDateTime.now();
		}
	}

	protected static BlockingQueue<LogPackage> packageQueue;
	protected static Thread handlingThread;
	protected static Map<String, Logger> allloggers = new HashMap<>();
	
	
	public static Logger getLogger(String name) {
		return getLogger(name, Level.TRACE);
	}
	public static Logger getLogger(String name, Level level) {
		return getLogger(name, level, MAX_FILE_SIZE, MAX_FILE_ROLL);
	}
	public static Logger getLogger(String name, int fileSize, int rollingFiles) {
		return getLogger(name, Level.TRACE, fileSize, rollingFiles);
	}
	public static Logger getLogger(String name, Level level, int fileSize, int rollingFiles) {
		return getOrCreateLogger(name, level, fileSize, rollingFiles);
	}
	protected static Logger getOrCreateLogger(String name, Level level, int fileSize, int rollingFiles) {
		if (allloggers.containsKey(name)) {
			return allloggers.get(name);
		}
		
		Logger logger = Logger.getLogger(name);
		
		try {
			File outputFile = new File(TextUtil.getExtVariable("LOG_FOLDER", System.getProperty("user.home")), name.replace('.', '_') + ".log");
			Layout layout = new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p: %m%n");
			RollingFileAppender newAppender = new RollingFileAppender(layout, outputFile.getAbsolutePath(), true);
			newAppender.setMaxFileSize(String.format("%d", fileSize));
			newAppender.setMaxBackupIndex(rollingFiles);
			logger.addAppender(newAppender);
			logger.setLevel(level);
			allloggers.put(name, logger);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return logger;
	}
	
	public static void log(String loggerKey, BaseUserContext ctx, Level level, String headers, Object ... values) {
		log(loggerKey, ctx, level, headers.split(","), values);
	}
	public static void log(String loggerKey, BaseUserContext ctx, Level level, String[] headers, Object ... values) {
		LogPackage logPkg = new LogPackage(loggerKey, ctx, level, headers, values);
		// System.out.println(Thread.currentThread().getId()+": [LOGUTIL] offer " + logPkg);
		offerPackage(logPkg);
	}

	protected static void offerPackage(LogPackage logPkg) {
		ensureHandling();
		try {
			packageQueue.put(logPkg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected static void ensureHandling() {
		if (packageQueue != null) {
			return;
		}
		synchronized (LogUtil.class) {
			if (packageQueue != null) {
				return;
			}
			handlingThread = new Thread() {
				public void run() {
					for(;;) {
						try {
							handlePackages();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			};
			packageQueue = new LinkedBlockingQueue<>(1000);
			handlingThread.start();
		}
	}

	protected static void handlePackages() throws Exception {
		LogPackage pkg = packageQueue.take();
		if (pkg == null) {
			return;
		}
		// System.out.println(Thread.currentThread().getId()+": [LOGUTIL] process " + pkg);
		Logger logger = getLogger(pkg.loggerKey);
		if (!logger.isEnabledFor(pkg.level)) {
			return;
		}
		Object message = assemblerMessage(pkg);
		logger.log(pkg.level, message);
	}
	
	private static Object assemblerMessage(LogPackage pkg) {
		if (pkg.values == null || pkg.values.length == 0) {
			return "";
		}
		if (pkg.headers == null || pkg.headers.length < 1) {
			return pkg.values;
		}
		Map<String, Object> messages = new LinkedHashMap<>();
		if (pkg.values.length <= pkg.headers.length) {
			for(int i=0;i<pkg.values.length;i++) {
				String name = pkg.headers[i];
				messages.put(name, pkg.values[i]);
			}
			messages.put("create_time", DateTimeFormatter.ISO_DATE_TIME.format( pkg.time));
			return messages;
		}
		for(int i=0;i<pkg.headers.length;i++) {
			String name = pkg.headers[i];
			messages.put(name, pkg.values[i]);
		}
		List<Object> others = new ArrayList<>();
		for(int i=pkg.headers.length;i<pkg.values.length;i++) {
			others.add(pkg.values[i]);
		}
		messages.put("others", others);
		messages.put("create_time", DateTimeFormatter.ISO_DATE_TIME.format( pkg.time));
		return messages;
	}
	
	
	public static void main(String[] args) {
		Logger logger = getLogger("test.try2");  
		logger.info("test logging");
		
		Logger logger2 = getLogger("test.do2");  
		logger2.info("do logging");
		
		logger.info("test logging again");
		logger2.info("do logging again");
		
		logger.debug("test logging again 2");
		logger2.debug("do logging again 2");
		
		logger.setLevel(Level.ALL);
		
		logger.trace("test logging again 3");
		logger2.trace("do logging again 3");
		
		logger.warn("test logging again 4");
		logger2.warn("do logging again 4");
		
		log("try.try", null, Level.INFO, "a,b,c", 1,2,3);
		log("try.try", null, Level.INFO, "a,b", 1,2,3);
		log("try.try", null, Level.INFO, "a,b,c", 1,2);
		
	}
	
}
