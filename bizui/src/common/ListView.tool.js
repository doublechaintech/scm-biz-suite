
import React, { PureComponent } from 'react'
import { connect } from 'dva'
import Result from '../components/Result'


import { Row, Col, Card, Form, Input, Select, Icon, Button, Dropdown, Menu, InputNumber, DatePicker, Modal, message,Alert } from 'antd';

import GlobalComponents from '../custcomponents'


const toggle=(src, dest)=>{

  if(src===dest){
    return null
  }
  return dest;

}  

const toggleAssociateModalVisible = (targetComponent,targetModal) => {
    console.log("targetComponent", targetComponent)
   
    // const { showDeleteResult, selectedRows, deletionModalVisible, addInputValue } = this.state
    const {currentAssociateModal } = targetComponent.state
    
    

  
    targetComponent.setState({
      currentAssociateModal: toggle(currentAssociateModal,targetModal)
   
    })

}



const handleDeletionModalVisible = (event,targetComponent) => {
  
    const {deletionModalVisible} = targetComponent.state
    console.log("current flag", deletionModalVisible)
  
    targetComponent.setState({
      deletionModalVisible: !deletionModalVisible,
      showDeleteResult: false,
    })
  }
  
  
  
  const handleElementCreate = (targetComponent) => {
    const { dispatch, owner, role } = targetComponent.props
    dispatch({
      type: `${owner.type}/gotoCreateForm`,
      payload: { id: owner.id, role: role },
    })
  }
  

  
  const confirmAfterDelete = (targetComponent) => {
    // const { selectedRows } = this.state
    // const { dispatch, owner } = this.props
    targetComponent.setState({
      deletionModalVisible: false,
      showDeleteResult: true,
    })
  }
  
  
  const handleUpdate = (targetComponent) => {
    const { dispatch, owner, role } = targetComponent.props
    // const { showDeleteResult, selectedRows, deletionModalVisible, addInputValue } = this.state
    const { selectedRows } = targetComponent.state
    const currentUpdateIndex = 0
    dispatch({
      type: `${owner.type}/gotoUpdateForm`,
      payload: { id: owner.id, role: role, selectedRows, currentUpdateIndex },
    })
  }
  
  const handleDelete = (targetComponent,parameterName) => {
    const { selectedRows } = targetComponent.state
    const { dispatch, owner, role } = targetComponent.props
    console.log('things to delete', selectedRows)
    targetComponent.setState({
      deletionModalVisible: true,
      showDeleteResult: true,
    })
    const {listName} = owner;
    const capFirstChar = (value)=>{
      //const upper = value.replace(/^\w/, c => c.toUpperCase());
      const upper = value.charAt(0).toUpperCase() + value.substr(1);
      return upper
    }
    const ids = selectedRows.map((item) => { return item.id })
    console.log("parameterName and Ids",parameterName, ids)
    var parameters = {}
    parameters[parameterName]=ids
    const cappedRoleName = capFirstChar(listName)
    dispatch({
      type: `${owner.type}/remove${cappedRoleName}`,
      payload: { id: owner.id, role: role, parameters },
    })
  }
  
  
  
  const showDeletionDialog = (targetComponent,ModalTable,parameterName) => {
  
    const { showDeleteResult, selectedRows, deletionModalVisible} = targetComponent.state;
   
    const {owner} = targetComponent.props
    
    if (showDeleteResult) {
      return (
      <Modal
        title="成功删除"
        visible={deletionModalVisible}
        onOk={() => confirmAfterDelete(targetComponent)}
        onCancel={() => confirmAfterDelete(targetComponent)}
        width={920}
        style={{ top: 40 }}
      >
        <Result type="success" title="删除成功，干得漂亮" description="" style={{ marginTop: 48, marginBottom: 16 }} />
      </Modal>)
    }
  
    return (
      <Modal
        title="注意！你正在删除数据，执行之后不可恢复"
        visible={deletionModalVisible}
        onOk={()=>handleDelete(targetComponent,parameterName)}
        onCancel={(flag) => handleDeletionModalVisible(flag,targetComponent)}
        width={920}
        style={{ top: 40 }}
      >
        <ModalTable data={selectedRows} owner={owner} />
      </Modal>)
  }
  
  
  const handleStandardTableChange = (pagination, filtersArg, sorter,targetComponent) => {
    const { dispatch } = targetComponent.props
    const { formValues } = targetComponent.state
  
    const filters = Object.keys(filtersArg).reduce((obj, key) => {
      const newObj = { ...obj }
      newObj[key] = getValue(filtersArg[key])
      return newObj
    }, {})
    const { owner,searchParameters } = targetComponent.props
    const {listName} = owner;
    let listParameters = {};
    listParameters[listName]=1;
    listParameters[`${listName}CurrentPage`]=pagination.current;
    listParameters[`${listName}RowsPerPage`]=pagination.pageSize;

    if(!searchParameters||!searchParameters[`${listName}.orderBy.0`]){
      listParameters[`${listName}.orderBy.0`]="id"
    }
    if(!searchParameters||!searchParameters[`${listName}.descOrAsc.0`]){
      listParameters[`${listName}.descOrAsc.0`]="desc"
    }
    
    
   

   
    console.log("searchParameters",searchParameters)

    const params = {
      ...listParameters,
      ...searchParameters,
      ...formValues,
      ...filters,

    }
    if (sorter.field) {
      params.sorter = '_'
    }

    console.log("handleStandardTableChange", params)
    
    dispatch({
      type: `${owner.type}/load`,
      payload: { id: owner.id, parameters: params,searchParameters },
    })
  }
  
  
const handleSelectRows = (rows,targetComponent) => {
    console.log("show logging.....", rows)
    targetComponent.setState({
      selectedRows: rows,
    })
  }
  
  
      
const handleCloseAlert = (listName, targetComponent) => {
    const { dispatch, owner,location } = targetComponent.props;
    console.log("trying to call handleCloseAlert",owner)
    const pathname = location.pathname
    dispatch({ type: `${owner.type}/view`, payload: { id: owner.id,pathname,displayName:listName } })
  
  }
  



const ListViewTool = {

    handleDeletionModalVisible,
    handleCloseAlert,handleSelectRows,handleStandardTableChange,
    showDeletionDialog,handleDelete,handleUpdate,confirmAfterDelete,
    handleElementCreate,toggleAssociateModalVisible

}


export default ListViewTool

  