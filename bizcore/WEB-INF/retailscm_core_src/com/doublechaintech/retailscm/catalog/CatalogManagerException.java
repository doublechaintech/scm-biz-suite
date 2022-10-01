package com.doublechaintech.retailscm.catalog;
// import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class CatalogManagerException extends RetailscmException {
  private static final long serialVersionUID = 1L;

  public CatalogManagerException(String string) {
    super(string);
  }

  public CatalogManagerException(Message message) {
    super(message);
  }

  public CatalogManagerException(List<Message> messageList) {
    super(messageList);
  }
}
