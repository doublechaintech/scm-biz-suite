package com.doublechaintech.retailscm.interviewtype;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class InterviewTypeManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public InterviewTypeManagerException(String string) {
    super(string);
  }

  public InterviewTypeManagerException(Message message) {
    super(message);
  }

  public InterviewTypeManagerException(List<Message> messageList) {
    super(messageList);
  }
}
