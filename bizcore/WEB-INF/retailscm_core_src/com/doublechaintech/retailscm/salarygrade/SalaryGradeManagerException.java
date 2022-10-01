package com.doublechaintech.retailscm.salarygrade;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class SalaryGradeManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public SalaryGradeManagerException(String string) {
    super(string);
  }

  public SalaryGradeManagerException(Message message) {
    super(message);
  }

  public SalaryGradeManagerException(List<Message> messageList) {
    super(messageList);
  }
}
