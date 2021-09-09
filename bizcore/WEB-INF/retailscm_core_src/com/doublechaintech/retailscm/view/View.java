
package com.doublechaintech.retailscm.view;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;









@JsonSerialize(using = ViewSerializer.class)
public class View extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String ASSESSMENT_PROPERTY            = "assessment"        ;
	public static final String INTERVIEW_TIME_PROPERTY        = "interviewTime"     ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="View";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(WHO_PROPERTY, "who", "谁")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ASSESSMENT_PROPERTY, "assessment", "评估")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(INTERVIEW_TIME_PROPERTY, "interview_time", "面试时间")
        .withType("date", Date.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,WHO_PROPERTY ,ASSESSMENT_PROPERTY ,INTERVIEW_TIME_PROPERTY ,VERSION_PROPERTY};
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
    
    return parents;
  }

  public View want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public View wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getWho();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		String              	who                 ;
	protected		String              	assessment          ;
	protected		Date                	interviewTime       ;
	protected		int                 	version             ;

	



	public 	View(){
		// lazy load for all the properties
	}
	public 	static View withId(String id){
		View view = new View();
		view.setId(id);
		view.setVersion(Integer.MAX_VALUE);
		view.setChecked(true);
		return view;
	}
	public 	static View refById(String id){
		return withId(id);
	}

  public View limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public View limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static View searchExample(){
    View view = new View();
    		view.setVersion(UNSET_INT);

    return view;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
		setChecked(false);
	}
	

	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(WHO_PROPERTY.equals(property)){
			changeWhoProperty(newValueExpr);
		}
		if(ASSESSMENT_PROPERTY.equals(property)){
			changeAssessmentProperty(newValueExpr);
		}
		if(INTERVIEW_TIME_PROPERTY.equals(property)){
			changeInterviewTimeProperty(newValueExpr);
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
			
			
			
	protected void changeAssessmentProperty(String newValueExpr){
	
		String oldValue = getAssessment();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAssessment(newValue);
		this.onChangeProperty(ASSESSMENT_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeInterviewTimeProperty(String newValueExpr){
	
		Date oldValue = getInterviewTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateInterviewTime(newValue);
		this.onChangeProperty(INTERVIEW_TIME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {

		if(WHO_PROPERTY.equals(property)){
			return getWho();
		}
		if(ASSESSMENT_PROPERTY.equals(property)){
			return getAssessment();
		}
		if(INTERVIEW_TIME_PROPERTY.equals(property)){
			return getInterviewTime();
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
	public View updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public View orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public View ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public View addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setWho(String who){String oldWho = this.who;String newWho = trimString(who);this.who = newWho;}
	public String who(){
doLoad();
return getWho();
}
	public String getWho(){
		return this.who;
	}
	public View updateWho(String who){String oldWho = this.who;String newWho = trimString(who);if(!shouldReplaceBy(newWho, oldWho)){return this;}this.who = newWho;addPropertyChange(WHO_PROPERTY, oldWho, newWho);this.changed = true;setChecked(false);return this;}
	public View orderByWho(boolean asc){
doAddOrderBy(WHO_PROPERTY, asc);
return this;
}
	public SearchCriteria createWhoCriteria(QueryOperator operator, Object... parameters){
return createCriteria(WHO_PROPERTY, operator, parameters);
}
	public View ignoreWhoCriteria(){super.ignoreSearchProperty(WHO_PROPERTY);
return this;
}
	public View addWhoCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createWhoCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeWho(String who){
		if(who != null) { setWho(who);}
	}

	
	public void setAssessment(String assessment){String oldAssessment = this.assessment;String newAssessment = trimString(assessment);this.assessment = newAssessment;}
	public String assessment(){
doLoad();
return getAssessment();
}
	public String getAssessment(){
		return this.assessment;
	}
	public View updateAssessment(String assessment){String oldAssessment = this.assessment;String newAssessment = trimString(assessment);if(!shouldReplaceBy(newAssessment, oldAssessment)){return this;}this.assessment = newAssessment;addPropertyChange(ASSESSMENT_PROPERTY, oldAssessment, newAssessment);this.changed = true;setChecked(false);return this;}
	public View orderByAssessment(boolean asc){
doAddOrderBy(ASSESSMENT_PROPERTY, asc);
return this;
}
	public SearchCriteria createAssessmentCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ASSESSMENT_PROPERTY, operator, parameters);
}
	public View ignoreAssessmentCriteria(){super.ignoreSearchProperty(ASSESSMENT_PROPERTY);
return this;
}
	public View addAssessmentCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createAssessmentCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeAssessment(String assessment){
		if(assessment != null) { setAssessment(assessment);}
	}

	
	public void setInterviewTime(Date interviewTime){Date oldInterviewTime = this.interviewTime;Date newInterviewTime = interviewTime;this.interviewTime = newInterviewTime;}
	public Date interviewTime(){
doLoad();
return getInterviewTime();
}
	public Date getInterviewTime(){
		return this.interviewTime;
	}
	public View updateInterviewTime(Date interviewTime){Date oldInterviewTime = this.interviewTime;Date newInterviewTime = interviewTime;if(!shouldReplaceBy(newInterviewTime, oldInterviewTime)){return this;}this.interviewTime = newInterviewTime;addPropertyChange(INTERVIEW_TIME_PROPERTY, oldInterviewTime, newInterviewTime);this.changed = true;setChecked(false);return this;}
	public View orderByInterviewTime(boolean asc){
doAddOrderBy(INTERVIEW_TIME_PROPERTY, asc);
return this;
}
	public SearchCriteria createInterviewTimeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(INTERVIEW_TIME_PROPERTY, operator, parameters);
}
	public View ignoreInterviewTimeCriteria(){super.ignoreSearchProperty(INTERVIEW_TIME_PROPERTY);
return this;
}
	public View addInterviewTimeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createInterviewTimeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeInterviewTime(Date interviewTime){
		setInterviewTime(interviewTime);
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public View updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public View orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public View ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public View addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){



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
		appendKeyValuePair(result, WHO_PROPERTY, getWho());
		appendKeyValuePair(result, ASSESSMENT_PROPERTY, getAssessment());
		appendKeyValuePair(result, INTERVIEW_TIME_PROPERTY, getInterviewTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof View){


			View dest =(View)baseDest;

			dest.setId(getId());
			dest.setWho(getWho());
			dest.setAssessment(getAssessment());
			dest.setInterviewTime(getInterviewTime());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof View){


			View dest =(View)baseDest;

			dest.mergeId(getId());
			dest.mergeWho(getWho());
			dest.mergeAssessment(getAssessment());
			dest.mergeInterviewTime(getInterviewTime());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof View){


			View dest =(View)baseDest;

			dest.mergeId(getId());
			dest.mergeWho(getWho());
			dest.mergeAssessment(getAssessment());
			dest.mergeInterviewTime(getInterviewTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getWho(), getAssessment(), getInterviewTime(), getVersion()};
	}


	public static View createWith(RetailscmUserContext userContext, ThrowingFunction<View,View,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<View> customCreator = mapper.findCustomCreator(View.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    View result = new View();
    result.setWho(mapper.tryToGet(View.class, WHO_PROPERTY, String.class,
        0, false, result.getWho(), params));
    result.setAssessment(mapper.tryToGet(View.class, ASSESSMENT_PROPERTY, String.class,
        1, false, result.getAssessment(), params));
    result.setInterviewTime(mapper.tryToGet(View.class, INTERVIEW_TIME_PROPERTY, Date.class,
        0, true, result.getInterviewTime(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixView(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      ViewTokens tokens = mapper.findParamByClass(params, ViewTokens.class);
      if (tokens == null) {
        tokens = ViewTokens.start();
      }
      result = userContext.getManagerGroup().getViewManager().internalSaveView(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("View{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\tassessment='"+getAssessment()+"';");
		stringBuilder.append("\tinterviewTime='"+getInterviewTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

