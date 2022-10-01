package com.doublechaintech.retailscm.companytraining;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class CompanyTrainingManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public CompanyTrainingManagerException(String string) {
    super(string);
  }

  public CompanyTrainingManagerException(Message message) {
    super(message);
  }

  public CompanyTrainingManagerException(List<Message> messageList) {
    super(messageList);
  }
}
