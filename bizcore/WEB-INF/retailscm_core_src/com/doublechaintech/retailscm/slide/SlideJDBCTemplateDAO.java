
package com.doublechaintech.retailscm.slide;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.utils.TextUtil;

import com.doublechaintech.retailscm.RetailscmBaseDAOImpl;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.DateKey;
import com.doublechaintech.retailscm.StatsInfo;
import com.doublechaintech.retailscm.StatsItem;

import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;


import com.doublechaintech.retailscm.page.Page;

import com.doublechaintech.retailscm.page.PageDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class SlideJDBCTemplateDAO extends RetailscmBaseDAOImpl implements SlideDAO{

	protected PageDAO pageDAO;
	public void setPageDAO(PageDAO pageDAO){
 	
 		if(pageDAO == null){
 			throw new IllegalStateException("Do not try to set pageDAO to null.");
 		}
	 	this.pageDAO = pageDAO;
 	}
 	public PageDAO getPageDAO(){
 		if(this.pageDAO == null){
 			throw new IllegalStateException("The pageDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.pageDAO;
 	}	


	/*
	protected Slide load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSlide(accessKey, options);
	}
	*/

	public SmartList<Slide> loadAll() {
	    return this.loadAll(getSlideMapper());
	}

  public Stream<Slide> loadAllAsStream() {
      return this.loadAllAsStream(getSlideMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public Slide load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSlide(SlideTable.withId(id), options);
	}

	

	public Slide save(Slide slide,Map<String,Object> options){

		String methodName="save(Slide slide,Map<String,Object> options)";

		assertMethodArgumentNotNull(slide, methodName, "slide");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalSlide(slide,options);
	}
	public Slide clone(String slideId, Map<String,Object> options) throws Exception{

		return clone(SlideTable.withId(slideId),options);
	}

	protected Slide clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String slideId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		Slide newSlide = loadInternalSlide(accessKey, options);
		newSlide.setVersion(0);
		
		


		saveInternalSlide(newSlide,options);

		return newSlide;
	}

	



	protected void throwIfHasException(String slideId,int version,int count) throws Exception{
		if (count == 1) {
			throw new SlideVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SlideNotFoundException(
					"The " + this.getTableName() + "(" + slideId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String slideId, int version) throws Exception{

		String methodName="delete(String slideId, int version)";
		assertMethodArgumentNotNull(slideId, methodName, "slideId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{slideId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(slideId,version);
		}


	}






	public Slide disconnectFromAll(String slideId, int version) throws Exception{


		Slide slide = loadInternalSlide(SlideTable.withId(slideId), emptyOptions());
		slide.clearFromAll();
		this.saveSlide(slide);
		return slide;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return SlideTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "slide";
	}
	@Override
	protected String getBeanName() {

		return "slide";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SlideTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPageEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SlideTokens.PAGE);
 	}

 	protected boolean isSavePageEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SlideTokens.PAGE);
 	}
 	

 	
 
		

	

	protected SlideMapper getSlideMapper(){
		return new SlideMapper();
	}

	
	
	protected Slide extractSlide(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Slide slide = loadSingleObject(accessKey, getSlideMapper());
			return slide;
		}catch(EmptyResultDataAccessException e){
			throw new SlideNotFoundException("Slide("+accessKey+") is not found!");
		}

	}

	
	

	protected Slide loadInternalSlide(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Slide slide = extractSlide(accessKey, loadOptions);
 	
 		if(isExtractPageEnabled(loadOptions)){
	 		extractPage(slide, loadOptions);
 		}
 
		
		return slide;
		
	}

	 

 	protected Slide extractPage(Slide slide, Map<String,Object> options) throws Exception{

		if(slide.getPage() == null){
			return slide;
		}
		String pageId = slide.getPage().getId();
		if( pageId == null){
			return slide;
		}
		Page page = getPageDAO().load(pageId,options);
		if(page != null){
			slide.setPage(page);
		}
		
 		
 		return slide;
 	}
 		
 
		
		
  	
 	public SmartList<Slide> findSlideByPage(String pageId,Map<String,Object> options){
 	
  		SmartList<Slide> resultList = queryWith(SlideTable.COLUMN_PAGE, pageId, options, getSlideMapper());
		// analyzeSlideByPage(resultList, pageId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Slide> findSlideByPage(String pageId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Slide> resultList =  queryWithRange(SlideTable.COLUMN_PAGE, pageId, options, getSlideMapper(), start, count);
 		//analyzeSlideByPage(resultList, pageId, options);
 		return resultList;
 		
 	}
 	public void analyzeSlideByPage(SmartList<Slide> resultList, String pageId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countSlideByPage(String pageId,Map<String,Object> options){

 		return countWith(SlideTable.COLUMN_PAGE, pageId, options);
 	}
 	@Override
	public Map<String, Integer> countSlideByPageIds(String[] ids, Map<String, Object> options) {
		return countWithIds(SlideTable.COLUMN_PAGE, ids, options);
	}
 	
 	
		
		
		

	

	protected Slide saveSlide(Slide  slide){
		
		if(!slide.isChanged()){
			return slide;
		}
		

		String SQL=this.getSaveSlideSQL(slide);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSlideParameters(slide);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		slide.incVersion();
		return slide;

	}
	public SmartList<Slide> saveSlideList(SmartList<Slide> slideList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSlideList(slideList);

		batchSlideCreate((List<Slide>)lists[CREATE_LIST_INDEX]);

		batchSlideUpdate((List<Slide>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(Slide slide:slideList){
			if(slide.isChanged()){
				slide.incVersion();
			}


		}


		return slideList;
	}

	public SmartList<Slide> removeSlideList(SmartList<Slide> slideList,Map<String,Object> options){


		super.removeList(slideList, options);

		return slideList;


	}

	protected List<Object[]> prepareSlideBatchCreateArgs(List<Slide> slideList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Slide slide:slideList ){
			Object [] parameters = prepareSlideCreateParameters(slide);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareSlideBatchUpdateArgs(List<Slide> slideList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Slide slide:slideList ){
			if(!slide.isChanged()){
				continue;
			}
			Object [] parameters = prepareSlideUpdateParameters(slide);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchSlideCreate(List<Slide> slideList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSlideBatchCreateArgs(slideList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchSlideUpdate(List<Slide> slideList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSlideBatchUpdateArgs(slideList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitSlideList(List<Slide> slideList){

		List<Slide> slideCreateList=new ArrayList<Slide>();
		List<Slide> slideUpdateList=new ArrayList<Slide>();

		for(Slide slide: slideList){
			if(isUpdateRequest(slide)){
				slideUpdateList.add( slide);
				continue;
			}
			slideCreateList.add(slide);
		}

		return new Object[]{slideCreateList,slideUpdateList};
	}

	protected boolean isUpdateRequest(Slide slide){
 		return slide.getVersion() > 0;
 	}
 	protected String getSaveSlideSQL(Slide slide){
 		if(isUpdateRequest(slide)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveSlideParameters(Slide slide){
 		if(isUpdateRequest(slide) ){
 			return prepareSlideUpdateParameters(slide);
 		}
 		return prepareSlideCreateParameters(slide);
 	}
 	protected Object[] prepareSlideUpdateParameters(Slide slide){
 		Object[] parameters = new Object[9];
 
 		
 		parameters[0] = slide.getName();
 		
 		
 		parameters[1] = slide.getDisplayOrder();
 		
 		
 		parameters[2] = slide.getImageUrl();
 		
 		
 		parameters[3] = slide.getVideoUrl();
 		
 		
 		parameters[4] = slide.getLinkToUrl();
 		
 		if(slide.getPage() != null){
 			parameters[5] = slide.getPage().getId();
 		}
 
 		parameters[6] = slide.nextVersion();
 		parameters[7] = slide.getId();
 		parameters[8] = slide.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareSlideCreateParameters(Slide slide){
		Object[] parameters = new Object[7];
        if(slide.getId() == null){
          String newSlideId=getNextId();
          slide.setId(newSlideId);
        }
		parameters[0] =  slide.getId();
 
 		
 		parameters[1] = slide.getName();
 		
 		
 		parameters[2] = slide.getDisplayOrder();
 		
 		
 		parameters[3] = slide.getImageUrl();
 		
 		
 		parameters[4] = slide.getVideoUrl();
 		
 		
 		parameters[5] = slide.getLinkToUrl();
 		
 		if(slide.getPage() != null){
 			parameters[6] = slide.getPage().getId();

 		}
 		

 		return parameters;
 	}

	protected Slide saveInternalSlide(Slide slide, Map<String,Object> options){

		saveSlide(slide);

 		if(isSavePageEnabled(options)){
	 		savePage(slide, options);
 		}
 
		
		return slide;

	}



	//======================================================================================
	

 	protected Slide savePage(Slide slide, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(slide.getPage() == null){
 			return slide;//do nothing when it is null
 		}

 		getPageDAO().save(slide.getPage(),options);
 		return slide;

 	}





 

	

		

	public Slide present(Slide slide,Map<String, Object> options){
	

		return slide;
	
	}
		

	

	protected String getTableName(){
		return SlideTable.TABLE_NAME;
	}



	public void enhanceList(List<Slide> slideList) {
		this.enhanceListInternal(slideList, this.getSlideMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Slide> slideList = ownerEntity.collectRefsWithType(Slide.INTERNAL_TYPE);
		this.enhanceList(slideList);

	}

	@Override
	public SmartList<Slide> findSlideWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getSlideMapper());

	}
	@Override
	public int countSlideWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countSlideWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<Slide> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getSlideMapper());
	}

  @Override
  public Stream<Slide> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getSlideMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateSlide executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateSlide result = new CandidateSlide();
		int pageNo = Math.max(1, query.getPageNo());
		result.setOwnerClass(TextUtil.toCamelCase(query.getOwnerType()));
		result.setOwnerId(query.getOwnerId());
		result.setFilterKey(query.getFilterKey());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase("displayName")));
		result.setGroupByFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase(query.getGroupBy())));

		SmartList candidateList = queryList(sql, parmeters);
		this.alias(candidateList);
		result.setCandidates(candidateList);
		int offSet = (pageNo - 1 ) * query.getPageSize();
		if (candidateList.size() > query.getPageSize()) {
			result.setTotalPage(pageNo+1);
		}else {
			result.setTotalPage(pageNo);
		}
		return result;
	}

	

}


