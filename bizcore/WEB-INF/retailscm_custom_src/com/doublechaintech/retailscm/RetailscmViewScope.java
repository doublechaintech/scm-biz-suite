package com.doublechaintech.retailscm;


import com.terapico.caf.viewpage.SerializeScope;

public class RetailscmViewScope extends RetailscmBaseViewScope{

	static {
		// 定制化本项目的序列化scope的代码放在这里
		System.out.println("**************************************************************\n定制序列化\n");
	}
	
	protected static RetailscmViewScope instance = null;
	public static RetailscmViewScope getInstance() {
		if (instance != null) {
			return instance;
		}
		synchronized (RetailscmViewScope.class) {
			instance = new RetailscmViewScope();
		}
		return instance;
	}
}







