package com.doublechaintech.retailscm;

public class RetailscmListOfViewScope extends BaseRetailscmListOfViewScope {

	protected static RetailscmListOfViewScope instance = new RetailscmListOfViewScope();
	static {
		instance.initAllViewScope();
	}
	public static RetailscmListOfViewScope getInstance() {
		return instance;
	}
}















