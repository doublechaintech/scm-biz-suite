
package com.doublechaintech.retailscm.memberrewardpoint;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;









@JsonSerialize(using = MemberRewardPointSerializer.class)
public class MemberRewardPoint extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String POINT_PROPERTY                 = "point"             ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="MemberRewardPoint";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(POINT_PROPERTY, "point", "点")
        .withType("int", "int"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(OWNER_PROPERTY, "retail_store_member", "业主")
        .withType("retail_store_member", RetailStoreMember.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NAME_PROPERTY ,POINT_PROPERTY ,OWNER_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(OWNER_PROPERTY, RetailStoreMember.class);

    return parents;
  }

  public MemberRewardPoint want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public MemberRewardPoint wants(Class<? extends BaseEntity>... classes) {
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
	protected		int                 	point               ;
	protected		RetailStoreMember   	owner               ;
	protected		int                 	version             ;

	



	public 	MemberRewardPoint(){
		// lazy load for all the properties
	}
	public 	static MemberRewardPoint withId(String id){
		MemberRewardPoint memberRewardPoint = new MemberRewardPoint();
		memberRewardPoint.setId(id);
		memberRewardPoint.setVersion(Integer.MAX_VALUE);
		memberRewardPoint.setChecked(true);
		return memberRewardPoint;
	}
	public 	static MemberRewardPoint refById(String id){
		return withId(id);
	}

  public MemberRewardPoint limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public MemberRewardPoint limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static MemberRewardPoint searchExample(){
    MemberRewardPoint memberRewardPoint = new MemberRewardPoint();
    		memberRewardPoint.setPoint(UNSET_INT);
		memberRewardPoint.setVersion(UNSET_INT);

    return memberRewardPoint;
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
		if(POINT_PROPERTY.equals(property)){
			changePointProperty(newValueExpr);
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
			
			
			
	protected void changePointProperty(String newValueExpr){
	
		int oldValue = getPoint();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePoint(newValue);
		this.onChangeProperty(POINT_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {

		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(POINT_PROPERTY.equals(property)){
			return getPoint();
		}
		if(OWNER_PROPERTY.equals(property)){
			return getOwner();
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
	public MemberRewardPoint updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public MemberRewardPoint orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public MemberRewardPoint ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public MemberRewardPoint addIdCriteria(QueryOperator operator, Object... parameters){
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
	public MemberRewardPoint updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public MemberRewardPoint orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public MemberRewardPoint ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public MemberRewardPoint addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}

	
	public void setPoint(int point){int oldPoint = this.point;int newPoint = point;this.point = newPoint;}
	public int point(){
doLoad();
return getPoint();
}
	public int getPoint(){
		return this.point;
	}
	public MemberRewardPoint updatePoint(int point){int oldPoint = this.point;int newPoint = point;if(!shouldReplaceBy(newPoint, oldPoint)){return this;}this.point = newPoint;addPropertyChange(POINT_PROPERTY, oldPoint, newPoint);this.changed = true;setChecked(false);return this;}
	public MemberRewardPoint orderByPoint(boolean asc){
doAddOrderBy(POINT_PROPERTY, asc);
return this;
}
	public SearchCriteria createPointCriteria(QueryOperator operator, Object... parameters){
return createCriteria(POINT_PROPERTY, operator, parameters);
}
	public MemberRewardPoint ignorePointCriteria(){super.ignoreSearchProperty(POINT_PROPERTY);
return this;
}
	public MemberRewardPoint addPointCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createPointCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergePoint(int point){
		setPoint(point);
	}

	
	public void setOwner(RetailStoreMember owner){RetailStoreMember oldOwner = this.owner;RetailStoreMember newOwner = owner;this.owner = newOwner;}
	public RetailStoreMember owner(){
doLoad();
return getOwner();
}
	public RetailStoreMember getOwner(){
		return this.owner;
	}
	public MemberRewardPoint updateOwner(RetailStoreMember owner){RetailStoreMember oldOwner = this.owner;RetailStoreMember newOwner = owner;if(!shouldReplaceBy(newOwner, oldOwner)){return this;}this.owner = newOwner;addPropertyChange(OWNER_PROPERTY, oldOwner, newOwner);this.changed = true;setChecked(false);return this;}
	public MemberRewardPoint orderByOwner(boolean asc){
doAddOrderBy(OWNER_PROPERTY, asc);
return this;
}
	public SearchCriteria createOwnerCriteria(QueryOperator operator, Object... parameters){
return createCriteria(OWNER_PROPERTY, operator, parameters);
}
	public MemberRewardPoint ignoreOwnerCriteria(){super.ignoreSearchProperty(OWNER_PROPERTY);
return this;
}
	public MemberRewardPoint addOwnerCriteria(QueryOperator operator, Object... parameters){
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
	public MemberRewardPoint updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public MemberRewardPoint orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public MemberRewardPoint ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public MemberRewardPoint addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getOwner(), internalType);


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
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, POINT_PROPERTY, getPoint());
		appendKeyValuePair(result, OWNER_PROPERTY, getOwner());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof MemberRewardPoint){


			MemberRewardPoint dest =(MemberRewardPoint)baseDest;

			dest.setId(getId());
			dest.setName(getName());
			dest.setPoint(getPoint());
			dest.setOwner(getOwner());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof MemberRewardPoint){


			MemberRewardPoint dest =(MemberRewardPoint)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergePoint(getPoint());
			dest.mergeOwner(getOwner());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof MemberRewardPoint){


			MemberRewardPoint dest =(MemberRewardPoint)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergePoint(getPoint());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getPoint(), getOwner(), getVersion()};
	}


	public static MemberRewardPoint createWith(RetailscmUserContext userContext, ThrowingFunction<MemberRewardPoint,MemberRewardPoint,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<MemberRewardPoint> customCreator = mapper.findCustomCreator(MemberRewardPoint.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    MemberRewardPoint result = new MemberRewardPoint();
    result.setName(mapper.tryToGet(MemberRewardPoint.class, NAME_PROPERTY, String.class,
        0, true, result.getName(), params));
    result.setPoint(mapper.tryToGet(MemberRewardPoint.class, POINT_PROPERTY, int.class,
        0, true, result.getPoint(), params));
    result.setOwner(mapper.tryToGet(MemberRewardPoint.class, OWNER_PROPERTY, RetailStoreMember.class,
        0, true, result.getOwner(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixMemberRewardPoint(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      MemberRewardPointTokens tokens = mapper.findParamByClass(params, MemberRewardPointTokens.class);
      if (tokens == null) {
        tokens = MemberRewardPointTokens.start();
      }
      result = userContext.getManagerGroup().getMemberRewardPointManager().internalSaveMemberRewardPoint(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("MemberRewardPoint{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tpoint='"+getPoint()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='RetailStoreMember("+getOwner().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	
	public void increasePoint(int incPoint){
		updatePoint(this.point +  incPoint);
	}
	public void decreasePoint(int decPoint){
		updatePoint(this.point - decPoint);
	}
	

}

