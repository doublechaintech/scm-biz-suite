package com.doublechaintech.retailscm.transporttasktrack;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class TransportTaskTrackManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public TransportTaskTrackManagerException(String string) {
    super(string);
  }

  public TransportTaskTrackManagerException(Message message) {
    super(message);
  }

  public TransportTaskTrackManagerException(List<Message> messageList) {
    super(messageList);
  }
}
