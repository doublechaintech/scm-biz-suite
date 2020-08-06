
package com.doublechaintech.retailscm.publickeytype;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class PublicKeyTypeGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for PublicKeyType", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(PublicKeyType.KEYPAIR_IDENTITY_LIST.equals(listName)){
			return new String[]{"id","public_key","key_type","sec_user","create_time","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(PublicKeyType.KEYPAIR_IDENTITY_LIST.equals(listName)){
			return "keypair_identity";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}












