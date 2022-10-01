package com.doublechaintech.retailscm.transporttask;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class TransportTaskManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public TransportTaskManagerException(String string) {
    super(string);
  }

  public TransportTaskManagerException(Message message) {
    super(message);
  }

  public TransportTaskManagerException(List<Message> messageList) {
    super(messageList);
  }
}
