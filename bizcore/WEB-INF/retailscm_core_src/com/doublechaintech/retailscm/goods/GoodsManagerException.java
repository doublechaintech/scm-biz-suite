package com.doublechaintech.retailscm.goods;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class GoodsManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public GoodsManagerException(String string) {
    super(string);
  }

  public GoodsManagerException(Message message) {
    super(message);
  }

  public GoodsManagerException(List<Message> messageList) {
    super(messageList);
  }
}
