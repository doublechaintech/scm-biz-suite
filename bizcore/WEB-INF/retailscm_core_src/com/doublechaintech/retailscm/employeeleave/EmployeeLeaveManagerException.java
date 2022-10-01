package com.doublechaintech.retailscm.employeeleave;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class EmployeeLeaveManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public EmployeeLeaveManagerException(String string) {
    super(string);
  }

  public EmployeeLeaveManagerException(Message message) {
    super(message);
  }

  public EmployeeLeaveManagerException(List<Message> messageList) {
    super(messageList);
  }
}
