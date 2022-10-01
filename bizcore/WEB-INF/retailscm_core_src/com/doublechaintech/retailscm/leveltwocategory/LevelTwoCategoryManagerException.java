package com.doublechaintech.retailscm.leveltwocategory;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class LevelTwoCategoryManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public LevelTwoCategoryManagerException(String string) {
    super(string);
  }

  public LevelTwoCategoryManagerException(Message message) {
    super(message);
  }

  public LevelTwoCategoryManagerException(List<Message> messageList) {
    super(messageList);
  }
}
