package com.doublechaintech.retailscm.consumerorderpriceadjustment;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class ConsumerOrderPriceAdjustmentManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public ConsumerOrderPriceAdjustmentManagerException(String string) {
    super(string);
  }

  public ConsumerOrderPriceAdjustmentManagerException(Message message) {
    super(message);
  }

  public ConsumerOrderPriceAdjustmentManagerException(List<Message> messageList) {
    super(messageList);
  }
}
