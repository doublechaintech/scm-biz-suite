
package com.doublechaintech.retailscm.stockcountissuetrack;
//import com.doublechaintech.retailscm.EntityNotFoundException;
import com.doublechaintech.retailscm.RetailscmException;
import com.doublechaintech.retailscm.Message;
import java.util.List;

public class StockCountIssueTrackManagerException extends RetailscmException {
	private static final long serialVersionUID = 1L;
	public StockCountIssueTrackManagerException(String string) {
		super(string);
	}
	public StockCountIssueTrackManagerException(Message message) {
		super(message);
	}
	public StockCountIssueTrackManagerException(List<Message> messageList) {
		super(messageList);
	}

}


