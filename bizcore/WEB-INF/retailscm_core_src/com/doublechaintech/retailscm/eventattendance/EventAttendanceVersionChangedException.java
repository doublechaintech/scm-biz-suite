package com.doublechaintech.retailscm.eventattendance;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class EventAttendanceVersionChangedException extends EventAttendanceManagerException {
  private static final long serialVersionUID = 1L;

  public EventAttendanceVersionChangedException(String string) {
    super(string);
  }
}
