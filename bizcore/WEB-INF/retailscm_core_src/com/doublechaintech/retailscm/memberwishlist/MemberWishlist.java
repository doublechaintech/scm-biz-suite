
package com.doublechaintech.retailscm.memberwishlist;

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
import com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProduct;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;









@JsonSerialize(using = MemberWishlistSerializer.class)
public class MemberWishlist extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String MEMBER_WISHLIST_PRODUCT_LIST             = "memberWishlistProductList";

	public static final String INTERNAL_TYPE="MemberWishlist";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		RetailStoreMember   	mOwner              ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<MemberWishlistProduct>	mMemberWishlistProductList;

	
		
	public 	MemberWishlist(){
		// lazy load for all the properties
	}
	public 	static MemberWishlist withId(String id){
		MemberWishlist memberWishlist = new MemberWishlist();
		memberWishlist.setId(id);
		memberWishlist.setVersion(Integer.MAX_VALUE);
		return memberWishlist;
	}
	public 	static MemberWishlist refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setOwner( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
	
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateName(newValue);
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(OWNER_PROPERTY.equals(property)){
			return getOwner();
		}
		if(MEMBER_WISHLIST_PRODUCT_LIST.equals(property)){
			List<BaseEntity> list = getMemberWishlistProductList().stream().map(item->item).collect(Collectors.toList());
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
	public MemberWishlist updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public MemberWishlist updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setOwner(RetailStoreMember owner){
		this.mOwner = owner;;
	}
	public RetailStoreMember getOwner(){
		return this.mOwner;
	}
	public MemberWishlist updateOwner(RetailStoreMember owner){
		this.mOwner = owner;;
		this.changed = true;
		return this;
	}
	public void mergeOwner(RetailStoreMember owner){
		if(owner != null) { setOwner(owner);}
	}
	
	
	public void clearOwner(){
		setOwner ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public MemberWishlist updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<MemberWishlistProduct> getMemberWishlistProductList(){
		if(this.mMemberWishlistProductList == null){
			this.mMemberWishlistProductList = new SmartList<MemberWishlistProduct>();
			this.mMemberWishlistProductList.setListInternalName (MEMBER_WISHLIST_PRODUCT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mMemberWishlistProductList;	
	}
	public  void setMemberWishlistProductList(SmartList<MemberWishlistProduct> memberWishlistProductList){
		for( MemberWishlistProduct memberWishlistProduct:memberWishlistProductList){
			memberWishlistProduct.setOwner(this);
		}

		this.mMemberWishlistProductList = memberWishlistProductList;
		this.mMemberWishlistProductList.setListInternalName (MEMBER_WISHLIST_PRODUCT_LIST );
		
	}
	
	public  void addMemberWishlistProduct(MemberWishlistProduct memberWishlistProduct){
		memberWishlistProduct.setOwner(this);
		getMemberWishlistProductList().add(memberWishlistProduct);
	}
	public  void addMemberWishlistProductList(SmartList<MemberWishlistProduct> memberWishlistProductList){
		for( MemberWishlistProduct memberWishlistProduct:memberWishlistProductList){
			memberWishlistProduct.setOwner(this);
		}
		getMemberWishlistProductList().addAll(memberWishlistProductList);
	}
	public  void mergeMemberWishlistProductList(SmartList<MemberWishlistProduct> memberWishlistProductList){
		if(memberWishlistProductList==null){
			return;
		}
		if(memberWishlistProductList.isEmpty()){
			return;
		}
		addMemberWishlistProductList( memberWishlistProductList );
		
	}
	public  MemberWishlistProduct removeMemberWishlistProduct(MemberWishlistProduct memberWishlistProductIndex){
		
		int index = getMemberWishlistProductList().indexOf(memberWishlistProductIndex);
        if(index < 0){
        	String message = "MemberWishlistProduct("+memberWishlistProductIndex.getId()+") with version='"+memberWishlistProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        MemberWishlistProduct memberWishlistProduct = getMemberWishlistProductList().get(index);        
        // memberWishlistProduct.clearOwner(); //disconnect with Owner
        memberWishlistProduct.clearFromAll(); //disconnect with Owner
		
		boolean result = getMemberWishlistProductList().planToRemove(memberWishlistProduct);
        if(!result){
        	String message = "MemberWishlistProduct("+memberWishlistProductIndex.getId()+") with version='"+memberWishlistProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return memberWishlistProduct;
        
	
	}
	//断舍离
	public  void breakWithMemberWishlistProduct(MemberWishlistProduct memberWishlistProduct){
		
		if(memberWishlistProduct == null){
			return;
		}
		memberWishlistProduct.setOwner(null);
		//getMemberWishlistProductList().remove();
	
	}
	
	public  boolean hasMemberWishlistProduct(MemberWishlistProduct memberWishlistProduct){
	
		return getMemberWishlistProductList().contains(memberWishlistProduct);
  
	}
	
	public void copyMemberWishlistProductFrom(MemberWishlistProduct memberWishlistProduct) {

		MemberWishlistProduct memberWishlistProductInList = findTheMemberWishlistProduct(memberWishlistProduct);
		MemberWishlistProduct newMemberWishlistProduct = new MemberWishlistProduct();
		memberWishlistProductInList.copyTo(newMemberWishlistProduct);
		newMemberWishlistProduct.setVersion(0);//will trigger copy
		getMemberWishlistProductList().add(newMemberWishlistProduct);
		addItemToFlexiableObject(COPIED_CHILD, newMemberWishlistProduct);
	}
	
	public  MemberWishlistProduct findTheMemberWishlistProduct(MemberWishlistProduct memberWishlistProduct){
		
		int index =  getMemberWishlistProductList().indexOf(memberWishlistProduct);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "MemberWishlistProduct("+memberWishlistProduct.getId()+") with version='"+memberWishlistProduct.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getMemberWishlistProductList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpMemberWishlistProductList(){
		getMemberWishlistProductList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getOwner(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getMemberWishlistProductList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getMemberWishlistProductList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, OWNER_PROPERTY, getOwner());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, MEMBER_WISHLIST_PRODUCT_LIST, getMemberWishlistProductList());
		if(!getMemberWishlistProductList().isEmpty()){
			appendKeyValuePair(result, "memberWishlistProductCount", getMemberWishlistProductList().getTotalCount());
			appendKeyValuePair(result, "memberWishlistProductCurrentPageNumber", getMemberWishlistProductList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof MemberWishlist){
		
		
			MemberWishlist dest =(MemberWishlist)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setOwner(getOwner());
			dest.setVersion(getVersion());
			dest.setMemberWishlistProductList(getMemberWishlistProductList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof MemberWishlist){
		
			
			MemberWishlist dest =(MemberWishlist)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeOwner(getOwner());
			dest.mergeVersion(getVersion());
			dest.mergeMemberWishlistProductList(getMemberWishlistProductList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof MemberWishlist){
		
			
			MemberWishlist dest =(MemberWishlist)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getOwner(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("MemberWishlist{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='RetailStoreMember("+getOwner().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

