package com.doublechaintech.retailscm.eventattendance;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class EventAttendanceNotFoundException extends EntityNotFoundException {
  private static final long serialVersionUID = 1L;

  public EventAttendanceNotFoundException(String string) {
    super(string);
  }
}
