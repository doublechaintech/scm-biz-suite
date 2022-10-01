package com.doublechaintech.retailscm.goodsmovement;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class GoodsMovementManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public GoodsMovementManagerException(String string) {
    super(string);
  }

  public GoodsMovementManagerException(Message message) {
    super(message);
  }

  public GoodsMovementManagerException(List<Message> messageList) {
    super(messageList);
  }
}
