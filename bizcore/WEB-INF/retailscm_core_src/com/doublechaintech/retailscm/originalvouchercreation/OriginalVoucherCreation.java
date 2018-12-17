
package com.doublechaintech.retailscm.originalvouchercreation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.originalvoucher.OriginalVoucher;

@JsonSerialize(using = OriginalVoucherCreationSerializer.class)
public class OriginalVoucherCreation extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String COMMENTS_PROPERTY              = "comments"          ;
	public static final String MAKE_DATE_PROPERTY             = "makeDate"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String ORIGINAL_VOUCHER_LIST                    = "originalVoucherList";

	public static final String INTERNAL_TYPE="OriginalVoucherCreation";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getWho();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mWho                ;
	protected		String              	mComments           ;
	protected		Date                	mMakeDate           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<OriginalVoucher>	mOriginalVoucherList;
	
		
	public 	OriginalVoucherCreation(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	public 	OriginalVoucherCreation(String who, String comments, Date makeDate)
	{
		setWho(who);
		setComments(comments);
		setMakeDate(makeDate);

		this.mOriginalVoucherList = new SmartList<OriginalVoucher>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(WHO_PROPERTY.equals(property)){
			changeWhoProperty(newValueExpr);
		}
		if(COMMENTS_PROPERTY.equals(property)){
			changeCommentsProperty(newValueExpr);
		}
		if(MAKE_DATE_PROPERTY.equals(property)){
			changeMakeDateProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeWhoProperty(String newValueExpr){
		String oldValue = getWho();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateWho(newValue);
		this.onChangeProperty(WHO_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeCommentsProperty(String newValueExpr){
		String oldValue = getComments();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateComments(newValue);
		this.onChangeProperty(COMMENTS_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeMakeDateProperty(String newValueExpr){
		Date oldValue = getMakeDate();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateMakeDate(newValue);
		this.onChangeProperty(MAKE_DATE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public OriginalVoucherCreation updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setWho(String who){
		this.mWho = trimString(who);;
	}
	public String getWho(){
		return this.mWho;
	}
	public OriginalVoucherCreation updateWho(String who){
		this.mWho = trimString(who);;
		this.changed = true;
		return this;
	}
	
	
	public void setComments(String comments){
		this.mComments = trimString(comments);;
	}
	public String getComments(){
		return this.mComments;
	}
	public OriginalVoucherCreation updateComments(String comments){
		this.mComments = trimString(comments);;
		this.changed = true;
		return this;
	}
	
	
	public void setMakeDate(Date makeDate){
		this.mMakeDate = makeDate;;
	}
	public Date getMakeDate(){
		return this.mMakeDate;
	}
	public OriginalVoucherCreation updateMakeDate(Date makeDate){
		this.mMakeDate = makeDate;;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public OriginalVoucherCreation updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<OriginalVoucher> getOriginalVoucherList(){
		if(this.mOriginalVoucherList == null){
			this.mOriginalVoucherList = new SmartList<OriginalVoucher>();
			this.mOriginalVoucherList.setListInternalName (ORIGINAL_VOUCHER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mOriginalVoucherList;	
	}
	public  void setOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList){
		for( OriginalVoucher originalVoucher:originalVoucherList){
			originalVoucher.setCreation(this);
		}

		this.mOriginalVoucherList = originalVoucherList;
		this.mOriginalVoucherList.setListInternalName (ORIGINAL_VOUCHER_LIST );
		
	}
	
	public  void addOriginalVoucher(OriginalVoucher originalVoucher){
		originalVoucher.setCreation(this);
		getOriginalVoucherList().add(originalVoucher);
	}
	public  void addOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList){
		for( OriginalVoucher originalVoucher:originalVoucherList){
			originalVoucher.setCreation(this);
		}
		getOriginalVoucherList().addAll(originalVoucherList);
	}
	
	public  OriginalVoucher removeOriginalVoucher(OriginalVoucher originalVoucherIndex){
		
		int index = getOriginalVoucherList().indexOf(originalVoucherIndex);
        if(index < 0){
        	String message = "OriginalVoucher("+originalVoucherIndex.getId()+") with version='"+originalVoucherIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        OriginalVoucher originalVoucher = getOriginalVoucherList().get(index);        
        // originalVoucher.clearCreation(); //disconnect with Creation
        originalVoucher.clearFromAll(); //disconnect with Creation
		
		boolean result = getOriginalVoucherList().planToRemove(originalVoucher);
        if(!result){
        	String message = "OriginalVoucher("+originalVoucherIndex.getId()+") with version='"+originalVoucherIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return originalVoucher;
        
	
	}
	//断舍离
	public  void breakWithOriginalVoucher(OriginalVoucher originalVoucher){
		
		if(originalVoucher == null){
			return;
		}
		originalVoucher.setCreation(null);
		//getOriginalVoucherList().remove();
	
	}
	
	public  boolean hasOriginalVoucher(OriginalVoucher originalVoucher){
	
		return getOriginalVoucherList().contains(originalVoucher);
  
	}
	
	public void copyOriginalVoucherFrom(OriginalVoucher originalVoucher) {

		OriginalVoucher originalVoucherInList = findTheOriginalVoucher(originalVoucher);
		OriginalVoucher newOriginalVoucher = new OriginalVoucher();
		originalVoucherInList.copyTo(newOriginalVoucher);
		newOriginalVoucher.setVersion(0);//will trigger copy
		getOriginalVoucherList().add(newOriginalVoucher);
		addItemToFlexiableObject(COPIED_CHILD, newOriginalVoucher);
	}
	
	public  OriginalVoucher findTheOriginalVoucher(OriginalVoucher originalVoucher){
		
		int index =  getOriginalVoucherList().indexOf(originalVoucher);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "OriginalVoucher("+originalVoucher.getId()+") with version='"+originalVoucher.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getOriginalVoucherList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpOriginalVoucherList(){
		getOriginalVoucherList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getOriginalVoucherList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getOriginalVoucherList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, WHO_PROPERTY, getWho());
		appendKeyValuePair(result, COMMENTS_PROPERTY, getComments());
		appendKeyValuePair(result, MAKE_DATE_PROPERTY, getMakeDate());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, ORIGINAL_VOUCHER_LIST, getOriginalVoucherList());
		if(!getOriginalVoucherList().isEmpty()){
			appendKeyValuePair(result, "originalVoucherCount", getOriginalVoucherList().getTotalCount());
			appendKeyValuePair(result, "originalVoucherCurrentPageNumber", getOriginalVoucherList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof OriginalVoucherCreation){
		
		
			OriginalVoucherCreation dest =(OriginalVoucherCreation)baseDest;
		
			dest.setId(getId());
			dest.setWho(getWho());
			dest.setComments(getComments());
			dest.setMakeDate(getMakeDate());
			dest.setVersion(getVersion());
			dest.setOriginalVoucherList(getOriginalVoucherList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("OriginalVoucherCreation{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\tcomments='"+getComments()+"';");
		stringBuilder.append("\tmakeDate='"+getMakeDate()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

