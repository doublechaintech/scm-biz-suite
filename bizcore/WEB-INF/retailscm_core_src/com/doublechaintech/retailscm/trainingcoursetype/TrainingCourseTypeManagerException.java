package com.doublechaintech.retailscm.trainingcoursetype;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class TrainingCourseTypeManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public TrainingCourseTypeManagerException(String string) {
    super(string);
  }

  public TrainingCourseTypeManagerException(Message message) {
    super(message);
  }

  public TrainingCourseTypeManagerException(List<Message> messageList) {
    super(messageList);
  }
}
