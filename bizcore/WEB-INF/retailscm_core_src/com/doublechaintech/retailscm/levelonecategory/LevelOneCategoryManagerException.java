package com.doublechaintech.retailscm.levelonecategory;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class LevelOneCategoryManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public LevelOneCategoryManagerException(String string) {
    super(string);
  }

  public LevelOneCategoryManagerException(Message message) {
    super(message);
  }

  public LevelOneCategoryManagerException(List<Message> messageList) {
    super(messageList);
  }
}
