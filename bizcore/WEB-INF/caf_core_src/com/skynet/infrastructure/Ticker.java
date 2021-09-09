package com.skynet.infrastructure;

public class Ticker{
	
	long previousTime = System.currentTimeMillis();
	
	public void tick(String title){
		long currentTime = System.currentTimeMillis();
		long interval = (currentTime - previousTime);
		System.out.printf("%20s: +%dms\n", title, interval);
		previousTime = currentTime;
	}
	
}