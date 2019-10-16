
import React, { PureComponent } from 'react'
import { connect } from 'dva'
import Result from '../../components/Result'
import { Row, Col, Card, Form, Input, Select, Icon, Button, Dropdown, Menu, InputNumber, DatePicker, Modal, message,Alert } from 'antd';
import GlobalComponents from '../../custcomponents'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './ConsumerOrder.search.less'
import ListViewTool from '../../common/ListView.tool'
import PermissionSettingService from '../../permission/PermissionSetting.service'
import appLocaleName from '../../common/Locale.tool'

import { Link, Route, Redirect} from 'dva/router'

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


    {hasUpdatePermission(metaInfo)&&<Button onClick={()=>handleUpdate(targetComponent)} icon="edit" disabled={disable}>{appLocaleName(userContext,"BatchUpdate")}</Button>}
 
 
    {hasDeletePermission(metaInfo)&&<Button onClick={(event)=>handleDeletionModalVisible(event,targetComponent)} type="danger" icon="delete" disabled={disable}>{appLocaleName(userContext,"BatchDelete")}</Button>}

</div> )


}


const showAssociateDialog = (targetComponent) => {
  const {data, owner, visible,onCancel,onCreate} = targetComponent.props
  const {currentAssociateModal} = targetComponent.state
  
  const {selectedRows} = targetComponent.state
  
  const { RetailStoreMemberAssociateForm } = GlobalComponents
  const { SupplyOrderConfirmationAssociateForm } = GlobalComponents
  const { SupplyOrderApprovalAssociateForm } = GlobalComponents
  const { SupplyOrderProcessingAssociateForm } = GlobalComponents
  const { SupplyOrderShipmentAssociateForm } = GlobalComponents
  const { SupplyOrderDeliveryAssociateForm } = GlobalComponents
  const { RetailStoreAssociateForm } = GlobalComponents


  return (
  <div>
  
    <SupplyOrderConfirmationAssociateForm 
	visible={currentAssociateModal==='confirmation'} 
	data={{consumerOrderList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'confirmation')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'confirmation')}/> <SupplyOrderApprovalAssociateForm 
	visible={currentAssociateModal==='approval'} 
	data={{consumerOrderList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'approval')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'approval')}/> <SupplyOrderProcessingAssociateForm 
	visible={currentAssociateModal==='processing'} 
	data={{consumerOrderList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'processing')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'processing')}/> <SupplyOrderShipmentAssociateForm 
	visible={currentAssociateModal==='shipment'} 
	data={{consumerOrderList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'shipment')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'shipment')}/> <SupplyOrderDeliveryAssociateForm 
	visible={currentAssociateModal==='delivery'} 
	data={{consumerOrderList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'delivery')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'delivery')}/>
  
    <RetailStoreMemberAssociateForm 
	visible={currentAssociateModal==='consumer'} 
	data={{consumerOrderList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'consumer')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'consumer')}/> <RetailStoreAssociateForm 
	visible={currentAssociateModal==='store'} 
	data={{consumerOrderList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'store')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'store')}/> 
 


    </div>
    
    
    
    )
}


class ConsumerOrderSearch extends PureComponent {
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
    const {ConsumerOrderTable} = GlobalComponents;
    const {ConsumerOrderSearchForm} = GlobalComponents;
    const {ConsumerOrderModalTable} = GlobalComponents;
    
    const userContext = null
    
    const renderTitle=()=>{
      const {returnURL} = this.props
      
      const linkComp=returnURL?<Link to={returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
      return (<div>{linkComp}{`${displayName}:${this.props.name}${appLocaleName(userContext,"List")}`}</div>);
    }
  
    return (
      <PageHeaderLayout title={renderTitle()}>
        <Card bordered={false}>
          <div className={styles.tableList}>
            <div className={styles.tableListForm}>
              <ConsumerOrderSearchForm {...this.props} />
            </div>
            <div className={styles.tableListOperator}>
           
   
              {showListActionBar(this)}
              {partialList&&(
              <div className={styles.searchAlert}>
                	<Alert message={appLocaleName(userContext,"CloseToShowAll")} type="success" closable  afterClose={()=>handleCloseAlert(displayName, this)}/>
              </div>  	
              )}
              
            </div>
            <ConsumerOrderTable
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
        {showDeletionDialog(this,ConsumerOrderModalTable,"consumerOrderIds")}
        {showAssociateDialog(this)}
      </PageHeaderLayout>
    )
  }
}

export default Form.create()(ConsumerOrderSearch)


