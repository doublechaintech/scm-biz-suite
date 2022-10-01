package com.doublechaintech.retailscm.data;

import com.doublechaintech.retailscm.UserContext;

import java.util.Map;

public interface PropertyValidator {
  String validate(UserContext ctx, Map<String, Object> rowData, String propertyName, Object value);
}
