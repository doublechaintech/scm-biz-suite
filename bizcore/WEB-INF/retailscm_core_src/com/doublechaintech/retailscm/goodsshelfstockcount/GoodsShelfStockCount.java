
package com.doublechaintech.retailscm.goodsshelfstockcount;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
	
	public String getDisplayName(){
	
		String displayName = getTitle();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mTitle              ;
	protected		Date                	mCountTime          ;
	protected		String              	mSummary            ;
	protected		GoodsShelf          	mShelf              ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<StockCountIssueTrack>	mStockCountIssueTrackList;

	
		
	public 	GoodsShelfStockCount(){
		// lazy load for all the properties
	}
	public 	static GoodsShelfStockCount withId(String id){
		GoodsShelfStockCount goodsShelfStockCount = new GoodsShelfStockCount();
		goodsShelfStockCount.setId(id);
		goodsShelfStockCount.setVersion(Integer.MAX_VALUE);
		return goodsShelfStockCount;
	}
	public 	static GoodsShelfStockCount refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setShelf( null );

		this.changed = true;
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
    
    


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public GoodsShelfStockCount updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setTitle(String title){
		this.mTitle = trimString(title);;
	}
	public String getTitle(){
		return this.mTitle;
	}
	public GoodsShelfStockCount updateTitle(String title){
		this.mTitle = trimString(title);;
		this.changed = true;
		return this;
	}
	public void mergeTitle(String title){
		if(title != null) { setTitle(title);}
	}
	
	
	public void setCountTime(Date countTime){
		this.mCountTime = countTime;;
	}
	public Date getCountTime(){
		return this.mCountTime;
	}
	public GoodsShelfStockCount updateCountTime(Date countTime){
		this.mCountTime = countTime;;
		this.changed = true;
		return this;
	}
	public void mergeCountTime(Date countTime){
		setCountTime(countTime);
	}
	
	
	public void setSummary(String summary){
		this.mSummary = trimString(summary);;
	}
	public String getSummary(){
		return this.mSummary;
	}
	public GoodsShelfStockCount updateSummary(String summary){
		this.mSummary = trimString(summary);;
		this.changed = true;
		return this;
	}
	public void mergeSummary(String summary){
		if(summary != null) { setSummary(summary);}
	}
	
	
	public void setShelf(GoodsShelf shelf){
		this.mShelf = shelf;;
	}
	public GoodsShelf getShelf(){
		return this.mShelf;
	}
	public GoodsShelfStockCount updateShelf(GoodsShelf shelf){
		this.mShelf = shelf;;
		this.changed = true;
		return this;
	}
	public void mergeShelf(GoodsShelf shelf){
		if(shelf != null) { setShelf(shelf);}
	}
	
	
	public void clearShelf(){
		setShelf ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public GoodsShelfStockCount updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
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
	public  void setStockCountIssueTrackList(SmartList<StockCountIssueTrack> stockCountIssueTrackList){
		for( StockCountIssueTrack stockCountIssueTrack:stockCountIssueTrackList){
			stockCountIssueTrack.setStockCount(this);
		}

		this.mStockCountIssueTrackList = stockCountIssueTrackList;
		this.mStockCountIssueTrackList.setListInternalName (STOCK_COUNT_ISSUE_TRACK_LIST );
		
	}
	
	public  void addStockCountIssueTrack(StockCountIssueTrack stockCountIssueTrack){
		stockCountIssueTrack.setStockCount(this);
		getStockCountIssueTrackList().add(stockCountIssueTrack);
	}
	public  void addStockCountIssueTrackList(SmartList<StockCountIssueTrack> stockCountIssueTrackList){
		for( StockCountIssueTrack stockCountIssueTrack:stockCountIssueTrackList){
			stockCountIssueTrack.setStockCount(this);
		}
		getStockCountIssueTrackList().addAll(stockCountIssueTrackList);
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

