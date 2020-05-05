
package com.doublechaintech.retailscm.terminationtype;

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
import com.doublechaintech.retailscm.termination.Termination;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

@JsonSerialize(using = TerminationTypeSerializer.class)
public class TerminationType extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String COMPANY_PROPERTY               = "company"           ;
	public static final String BASE_DESCRIPTION_PROPERTY      = "baseDescription"   ;
	public static final String DETAIL_DESCRIPTION_PROPERTY    = "detailDescription" ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String TERMINATION_LIST                         = "terminationList"   ;

	public static final String INTERNAL_TYPE="TerminationType";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getCode();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mCode               ;
	protected		RetailStoreCountryCenter	mCompany            ;
	protected		String              	mBaseDescription    ;
	protected		String              	mDetailDescription  ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Termination>	mTerminationList    ;

	
		
	public 	TerminationType(){
		// lazy load for all the properties
	}
	public 	static TerminationType withId(String id){
		TerminationType terminationType = new TerminationType();
		terminationType.setId(id);
		terminationType.setVersion(Integer.MAX_VALUE);
		return terminationType;
	}
	public 	static TerminationType refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setCompany( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(CODE_PROPERTY.equals(property)){
			changeCodeProperty(newValueExpr);
		}
		if(BASE_DESCRIPTION_PROPERTY.equals(property)){
			changeBaseDescriptionProperty(newValueExpr);
		}
		if(DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			changeDetailDescriptionProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeCodeProperty(String newValueExpr){
	
		String oldValue = getCode();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCode(newValue);
		this.onChangeProperty(CODE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeBaseDescriptionProperty(String newValueExpr){
	
		String oldValue = getBaseDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateBaseDescription(newValue);
		this.onChangeProperty(BASE_DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeDetailDescriptionProperty(String newValueExpr){
	
		String oldValue = getDetailDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDetailDescription(newValue);
		this.onChangeProperty(DETAIL_DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(CODE_PROPERTY.equals(property)){
			return getCode();
		}
		if(COMPANY_PROPERTY.equals(property)){
			return getCompany();
		}
		if(BASE_DESCRIPTION_PROPERTY.equals(property)){
			return getBaseDescription();
		}
		if(DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			return getDetailDescription();
		}
		if(TERMINATION_LIST.equals(property)){
			List<BaseEntity> list = getTerminationList().stream().map(item->item).collect(Collectors.toList());
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
	public TerminationType updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setCode(String code){
		this.mCode = trimString(code);;
	}
	public String getCode(){
		return this.mCode;
	}
	public TerminationType updateCode(String code){
		this.mCode = trimString(code);;
		this.changed = true;
		return this;
	}
	public void mergeCode(String code){
		if(code != null) { setCode(code);}
	}
	
	
	public void setCompany(RetailStoreCountryCenter company){
		this.mCompany = company;;
	}
	public RetailStoreCountryCenter getCompany(){
		return this.mCompany;
	}
	public TerminationType updateCompany(RetailStoreCountryCenter company){
		this.mCompany = company;;
		this.changed = true;
		return this;
	}
	public void mergeCompany(RetailStoreCountryCenter company){
		if(company != null) { setCompany(company);}
	}
	
	
	public void clearCompany(){
		setCompany ( null );
		this.changed = true;
	}
	
	public void setBaseDescription(String baseDescription){
		this.mBaseDescription = trimString(baseDescription);;
	}
	public String getBaseDescription(){
		return this.mBaseDescription;
	}
	public TerminationType updateBaseDescription(String baseDescription){
		this.mBaseDescription = trimString(baseDescription);;
		this.changed = true;
		return this;
	}
	public void mergeBaseDescription(String baseDescription){
		if(baseDescription != null) { setBaseDescription(baseDescription);}
	}
	
	
	public void setDetailDescription(String detailDescription){
		this.mDetailDescription = trimString(detailDescription);;
	}
	public String getDetailDescription(){
		return this.mDetailDescription;
	}
	public TerminationType updateDetailDescription(String detailDescription){
		this.mDetailDescription = trimString(detailDescription);;
		this.changed = true;
		return this;
	}
	public void mergeDetailDescription(String detailDescription){
		if(detailDescription != null) { setDetailDescription(detailDescription);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public TerminationType updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<Termination> getTerminationList(){
		if(this.mTerminationList == null){
			this.mTerminationList = new SmartList<Termination>();
			this.mTerminationList.setListInternalName (TERMINATION_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTerminationList;	
	}
	public  void setTerminationList(SmartList<Termination> terminationList){
		for( Termination termination:terminationList){
			termination.setType(this);
		}

		this.mTerminationList = terminationList;
		this.mTerminationList.setListInternalName (TERMINATION_LIST );
		
	}
	
	public  void addTermination(Termination termination){
		termination.setType(this);
		getTerminationList().add(termination);
	}
	public  void addTerminationList(SmartList<Termination> terminationList){
		for( Termination termination:terminationList){
			termination.setType(this);
		}
		getTerminationList().addAll(terminationList);
	}
	public  void mergeTerminationList(SmartList<Termination> terminationList){
		if(terminationList==null){
			return;
		}
		if(terminationList.isEmpty()){
			return;
		}
		addTerminationList( terminationList );
		
	}
	public  Termination removeTermination(Termination terminationIndex){
		
		int index = getTerminationList().indexOf(terminationIndex);
        if(index < 0){
        	String message = "Termination("+terminationIndex.getId()+") with version='"+terminationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Termination termination = getTerminationList().get(index);        
        // termination.clearType(); //disconnect with Type
        termination.clearFromAll(); //disconnect with Type
		
		boolean result = getTerminationList().planToRemove(termination);
        if(!result){
        	String message = "Termination("+terminationIndex.getId()+") with version='"+terminationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return termination;
        
	
	}
	//断舍离
	public  void breakWithTermination(Termination termination){
		
		if(termination == null){
			return;
		}
		termination.setType(null);
		//getTerminationList().remove();
	
	}
	
	public  boolean hasTermination(Termination termination){
	
		return getTerminationList().contains(termination);
  
	}
	
	public void copyTerminationFrom(Termination termination) {

		Termination terminationInList = findTheTermination(termination);
		Termination newTermination = new Termination();
		terminationInList.copyTo(newTermination);
		newTermination.setVersion(0);//will trigger copy
		getTerminationList().add(newTermination);
		addItemToFlexiableObject(COPIED_CHILD, newTermination);
	}
	
	public  Termination findTheTermination(Termination termination){
		
		int index =  getTerminationList().indexOf(termination);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Termination("+termination.getId()+") with version='"+termination.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTerminationList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTerminationList(){
		getTerminationList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getCompany(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getTerminationList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getTerminationList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, CODE_PROPERTY, getCode());
		appendKeyValuePair(result, COMPANY_PROPERTY, getCompany());
		appendKeyValuePair(result, BASE_DESCRIPTION_PROPERTY, getBaseDescription());
		appendKeyValuePair(result, DETAIL_DESCRIPTION_PROPERTY, getDetailDescription());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, TERMINATION_LIST, getTerminationList());
		if(!getTerminationList().isEmpty()){
			appendKeyValuePair(result, "terminationCount", getTerminationList().getTotalCount());
			appendKeyValuePair(result, "terminationCurrentPageNumber", getTerminationList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TerminationType){
		
		
			TerminationType dest =(TerminationType)baseDest;
		
			dest.setId(getId());
			dest.setCode(getCode());
			dest.setCompany(getCompany());
			dest.setBaseDescription(getBaseDescription());
			dest.setDetailDescription(getDetailDescription());
			dest.setVersion(getVersion());
			dest.setTerminationList(getTerminationList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TerminationType){
		
			
			TerminationType dest =(TerminationType)baseDest;
		
			dest.mergeId(getId());
			dest.mergeCode(getCode());
			dest.mergeCompany(getCompany());
			dest.mergeBaseDescription(getBaseDescription());
			dest.mergeDetailDescription(getDetailDescription());
			dest.mergeVersion(getVersion());
			dest.mergeTerminationList(getTerminationList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TerminationType){
		
			
			TerminationType dest =(TerminationType)baseDest;
		
			dest.mergeId(getId());
			dest.mergeCode(getCode());
			dest.mergeBaseDescription(getBaseDescription());
			dest.mergeDetailDescription(getDetailDescription());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getCode(), getCompany(), getBaseDescription(), getDetailDescription(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("TerminationType{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		if(getCompany() != null ){
 			stringBuilder.append("\tcompany='RetailStoreCountryCenter("+getCompany().getId()+")';");
 		}
		stringBuilder.append("\tbaseDescription='"+getBaseDescription()+"';");
		stringBuilder.append("\tdetailDescription='"+getDetailDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

