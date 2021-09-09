
package com.doublechaintech.retailscm.treenode;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;









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


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NODE_ID_PROPERTY, "node_id", "节点ID")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NODE_TYPE_PROPERTY, "node_type", "节点类型")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(LEFT_VALUE_PROPERTY, "left_value", "左值")
        .withType("int", "int"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(RIGHT_VALUE_PROPERTY, "right_value", "右值")
        .withType("int", "int"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NODE_ID_PROPERTY ,NODE_TYPE_PROPERTY ,LEFT_VALUE_PROPERTY ,RIGHT_VALUE_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    
    return parents;
  }

  public TreeNode want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public TreeNode wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getNodeId();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		String              	nodeId              ;
	protected		String              	nodeType            ;
	protected		int                 	leftValue           ;
	protected		int                 	rightValue          ;
	protected		int                 	version             ;

	



	public 	TreeNode(){
		// lazy load for all the properties
	}
	public 	static TreeNode withId(String id){
		TreeNode treeNode = new TreeNode();
		treeNode.setId(id);
		treeNode.setVersion(Integer.MAX_VALUE);
		treeNode.setChecked(true);
		return treeNode;
	}
	public 	static TreeNode refById(String id){
		return withId(id);
	}

  public TreeNode limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public TreeNode limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static TreeNode searchExample(){
    TreeNode treeNode = new TreeNode();
    		treeNode.setLeftValue(UNSET_INT);
		treeNode.setRightValue(UNSET_INT);
		treeNode.setVersion(UNSET_INT);

    return treeNode;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
		setChecked(false);
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

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public TreeNode updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public TreeNode orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public TreeNode ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public TreeNode addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setNodeId(String nodeId){String oldNodeId = this.nodeId;String newNodeId = trimString(nodeId);this.nodeId = newNodeId;}
	public String nodeId(){
doLoad();
return getNodeId();
}
	public String getNodeId(){
		return this.nodeId;
	}
	public TreeNode updateNodeId(String nodeId){String oldNodeId = this.nodeId;String newNodeId = trimString(nodeId);if(!shouldReplaceBy(newNodeId, oldNodeId)){return this;}this.nodeId = newNodeId;addPropertyChange(NODE_ID_PROPERTY, oldNodeId, newNodeId);this.changed = true;setChecked(false);return this;}
	public TreeNode orderByNodeId(boolean asc){
doAddOrderBy(NODE_ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createNodeIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NODE_ID_PROPERTY, operator, parameters);
}
	public TreeNode ignoreNodeIdCriteria(){super.ignoreSearchProperty(NODE_ID_PROPERTY);
return this;
}
	public TreeNode addNodeIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNodeIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeNodeId(String nodeId){
		if(nodeId != null) { setNodeId(nodeId);}
	}

	
	public void setNodeType(String nodeType){String oldNodeType = this.nodeType;String newNodeType = trimString(nodeType);this.nodeType = newNodeType;}
	public String nodeType(){
doLoad();
return getNodeType();
}
	public String getNodeType(){
		return this.nodeType;
	}
	public TreeNode updateNodeType(String nodeType){String oldNodeType = this.nodeType;String newNodeType = trimString(nodeType);if(!shouldReplaceBy(newNodeType, oldNodeType)){return this;}this.nodeType = newNodeType;addPropertyChange(NODE_TYPE_PROPERTY, oldNodeType, newNodeType);this.changed = true;setChecked(false);return this;}
	public TreeNode orderByNodeType(boolean asc){
doAddOrderBy(NODE_TYPE_PROPERTY, asc);
return this;
}
	public SearchCriteria createNodeTypeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NODE_TYPE_PROPERTY, operator, parameters);
}
	public TreeNode ignoreNodeTypeCriteria(){super.ignoreSearchProperty(NODE_TYPE_PROPERTY);
return this;
}
	public TreeNode addNodeTypeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNodeTypeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeNodeType(String nodeType){
		if(nodeType != null) { setNodeType(nodeType);}
	}

	
	public void setLeftValue(int leftValue){int oldLeftValue = this.leftValue;int newLeftValue = leftValue;this.leftValue = newLeftValue;}
	public int leftValue(){
doLoad();
return getLeftValue();
}
	public int getLeftValue(){
		return this.leftValue;
	}
	public TreeNode updateLeftValue(int leftValue){int oldLeftValue = this.leftValue;int newLeftValue = leftValue;if(!shouldReplaceBy(newLeftValue, oldLeftValue)){return this;}this.leftValue = newLeftValue;addPropertyChange(LEFT_VALUE_PROPERTY, oldLeftValue, newLeftValue);this.changed = true;setChecked(false);return this;}
	public TreeNode orderByLeftValue(boolean asc){
doAddOrderBy(LEFT_VALUE_PROPERTY, asc);
return this;
}
	public SearchCriteria createLeftValueCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LEFT_VALUE_PROPERTY, operator, parameters);
}
	public TreeNode ignoreLeftValueCriteria(){super.ignoreSearchProperty(LEFT_VALUE_PROPERTY);
return this;
}
	public TreeNode addLeftValueCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createLeftValueCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeLeftValue(int leftValue){
		setLeftValue(leftValue);
	}

	
	public void setRightValue(int rightValue){int oldRightValue = this.rightValue;int newRightValue = rightValue;this.rightValue = newRightValue;}
	public int rightValue(){
doLoad();
return getRightValue();
}
	public int getRightValue(){
		return this.rightValue;
	}
	public TreeNode updateRightValue(int rightValue){int oldRightValue = this.rightValue;int newRightValue = rightValue;if(!shouldReplaceBy(newRightValue, oldRightValue)){return this;}this.rightValue = newRightValue;addPropertyChange(RIGHT_VALUE_PROPERTY, oldRightValue, newRightValue);this.changed = true;setChecked(false);return this;}
	public TreeNode orderByRightValue(boolean asc){
doAddOrderBy(RIGHT_VALUE_PROPERTY, asc);
return this;
}
	public SearchCriteria createRightValueCriteria(QueryOperator operator, Object... parameters){
return createCriteria(RIGHT_VALUE_PROPERTY, operator, parameters);
}
	public TreeNode ignoreRightValueCriteria(){super.ignoreSearchProperty(RIGHT_VALUE_PROPERTY);
return this;
}
	public TreeNode addRightValueCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createRightValueCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeRightValue(int rightValue){
		setRightValue(rightValue);
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public TreeNode updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public TreeNode orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public TreeNode ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public TreeNode addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
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


	public static TreeNode createWith(RetailscmUserContext userContext, ThrowingFunction<TreeNode,TreeNode,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<TreeNode> customCreator = mapper.findCustomCreator(TreeNode.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    TreeNode result = new TreeNode();
    result.setNodeId(mapper.tryToGet(TreeNode.class, NODE_ID_PROPERTY, String.class,
        0, false, result.getNodeId(), params));
    result.setNodeType(mapper.tryToGet(TreeNode.class, NODE_TYPE_PROPERTY, String.class,
        1, false, result.getNodeType(), params));
    result.setLeftValue(mapper.tryToGet(TreeNode.class, LEFT_VALUE_PROPERTY, int.class,
        0, false, result.getLeftValue(), params));
    result.setRightValue(mapper.tryToGet(TreeNode.class, RIGHT_VALUE_PROPERTY, int.class,
        1, false, result.getRightValue(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixTreeNode(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      TreeNodeTokens tokens = mapper.findParamByClass(params, TreeNodeTokens.class);
      if (tokens == null) {
        tokens = TreeNodeTokens.start();
      }
      result = userContext.getManagerGroup().getTreeNodeManager().internalSaveTreeNode(userContext, result, tokens.done());
      
    }
    return result;
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
		updateLeftValue(this.leftValue +  incLeftValue);
	}
	public void decreaseLeftValue(int decLeftValue){
		updateLeftValue(this.leftValue - decLeftValue);
	}
	
	public void increaseRightValue(int incRightValue){
		updateRightValue(this.rightValue +  incRightValue);
	}
	public void decreaseRightValue(int decRightValue){
		updateRightValue(this.rightValue - decRightValue);
	}
	

}

















