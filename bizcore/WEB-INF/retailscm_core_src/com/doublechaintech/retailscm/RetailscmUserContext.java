package com.doublechaintech.retailscm;

public interface RetailscmUserContext extends UserContext{
    //define the domain specific user model
	String getLocaleKey(String subject);
	void setChecker(RetailscmChecker checker);
	RetailscmChecker getChecker();
}

