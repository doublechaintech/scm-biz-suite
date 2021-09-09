package com.doublechaintech.retailscm.treenode;

import com.doublechaintech.retailscm.search.*;



import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.treenode.TreeNode.*;

public class TreeNodeRequest extends BaseRequest<TreeNode> {
    public static TreeNodeRequest newInstance() {
        return new TreeNodeRequest().selectId();
    }

    public String getInternalType() {
        return "TreeNode";
    }

    public TreeNodeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public TreeNodeRequest select(String... names) {
        super.select(names);
        return this;
    }

    public TreeNodeRequest selectAll() {return this.selectId().selectNodeId().selectNodeType().selectLeftValue().selectRightValue().selectVersion();
    }

    public TreeNodeRequest selectSelf() {return this.selectId().selectNodeId().selectNodeType().selectLeftValue().selectRightValue().selectVersion();
    }

    public TreeNodeRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public TreeNodeRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static TreeNodeRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public TreeNodeRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public TreeNodeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TreeNodeRequest selectId(){
          return select(ID_PROPERTY);
      }

      public TreeNodeRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public TreeNodeRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public TreeNodeRequest filterByNodeId(String nodeId) {
          
          if (nodeId == null) {
              return this;
          }
          
          return filterByNodeId(QueryOperator.EQUAL, nodeId);
      }
    

      public TreeNodeRequest filterByNodeId(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNodeIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TreeNodeRequest selectNodeId(){
          return select(NODE_ID_PROPERTY);
      }

      public TreeNodeRequest unselectNodeId(){
          return unselect(NODE_ID_PROPERTY);
      }

      public SearchCriteria getNodeIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NODE_ID_PROPERTY, pQueryOperator, parameters);
      }

      public TreeNodeRequest orderByNodeId(boolean asc){
          addOrderBy(NODE_ID_PROPERTY, asc);
          return this;
      }
   
      public TreeNodeRequest filterByNodeType(String nodeType) {
          
          if (nodeType == null) {
              return this;
          }
          
          return filterByNodeType(QueryOperator.EQUAL, nodeType);
      }
    

      public TreeNodeRequest filterByNodeType(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNodeTypeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TreeNodeRequest selectNodeType(){
          return select(NODE_TYPE_PROPERTY);
      }

      public TreeNodeRequest unselectNodeType(){
          return unselect(NODE_TYPE_PROPERTY);
      }

      public SearchCriteria getNodeTypeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NODE_TYPE_PROPERTY, pQueryOperator, parameters);
      }

      public TreeNodeRequest orderByNodeType(boolean asc){
          addOrderBy(NODE_TYPE_PROPERTY, asc);
          return this;
      }
   
      public TreeNodeRequest filterByLeftValue(int leftValue) {
          
          return filterByLeftValue(QueryOperator.EQUAL, leftValue);
      }
    

      public TreeNodeRequest filterByLeftValue(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLeftValueSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TreeNodeRequest selectLeftValue(){
          return select(LEFT_VALUE_PROPERTY);
      }

      public TreeNodeRequest unselectLeftValue(){
          return unselect(LEFT_VALUE_PROPERTY);
      }

      public SearchCriteria getLeftValueSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LEFT_VALUE_PROPERTY, pQueryOperator, parameters);
      }

      public TreeNodeRequest orderByLeftValue(boolean asc){
          addOrderBy(LEFT_VALUE_PROPERTY, asc);
          return this;
      }
   
      public TreeNodeRequest filterByRightValue(int rightValue) {
          
          return filterByRightValue(QueryOperator.EQUAL, rightValue);
      }
    

      public TreeNodeRequest filterByRightValue(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getRightValueSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TreeNodeRequest selectRightValue(){
          return select(RIGHT_VALUE_PROPERTY);
      }

      public TreeNodeRequest unselectRightValue(){
          return unselect(RIGHT_VALUE_PROPERTY);
      }

      public SearchCriteria getRightValueSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(RIGHT_VALUE_PROPERTY, pQueryOperator, parameters);
      }

      public TreeNodeRequest orderByRightValue(boolean asc){
          addOrderBy(RIGHT_VALUE_PROPERTY, asc);
          return this;
      }
   
      public TreeNodeRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public TreeNodeRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TreeNodeRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public TreeNodeRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public TreeNodeRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  


  

   public TreeNodeRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}



