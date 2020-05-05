package com.terapico.caf;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@SuppressWarnings("rawtypes")
public class ReflectionTool {
	protected Object[] getParameters(Type[] types, Object[] parameters) {

		int length = parameters.length;
		if (length == 0) {
			return new Object[] {};
		}
		Object[] ret = new Object[length];

		for (int i = 0; i < length; i++) {
			ret[i] = convertExprToObject(types[i], parameters[i]);
			// System.out.println(ret[i].getClass() + "" + ret[i]);
		}
		return ret;
	}
	
	
	public static void appendBytes(StringBuilder stringBuilder, byte[] parameter, int maxToShow) {
		
		byte []objects = parameter;
		stringBuilder.append("[");
		for(int i=0;i<objects.length;i++){
			if(i>0){
				stringBuilder.append(" ");
			}
			byte object = objects[i];
			stringBuilder.append(String.format("%02X", object));
			if((i+1)>maxToShow) {//only print 31 bytes
				stringBuilder.append(" ... ");
				stringBuilder.append(objects.length);
				stringBuilder.append(" bytes...");
				break;
			}
		}
		stringBuilder.append("]");
		
		
	}
	
	

	protected static boolean isArrayType(Type type) {
		
		
		Class typeClazz = (Class) type;
		if (typeClazz.isArray()) {
			return true;
		}
		return false;
	}

	protected boolean isArrayOfPrimaryType(Type type) {
		Class typeClazz = (Class) type;
		if (!typeClazz.isArray()) {
			return false;
		}
		Class clazz = typeClazz.getComponentType();
		if (isPrimaryType(clazz)) {
			return true;
		}
		return false;
	}
	public static boolean hasRemoteInitiableInterface(Type parameterType) {
		
		return RemoteInitiable.class.isAssignableFrom((Class) parameterType);
		
	}
	
	private static ObjectMapper mapper ;
	static {
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
	}
	public static boolean isByteType(Type type) {
		Class clazz = (Class)type;
		if (clazz == byte.class) {
			return true;
		}
		return false;
	}
	protected static boolean isArrayOfBytesType(Type type) {
		Class typeClazz = (Class) type;
		if (!typeClazz.isArray()) {
			return false;
		}
		Class clazz = typeClazz.getComponentType();
		if (isByteType(clazz)) {
			return true;
		}
		return false;
	}
	public static boolean isFirstParameterByteArray(Type[] types) {
		int length = types.length;
		
		if(length == 0) {
			throw new IllegalArgumentException("Only one type allowed here, but the length of the length is: "+length);
			
		}
		Type firstParameterType = types[0];
		return isArrayOfBytesType(firstParameterType);

	}
	public static Object convertOnlyOneParameter(Type[] types, String value) {
		int length = types.length;
		
		if(length == 0) {
			throw new IllegalArgumentException("Only one type allowed here, but the length of the length is: "+length);
			
		}
		Type firstParameterType = types[0]; //it is safe here, there is ONE param when code runs to here
		
		//String type supported
		if(firstParameterType == java.lang.String.class) {
			return value;
		}
		
		
		
		//otherwise this should be a json object with a class
		if(!hasRemoteInitiableInterface(firstParameterType)) {
			throw new IllegalArgumentException("The type should implement a RemoteInitiable interface, but the class is: " + firstParameterType.getTypeName());
		}
		//parse to a json object and return
		
		 
		
		try {
			Object responseObj = mapper.copy().readValue(value, (Class)firstParameterType);
			return responseObj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 

	}
	
	
	protected boolean isPrimaryTypeOrOneStringConstructor(Class clazz) {
		if(isPrimaryType(clazz)) {
			return true;
		}
		Constructor constructor = getOneStringConstructor(clazz);
		if(constructor != null) {
			return true;
		}
		return false;
		
	}
	
	
	protected Constructor getOneStringConstructor(Class clazz) {
		Constructor constructors[] = clazz.getDeclaredConstructors();

		for (int i = 0; i < constructors.length; i++) {
			Constructor constructor = constructors[i];
			Type[] types = constructor.getGenericParameterTypes();
			if (types.length != 1) {
				continue;
			}
			if (types[0] == java.lang.String.class) {
				return constructor;
			}
		}

		return null;

	}

	public static boolean isPrimaryType(Class clazz) {

		if (clazz.isPrimitive()) {
			return true;
		}
		if (clazz == String.class) {
			return true;
		}
		if (clazz == Number.class) {
			return true;
		}
		if (clazz == Byte.class) {
			return true;
		}
		// java.lang.Byte (implements java.lang.Comparable<T>)
		// java.lang.Double (implements java.lang.Comparable<T>)
		// java.lang.Float (implements java.lang.Comparable<T>)
		// java.lang.Integer (implements java.lang.Comparable<T>)
		// java.lang.Long (implements java.lang.Comparable<T>)
		// java.lang.Short (implements java.lang.Comparable<T>)
		if (clazz == Double.class) {
			return true;
		}
		if (clazz == Float.class) {
			return true;
		}
		if (clazz == Integer.class) {
			return true;
		}
		if (clazz == Long.class) {
			return true;
		}
		if (clazz == Short.class) {
			return true;
		}
		if (clazz == Boolean.class) {
			return true;
		}
		if (clazz == java.util.Date.class) {
			return true;
		}
		if (clazz == java.sql.Date.class) {
			return true;
		}
		if (clazz == DateTime.class) {
			return true;
		}
		if(clazz == BigDecimal.class){
			return true;
		}
		
		return false;

	}
	
	public java.util.Date parseDate(String dateExpr){
		
		String formats[] = {
				"yyyy-MM-dd'T'HH:mm:ss",
				"yyyy-MM-dd'T'HH:mm",				
				"yyyy-MM-dd HH:mm:ss",
				"yyyy-MM-dd HH:mm",				
				"yyyy-MM-dd",};
		
		for(String format:formats){
			SimpleDateFormat tf = new SimpleDateFormat(format);
			tf.setTimeZone(TimeZone.getTimeZone("Asia/Chongqing"));
			try {
				 return tf.parse(dateExpr);
			} catch (ParseException e) {

			}
		}
		return null;
	}
	
	public int parseInt(String expr){
		
		try{			
			return Integer.parseInt(expr);
		}catch(Exception e){
			String message =String.format("The expected string should be a number, but it is: '%s' ", expr) ;
			throw new IllegalArgumentException(message);
		}

	}
	
	public BigDecimal parseBigDecimal(String expr){
		
		try{			
			//return Integer.parseInt(expr);
			return new BigDecimal(expr);
		}catch(Exception e){
			String message =String.format("The expected string should be a number, but it is: '%s' ", expr) ;
			throw new IllegalArgumentException(message);
		}

	}
	
	public double parseDouble(String expr){
		
		try{
			return Double.parseDouble(expr);
		}catch(Exception e){
			String message =String.format("The expected string should be a number, but it is: '%s' ", expr) ;
			throw new IllegalArgumentException(message);
		}

	}
	public long parseLong(String expr){
		
		try{
			return Long.parseLong(expr);
		}catch(Exception e){
			String message =String.format("The expected string should be a number, but it is: '%s' ", expr) ;
			throw new IllegalArgumentException(message);
		}

	}
	public float parseFloat(String expr){
		
		try{
			return Float.parseFloat(expr);
		}catch(Exception e){
			String message =String.format("The expected string should be a number, but it is: '%s' ", expr) ;
			throw new IllegalArgumentException(message);
		}

	}
	public byte parseByte(String expr){
		
		try{
			return Byte.parseByte(expr);
		}catch(Exception e){
			String message =String.format("The expected string should be a byte, but it is: '%s' ", expr) ;
			throw new IllegalArgumentException(message);
		}

	}
	public boolean parseBoolean(String expr){
		
		try{
			return Boolean.parseBoolean(expr);
		}catch(Exception e){
			String message =String.format("The expected string should be a boolean value like true/false, but it is: '%s' ", expr) ;
			throw new IllegalArgumentException(message);
		}

	}
	

	
	@SuppressWarnings("unchecked")
	protected Object convertExprToObject(Type type, Object parameter) {

		if (type == String.class) {
			return parameter;
		}
		if (!(parameter instanceof String)) {
			return parameter;
			// this allow external service to initiate the object directly like
			// File in the context of Web Container
		}
		String stringParameter = parameter.toString();
		if (type == int.class || type == Integer.class) {
			return parseInt(stringParameter);
		}
		if (type == long.class || type == Long.class) {
			return parseLong(stringParameter);
		}
		if (type == float.class || type == Float.class) {
			return parseFloat(stringParameter);
		}
		if (type == double.class || type == Double.class) {
			return parseDouble(stringParameter);
		}

		if (type == byte.class || type == Byte.class) {
			return parseByte(stringParameter);
		}
		if (type == boolean.class || type == Boolean.class) {
			return parseBoolean(stringParameter);
		}
		if(type == BigDecimal.class){
			return this.parseBigDecimal(stringParameter);
		}
		// if the class has a default constructor and the only parameter is
		// String like URL
		

		if (DateTime.class.isAssignableFrom((Class) type)) {
	
			DateTime dateTime = new DateTime();
			java.util.Date date = parseDate(stringParameter);
			dateTime.setTime(date.getTime());
			return dateTime;
			
		}
		if (java.util.Date.class.isAssignableFrom((Class) type)) {

			return parseDate(stringParameter);
			
		}
		Constructor constructor = getOneStringConstructor((Class) type);
		if (constructor != null) {
			try {
				return constructor.newInstance(new Object[] { stringParameter });
			} catch (Exception exception) {
				System.out.println("error param value: "+ parameter);
				throw new IllegalArgumentException(exception);
			}
		}
		if (!isArrayType(type)) {
			// other component type
			// parse it as json
			/*
			Gson gson = new Gson();
			System.err.println("Trying to parse value "+ stringParameter+" for type "+ type);
			return gson.fromJson(stringParameter, (Class) type);*/
			throw new IllegalStateException("Not supporting parse object from a string cause of secure concerns for: "+stringParameter);
		}

		if (isArrayOfPrimaryType(type)) {
			String subParameters[] = stringParameter.split(";");
			int length = subParameters.length;
			Class typeClazz = (Class) type;
			Class componentClazz = typeClazz.getComponentType();
			Object object = Array.newInstance(componentClazz, length);
			for (int index = 0; index < length; index++) {
				Array.set(object, index, convertExprToObject(typeClazz.getComponentType(), subParameters[index]));
			}
			return object;
		}
		// any other should presents as json string, include objects, list of
		// objects.
		// List<Video> videos = gson.fromJson(json, new
		// TypeToken<List<Video>>(){}.getType());
		//Gson gson = new Gson();
		//FIXME; SECURITY ISSUERE, TYPE COULD NOT BE VERY THING!!!!!!
		//NEED A WHITE LIST HERE TO ENSURE THE CLASS IS SAFE TO INITIATE
		//return gson.fromJson(stringParameter, (Class) type);
		throw new IllegalArgumentException("Blocked the object parsing cause of security reason!");
	}


	
	protected Method findSingleMethod( Object targetObject, String methodName)
			throws InvocationException {

		if (isIgnoreMethod(methodName)) {
			throw new InvocationException("The method '" + methodName + "' is not allowed to be called");
		}
		Class clazz = targetObject.getClass();
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				return method;
			}
			// parameter count here is not compared, assume different
		}
		throw new InvocationException("The method '" + methodName + "' is not found in class: " + clazz.getName());

		
	}
	
	protected List<Method> getSafeMethods( Object targetObject) {

		
		
		
		Class clazz = targetObject.getClass();
		return getSafeMethodsFromClass( clazz);

	}

	protected List<Method> getSafeMethodsFromClass( Class clazz) {
		
		List<Method> methodList=new ArrayList<Method>();
		Method[] methods = clazz.getMethods();
		
		for (Method method : methods) {

			if (isIgnoreMethod(method.getName())) {
				continue;
			}
			if (methodList.contains(method)) {
				continue;
			}
			methodList.add(method);
		}
		return methodList;
	}
	protected Method[] getInternalList(Class clazz) {

		Method[] methods = clazz.getMethods();

		return methods;
	}

	final static String[] IGNORE_METHOS = { "equals", "getClass", "hashCode", "notify", "notifyAll", "toString",
			"wait" };

	protected static boolean isIgnoreMethod(String methodName) {

		int index = Arrays.binarySearch(IGNORE_METHOS, methodName);
		if (index < 0) {
			return false;
		}
		return true;

	}
	
	
	
}
