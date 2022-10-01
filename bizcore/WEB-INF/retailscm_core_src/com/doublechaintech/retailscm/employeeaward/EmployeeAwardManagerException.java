package com.doublechaintech.retailscm.employeeaward;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class EmployeeAwardManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public EmployeeAwardManagerException(String string) {
    super(string);
  }

  public EmployeeAwardManagerException(Message message) {
    super(message);
  }

  public EmployeeAwardManagerException(List<Message> messageList) {
    super(messageList);
  }
}
