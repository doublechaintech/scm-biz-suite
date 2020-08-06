package com.doublechaintech.retailscm;


import java.io.Serializable;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.RemoteInitiable;
import com.terapico.uccaf.CafEntity;
import com.terapico.utils.TextUtil;

public class BaseEntity implements CafEntity, Serializable, RemoteInitiable{
	
	
	public String getPresentType(){
		String internalType = getInternalType();
		if(internalType.isEmpty()) {
			return "__missingType"; // should not happen
		}
		StringBuilder presentTypeBuffer = new StringBuilder()
				.append(internalType.substring(0, 1)
						.toLowerCase()).append(internalType.substring(1));
		return presentTypeBuffer.toString();
		
	}
	
	public Object[] toFlatArray(){
		return new Object[]{getId(), getVersion()};
	}
	
	private String internalType = null; // 禁止直接操作这个成员
	public static BaseEntity pretendToBe(String classShortName, String id) {
		BaseEntity result = new BaseEntity();
		result.internalType = classShortName;
		result.setId(id);
		result.setDisplayName(id);
		return result;
	}
	public  void ensureAccess(Map<String,Object> accessTokens) {
		
		List<SmartList<?>> allLists = this.getAllRelatedLists();
		if(allLists==null) {
			return;
		}
		if(allLists.isEmpty()) {
			return;
		}
		for(SmartList<?> list:allLists) {
			String listName = list.getListInternalName();
			if(accessTokens.get(listName)==null) {
				//no access granted
				list.clear();
				list.setAccessible(false);
				continue;
			}
			list.setAccessible(true);
		}
		
	}
	
	protected List<Action> filterActionList(){
		if(this.getActionList()==null) {
			return null;
		}
		List<Action> filteredActionList = this.getActionList()
				.stream()
				.filter(action->this.isOneOf(action.getActionGroup(), action.specialActionTypes()))
				.collect(Collectors.toList());
		
		return filteredActionList;
		
	}
	
	public List<KeyValuePair> keyValuePairOf(){
		
		List<KeyValuePair> result = new ArrayList<KeyValuePair>();
		this.appendKeyValuePair(result, "actionList", filterActionList() );
		this.appendKeyValuePair(result, "messageList", this.getErrorMessageList());
		return result;
	}
	
	protected void appendKeyValuePair(List<KeyValuePair> list, String key, Object value) {
		
		
		if(list==null) {
			throw new IllegalArgumentException("createKeyValuePair(List<KeyValuePair> list, String key, Object value): list could not be null");
		}
		if(key==null) {
			throw new IllegalArgumentException("createKeyValuePair(List<KeyValuePair> list, String key, Object value): key could not be null");
		}
		if(value==null) {
			return;
		}
		KeyValuePair pair = new KeyValuePair();
		pair.setKey(key);
		pair.setValue(value);
		list.add(pair);
		
	}
	
	public List<SmartList<?>> getAllRelatedLists() {
		//每个具体的类实现该方法
		return null;
	}
	public String getInternalType(){
		if (internalType != null){
			return internalType;
		}
		return this.getClass().getSimpleName();
	}
	boolean endsWithOneOf(String value, String candiates[]){
    	for(String candidate:candiates){
    		if(value.endsWith(candidate)){
    			return true;
    		}
    	}
    	return false;
    }
	boolean isOneOf(String value, String candiates[]){
	  for(String candidate:candiates){
		if(value.equals(candidate)){
			return true;
		}
	}
	return false;
   }
	
	public String maskChinaMobileNumber(String chinaMobileNumber){
	
		if(chinaMobileNumber == null){
			return null;
		}
		if(chinaMobileNumber.length()!=11){
			return chinaMobileNumber;//残缺的手机号，无需屏蔽
		}
		
		return chinaMobileNumber.substring(0,3)+"****"+chinaMobileNumber.substring(7);
    
	}

	private static final long serialVersionUID = 1L;
	protected		int                 	mVersion            ;
	protected		boolean					changed = false      ;
	protected		String 					id;
	
	
	private String displayName;
	
	
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public Object propertyOf(String propertyName) {
		
		String methodNames[]={"get", propertyName.substring(0,1).toUpperCase() ,propertyName.substring(1)};
		String methodName=String.join("", methodNames);
		Method method;
		try {
			method = this.getClass().getDeclaredMethod(methodName, new Class[]{});
			Object value = method.invoke(this, new Object[]{});
			return value;
		} catch (Exception e) {
			String args[]={"the property", propertyName ,"is not found for this object."};
			throw new IllegalArgumentException(String.join(" ",args));
		}
	}
	
	public void setPropertyOf(String propertyName, Object value) throws Exception{
        String methodName="set"+propertyName.substring(0,1).toUpperCase()+propertyName.substring(1);
        Method method = this.getClass().getMethod(methodName, new Class[]{value.getClass()});
        method.invoke(this, new Object[]{value});
    }
	protected String repeatExpr(String string, String delimit, int length) {
		if(length <= 0){
			return "";
		}
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0;i<length;i++){
			if(i>0){
				stringBuilder.append(delimit);
			}
			stringBuilder.append(string);
		}
		
		return stringBuilder.toString();
	}
	protected void checkFieldName(String field) {
		
		if(field.length()>50){
			String message = "The field name: "+ field +" length("+field.length()+") is more 50!";
			throw new IllegalArgumentException(message);
		}
		
		char [] fieldCharArray = field.toCharArray();
		for(char ch: fieldCharArray){
			if(isValidFieldChar(ch)){
				continue;
			}
			String message = "Found invalid char <"+ch+"> from the field name: "+ field;
			throw new IllegalArgumentException(message);
		}
		
		
	}
	protected String mapToInternalColumn(String field){
		char [] fieldArray = field.toCharArray();
		StringBuilder internalFieldBuffer = new StringBuilder();
		
		for(char ch:fieldArray){
			if(Character.isUpperCase(ch)){
				internalFieldBuffer.append('_');
				char lowerCaseChar = Character.toLowerCase(ch);
				internalFieldBuffer.append(lowerCaseChar);
				continue;
			}
			internalFieldBuffer.append(ch);
		}
		return internalFieldBuffer.toString();
	}
	
	
	protected boolean isValidFieldChar(char fieldChar){
		
		//Character.isAlphabetic(codePoint);
		if(fieldChar>='0' && fieldChar <='9'){
			return true;
		}
		if(fieldChar>='A' && fieldChar <='Z'){
			return true;
		}
		if(fieldChar>='a' && fieldChar <='z'){
			return true;
		}
		if(fieldChar == '_'){
			return true;
		}
		
		return false;
		
		
		
	}
	
	protected boolean emptyString(String value){
		if(value == null){
			return true;
		}
		if(value.isEmpty()){
			return true;
		}
		return false;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void incVersion(){
		setVersion(nextVersion());

	}
	public int nextVersion(){
		int version = getVersion();
		if(version==Integer.MAX_VALUE){
			return 1;//希望有系统能用到这个分支，也就是这条记录更新了20多亿次，客户的生意一定很好
		}
		return version+1;
	}
	protected String joinWithDelimitter(String delimitter,Object ...objs ){
		StringBuilder internalPresentBuffer = new StringBuilder();
		
		int index = 0;
		for(Object o:objs){
			
			if(shouldAppendDelimitter(index,delimitter)){
				internalPresentBuffer.append(delimitter);
			}
			internalPresentBuffer.append(o);
			index++;
			
		}
		
		
		return internalPresentBuffer.toString();
	}
	protected String join(Object ...objs ){
		StringBuilder internalPresentBuffer = new StringBuilder();

		for(Object o:objs){
			if(o == null){
				continue;
			}
			internalPresentBuffer.append(o);
		}
		
		
		return internalPresentBuffer.toString();
	}
	protected boolean shouldAppendDelimitter(int index, String delimitter){
		if(index < 1 ){
			return false;
		}
		if(delimitter == null){
			return false;
		}
		if(delimitter.isEmpty()){
			return false;
		}
		return true;
		
	}
	public List<Message> getErrorMessageList() {
		
		if(errorMessageList ==  null){
			return new ArrayList<Message>();
		}
		
		return errorMessageList;
	}
	public void setErrorMessageList(List<Message> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}
	@Override
	public boolean equals(Object object){
		if(object == null){
			return false;
		}
		
		if(!(object instanceof BaseEntity)){
			return false;
		}
		BaseEntity targetObject = (BaseEntity)object;
		String targetId = targetObject.getId();
		if(targetId == null){
			return false;
		}
		
		if(!(targetId.equals(this.getId()))){
			return false;
		}
		/* comment this for tempory usage for cis
		int targetVersion = targetObject.getVersion();
		
		if(targetVersion != this.getVersion()){
			return false;
		}*/
		
		//is exactly the same class?
		if(object.getClass() == this.getClass()){
			return true;
		}
		//If the class is not exactly the same, but they may initiated from different class loader
		
		
		String targetClassName = object.getClass().getCanonicalName();
		String thisClassName = this.getClass().getCanonicalName();
		
		if(targetClassName.equals(thisClassName)){
			return true;
		}		
		
		return false;
		
	}
	protected  Map<String,List<BaseEntity>> flexibleLists;
	protected<T> void ensureFlexibleLists(){
		if(flexibleLists ==  null){
			flexibleLists = new HashMap<String,List<BaseEntity>>();
		}
	}
	protected List<BaseEntity> ensureFlexibleList(String key){
		
		List<BaseEntity> list = (List<BaseEntity>) flexibleLists.get(key);
		if(list ==  null){
			list = new ArrayList<BaseEntity>();
			flexibleLists.put(key,list);
		}
		return list;
		
	}
	public void  addItemToFlexibleList(String key, BaseEntity item){
		ensureFlexibleLists();
		List<BaseEntity> list = ensureFlexibleList(key);
		list.add(item);
		
		
	}
	
	protected Map<String,Object> valueMap;
	protected<T> void ensureValueMap(){
		if(valueMap ==  null){
			valueMap = new HashMap<String,Object>();
		}
	}
	public Map<String, Object> getValueMap() {
		return valueMap;
	}
	public void setValueMap(Map<String, Object> valueMap) {
		this.valueMap = valueMap;
	}
	public <T> void  addItemToValueMap(String key, T item){
		ensureValueMap();
		valueMap.put(key, item);
	}
	
	public Object  valueByKey(String key){
		if(valueMap == null){
			return null;
		}
		
		return valueMap.get(key);
	}
	protected String getListSizeKey(String targetName){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(targetName);
		stringBuilder.append("ListSize");
		return stringBuilder.toString();
	}
	public Integer  listSizeOf(String targetName){

		return (Integer)valueMap.get(getListSizeKey(targetName));
	}
	public void addListSize(String targetName, int value){
	
		addItemToValueMap(getListSizeKey(targetName), value);
		
	}
	
	public void  addItemToFlexibleList(String key, List<BaseEntity> entityList){
		ensureFlexibleLists();
		List<BaseEntity> list = ensureFlexibleList(key);
		list.addAll(entityList);
		
		
	}
	
	public void  addPagesToFlexibleList(String object, List<BaseEntity> entityList){
		ensureFlexibleLists();
		List<BaseEntity> list = ensureFlexibleList(object+"ListPagination");
		list.addAll(entityList);
		
		
	}
	
	public List<BaseEntity>   flexibleListOf(String key){
		
		if(flexibleLists == null){
			return null;
		}

		List<BaseEntity> list = (List<BaseEntity>) flexibleLists.get(key);
		return list;
		
		
	}
	
	protected  Map<String,BaseEntity> flexibleObjects;
	protected void ensureFlexibleObjects(){
		if(flexibleObjects ==  null){
			flexibleObjects = new HashMap<String,BaseEntity>();
		}
	}
	public void addItemToFlexiableObject(String key, BaseEntity item){
		ensureFlexibleObjects();		
		flexibleObjects.put(key, item);
		
	}
	public Map<String,BaseEntity> getFlexiableObjects(){
		return flexibleObjects;
	}
	/*
	 * Functional for this list:
	 * 
	 * Removed items Once an item marked as delete, then the item will move to this list before delete
	 * 
	 * there may be more items types need to remove
	 * 
	 * 
	 * */
	protected List<Message> errorMessageList;
	protected void ensureErrorMessageList(){
		if(errorMessageList ==  null){
			errorMessageList = new ArrayList<Message>();
		}
	}
	public void addErrorMessage(Message message){
		ensureErrorMessageList();
		errorMessageList.add(message);
		
	}
	
	protected List<Action> actionList;
	
	protected void ensureActionList(){
		if(actionList ==  null){
			actionList = new ArrayList<Action>();
		}
	}
	public void addAction(Action action){
		ensureActionList();
		actionList.add(action);
		
	}
	
	
	public List<Action> getActionList() {
		return actionList;
	}
	
	public void addActions(List<Action> actions){
		ensureActionList();
		actionList.addAll(actions);
	}
	
	protected void onChangeProperty(String property, Object oldValue, Object newValue){
		changed = true;
		return;
	}
	public boolean isChanged(){
		if(this.getVersion()==0){
			return true;
		}
		return changed;
	}
	public void setVersion(int version){
		this.mVersion = version;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	protected Double parseDouble(String doubleExpr) {
		//support for money types
		char firstChar = doubleExpr.charAt(0);
		
		if(Character.isDigit(firstChar)){

			return Double.parseDouble(doubleExpr);
		}
		
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.SIMPLIFIED_CHINESE);
		try {
			return format.parse(doubleExpr).doubleValue();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new NumberFormatException("The value: "+ doubleExpr +" is not for a number");
		}
		
		
		//return Double.parseDouble(doubleExpr.substring(1));
		
		
	}
	
	protected BigDecimal parseBigDecimal(String bigDecimalExpr) {

		
		if(bigDecimalExpr==null){
			throw new NumberFormatException("The value: "+ bigDecimalExpr +" is null, not for a number");
		}
		if(bigDecimalExpr.isEmpty()){
			throw new NumberFormatException("The value: "+ bigDecimalExpr +" is empty, not for a number");
		}
		try {
			char firstChar = bigDecimalExpr.charAt(0);

			if (Character.isDigit(firstChar)) {

				return new BigDecimal(bigDecimalExpr);
			}
			return new BigDecimal(bigDecimalExpr.substring(1));
		} catch (Exception e) {
			throw new NumberFormatException(
					"The value: " + bigDecimalExpr + " is not a number");
		}
	}
	
	
	
	protected Double parseDouble(String doubleExpr, int precision){		
		return Double.parseDouble(doubleExpr);
	}
	
	protected Float parseFloat(String floatExpr){		
		return Float.parseFloat(floatExpr);
	}
	protected Integer parseInt(String intExpr){		
		return Integer.parseInt(intExpr);
	}
	protected Long parseLong(String longExpr){		
		return Long.parseLong(longExpr);
	}
	protected Boolean parseBoolean(String booleanExpr){		
		return Boolean.parseBoolean(booleanExpr);
	}
	protected Date parseTime(String timeExpr){		
		String defaultFormat = "HH:mm:ss";
		DateFormat formatter = new SimpleDateFormat(defaultFormat);
		try {
			return formatter.parse(timeExpr);
		} catch (ParseException e) {
			throw new IllegalArgumentException("The value '"+timeExpr+"' could not be parsed to a Time.");
		}
	}
	protected Date parseDate(String dateExpr){
		String defaultFormat = "yyyy-MM-dd";
		DateFormat formatter = new SimpleDateFormat(defaultFormat);
		try {
			return formatter.parse(dateExpr);
		} catch (ParseException e) {
			throw new IllegalArgumentException("The value '"+dateExpr+"' could not be parsed to a Date.");
		}
	}

	protected String parseString(String stringExpr){		
		return stringExpr;
	}
	protected Images parseImages(String stringExpr){		
		return Images.fromString(stringExpr);
	}
	
	protected boolean equalsInt(int a, int b){
		return a==b;
	}
	protected boolean equalsLong(long a, long b){
		return a==b;
	}
	protected boolean equalsDouble(double a, double b){
		return Math.abs(a-b)<0.00001;
	}
	protected boolean equalsFloat(float a, float b){
		return Math.abs(a-b)<0.00001;
	}
	
	protected boolean equalsBigDecimal(BigDecimal a, BigDecimal b){
		return a.equals(b);
	}
	
	protected boolean equalsObject(Object a, Object b){
		if(a==b){
			return true;//they can be both null, or exact the same object, this is much faster than equals function
		}
		if(a==null){
			return false;//a is null, b must not be null
		}
		if(b==null){
			return false;//b is null, b must not be null
		}
		if(a.equals(b)){
			return true;//both of them are not null, then safely compare the value
		}
		return false;
		
	}
	protected boolean equalsString(String a, String b){
		return equalsObject(a,b);
	}
	protected boolean equalsTime(Date a, Date b){
		return equalsObject(a,b);
	}
	protected boolean equalsDate(Date a, Date b){
		return equalsObject(a,b);
	}
	protected boolean equalsBoolean(boolean a, boolean b){
		return a==b;
	}
	protected void addErrorMessageInternal(String messageKey, Object prameters[]){
		ensureErrorMessageList();
		Message erroMessage = createErrorMessage(messageKey, prameters);
		errorMessageList.add(erroMessage);
	}
	//This method will be called from external classes.
	public void addErrorMessage(String messageKey, Object prarameters[]){
		if(messageKey == null){	
			//this must a code issue
			throw new IllegalArgumentException("wrapErrorMessage(String key,Object[] parameters): key is null, this is not epected");
		}
		if(prarameters == null){
			//this must a code issue
			addErrorMessageInternal(messageKey,prarameters);
			return;
			//throw new IllegalArgumentException("wrapErrorMessage(String key,Object[] parameters): parameters is null, this is not epected");			
		}
		addErrorMessageInternal(messageKey,prarameters);
		
	}
	protected Message createErrorMessage(String key, Object[] parameters){
		Message message = new Message();
		message.setSourcePosition(key);
		message.setParameters(parameters);
		
		return message;
	}
	protected boolean wrapErrorMessage(String key){
		return  wrapErrorMessage( key, null);
	}
	protected boolean wrapErrorMessage(String key,Object[] parameters){
		if(key == null){	
			//this must a code issue
			throw new IllegalArgumentException("wrapErrorMessage(String key,Object[] parameters): key is null, this is not epected");
		}
		if(parameters == null){
			//this must a code issue
			addErrorMessageInternal(key,parameters);
			//throw new IllegalArgumentException("wrapErrorMessage(String key,Object[] parameters): parameters is null, this is not epected");
			return false;
		}
		int index = 0;
		for(Object object: parameters){
			//this must a code issue
			if(object == null){
				throw new IllegalArgumentException("wrapErrorMessage(String key,Object[] parameters): parameters["+index+"] is null, this is not epected");
			}
			index++;
		}
		addErrorMessageInternal(key,parameters);
		return false;

	}
	private static final String ID_NOT_ALLOWED_TO_BE_NULL_WHEN_VERSION_GREAT_THAN_ZERO = "ID_NOT_ALLOWED_TO_BE_NULL_WHEN_VERSION_GREAT_THAN_ZERO";
	private static final String ID_NOT_ALLOWED_TO_BE_EMPTY_WHEN_VERSION_GREAT_THAN_ZERO = "ID_NOT_ALLOWED_TO_BE_EMPTY_WHEN_VERSION_GREAT_THAN_ZERO";
	private static final String VERSION_NOT_ALLOWED_TO_BE_LESS_THAN_ZERO_ANY_TIME = "VERSION_NOT_ALLOWED_TO_LESS_THAN_ZERO_ANY_TIME";
	public static final String COPIED_CHILD = "__copied_chiled";
	
	public boolean validate(){
		if(getVersion()>0){
			//when the version great than 0, it means an existing object.
			if(null == getId()){				
				return wrapErrorMessage(ID_NOT_ALLOWED_TO_BE_NULL_WHEN_VERSION_GREAT_THAN_ZERO);
			}
			String trimedId = getId().trim();
			if(trimedId.isEmpty()){
				return wrapErrorMessage(ID_NOT_ALLOWED_TO_BE_EMPTY_WHEN_VERSION_GREAT_THAN_ZERO);
			}
		}
		if(getVersion()<0){
			
			return wrapErrorMessage(VERSION_NOT_ALLOWED_TO_BE_LESS_THAN_ZERO_ANY_TIME, new Object[]{ getVersion()});
		}
		return true;
	}
	protected String trimString(String string){
		if(string == null){
			return null;
		}
		return string.trim();
		
	}
	protected static String encodeUrl(String string){
		return TextUtil.encodeUrl(string);
	}
	//使用SALT的目的是为了防止在数据库泄露的情况下，黑客对其进行碰撞攻击，黑客的碰撞攻击
	//就是通过密码词典，进行hash，然后查看库中是否有匹配的字串，发现有，则密码攻破
	//弱的密码就无法逃脱
	//加入SALT之后，可以大大增加hash攻击的难度，因为增加了一个维度。
	protected String hashStringWithSHA256(String valueToHash) {
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			String textToHash = new StringBuilder(valueToHash).append(":").append(getSalt()).toString();
			byte[] hash = digest.digest(textToHash.getBytes(StandardCharsets.UTF_8));
			StringBuilder stringBuilder = new StringBuilder();
		    for (byte b : hash) {
		        stringBuilder.append(String.format("%02X", b));
		    }
		    return stringBuilder.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException(e);
		}
		
	}
	protected String getSalt(){
		return this.getId();
	}
	protected boolean equalsTimestamp(Date oldValue, Date newValue) {
		
		return equalsDate(oldValue,newValue);
	}

	protected DateTime parseTimestamp(String timeStampExpr) {
		String defaultFormat = "yyyy-MM-dd'T'hh:mm";
		DateFormat formatter = new SimpleDateFormat(defaultFormat);
		try {
			return DateTime.fromDate(formatter.parse(timeStampExpr));
		} catch (ParseException e) {
			throw new IllegalArgumentException("The value '"+timeStampExpr+"' could not be parsed to a TimeStamp.");
		}
		
	}
	
	public BaseEntity copyTo(BaseEntity dest) {
		if(this.getActionList()==null){
			return dest;
		}
		if(this.getActionList().isEmpty()){
			return dest;
		}
		
		dest.addActions(this.getActionList());
        dest.setDisplayName(this.getDisplayName());
		return dest;
	}
	
	protected void addToEntityList(BaseEntity owner,List<BaseEntity> entityList, BaseEntity baseEntity, String internalType) {
		if(baseEntity==null){
			return;
		}
		if(baseEntity.getId()==null){
			return;
		}
		if(entityList==null){
			throw new IllegalArgumentException("addToEntityList(List<BaseEntity> entityList, BaseEntity baseEntity): entityList should not be null ");
		}
		if(owner==baseEntity){
			return;//ignore owner object
		}
		if(internalType==null){
			entityList.add(baseEntity);
			return;
		}
		//internal type is not null, then must match
		if(internalType.equals(baseEntity.getInternalType())){
			entityList.add(baseEntity);
			return;
		}
		//nothing happeng
		
		
	}
	@SuppressWarnings("unchecked")
	public <T  extends BaseEntity> List<T> collectRefsWithType(String internalType){
		List<T> entityList = new ArrayList<T>();
		List<BaseEntity>  resultList = collectRefercencesFromLists(internalType);
		for(BaseEntity baseEntity: resultList) {
			entityList.add((T)baseEntity);
			
			
		}
		return entityList;
	}	
	
	protected void collectFromList(BaseEntity owner, List<BaseEntity> entityList,
			SmartList<? extends BaseEntity> targetEntityList, String internalType) {
		
		if(targetEntityList==null){
			return;
		}
		if(targetEntityList.isEmpty()){
			return;
		}
		for(BaseEntity target: targetEntityList){
			if(target==null){
				continue;
			}

			
			target.collectRefercences(owner, entityList,internalType);
			
		}
		
		
	}
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		return new ArrayList<BaseEntity>();
	}
	public List<BaseEntity>  collectRefercencesFromLists(){
		return collectRefercencesFromLists(null);
	}
	protected void collectRefercences(BaseEntity owner, List<BaseEntity> entityList){
		collectRefercences(owner, entityList, null);
	}
	protected void collectRefercences(BaseEntity owner, List<BaseEntity> entityList,String internalType){

	}
	public  void clearFromAll(){}
	protected void checkGroupKey(String groupKey) {
		if(groupKey.length()>50){
			String message = "The field name: "+ groupKey +" length("+groupKey.length()+") is more 50!";
			throw new IllegalArgumentException(message);
		}
		
		char [] fieldCharArray = groupKey.toCharArray();
		for(char ch: fieldCharArray){
			if(isGroupKeyChar(ch)){
				continue;
			}
			String message = "Found invalid char <"+ch+"> from the field name: "+ groupKey;
			throw new IllegalArgumentException(message);
		}
		
		
	}
	protected boolean isGroupKeyChar(char fieldChar) {
		if(fieldChar=='('||fieldChar==')'||fieldChar==',') {
			return true;
		}
		return this.isValidFieldChar(fieldChar);
	}
}




















