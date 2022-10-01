package com.doublechaintech.retailscm.data;

import com.doublechaintech.retailscm.CustomRetailscmUserContextImpl;

public interface PropertyConverter {
  Object convert(CustomRetailscmUserContextImpl ctx, Object row, Object property, Class expectType)
      throws Exception;
}
