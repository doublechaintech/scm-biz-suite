
package  com.doublechaintech.retailscm;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.terapico.caf.DateTime;
import com.terapico.caf.Images;

public class BaseChecker {
	protected RetailscmUserContext userContext;
	protected List<Message> messageList;

	public RetailscmUserContext getUserContext() {
		return userContext;
	}
	Stack<String>positonsStack;

	protected void pushPosition(String value) {
		if(positonsStack==null) {
			positonsStack = new Stack<String>();
		}
		positonsStack.push(value);
	}
	protected void popPosition() {
		if(positonsStack==null) {
			return;
		}
		positonsStack.pop();
	}
	protected String currentPosition() {
		if(positonsStack==null) {
			return "";
		}
		return positonsStack.stream().collect( Collectors.joining( "." ) );

	}
	AtomicInteger baseEntityListArrayIndex = null;
	protected void endList(List<BaseEntity> transactionList) {
		baseEntityListArrayIndex = null;

	}

	protected void startList(List<BaseEntity> transactionList) {

		baseEntityListArrayIndex = new AtomicInteger();

	}
	protected BaseEntity eachOfList(BaseEntity entity) {
		if(baseEntityListArrayIndex != null) {
			baseEntityListArrayIndex.incrementAndGet();
		}

		return entity;

	}

	public void setUserContext(RetailscmUserContext ctx){
		this.userContext = ctx;
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
    errorMsg.setSourcePosition(this.currentPosition());
 		messageList.add(errorMsg);

		return;
	}

	protected void checkLongtext(String value, int minLength, int maxLength,
			String propertyKey) {
		checkStringLengthRange(value, minLength, maxLength, propertyKey);
	}
	protected void checkTaxpayerid(String value, int minLength, int maxLength,
			String propertyKey) {
		checkStringLengthRange(value, 15, 15, propertyKey);
	}

	protected void checkBaseEntityReference(BaseEntity value, boolean isRequired,String propertyKey) {
		if(!isRequired) {
			return;
		}
		if(value!=null) {
			return;
		}
		//this value is required but not null, this will produce a message
		packMessage(messageList, "OBJECT_NOT_ALLOW_TO_BE_NULL",propertyKey,new Object[]{propertyKey, value, isRequired},
					"您输入的 对象'"+propertyKey+"' 的值'"+value+"'不允许为空.");


	}

	protected void checkStringLengthRange(String value, int minLength, int maxLength,
			String propertyKey) {

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
	protected void checkImagesRange(Images value, int minLength, int maxLength, String propertyKey) {
		if(value == null){
			if(minLength == 0 ){
				//如果最小长度为0，则改值允许为NULL
				return;
			}
			packMessage(messageList, "STRING_NOT_ALLOW_TO_BE_NULL",propertyKey,new Object[]{propertyKey, value, minLength, maxLength},
					"您输入的 '"+propertyKey+"' 的值'"+value+"'有误，最少"+minLength+"张图片.");
			return;
		}

		if(integerValueInClosedRange(value.size(), minLength, maxLength)){
			return;
		}

		if(minLength == maxLength){
			//固定长度，
			packMessage(messageList, "STRING_NOT_FIXED_LENGTH",propertyKey,new Object[]{propertyKey, value, minLength, maxLength, value.size()},
					"您输入的 '"+propertyKey+"' 的'"+value+"'数量不对, 该值包含 "+ value.size()+" 张图, 系统预期是固定数量为 "+minLength + " 张图.");
	 		return;
		}
		if(value.size()>maxLength){
			packMessage(messageList, "STRING_TOO_LONG",propertyKey,new Object[]{propertyKey, value, minLength, maxLength, value.size()},
					"您输入的 '"+propertyKey+"' 的值'"+value+"'数量太多, 该值包含 "+ value.size()+" 张图, 系统预期最多 "+maxLength+" 张图.");
	 		return;
	 	}
		if(value.size()<minLength){

			packMessage(messageList, "STRING_TOO_SHORT",propertyKey,new Object[]{propertyKey, value, minLength, maxLength, value.size()},
					"您输入的 '"+propertyKey+"' 的值'"+value+"'数量太少, 该值包含 "+ value.size()+" 张图, 系统预期最少 "+minLength+" 张图.");
	 		return;
	 	}

	}
	protected void checkGender(String gender, int i, int j,String targetFieldName) {


	}

	//for stub only
	protected void checkDateNow(Date likeTime, int i, Object now,
			String targetFieldName, Exception exception) {


	}


	protected Object now() {

		return null;
	}

	protected boolean isValidIdentifier(String value){
		return hasVisualChar(value);

	}

	protected boolean hasVisualChar(String value){
		if(value==null){
			return false;
		}
		if(value.isEmpty()){
			return false;
		}
		if(value.trim().isEmpty()){
			return false;
		}
		return true;

	}
	protected void checkBigDecimalRange(BigDecimal projectArea, double i, double j, String projectAreaOfProject) {

	}


	protected void checkChinaMobilePhone(String value, int minLength, int maxLength,
			String propertyKey) {
		//checkStringLengthRange(value, 11, 11, propertyKey);
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
		String prefixes[]= {"13","15","16","17","18","19"};



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

	protected void checkDateTime(Date value, Date minDate, Date maxDate, String propertyKey) {
		this.checkDateRange(value, minDate, maxDate, propertyKey);
	}
	protected void checkDateFuture(Date value, Date minDate, Date maxDate, String propertyKey) {
		this.checkDateRange(value, minDate, maxDate, propertyKey);
	}

	protected void checkDateRange(Date value, Date minDate,
			Date maxDate, String propertyKey) {
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
			Date maxDate, String propertyKey) {
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
		String propertyKey) {
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
			String propertyKey) {
		if (min == 0 && (value==null || value.isEmpty())) {
			return;
		}
		checkStringLengthRange(value, 5, 256, propertyKey);
		/*
		 * The maximum length is specified in RFC 5321: "The maximum total length of
		 * a reverse-path or forward-path is 256 characters"
		 *
		 * */



	}
	protected void checkPassword(String value, int min, int max,
			String propertyKey) {
		checkStringLengthRange(value, 6, 64, propertyKey);

	}
	protected void checkMoneyAmount(double value, double min, double max,
			String propertyKey) {
		checkDoubleRange(value, min, max, propertyKey);

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
			String propertyKey) {
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
	protected  void checkUrl(String pActionLink, int pI, int pI2, String pActionLinkOfAcceleratorAccount) {

    }
    protected void checkBooleanRange(boolean pFullAccess, int pI, boolean pB, String pFullAccessOfUserApp) {

    }
    protected void checkImage(String pAppIcon, int pI, int pI2, String pAppIconOfUserApp) {

    }
    protected void checkDocument(String pAppIcon, int pI, int pI2, String pAppIconOfUserApp) {

    }
	protected void checkIntegerRange(int value, int min, int max,
			String propertyKey) {
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
	protected void checkMoneyAmount(BigDecimal amount, double min, double max, String propertyKey) {
		this.checkBigDecimalRange(amount, min, max, propertyKey);
	}
	protected void checkCountryCode(String countryCode, int min, int max, String propertyKey) {
		checkStringLengthRange(countryCode, min, max, propertyKey);
	}
	protected void checkLongRange(long value, long min, long max, String propertyKey) {
		if (value > max) {
			packMessage(messageList, "LONG_GREATER_THAN_MAX", propertyKey,
					new Object[] { propertyKey, value, min, max },
					"您输入的" + propertyKey + "在比允许的最大值" + max + "还要大，请修正。");

			return;
		}
		if (value < min) {
			packMessage(messageList, "LONG_LESS_THAN_MIN", propertyKey, new Object[] { propertyKey, value, min, max },
					"您输入的" + propertyKey + "在比允许的最小值" + min + "还要小，请修正。");

			return;
		}

	}

  public void putMessageIfHasErrors(BaseEntity entity)
      throws Exception {
    if (messageList.isEmpty() || entity == null) {
      return;
    }
    entity.setErrorMessageList(messageList);
  }

	public void throwExceptionIfHasErrors(Class<? extends Exception> exceptionClazz) throws Exception {
		if(messageList.isEmpty()){
			return;
		}
		if(userContext==null) {
			Class [] classes = {List.class};
      List<Message> copy = new ArrayList<>(this.messageList);
      messageList.clear();
      throw exceptionClazz.getDeclaredConstructor(classes).newInstance(copy);
		}
		for(Message message: messageList){
			String subject = message.getSubject();
			String template = userContext.getLocaleKey(subject);
			if(template==null){
				//not found, it is fine to use hard coded value
				userContext.log("Check Result "+message.getBody());
				continue;
			}
			MessageFormat mf = new MessageFormat(template);

			String labelKey = message.getFirstParam();
			String newLabel = userContext.getLocaleKey(labelKey);
			message.setFirstParam(newLabel);
			String newBody = mf.format(message.getParameters());
			message.setBody(newBody);
			userContext.log("Check Result "+message.getBody());

		}


		Class [] classes = {List.class};
    List<Message> copy = new ArrayList<>(this.messageList);
    messageList.clear();
    throw exceptionClazz.getDeclaredConstructor(classes).newInstance(copy);
	}



}

















