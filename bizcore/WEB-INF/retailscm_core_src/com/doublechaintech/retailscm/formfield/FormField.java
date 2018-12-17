
package com.doublechaintech.retailscm.formfield;

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

@JsonSerialize(using = FormFieldSerializer.class)
public class FormField extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String LABEL_PROPERTY                 = "label"             ;
	public static final String LOCALE_KEY_PROPERTY            = "localeKey"         ;
	public static final String PARAMETER_NAME_PROPERTY        = "parameterName"     ;
	public static final String TYPE_PROPERTY                  = "type"              ;
	public static final String FORM_PROPERTY                  = "form"              ;
	public static final String PLACEHOLDER_PROPERTY           = "placeholder"       ;
	public static final String DEFAULT_VALUE_PROPERTY         = "defaultValue"      ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String FIELD_GROUP_PROPERTY           = "fieldGroup"        ;
	public static final String MINIMUM_VALUE_PROPERTY         = "minimumValue"      ;
	public static final String MAXIMUM_VALUE_PROPERTY         = "maximumValue"      ;
	public static final String REQUIRED_PROPERTY              = "required"          ;
	public static final String DISABLED_PROPERTY              = "disabled"          ;
	public static final String CUSTOM_RENDERING_PROPERTY      = "customRendering"   ;
	public static final String CANDIDATE_VALUES_PROPERTY      = "candidateValues"   ;
	public static final String SUGGEST_VALUES_PROPERTY        = "suggestValues"     ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="FormField";
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
	protected		String              	mParameterName      ;
	protected		String              	mType               ;
	protected		GenericForm         	mForm               ;
	protected		String              	mPlaceholder        ;
	protected		String              	mDefaultValue       ;
	protected		String              	mDescription        ;
	protected		String              	mFieldGroup         ;
	protected		String              	mMinimumValue       ;
	protected		String              	mMaximumValue       ;
	protected		boolean             	mRequired           ;
	protected		boolean             	mDisabled           ;
	protected		boolean             	mCustomRendering    ;
	protected		String              	mCandidateValues    ;
	protected		String              	mSuggestValues      ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	FormField(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setForm( null );

		this.changed = true;
	}
	
	public 	FormField(String label, String localeKey, String parameterName, String type, GenericForm form, String placeholder, String defaultValue, String description, String fieldGroup, String minimumValue, String maximumValue, boolean required, boolean disabled, boolean customRendering, String candidateValues, String suggestValues)
	{
		setLabel(label);
		setLocaleKey(localeKey);
		setParameterName(parameterName);
		setType(type);
		setForm(form);
		setPlaceholder(placeholder);
		setDefaultValue(defaultValue);
		setDescription(description);
		setFieldGroup(fieldGroup);
		setMinimumValue(minimumValue);
		setMaximumValue(maximumValue);
		setRequired(required);
		setDisabled(disabled);
		setCustomRendering(customRendering);
		setCandidateValues(candidateValues);
		setSuggestValues(suggestValues);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(LABEL_PROPERTY.equals(property)){
			changeLabelProperty(newValueExpr);
		}
		if(LOCALE_KEY_PROPERTY.equals(property)){
			changeLocaleKeyProperty(newValueExpr);
		}
		if(PARAMETER_NAME_PROPERTY.equals(property)){
			changeParameterNameProperty(newValueExpr);
		}
		if(TYPE_PROPERTY.equals(property)){
			changeTypeProperty(newValueExpr);
		}
		if(PLACEHOLDER_PROPERTY.equals(property)){
			changePlaceholderProperty(newValueExpr);
		}
		if(DEFAULT_VALUE_PROPERTY.equals(property)){
			changeDefaultValueProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
		}
		if(FIELD_GROUP_PROPERTY.equals(property)){
			changeFieldGroupProperty(newValueExpr);
		}
		if(MINIMUM_VALUE_PROPERTY.equals(property)){
			changeMinimumValueProperty(newValueExpr);
		}
		if(MAXIMUM_VALUE_PROPERTY.equals(property)){
			changeMaximumValueProperty(newValueExpr);
		}
		if(REQUIRED_PROPERTY.equals(property)){
			changeRequiredProperty(newValueExpr);
		}
		if(DISABLED_PROPERTY.equals(property)){
			changeDisabledProperty(newValueExpr);
		}
		if(CUSTOM_RENDERING_PROPERTY.equals(property)){
			changeCustomRenderingProperty(newValueExpr);
		}
		if(CANDIDATE_VALUES_PROPERTY.equals(property)){
			changeCandidateValuesProperty(newValueExpr);
		}
		if(SUGGEST_VALUES_PROPERTY.equals(property)){
			changeSuggestValuesProperty(newValueExpr);
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
			
			
			
	protected void changeTypeProperty(String newValueExpr){
		String oldValue = getType();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateType(newValue);
		this.onChangeProperty(TYPE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changePlaceholderProperty(String newValueExpr){
		String oldValue = getPlaceholder();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePlaceholder(newValue);
		this.onChangeProperty(PLACEHOLDER_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeDefaultValueProperty(String newValueExpr){
		String oldValue = getDefaultValue();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDefaultValue(newValue);
		this.onChangeProperty(DEFAULT_VALUE_PROPERTY, oldValue, newValue);
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
			
			
			
	protected void changeFieldGroupProperty(String newValueExpr){
		String oldValue = getFieldGroup();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateFieldGroup(newValue);
		this.onChangeProperty(FIELD_GROUP_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeMinimumValueProperty(String newValueExpr){
		String oldValue = getMinimumValue();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateMinimumValue(newValue);
		this.onChangeProperty(MINIMUM_VALUE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeMaximumValueProperty(String newValueExpr){
		String oldValue = getMaximumValue();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateMaximumValue(newValue);
		this.onChangeProperty(MAXIMUM_VALUE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeRequiredProperty(String newValueExpr){
		boolean oldValue = getRequired();
		boolean newValue = parseBoolean(newValueExpr);
		if(equalsBoolean(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateRequired(newValue);
		this.onChangeProperty(REQUIRED_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeDisabledProperty(String newValueExpr){
		boolean oldValue = getDisabled();
		boolean newValue = parseBoolean(newValueExpr);
		if(equalsBoolean(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDisabled(newValue);
		this.onChangeProperty(DISABLED_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeCustomRenderingProperty(String newValueExpr){
		boolean oldValue = getCustomRendering();
		boolean newValue = parseBoolean(newValueExpr);
		if(equalsBoolean(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCustomRendering(newValue);
		this.onChangeProperty(CUSTOM_RENDERING_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeCandidateValuesProperty(String newValueExpr){
		String oldValue = getCandidateValues();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCandidateValues(newValue);
		this.onChangeProperty(CANDIDATE_VALUES_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeSuggestValuesProperty(String newValueExpr){
		String oldValue = getSuggestValues();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateSuggestValues(newValue);
		this.onChangeProperty(SUGGEST_VALUES_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public FormField updateId(String id){
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
	public FormField updateLabel(String label){
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
	public FormField updateLocaleKey(String localeKey){
		this.mLocaleKey = trimString(localeKey);;
		this.changed = true;
		return this;
	}
	
	
	public void setParameterName(String parameterName){
		this.mParameterName = trimString(parameterName);;
	}
	public String getParameterName(){
		return this.mParameterName;
	}
	public FormField updateParameterName(String parameterName){
		this.mParameterName = trimString(parameterName);;
		this.changed = true;
		return this;
	}
	
	
	public void setType(String type){
		this.mType = trimString(type);;
	}
	public String getType(){
		return this.mType;
	}
	public FormField updateType(String type){
		this.mType = trimString(type);;
		this.changed = true;
		return this;
	}
	
	
	public void setForm(GenericForm form){
		this.mForm = form;;
	}
	public GenericForm getForm(){
		return this.mForm;
	}
	public FormField updateForm(GenericForm form){
		this.mForm = form;;
		this.changed = true;
		return this;
	}
	
	
	public void clearForm(){
		setForm ( null );
		this.changed = true;
	}
	
	public void setPlaceholder(String placeholder){
		this.mPlaceholder = trimString(placeholder);;
	}
	public String getPlaceholder(){
		return this.mPlaceholder;
	}
	public FormField updatePlaceholder(String placeholder){
		this.mPlaceholder = trimString(placeholder);;
		this.changed = true;
		return this;
	}
	
	
	public void setDefaultValue(String defaultValue){
		this.mDefaultValue = trimString(defaultValue);;
	}
	public String getDefaultValue(){
		return this.mDefaultValue;
	}
	public FormField updateDefaultValue(String defaultValue){
		this.mDefaultValue = trimString(defaultValue);;
		this.changed = true;
		return this;
	}
	
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public FormField updateDescription(String description){
		this.mDescription = trimString(description);;
		this.changed = true;
		return this;
	}
	
	
	public void setFieldGroup(String fieldGroup){
		this.mFieldGroup = trimString(fieldGroup);;
	}
	public String getFieldGroup(){
		return this.mFieldGroup;
	}
	public FormField updateFieldGroup(String fieldGroup){
		this.mFieldGroup = trimString(fieldGroup);;
		this.changed = true;
		return this;
	}
	
	
	public void setMinimumValue(String minimumValue){
		this.mMinimumValue = trimString(minimumValue);;
	}
	public String getMinimumValue(){
		return this.mMinimumValue;
	}
	public FormField updateMinimumValue(String minimumValue){
		this.mMinimumValue = trimString(minimumValue);;
		this.changed = true;
		return this;
	}
	
	
	public void setMaximumValue(String maximumValue){
		this.mMaximumValue = trimString(maximumValue);;
	}
	public String getMaximumValue(){
		return this.mMaximumValue;
	}
	public FormField updateMaximumValue(String maximumValue){
		this.mMaximumValue = trimString(maximumValue);;
		this.changed = true;
		return this;
	}
	
	
	public void setRequired(boolean required){
		this.mRequired = required;;
	}
	public boolean getRequired(){
		return this.mRequired;
	}
	public FormField updateRequired(boolean required){
		this.mRequired = required;;
		this.changed = true;
		return this;
	}
	
	
	public void setDisabled(boolean disabled){
		this.mDisabled = disabled;;
	}
	public boolean getDisabled(){
		return this.mDisabled;
	}
	public FormField updateDisabled(boolean disabled){
		this.mDisabled = disabled;;
		this.changed = true;
		return this;
	}
	
	
	public void setCustomRendering(boolean customRendering){
		this.mCustomRendering = customRendering;;
	}
	public boolean getCustomRendering(){
		return this.mCustomRendering;
	}
	public FormField updateCustomRendering(boolean customRendering){
		this.mCustomRendering = customRendering;;
		this.changed = true;
		return this;
	}
	
	
	public void setCandidateValues(String candidateValues){
		this.mCandidateValues = trimString(candidateValues);;
	}
	public String getCandidateValues(){
		return this.mCandidateValues;
	}
	public FormField updateCandidateValues(String candidateValues){
		this.mCandidateValues = trimString(candidateValues);;
		this.changed = true;
		return this;
	}
	
	
	public void setSuggestValues(String suggestValues){
		this.mSuggestValues = trimString(suggestValues);;
	}
	public String getSuggestValues(){
		return this.mSuggestValues;
	}
	public FormField updateSuggestValues(String suggestValues){
		this.mSuggestValues = trimString(suggestValues);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public FormField updateVersion(int version){
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
		appendKeyValuePair(result, PARAMETER_NAME_PROPERTY, getParameterName());
		appendKeyValuePair(result, TYPE_PROPERTY, getType());
		appendKeyValuePair(result, FORM_PROPERTY, getForm());
		appendKeyValuePair(result, PLACEHOLDER_PROPERTY, getPlaceholder());
		appendKeyValuePair(result, DEFAULT_VALUE_PROPERTY, getDefaultValue());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, FIELD_GROUP_PROPERTY, getFieldGroup());
		appendKeyValuePair(result, MINIMUM_VALUE_PROPERTY, getMinimumValue());
		appendKeyValuePair(result, MAXIMUM_VALUE_PROPERTY, getMaximumValue());
		appendKeyValuePair(result, REQUIRED_PROPERTY, getRequired());
		appendKeyValuePair(result, DISABLED_PROPERTY, getDisabled());
		appendKeyValuePair(result, CUSTOM_RENDERING_PROPERTY, getCustomRendering());
		appendKeyValuePair(result, CANDIDATE_VALUES_PROPERTY, getCandidateValues());
		appendKeyValuePair(result, SUGGEST_VALUES_PROPERTY, getSuggestValues());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof FormField){
		
		
			FormField dest =(FormField)baseDest;
		
			dest.setId(getId());
			dest.setLabel(getLabel());
			dest.setLocaleKey(getLocaleKey());
			dest.setParameterName(getParameterName());
			dest.setType(getType());
			dest.setForm(getForm());
			dest.setPlaceholder(getPlaceholder());
			dest.setDefaultValue(getDefaultValue());
			dest.setDescription(getDescription());
			dest.setFieldGroup(getFieldGroup());
			dest.setMinimumValue(getMinimumValue());
			dest.setMaximumValue(getMaximumValue());
			dest.setRequired(getRequired());
			dest.setDisabled(getDisabled());
			dest.setCustomRendering(getCustomRendering());
			dest.setCandidateValues(getCandidateValues());
			dest.setSuggestValues(getSuggestValues());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("FormField{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tlabel='"+getLabel()+"';");
		stringBuilder.append("\tlocaleKey='"+getLocaleKey()+"';");
		stringBuilder.append("\tparameterName='"+getParameterName()+"';");
		stringBuilder.append("\ttype='"+getType()+"';");
		if(getForm() != null ){
 			stringBuilder.append("\tform='GenericForm("+getForm().getId()+")';");
 		}
		stringBuilder.append("\tplaceholder='"+getPlaceholder()+"';");
		stringBuilder.append("\tdefaultValue='"+getDefaultValue()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tfieldGroup='"+getFieldGroup()+"';");
		stringBuilder.append("\tminimumValue='"+getMinimumValue()+"';");
		stringBuilder.append("\tmaximumValue='"+getMaximumValue()+"';");
		stringBuilder.append("\trequired='"+getRequired()+"';");
		stringBuilder.append("\tdisabled='"+getDisabled()+"';");
		stringBuilder.append("\tcustomRendering='"+getCustomRendering()+"';");
		stringBuilder.append("\tcandidateValues='"+getCandidateValues()+"';");
		stringBuilder.append("\tsuggestValues='"+getSuggestValues()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

