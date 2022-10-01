package com.doublechaintech.retailscm.data;

import com.doublechaintech.retailscm.UserContext;

public interface PhaseProcessor {
  void process(UserContext ctx);
}
