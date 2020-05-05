package com.doublechaintech.retailscm;

import com.skynet.infrastructure.graphservice.BaseQuery;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class RetailscmQuery extends BaseQuery {
	
	public RetailscmQuery(Class startType, String ... pStart) {
        super(startType, pStart);
        super.setProject("retailscm");
  }

  public RetailscmQuery(Object start){
    this(start.getClass(), getId(start));
  }

  private static String getId(Object pStart) {
      BeanWrapper bw = new BeanWrapperImpl(pStart);
      return String.valueOf(bw.getPropertyValue("id"));
  }
}























