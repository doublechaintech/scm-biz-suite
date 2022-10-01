package com.doublechaintech.retailscm.goodsallocation;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class GoodsAllocationManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public GoodsAllocationManagerException(String string) {
    super(string);
  }

  public GoodsAllocationManagerException(Message message) {
    super(message);
  }

  public GoodsAllocationManagerException(List<Message> messageList) {
    super(messageList);
  }
}
