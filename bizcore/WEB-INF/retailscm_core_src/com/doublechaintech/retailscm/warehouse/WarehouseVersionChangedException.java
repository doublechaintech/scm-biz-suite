
package com.doublechaintech.retailscm.warehouse;
import com.doublechaintech.retailscm.EntityNotFoundException;

public class WarehouseVersionChangedException extends WarehouseManagerException {
	private static final long serialVersionUID = 1L;
	public WarehouseVersionChangedException(String string) {
		super(string);
	}


}


