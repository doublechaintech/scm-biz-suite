package com.doublechaintech.retailscm.trainingcoursetype;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class TrainingCourseTypeVersionChangedException extends TrainingCourseTypeManagerException {
  private static final long serialVersionUID = 1L;

  public TrainingCourseTypeVersionChangedException(String string) {
    super(string);
  }
}
