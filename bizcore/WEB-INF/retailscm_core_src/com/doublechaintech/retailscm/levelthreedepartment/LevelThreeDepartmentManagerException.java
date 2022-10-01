package com.doublechaintech.retailscm.levelthreedepartment;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class LevelThreeDepartmentManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public LevelThreeDepartmentManagerException(String string) {
    super(string);
  }

  public LevelThreeDepartmentManagerException(Message message) {
    super(message);
  }

  public LevelThreeDepartmentManagerException(List<Message> messageList) {
    super(messageList);
  }
}
