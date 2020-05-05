
package com.doublechaintech.retailscm.candidatecontainer;

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
import com.doublechaintech.retailscm.candidateelement.CandidateElement;

@JsonSerialize(using = CandidateContainerSerializer.class)
public class CandidateContainer extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String CANDIDATE_ELEMENT_LIST                   = "candidateElementList";

	public static final String INTERNAL_TYPE="CandidateContainer";
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
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<CandidateElement>	mCandidateElementList;

	
		
	public 	CandidateContainer(){
		// lazy load for all the properties
	}
	public 	static CandidateContainer withId(String id){
		CandidateContainer candidateContainer = new CandidateContainer();
		candidateContainer.setId(id);
		candidateContainer.setVersion(Integer.MAX_VALUE);
		return candidateContainer;
	}
	public 	static CandidateContainer refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

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
		if(CANDIDATE_ELEMENT_LIST.equals(property)){
			List<BaseEntity> list = getCandidateElementList().stream().map(item->item).collect(Collectors.toList());
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
	public CandidateContainer updateId(String id){
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
	public CandidateContainer updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public CandidateContainer updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<CandidateElement> getCandidateElementList(){
		if(this.mCandidateElementList == null){
			this.mCandidateElementList = new SmartList<CandidateElement>();
			this.mCandidateElementList.setListInternalName (CANDIDATE_ELEMENT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mCandidateElementList;	
	}
	public  void setCandidateElementList(SmartList<CandidateElement> candidateElementList){
		for( CandidateElement candidateElement:candidateElementList){
			candidateElement.setContainer(this);
		}

		this.mCandidateElementList = candidateElementList;
		this.mCandidateElementList.setListInternalName (CANDIDATE_ELEMENT_LIST );
		
	}
	
	public  void addCandidateElement(CandidateElement candidateElement){
		candidateElement.setContainer(this);
		getCandidateElementList().add(candidateElement);
	}
	public  void addCandidateElementList(SmartList<CandidateElement> candidateElementList){
		for( CandidateElement candidateElement:candidateElementList){
			candidateElement.setContainer(this);
		}
		getCandidateElementList().addAll(candidateElementList);
	}
	public  void mergeCandidateElementList(SmartList<CandidateElement> candidateElementList){
		if(candidateElementList==null){
			return;
		}
		if(candidateElementList.isEmpty()){
			return;
		}
		addCandidateElementList( candidateElementList );
		
	}
	public  CandidateElement removeCandidateElement(CandidateElement candidateElementIndex){
		
		int index = getCandidateElementList().indexOf(candidateElementIndex);
        if(index < 0){
        	String message = "CandidateElement("+candidateElementIndex.getId()+") with version='"+candidateElementIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        CandidateElement candidateElement = getCandidateElementList().get(index);        
        // candidateElement.clearContainer(); //disconnect with Container
        candidateElement.clearFromAll(); //disconnect with Container
		
		boolean result = getCandidateElementList().planToRemove(candidateElement);
        if(!result){
        	String message = "CandidateElement("+candidateElementIndex.getId()+") with version='"+candidateElementIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return candidateElement;
        
	
	}
	//断舍离
	public  void breakWithCandidateElement(CandidateElement candidateElement){
		
		if(candidateElement == null){
			return;
		}
		candidateElement.setContainer(null);
		//getCandidateElementList().remove();
	
	}
	
	public  boolean hasCandidateElement(CandidateElement candidateElement){
	
		return getCandidateElementList().contains(candidateElement);
  
	}
	
	public void copyCandidateElementFrom(CandidateElement candidateElement) {

		CandidateElement candidateElementInList = findTheCandidateElement(candidateElement);
		CandidateElement newCandidateElement = new CandidateElement();
		candidateElementInList.copyTo(newCandidateElement);
		newCandidateElement.setVersion(0);//will trigger copy
		getCandidateElementList().add(newCandidateElement);
		addItemToFlexiableObject(COPIED_CHILD, newCandidateElement);
	}
	
	public  CandidateElement findTheCandidateElement(CandidateElement candidateElement){
		
		int index =  getCandidateElementList().indexOf(candidateElement);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "CandidateElement("+candidateElement.getId()+") with version='"+candidateElement.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getCandidateElementList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpCandidateElementList(){
		getCandidateElementList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getCandidateElementList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getCandidateElementList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, CANDIDATE_ELEMENT_LIST, getCandidateElementList());
		if(!getCandidateElementList().isEmpty()){
			appendKeyValuePair(result, "candidateElementCount", getCandidateElementList().getTotalCount());
			appendKeyValuePair(result, "candidateElementCurrentPageNumber", getCandidateElementList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof CandidateContainer){
		
		
			CandidateContainer dest =(CandidateContainer)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setVersion(getVersion());
			dest.setCandidateElementList(getCandidateElementList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof CandidateContainer){
		
			
			CandidateContainer dest =(CandidateContainer)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeVersion(getVersion());
			dest.mergeCandidateElementList(getCandidateElementList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof CandidateContainer){
		
			
			CandidateContainer dest =(CandidateContainer)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("CandidateContainer{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

