
package com.doublechaintech.retailscm.objectaccess;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.userapp.UserApp;

@JsonSerialize(using = ObjectAccessSerializer.class)
public class ObjectAccess extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String OBJECT_TYPE_PROPERTY           = "objectType"        ;
	public static final String LIST1_PROPERTY                 = "list1"             ;
	public static final String LIST2_PROPERTY                 = "list2"             ;
	public static final String LIST3_PROPERTY                 = "list3"             ;
	public static final String LIST4_PROPERTY                 = "list4"             ;
	public static final String LIST5_PROPERTY                 = "list5"             ;
	public static final String LIST6_PROPERTY                 = "list6"             ;
	public static final String LIST7_PROPERTY                 = "list7"             ;
	public static final String LIST8_PROPERTY                 = "list8"             ;
	public static final String LIST9_PROPERTY                 = "list9"             ;
	public static final String APP_PROPERTY                   = "app"               ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="ObjectAccess";
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
	protected		String              	mObjectType         ;
	protected		String              	mList1              ;
	protected		String              	mList2              ;
	protected		String              	mList3              ;
	protected		String              	mList4              ;
	protected		String              	mList5              ;
	protected		String              	mList6              ;
	protected		String              	mList7              ;
	protected		String              	mList8              ;
	protected		String              	mList9              ;
	protected		UserApp             	mApp                ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	ObjectAccess(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setApp( null );

		this.changed = true;
	}
	
	public 	ObjectAccess(String name, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9, UserApp app)
	{
		setName(name);
		setObjectType(objectType);
		setList1(list1);
		setList2(list2);
		setList3(list3);
		setList4(list4);
		setList5(list5);
		setList6(list6);
		setList7(list7);
		setList8(list8);
		setList9(list9);
		setApp(app);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(OBJECT_TYPE_PROPERTY.equals(property)){
			changeObjectTypeProperty(newValueExpr);
		}
		if(LIST1_PROPERTY.equals(property)){
			changeList1Property(newValueExpr);
		}
		if(LIST2_PROPERTY.equals(property)){
			changeList2Property(newValueExpr);
		}
		if(LIST3_PROPERTY.equals(property)){
			changeList3Property(newValueExpr);
		}
		if(LIST4_PROPERTY.equals(property)){
			changeList4Property(newValueExpr);
		}
		if(LIST5_PROPERTY.equals(property)){
			changeList5Property(newValueExpr);
		}
		if(LIST6_PROPERTY.equals(property)){
			changeList6Property(newValueExpr);
		}
		if(LIST7_PROPERTY.equals(property)){
			changeList7Property(newValueExpr);
		}
		if(LIST8_PROPERTY.equals(property)){
			changeList8Property(newValueExpr);
		}
		if(LIST9_PROPERTY.equals(property)){
			changeList9Property(newValueExpr);
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
			
			
			
	protected void changeObjectTypeProperty(String newValueExpr){
		String oldValue = getObjectType();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateObjectType(newValue);
		this.onChangeProperty(OBJECT_TYPE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeList1Property(String newValueExpr){
		String oldValue = getList1();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateList1(newValue);
		this.onChangeProperty(LIST1_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeList2Property(String newValueExpr){
		String oldValue = getList2();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateList2(newValue);
		this.onChangeProperty(LIST2_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeList3Property(String newValueExpr){
		String oldValue = getList3();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateList3(newValue);
		this.onChangeProperty(LIST3_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeList4Property(String newValueExpr){
		String oldValue = getList4();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateList4(newValue);
		this.onChangeProperty(LIST4_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeList5Property(String newValueExpr){
		String oldValue = getList5();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateList5(newValue);
		this.onChangeProperty(LIST5_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeList6Property(String newValueExpr){
		String oldValue = getList6();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateList6(newValue);
		this.onChangeProperty(LIST6_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeList7Property(String newValueExpr){
		String oldValue = getList7();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateList7(newValue);
		this.onChangeProperty(LIST7_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeList8Property(String newValueExpr){
		String oldValue = getList8();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateList8(newValue);
		this.onChangeProperty(LIST8_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeList9Property(String newValueExpr){
		String oldValue = getList9();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateList9(newValue);
		this.onChangeProperty(LIST9_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public ObjectAccess updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public ObjectAccess updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setObjectType(String objectType){
		this.mObjectType = trimString(objectType);;
	}
	public String getObjectType(){
		return this.mObjectType;
	}
	public ObjectAccess updateObjectType(String objectType){
		this.mObjectType = trimString(objectType);;
		this.changed = true;
		return this;
	}
	
	
	public void setList1(String list1){
		this.mList1 = trimString(list1);;
	}
	public String getList1(){
		return this.mList1;
	}
	public ObjectAccess updateList1(String list1){
		this.mList1 = trimString(list1);;
		this.changed = true;
		return this;
	}
	
	
	public void setList2(String list2){
		this.mList2 = trimString(list2);;
	}
	public String getList2(){
		return this.mList2;
	}
	public ObjectAccess updateList2(String list2){
		this.mList2 = trimString(list2);;
		this.changed = true;
		return this;
	}
	
	
	public void setList3(String list3){
		this.mList3 = trimString(list3);;
	}
	public String getList3(){
		return this.mList3;
	}
	public ObjectAccess updateList3(String list3){
		this.mList3 = trimString(list3);;
		this.changed = true;
		return this;
	}
	
	
	public void setList4(String list4){
		this.mList4 = trimString(list4);;
	}
	public String getList4(){
		return this.mList4;
	}
	public ObjectAccess updateList4(String list4){
		this.mList4 = trimString(list4);;
		this.changed = true;
		return this;
	}
	
	
	public void setList5(String list5){
		this.mList5 = trimString(list5);;
	}
	public String getList5(){
		return this.mList5;
	}
	public ObjectAccess updateList5(String list5){
		this.mList5 = trimString(list5);;
		this.changed = true;
		return this;
	}
	
	
	public void setList6(String list6){
		this.mList6 = trimString(list6);;
	}
	public String getList6(){
		return this.mList6;
	}
	public ObjectAccess updateList6(String list6){
		this.mList6 = trimString(list6);;
		this.changed = true;
		return this;
	}
	
	
	public void setList7(String list7){
		this.mList7 = trimString(list7);;
	}
	public String getList7(){
		return this.mList7;
	}
	public ObjectAccess updateList7(String list7){
		this.mList7 = trimString(list7);;
		this.changed = true;
		return this;
	}
	
	
	public void setList8(String list8){
		this.mList8 = trimString(list8);;
	}
	public String getList8(){
		return this.mList8;
	}
	public ObjectAccess updateList8(String list8){
		this.mList8 = trimString(list8);;
		this.changed = true;
		return this;
	}
	
	
	public void setList9(String list9){
		this.mList9 = trimString(list9);;
	}
	public String getList9(){
		return this.mList9;
	}
	public ObjectAccess updateList9(String list9){
		this.mList9 = trimString(list9);;
		this.changed = true;
		return this;
	}
	
	
	public void setApp(UserApp app){
		this.mApp = app;;
	}
	public UserApp getApp(){
		return this.mApp;
	}
	public ObjectAccess updateApp(UserApp app){
		this.mApp = app;;
		this.changed = true;
		return this;
	}
	
	
	public void clearApp(){
		setApp ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public ObjectAccess updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getApp(), internalType);

		
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
		appendKeyValuePair(result, OBJECT_TYPE_PROPERTY, getObjectType());
		appendKeyValuePair(result, LIST1_PROPERTY, getList1());
		appendKeyValuePair(result, LIST2_PROPERTY, getList2());
		appendKeyValuePair(result, LIST3_PROPERTY, getList3());
		appendKeyValuePair(result, LIST4_PROPERTY, getList4());
		appendKeyValuePair(result, LIST5_PROPERTY, getList5());
		appendKeyValuePair(result, LIST6_PROPERTY, getList6());
		appendKeyValuePair(result, LIST7_PROPERTY, getList7());
		appendKeyValuePair(result, LIST8_PROPERTY, getList8());
		appendKeyValuePair(result, LIST9_PROPERTY, getList9());
		appendKeyValuePair(result, APP_PROPERTY, getApp());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ObjectAccess){
		
		
			ObjectAccess dest =(ObjectAccess)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setObjectType(getObjectType());
			dest.setList1(getList1());
			dest.setList2(getList2());
			dest.setList3(getList3());
			dest.setList4(getList4());
			dest.setList5(getList5());
			dest.setList6(getList6());
			dest.setList7(getList7());
			dest.setList8(getList8());
			dest.setList9(getList9());
			dest.setApp(getApp());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ObjectAccess{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tobjectType='"+getObjectType()+"';");
		stringBuilder.append("\tlist1='"+getList1()+"';");
		stringBuilder.append("\tlist2='"+getList2()+"';");
		stringBuilder.append("\tlist3='"+getList3()+"';");
		stringBuilder.append("\tlist4='"+getList4()+"';");
		stringBuilder.append("\tlist5='"+getList5()+"';");
		stringBuilder.append("\tlist6='"+getList6()+"';");
		stringBuilder.append("\tlist7='"+getList7()+"';");
		stringBuilder.append("\tlist8='"+getList8()+"';");
		stringBuilder.append("\tlist9='"+getList9()+"';");
		if(getApp() != null ){
 			stringBuilder.append("\tapp='UserApp("+getApp().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

