package com.doublechaintech.retailscm.employeecompanytraining;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class EmployeeCompanyTrainingManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public EmployeeCompanyTrainingManagerException(String string) {
    super(string);
  }

  public EmployeeCompanyTrainingManagerException(Message message) {
    super(message);
  }

  public EmployeeCompanyTrainingManagerException(List<Message> messageList) {
    super(messageList);
  }
}
