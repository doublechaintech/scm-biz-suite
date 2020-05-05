
package com.doublechaintech.retailscm.treenode;

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

@JsonSerialize(using = TreeNodeSerializer.class)
public class TreeNode extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NODE_ID_PROPERTY               = "nodeId"            ;
	public static final String NODE_TYPE_PROPERTY             = "nodeType"          ;
	public static final String LEFT_VALUE_PROPERTY            = "leftValue"         ;
	public static final String RIGHT_VALUE_PROPERTY           = "rightValue"        ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="TreeNode";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getNodeId();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mNodeId             ;
	protected		String              	mNodeType           ;
	protected		int                 	mLeftValue          ;
	protected		int                 	mRightValue         ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	TreeNode(){
		// lazy load for all the properties
	}
	public 	static TreeNode withId(String id){
		TreeNode treeNode = new TreeNode();
		treeNode.setId(id);
		treeNode.setVersion(Integer.MAX_VALUE);
		return treeNode;
	}
	public 	static TreeNode refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NODE_ID_PROPERTY.equals(property)){
			changeNodeIdProperty(newValueExpr);
		}
		if(NODE_TYPE_PROPERTY.equals(property)){
			changeNodeTypeProperty(newValueExpr);
		}
		if(LEFT_VALUE_PROPERTY.equals(property)){
			changeLeftValueProperty(newValueExpr);
		}
		if(RIGHT_VALUE_PROPERTY.equals(property)){
			changeRightValueProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNodeIdProperty(String newValueExpr){
	
		String oldValue = getNodeId();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateNodeId(newValue);
		this.onChangeProperty(NODE_ID_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeNodeTypeProperty(String newValueExpr){
	
		String oldValue = getNodeType();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateNodeType(newValue);
		this.onChangeProperty(NODE_TYPE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeLeftValueProperty(String newValueExpr){
	
		int oldValue = getLeftValue();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLeftValue(newValue);
		this.onChangeProperty(LEFT_VALUE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeRightValueProperty(String newValueExpr){
	
		int oldValue = getRightValue();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateRightValue(newValue);
		this.onChangeProperty(RIGHT_VALUE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NODE_ID_PROPERTY.equals(property)){
			return getNodeId();
		}
		if(NODE_TYPE_PROPERTY.equals(property)){
			return getNodeType();
		}
		if(LEFT_VALUE_PROPERTY.equals(property)){
			return getLeftValue();
		}
		if(RIGHT_VALUE_PROPERTY.equals(property)){
			return getRightValue();
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
	public TreeNode updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setNodeId(String nodeId){
		this.mNodeId = trimString(nodeId);;
	}
	public String getNodeId(){
		return this.mNodeId;
	}
	public TreeNode updateNodeId(String nodeId){
		this.mNodeId = trimString(nodeId);;
		this.changed = true;
		return this;
	}
	public void mergeNodeId(String nodeId){
		if(nodeId != null) { setNodeId(nodeId);}
	}
	
	
	public void clearNodeId(){
		setNodeId ( null );
		this.changed = true;
	}
	
	public void setNodeType(String nodeType){
		this.mNodeType = trimString(nodeType);;
	}
	public String getNodeType(){
		return this.mNodeType;
	}
	public TreeNode updateNodeType(String nodeType){
		this.mNodeType = trimString(nodeType);;
		this.changed = true;
		return this;
	}
	public void mergeNodeType(String nodeType){
		if(nodeType != null) { setNodeType(nodeType);}
	}
	
	
	public void setLeftValue(int leftValue){
		this.mLeftValue = leftValue;;
	}
	public int getLeftValue(){
		return this.mLeftValue;
	}
	public TreeNode updateLeftValue(int leftValue){
		this.mLeftValue = leftValue;;
		this.changed = true;
		return this;
	}
	public void mergeLeftValue(int leftValue){
		setLeftValue(leftValue);
	}
	
	
	public void setRightValue(int rightValue){
		this.mRightValue = rightValue;;
	}
	public int getRightValue(){
		return this.mRightValue;
	}
	public TreeNode updateRightValue(int rightValue){
		this.mRightValue = rightValue;;
		this.changed = true;
		return this;
	}
	public void mergeRightValue(int rightValue){
		setRightValue(rightValue);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public TreeNode updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
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
		appendKeyValuePair(result, NODE_ID_PROPERTY, getNodeId());
		appendKeyValuePair(result, NODE_TYPE_PROPERTY, getNodeType());
		appendKeyValuePair(result, LEFT_VALUE_PROPERTY, getLeftValue());
		appendKeyValuePair(result, RIGHT_VALUE_PROPERTY, getRightValue());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TreeNode){
		
		
			TreeNode dest =(TreeNode)baseDest;
		
			dest.setId(getId());
			dest.setNodeId(getNodeId());
			dest.setNodeType(getNodeType());
			dest.setLeftValue(getLeftValue());
			dest.setRightValue(getRightValue());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TreeNode){
		
			
			TreeNode dest =(TreeNode)baseDest;
		
			dest.mergeId(getId());
			dest.mergeNodeId(getNodeId());
			dest.mergeNodeType(getNodeType());
			dest.mergeLeftValue(getLeftValue());
			dest.mergeRightValue(getRightValue());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TreeNode){
		
			
			TreeNode dest =(TreeNode)baseDest;
		
			dest.mergeId(getId());
			dest.mergeNodeId(getNodeId());
			dest.mergeNodeType(getNodeType());
			dest.mergeLeftValue(getLeftValue());
			dest.mergeRightValue(getRightValue());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getNodeId(), getNodeType(), getLeftValue(), getRightValue(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("TreeNode{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tnodeId='"+getNodeId()+"';");
		stringBuilder.append("\tnodeType='"+getNodeType()+"';");
		stringBuilder.append("\tleftValue='"+getLeftValue()+"';");
		stringBuilder.append("\trightValue='"+getRightValue()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	
	public void increaseLeftValue(int incLeftValue){
		updateLeftValue(this.mLeftValue +  incLeftValue);
	}
	public void decreaseLeftValue(int decLeftValue){
		updateLeftValue(this.mLeftValue - decLeftValue);
	}
	
	public void increaseRightValue(int incRightValue){
		updateRightValue(this.mRightValue +  incRightValue);
	}
	public void decreaseRightValue(int decRightValue){
		updateRightValue(this.mRightValue - decRightValue);
	}
	

}

















