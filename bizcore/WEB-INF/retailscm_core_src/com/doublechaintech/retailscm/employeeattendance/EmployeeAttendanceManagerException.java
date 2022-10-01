package com.doublechaintech.retailscm.employeeattendance;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class EmployeeAttendanceManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public EmployeeAttendanceManagerException(String string) {
    super(string);
  }

  public EmployeeAttendanceManagerException(Message message) {
    super(message);
  }

  public EmployeeAttendanceManagerException(List<Message> messageList) {
    super(messageList);
  }
}
