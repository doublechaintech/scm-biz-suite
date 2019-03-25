
import React, { PureComponent } from 'react'
import { connect } from 'dva'
import Result from '../../components/Result'
import { Row, Col, Card, Form, Input, Select, Icon, Button, Dropdown, Menu, InputNumber, DatePicker, Modal, message,Alert } from 'antd';
import GlobalComponents from '../../custcomponents'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './SupplyOrder.search.less'
import ListViewTool from '../../common/ListView.tool'
import PermissionSettingService from '../../permission/PermissionSetting.service'
import appLocaleName from '../../common/Locale.tool'
const  {  hasCreatePermission,hasExecutionPermission,hasDeletePermission,hasUpdatePermission,hasReadPermission } = PermissionSettingService


const {handleSelectRows,handleStandardTableChange,
  showDeletionDialog,handleUpdate,handleDeletionModalVisible,
  handleElementCreate,toggleAssociateModalVisible,handleCloseAlert}=ListViewTool


const buttonMenuFor =(targetComponent, internalName, localeName)=> {
  const userContext = null
  return (
   <Menu >
     <Menu.Item key="1" onClick={()=>toggleAssociateModalVisible(targetComponent,internalName)}>{appLocaleName(userContext,"New")}{localeName}</Menu.Item>
     <Menu.Item key="2">{appLocaleName(userContext,"Merge")}{localeName}</Menu.Item>
    </Menu>
  )

}


 
const showListActionBar = (targetComponent)=>{

  const {selectedRows} = targetComponent.state
  const {metaInfo} = targetComponent.props
  const disable = (selectedRows.length === 0)
  const userContext = null
  return (<div className={styles.tableListOperator}>
  
 
              {hasCreatePermission(metaInfo)&&<Button icon="plus" type="primary" onClick={() => handleElementCreate(targetComponent)}>{appLocaleName(userContext,"New")}</Button>}
              
 {hasDeletePermission(metaInfo)&&<Button onClick={(event)=>handleDeletionModalVisible(event,targetComponent)} type="danger" icon="delete" disabled={disable}>{appLocaleName(userContext,"BatchDelete")}</Button>}
               

               {hasUpdatePermission(metaInfo)&&<Button onClick={()=>handleUpdate(targetComponent)} icon="update" disabled={disable}>{appLocaleName(userContext,"BatchUpdate")}</Button>}
 
 	
    
               
	</div> )


}


const showAssociateDialog = (targetComponent) => {
  const {data, owner, visible,onCancel,onCreate} = targetComponent.props
  const {currentAssociateModal} = targetComponent.state
  
  const {selectedRows} = targetComponent.state
  
  const { RetailStoreCountryCenterAssociateForm } = GlobalComponents
  const { GoodsSupplierAssociateForm } = GlobalComponents
  const { SupplyOrderConfirmationAssociateForm } = GlobalComponents
  const { SupplyOrderApprovalAssociateForm } = GlobalComponents
  const { SupplyOrderProcessingAssociateForm } = GlobalComponents
  const { SupplyOrderPickingAssociateForm } = GlobalComponents
  const { SupplyOrderShipmentAssociateForm } = GlobalComponents
  const { SupplyOrderDeliveryAssociateForm } = GlobalComponents


  return (
  <div>
  
    <SupplyOrderConfirmationAssociateForm 
	visible={currentAssociateModal==='confirmation'} 
	data={{supplyOrderList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'confirmation')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'confirmation')}/> <SupplyOrderApprovalAssociateForm 
	visible={currentAssociateModal==='approval'} 
	data={{supplyOrderList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'approval')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'approval')}/> <SupplyOrderProcessingAssociateForm 
	visible={currentAssociateModal==='processing'} 
	data={{supplyOrderList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'processing')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'processing')}/> <SupplyOrderPickingAssociateForm 
	visible={currentAssociateModal==='picking'} 
	data={{supplyOrderList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'picking')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'picking')}/> <SupplyOrderShipmentAssociateForm 
	visible={currentAssociateModal==='shipment'} 
	data={{supplyOrderList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'shipment')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'shipment')}/> <SupplyOrderDeliveryAssociateForm 
	visible={currentAssociateModal==='delivery'} 
	data={{supplyOrderList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'delivery')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'delivery')}/>
  
    <RetailStoreCountryCenterAssociateForm 
	visible={currentAssociateModal==='buyer'} 
	data={{supplyOrderList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'buyer')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'buyer')}/> <GoodsSupplierAssociateForm 
	visible={currentAssociateModal==='seller'} 
	data={{supplyOrderList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'seller')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'seller')}/> 
 


    </div>
    
    
    
    )
}


class SupplyOrderSearch extends PureComponent {
  state = {
    deletionModalVisible: false,
    selectedRows: [],
    showDeleteResult: false,
    currentAssociateModal: null,
  }

  render(){
    const { data, loading, count, currentPage, owner,partialList } = this.props;
    const {displayName} = owner.ref
    const { showDeleteResult, selectedRows, deletionModalVisible, showAssociatePaymentForm } = this.state;
    const {SupplyOrderTable} = GlobalComponents;
    const {SupplyOrderSearchForm} = GlobalComponents;
    const {SupplyOrderModalTable} = GlobalComponents;
    
    const userContext = null
    
    
  
    return (
      <PageHeaderLayout title={`${displayName}:${this.props.name}${appLocaleName(userContext,"List")}`}>
        <Card bordered={false}>
          <div className={styles.tableList}>
            <div className={styles.tableListForm}>
              <SupplyOrderSearchForm {...this.props} />
            </div>
            <div className={styles.tableListOperator}>
           
   
              {showListActionBar(this)}
              {partialList&&(
              <div className={styles.searchAlert}>
                	<Alert message={appLocaleName(userContext,"CloseToShowAll")} type="success" closable  afterClose={()=>handleCloseAlert(displayName, this)}/>
              </div>  	
              )}
              
            </div>
            <SupplyOrderTable
              selectedRows={selectedRows}
              loading={loading}
              data={data}
              count={count}
              current={currentPage}
              onSelectRow={(selectedRows)=>handleSelectRows(selectedRows,this)}
              onChange={(pagination, filtersArg, sorter)=>handleStandardTableChange(pagination, filtersArg, sorter,this)}
              owner={owner}
              {...this.props}
            />
          </div>
        </Card>
        {showDeletionDialog(this,SupplyOrderModalTable,"supplyOrderIds")}
        {showAssociateDialog(this)}
      </PageHeaderLayout>
    )
  }
}

export default Form.create()(SupplyOrderSearch)


