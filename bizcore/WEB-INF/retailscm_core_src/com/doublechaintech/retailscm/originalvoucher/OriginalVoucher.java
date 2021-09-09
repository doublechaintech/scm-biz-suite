
package com.doublechaintech.retailscm.originalvoucher;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
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


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(TITLE_PROPERTY, "title", "头衔")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(MADE_BY_PROPERTY, "made_by", "由")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(RECEIVED_BY_PROPERTY, "received_by", "受")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VOUCHER_TYPE_PROPERTY, "voucher_type", "凭证类型")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VOUCHER_IMAGE_PROPERTY, "voucher_image", "凭证图像")
        .withType("string_image", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(BELONGS_TO_PROPERTY, "accounting_document", "属于")
        .withType("accounting_document", AccountingDocument.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,TITLE_PROPERTY ,MADE_BY_PROPERTY ,RECEIVED_BY_PROPERTY ,VOUCHER_TYPE_PROPERTY ,VOUCHER_IMAGE_PROPERTY ,BELONGS_TO_PROPERTY ,VERSION_PROPERTY};
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
    parents.put(BELONGS_TO_PROPERTY, AccountingDocument.class);

    return parents;
  }

  public OriginalVoucher want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public OriginalVoucher wants(Class<? extends BaseEntity>... classes) {
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
	protected		String              	madeBy              ;
	protected		String              	receivedBy          ;
	protected		String              	voucherType         ;
	protected		String              	voucherImage        ;
	protected		AccountingDocument  	belongsTo           ;
	protected		int                 	version             ;

	



	public 	OriginalVoucher(){
		// lazy load for all the properties
	}
	public 	static OriginalVoucher withId(String id){
		OriginalVoucher originalVoucher = new OriginalVoucher();
		originalVoucher.setId(id);
		originalVoucher.setVersion(Integer.MAX_VALUE);
		originalVoucher.setChecked(true);
		return originalVoucher;
	}
	public 	static OriginalVoucher refById(String id){
		return withId(id);
	}

  public OriginalVoucher limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public OriginalVoucher limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static OriginalVoucher searchExample(){
    OriginalVoucher originalVoucher = new OriginalVoucher();
    		originalVoucher.setVersion(UNSET_INT);

    return originalVoucher;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setBelongsTo( null );

		this.changed = true;
		setChecked(false);
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

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public OriginalVoucher updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public OriginalVoucher orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public OriginalVoucher ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public OriginalVoucher addIdCriteria(QueryOperator operator, Object... parameters){
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
	public OriginalVoucher updateTitle(String title){String oldTitle = this.title;String newTitle = trimString(title);if(!shouldReplaceBy(newTitle, oldTitle)){return this;}this.title = newTitle;addPropertyChange(TITLE_PROPERTY, oldTitle, newTitle);this.changed = true;setChecked(false);return this;}
	public OriginalVoucher orderByTitle(boolean asc){
doAddOrderBy(TITLE_PROPERTY, asc);
return this;
}
	public SearchCriteria createTitleCriteria(QueryOperator operator, Object... parameters){
return createCriteria(TITLE_PROPERTY, operator, parameters);
}
	public OriginalVoucher ignoreTitleCriteria(){super.ignoreSearchProperty(TITLE_PROPERTY);
return this;
}
	public OriginalVoucher addTitleCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createTitleCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeTitle(String title){
		if(title != null) { setTitle(title);}
	}

	
	public void setMadeBy(String madeBy){String oldMadeBy = this.madeBy;String newMadeBy = trimString(madeBy);this.madeBy = newMadeBy;}
	public String madeBy(){
doLoad();
return getMadeBy();
}
	public String getMadeBy(){
		return this.madeBy;
	}
	public OriginalVoucher updateMadeBy(String madeBy){String oldMadeBy = this.madeBy;String newMadeBy = trimString(madeBy);if(!shouldReplaceBy(newMadeBy, oldMadeBy)){return this;}this.madeBy = newMadeBy;addPropertyChange(MADE_BY_PROPERTY, oldMadeBy, newMadeBy);this.changed = true;setChecked(false);return this;}
	public OriginalVoucher orderByMadeBy(boolean asc){
doAddOrderBy(MADE_BY_PROPERTY, asc);
return this;
}
	public SearchCriteria createMadeByCriteria(QueryOperator operator, Object... parameters){
return createCriteria(MADE_BY_PROPERTY, operator, parameters);
}
	public OriginalVoucher ignoreMadeByCriteria(){super.ignoreSearchProperty(MADE_BY_PROPERTY);
return this;
}
	public OriginalVoucher addMadeByCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createMadeByCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeMadeBy(String madeBy){
		if(madeBy != null) { setMadeBy(madeBy);}
	}

	
	public void setReceivedBy(String receivedBy){String oldReceivedBy = this.receivedBy;String newReceivedBy = trimString(receivedBy);this.receivedBy = newReceivedBy;}
	public String receivedBy(){
doLoad();
return getReceivedBy();
}
	public String getReceivedBy(){
		return this.receivedBy;
	}
	public OriginalVoucher updateReceivedBy(String receivedBy){String oldReceivedBy = this.receivedBy;String newReceivedBy = trimString(receivedBy);if(!shouldReplaceBy(newReceivedBy, oldReceivedBy)){return this;}this.receivedBy = newReceivedBy;addPropertyChange(RECEIVED_BY_PROPERTY, oldReceivedBy, newReceivedBy);this.changed = true;setChecked(false);return this;}
	public OriginalVoucher orderByReceivedBy(boolean asc){
doAddOrderBy(RECEIVED_BY_PROPERTY, asc);
return this;
}
	public SearchCriteria createReceivedByCriteria(QueryOperator operator, Object... parameters){
return createCriteria(RECEIVED_BY_PROPERTY, operator, parameters);
}
	public OriginalVoucher ignoreReceivedByCriteria(){super.ignoreSearchProperty(RECEIVED_BY_PROPERTY);
return this;
}
	public OriginalVoucher addReceivedByCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createReceivedByCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeReceivedBy(String receivedBy){
		if(receivedBy != null) { setReceivedBy(receivedBy);}
	}

	
	public void setVoucherType(String voucherType){String oldVoucherType = this.voucherType;String newVoucherType = trimString(voucherType);this.voucherType = newVoucherType;}
	public String voucherType(){
doLoad();
return getVoucherType();
}
	public String getVoucherType(){
		return this.voucherType;
	}
	public OriginalVoucher updateVoucherType(String voucherType){String oldVoucherType = this.voucherType;String newVoucherType = trimString(voucherType);if(!shouldReplaceBy(newVoucherType, oldVoucherType)){return this;}this.voucherType = newVoucherType;addPropertyChange(VOUCHER_TYPE_PROPERTY, oldVoucherType, newVoucherType);this.changed = true;setChecked(false);return this;}
	public OriginalVoucher orderByVoucherType(boolean asc){
doAddOrderBy(VOUCHER_TYPE_PROPERTY, asc);
return this;
}
	public SearchCriteria createVoucherTypeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VOUCHER_TYPE_PROPERTY, operator, parameters);
}
	public OriginalVoucher ignoreVoucherTypeCriteria(){super.ignoreSearchProperty(VOUCHER_TYPE_PROPERTY);
return this;
}
	public OriginalVoucher addVoucherTypeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVoucherTypeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVoucherType(String voucherType){
		if(voucherType != null) { setVoucherType(voucherType);}
	}

	
	public void setVoucherImage(String voucherImage){String oldVoucherImage = this.voucherImage;String newVoucherImage = trimString(encodeUrl(voucherImage));;this.voucherImage = newVoucherImage;}
	public String voucherImage(){
doLoad();
return getVoucherImage();
}
	public String getVoucherImage(){
		return this.voucherImage;
	}
	public OriginalVoucher updateVoucherImage(String voucherImage){String oldVoucherImage = this.voucherImage;String newVoucherImage = trimString(encodeUrl(voucherImage));;if(!shouldReplaceBy(newVoucherImage, oldVoucherImage)){return this;}this.voucherImage = newVoucherImage;addPropertyChange(VOUCHER_IMAGE_PROPERTY, oldVoucherImage, newVoucherImage);this.changed = true;setChecked(false);return this;}
	public OriginalVoucher orderByVoucherImage(boolean asc){
doAddOrderBy(VOUCHER_IMAGE_PROPERTY, asc);
return this;
}
	public SearchCriteria createVoucherImageCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VOUCHER_IMAGE_PROPERTY, operator, parameters);
}
	public OriginalVoucher ignoreVoucherImageCriteria(){super.ignoreSearchProperty(VOUCHER_IMAGE_PROPERTY);
return this;
}
	public OriginalVoucher addVoucherImageCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVoucherImageCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVoucherImage(String voucherImage){
		if(voucherImage != null) { setVoucherImage(voucherImage);}
	}

	
	public void setBelongsTo(AccountingDocument belongsTo){AccountingDocument oldBelongsTo = this.belongsTo;AccountingDocument newBelongsTo = belongsTo;this.belongsTo = newBelongsTo;}
	public AccountingDocument belongsTo(){
doLoad();
return getBelongsTo();
}
	public AccountingDocument getBelongsTo(){
		return this.belongsTo;
	}
	public OriginalVoucher updateBelongsTo(AccountingDocument belongsTo){AccountingDocument oldBelongsTo = this.belongsTo;AccountingDocument newBelongsTo = belongsTo;if(!shouldReplaceBy(newBelongsTo, oldBelongsTo)){return this;}this.belongsTo = newBelongsTo;addPropertyChange(BELONGS_TO_PROPERTY, oldBelongsTo, newBelongsTo);this.changed = true;setChecked(false);return this;}
	public OriginalVoucher orderByBelongsTo(boolean asc){
doAddOrderBy(BELONGS_TO_PROPERTY, asc);
return this;
}
	public SearchCriteria createBelongsToCriteria(QueryOperator operator, Object... parameters){
return createCriteria(BELONGS_TO_PROPERTY, operator, parameters);
}
	public OriginalVoucher ignoreBelongsToCriteria(){super.ignoreSearchProperty(BELONGS_TO_PROPERTY);
return this;
}
	public OriginalVoucher addBelongsToCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createBelongsToCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeBelongsTo(AccountingDocument belongsTo){
		if(belongsTo != null) { setBelongsTo(belongsTo);}
	}

	
	public void clearBelongsTo(){
		setBelongsTo ( null );
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
	public OriginalVoucher updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public OriginalVoucher orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public OriginalVoucher ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public OriginalVoucher addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
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


	public static OriginalVoucher createWith(RetailscmUserContext userContext, ThrowingFunction<OriginalVoucher,OriginalVoucher,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<OriginalVoucher> customCreator = mapper.findCustomCreator(OriginalVoucher.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    OriginalVoucher result = new OriginalVoucher();
    result.setTitle(mapper.tryToGet(OriginalVoucher.class, TITLE_PROPERTY, String.class,
        0, false, result.getTitle(), params));
    result.setMadeBy(mapper.tryToGet(OriginalVoucher.class, MADE_BY_PROPERTY, String.class,
        1, false, result.getMadeBy(), params));
    result.setReceivedBy(mapper.tryToGet(OriginalVoucher.class, RECEIVED_BY_PROPERTY, String.class,
        2, false, result.getReceivedBy(), params));
    result.setVoucherType(mapper.tryToGet(OriginalVoucher.class, VOUCHER_TYPE_PROPERTY, String.class,
        3, false, result.getVoucherType(), params));
    result.setVoucherImage(mapper.tryToGet(OriginalVoucher.class, VOUCHER_IMAGE_PROPERTY, String.class,
        4, false, result.getVoucherImage(), params));
    result.setBelongsTo(mapper.tryToGet(OriginalVoucher.class, BELONGS_TO_PROPERTY, AccountingDocument.class,
        0, true, result.getBelongsTo(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixOriginalVoucher(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      OriginalVoucherTokens tokens = mapper.findParamByClass(params, OriginalVoucherTokens.class);
      if (tokens == null) {
        tokens = OriginalVoucherTokens.start();
      }
      result = userContext.getManagerGroup().getOriginalVoucherManager().internalSaveOriginalVoucher(userContext, result, tokens.done());
      
    }
    return result;
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

