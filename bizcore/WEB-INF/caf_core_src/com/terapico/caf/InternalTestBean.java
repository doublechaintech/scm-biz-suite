package com.terapico.caf;

import java.util.concurrent.atomic.AtomicInteger;

public class InternalTestBean {
	//private int echocount=0;
	private AtomicInteger counter = new AtomicInteger(0);
	public String hello(){
		return "when you see this, that means you need to inject some beans to playwith";
	}
	public String  echo(String message){
		counter.incrementAndGet();
		return message;
	}
	public int echocount(){
		//echocount++;
		return counter.get();
	}
	
	
}
