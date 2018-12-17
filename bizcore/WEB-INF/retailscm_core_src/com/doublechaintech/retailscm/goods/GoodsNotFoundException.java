
package com.doublechaintech.retailscm.goods;
import com.doublechaintech.retailscm.EntityNotFoundException;
public class GoodsNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public GoodsNotFoundException(String string) {
		super(string);
	}

}

