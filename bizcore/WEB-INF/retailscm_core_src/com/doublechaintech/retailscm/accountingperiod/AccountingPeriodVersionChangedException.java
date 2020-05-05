
package com.doublechaintech.retailscm.accountingperiod;
import com.doublechaintech.retailscm.EntityNotFoundException;

public class AccountingPeriodVersionChangedException extends AccountingPeriodManagerException {
	private static final long serialVersionUID = 1L;
	public AccountingPeriodVersionChangedException(String string) {
		super(string);
	}


}


