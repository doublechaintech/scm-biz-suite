
package com.doublechaintech.retailscm.accountset;
import com.doublechaintech.retailscm.EntityNotFoundException;

public class AccountSetVersionChangedException extends AccountSetManagerException {
	private static final long serialVersionUID = 1L;
	public AccountSetVersionChangedException(String string) {
		super(string);
	}


}


