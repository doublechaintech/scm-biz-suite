package com.doublechaintech.retailscm;

public interface RetailscmUserContext extends UserContext{

    // define the domain specific user model
    String getLocaleKey(String subject);

    void setChecker(RetailscmObjectChecker checker);

    RetailscmObjectChecker getChecker();

    void saveAccessInfo(String beanName, String methodName, Object[] parameters);

    void addFootprint(FootprintProducer helper) throws Exception;

    Object getPreviousViewPage() throws Exception;

    Object getLastViewPage() throws Exception;

    Object goback() throws Exception;

    <T extends BaseEntity> T reloadEntity(T stubEntity) throws Exception;
}

