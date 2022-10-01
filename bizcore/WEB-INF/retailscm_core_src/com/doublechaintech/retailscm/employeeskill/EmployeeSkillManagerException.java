package com.doublechaintech.retailscm.employeeskill;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class EmployeeSkillManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public EmployeeSkillManagerException(String string) {
    super(string);
  }

  public EmployeeSkillManagerException(Message message) {
    super(message);
  }

  public EmployeeSkillManagerException(List<Message> messageList) {
    super(messageList);
  }
}
