
import React, { PureComponent } from 'react'
import { connect } from 'dva'
import Result from '../../components/Result'
import { Row, Col, Card, Form, Input, Select, Icon, Button, Dropdown, Menu, InputNumber, DatePicker, Modal, message,Alert } from 'antd';
import GlobalComponents from '../../custcomponents'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './RetailStore.search.less'
import ListViewTool from '../../common/ListView.tool'
import PermissionSettingService from '../../permission/PermissionSetting.service'
const  {  hasCreatePermission,hasExecutionPermission,hasDeletePermission,hasUpdatePermission,hasReadPermission } = PermissionSettingService


const {handleSelectRows,handleStandardTableChange,
  showDeletionDialog,handleUpdate,handleDeletionModalVisible,
  handleElementCreate,toggleAssociateModalVisible,handleCloseAlert}=ListViewTool


const buttonMenuFor =(targetComponent, internalName, localeName)=> (
  <Menu >
    <Menu.Item key="1" onClick={()=>toggleAssociateModalVisible(targetComponent,internalName)}>新建{localeName}</Menu.Item>
    <Menu.Item key="2">合并{localeName}</Menu.Item>
   
  </Menu>
);


 
const showListActionBar = (targetComponent)=>{

  const {selectedRows} = targetComponent.state
  const {metaInfo} = targetComponent.props
  const disable = (selectedRows.length === 0)

  return (<div className={styles.tableListOperator}>
        
 
              {hasCreatePermission(metaInfo)&&<Button icon="plus" type="primary" onClick={() => handleElementCreate(targetComponent)}>新建</Button>}
              
 {hasDeletePermission(metaInfo)&&<Button onClick={(event)=>handleDeletionModalVisible(event,targetComponent)} type="danger" icon="delete" disabled={disable}>批量删除</Button>}
               

               {hasUpdatePermission(metaInfo)&&<Button onClick={()=>handleUpdate(targetComponent)} icon="update" disabled={disable}>批量更新</Button>}
 
 	
    
               
	</div> )


}


const showAssociateDialog = (targetComponent) => {
  const {data, owner, visible,onCancel,onCreate} = targetComponent.props
  const {currentAssociateModal} = targetComponent.state
  
  const {selectedRows} = targetComponent.state
  
  const { RetailStoreCountryCenterAssociateForm } = GlobalComponents
  const { RetailStoreCityServiceCenterAssociateForm } = GlobalComponents
  const { RetailStoreCreationAssociateForm } = GlobalComponents
  const { RetailStoreInvestmentInvitationAssociateForm } = GlobalComponents
  const { RetailStoreFranchisingAssociateForm } = GlobalComponents
  const { RetailStoreDecorationAssociateForm } = GlobalComponents
  const { RetailStoreOpeningAssociateForm } = GlobalComponents
  const { RetailStoreClosingAssociateForm } = GlobalComponents


  return (
  <div>
  
    <RetailStoreCreationAssociateForm 
	visible={currentAssociateModal==='creation'} 
	data={{retailStoreList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'creation')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'creation')}/> <RetailStoreInvestmentInvitationAssociateForm 
	visible={currentAssociateModal==='investmentInvitation'} 
	data={{retailStoreList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'investmentInvitation')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'investmentInvitation')}/> <RetailStoreFranchisingAssociateForm 
	visible={currentAssociateModal==='franchising'} 
	data={{retailStoreList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'franchising')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'franchising')}/> <RetailStoreDecorationAssociateForm 
	visible={currentAssociateModal==='decoration'} 
	data={{retailStoreList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'decoration')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'decoration')}/> <RetailStoreOpeningAssociateForm 
	visible={currentAssociateModal==='opening'} 
	data={{retailStoreList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'opening')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'opening')}/> <RetailStoreClosingAssociateForm 
	visible={currentAssociateModal==='closing'} 
	data={{retailStoreList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'closing')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'closing')}/>
  
    <RetailStoreCountryCenterAssociateForm 
	visible={currentAssociateModal==='retailStoreCountryCenter'} 
	data={{retailStoreList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'retailStoreCountryCenter')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'retailStoreCountryCenter')}/> <RetailStoreCityServiceCenterAssociateForm 
	visible={currentAssociateModal==='cityServiceCenter'} 
	data={{retailStoreList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'cityServiceCenter')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'cityServiceCenter')}/> 
 


    </div>
    
    
    
    )
}


class RetailStoreSearch extends PureComponent {
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
    const {RetailStoreTable} = GlobalComponents;
    const {RetailStoreSearchForm} = GlobalComponents;
    const {RetailStoreModalTable} = GlobalComponents;
    
    
  
    return (
      <PageHeaderLayout title={`${displayName}:${this.props.name}列表`}>
        <Card bordered={false}>
          <div className={styles.tableList}>
            <div className={styles.tableListForm}>
              <RetailStoreSearchForm {...this.props} />
            </div>
            <div className={styles.tableListOperator}>
           
   
              {showListActionBar(this)}
              {partialList&&(
              <div className={styles.searchAlert}>
                	<Alert message="下面显示最近更新结果，关闭显示全部" type="success" closable  afterClose={()=>handleCloseAlert(displayName, this)}/>
              </div>  	
              )}
              
            </div>
            <RetailStoreTable
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
        {showDeletionDialog(this,RetailStoreModalTable,"retailStoreIds")}
        {showAssociateDialog(this)}
      </PageHeaderLayout>
    )
  }
}

export default Form.create()(RetailStoreSearch)


