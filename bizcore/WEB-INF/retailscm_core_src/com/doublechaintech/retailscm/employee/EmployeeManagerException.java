package com.doublechaintech.retailscm.employee;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class EmployeeManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public EmployeeManagerException(String string) {
    super(string);
  }

  public EmployeeManagerException(Message message) {
    super(message);
  }

  public EmployeeManagerException(List<Message> messageList) {
    super(messageList);
  }
}
