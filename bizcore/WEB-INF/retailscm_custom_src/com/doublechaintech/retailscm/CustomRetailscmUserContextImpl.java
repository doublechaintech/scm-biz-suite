package com.doublechaintech.retailscm;

public class CustomRetailscmUserContextImpl extends RetailscmBizUserContextImpl {
    protected BaseEntity currentUserInfo;

    public BaseEntity getCurrentUserInfo() {
        return currentUserInfo;
    }

    public void setCurrentUserInfo(BaseEntity currentUserInfo) {
        this.currentUserInfo = currentUserInfo;
    }

}

