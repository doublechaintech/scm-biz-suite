package com.doublechaintech.retailscm.data;

import com.doublechaintech.retailscm.CustomRetailscmUserContextImpl;

import java.util.Map;

public interface RowValidator {
  String validate(CustomRetailscmUserContextImpl ctx, Map<String, Object> rowData, int pDataRow);
}
