
package com.doublechaintech.retailscm.scoring;

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
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;

@JsonSerialize(using = ScoringSerializer.class)
public class Scoring extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String SCORED_BY_PROPERTY             = "scoredBy"          ;
	public static final String SCORE_PROPERTY                 = "score"             ;
	public static final String COMMENT_PROPERTY               = "comment"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EMPLOYEE_COMPANY_TRAINING_LIST           = "employeeCompanyTrainingList";

	public static final String INTERNAL_TYPE="Scoring";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getScoredBy();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mScoredBy           ;
	protected		int                 	mScore              ;
	protected		String              	mComment            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<EmployeeCompanyTraining>	mEmployeeCompanyTrainingList;

	
		
	public 	Scoring(){
		// lazy load for all the properties
	}
	public 	static Scoring withId(String id){
		Scoring scoring = new Scoring();
		scoring.setId(id);
		scoring.setVersion(Integer.MAX_VALUE);
		return scoring;
	}
	public 	static Scoring refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(SCORED_BY_PROPERTY.equals(property)){
			changeScoredByProperty(newValueExpr);
		}
		if(SCORE_PROPERTY.equals(property)){
			changeScoreProperty(newValueExpr);
		}
		if(COMMENT_PROPERTY.equals(property)){
			changeCommentProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeScoredByProperty(String newValueExpr){
	
		String oldValue = getScoredBy();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateScoredBy(newValue);
		this.onChangeProperty(SCORED_BY_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeScoreProperty(String newValueExpr){
	
		int oldValue = getScore();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateScore(newValue);
		this.onChangeProperty(SCORE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeCommentProperty(String newValueExpr){
	
		String oldValue = getComment();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateComment(newValue);
		this.onChangeProperty(COMMENT_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(SCORED_BY_PROPERTY.equals(property)){
			return getScoredBy();
		}
		if(SCORE_PROPERTY.equals(property)){
			return getScore();
		}
		if(COMMENT_PROPERTY.equals(property)){
			return getComment();
		}
		if(EMPLOYEE_COMPANY_TRAINING_LIST.equals(property)){
			List<BaseEntity> list = getEmployeeCompanyTrainingList().stream().map(item->item).collect(Collectors.toList());
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
	public Scoring updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setScoredBy(String scoredBy){
		this.mScoredBy = trimString(scoredBy);;
	}
	public String getScoredBy(){
		return this.mScoredBy;
	}
	public Scoring updateScoredBy(String scoredBy){
		this.mScoredBy = trimString(scoredBy);;
		this.changed = true;
		return this;
	}
	public void mergeScoredBy(String scoredBy){
		if(scoredBy != null) { setScoredBy(scoredBy);}
	}
	
	
	public void setScore(int score){
		this.mScore = score;;
	}
	public int getScore(){
		return this.mScore;
	}
	public Scoring updateScore(int score){
		this.mScore = score;;
		this.changed = true;
		return this;
	}
	public void mergeScore(int score){
		setScore(score);
	}
	
	
	public void setComment(String comment){
		this.mComment = trimString(comment);;
	}
	public String getComment(){
		return this.mComment;
	}
	public Scoring updateComment(String comment){
		this.mComment = trimString(comment);;
		this.changed = true;
		return this;
	}
	public void mergeComment(String comment){
		if(comment != null) { setComment(comment);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Scoring updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<EmployeeCompanyTraining> getEmployeeCompanyTrainingList(){
		if(this.mEmployeeCompanyTrainingList == null){
			this.mEmployeeCompanyTrainingList = new SmartList<EmployeeCompanyTraining>();
			this.mEmployeeCompanyTrainingList.setListInternalName (EMPLOYEE_COMPANY_TRAINING_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mEmployeeCompanyTrainingList;	
	}
	public  void setEmployeeCompanyTrainingList(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList){
		for( EmployeeCompanyTraining employeeCompanyTraining:employeeCompanyTrainingList){
			employeeCompanyTraining.setScoring(this);
		}

		this.mEmployeeCompanyTrainingList = employeeCompanyTrainingList;
		this.mEmployeeCompanyTrainingList.setListInternalName (EMPLOYEE_COMPANY_TRAINING_LIST );
		
	}
	
	public  void addEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining){
		employeeCompanyTraining.setScoring(this);
		getEmployeeCompanyTrainingList().add(employeeCompanyTraining);
	}
	public  void addEmployeeCompanyTrainingList(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList){
		for( EmployeeCompanyTraining employeeCompanyTraining:employeeCompanyTrainingList){
			employeeCompanyTraining.setScoring(this);
		}
		getEmployeeCompanyTrainingList().addAll(employeeCompanyTrainingList);
	}
	public  void mergeEmployeeCompanyTrainingList(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList){
		if(employeeCompanyTrainingList==null){
			return;
		}
		if(employeeCompanyTrainingList.isEmpty()){
			return;
		}
		addEmployeeCompanyTrainingList( employeeCompanyTrainingList );
		
	}
	public  EmployeeCompanyTraining removeEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTrainingIndex){
		
		int index = getEmployeeCompanyTrainingList().indexOf(employeeCompanyTrainingIndex);
        if(index < 0){
        	String message = "EmployeeCompanyTraining("+employeeCompanyTrainingIndex.getId()+") with version='"+employeeCompanyTrainingIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        EmployeeCompanyTraining employeeCompanyTraining = getEmployeeCompanyTrainingList().get(index);        
        // employeeCompanyTraining.clearScoring(); //disconnect with Scoring
        employeeCompanyTraining.clearFromAll(); //disconnect with Scoring
		
		boolean result = getEmployeeCompanyTrainingList().planToRemove(employeeCompanyTraining);
        if(!result){
        	String message = "EmployeeCompanyTraining("+employeeCompanyTrainingIndex.getId()+") with version='"+employeeCompanyTrainingIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return employeeCompanyTraining;
        
	
	}
	//断舍离
	public  void breakWithEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining){
		
		if(employeeCompanyTraining == null){
			return;
		}
		employeeCompanyTraining.setScoring(null);
		//getEmployeeCompanyTrainingList().remove();
	
	}
	
	public  boolean hasEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining){
	
		return getEmployeeCompanyTrainingList().contains(employeeCompanyTraining);
  
	}
	
	public void copyEmployeeCompanyTrainingFrom(EmployeeCompanyTraining employeeCompanyTraining) {

		EmployeeCompanyTraining employeeCompanyTrainingInList = findTheEmployeeCompanyTraining(employeeCompanyTraining);
		EmployeeCompanyTraining newEmployeeCompanyTraining = new EmployeeCompanyTraining();
		employeeCompanyTrainingInList.copyTo(newEmployeeCompanyTraining);
		newEmployeeCompanyTraining.setVersion(0);//will trigger copy
		getEmployeeCompanyTrainingList().add(newEmployeeCompanyTraining);
		addItemToFlexiableObject(COPIED_CHILD, newEmployeeCompanyTraining);
	}
	
	public  EmployeeCompanyTraining findTheEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining){
		
		int index =  getEmployeeCompanyTrainingList().indexOf(employeeCompanyTraining);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "EmployeeCompanyTraining("+employeeCompanyTraining.getId()+") with version='"+employeeCompanyTraining.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getEmployeeCompanyTrainingList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeCompanyTrainingList(){
		getEmployeeCompanyTrainingList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getEmployeeCompanyTrainingList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getEmployeeCompanyTrainingList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, SCORED_BY_PROPERTY, getScoredBy());
		appendKeyValuePair(result, SCORE_PROPERTY, getScore());
		appendKeyValuePair(result, COMMENT_PROPERTY, getComment());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, EMPLOYEE_COMPANY_TRAINING_LIST, getEmployeeCompanyTrainingList());
		if(!getEmployeeCompanyTrainingList().isEmpty()){
			appendKeyValuePair(result, "employeeCompanyTrainingCount", getEmployeeCompanyTrainingList().getTotalCount());
			appendKeyValuePair(result, "employeeCompanyTrainingCurrentPageNumber", getEmployeeCompanyTrainingList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Scoring){
		
		
			Scoring dest =(Scoring)baseDest;
		
			dest.setId(getId());
			dest.setScoredBy(getScoredBy());
			dest.setScore(getScore());
			dest.setComment(getComment());
			dest.setVersion(getVersion());
			dest.setEmployeeCompanyTrainingList(getEmployeeCompanyTrainingList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Scoring){
		
			
			Scoring dest =(Scoring)baseDest;
		
			dest.mergeId(getId());
			dest.mergeScoredBy(getScoredBy());
			dest.mergeScore(getScore());
			dest.mergeComment(getComment());
			dest.mergeVersion(getVersion());
			dest.mergeEmployeeCompanyTrainingList(getEmployeeCompanyTrainingList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Scoring){
		
			
			Scoring dest =(Scoring)baseDest;
		
			dest.mergeId(getId());
			dest.mergeScoredBy(getScoredBy());
			dest.mergeScore(getScore());
			dest.mergeComment(getComment());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getScoredBy(), getScore(), getComment(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Scoring{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tscoredBy='"+getScoredBy()+"';");
		stringBuilder.append("\tscore='"+getScore()+"';");
		stringBuilder.append("\tcomment='"+getComment()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	
	public void increaseScore(int incScore){
		updateScore(this.mScore +  incScore);
	}
	public void decreaseScore(int decScore){
		updateScore(this.mScore - decScore);
	}
	

}

