
package com.doublechaintech.retailscm.genericform;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;
import com.doublechaintech.retailscm.formfield.FormField;

@JsonSerialize(using = GenericFormSerializer.class)
public class GenericForm extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String FORM_MESSAGE_LIST                        = "formMessageList"   ;
	public static final String FORM_FIELD_MESSAGE_LIST                  = "formFieldMessageList";
	public static final String FORM_FIELD_LIST                          = "formFieldList"     ;
	public static final String FORM_ACTION_LIST                         = "formActionList"    ;

	public static final String INTERNAL_TYPE="GenericForm";
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
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<FormMessage>	mFormMessageList    ;
	protected		SmartList<FormFieldMessage>	mFormFieldMessageList;
	protected		SmartList<FormField>	mFormFieldList      ;
	protected		SmartList<FormAction>	mFormActionList     ;
	
		
	public 	GenericForm(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	public 	GenericForm(String title, String description)
	{
		setTitle(title);
		setDescription(description);

		this.mFormMessageList = new SmartList<FormMessage>();
		this.mFormFieldMessageList = new SmartList<FormFieldMessage>();
		this.mFormFieldList = new SmartList<FormField>();
		this.mFormActionList = new SmartList<FormAction>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
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
	public GenericForm updateId(String id){
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
	public GenericForm updateTitle(String title){
		this.mTitle = trimString(title);;
		this.changed = true;
		return this;
	}
	
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public GenericForm updateDescription(String description){
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
	public GenericForm updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<FormMessage> getFormMessageList(){
		if(this.mFormMessageList == null){
			this.mFormMessageList = new SmartList<FormMessage>();
			this.mFormMessageList.setListInternalName (FORM_MESSAGE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mFormMessageList;	
	}
	public  void setFormMessageList(SmartList<FormMessage> formMessageList){
		for( FormMessage formMessage:formMessageList){
			formMessage.setForm(this);
		}

		this.mFormMessageList = formMessageList;
		this.mFormMessageList.setListInternalName (FORM_MESSAGE_LIST );
		
	}
	
	public  void addFormMessage(FormMessage formMessage){
		formMessage.setForm(this);
		getFormMessageList().add(formMessage);
	}
	public  void addFormMessageList(SmartList<FormMessage> formMessageList){
		for( FormMessage formMessage:formMessageList){
			formMessage.setForm(this);
		}
		getFormMessageList().addAll(formMessageList);
	}
	
	public  FormMessage removeFormMessage(FormMessage formMessageIndex){
		
		int index = getFormMessageList().indexOf(formMessageIndex);
        if(index < 0){
        	String message = "FormMessage("+formMessageIndex.getId()+") with version='"+formMessageIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        FormMessage formMessage = getFormMessageList().get(index);        
        // formMessage.clearForm(); //disconnect with Form
        formMessage.clearFromAll(); //disconnect with Form
		
		boolean result = getFormMessageList().planToRemove(formMessage);
        if(!result){
        	String message = "FormMessage("+formMessageIndex.getId()+") with version='"+formMessageIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return formMessage;
        
	
	}
	//断舍离
	public  void breakWithFormMessage(FormMessage formMessage){
		
		if(formMessage == null){
			return;
		}
		formMessage.setForm(null);
		//getFormMessageList().remove();
	
	}
	
	public  boolean hasFormMessage(FormMessage formMessage){
	
		return getFormMessageList().contains(formMessage);
  
	}
	
	public void copyFormMessageFrom(FormMessage formMessage) {

		FormMessage formMessageInList = findTheFormMessage(formMessage);
		FormMessage newFormMessage = new FormMessage();
		formMessageInList.copyTo(newFormMessage);
		newFormMessage.setVersion(0);//will trigger copy
		getFormMessageList().add(newFormMessage);
		addItemToFlexiableObject(COPIED_CHILD, newFormMessage);
	}
	
	public  FormMessage findTheFormMessage(FormMessage formMessage){
		
		int index =  getFormMessageList().indexOf(formMessage);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "FormMessage("+formMessage.getId()+") with version='"+formMessage.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getFormMessageList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpFormMessageList(){
		getFormMessageList().clear();
	}
	
	
	


	public  SmartList<FormFieldMessage> getFormFieldMessageList(){
		if(this.mFormFieldMessageList == null){
			this.mFormFieldMessageList = new SmartList<FormFieldMessage>();
			this.mFormFieldMessageList.setListInternalName (FORM_FIELD_MESSAGE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mFormFieldMessageList;	
	}
	public  void setFormFieldMessageList(SmartList<FormFieldMessage> formFieldMessageList){
		for( FormFieldMessage formFieldMessage:formFieldMessageList){
			formFieldMessage.setForm(this);
		}

		this.mFormFieldMessageList = formFieldMessageList;
		this.mFormFieldMessageList.setListInternalName (FORM_FIELD_MESSAGE_LIST );
		
	}
	
	public  void addFormFieldMessage(FormFieldMessage formFieldMessage){
		formFieldMessage.setForm(this);
		getFormFieldMessageList().add(formFieldMessage);
	}
	public  void addFormFieldMessageList(SmartList<FormFieldMessage> formFieldMessageList){
		for( FormFieldMessage formFieldMessage:formFieldMessageList){
			formFieldMessage.setForm(this);
		}
		getFormFieldMessageList().addAll(formFieldMessageList);
	}
	
	public  FormFieldMessage removeFormFieldMessage(FormFieldMessage formFieldMessageIndex){
		
		int index = getFormFieldMessageList().indexOf(formFieldMessageIndex);
        if(index < 0){
        	String message = "FormFieldMessage("+formFieldMessageIndex.getId()+") with version='"+formFieldMessageIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        FormFieldMessage formFieldMessage = getFormFieldMessageList().get(index);        
        // formFieldMessage.clearForm(); //disconnect with Form
        formFieldMessage.clearFromAll(); //disconnect with Form
		
		boolean result = getFormFieldMessageList().planToRemove(formFieldMessage);
        if(!result){
        	String message = "FormFieldMessage("+formFieldMessageIndex.getId()+") with version='"+formFieldMessageIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return formFieldMessage;
        
	
	}
	//断舍离
	public  void breakWithFormFieldMessage(FormFieldMessage formFieldMessage){
		
		if(formFieldMessage == null){
			return;
		}
		formFieldMessage.setForm(null);
		//getFormFieldMessageList().remove();
	
	}
	
	public  boolean hasFormFieldMessage(FormFieldMessage formFieldMessage){
	
		return getFormFieldMessageList().contains(formFieldMessage);
  
	}
	
	public void copyFormFieldMessageFrom(FormFieldMessage formFieldMessage) {

		FormFieldMessage formFieldMessageInList = findTheFormFieldMessage(formFieldMessage);
		FormFieldMessage newFormFieldMessage = new FormFieldMessage();
		formFieldMessageInList.copyTo(newFormFieldMessage);
		newFormFieldMessage.setVersion(0);//will trigger copy
		getFormFieldMessageList().add(newFormFieldMessage);
		addItemToFlexiableObject(COPIED_CHILD, newFormFieldMessage);
	}
	
	public  FormFieldMessage findTheFormFieldMessage(FormFieldMessage formFieldMessage){
		
		int index =  getFormFieldMessageList().indexOf(formFieldMessage);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "FormFieldMessage("+formFieldMessage.getId()+") with version='"+formFieldMessage.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getFormFieldMessageList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpFormFieldMessageList(){
		getFormFieldMessageList().clear();
	}
	
	
	


	public  SmartList<FormField> getFormFieldList(){
		if(this.mFormFieldList == null){
			this.mFormFieldList = new SmartList<FormField>();
			this.mFormFieldList.setListInternalName (FORM_FIELD_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mFormFieldList;	
	}
	public  void setFormFieldList(SmartList<FormField> formFieldList){
		for( FormField formField:formFieldList){
			formField.setForm(this);
		}

		this.mFormFieldList = formFieldList;
		this.mFormFieldList.setListInternalName (FORM_FIELD_LIST );
		
	}
	
	public  void addFormField(FormField formField){
		formField.setForm(this);
		getFormFieldList().add(formField);
	}
	public  void addFormFieldList(SmartList<FormField> formFieldList){
		for( FormField formField:formFieldList){
			formField.setForm(this);
		}
		getFormFieldList().addAll(formFieldList);
	}
	
	public  FormField removeFormField(FormField formFieldIndex){
		
		int index = getFormFieldList().indexOf(formFieldIndex);
        if(index < 0){
        	String message = "FormField("+formFieldIndex.getId()+") with version='"+formFieldIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        FormField formField = getFormFieldList().get(index);        
        // formField.clearForm(); //disconnect with Form
        formField.clearFromAll(); //disconnect with Form
		
		boolean result = getFormFieldList().planToRemove(formField);
        if(!result){
        	String message = "FormField("+formFieldIndex.getId()+") with version='"+formFieldIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return formField;
        
	
	}
	//断舍离
	public  void breakWithFormField(FormField formField){
		
		if(formField == null){
			return;
		}
		formField.setForm(null);
		//getFormFieldList().remove();
	
	}
	
	public  boolean hasFormField(FormField formField){
	
		return getFormFieldList().contains(formField);
  
	}
	
	public void copyFormFieldFrom(FormField formField) {

		FormField formFieldInList = findTheFormField(formField);
		FormField newFormField = new FormField();
		formFieldInList.copyTo(newFormField);
		newFormField.setVersion(0);//will trigger copy
		getFormFieldList().add(newFormField);
		addItemToFlexiableObject(COPIED_CHILD, newFormField);
	}
	
	public  FormField findTheFormField(FormField formField){
		
		int index =  getFormFieldList().indexOf(formField);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "FormField("+formField.getId()+") with version='"+formField.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getFormFieldList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpFormFieldList(){
		getFormFieldList().clear();
	}
	
	
	


	public  SmartList<FormAction> getFormActionList(){
		if(this.mFormActionList == null){
			this.mFormActionList = new SmartList<FormAction>();
			this.mFormActionList.setListInternalName (FORM_ACTION_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mFormActionList;	
	}
	public  void setFormActionList(SmartList<FormAction> formActionList){
		for( FormAction formAction:formActionList){
			formAction.setForm(this);
		}

		this.mFormActionList = formActionList;
		this.mFormActionList.setListInternalName (FORM_ACTION_LIST );
		
	}
	
	public  void addFormAction(FormAction formAction){
		formAction.setForm(this);
		getFormActionList().add(formAction);
	}
	public  void addFormActionList(SmartList<FormAction> formActionList){
		for( FormAction formAction:formActionList){
			formAction.setForm(this);
		}
		getFormActionList().addAll(formActionList);
	}
	
	public  FormAction removeFormAction(FormAction formActionIndex){
		
		int index = getFormActionList().indexOf(formActionIndex);
        if(index < 0){
        	String message = "FormAction("+formActionIndex.getId()+") with version='"+formActionIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        FormAction formAction = getFormActionList().get(index);        
        // formAction.clearForm(); //disconnect with Form
        formAction.clearFromAll(); //disconnect with Form
		
		boolean result = getFormActionList().planToRemove(formAction);
        if(!result){
        	String message = "FormAction("+formActionIndex.getId()+") with version='"+formActionIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return formAction;
        
	
	}
	//断舍离
	public  void breakWithFormAction(FormAction formAction){
		
		if(formAction == null){
			return;
		}
		formAction.setForm(null);
		//getFormActionList().remove();
	
	}
	
	public  boolean hasFormAction(FormAction formAction){
	
		return getFormActionList().contains(formAction);
  
	}
	
	public void copyFormActionFrom(FormAction formAction) {

		FormAction formActionInList = findTheFormAction(formAction);
		FormAction newFormAction = new FormAction();
		formActionInList.copyTo(newFormAction);
		newFormAction.setVersion(0);//will trigger copy
		getFormActionList().add(newFormAction);
		addItemToFlexiableObject(COPIED_CHILD, newFormAction);
	}
	
	public  FormAction findTheFormAction(FormAction formAction){
		
		int index =  getFormActionList().indexOf(formAction);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "FormAction("+formAction.getId()+") with version='"+formAction.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getFormActionList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpFormActionList(){
		getFormActionList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getFormMessageList(), internalType);
		collectFromList(this, entityList, getFormFieldMessageList(), internalType);
		collectFromList(this, entityList, getFormFieldList(), internalType);
		collectFromList(this, entityList, getFormActionList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getFormMessageList());
		listOfList.add( getFormFieldMessageList());
		listOfList.add( getFormFieldList());
		listOfList.add( getFormActionList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, TITLE_PROPERTY, getTitle());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, FORM_MESSAGE_LIST, getFormMessageList());
		if(!getFormMessageList().isEmpty()){
			appendKeyValuePair(result, "formMessageCount", getFormMessageList().getTotalCount());
			appendKeyValuePair(result, "formMessageCurrentPageNumber", getFormMessageList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, FORM_FIELD_MESSAGE_LIST, getFormFieldMessageList());
		if(!getFormFieldMessageList().isEmpty()){
			appendKeyValuePair(result, "formFieldMessageCount", getFormFieldMessageList().getTotalCount());
			appendKeyValuePair(result, "formFieldMessageCurrentPageNumber", getFormFieldMessageList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, FORM_FIELD_LIST, getFormFieldList());
		if(!getFormFieldList().isEmpty()){
			appendKeyValuePair(result, "formFieldCount", getFormFieldList().getTotalCount());
			appendKeyValuePair(result, "formFieldCurrentPageNumber", getFormFieldList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, FORM_ACTION_LIST, getFormActionList());
		if(!getFormActionList().isEmpty()){
			appendKeyValuePair(result, "formActionCount", getFormActionList().getTotalCount());
			appendKeyValuePair(result, "formActionCurrentPageNumber", getFormActionList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof GenericForm){
		
		
			GenericForm dest =(GenericForm)baseDest;
		
			dest.setId(getId());
			dest.setTitle(getTitle());
			dest.setDescription(getDescription());
			dest.setVersion(getVersion());
			dest.setFormMessageList(getFormMessageList());
			dest.setFormFieldMessageList(getFormFieldMessageList());
			dest.setFormFieldList(getFormFieldList());
			dest.setFormActionList(getFormActionList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("GenericForm{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

