package com.doublechaintech.retailscm.leavetype;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class LeaveTypeVersionChangedException extends LeaveTypeManagerException {
  private static final long serialVersionUID = 1L;

  public LeaveTypeVersionChangedException(String string) {
    super(string);
  }
}
