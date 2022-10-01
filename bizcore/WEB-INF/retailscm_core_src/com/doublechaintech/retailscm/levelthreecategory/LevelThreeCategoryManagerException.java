package com.doublechaintech.retailscm.levelthreecategory;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class LevelThreeCategoryManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public LevelThreeCategoryManagerException(String string) {
    super(string);
  }

  public LevelThreeCategoryManagerException(Message message) {
    super(message);
  }

  public LevelThreeCategoryManagerException(List<Message> messageList) {
    super(messageList);
  }
}
