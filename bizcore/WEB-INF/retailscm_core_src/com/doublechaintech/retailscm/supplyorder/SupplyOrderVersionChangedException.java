
package com.doublechaintech.retailscm.supplyorder;
import com.doublechaintech.retailscm.EntityNotFoundException;

public class SupplyOrderVersionChangedException extends SupplyOrderManagerException {
	private static final long serialVersionUID = 1L;
	public SupplyOrderVersionChangedException(String string) {
		super(string);
	}


}


