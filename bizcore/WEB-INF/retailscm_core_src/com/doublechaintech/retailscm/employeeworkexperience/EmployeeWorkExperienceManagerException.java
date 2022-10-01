package com.doublechaintech.retailscm.employeeworkexperience;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class EmployeeWorkExperienceManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public EmployeeWorkExperienceManagerException(String string) {
    super(string);
  }

  public EmployeeWorkExperienceManagerException(Message message) {
    super(message);
  }

  public EmployeeWorkExperienceManagerException(List<Message> messageList) {
    super(messageList);
  }
}
