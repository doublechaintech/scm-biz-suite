
package com.doublechaintech.retailscm.originalvoucher;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;

@JsonSerialize(using = OriginalVoucherSerializer.class)
public class OriginalVoucher extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String MADE_BY_PROPERTY               = "madeBy"            ;
	public static final String RECEIVED_BY_PROPERTY           = "receivedBy"        ;
	public static final String VOUCHER_TYPE_PROPERTY          = "voucherType"       ;
	public static final String VOUCHER_IMAGE_PROPERTY         = "voucherImage"      ;
	public static final String BELONGS_TO_PROPERTY            = "belongsTo"         ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="OriginalVoucher";
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
	protected		String              	mMadeBy             ;
	protected		String              	mReceivedBy         ;
	protected		String              	mVoucherType        ;
	protected		String              	mVoucherImage       ;
	protected		AccountingDocument  	mBelongsTo          ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	OriginalVoucher(){
		// lazy load for all the properties
	}
	public 	static OriginalVoucher withId(String id){
		OriginalVoucher originalVoucher = new OriginalVoucher();
		originalVoucher.setId(id);
		originalVoucher.setVersion(Integer.MAX_VALUE);
		return originalVoucher;
	}
	public 	static OriginalVoucher refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setBelongsTo( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}
		if(MADE_BY_PROPERTY.equals(property)){
			changeMadeByProperty(newValueExpr);
		}
		if(RECEIVED_BY_PROPERTY.equals(property)){
			changeReceivedByProperty(newValueExpr);
		}
		if(VOUCHER_TYPE_PROPERTY.equals(property)){
			changeVoucherTypeProperty(newValueExpr);
		}
		if(VOUCHER_IMAGE_PROPERTY.equals(property)){
			changeVoucherImageProperty(newValueExpr);
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
			
			
			
	protected void changeMadeByProperty(String newValueExpr){
	
		String oldValue = getMadeBy();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateMadeBy(newValue);
		this.onChangeProperty(MADE_BY_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeReceivedByProperty(String newValueExpr){
	
		String oldValue = getReceivedBy();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateReceivedBy(newValue);
		this.onChangeProperty(RECEIVED_BY_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeVoucherTypeProperty(String newValueExpr){
	
		String oldValue = getVoucherType();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateVoucherType(newValue);
		this.onChangeProperty(VOUCHER_TYPE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeVoucherImageProperty(String newValueExpr){
	
		String oldValue = getVoucherImage();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateVoucherImage(newValue);
		this.onChangeProperty(VOUCHER_IMAGE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(TITLE_PROPERTY.equals(property)){
			return getTitle();
		}
		if(MADE_BY_PROPERTY.equals(property)){
			return getMadeBy();
		}
		if(RECEIVED_BY_PROPERTY.equals(property)){
			return getReceivedBy();
		}
		if(VOUCHER_TYPE_PROPERTY.equals(property)){
			return getVoucherType();
		}
		if(VOUCHER_IMAGE_PROPERTY.equals(property)){
			return getVoucherImage();
		}
		if(BELONGS_TO_PROPERTY.equals(property)){
			return getBelongsTo();
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
	public OriginalVoucher updateId(String id){
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
	public OriginalVoucher updateTitle(String title){
		this.mTitle = trimString(title);;
		this.changed = true;
		return this;
	}
	public void mergeTitle(String title){
		if(title != null) { setTitle(title);}
	}
	
	
	public void setMadeBy(String madeBy){
		this.mMadeBy = trimString(madeBy);;
	}
	public String getMadeBy(){
		return this.mMadeBy;
	}
	public OriginalVoucher updateMadeBy(String madeBy){
		this.mMadeBy = trimString(madeBy);;
		this.changed = true;
		return this;
	}
	public void mergeMadeBy(String madeBy){
		if(madeBy != null) { setMadeBy(madeBy);}
	}
	
	
	public void setReceivedBy(String receivedBy){
		this.mReceivedBy = trimString(receivedBy);;
	}
	public String getReceivedBy(){
		return this.mReceivedBy;
	}
	public OriginalVoucher updateReceivedBy(String receivedBy){
		this.mReceivedBy = trimString(receivedBy);;
		this.changed = true;
		return this;
	}
	public void mergeReceivedBy(String receivedBy){
		if(receivedBy != null) { setReceivedBy(receivedBy);}
	}
	
	
	public void setVoucherType(String voucherType){
		this.mVoucherType = trimString(voucherType);;
	}
	public String getVoucherType(){
		return this.mVoucherType;
	}
	public OriginalVoucher updateVoucherType(String voucherType){
		this.mVoucherType = trimString(voucherType);;
		this.changed = true;
		return this;
	}
	public void mergeVoucherType(String voucherType){
		if(voucherType != null) { setVoucherType(voucherType);}
	}
	
	
	public void setVoucherImage(String voucherImage){
		this.mVoucherImage = trimString(encodeUrl(voucherImage));;
	}
	public String getVoucherImage(){
		return this.mVoucherImage;
	}
	public OriginalVoucher updateVoucherImage(String voucherImage){
		this.mVoucherImage = trimString(encodeUrl(voucherImage));;
		this.changed = true;
		return this;
	}
	public void mergeVoucherImage(String voucherImage){
		if(voucherImage != null) { setVoucherImage(voucherImage);}
	}
	
	
	public void setBelongsTo(AccountingDocument belongsTo){
		this.mBelongsTo = belongsTo;;
	}
	public AccountingDocument getBelongsTo(){
		return this.mBelongsTo;
	}
	public OriginalVoucher updateBelongsTo(AccountingDocument belongsTo){
		this.mBelongsTo = belongsTo;;
		this.changed = true;
		return this;
	}
	public void mergeBelongsTo(AccountingDocument belongsTo){
		if(belongsTo != null) { setBelongsTo(belongsTo);}
	}
	
	
	public void clearBelongsTo(){
		setBelongsTo ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public OriginalVoucher updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getBelongsTo(), internalType);

		
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
		appendKeyValuePair(result, MADE_BY_PROPERTY, getMadeBy());
		appendKeyValuePair(result, RECEIVED_BY_PROPERTY, getReceivedBy());
		appendKeyValuePair(result, VOUCHER_TYPE_PROPERTY, getVoucherType());
		appendKeyValuePair(result, VOUCHER_IMAGE_PROPERTY, getVoucherImage());
		appendKeyValuePair(result, BELONGS_TO_PROPERTY, getBelongsTo());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof OriginalVoucher){
		
		
			OriginalVoucher dest =(OriginalVoucher)baseDest;
		
			dest.setId(getId());
			dest.setTitle(getTitle());
			dest.setMadeBy(getMadeBy());
			dest.setReceivedBy(getReceivedBy());
			dest.setVoucherType(getVoucherType());
			dest.setVoucherImage(getVoucherImage());
			dest.setBelongsTo(getBelongsTo());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof OriginalVoucher){
		
			
			OriginalVoucher dest =(OriginalVoucher)baseDest;
		
			dest.mergeId(getId());
			dest.mergeTitle(getTitle());
			dest.mergeMadeBy(getMadeBy());
			dest.mergeReceivedBy(getReceivedBy());
			dest.mergeVoucherType(getVoucherType());
			dest.mergeVoucherImage(getVoucherImage());
			dest.mergeBelongsTo(getBelongsTo());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof OriginalVoucher){
		
			
			OriginalVoucher dest =(OriginalVoucher)baseDest;
		
			dest.mergeId(getId());
			dest.mergeTitle(getTitle());
			dest.mergeMadeBy(getMadeBy());
			dest.mergeReceivedBy(getReceivedBy());
			dest.mergeVoucherType(getVoucherType());
			dest.mergeVoucherImage(getVoucherImage());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getTitle(), getMadeBy(), getReceivedBy(), getVoucherType(), getVoucherImage(), getBelongsTo(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("OriginalVoucher{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		stringBuilder.append("\tmadeBy='"+getMadeBy()+"';");
		stringBuilder.append("\treceivedBy='"+getReceivedBy()+"';");
		stringBuilder.append("\tvoucherType='"+getVoucherType()+"';");
		stringBuilder.append("\tvoucherImage='"+getVoucherImage()+"';");
		if(getBelongsTo() != null ){
 			stringBuilder.append("\tbelongsTo='AccountingDocument("+getBelongsTo().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

