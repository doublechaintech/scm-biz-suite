
package com.doublechaintech.retailscm.formfieldmessage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.genericform.GenericForm;

@JsonSerialize(using = FormFieldMessageSerializer.class)
public class FormFieldMessage extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String PARAMETER_NAME_PROPERTY        = "parameterName"     ;
	public static final String FORM_PROPERTY                  = "form"              ;
	public static final String LEVEL_PROPERTY                 = "level"             ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="FormFieldMessage";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getTitle();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mTitle              ;
	protected		String              	mParameterName      ;
	protected		GenericForm         	mForm               ;
	protected		String              	mLevel              ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	FormFieldMessage(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setForm( null );

		this.changed = true;
	}
	
	public 	FormFieldMessage(String title, String parameterName, GenericForm form, String level)
	{
		setTitle(title);
		setParameterName(parameterName);
		setForm(form);
		setLevel(level);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}
		if(PARAMETER_NAME_PROPERTY.equals(property)){
			changeParameterNameProperty(newValueExpr);
		}
		if(LEVEL_PROPERTY.equals(property)){
			changeLevelProperty(newValueExpr);
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
			
			
			
	protected void changeParameterNameProperty(String newValueExpr){
		String oldValue = getParameterName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateParameterName(newValue);
		this.onChangeProperty(PARAMETER_NAME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeLevelProperty(String newValueExpr){
		String oldValue = getLevel();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLevel(newValue);
		this.onChangeProperty(LEVEL_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public FormFieldMessage updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setTitle(String title){
		this.mTitle = trimString(title);;
	}
	public String getTitle(){
		return this.mTitle;
	}
	public FormFieldMessage updateTitle(String title){
		this.mTitle = trimString(title);;
		this.changed = true;
		return this;
	}
	
	
	public void setParameterName(String parameterName){
		this.mParameterName = trimString(parameterName);;
	}
	public String getParameterName(){
		return this.mParameterName;
	}
	public FormFieldMessage updateParameterName(String parameterName){
		this.mParameterName = trimString(parameterName);;
		this.changed = true;
		return this;
	}
	
	
	public void setForm(GenericForm form){
		this.mForm = form;;
	}
	public GenericForm getForm(){
		return this.mForm;
	}
	public FormFieldMessage updateForm(GenericForm form){
		this.mForm = form;;
		this.changed = true;
		return this;
	}
	
	
	public void clearForm(){
		setForm ( null );
		this.changed = true;
	}
	
	public void setLevel(String level){
		this.mLevel = trimString(level);;
	}
	public String getLevel(){
		return this.mLevel;
	}
	public FormFieldMessage updateLevel(String level){
		this.mLevel = trimString(level);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public FormFieldMessage updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getForm(), internalType);

		
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
		appendKeyValuePair(result, PARAMETER_NAME_PROPERTY, getParameterName());
		appendKeyValuePair(result, FORM_PROPERTY, getForm());
		appendKeyValuePair(result, LEVEL_PROPERTY, getLevel());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof FormFieldMessage){
		
		
			FormFieldMessage dest =(FormFieldMessage)baseDest;
		
			dest.setId(getId());
			dest.setTitle(getTitle());
			dest.setParameterName(getParameterName());
			dest.setForm(getForm());
			dest.setLevel(getLevel());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("FormFieldMessage{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		stringBuilder.append("\tparameterName='"+getParameterName()+"';");
		if(getForm() != null ){
 			stringBuilder.append("\tform='GenericForm("+getForm().getId()+")';");
 		}
		stringBuilder.append("\tlevel='"+getLevel()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

