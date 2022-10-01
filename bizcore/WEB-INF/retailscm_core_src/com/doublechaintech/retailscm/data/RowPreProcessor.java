package com.doublechaintech.retailscm.data;

import com.doublechaintech.retailscm.CustomRetailscmUserContextImpl;

import java.util.Map;

public interface RowPreProcessor {
  String processor(CustomRetailscmUserContextImpl ctx, Map<String, Object> rowData, int pDataRow);
}
