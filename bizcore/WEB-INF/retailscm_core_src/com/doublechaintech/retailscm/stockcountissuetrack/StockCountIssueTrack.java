
package com.doublechaintech.retailscm.stockcountissuetrack;

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
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;









@JsonSerialize(using = StockCountIssueTrackSerializer.class)
public class StockCountIssueTrack extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String COUNT_TIME_PROPERTY            = "countTime"         ;
	public static final String SUMMARY_PROPERTY               = "summary"           ;
	public static final String STOCK_COUNT_PROPERTY           = "stockCount"        ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="StockCountIssueTrack";
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
	protected		GoodsShelfStockCount	mStockCount         ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	StockCountIssueTrack(){
		// lazy load for all the properties
	}
	public 	static StockCountIssueTrack withId(String id){
		StockCountIssueTrack stockCountIssueTrack = new StockCountIssueTrack();
		stockCountIssueTrack.setId(id);
		stockCountIssueTrack.setVersion(Integer.MAX_VALUE);
		return stockCountIssueTrack;
	}
	public 	static StockCountIssueTrack refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setStockCount( null );

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
		if(STOCK_COUNT_PROPERTY.equals(property)){
			return getStockCount();
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
	public StockCountIssueTrack updateId(String id){
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
	public StockCountIssueTrack updateTitle(String title){
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
	public StockCountIssueTrack updateCountTime(Date countTime){
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
	public StockCountIssueTrack updateSummary(String summary){
		this.mSummary = trimString(summary);;
		this.changed = true;
		return this;
	}
	public void mergeSummary(String summary){
		if(summary != null) { setSummary(summary);}
	}
	
	
	public void setStockCount(GoodsShelfStockCount stockCount){
		this.mStockCount = stockCount;;
	}
	public GoodsShelfStockCount getStockCount(){
		return this.mStockCount;
	}
	public StockCountIssueTrack updateStockCount(GoodsShelfStockCount stockCount){
		this.mStockCount = stockCount;;
		this.changed = true;
		return this;
	}
	public void mergeStockCount(GoodsShelfStockCount stockCount){
		if(stockCount != null) { setStockCount(stockCount);}
	}
	
	
	public void clearStockCount(){
		setStockCount ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public StockCountIssueTrack updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getStockCount(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, TITLE_PROPERTY, getTitle());
		appendKeyValuePair(result, COUNT_TIME_PROPERTY, getCountTime());
		appendKeyValuePair(result, SUMMARY_PROPERTY, getSummary());
		appendKeyValuePair(result, STOCK_COUNT_PROPERTY, getStockCount());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof StockCountIssueTrack){
		
		
			StockCountIssueTrack dest =(StockCountIssueTrack)baseDest;
		
			dest.setId(getId());
			dest.setTitle(getTitle());
			dest.setCountTime(getCountTime());
			dest.setSummary(getSummary());
			dest.setStockCount(getStockCount());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof StockCountIssueTrack){
		
			
			StockCountIssueTrack dest =(StockCountIssueTrack)baseDest;
		
			dest.mergeId(getId());
			dest.mergeTitle(getTitle());
			dest.mergeCountTime(getCountTime());
			dest.mergeSummary(getSummary());
			dest.mergeStockCount(getStockCount());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof StockCountIssueTrack){
		
			
			StockCountIssueTrack dest =(StockCountIssueTrack)baseDest;
		
			dest.mergeId(getId());
			dest.mergeTitle(getTitle());
			dest.mergeCountTime(getCountTime());
			dest.mergeSummary(getSummary());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getTitle(), getCountTime(), getSummary(), getStockCount(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("StockCountIssueTrack{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		stringBuilder.append("\tcountTime='"+getCountTime()+"';");
		stringBuilder.append("\tsummary='"+getSummary()+"';");
		if(getStockCount() != null ){
 			stringBuilder.append("\tstockCount='GoodsShelfStockCount("+getStockCount().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

