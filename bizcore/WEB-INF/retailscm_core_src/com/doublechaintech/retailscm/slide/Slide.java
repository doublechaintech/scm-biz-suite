
package com.doublechaintech.retailscm.slide;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.page.Page;









@JsonSerialize(using = SlideSerializer.class)
public class Slide extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String DISPLAY_ORDER_PROPERTY         = "displayOrder"      ;
	public static final String IMAGE_URL_PROPERTY             = "imageUrl"          ;
	public static final String VIDEO_URL_PROPERTY             = "videoUrl"          ;
	public static final String LINK_TO_URL_PROPERTY           = "linkToUrl"         ;
	public static final String PAGE_PROPERTY                  = "page"              ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="Slide";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(DISPLAY_ORDER_PROPERTY, "display_order", "顺序")
        .withType("int", "int"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(IMAGE_URL_PROPERTY, "image_url", "图片链接")
        .withType("string_image", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VIDEO_URL_PROPERTY, "video_url", "视频网址")
        .withType("string_image", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(LINK_TO_URL_PROPERTY, "link_to_url", "链接网址")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(PAGE_PROPERTY, "page", "页面")
        .withType("page", Page.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NAME_PROPERTY ,DISPLAY_ORDER_PROPERTY ,IMAGE_URL_PROPERTY ,VIDEO_URL_PROPERTY ,LINK_TO_URL_PROPERTY ,PAGE_PROPERTY ,VERSION_PROPERTY};
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
    parents.put(PAGE_PROPERTY, Page.class);

    return parents;
  }

  public Slide want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public Slide wants(Class<? extends BaseEntity>... classes) {
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
	protected		int                 	displayOrder        ;
	protected		String              	imageUrl            ;
	protected		String              	videoUrl            ;
	protected		String              	linkToUrl           ;
	protected		Page                	page                ;
	protected		int                 	version             ;

	



	public 	Slide(){
		// lazy load for all the properties
	}
	public 	static Slide withId(String id){
		Slide slide = new Slide();
		slide.setId(id);
		slide.setVersion(Integer.MAX_VALUE);
		slide.setChecked(true);
		return slide;
	}
	public 	static Slide refById(String id){
		return withId(id);
	}

  public Slide limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public Slide limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static Slide searchExample(){
    Slide slide = new Slide();
    		slide.setDisplayOrder(UNSET_INT);
		slide.setVersion(UNSET_INT);

    return slide;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPage( null );

		this.changed = true;
		setChecked(false);
	}
	

	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(DISPLAY_ORDER_PROPERTY.equals(property)){
			changeDisplayOrderProperty(newValueExpr);
		}
		if(IMAGE_URL_PROPERTY.equals(property)){
			changeImageUrlProperty(newValueExpr);
		}
		if(VIDEO_URL_PROPERTY.equals(property)){
			changeVideoUrlProperty(newValueExpr);
		}
		if(LINK_TO_URL_PROPERTY.equals(property)){
			changeLinkToUrlProperty(newValueExpr);
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
			
			
			
	protected void changeDisplayOrderProperty(String newValueExpr){
	
		int oldValue = getDisplayOrder();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDisplayOrder(newValue);
		this.onChangeProperty(DISPLAY_ORDER_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeImageUrlProperty(String newValueExpr){
	
		String oldValue = getImageUrl();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateImageUrl(newValue);
		this.onChangeProperty(IMAGE_URL_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeVideoUrlProperty(String newValueExpr){
	
		String oldValue = getVideoUrl();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateVideoUrl(newValue);
		this.onChangeProperty(VIDEO_URL_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeLinkToUrlProperty(String newValueExpr){
	
		String oldValue = getLinkToUrl();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLinkToUrl(newValue);
		this.onChangeProperty(LINK_TO_URL_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {

		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(DISPLAY_ORDER_PROPERTY.equals(property)){
			return getDisplayOrder();
		}
		if(IMAGE_URL_PROPERTY.equals(property)){
			return getImageUrl();
		}
		if(VIDEO_URL_PROPERTY.equals(property)){
			return getVideoUrl();
		}
		if(LINK_TO_URL_PROPERTY.equals(property)){
			return getLinkToUrl();
		}
		if(PAGE_PROPERTY.equals(property)){
			return getPage();
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
	public Slide updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public Slide orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public Slide ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public Slide addIdCriteria(QueryOperator operator, Object... parameters){
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
	public Slide updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public Slide orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public Slide ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public Slide addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}

	
	public void setDisplayOrder(int displayOrder){int oldDisplayOrder = this.displayOrder;int newDisplayOrder = displayOrder;this.displayOrder = newDisplayOrder;}
	public int displayOrder(){
doLoad();
return getDisplayOrder();
}
	public int getDisplayOrder(){
		return this.displayOrder;
	}
	public Slide updateDisplayOrder(int displayOrder){int oldDisplayOrder = this.displayOrder;int newDisplayOrder = displayOrder;if(!shouldReplaceBy(newDisplayOrder, oldDisplayOrder)){return this;}this.displayOrder = newDisplayOrder;addPropertyChange(DISPLAY_ORDER_PROPERTY, oldDisplayOrder, newDisplayOrder);this.changed = true;setChecked(false);return this;}
	public Slide orderByDisplayOrder(boolean asc){
doAddOrderBy(DISPLAY_ORDER_PROPERTY, asc);
return this;
}
	public SearchCriteria createDisplayOrderCriteria(QueryOperator operator, Object... parameters){
return createCriteria(DISPLAY_ORDER_PROPERTY, operator, parameters);
}
	public Slide ignoreDisplayOrderCriteria(){super.ignoreSearchProperty(DISPLAY_ORDER_PROPERTY);
return this;
}
	public Slide addDisplayOrderCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createDisplayOrderCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeDisplayOrder(int displayOrder){
		setDisplayOrder(displayOrder);
	}

	
	public void setImageUrl(String imageUrl){String oldImageUrl = this.imageUrl;String newImageUrl = trimString(encodeUrl(imageUrl));;this.imageUrl = newImageUrl;}
	public String imageUrl(){
doLoad();
return getImageUrl();
}
	public String getImageUrl(){
		return this.imageUrl;
	}
	public Slide updateImageUrl(String imageUrl){String oldImageUrl = this.imageUrl;String newImageUrl = trimString(encodeUrl(imageUrl));;if(!shouldReplaceBy(newImageUrl, oldImageUrl)){return this;}this.imageUrl = newImageUrl;addPropertyChange(IMAGE_URL_PROPERTY, oldImageUrl, newImageUrl);this.changed = true;setChecked(false);return this;}
	public Slide orderByImageUrl(boolean asc){
doAddOrderBy(IMAGE_URL_PROPERTY, asc);
return this;
}
	public SearchCriteria createImageUrlCriteria(QueryOperator operator, Object... parameters){
return createCriteria(IMAGE_URL_PROPERTY, operator, parameters);
}
	public Slide ignoreImageUrlCriteria(){super.ignoreSearchProperty(IMAGE_URL_PROPERTY);
return this;
}
	public Slide addImageUrlCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createImageUrlCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeImageUrl(String imageUrl){
		if(imageUrl != null) { setImageUrl(imageUrl);}
	}

	
	public void setVideoUrl(String videoUrl){String oldVideoUrl = this.videoUrl;String newVideoUrl = trimString(encodeUrl(videoUrl));;this.videoUrl = newVideoUrl;}
	public String videoUrl(){
doLoad();
return getVideoUrl();
}
	public String getVideoUrl(){
		return this.videoUrl;
	}
	public Slide updateVideoUrl(String videoUrl){String oldVideoUrl = this.videoUrl;String newVideoUrl = trimString(encodeUrl(videoUrl));;if(!shouldReplaceBy(newVideoUrl, oldVideoUrl)){return this;}this.videoUrl = newVideoUrl;addPropertyChange(VIDEO_URL_PROPERTY, oldVideoUrl, newVideoUrl);this.changed = true;setChecked(false);return this;}
	public Slide orderByVideoUrl(boolean asc){
doAddOrderBy(VIDEO_URL_PROPERTY, asc);
return this;
}
	public SearchCriteria createVideoUrlCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VIDEO_URL_PROPERTY, operator, parameters);
}
	public Slide ignoreVideoUrlCriteria(){super.ignoreSearchProperty(VIDEO_URL_PROPERTY);
return this;
}
	public Slide addVideoUrlCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVideoUrlCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVideoUrl(String videoUrl){
		if(videoUrl != null) { setVideoUrl(videoUrl);}
	}

	
	public void setLinkToUrl(String linkToUrl){String oldLinkToUrl = this.linkToUrl;String newLinkToUrl = trimString(linkToUrl);this.linkToUrl = newLinkToUrl;}
	public String linkToUrl(){
doLoad();
return getLinkToUrl();
}
	public String getLinkToUrl(){
		return this.linkToUrl;
	}
	public Slide updateLinkToUrl(String linkToUrl){String oldLinkToUrl = this.linkToUrl;String newLinkToUrl = trimString(linkToUrl);if(!shouldReplaceBy(newLinkToUrl, oldLinkToUrl)){return this;}this.linkToUrl = newLinkToUrl;addPropertyChange(LINK_TO_URL_PROPERTY, oldLinkToUrl, newLinkToUrl);this.changed = true;setChecked(false);return this;}
	public Slide orderByLinkToUrl(boolean asc){
doAddOrderBy(LINK_TO_URL_PROPERTY, asc);
return this;
}
	public SearchCriteria createLinkToUrlCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LINK_TO_URL_PROPERTY, operator, parameters);
}
	public Slide ignoreLinkToUrlCriteria(){super.ignoreSearchProperty(LINK_TO_URL_PROPERTY);
return this;
}
	public Slide addLinkToUrlCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createLinkToUrlCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeLinkToUrl(String linkToUrl){
		if(linkToUrl != null) { setLinkToUrl(linkToUrl);}
	}

	
	public void setPage(Page page){Page oldPage = this.page;Page newPage = page;this.page = newPage;}
	public Page page(){
doLoad();
return getPage();
}
	public Page getPage(){
		return this.page;
	}
	public Slide updatePage(Page page){Page oldPage = this.page;Page newPage = page;if(!shouldReplaceBy(newPage, oldPage)){return this;}this.page = newPage;addPropertyChange(PAGE_PROPERTY, oldPage, newPage);this.changed = true;setChecked(false);return this;}
	public Slide orderByPage(boolean asc){
doAddOrderBy(PAGE_PROPERTY, asc);
return this;
}
	public SearchCriteria createPageCriteria(QueryOperator operator, Object... parameters){
return createCriteria(PAGE_PROPERTY, operator, parameters);
}
	public Slide ignorePageCriteria(){super.ignoreSearchProperty(PAGE_PROPERTY);
return this;
}
	public Slide addPageCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createPageCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergePage(Page page){
		if(page != null) { setPage(page);}
	}

	
	public void clearPage(){
		setPage ( null );
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
	public Slide updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public Slide orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public Slide ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public Slide addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getPage(), internalType);


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
		appendKeyValuePair(result, DISPLAY_ORDER_PROPERTY, getDisplayOrder());
		appendKeyValuePair(result, IMAGE_URL_PROPERTY, getImageUrl());
		appendKeyValuePair(result, VIDEO_URL_PROPERTY, getVideoUrl());
		appendKeyValuePair(result, LINK_TO_URL_PROPERTY, getLinkToUrl());
		appendKeyValuePair(result, PAGE_PROPERTY, getPage());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof Slide){


			Slide dest =(Slide)baseDest;

			dest.setId(getId());
			dest.setName(getName());
			dest.setDisplayOrder(getDisplayOrder());
			dest.setImageUrl(getImageUrl());
			dest.setVideoUrl(getVideoUrl());
			dest.setLinkToUrl(getLinkToUrl());
			dest.setPage(getPage());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof Slide){


			Slide dest =(Slide)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeDisplayOrder(getDisplayOrder());
			dest.mergeImageUrl(getImageUrl());
			dest.mergeVideoUrl(getVideoUrl());
			dest.mergeLinkToUrl(getLinkToUrl());
			dest.mergePage(getPage());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof Slide){


			Slide dest =(Slide)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeDisplayOrder(getDisplayOrder());
			dest.mergeImageUrl(getImageUrl());
			dest.mergeVideoUrl(getVideoUrl());
			dest.mergeLinkToUrl(getLinkToUrl());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getDisplayOrder(), getImageUrl(), getVideoUrl(), getLinkToUrl(), getPage(), getVersion()};
	}


	public static Slide createWith(RetailscmUserContext userContext, ThrowingFunction<Slide,Slide,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<Slide> customCreator = mapper.findCustomCreator(Slide.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    Slide result = new Slide();
    result.setName(mapper.tryToGet(Slide.class, NAME_PROPERTY, String.class,
        0, false, result.getName(), params));
    result.setDisplayOrder(mapper.tryToGet(Slide.class, DISPLAY_ORDER_PROPERTY, int.class,
        0, true, result.getDisplayOrder(), params));
    result.setImageUrl(mapper.tryToGet(Slide.class, IMAGE_URL_PROPERTY, String.class,
        1, false, result.getImageUrl(), params));
    result.setVideoUrl(mapper.tryToGet(Slide.class, VIDEO_URL_PROPERTY, String.class,
        2, false, result.getVideoUrl(), params));
    result.setLinkToUrl(mapper.tryToGet(Slide.class, LINK_TO_URL_PROPERTY, String.class,
        3, false, result.getLinkToUrl(), params));
    result.setPage(mapper.tryToGet(Slide.class, PAGE_PROPERTY, Page.class,
        0, true, result.getPage(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixSlide(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      SlideTokens tokens = mapper.findParamByClass(params, SlideTokens.class);
      if (tokens == null) {
        tokens = SlideTokens.start();
      }
      result = userContext.getManagerGroup().getSlideManager().internalSaveSlide(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Slide{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tdisplayOrder='"+getDisplayOrder()+"';");
		stringBuilder.append("\timageUrl='"+getImageUrl()+"';");
		stringBuilder.append("\tvideoUrl='"+getVideoUrl()+"';");
		stringBuilder.append("\tlinkToUrl='"+getLinkToUrl()+"';");
		if(getPage() != null ){
 			stringBuilder.append("\tpage='Page("+getPage().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	
	public void increaseDisplayOrder(int incDisplayOrder){
		updateDisplayOrder(this.displayOrder +  incDisplayOrder);
	}
	public void decreaseDisplayOrder(int decDisplayOrder){
		updateDisplayOrder(this.displayOrder - decDisplayOrder);
	}
	

}

