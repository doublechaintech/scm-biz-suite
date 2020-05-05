
package  com.doublechaintech.retailscm;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.io.IOException;
import java.util.HashMap;
import java.net.URLEncoder;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.skynet.infrastructure.GraphService;
import com.terapico.caf.baseelement.Event;
import com.terapico.caf.BlobObject;
import com.terapico.caf.xls.Block;
import com.skynet.infrastructure.EventService;
import com.skynet.infrastructure.graphservice.GraphServiceImpl;
import com.skynet.infrastructure.TokenTool;
import com.doublechaintech.retailscm.userapp.UserApp;

import com.doublechaintech.retailscm.listaccess.ListAccess;
import org.springframework.beans.factory.BeanNameAware;
import java.math.BigDecimal;

import com.terapico.uccaf.AccessControledService;
import com.terapico.uccaf.BaseUserContext;

public class BaseManagerImpl implements AccessControledService,BeanNameAware{

	
	protected		String 					beanName;
	
	
	public BaseGridViewGenerator gridViewGenerator() {
		throw new IllegalStateException("Sub class of BaseManagerImpl must override method gridViewGenerator()");
	}
	protected BlobObject exportListToExcel(UserContext userContext, BaseEntity targetObject, String listName) throws IOException {
		
		BaseGridViewGenerator generator = gridViewGenerator() ;
		List<Block> blocks= generator.allBlocks(targetObject, listName);
		fixBlocks(userContext,blocks);
		return generator.exportExcel("file",blocks);
		
	}
	protected void fixBlocks(UserContext userContext,List<Block> blocks) {
		BaseGridViewGenerator generator= gridViewGenerator();
		
		RetailscmUserContext dmosUserContext=(RetailscmUserContext)userContext;
		
		for(Block block: blocks) {
			if(generator.isHeaderBlock(block)) {
				block.setValue(dmosUserContext.getLocaleKey(block.getValue().toString()));
			}
			String pageName = dmosUserContext.getLocaleKey(block.getPage());
			block.setPage(pageName);
			
		}
	}
	
	
	
	
	//To enable the class to get the bean name, then all managers know who they are, 
	//so that the actions can be added with manager bean name
	protected UserApp currentApp(BaseUserContext baseUserContext){
		if(baseUserContext == null){
			throw new IllegalStateException("Not able to get a context from");
		}
		UserContext userContext = (UserContext)baseUserContext;
		
		String currentUserAppKey = this.getCurrentAppKey(userContext);
		
		Object localCachedUserApp = userContext.getFromContextLocalStorage(currentUserAppKey);
		
		if(localCachedUserApp!=null) {
			return (UserApp)localCachedUserApp;
		}
		Object remoteObject = userContext.getCachedObject(this.getCurrentAppKey(userContext), UserApp.class);
		userContext.putIntoContextLocalStorage(currentUserAppKey, remoteObject);
		return (UserApp) remoteObject;
		
	}
	public static String getSystemInternalName() {
		return "retailscm";
	}
	
	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	public String encodeURL(String urlToEncode){
		try{
			return URLEncoder.encode(urlToEncode,"UTF-8");
		}catch(Exception e){
			System.err.println("FATAL ERROR, SYSTEM IS NOT ABLE TO RUN CAUSE OF UNSUPPORTING FOR ENCODING UTF-8");
			return "SYSTEM IS NOT ABLE TO RUN CAUSE OF UNSUPPORTING FOR ENCODING UTF-8";
		}
	}
	public void ensureRelationInGraph(UserContext userContext, BaseEntity sourceEntity) {
	
		
		GraphService graphService = ((RetailscmUserContextImpl)userContext).getGraphService();
		if (graphService instanceof GraphServiceImpl) {
			((GraphServiceImpl) graphService).addNode(getSystemInternalName(), sourceEntity.getInternalType(), sourceEntity.getId());
			//List<BaseEntity> entityList = new SmartList<BaseEntity>();
			//sourceEntity.collectRefercences(sourceEntity, entityList);
			//for (BaseEntity entity : entityList) {
			//	((GraphServiceImpl) graphService).addEdge(getSystemInternalName(), sourceEntity.getInternalType() + "_" + entity.getInternalType(), sourceEntity.getInternalType(), entity.getInternalType(), sourceEntity.getId(), entity.getId());
			//}
		}
		
		
	}
	public void sendCreationEvent(UserContext userContext, BaseEntity sourceEntity) {
		EventService eventService = ((RetailscmUserContextImpl)userContext).getEventService();
		if(eventService == null){
			return;
		}
		Event event = new Event();
		event.setTarget(getSystemInternalName());
		event.setMessage(sourceEntity);
		eventService.sendEvent(event);
	}
	public void deleteRelationInGraph(UserContext userContext, BaseEntity sourceEntity) {
		
		GraphService graphService = ((RetailscmUserContextImpl)userContext).getGraphService();
		if (graphService instanceof GraphServiceImpl) {
			((GraphServiceImpl) graphService).deleteNode(getSystemInternalName(), sourceEntity.getInternalType(), sourceEntity.getId());
		}
		
	}
	public <T extends BaseEntity> void deleteRelationListInGraph(UserContext userContext, SmartList<T > entityList) {
		SmartList<T> toRemoveList = entityList.getToRemoveList();
		if (toRemoveList == null || toRemoveList.isEmpty()) {
			return;
		}
		for (BaseEntity baseEntity : toRemoveList) {
			deleteRelationInGraph (userContext, baseEntity);
		}
	}
	
	
	
	
	
	protected Object accessOK(){
		return null;
	}
	protected Object accessFail(String message){
		LoginForm form =  new LoginForm();
		form.addErrorMessage(message, null);
		return form;
	}
	public Object checkAccess(BaseUserContext baseUserContext,String methodName, Object[] parameters) throws IllegalAccessException{
		if(baseUserContext == null){
			return accessOK();
		}
		
		UserContext userContext = (UserContext)baseUserContext;
		logCall(userContext, methodName, parameters);
		
		
		//如果来自本地IP，则放开访问
		UserApp app = this.currentApp(baseUserContext);
		if(app == null){
			userContext.log("app is null!");
			return accessFail("没有选择App");
		}
		//userContext.log("trying to log all access list");
		//for(ObjectAccess oa:app.getObjectAccessList()){
		//	userContext.log(oa.toString());
		//}
		//userContext.log("/trying to log all access list");
		
		
		if(true){
			return accessOK();//暂时不适用graph来确定权限
		}
		String sourceType = app.getObjectType();//temp here
		String sourceId = app.getObjectId();//temp here
		
		
		
		String targetId = this.targetIdOf(methodName, parameters);
		String operation = this.operationTypeOf(methodName, parameters);		
		String targetObjectType = this.serviceFor();
		userContext.log("The user wants to do '"+operation+"' to "+targetObjectType+":"+targetId );
		String permission = app.getPermission();
		if(targetObjectType.equals(sourceType)){
			if(targetId.equals(sourceId)){
				//直接权限分配，直接检查操作类型是不是子集就好了
				if(hasDirectRight(permission,operation)){
					return accessOK();
				}
				
				return accessFail("你直接访问"+sourceType+"("+sourceId+") 失败，你不具有"+operation+"权限" );
				
			}
		}
		
		
		//userContext.relationBetween(sourceId, sourceType, targetType, targetId)
		List<String[]> relations = userContext.relationBetween( targetObjectType, targetId,sourceType, sourceId);

		logRelation(relations);

		if(hasIndirectRight(userContext, permission,operation, relations)){
			return accessOK();
		}
		String message = "你以持有对"+sourceType+"("+sourceId+")的 '"+permission+"' 权限被禁止以 '"+operation+"' 访问: "+targetObjectType+"("+targetId+")";
		try {
			userContext.sendEmail("philip_chang@163.com", "发现认证失败事件", message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accessFail(message );


	}
	public boolean hasDirectRight(String permission, String requiredPermission){
		String [] tokens = {permission,requiredPermission};
		return TokenTool.encodeTokens(tokens)>0;
		
	}
	protected boolean hasIndirectRight(UserContext userContext,String permission,String requiredPermission, List<String[]> relations){
		//String [] tokens = {permission,requiredPermission};
		if(relations.size() == 0){
			return false;
		}
		String [] tokens = {permission,requiredPermission.toUpperCase()};//only MXWR can extend to sub objects
		int simpleCheck = TokenTool.encodeTokens(tokens);
		if(simpleCheck<=0){
			return false;
		}
		
		
		int value = TokenTool.finalTokensOf(relations);
		
		return (simpleCheck&value) > 0;
		
	}
	
	
	protected void logRelation(List<String[]> relations){
		
		System.out.print("Relations: ");
		
		for(String []rels: relations){
			System.out.print("\tline: ");
			
			for(String r:rels){
				System.out.print(r + " ,");
			}
			System.out.println();
		}
		
	}
	
	//static String secondParameterHeaders[]={"load","update"};
	protected int indexOfTargetId(String methodName){
		
		if(methodName.startsWith("create")){
			return -1;
		}
		if(methodName.startsWith("deleteAll")){
			return -1;
		}
		return 1;
		
	}
	protected String targetIdOf(String methodName, Object[] parameters){
		//如果第一个是Context，那么通常第二个就是Id，结合方法名，可以找得比较准确
		//所有的public方法第一个参数都必须是UserContext，第二餐参数可能id或者没有就像deleteAll
		
		if(parameters.length == 0){
			return null;//什么都没有，无法判断权限
		}
		Object object = parameters[0];
		if(!(object instanceof BaseUserContext)){
			return null;//第一个不是，也无法判断权限，通常这样的方法不允许在manager方法出现
		}
		if(parameters.length == 1){
			//只有UC，没有其他参数
			return null;
		}
		
		//第一个是UC，而且至少有第二个参数，而且是String，而且方法的名字不是deleteAll和create，都应该是第二个
		int index = indexOfTargetId(methodName);
		if(index < 0){
			return null;//不存在targetId
		}
	
		if(index >= parameters.length){
			return null;//得到的Index超过范围，也不知道是怎么算的
		}

		Object secondParameter = parameters[index];
		
		if(secondParameter instanceof String){
			return (String)secondParameter;
		}

		return null;
		
	}
	
	static final String[] readMethodPrefixes = {"find","load","search","select","view"};
	//保持字母顺序，查找很快, 但是你得非常小心，如果排序没对，就惨了
	static final String[] writeMethodPrefixes = {"add","update"};//保持字母顺序，查找很快
	static final String[] managementMethodPrefixes = {"assign","delete"};//保持字母顺序，查找很快
	
	protected String operationTypeOf(String methodName, Object[] parameters){
		//每个方法都对应着唯一的操作类型
		
		String prefix = getMethodPrefix(methodName);
		
		int index = Arrays.binarySearch(readMethodPrefixes, prefix);
		if(index >= 0 ){
			return "r";
		}
		index = Arrays.binarySearch(writeMethodPrefixes, prefix);
		if(index >= 0 ){
			return "w";
		}
		index = Arrays.binarySearch(managementMethodPrefixes, prefix);
		if(index >= 0 ){
			return "m";
		}
		return "x";//执行的词汇非常多，默认是执行
		
	}
	//找到第一个大写字母或者结束，都算prefix
	protected String getMethodPrefix(String methodName) {
		
		
		char [] methodNameArray = methodName.toCharArray();
		for(int i=0;i<methodNameArray.length;i++){
			if(Character.isUpperCase(methodNameArray[i])){
				
				return methodName.substring(0,i);
				
			}
		}
	
		return methodName;
	}
	
	public  static void main(String []args) {
		BaseManagerImpl manager = new BaseManagerImpl();
		String value = manager.getMethodPrefix("loadPa");
		System.out.println(value);
		value = manager.getMethodPrefix("load");
		System.out.println(value);
		
		value = manager.operationTypeOf("load",new Object[]{});
		System.out.println(value);
		
		value = manager.operationTypeOf("delete",new Object[]{});
		System.out.println(value);
		
		value = manager.operationTypeOf("add",new Object[]{});
		System.out.println(value);
		value = manager.operationTypeOf("address",new Object[]{});
		System.out.println(value);
	}
	public String serviceFor(){
		return "BASE";
	}
	
	protected void logCall(UserContext userContext,String methodName, Object[] parameters){
		if(userContext == null){
			return;
		}
		
		
		userContext.log(callingLog(methodName,parameters));	
	}
	
	protected String callingLog(String methodName, Object[] parameters) {
		 StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(this.getClass().getSimpleName());
		stringBuilder.append(".");
		stringBuilder.append(methodName);
		stringBuilder.append("(");
		wrapParameters(stringBuilder,parameters);
		stringBuilder.append(")");
		return stringBuilder.toString();
	}
	protected String wrapValueIn(Object value) {
		if(value == null) {
			return "NULL";
		}

		if(value instanceof DateTime) {
			DateTime dateTimeValue = (DateTime)value;
			return this.join("'",timeExpr(dateTimeValue),"'");
		}
		if(value instanceof Date) {
			Date dateValue = (Date)value;
			return this.join("'",dateExpr(dateValue),"'");
		}
		if(value instanceof Number) {
			return value.toString();
		}
		if(value instanceof String) {
			String strValue = (String)value;
			String escapedValue =strValue.replace("\'", "''");
			return this.join("'",escapedValue,"'");
		}
		
		return this.join("'",value,"'");

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
	protected String timeExpr(DateTime dateTimeValue){

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//It is not thread safe, how silly the JDK is!!!
		return simpleDateFormat.format(dateTimeValue);
	}
	protected String dateExpr(Date dateValue){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//It is not thread safe, how silly the JDK is!!!
		return simpleDateFormat.format(dateValue);
	}	
	protected String timeExpr(){
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd'T'HH:mm:ss.SSS");
		//It is not thread safe, how silly the JDK is!!!
		return simpleDateFormat.format(new java.util.Date());
	}
	
	protected void wrapParameters(StringBuilder stringBuilder,Object[] parameters)
	{
		for(int i=1;i<parameters.length;i++){
			if(i>1){
				stringBuilder.append(", ");
			}
			wrapParameter(stringBuilder,parameters[i]);
		}
		
	}
	protected void wrapParameter(StringBuilder stringBuilder,Object parameter)
	{
		if(parameter==null){
			stringBuilder.append("<null>");
			return;
		}
		if(parameter instanceof String){
			wrapString(stringBuilder,parameter.toString());
			return;
		}
		//
		if(isArrayType(parameter.getClass())){
			Object []objects =(Object []) parameter;
			stringBuilder.append("[");
			for(int i=0;i<objects.length;i++){
				if(i>0){
					stringBuilder.append(", ");
				}
				Object object = objects[i];
				wrapParameter(stringBuilder,object);
			}
			stringBuilder.append("]");
			return;
		}
		
		stringBuilder.append(this.wrapValueIn(parameter));
	}
	
	protected boolean isArrayType(Type type) {
		
		
		Class<?> typeClazz = (Class<?>) type;
		if (typeClazz.isArray()) {
			return true;
		}
		return false;
	}
	
	protected void wrapString(StringBuilder stringBuilder,String parameter)
	{
		
		stringBuilder.append("\'");
		stringBuilder.append(parameter);
		stringBuilder.append("\'");
		
	}
	protected String getCacheKey(UserContext userContext, String prefix){
		return "retailscm:"+prefix+":"+userContext.tokenId();
	}
	protected String getUserKey(UserContext userContext){
		return "retailscm:user:"+userContext.tokenId();
	}
	protected String getCurrentAppKey(UserContext userContext){
		return getUserKey(userContext)+":currentApp";
	}
	protected Object invokeWithOneString(BaseUserContext baseUserContext, 
			String beanName, String methodName, 
			String classBaseName,String parameter) throws Exception{
		UserContext userContext = (UserContext)baseUserContext;
		Object target = userContext.getBean(beanName);
		Method  method =target.getClass().getMethod(methodName, (Class<?>[]) new Class<?>[]{RetailscmUserContext.class,String.class});
		UserContext targetUserContext =(UserContext)baseUserContext;// userContext.castTo(implClass);
		// Method main = c.getDeclaredMethod("main", argTypes);
		return method.invoke(target, targetUserContext, parameter);
		
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
	protected Double parseDouble(String doubleExpr, int precision){		
		return Double.parseDouble(doubleExpr);
	}
	
	protected Float parseFloat(String floatExpr){		
		return Float.parseFloat(floatExpr);
	}
	protected Integer parseInt(String intExpr){		
		return Integer.parseInt(intExpr);
	}
	protected Boolean parseBoolean(String booleanExpr){		
		return Boolean.parseBoolean(booleanExpr);
	}
	//protected Double parseTime(String timeExpr){		
	//	return Double.parseDouble(timeExpr);
	//}
	protected Date parseTime(String dateExpr){
		String defaultFormat = "HH:mm:ss";
		DateFormat formatter = new SimpleDateFormat(defaultFormat);
		try {
			return formatter.parse(dateExpr);
		} catch (ParseException e) {
			throw new IllegalArgumentException("The value '"+dateExpr+"' could not be parsed to a Time.");
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
	
	protected DateTime parseTimestamp(String timeStampExpr) {
		String defaultFormat = "yyyy-MM-dd'T'hh:mm";
		DateFormat formatter = new SimpleDateFormat(defaultFormat);
		try {
			return DateTime.fromDate(formatter.parse(timeStampExpr));
		} catch (ParseException e) {
			throw new IllegalArgumentException("The value '"+timeStampExpr+"' could not be parsed to a TimeStamp.");
		}
		
	}

	protected String parseString(String stringExpr){		
		return stringExpr;
	}
	protected Images parseImages(String stringExpr){		
		return Images.fromString(stringExpr);
	}
	protected boolean integerValueInClosedRange(int value, int min, int max){
		if(value < min){
			return false;
		}
		if(value > max){
			return false;
		}
		return true;
		
	}
	protected void packMessage(List<Message> messageList,String subject, String propertykey, Object[] parameters,String defaultMessage ){
		Message errorMsg = new Message();
		errorMsg.setLevel("warning");
		errorMsg.setSubject(subject);
 		errorMsg.setParameters(parameters);
 		errorMsg.setBody(defaultMessage);
 		errorMsg.setPropertyKey(propertykey);
 		messageList.add(errorMsg);
		return;
	}
	protected void checkLongtext(String value, int minLength, int maxLength,
			String propertyKey, List<Message> messageList) {
		checkStringLengthRange(value, minLength, maxLength, propertyKey, messageList);
	}
	protected void checkStringLengthRange(String value, int minLength, int maxLength,
			String propertyKey, List<Message> messageList) {
	
		if(value == null){
			if(minLength == 0 ){
				//如果最小长度为0，则改值允许为NULL
				return;
			}
			packMessage(messageList, "STRING_NOT_ALLOW_TO_BE_NULL",propertyKey,new Object[]{propertyKey, value, minLength, maxLength},
					"您输入的 '"+propertyKey+"' 的值'"+value+"'长度有误，该值最少"+minLength+"个字符.");
			return;
		}
		
		if(integerValueInClosedRange(value.length(), minLength, maxLength)){
			return;
		}
		
		if(minLength == maxLength){
			//固定长度，
			
	 		//errorMsg.setBody("您输入的"+propertyKey+":'"+value+"'长度有误, 该值长度为 "+ value.length()+", 系统预期是固定长度为"+minLength + "之间的文本");
			packMessage(messageList, "STRING_NOT_FIXED_LENGTH",propertyKey,new Object[]{propertyKey, value, minLength, maxLength, value.length()},
					"您输入的 '"+propertyKey+"' 的值'"+value+"'长度不对, 该值长度为 "+ value.length()+", 系统预期是固定长度为 "+minLength + " 文本.");
	 		return;
		}
		if(value.length()>maxLength){
			packMessage(messageList, "STRING_TOO_LONG",propertyKey,new Object[]{propertyKey, value, minLength, maxLength, value.length()},
					"您输入的 '"+propertyKey+"' 的值'"+value+"'长度太长, 该值长度为 "+ value.length()+", 系统预期最多 "+maxLength+" 个字符.");
	 		return;
	 	}
		if(value.length()<minLength){
	 		
			packMessage(messageList, "STRING_TOO_SHORT",propertyKey,new Object[]{propertyKey, value, minLength, maxLength, value.length()},
					"您输入的 '"+propertyKey+"' 的值'"+value+"'长度太短, 该值长度为 "+ value.length()+", 系统预期是最短 "+minLength+" 个字符.");
	 		return;
	 	}
		
	} 		
	
	protected boolean prefixedWith(String value,String prefixes[]) {
		
		for(String prefix: prefixes) {
			
			if(value.startsWith(prefix)) {
				return true;
			}
			
		}
		return false;
		
	}
	
	protected String joinArray(String delimiter, Object []args){
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0;i<args.length;i++){
			if(i>0) stringBuilder.append(delimiter);
			stringBuilder.append(args[i]);
		}
		return stringBuilder.toString();
		
	}
	
	protected void checkChinaMobilePhone(String value, int minLength, int maxLength,
			String propertyKey, List<Message> messageList) {
		//checkStringLengthRange(value, 11, 11, propertyKey, messageList);
		//中国的手机号目前都只有11位,全部数字，并且是以13 15 17 18 开头
		
		if(value == null){
			if(minLength == 0 ){
				//如果最小长度为0，则改值允许为NULL
				return;
			}
			packMessage(messageList, "CHINA_MOBILE_NOT_ALLOW_TO_BE_NULL",propertyKey,new Object[]{propertyKey, value, minLength, maxLength},
					"您输入的 '"+propertyKey+"' 的值 '"+value+"' 长度有误，该值为11个数字的手机号.");
			return;
		}

		if(!integerValueInClosedRange(value.length(), 11, 11)){
			packMessage(messageList, "CHINA_MOBILE_NOT_FIXED_LENGTH",propertyKey,new Object[]{propertyKey, value, minLength, maxLength, value.length()},
					"您输入的 '"+propertyKey+"' 的值 '"+value+"' 长度不对, 该值长度为 "+ value.length()+", 系统预期是固定长度为 "+minLength + "，而且全部为数字的手机号.");
	 		
			return;
		}
		String prefixes[]= {"13","14","15","17","18","166","199"};
		
		
		
		if(!prefixedWith(value,prefixes)){
			String errorForPrefixes = this.joinArray("、", prefixes);
			packMessage(messageList, "CHINA_MOBILE_FORMAT_ISSUE",propertyKey,new Object[]{propertyKey, value, minLength, maxLength, value.length()},
					"您输入的 '"+propertyKey+"' 的值 '"+value+"' 格式错误, 开头应为"+errorForPrefixes+"而且全部为半角字符数字的手机号.");
	 		return;
		}
		char digits[]=value.toCharArray();
		for(char ch: digits){
			if(Character.isDigit(ch)){
				continue;	
			}
			packMessage(messageList, "CHINA_MOBILE_CONTAIN_INVALID_CHAR",propertyKey,new Object[]{propertyKey, value, minLength, maxLength,ch+""},
					"您输入的 '"+propertyKey+"' 的值 '"+value+"'包含非数字字符 '"+ch+"', 系统预期是全部为数字的手机号.");
	 		return;
		}
	}
	
	
	protected void checkDateTime(Date value, Date minDate,
			Date maxDate, String propertyKey,
			List<Message> messageList) {
		this.checkDateRange(value, minDate, maxDate, propertyKey, messageList);
		
	}
	protected void checkDateRange(Date value, Date minDate,
			Date maxDate, String propertyKey,List<Message> messageList) {
		if(value == null){
			
			packMessage(messageList, "DATE_NOT_ALLOWED_TO_BE_NULL",propertyKey,new Object[]{propertyKey, value, minDate, maxDate},
					"您输入的 '"+propertyKey+"' 为空，系统预期为一个日期.");
	 		return;
		}
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		if(minDate.after(value)){
			packMessage(messageList, "DATE_BEFORE_START",propertyKey,new Object[]{propertyKey, value, minDate, maxDate},
					"您输入的 '"+propertyKey+"' 在允许最早日期"+formatter.format(minDate) +"之前，请修正");
	 		
	 		return;
	 	}
		if(maxDate.before(value)){
			packMessage(messageList, "DATE_AFTER_END",propertyKey,new Object[]{propertyKey, value, minDate, maxDate},
					"您输入的 '"+propertyKey+"' 在允许最晚日期"+formatter.format(maxDate)+"之后，请修正");
	 		
	 		return;
	 	}
		
	}
	protected void checkTimeRange(Date value, Date minDate,
			Date maxDate, String propertyKey, List<Message> messageList) {
		if(value == null){
			
			packMessage(messageList, "DATE_NOT_ALLOWED_TO_BE_NULL",propertyKey,new Object[]{propertyKey, value, minDate, maxDate},
					"您输入的 '"+propertyKey+"' 为空，系统预期为一个时间.");
	 		return;
		}
		Format formatter = new SimpleDateFormat("HH:mm:ss");
		long valTime = value.getHours()*3600+value.getMinutes()*60+value.getSeconds();
		long minTime = minDate.getHours()*3600+minDate.getMinutes()*60+minDate.getSeconds();
		if(minTime>valTime){
			packMessage(messageList, "DATE_BEFORE_START",propertyKey,new Object[]{propertyKey, value, minDate, maxDate},
					"您输入的 '"+propertyKey+"' 在允许最早时间"+formatter.format(minDate) +"之前，请修正");
	 		
	 		return;
	 	}
		long maxTime = maxDate.getHours()*3600+maxDate.getMinutes()*60+maxDate.getSeconds();
		if(maxTime<valTime){
			packMessage(messageList, "DATE_AFTER_END",propertyKey,new Object[]{propertyKey, value, minDate, maxDate},
					"您输入的 '"+propertyKey+"' 在允许最晚时间"+formatter.format(maxDate)+"之后，请修正");
	 		
	 		return;
	 	}
		
	}
		
	protected void checkDatePast(Date value, Date minDate, Date maxDate,
		String propertyKey, List<Message> messageList) {
		if(value == null){
			
			packMessage(messageList, "DATE_NOT_ALLOWED_TO_BE_NULL",propertyKey,new Object[]{propertyKey, value, minDate, maxDate},
					"您输入的 '"+propertyKey+"' 为空，系统预期为一个日期.");
	 		return;
		}
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		if(minDate.after(value)){
			packMessage(messageList, "DATE_BEFORE_START",propertyKey,new Object[]{propertyKey, value, minDate, maxDate},
					"您输入的 '"+propertyKey+"' 在最早的日期"+formatter.format(minDate) +"之前，请修正");
	 		
	 		return;
	 	}
		if(maxDate.before(value)){
			packMessage(messageList, "DATE_AFTER_END",propertyKey,new Object[]{propertyKey, value, minDate, maxDate},
					"您输入的 '"+propertyKey+"' 在最晚的日期"+formatter.format(maxDate)+"之后，请修正");
	 		
	 		return;
	 	}
		
	}
	protected void checkEmail(String value, int min, int max,
			String propertyKey, List<Message> messageList) {
		if (min == 0 && (value==null || value.isEmpty())) {
			return;
		}
		checkStringLengthRange(value, 5, 256, propertyKey, messageList);
		/*
		 * The maximum length is specified in RFC 5321: "The maximum total length of 
		 * a reverse-path or forward-path is 256 characters"
		 * 
		 * */
		
		
		
	}
	protected void checkPassword(String value, int min, int max,
			String propertyKey, List<Message> messageList) {
		checkStringLengthRange(value, 6, 24, propertyKey, messageList);
		
	}
	protected void checkMoneyAmount(double value, double min, double max,
			String propertyKey, List<Message> messageList) {
		checkDoubleRange(value, min, max, propertyKey, messageList);
		
	}
	/*
	 * 
您输入的姓名阿布切诺-买买提有误，该值长度 7 ，系统预期是长度2到6之间的文本

您输入的支付金额 ‘100.00’ 有误， 该值低于系统预期范围，系统期望是从101.00到121.00之间

您输入的支付金额 ‘啊100.00’ 有误， 该输入正确的格式是像 123.09 的小数

您输入的出生日期格式有误，该输入正确的的格式是像 2017-09-09的日期
	 * 
	 * 
	 * */
	protected void checkDoubleRange(double value, double min, double max,
			String propertyKey, List<Message> messageList) {
		if(value > max){
			packMessage(messageList, "NUMBER_GREATER_THAN_MAX",propertyKey,new Object[]{propertyKey, value, min, max},
					"您输入的 '"+propertyKey+"' 在比允许的最大值"+max+"还要大，请修正。");
	 		
	 		return;
	 	}
		if(value < min){
			packMessage(messageList, "NUMBER_LESS_THAN_MIN",propertyKey,new Object[]{propertyKey, value, min, max},
					"您输入的 '"+propertyKey+"' 在比允许的最小值"+min+"还要小，请修正。");
	 		
	 		return;
	 	}
		
	}
	protected  void checkUrl(String pActionLink, int pI, int pI2, String pActionLinkOfAcceleratorAccount,
            List<Message> messageList) {
          
    }
    protected void checkBooleanRange(boolean pFullAccess, int pI, boolean pB, String pFullAccessOfUserApp,
            List<Message> messageList) {
         
    }
    protected void checkImage(String pAppIcon, int pI, int pI2, String pAppIconOfUserApp, List<Message> messageList) {
        
    }
    protected void checkDocument(String pAppIcon, int pI, int pI2, String pAppIconOfUserApp, List<Message> messageList) {
        
    }
	protected void checkIntegerRange(int value, int min, int max,
			String propertyKey, List<Message> messageList) {
		if(value > max){
			packMessage(messageList, "INTEGER_GREATER_THAN_MAX",propertyKey,new Object[]{propertyKey, value, min, max},
					"您输入的"+propertyKey+"在比允许的最大值"+max+"还要大，请修正。");
	 		
	 		return;
	 	}
		if(value < min){
			packMessage(messageList, "INTEGER_LESS_THAN_MIN",propertyKey,new Object[]{propertyKey, value, min, max},
					"您输入的"+propertyKey+"在比允许的最小值"+min+"还要小，请修正。");
	 		
	 		return;
	 	}
		
	}
	protected String hashStringWithSHA256(String valueToHash, String salt) {
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			String textToHash = valueToHash+":"+salt;
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
	
	
	protected<T extends BaseEntity> void addActions(BaseUserContext baseUserContext, T entity,
			Map<String, Object> tokens){
		
		entity.addAction(createAction("@view","view","view/"+entity.getId()+"/","main","primary"));

	}
	
	protected<T extends BaseEntity> void addAction(BaseUserContext userContext, BaseEntity baseEntity, Map<String, Object> tokens,
 			String localeKey, String key, String path,String group, String level){
 		
 		baseEntity.addAction(createAction( localeKey,  key,   path,group, level));
		
 		
 	}
	
	protected Action createAction(String localeKey, String key, String path,String actionGroup, String actionLevel){
		
		
		return new Action()
			.withLocaleKey(localeKey)
			.withActionKey(key)
			.withManagerBeanName(this.getBeanName())
			.withActionPath(path)
			.withActionGroup(actionGroup)
			.withActionLevel(actionLevel);

	}
	
	public void onAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters) {
		// by default, nothing to do
	}
	protected void checkMoneyAmount(BigDecimal value, double min, double max,
			String propertyKey, List<Message> messageList) {
		checkDoubleRange(value.doubleValue(), min, max, propertyKey, messageList);
		
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
	protected void checkBigDecimalRange(BigDecimal value, double min, double max, String propertyKey, List<Message> messageList) {
		if(value.compareTo(new BigDecimal(max)) > 0){
			packMessage(messageList, "NUMBER_GREATER_THAN_MAX",propertyKey,new Object[]{propertyKey, value, min, max},
					"您输入的 '"+propertyKey+"' 在比允许的最大值"+max+"还要大，请修正。");
	 		
	 		return;
	 	}
		if(value.compareTo(new BigDecimal(min)) < 0){
			packMessage(messageList, "NUMBER_LESS_THAN_MIN",propertyKey,new Object[]{propertyKey, value, min, max},
					"您输入的 '"+propertyKey+"' 在比允许的最小值"+min+"还要小，请修正。");
	 		
	 		return;
	 	}
	}
	protected void checkTaxpayerid(String value, int min, int max, String propertyKey,
			List<Message> messageList) {
		if(value == null || value.trim().length() != 15){
			packMessage(messageList, "STRING_NOT_FIXED_LENGTH",propertyKey,new Object[]{propertyKey, value, 15},
					"您输入的 '"+propertyKey+"' 不是15位的有效税号，请修正。");
	 		return;
	 	}
	}
	
	
	
	
	protected AccessInfo convertToAccessInfo(ListAccess listAccess) {
		
		AccessInfo accessInfo = new AccessInfo();
		
		
		accessInfo.setInternalName(listAccess.getInternalName());
		accessInfo.setReadPermission(listAccess.getReadPermission());
		accessInfo.setCreatePermission(listAccess.getCreatePermission());
		accessInfo.setDeletePermission(listAccess.getDeletePermission());
		accessInfo.setUpdatePermission(listAccess.getUpdatePermission());
		accessInfo.setExecutionPermission(listAccess.getExecutionPermission());
		
		
		
		
		return accessInfo;
		
	}
	public void enforceAccess(BaseUserContext baseUserContext, Object targetObject) {
		if(baseUserContext == null){
			return ;
		}
		
		UserContext userContext = (UserContext)baseUserContext;
		
		this.applyAccessList(userContext, targetObject);
		
	}
	protected Map<String, ListAccess> toMap(SmartList<ListAccess> listAccessList){
		
		Map<String, ListAccess> map = new HashMap<String, ListAccess>();
		
		for(ListAccess listAccess: listAccessList) {
			
			map.put(listAccess.getInternalName(), listAccess);
			
		}
		
		return map;

	}
	protected void applyAccessList(UserContext userContext, Object targetObject) {
		
		if(!(targetObject instanceof BaseEntity)) {
			
			userContext.log("no applied to target object "+targetObject.getClass().getName());
			return;
		}
		
		BaseEntity entity = (BaseEntity)targetObject;
		
		UserApp app = currentApp(userContext);
		 
		if(app==null) {
			userContext.log("no app");
			return;
		}
		
		List<SmartList<?>> allLists = entity.getAllRelatedLists();
		
		
		if(allLists==null) {
			userContext.log("no list");
			return;
		}
		
		if(!app.getObjectType().equalsIgnoreCase(entity.getInternalType())) {
			userContext.log("no match type");
			return;
		}
		if(!app.getObjectId().equals(entity.getId())) {
			userContext.log("no match id");
			return;
		}
		SmartList<ListAccess> listAccessList = app.getListAccessList();
		//then apply to the list;
		Map<String, ListAccess> accessListMap = toMap(listAccessList);
		
		
		
		
		for(SmartList<?> list:allLists) {
			
			String listName = list.getListInternalName();
			userContext.log("---------------"+list.getListInternalName()+"");
			
			ListAccess listAccess = accessListMap.get(listName);
			if(listAccess==null) {
				continue;
			}
			//AccessInfo
			SmartListMetaInfo metaInfo = new SmartListMetaInfo();
			
			AccessInfo accessInfo = convertToAccessInfo(listAccess);
			userContext.log(list.getListInternalName()+""+accessInfo.getReadPermission());
			metaInfo.setAccessInfo(accessInfo);
			
			list.setMetaInfo(metaInfo);
			
			if(!accessInfo.getReadPermission()) {
				
				
				list.clear();
			}
			
			
			
		}
		
		
		
		userContext.log(" match done" + allLists.size());
		
	}
	
	protected long parseLong(String longExpr) {
		return Long.valueOf(longExpr);
	}
	
	
	
	
	
}



















