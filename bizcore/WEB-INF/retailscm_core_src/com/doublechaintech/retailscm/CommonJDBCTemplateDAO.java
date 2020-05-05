package com.doublechaintech.retailscm;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.utils.TextUtil;
import java.util.Arrays;


public abstract class CommonJDBCTemplateDAO extends BaseEntity{


	protected String getSelectAllSQL() {

		//return new String[]{"name","bize_order","card_number","billing_address"};
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("select * from ");
		stringBuilder.append(this.getTableName());
		return stringBuilder.toString();
	}

	protected <T  extends BaseEntity> SmartList<T> loadAll(RowMapper<T> mapper) {

		return this.queryForList(getSelectAllSQL(), new Object[] {}, mapper);

	}

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JdbcTemplate jdbcTemplateObject;

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);

		jdbcTemplateObject.setFetchSize(1000);
		jdbcTemplateObject.setMaxRows(getMaxRows());
		jdbcTemplateObject.setQueryTimeout(10);
	}

	protected <T  extends BaseEntity> void  handleNotFullFilled(Map<String, T> entityMap,
			List<T > databaseEntityList) {


	}

	public <T  extends BaseEntity> void enhanceListInternal(List<T> entityList,RowMapper<T> mapper) {

		if(entityList == null){
			//noting to be enhanced
			return;
		}

		if(entityList.isEmpty()){
			//noting to be enhanced
			return;
		}
		//put id into a set
		Map <String,T> entityMap = new HashMap<String,T>();
		for(T entity: entityList){
			if(entity == null){
				continue;
			}
			if(entity.getId() == null){
				continue;
			}
			entityMap.put(entity.getId(), entity);
		}
		Object idArray [] = entityMap.keySet().toArray();
		if(idArray.length < 1){
			return;
		}
		String SQL = getListQuerySQL(idArray); //MySql does not support set array as parameter, meanwhile oracle and PgSQL support it
		List<T> databaseEntityList = this.queryForList(SQL, entityMap.keySet().toArray(),mapper );
		if(databaseEntityList == null){
			//found nothing
			return;
		}

		if(databaseEntityList.isEmpty()){
			//found nothing
			return;
		}

		if(databaseEntityList.size() != idArray.length){
			//some of the AvailableToken may not be fetched, just ignore, things are not perfect too!
			handleNotFullFilled(entityMap,databaseEntityList);
		}

		for(T entity: databaseEntityList){
			if(entity == null){
				continue;
			}
			if(entity.getId() == null){
				continue;
			}
			entityMap.put(entity.getId(), entity);
		}

		//find and copy the value
		for(T entity: entityList){
			if(entity == null){
				continue;
			}
			if(entity.getId() == null){
				continue;
			}
			T entityInMap = entityMap.get(entity.getId());
			//may missing the value;
			if(entityInMap == null){
				//this is very strange, it means the database query has some big issue;
				//it means found something other than the expected value;
				continue;
			}

			entityInMap.copyTo((T)entity);//the entity has been filled;
		}




	}


	protected <T  extends BaseEntity> SmartList<T> presentSubList(String ownerObjectId,
			SmartList<T>list,Map<String, Object> options,
			BiFunction<String, Map<String, Object>, Integer>countFunction,
			FourParameterFunction<String, Integer, Integer,Map<String, Object>,SmartList<T>>fillDataFromDBFunction
			){


		if(list == null){
			return null;
		}
		String targetObjectName =  list.getListInternalName();
		int listSize = list.size();
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);

		list.setRowsPerPage(rowsPerPage);

		if(listSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page
			return list;
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);
		//page must be calculated with this step
		int count = listSize;
		if(listSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count =countFunction.apply(ownerObjectId, options);
			//need to be a method reference

		}

		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}

		if(isCurrentPageInLoadedList(listSize, currentPage,rowsPerPage )){

			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(listSize,currentPage,rowsPerPage) ;
			SmartList<T> sublist = list.subListOf(fromIndex, toIndex);
			sublist.setListInternalName(targetObjectName);
			sublist.setTotalCount(count);
			sublist.setCurrentPageNumber(currentPage);
			sublist.setRowsPerPage(rowsPerPage);
			sublist.setMetaInfo(list.getMetaInfo());
			sublist.setStatsInfo(list.getStatsInfo());
			return sublist;
			//bookCopy.setLossAssessmentRecordList(lossAssessmentRecordList);
			//return bookCopy;
		}
		int start = (currentPage-1) * rowsPerPage ;
		SmartList<T> newList = fillDataFromDBFunction.apply(ownerObjectId, start, rowsPerPage, options);
		newList.setListInternalName(targetObjectName);
		newList.setTotalCount(count);
		newList.setCurrentPageNumber(currentPage);
		newList.setRowsPerPage(rowsPerPage);
		newList.setMetaInfo(list.getMetaInfo());
		newList.setStatsInfo(list.getStatsInfo());
		return newList;

	}
	@FunctionalInterface
	public interface FourParameterFunction<P1, P2, P3,P4,R> {
		R apply(P1 p1,P2 p2,P3 p3,P4 p4);
	}

	public int getMaxRows() {
		return 1000;
	}

	protected Map<String,Object>  emptyOptions() {
		return new HashMap<String,Object>();
	}
	public int deleteAll() throws Exception{

		String methodName="deleteAll()";

		String SQL=this.getDeleteAllSQL();
		int affectedNumber = this.singleUpdate(SQL, new Object[] {});
		return affectedNumber;


	}
	protected void handleDeleteOneError(String objectId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{objectId};
		//int count = queryForObject(SQL, Integer.class, parameters);
		int count = this.queryInt(SQL, parameters);

		throwIfHasException(objectId,version,count);
	}

	protected void throwIfHasException(String objectId, int version, int count) throws Exception{



	}

	protected static final String DATABASE_PRODUCT_INFORMIX="Informix Server".toLowerCase();
	protected static final String DATABASE_PRODUCT_GBASE="GBase Server".toLowerCase();
	protected static final String DATABASE_PRODUCT_MYSQL="MySQL".toLowerCase();
	protected static final String DATABASE_PRODUCT_PGSQL="PostgreSQL".toLowerCase();
	protected static final String DATABASE_PRODUCT_ORACLE="Oracle".toLowerCase();
	protected static final String DATABASE_PRODUCT_MSSQL="Microsoft SQL Server".toLowerCase();
	protected static final String DATABASE_PRODUCT_H2="H2".toLowerCase();

	protected String wrapRangeQuery(String body) {

		if(getDatabaseProductName().equals(DATABASE_PRODUCT_MYSQL)) {
			return this.join("select ",body," limit ?, ?");
		}
		if(getDatabaseProductName().equals(DATABASE_PRODUCT_H2)) {
			return this.join("select ",body," limit ?, ?");
		}
		if(getDatabaseProductName().equals(DATABASE_PRODUCT_GBASE)) {
			return this.join("select skip ? first ? ",body);
		}
		if(getDatabaseProductName().equals(DATABASE_PRODUCT_INFORMIX)) {
			return this.join("select skip ? first ? ",body);
		}
		if(getDatabaseProductName().equals(DATABASE_PRODUCT_PGSQL)) {
			return this.join("select  ",body," offset ? limit ?");
		}

		if(getDatabaseProductName().equals(DATABASE_PRODUCT_ORACLE)) {
			//not tested yet, more issue is here
			return this.join("select * from (",
					"select a.*, rownum rowno from (",
					"select ",body,
					") _external where_external.rownum<=? ",
					") _internal where _internal.rownum>=? ");
		}
		return this.join("select ",body," offset ? limit ?");

	}




	protected String currentDatabaseProductName = null;



	protected String getDatabaseProductName() {

		if(currentDatabaseProductName!=null) {
			return currentDatabaseProductName;
		}
		// only call the connection to get product by the first time;
		Connection conn = null;
		try {
			conn = jdbcTemplateObject.getDataSource().getConnection();
			return currentDatabaseProductName = conn.getMetaData().getDatabaseProductName().toLowerCase();
		} catch (Exception e) {
			return null;
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (Exception e) {
					//Do nothing
					this.logDebug("Trying to close connection error: "+e.getMessage());
				}
			}
		}
	}

	protected JdbcTemplate getJdbcTemplateObject()  {



		return jdbcTemplateObject;
	}
	//Having following methods to allow easier logging, performance optimization
	//The data can be read from read only databases with slave-master arch

	protected int[] batchUpdate(String sql, List<Object[]>args) {
		if(args.isEmpty()){
			return new int[0];
		}

		int[] counts =  getJdbcTemplateObject().batchUpdate(sql, args);
		logSQLAndParamList("batchUpdate",sql,args,counts);
		return counts;

	}



	public int singleUpdate(String sql,Object [] parameters) {
		try {
			int count = getJdbcTemplateObject().update(sql,parameters);
			logSQLAndParameters("singleUpdate",sql,parameters,count+" UPDATED");
			return count;
		}catch(Throwable t) {
			logSQLAndParameters("singleUpdate",sql,parameters,"FAIL with: "+t.getMessage());
			throw t;
		}

	}
	//compatiable with old code
	protected int update(String sql,Object [] parameters) {
		return this.singleUpdate(sql, parameters);

	}
	protected<T extends BaseEntity> T queryForObject(String sql,Object [] parameters,RowMapper<T> mapper) {
		//return getJdbcTemplateObject().batchUpdate(sql, args);

		return wrapWithLog("loadSingleObj",sql, parameters,getJdbcTemplateObject().queryForObject(sql,parameters,mapper));
	}
	protected<T extends BaseEntity> T loadSingleObject(AccessKey accessKey,RowMapper<T> mapper) {
		//return getJdbcTemplateObject().batchUpdate(sql, args);
		//String sql="select * from "+ this.getTableName() +" where " + accessKey.getColumnName() + "= ?";
		String sql = this.join("select * from ",this.getTableName()," where ",accessKey.getColumnName(),"= ?");
		Object [] parameters={accessKey.getValue()};

		return wrapWithLog("loadSingleObject",sql, parameters,getJdbcTemplateObject().queryForObject(sql,parameters,mapper));
	}

	protected <T extends BaseEntity> T wrapWithLog(String methodName, String sql, Object [] parameters, T result) {
		if(result==null) {
			logSQLAndParameters(methodName,sql,parameters,"NULL");
			return null;
		}
		logSQLAndParameters(methodName,sql,parameters,result.getId());

		return result;
	}
	/*
	protected void logSQLAndParameters2(String method, String sql,Object [] parameters) {

		System.out.println(timeExpr()+": "+method+" excuting: "+ sql);

		for(int i=0;i<parameters.length;i++){
			logDebug("\t\tp["+i+"]:\t"+parameters[i]);
		}
	}
*/
	private static  final char SINGLE_QUOTE='\'';

	static class Counter{
		int count = 0;
		public void onChar(char ch){
			if(ch==SINGLE_QUOTE) {
				count++;
			}
		}
		public boolean outOfQuote() {
			return count%2 == 0;
		}


	}

	protected String wrapValueInSQL(Object value) {
		if(value == null) {
			return "NULL";
		}

		if(value instanceof DateTime) {
			DateTime dateTimeValue = (DateTime)value;
			return this.join("'",sqlTimeExpr(dateTimeValue),"'");
		}
		if(value instanceof Date) {
			Date dateValue = (Date)value;
			return this.join("'",sqlDateExpr(dateValue),"'");
		}
		if(value instanceof Number) {
			return value.toString();
		}
		if(value instanceof Boolean) {
			return (Boolean)value?"1":"0";
		}
		if(value instanceof String) {
			String strValue = (String)value;
			String escapedValue =strValue.replace("\'", "''");
			return this.join("'",escapedValue,"'");
		}

		return this.join("'",value,"'");

	}
	protected void logSQLAndParameters1(String method, String sql,Object [] parameters) {
		this.logSQLAndParameters(method, sql, parameters, "UNKNOWN");
	}
	protected void logSQLAndParameters(String method, String sql,Object [] parameters, String result){


		StringBuilder finalSQL = new StringBuilder();

		char [] sqlChars= sql.toCharArray();
		int index = 0;

		Counter counter=new Counter();

		for(char ch:sqlChars) {
			counter.onChar(ch);

			if(ch=='?'&&counter.outOfQuote()) {
				finalSQL.append(wrapValueInSQL(parameters[index]));
				index++;
				continue;
			}
			finalSQL.append(ch);

		}


		logDebug(timeExpr()+"\t"+alignWithTabSpace(method,2)+alignWithTabSpace(result,2)+ finalSQL.toString() +";");


	}

	public String alignWithTabSpace(String value, int tabWidth) {
		if(tabWidth<=0) {
			return value;
		}
		int length = value.length();
		if(length>=tabWidth*8) {
			//超过了
			return value.substring(0, tabWidth*8-2)+".\t";
		}

		int count = tabWidth - (length/8);

		return value+repeatTab(count);


	}
	protected String repeatTab(int length) {
		if(length <= 0){
			return "";
		}
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0;i<length;i++){

			stringBuilder.append('\t');
		}

		return stringBuilder.toString();
	}


	protected void logDebug(String message){
		System.out.println(message);
	}
	protected String sqlTimeExpr(DateTime dateTimeValue){

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//It is not thread safe, how silly the JDK is!!!
		return simpleDateFormat.format(dateTimeValue);
	}
	protected String sqlDateExpr(Date dateValue){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//It is not thread safe, how silly the JDK is!!!
		return simpleDateFormat.format(dateValue);
	}	protected String timeExpr(){

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd'T'HH:mm:ss.SSS");
		//It is not thread safe, how silly the JDK is!!!
		return simpleDateFormat.format(new java.util.Date());
	}

	protected void logSQLAndParamList(String method, String sql,List<Object[]>args, int []counts) {
		//System.out.println(timeExpr()+": "+method+"batch excuting: "+ sql);

		int counter = 0;
		for(Object[] parameters: args){

			this.logSQLAndParameters(this.join(method,"[",counter,"]"), sql, parameters,counts[counter]+" UPDATED");
			counter++;
		}
	}

	protected<T extends BaseEntity> T queryForObject(String sql,Class<T> clazz, Object [] parameters) {
		//return getJdbcTemplateObject().batchUpdate(sql, args);

		return this.wrapWithLog("queryForObject", sql, parameters, getJdbcTemplateObject().queryForObject(sql,clazz,parameters));
	}
	//List<Order> orderList = getJdbcTemplateObject().query(SQL, new Object[]{confirmationId}, getMapper());

	protected <T  extends BaseEntity> SmartList<T> queryForList(String sql,Object [] parameters,RowMapper<T> mapper) {
		//return getJdbcTemplateObject().batchUpdate(sql, args);

		//return getJdbcTemplateObject().query(sql,parameters,mapper);
		List<T> originList = getJdbcTemplateObject().query(sql,parameters,mapper);
		logSQLAndParameters("queryForList",sql,parameters,originList.size()+" ROWS");
		SmartList<T> smartList = new SmartList<T>();
		smartList.addAll(originList);
		return smartList;
	}

	protected Integer queryInt(String sql,Object [] parameters) {
		//return getJdbcTemplateObject().batchUpdate(sql, args);

		//return getJdbcTemplateObject().query(sql,parameters,mapper);

		Integer result =  getJdbcTemplateObject().queryForObject (sql,parameters,Integer.class);
		logSQLAndParameters("queryInt",sql,parameters,"RESULT: "+result);
		return result;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplateObject = jdbcTemplate;
	}

	static boolean inCloseCharRang(char test, char start, char end) {
		if (test < start) {
			return false;
		}
		if (test > end) {
			return false;
		}
		return true;
	}

	static Object[] parse(String maxId) {

		if(maxId==null){
			return new Object[]{"USER",1L};
		}

		Object ret[] = new Object[2];
		StringBuilder numberBuffer = new StringBuilder();
		StringBuilder prefixBuffer = new StringBuilder();
		StringBuilder currentBuffer = numberBuffer;
		char[] chs = maxId.toCharArray();

		int length = chs.length;
		for(int i=0;i<length;i++) {
			char ch=chs[length-i-1];
			if(inCloseCharRang(ch,'0','9')){
				currentBuffer.insert(0, ch);
				continue;
			}
			currentBuffer = prefixBuffer;
			currentBuffer.insert(0, ch);
		}

		ret[0] = prefixBuffer.toString();
		String numberExpr=numberBuffer.toString();
		if(numberExpr.isEmpty()){
			ret[1] = 0L;
			return ret;
		}

		ret[1] = Long.parseLong(numberExpr);
		return ret;

	}

	//static final String ID_FORMAT="USER%06d";

	//There is an issue when runing this code under cluster environment
	//Since other instance running the same code and keep conflicting each other
	//When running under a cluster environment, we need a global unique id to ensure
	//The id will not be repeated

	private AtomicLong currentMax = new AtomicLong(-1L);

	protected String getNextId() {
		synchronized(currentMax){
			if(currentMax.get() > 0){

				return String.format(getIdFormat(),currentMax.incrementAndGet());
			}
			//The following logic just run when the first time loaded the id from table
			try {
				String SQL = "select max(id) from "+getName()+"_data";
				String maxId = getJdbcTemplateObject().queryForObject(SQL, String.class);
				if(maxId==null){
                    currentMax.set(1L);;
					return  String.format(getIdFormat(),1);
				}

				Object ret[]=parse(maxId);
				currentMax.set((Long)ret[1]+1);
				//System.out.println(this.getClass().getName()+this.hashCode()+":getNextId(start from "+maxId+")="+currentMax);
				return String.format(getIdFormat(),currentMax.get());

			} catch (EmptyResultDataAccessException e) {
                currentMax.set(1L);
				return  String.format(getIdFormat(),1);
			}
		}

	}
	protected String getIdFormat() {
		return getShortName(this.getName())+"%06d";
	}


	public static String getShortName(String name) {
		String ar[] = name.split("_");
		String ret = ar[0].substring(0, 1).toUpperCase();

		for (int i = 1; i < ar.length; i++) {
			ret +=ar[i].substring(0, 1).toUpperCase();

		}
		return ret;
	}

	protected String getIdColumnName() {
		return "id";
	}

	protected String getVersionColumnName() {
		return "version";
	}

	abstract protected String[] getNormalColumnNames();

	abstract protected String getName();
	abstract protected String getBeanName();

	protected String getTableName() {
		return this.getName()+"_data";
	}

	protected String getBeanListName() {
		return getBeanName()+"List";
	}

	protected String getCreateSQL() {
		StringBuilder stringBuilder=new StringBuilder();

		stringBuilder.append("insert into ");
		stringBuilder.append(this.getTableName());
		stringBuilder.append("(id, ");
		stringBuilder.append(join());
		stringBuilder.append(", version)values(?, ");
		stringBuilder.append(getCreateParametersPlaceHolders());
		stringBuilder.append(", 1)");

		return stringBuilder.toString();
	}

	protected String getDeleteSQL() {

		//return new String[]{"name","bize_order","card_number","billing_address"};
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("delete from  ");
		stringBuilder.append(this.getTableName());
		stringBuilder.append(" where id= ? and version =?;");

		return stringBuilder.toString();

	}

	protected String getUpdateSQL() {

		//return new String[]{"name","bize_order","card_number","billing_address"};
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("update ");
		stringBuilder.append(this.getTableName());
		stringBuilder.append(" set ");
		stringBuilder.append(joinUpdate());
		stringBuilder.append(", version = ? ");

		stringBuilder.append("where id=? and version=?");

		return stringBuilder.toString();

	}

	protected String getDeleteWithVerionSQL() {

		//return new String[]{"name","bize_order","card_number","billing_address"};
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("delete from ");
		stringBuilder.append(this.getTableName());


		stringBuilder.append(" where id=? and version=?");

		return stringBuilder.toString();

	}



	protected String getCreateParametersPlaceHolders() {


		int length=getNormalColumnNames().length;
		return repeatAndJoin("?",", ",length);
	}





	protected String joinUpdateParametersPlaceHolders() {

		int length=getNormalColumnNames().length;
		return repeatAndJoin("?",", ",length);
	}



	protected String repeatAndJoin(String value, String delimiter, int times) {
		return IntStream.range(0, times).mapToObj(i -> value).collect(Collectors.joining(delimiter));
	}

	protected String joinPlaceHolders(String []parameters) {
		return repeatAndJoin("?",",",parameters.length);
	}

	protected String join() {
		String columNames[]=getNormalColumnNames();
		return Arrays.asList(columNames).stream().collect(Collectors.joining(", "));

	}


	protected String joinUpdate() {

		String columNames[]=getNormalColumnNames();
		return Arrays.asList(columNames).stream().map(columnName->columnName+" = ?").collect(Collectors.joining(", "));

	}

	protected String getDeleteAllSQL() {

		//return new String[]{"name","bize_order","card_number","billing_address"};
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("delete from  ");
		stringBuilder.append(this.getTableName());


		return stringBuilder.toString();

	}

	public<T extends BaseEntity> SmartList<T> removeList(SmartList<T> entityList, Map<String, Object> options) {

		//if(true) throw new IllegalStateException("removeList-----");
		//System.out.println("removeList-----");
		batchDelete(entityList);
		return entityList;
	}

	protected<T extends BaseEntity> void batchDelete(List<T> entityList) {

		if(entityList.isEmpty()){
			return;
		}

		String SQL=getDeleteWithVerionSQL();
		List<Object[]> args=prepareBatchDeleteArgs(entityList);

		int affectedNumbers[] = batchUpdate(SQL, args);


	}

	protected<T extends BaseEntity> List<Object[]> prepareBatchDeleteArgs(List<T> entityList) {

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(T acceleraterAccount:entityList ){
			Object [] parameters = prepareDeleteEntityParameters(acceleraterAccount);
			parametersList.add(parameters);

		}
		return parametersList;

	}

	protected<T extends BaseEntity> Object[] prepareDeleteEntityParameters(T acceleraterAccount) {
 		Object[] parameters = new Object[2];
 		parameters[0] = acceleraterAccount.getId();
 		parameters[1] = acceleraterAccount.getVersion();

 		return parameters;
 	}

	protected int calcToIndex(int totalLoadSize, int currentPage, int rowsPerPage) {
		int lastIndex = currentPage*rowsPerPage;
		if( lastIndex> totalLoadSize){
			return totalLoadSize;
		}
		return lastIndex;

	}

	protected boolean isCurrentPageInLoadedList(int totalLoadSize, int currentPage, int rowsPerPage) {

		if(currentPage*rowsPerPage <= totalLoadSize){//is this really needed????????
			return true;
		}

		if(totalLoadSize < this.getMaxRows()){
			//full loaded
			return true;
		}


		return false;
	}

	protected int rowsPerPageOf(String objectName,Map<String,Object> options) {
		//first get the value from options
		//acceleratorAccountList
		Object object = options.get(objectName + "RowsPerPage");
		if(object == null){
			return 20;
		}
		if(object instanceof Integer){
			return (Integer)object;
		}
		//From the front end, this value may be a string.
		try{
			int rowsPerPage = Integer.parseInt(object.toString());
			if(rowsPerPage > 1000) {
				return 1000;//prevent large rows
			}
			return rowsPerPage;
		}catch(Exception e){
			return 20;
		}

	}

	protected int currentPageNumberOf(String objectName,Map<String,Object> options) {
		Object currentPageObject = options.get(objectName + "CurrentPage");
		if(currentPageObject==null){
			return 1;
		}
		if(currentPageObject instanceof Integer) {
   			return (Integer)currentPageObject;
  		}
		//From the front end, this value may be a string.
		String object =(String) currentPageObject;
		try{
			int rowsPerPage = Integer.parseInt(object);
			return rowsPerPage;
		}catch(Exception e){
			return 1;
		}


	}

	protected void convertListOptions(Map<String,Object> options, String fromPrefix, String toPrefix) {


		Map<String,Object> optionsToMerge = new HashMap<String,Object>();

		Set<Map.Entry<String,Object>> entrySet = options.entrySet();

		for(Map.Entry<String,Object> entry: entrySet){

			String key = entry.getKey();
			if(!key.startsWith(fromPrefix+".")){
				//eg. "XYListAsSender"=>XYList
				continue;
			}
			int startIndex = key.indexOf('.');
			if(startIndex<1){
				continue;
			}
			String remainKeyPart = key.substring(startIndex);
			String newKey = this.join(toPrefix,remainKeyPart);

			optionsToMerge.put(newKey, entry.getValue());


		}
		//to avoid concurrent modification
		Set<Map.Entry<String,Object>> mergeEntrySet = optionsToMerge.entrySet();
		for(Map.Entry<String,Object> entry: mergeEntrySet){
			options.put( entry.getKey(), entry.getValue());
		}

	}

	/*
	protected Object [] joinArrays(Object [] arr1, Object[] arr2) {
 		Object [] objs = new Object[arr1.length+arr2.length];
 		int index = 0;
 		for(Object obj:arr1){
 			objs[index++] = obj;
 		}
 		for(Object obj:arr2){
 			objs[index++] = obj;
 		}
 		return objs;

 	}*/

	protected Object [] joinArrays(Object [][] arrays) {
		if(arrays == null){
			throw new IllegalArgumentException("joinArrays(Object [][] arrays): arrays can not be NULL");
		}

		int length = 0;

		for(int i=0;i<arrays.length;i++){
			if(arrays[i] == null){
				throw new IllegalArgumentException("joinArrays(Object [][] arrays): arrays["+i+"] with can not be NULL");
			}
			length += arrays[i].length;
		}

 		Object [] result = new Object[length];
 		int offset = 0;
 		for(int i=0;i<arrays.length;i++){
			//length += arrays[i].length;
 			Object [] element = arrays[i];

			System.arraycopy(element,0,result,offset, element.length);
			offset += element.length;
		}

 		return result;

 	}

	protected String getListQuerySQL(Object [] array) {

		String SQL = "select * from "+this.getTableName()+" where id in ("+repeatExpr("?",",",array.length)+")";

		return SQL;
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

	protected int countWith(String target, Object value, Map<String,Object> options) {
 		MultipleAccessKey key = new MultipleAccessKey();
		key.put(target, value);
		return this.countWith(key , options);
 	}


	protected QueryCriteria createQueryCriteria(Map<String,Object> options) {
		return QueryCriteria.createCriteriaFromOptions(this.getBeanListName(), options);
	}

	protected <T  extends BaseEntity> SmartList<T> queryWith(String target, Object value, Map<String,Object> options,  RowMapper<T> mapper){

		QueryCriteria qc = this.createQueryCriteria(options);

		String SQL = "select * from "+this.getTableName()+" where "+target+" = ? "+ qc.getSQL();

		Object []parameters = this.joinArrays(new Object[][]{new Object[]{value}, qc.getParameters()});
		SmartList<T> resultList = queryForList(SQL, parameters, mapper);
		return resultList;

 	}

	protected <T  extends BaseEntity> SmartList<T> queryWith(MultipleAccessKey key,
			Map<String, Object> options, RowMapper<T> mapper) {
		QueryCriteria qc = this.createQueryCriteria(options);
		if(key.isEmpty()){
			throw new IllegalArgumentException("The key.sql() from MultipleAccessKey has nothing in it!");
		}
		String SQL = "select * from "+this.getTableName()+" where" + key.sql() + qc.getSQL();

		Object []parameters = this.joinArrays(new Object[][]{key.params(), qc.getParameters()});
		SmartList<T> resultList = queryForList(SQL, parameters, mapper);
		return resultList;

	}

	protected int countWith(MultipleAccessKey key, Map<String, Object> options) {
		if(key.isEmpty()){
			throw new IllegalArgumentException("The key.sql() from MultipleAccessKey has nothing in it!");
		}
		QueryCriteria qc = this.createQueryCriteria(options);

		String SQL = "select count(*) from "+this.getTableName()+" where " + key.sql() + qc.getSQL();

		Object []parameters = this.joinArrays(new Object[][]{key.params(), qc.getParameters()});
		Integer count = queryInt(SQL, parameters);
 		if(count ==  null ){
			//return the value anyways
			return 0;
		}
		return count;

	}
	protected Map<String, Integer> countWithIds(String target, String[] ids, Map<String,Object> options) {
		if (ids == null || ids.length == 0) {
			return new HashMap<>();
		}
 		String SQL = "select " + target +" as id, count(*) as count from "+this.getTableName()+" where "+target+" in (" + TextUtil.repeat("?", ids.length, ",", true) +") group by " + target;
 		Object [] parametersArray = ids;
 		List<Map<String, Object>> result = this.getJdbcTemplateObject().queryForList(SQL, parametersArray);
 		if (result == null || result.isEmpty()) {
 			return new HashMap<>();
 		}
 		Map<String, Integer> cntMap = new HashMap<>();
 		for(Map<String, Object> data : result) {
 			String key = (String) data.get("id");
 			Number value = (Number) data.get("count");
 			cntMap.put(key, value.intValue());
 		}
 		this.logSQLAndParameters("countWithIds", SQL, ids, cntMap.size() + " Counts");
 		return cntMap;
 	}
	//先支持一个Key好了, 后面再扩展到多Key场景
	protected Map<String, Integer> countWithGroup(String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {
		if(filterKey.isEmpty()){
			throw new IllegalArgumentException("The key.sql() from MultipleAccessKey has nothing in it!");
		}
		QueryCriteria qc = this.createQueryCriteria(options);
		/*
		if(groupKey == null){
			throw new IllegalArgumentException("method countWithGroup: param groupKey can not be null");
		}
		if(groupKey.length == 0){
			throw new IllegalArgumentException("method countWithGroup: param groupKey can not be empty");
		}
		String groupKeyExpr = this.joinArray(",",groupKey);
		*/

		String internalKey = this.mapToInternalColumn(groupKey);
		checkFieldName(internalKey);
		String SQL = "select count(*) as count, "+internalKey+" from "+this.getTableName()
				+" where " + filterKey.sql() + qc.getSQL() +" group by " +internalKey ;

		Object []parameters = this.joinArrays(new Object[][]{filterKey.params(), qc.getParameters()});
		if(parameters.length == 0){
			//if there are no parameters, where does not make sence
			SQL = "select count(*) as count, "+internalKey+" from "+this.getTableName()
					+" group by " +internalKey ;
		}



		logSQLAndParameters("countWithGroup",SQL,parameters,"PENDING");
		Map<String, Integer> result = this.getJdbcTemplateObject().query(SQL, parameters, new ResultSetExtractor<Map<String, Integer>>() {

			@Override
			public Map<String, Integer> extractData(ResultSet rs)
					throws SQLException, DataAccessException {
				Map<String, Integer> countResult = new CountingResultMap();

				while (rs.next()){

					int count = rs.getInt(1);
					//int resultCount = rs.get
					String key = rs.getString(2);

					countResult.put(key, count);
				}

				return countResult;

			}


		});

		return result;
	}

	protected String joinArray(String delimiter, Object []args){
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0;i<args.length;i++){
			if(i>0) stringBuilder.append(delimiter);
			stringBuilder.append(args[i]);
		}
		return stringBuilder.toString();

	}

	protected <T  extends BaseEntity> SmartList<T> queryWithRange(String target, Object value, Map<String,Object> options,
			RowMapper<T> mapper, int start, int count){
		QueryCriteria qc = this.createQueryCriteria(options);
		String SQL = wrapRangeQuery("* from "+this.getTableName()+" where "+target+" = ? " + qc.getSQL());


		Object []parameters = this.joinArrays(new Object[][]{new Object[]{value}, qc.getParameters(), new Object[]{ start, count}} );

		SmartList<T> resultList = queryForList(SQL, parameters, mapper);
		return resultList;

 	}

	public <T extends BaseEntity> SmartList<T> findAllCandidateByFilter(String fieldName, String filterKey, int pageNo, int pageSize, RowMapper<T> mapper) {
		return findAllCandidateByFilter(fieldName, null, filterKey, pageNo, pageSize, mapper);
	}
	public <T extends BaseEntity> SmartList<T> findAllCandidateByFilter(String fieldName, String notNullColName, String filterKey, int pageNo, int pageSize, RowMapper<T> mapper) {
		Object[] preparedResult = constractFindAllByFilterParams(fieldName, notNullColName, filterKey, pageNo, pageSize);
		String sqlCount = (String) preparedResult[0];
		Object[] countParams = (Object[]) preparedResult[1];
		String sqlQuery = (String) preparedResult[2];
		Object[] params = (Object[]) preparedResult[3];
		int totalNum = this.queryInt(sqlCount, countParams);
		SmartList<T> resultList = this.queryForList(sqlQuery, params, mapper);
		resultList.setTotalCount(totalNum);
		resultList.setCurrentPageNumber(pageNo);
		resultList.setRowsPerPage(pageSize);
		return resultList;
	}

	protected Object[] constractFindAllByFilterParams(String fieldName, String notNullColName, String filterKey, int pageNo, int pageSize) {
		if (filterKey == null || filterKey.trim().isEmpty()) {
			return constructFindAllWithoutFilterKey(fieldName, notNullColName, pageNo, pageSize);
		}
		return constractFindAllWithFilterKey(fieldName, notNullColName, filterKey, pageNo, pageSize);
	}

	protected Object[] constructFindAllWithoutFilterKey(String fieldName, String notNullColName, int pageNo, int pageSize) {
		String querySQL = wrapRangeQuery("* from " + this.getTableName() 
			+ (notNullColName==null?"":" where "+ notNullColName +" is not null ") 
			+ " order by " + fieldName + " asc ");
		String countSQL = "select count(*) from " + this.getTableName() + (notNullColName==null?"":" where "+ notNullColName +" is not null ") ;
		Object[] params = new Object[] { (pageNo - 1) * pageSize, pageSize };
		return new Object[] { countSQL, new Object[] {}, querySQL, params };
	}

	protected Object[] constractFindAllWithFilterKey(String fieldName, String notNullColName, String filterKey, int pageNo, int pageSize) {
		String notNullClause = notNullColName==null?"":(" and " + notNullColName +" is not null ");
		String querySQL =  wrapRangeQuery("* from " + this.getTableName() + " where " + fieldName + " like ? "+ notNullClause +" order by " + fieldName + " asc ");
		String countSQL = "select count(*) from " + this.getTableName() + " where " + fieldName + " like ? " + notNullClause;
		Object[] countParams = new Object[] { '%' + filterKey + '%' };
		Object[] queryParams = new Object[] { '%' + filterKey + '%', (pageNo - 1) * pageSize, pageSize };
		return new Object[] { countSQL, countParams, querySQL, queryParams };
	}
	/*
	protected Object[] constructFindAllWithoutFilterKey(String fieldName, int pageNo, int pageSize) {
		String querySQL = "select * from " + this.getTableName() + " order by " + fieldName + " asc limit ?,?";
		String countSQL = "select count(*) from " + this.getTableName();
		Object[] params = new Object[] { (pageNo - 1) * pageSize, pageSize };
		return new Object[] { countSQL, new Object[] {}, querySQL, params };
	}

	protected Object[] constractFindAllWithFilterKey(String fieldName, String filterKey, int pageNo, int pageSize) {
		String querySQL = "select * from " + this.getTableName() + " where " + fieldName + " like ? order by " + fieldName + " asc limit ?,?";
		String countSQL = "select count(*) from " + this.getTableName() + " where " + fieldName + " like ? ";
		Object[] countParams = new Object[] { '%' + filterKey + '%' };
		Object[] queryParams = new Object[] { '%' + filterKey + '%', (pageNo - 1) * pageSize, pageSize };
		return new Object[] { countSQL, countParams, querySQL, queryParams };
	}
	*/

	protected void assertMethodArgumentNotNull(Object object, String method, String parameterName){
		if(object == null){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud NOT be null");
		}
	}
	protected void assertMethodIntArgumentGreaterThan(int value, int targetValue,String method, String parameterName){
		if(value <= targetValue){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud greater than " + targetValue +" but it is: "+ value);
		}
	}
	protected void assertMethodIntArgumentLessThan(int value, int targetValue,String method, String parameterName){
		if(value >= targetValue){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud less than " + targetValue +" but it is: "+ value);
		}
	}

	protected void assertMethodIntArgumentInClosedRange(int value, int startValue, int endValue, String method, String parameterName){

		if(startValue>endValue){
			throw new IllegalArgumentException("When calling the check method, please note your parameter, endValue < startValue");
		}

		if(value < startValue){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud be in closed range: ["+startValue+","+endValue+"] but it is: "+value);
		}
		if(value > endValue){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud be in closed range: ["+startValue+","+endValue+"] but it is: "+value);
		}
	}
	protected void assertMethodStringArgumentLengthInClosedRange(String value, int lengthMin, int lengthMax, String method, String parameterName){

		if(lengthMin < 0){
			throw new IllegalArgumentException("The method assertMethodStringArgumentLengthInClosedRange lengMin should not less than 0");
		}

		if(lengthMin > lengthMax){
			throw new IllegalArgumentException("The method assertMethodStringArgumentLengthInClosedRange lengMin less or equal lengthMax");
		}

		if(value == null){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' length shoud be in closed range: ["+lengthMin+","+lengthMax+"] but it is null");
		}
		if(value.length() < lengthMin){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' length shoud be in closed range: ["+lengthMin+","+lengthMax+"] but it is: "+value.length());
		}
		if(value.length() > lengthMax){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' length shoud be in closed range: ["+lengthMin+","+lengthMax+"] but it is: "+value.length());
		}
	}

	protected String wrapWithDate(String fieldName) {

		return this.join("date(",fieldName,")");


	}
	protected String formatKeyForDateLine(String fieldName) {

		return this.join(fieldName,"OfDateline");


	}

	//wrapWithDate
	protected List<AggrResult> statsWithGroup(Class<? extends BaseEntity> type, String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {
		if(filterKey.isEmpty()){
			throw new IllegalArgumentException("The key.sql() from MultipleAccessKey has nothing in it!");
		}
		QueryCriteria qc = this.createQueryCriteria(options);


		String internalKey = this.mapToInternalColumn(groupKey);
		checkGroupKey(internalKey);//open for functions
		String SQL = "select "+internalKey+" as date_key, count(*) as count from "+this.getTableName()
				+" where " + filterKey.sql() + qc.getSQL() +" group by date_key"  ;

		Object []parameters = this.joinArrays(new Object[][]{filterKey.params(), qc.getParameters()});
		if(parameters.length == 0){
			//if there are no parameters, where does not make sence
			SQL = "select "+internalKey+" as date_key, count(*) as count from "+this.getTableName()
					+" group by date_key"  ;
		}



		logSQLAndParameters("statsWithGroup",SQL,parameters,"PENDING");
		List<AggrResult> result = this.getJdbcTemplateObject().query(SQL, parameters, new ResultSetExtractor<List<AggrResult> >() {

			@Override
			public List<AggrResult>  extractData(ResultSet rs)
					throws SQLException, DataAccessException {


				List<AggrResult> resultList = new ArrayList<AggrResult>();


				while (rs.next()){
					AggrResult result = new AggrResult();
					Object key = rs.getObject(1);
					int count = rs.getInt(2);

					BaseEntity objectKey = convertToBaseEntityKey(type, key);

					result.setKey(objectKey);
					result.setValue(count);

					resultList.add(result);

				}

				return resultList;

			}

			protected BaseEntity convertToBaseEntityKey(Class<? extends BaseEntity> type, Object key) {



				if(key != null && (key instanceof Date)) {
					DateKey objectKey = new DateKey();
					objectKey.setId(objectKey.toString());
					objectKey.setDateValue((Date)key);
					return objectKey;
				}

				try {
					BaseEntity objectKey = type.newInstance();
					objectKey.setId(key==null?null:key.toString());
					return objectKey;
				} catch (InstantiationException e) {
					return null; //god bless code not going here
				} catch (IllegalAccessException e) {
					return null;//god bless code not going here
				}
			}


		});

		return result;
	}

	protected Object toSqlParameter(Object value) {
		if (value == null) {
			return value;
		}
		return value.toString();
	}

}

class CountingResultMap extends HashMap<String, Integer> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Integer get(Object key) {

		Integer  value = super.get(key);
		if(value==null){
			return 0;
		}
		return value;
	}

}
















