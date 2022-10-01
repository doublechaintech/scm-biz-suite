package com.doublechaintech.retailscm.leveltwodepartment;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class LevelTwoDepartmentManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public LevelTwoDepartmentManagerException(String string) {
    super(string);
  }

  public LevelTwoDepartmentManagerException(Message message) {
    super(message);
  }

  public LevelTwoDepartmentManagerException(List<Message> messageList) {
    super(messageList);
  }
}
