
package com.doublechaintech.retailscm.memberwishlist;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
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


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(OWNER_PROPERTY, "retail_store_member", "业主")
        .withType("retail_store_member", RetailStoreMember.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(MEMBER_WISHLIST_PRODUCT_LIST, "owner", "会员愿望列表产品列表")
        .withType("member_wishlist_product", MemberWishlistProduct.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NAME_PROPERTY ,OWNER_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(MEMBER_WISHLIST_PRODUCT_LIST, "owner");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(MEMBER_WISHLIST_PRODUCT_LIST, MemberWishlistProduct.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(OWNER_PROPERTY, RetailStoreMember.class);

    return parents;
  }

  public MemberWishlist want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public MemberWishlist wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		String              	name                ;
	protected		RetailStoreMember   	owner               ;
	protected		int                 	version             ;

	
	protected		SmartList<MemberWishlistProduct>	mMemberWishlistProductList;



	public 	MemberWishlist(){
		// lazy load for all the properties
	}
	public 	static MemberWishlist withId(String id){
		MemberWishlist memberWishlist = new MemberWishlist();
		memberWishlist.setId(id);
		memberWishlist.setVersion(Integer.MAX_VALUE);
		memberWishlist.setChecked(true);
		return memberWishlist;
	}
	public 	static MemberWishlist refById(String id){
		return withId(id);
	}

  public MemberWishlist limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public MemberWishlist limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static MemberWishlist searchExample(){
    MemberWishlist memberWishlist = new MemberWishlist();
    		memberWishlist.setVersion(UNSET_INT);

    return memberWishlist;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setOwner( null );

		this.changed = true;
		setChecked(false);
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

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public MemberWishlist updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public MemberWishlist orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public MemberWishlist ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public MemberWishlist addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setName(String name){String oldName = this.name;String newName = trimString(name);this.name = newName;}
	public String name(){
doLoad();
return getName();
}
	public String getName(){
		return this.name;
	}
	public MemberWishlist updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public MemberWishlist orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public MemberWishlist ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public MemberWishlist addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}

	
	public void setOwner(RetailStoreMember owner){RetailStoreMember oldOwner = this.owner;RetailStoreMember newOwner = owner;this.owner = newOwner;}
	public RetailStoreMember owner(){
doLoad();
return getOwner();
}
	public RetailStoreMember getOwner(){
		return this.owner;
	}
	public MemberWishlist updateOwner(RetailStoreMember owner){RetailStoreMember oldOwner = this.owner;RetailStoreMember newOwner = owner;if(!shouldReplaceBy(newOwner, oldOwner)){return this;}this.owner = newOwner;addPropertyChange(OWNER_PROPERTY, oldOwner, newOwner);this.changed = true;setChecked(false);return this;}
	public MemberWishlist orderByOwner(boolean asc){
doAddOrderBy(OWNER_PROPERTY, asc);
return this;
}
	public SearchCriteria createOwnerCriteria(QueryOperator operator, Object... parameters){
return createCriteria(OWNER_PROPERTY, operator, parameters);
}
	public MemberWishlist ignoreOwnerCriteria(){super.ignoreSearchProperty(OWNER_PROPERTY);
return this;
}
	public MemberWishlist addOwnerCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createOwnerCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeOwner(RetailStoreMember owner){
		if(owner != null) { setOwner(owner);}
	}

	
	public void clearOwner(){
		setOwner ( null );
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
	public MemberWishlist updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public MemberWishlist orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public MemberWishlist ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public MemberWishlist addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
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

  public  SmartList<MemberWishlistProduct> memberWishlistProductList(){
    
    doLoadChild(MEMBER_WISHLIST_PRODUCT_LIST);
    
    return getMemberWishlistProductList();
  }


	public  void setMemberWishlistProductList(SmartList<MemberWishlistProduct> memberWishlistProductList){
		for( MemberWishlistProduct memberWishlistProduct:memberWishlistProductList){
			memberWishlistProduct.setOwner(this);
		}

		this.mMemberWishlistProductList = memberWishlistProductList;
		this.mMemberWishlistProductList.setListInternalName (MEMBER_WISHLIST_PRODUCT_LIST );

	}

	public  MemberWishlist addMemberWishlistProduct(MemberWishlistProduct memberWishlistProduct){
		memberWishlistProduct.setOwner(this);
		getMemberWishlistProductList().add(memberWishlistProduct);
		return this;
	}
	public  MemberWishlist addMemberWishlistProductList(SmartList<MemberWishlistProduct> memberWishlistProductList){
		for( MemberWishlistProduct memberWishlistProduct:memberWishlistProductList){
			memberWishlistProduct.setOwner(this);
		}
		getMemberWishlistProductList().addAll(memberWishlistProductList);
		return this;
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


	public static MemberWishlist createWith(RetailscmUserContext userContext, ThrowingFunction<MemberWishlist,MemberWishlist,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<MemberWishlist> customCreator = mapper.findCustomCreator(MemberWishlist.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    MemberWishlist result = new MemberWishlist();
    result.setName(mapper.tryToGet(MemberWishlist.class, NAME_PROPERTY, String.class,
        0, true, result.getName(), params));
    result.setOwner(mapper.tryToGet(MemberWishlist.class, OWNER_PROPERTY, RetailStoreMember.class,
        0, true, result.getOwner(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixMemberWishlist(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      MemberWishlistTokens tokens = mapper.findParamByClass(params, MemberWishlistTokens.class);
      if (tokens == null) {
        tokens = MemberWishlistTokens.start();
      }
      result = userContext.getManagerGroup().getMemberWishlistManager().internalSaveMemberWishlist(userContext, result, tokens.done());
      
    }
    return result;
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

