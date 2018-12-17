
package com.doublechaintech.retailscm.terminationreason;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.termination.Termination;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

@JsonSerialize(using = TerminationReasonSerializer.class)
public class TerminationReason extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String COMPANY_PROPERTY               = "company"           ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String TERMINATION_LIST                         = "terminationList"   ;

	public static final String INTERNAL_TYPE="TerminationReason";
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
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Termination>	mTerminationList    ;
	
		
	public 	TerminationReason(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setCompany( null );

		this.changed = true;
	}
	
	public 	TerminationReason(String code, RetailStoreCountryCenter company, String description)
	{
		setCode(code);
		setCompany(company);
		setDescription(description);

		this.mTerminationList = new SmartList<Termination>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(CODE_PROPERTY.equals(property)){
			changeCodeProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
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
			
			
			
	protected void changeDescriptionProperty(String newValueExpr){
		String oldValue = getDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDescription(newValue);
		this.onChangeProperty(DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public TerminationReason updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setCode(String code){
		this.mCode = trimString(code);;
	}
	public String getCode(){
		return this.mCode;
	}
	public TerminationReason updateCode(String code){
		this.mCode = trimString(code);;
		this.changed = true;
		return this;
	}
	
	
	public void setCompany(RetailStoreCountryCenter company){
		this.mCompany = company;;
	}
	public RetailStoreCountryCenter getCompany(){
		return this.mCompany;
	}
	public TerminationReason updateCompany(RetailStoreCountryCenter company){
		this.mCompany = company;;
		this.changed = true;
		return this;
	}
	
	
	public void clearCompany(){
		setCompany ( null );
		this.changed = true;
	}
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public TerminationReason updateDescription(String description){
		this.mDescription = trimString(description);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public TerminationReason updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
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
			termination.setReason(this);
		}

		this.mTerminationList = terminationList;
		this.mTerminationList.setListInternalName (TERMINATION_LIST );
		
	}
	
	public  void addTermination(Termination termination){
		termination.setReason(this);
		getTerminationList().add(termination);
	}
	public  void addTerminationList(SmartList<Termination> terminationList){
		for( Termination termination:terminationList){
			termination.setReason(this);
		}
		getTerminationList().addAll(terminationList);
	}
	
	public  Termination removeTermination(Termination terminationIndex){
		
		int index = getTerminationList().indexOf(terminationIndex);
        if(index < 0){
        	String message = "Termination("+terminationIndex.getId()+") with version='"+terminationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Termination termination = getTerminationList().get(index);        
        // termination.clearReason(); //disconnect with Reason
        termination.clearFromAll(); //disconnect with Reason
		
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
		termination.setReason(null);
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
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, TERMINATION_LIST, getTerminationList());
		if(!getTerminationList().isEmpty()){
			appendKeyValuePair(result, "terminationCount", getTerminationList().getTotalCount());
			appendKeyValuePair(result, "terminationCurrentPageNumber", getTerminationList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TerminationReason){
		
		
			TerminationReason dest =(TerminationReason)baseDest;
		
			dest.setId(getId());
			dest.setCode(getCode());
			dest.setCompany(getCompany());
			dest.setDescription(getDescription());
			dest.setVersion(getVersion());
			dest.setTerminationList(getTerminationList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("TerminationReason{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		if(getCompany() != null ){
 			stringBuilder.append("\tcompany='RetailStoreCountryCenter("+getCompany().getId()+")';");
 		}
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

