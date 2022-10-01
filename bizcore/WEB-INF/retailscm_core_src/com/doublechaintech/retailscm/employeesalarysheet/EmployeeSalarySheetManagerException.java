package com.doublechaintech.retailscm.employeesalarysheet;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class EmployeeSalarySheetManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public EmployeeSalarySheetManagerException(String string) {
    super(string);
  }

  public EmployeeSalarySheetManagerException(Message message) {
    super(message);
  }

  public EmployeeSalarySheetManagerException(List<Message> messageList) {
    super(messageList);
  }
}
