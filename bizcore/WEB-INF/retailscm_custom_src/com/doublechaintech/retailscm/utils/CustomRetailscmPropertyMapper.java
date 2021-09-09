package com.doublechaintech.retailscm.utils;

import com.doublechaintech.retailscm.RetailscmUserContext;

public class CustomRetailscmPropertyMapper extends RetailscmPropertyMapper{
    static {
    //    registerCreator(目标类, 场景?, 字段?, 自定义creator);
    }
    public static CustomRetailscmPropertyMapper of(RetailscmUserContext ctx){
      String key = "thread_lvl_helper_" + CustomRetailscmPropertyMapper.class.getName();
      CustomRetailscmPropertyMapper rst = (CustomRetailscmPropertyMapper) ctx.getFromContextLocalStorage(key);
      if (rst != null) {
        return rst;
      }
      rst = new CustomRetailscmPropertyMapper();
      rst.setUserContext(ctx);
      ctx.putIntoContextLocalStorage(key, rst);
      return rst;
    }
}
















