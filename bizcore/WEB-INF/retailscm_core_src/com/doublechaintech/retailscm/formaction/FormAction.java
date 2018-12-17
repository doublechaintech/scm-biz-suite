
package com.doublechaintech.retailscm.formaction;

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

@JsonSerialize(using = FormActionSerializer.class)
public class FormAction extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String LABEL_PROPERTY                 = "label"             ;
	public static final String LOCALE_KEY_PROPERTY            = "localeKey"         ;
	public static final String ACTION_KEY_PROPERTY            = "actionKey"         ;
	public static final String LEVEL_PROPERTY                 = "level"             ;
	public static final String URL_PROPERTY                   = "url"               ;
	public static final String FORM_PROPERTY                  = "form"              ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="FormAction";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getLabel();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mLabel              ;
	protected		String              	mLocaleKey          ;
	protected		String              	mActionKey          ;
	protected		String              	mLevel              ;
	protected		String              	mUrl                ;
	protected		GenericForm         	mForm               ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	FormAction(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setForm( null );

		this.changed = true;
	}
	
	public 	FormAction(String label, String localeKey, String actionKey, String level, String url, GenericForm form)
	{
		setLabel(label);
		setLocaleKey(localeKey);
		setActionKey(actionKey);
		setLevel(level);
		setUrl(url);
		setForm(form);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(LABEL_PROPERTY.equals(property)){
			changeLabelProperty(newValueExpr);
		}
		if(LOCALE_KEY_PROPERTY.equals(property)){
			changeLocaleKeyProperty(newValueExpr);
		}
		if(ACTION_KEY_PROPERTY.equals(property)){
			changeActionKeyProperty(newValueExpr);
		}
		if(LEVEL_PROPERTY.equals(property)){
			changeLevelProperty(newValueExpr);
		}
		if(URL_PROPERTY.equals(property)){
			changeUrlProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeLabelProperty(String newValueExpr){
		String oldValue = getLabel();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLabel(newValue);
		this.onChangeProperty(LABEL_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeLocaleKeyProperty(String newValueExpr){
		String oldValue = getLocaleKey();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLocaleKey(newValue);
		this.onChangeProperty(LOCALE_KEY_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeActionKeyProperty(String newValueExpr){
		String oldValue = getActionKey();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateActionKey(newValue);
		this.onChangeProperty(ACTION_KEY_PROPERTY, oldValue, newValue);
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
			
			
			
	protected void changeUrlProperty(String newValueExpr){
		String oldValue = getUrl();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateUrl(newValue);
		this.onChangeProperty(URL_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public FormAction updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setLabel(String label){
		this.mLabel = trimString(label);;
	}
	public String getLabel(){
		return this.mLabel;
	}
	public FormAction updateLabel(String label){
		this.mLabel = trimString(label);;
		this.changed = true;
		return this;
	}
	
	
	public void setLocaleKey(String localeKey){
		this.mLocaleKey = trimString(localeKey);;
	}
	public String getLocaleKey(){
		return this.mLocaleKey;
	}
	public FormAction updateLocaleKey(String localeKey){
		this.mLocaleKey = trimString(localeKey);;
		this.changed = true;
		return this;
	}
	
	
	public void setActionKey(String actionKey){
		this.mActionKey = trimString(actionKey);;
	}
	public String getActionKey(){
		return this.mActionKey;
	}
	public FormAction updateActionKey(String actionKey){
		this.mActionKey = trimString(actionKey);;
		this.changed = true;
		return this;
	}
	
	
	public void setLevel(String level){
		this.mLevel = trimString(level);;
	}
	public String getLevel(){
		return this.mLevel;
	}
	public FormAction updateLevel(String level){
		this.mLevel = trimString(level);;
		this.changed = true;
		return this;
	}
	
	
	public void setUrl(String url){
		this.mUrl = trimString(url);;
	}
	public String getUrl(){
		return this.mUrl;
	}
	public FormAction updateUrl(String url){
		this.mUrl = trimString(url);;
		this.changed = true;
		return this;
	}
	
	
	public void setForm(GenericForm form){
		this.mForm = form;;
	}
	public GenericForm getForm(){
		return this.mForm;
	}
	public FormAction updateForm(GenericForm form){
		this.mForm = form;;
		this.changed = true;
		return this;
	}
	
	
	public void clearForm(){
		setForm ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public FormAction updateVersion(int version){
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
		appendKeyValuePair(result, LABEL_PROPERTY, getLabel());
		appendKeyValuePair(result, LOCALE_KEY_PROPERTY, getLocaleKey());
		appendKeyValuePair(result, ACTION_KEY_PROPERTY, getActionKey());
		appendKeyValuePair(result, LEVEL_PROPERTY, getLevel());
		appendKeyValuePair(result, URL_PROPERTY, getUrl());
		appendKeyValuePair(result, FORM_PROPERTY, getForm());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof FormAction){
		
		
			FormAction dest =(FormAction)baseDest;
		
			dest.setId(getId());
			dest.setLabel(getLabel());
			dest.setLocaleKey(getLocaleKey());
			dest.setActionKey(getActionKey());
			dest.setLevel(getLevel());
			dest.setUrl(getUrl());
			dest.setForm(getForm());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("FormAction{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tlabel='"+getLabel()+"';");
		stringBuilder.append("\tlocaleKey='"+getLocaleKey()+"';");
		stringBuilder.append("\tactionKey='"+getActionKey()+"';");
		stringBuilder.append("\tlevel='"+getLevel()+"';");
		stringBuilder.append("\turl='"+getUrl()+"';");
		if(getForm() != null ){
 			stringBuilder.append("\tform='GenericForm("+getForm().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}









