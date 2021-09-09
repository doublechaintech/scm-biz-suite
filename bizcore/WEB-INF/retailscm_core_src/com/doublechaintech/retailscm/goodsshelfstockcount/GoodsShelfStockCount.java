
package com.doublechaintech.retailscm.goodsshelfstockcount;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;
import com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrack;









@JsonSerialize(using = GoodsShelfStockCountSerializer.class)
public class GoodsShelfStockCount extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String COUNT_TIME_PROPERTY            = "countTime"         ;
	public static final String SUMMARY_PROPERTY               = "summary"           ;
	public static final String SHELF_PROPERTY                 = "shelf"             ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String STOCK_COUNT_ISSUE_TRACK_LIST             = "stockCountIssueTrackList";

	public static final String INTERNAL_TYPE="GoodsShelfStockCount";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(TITLE_PROPERTY, "title", "头衔")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(COUNT_TIME_PROPERTY, "count_time", "计数时间")
        .withType("date", Date.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(SUMMARY_PROPERTY, "summary", "概览")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(SHELF_PROPERTY, "goods_shelf", "架")
        .withType("goods_shelf", GoodsShelf.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(STOCK_COUNT_ISSUE_TRACK_LIST, "stockCount", "盘点发行跟踪清单")
        .withType("stock_count_issue_track", StockCountIssueTrack.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,TITLE_PROPERTY ,COUNT_TIME_PROPERTY ,SUMMARY_PROPERTY ,SHELF_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(STOCK_COUNT_ISSUE_TRACK_LIST, "stockCount");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(STOCK_COUNT_ISSUE_TRACK_LIST, StockCountIssueTrack.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(SHELF_PROPERTY, GoodsShelf.class);

    return parents;
  }

  public GoodsShelfStockCount want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public GoodsShelfStockCount wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getTitle();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		String              	title               ;
	protected		Date                	countTime           ;
	protected		String              	summary             ;
	protected		GoodsShelf          	shelf               ;
	protected		int                 	version             ;

	
	protected		SmartList<StockCountIssueTrack>	mStockCountIssueTrackList;



	public 	GoodsShelfStockCount(){
		// lazy load for all the properties
	}
	public 	static GoodsShelfStockCount withId(String id){
		GoodsShelfStockCount goodsShelfStockCount = new GoodsShelfStockCount();
		goodsShelfStockCount.setId(id);
		goodsShelfStockCount.setVersion(Integer.MAX_VALUE);
		goodsShelfStockCount.setChecked(true);
		return goodsShelfStockCount;
	}
	public 	static GoodsShelfStockCount refById(String id){
		return withId(id);
	}

  public GoodsShelfStockCount limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public GoodsShelfStockCount limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static GoodsShelfStockCount searchExample(){
    GoodsShelfStockCount goodsShelfStockCount = new GoodsShelfStockCount();
    		goodsShelfStockCount.setVersion(UNSET_INT);

    return goodsShelfStockCount;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setShelf( null );

		this.changed = true;
		setChecked(false);
	}
	

	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}
		if(COUNT_TIME_PROPERTY.equals(property)){
			changeCountTimeProperty(newValueExpr);
		}
		if(SUMMARY_PROPERTY.equals(property)){
			changeSummaryProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeTitleProperty(String newValueExpr){
	
		String oldValue = getTitle();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateTitle(newValue);
		this.onChangeProperty(TITLE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeCountTimeProperty(String newValueExpr){
	
		Date oldValue = getCountTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCountTime(newValue);
		this.onChangeProperty(COUNT_TIME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeSummaryProperty(String newValueExpr){
	
		String oldValue = getSummary();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateSummary(newValue);
		this.onChangeProperty(SUMMARY_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {

		if(TITLE_PROPERTY.equals(property)){
			return getTitle();
		}
		if(COUNT_TIME_PROPERTY.equals(property)){
			return getCountTime();
		}
		if(SUMMARY_PROPERTY.equals(property)){
			return getSummary();
		}
		if(SHELF_PROPERTY.equals(property)){
			return getShelf();
		}
		if(STOCK_COUNT_ISSUE_TRACK_LIST.equals(property)){
			List<BaseEntity> list = getStockCountIssueTrackList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}

    		//other property not include here
		return super.propertyOf(property);
	}

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public GoodsShelfStockCount updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public GoodsShelfStockCount orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public GoodsShelfStockCount ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public GoodsShelfStockCount addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setTitle(String title){String oldTitle = this.title;String newTitle = trimString(title);this.title = newTitle;}
	public String title(){
doLoad();
return getTitle();
}
	public String getTitle(){
		return this.title;
	}
	public GoodsShelfStockCount updateTitle(String title){String oldTitle = this.title;String newTitle = trimString(title);if(!shouldReplaceBy(newTitle, oldTitle)){return this;}this.title = newTitle;addPropertyChange(TITLE_PROPERTY, oldTitle, newTitle);this.changed = true;setChecked(false);return this;}
	public GoodsShelfStockCount orderByTitle(boolean asc){
doAddOrderBy(TITLE_PROPERTY, asc);
return this;
}
	public SearchCriteria createTitleCriteria(QueryOperator operator, Object... parameters){
return createCriteria(TITLE_PROPERTY, operator, parameters);
}
	public GoodsShelfStockCount ignoreTitleCriteria(){super.ignoreSearchProperty(TITLE_PROPERTY);
return this;
}
	public GoodsShelfStockCount addTitleCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createTitleCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeTitle(String title){
		if(title != null) { setTitle(title);}
	}

	
	public void setCountTime(Date countTime){Date oldCountTime = this.countTime;Date newCountTime = countTime;this.countTime = newCountTime;}
	public Date countTime(){
doLoad();
return getCountTime();
}
	public Date getCountTime(){
		return this.countTime;
	}
	public GoodsShelfStockCount updateCountTime(Date countTime){Date oldCountTime = this.countTime;Date newCountTime = countTime;if(!shouldReplaceBy(newCountTime, oldCountTime)){return this;}this.countTime = newCountTime;addPropertyChange(COUNT_TIME_PROPERTY, oldCountTime, newCountTime);this.changed = true;setChecked(false);return this;}
	public GoodsShelfStockCount orderByCountTime(boolean asc){
doAddOrderBy(COUNT_TIME_PROPERTY, asc);
return this;
}
	public SearchCriteria createCountTimeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(COUNT_TIME_PROPERTY, operator, parameters);
}
	public GoodsShelfStockCount ignoreCountTimeCriteria(){super.ignoreSearchProperty(COUNT_TIME_PROPERTY);
return this;
}
	public GoodsShelfStockCount addCountTimeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createCountTimeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeCountTime(Date countTime){
		setCountTime(countTime);
	}

	
	public void setSummary(String summary){String oldSummary = this.summary;String newSummary = trimString(summary);this.summary = newSummary;}
	public String summary(){
doLoad();
return getSummary();
}
	public String getSummary(){
		return this.summary;
	}
	public GoodsShelfStockCount updateSummary(String summary){String oldSummary = this.summary;String newSummary = trimString(summary);if(!shouldReplaceBy(newSummary, oldSummary)){return this;}this.summary = newSummary;addPropertyChange(SUMMARY_PROPERTY, oldSummary, newSummary);this.changed = true;setChecked(false);return this;}
	public GoodsShelfStockCount orderBySummary(boolean asc){
doAddOrderBy(SUMMARY_PROPERTY, asc);
return this;
}
	public SearchCriteria createSummaryCriteria(QueryOperator operator, Object... parameters){
return createCriteria(SUMMARY_PROPERTY, operator, parameters);
}
	public GoodsShelfStockCount ignoreSummaryCriteria(){super.ignoreSearchProperty(SUMMARY_PROPERTY);
return this;
}
	public GoodsShelfStockCount addSummaryCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createSummaryCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeSummary(String summary){
		if(summary != null) { setSummary(summary);}
	}

	
	public void setShelf(GoodsShelf shelf){GoodsShelf oldShelf = this.shelf;GoodsShelf newShelf = shelf;this.shelf = newShelf;}
	public GoodsShelf shelf(){
doLoad();
return getShelf();
}
	public GoodsShelf getShelf(){
		return this.shelf;
	}
	public GoodsShelfStockCount updateShelf(GoodsShelf shelf){GoodsShelf oldShelf = this.shelf;GoodsShelf newShelf = shelf;if(!shouldReplaceBy(newShelf, oldShelf)){return this;}this.shelf = newShelf;addPropertyChange(SHELF_PROPERTY, oldShelf, newShelf);this.changed = true;setChecked(false);return this;}
	public GoodsShelfStockCount orderByShelf(boolean asc){
doAddOrderBy(SHELF_PROPERTY, asc);
return this;
}
	public SearchCriteria createShelfCriteria(QueryOperator operator, Object... parameters){
return createCriteria(SHELF_PROPERTY, operator, parameters);
}
	public GoodsShelfStockCount ignoreShelfCriteria(){super.ignoreSearchProperty(SHELF_PROPERTY);
return this;
}
	public GoodsShelfStockCount addShelfCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createShelfCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeShelf(GoodsShelf shelf){
		if(shelf != null) { setShelf(shelf);}
	}

	
	public void clearShelf(){
		setShelf ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public GoodsShelfStockCount updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public GoodsShelfStockCount orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public GoodsShelfStockCount ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public GoodsShelfStockCount addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public  SmartList<StockCountIssueTrack> getStockCountIssueTrackList(){
		if(this.mStockCountIssueTrackList == null){
			this.mStockCountIssueTrackList = new SmartList<StockCountIssueTrack>();
			this.mStockCountIssueTrackList.setListInternalName (STOCK_COUNT_ISSUE_TRACK_LIST );
			//有名字，便于做权限控制
		}

		return this.mStockCountIssueTrackList;
	}

  public  SmartList<StockCountIssueTrack> stockCountIssueTrackList(){
    
    doLoadChild(STOCK_COUNT_ISSUE_TRACK_LIST);
    
    return getStockCountIssueTrackList();
  }


	public  void setStockCountIssueTrackList(SmartList<StockCountIssueTrack> stockCountIssueTrackList){
		for( StockCountIssueTrack stockCountIssueTrack:stockCountIssueTrackList){
			stockCountIssueTrack.setStockCount(this);
		}

		this.mStockCountIssueTrackList = stockCountIssueTrackList;
		this.mStockCountIssueTrackList.setListInternalName (STOCK_COUNT_ISSUE_TRACK_LIST );

	}

	public  GoodsShelfStockCount addStockCountIssueTrack(StockCountIssueTrack stockCountIssueTrack){
		stockCountIssueTrack.setStockCount(this);
		getStockCountIssueTrackList().add(stockCountIssueTrack);
		return this;
	}
	public  GoodsShelfStockCount addStockCountIssueTrackList(SmartList<StockCountIssueTrack> stockCountIssueTrackList){
		for( StockCountIssueTrack stockCountIssueTrack:stockCountIssueTrackList){
			stockCountIssueTrack.setStockCount(this);
		}
		getStockCountIssueTrackList().addAll(stockCountIssueTrackList);
		return this;
	}
	public  void mergeStockCountIssueTrackList(SmartList<StockCountIssueTrack> stockCountIssueTrackList){
		if(stockCountIssueTrackList==null){
			return;
		}
		if(stockCountIssueTrackList.isEmpty()){
			return;
		}
		addStockCountIssueTrackList( stockCountIssueTrackList );

	}
	public  StockCountIssueTrack removeStockCountIssueTrack(StockCountIssueTrack stockCountIssueTrackIndex){

		int index = getStockCountIssueTrackList().indexOf(stockCountIssueTrackIndex);
        if(index < 0){
        	String message = "StockCountIssueTrack("+stockCountIssueTrackIndex.getId()+") with version='"+stockCountIssueTrackIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        StockCountIssueTrack stockCountIssueTrack = getStockCountIssueTrackList().get(index);
        // stockCountIssueTrack.clearStockCount(); //disconnect with StockCount
        stockCountIssueTrack.clearFromAll(); //disconnect with StockCount

		boolean result = getStockCountIssueTrackList().planToRemove(stockCountIssueTrack);
        if(!result){
        	String message = "StockCountIssueTrack("+stockCountIssueTrackIndex.getId()+") with version='"+stockCountIssueTrackIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return stockCountIssueTrack;


	}
	//断舍离
	public  void breakWithStockCountIssueTrack(StockCountIssueTrack stockCountIssueTrack){

		if(stockCountIssueTrack == null){
			return;
		}
		stockCountIssueTrack.setStockCount(null);
		//getStockCountIssueTrackList().remove();

	}

	public  boolean hasStockCountIssueTrack(StockCountIssueTrack stockCountIssueTrack){

		return getStockCountIssueTrackList().contains(stockCountIssueTrack);

	}

	public void copyStockCountIssueTrackFrom(StockCountIssueTrack stockCountIssueTrack) {

		StockCountIssueTrack stockCountIssueTrackInList = findTheStockCountIssueTrack(stockCountIssueTrack);
		StockCountIssueTrack newStockCountIssueTrack = new StockCountIssueTrack();
		stockCountIssueTrackInList.copyTo(newStockCountIssueTrack);
		newStockCountIssueTrack.setVersion(0);//will trigger copy
		getStockCountIssueTrackList().add(newStockCountIssueTrack);
		addItemToFlexiableObject(COPIED_CHILD, newStockCountIssueTrack);
	}

	public  StockCountIssueTrack findTheStockCountIssueTrack(StockCountIssueTrack stockCountIssueTrack){

		int index =  getStockCountIssueTrackList().indexOf(stockCountIssueTrack);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "StockCountIssueTrack("+stockCountIssueTrack.getId()+") with version='"+stockCountIssueTrack.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getStockCountIssueTrackList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpStockCountIssueTrackList(){
		getStockCountIssueTrackList().clear();
	}





	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getShelf(), internalType);


	}

	public List<BaseEntity>  collectRefercencesFromLists(String internalType){

		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getStockCountIssueTrackList(), internalType);

		return entityList;
	}

	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

		listOfList.add( getStockCountIssueTrackList());


		return listOfList;
	}


	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, TITLE_PROPERTY, getTitle());
		appendKeyValuePair(result, COUNT_TIME_PROPERTY, getCountTime());
		appendKeyValuePair(result, SUMMARY_PROPERTY, getSummary());
		appendKeyValuePair(result, SHELF_PROPERTY, getShelf());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, STOCK_COUNT_ISSUE_TRACK_LIST, getStockCountIssueTrackList());
		if(!getStockCountIssueTrackList().isEmpty()){
			appendKeyValuePair(result, "stockCountIssueTrackCount", getStockCountIssueTrackList().getTotalCount());
			appendKeyValuePair(result, "stockCountIssueTrackCurrentPageNumber", getStockCountIssueTrackList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof GoodsShelfStockCount){


			GoodsShelfStockCount dest =(GoodsShelfStockCount)baseDest;

			dest.setId(getId());
			dest.setTitle(getTitle());
			dest.setCountTime(getCountTime());
			dest.setSummary(getSummary());
			dest.setShelf(getShelf());
			dest.setVersion(getVersion());
			dest.setStockCountIssueTrackList(getStockCountIssueTrackList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof GoodsShelfStockCount){


			GoodsShelfStockCount dest =(GoodsShelfStockCount)baseDest;

			dest.mergeId(getId());
			dest.mergeTitle(getTitle());
			dest.mergeCountTime(getCountTime());
			dest.mergeSummary(getSummary());
			dest.mergeShelf(getShelf());
			dest.mergeVersion(getVersion());
			dest.mergeStockCountIssueTrackList(getStockCountIssueTrackList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof GoodsShelfStockCount){


			GoodsShelfStockCount dest =(GoodsShelfStockCount)baseDest;

			dest.mergeId(getId());
			dest.mergeTitle(getTitle());
			dest.mergeCountTime(getCountTime());
			dest.mergeSummary(getSummary());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getTitle(), getCountTime(), getSummary(), getShelf(), getVersion()};
	}


	public static GoodsShelfStockCount createWith(RetailscmUserContext userContext, ThrowingFunction<GoodsShelfStockCount,GoodsShelfStockCount,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<GoodsShelfStockCount> customCreator = mapper.findCustomCreator(GoodsShelfStockCount.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    GoodsShelfStockCount result = new GoodsShelfStockCount();
    result.setTitle(mapper.tryToGet(GoodsShelfStockCount.class, TITLE_PROPERTY, String.class,
        0, false, result.getTitle(), params));
    result.setCountTime(mapper.tryToGet(GoodsShelfStockCount.class, COUNT_TIME_PROPERTY, Date.class,
        0, true, result.getCountTime(), params));
    result.setSummary(mapper.tryToGet(GoodsShelfStockCount.class, SUMMARY_PROPERTY, String.class,
        1, false, result.getSummary(), params));
    result.setShelf(mapper.tryToGet(GoodsShelfStockCount.class, SHELF_PROPERTY, GoodsShelf.class,
        0, true, result.getShelf(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixGoodsShelfStockCount(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      GoodsShelfStockCountTokens tokens = mapper.findParamByClass(params, GoodsShelfStockCountTokens.class);
      if (tokens == null) {
        tokens = GoodsShelfStockCountTokens.start();
      }
      result = userContext.getManagerGroup().getGoodsShelfStockCountManager().internalSaveGoodsShelfStockCount(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("GoodsShelfStockCount{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		stringBuilder.append("\tcountTime='"+getCountTime()+"';");
		stringBuilder.append("\tsummary='"+getSummary()+"';");
		if(getShelf() != null ){
 			stringBuilder.append("\tshelf='GoodsShelf("+getShelf().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

