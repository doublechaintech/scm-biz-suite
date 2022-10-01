package com.doublechaintech.retailscm.employeequalifier;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class EmployeeQualifierManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public EmployeeQualifierManagerException(String string) {
    super(string);
  }

  public EmployeeQualifierManagerException(Message message) {
    super(message);
  }

  public EmployeeQualifierManagerException(List<Message> messageList) {
    super(messageList);
  }
}
