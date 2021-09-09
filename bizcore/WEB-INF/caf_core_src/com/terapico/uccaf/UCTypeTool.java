package com.terapico.uccaf;

import java.lang.reflect.Type;

public class UCTypeTool {
	public static boolean isBaseUCType(Type type){
		Class<?> typeOfClass = (Class<?>)type;
		if(BaseUserContext.class.isAssignableFrom(typeOfClass)){
			return true;
		}
		return false;
	}
}
