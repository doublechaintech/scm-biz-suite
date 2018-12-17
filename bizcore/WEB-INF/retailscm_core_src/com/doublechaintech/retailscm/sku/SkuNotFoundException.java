
package com.doublechaintech.retailscm.sku;
import com.doublechaintech.retailscm.EntityNotFoundException;
public class SkuNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public SkuNotFoundException(String string) {
		super(string);
	}

}

