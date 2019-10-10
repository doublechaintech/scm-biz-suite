
import React, { PureComponent } from 'react'
import { connect } from 'dva'
import Result from '../../components/Result'
import { Row, Col, Card, Form, Input, Select, Icon, Button, Dropdown, Menu, InputNumber, DatePicker, Modal, message,Alert } from 'antd';
import GlobalComponents from '../../custcomponents'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './AccountingDocument.search.less'
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
  
  const { AccountingPeriodAssociateForm } = GlobalComponents
  const { AccountingDocumentTypeAssociateForm } = GlobalComponents
  const { AccountingDocumentCreationAssociateForm } = GlobalComponents
  const { AccountingDocumentConfirmationAssociateForm } = GlobalComponents
  const { AccountingDocumentAuditingAssociateForm } = GlobalComponents
  const { AccountingDocumentPostingAssociateForm } = GlobalComponents


  return (
  <div>
  
    <AccountingDocumentCreationAssociateForm 
	visible={currentAssociateModal==='creation'} 
	data={{accountingDocumentList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'creation')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'creation')}/> <AccountingDocumentConfirmationAssociateForm 
	visible={currentAssociateModal==='confirmation'} 
	data={{accountingDocumentList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'confirmation')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'confirmation')}/> <AccountingDocumentAuditingAssociateForm 
	visible={currentAssociateModal==='auditing'} 
	data={{accountingDocumentList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'auditing')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'auditing')}/> <AccountingDocumentPostingAssociateForm 
	visible={currentAssociateModal==='posting'} 
	data={{accountingDocumentList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'posting')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'posting')}/>
  
    <AccountingPeriodAssociateForm 
	visible={currentAssociateModal==='accountingPeriod'} 
	data={{accountingDocumentList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'accountingPeriod')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'accountingPeriod')}/> <AccountingDocumentTypeAssociateForm 
	visible={currentAssociateModal==='documentType'} 
	data={{accountingDocumentList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'documentType')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'documentType')}/> 
 


    </div>
    
    
    
    )
}


class AccountingDocumentSearch extends PureComponent {
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
    const {AccountingDocumentTable} = GlobalComponents;
    const {AccountingDocumentSearchForm} = GlobalComponents;
    const {AccountingDocumentModalTable} = GlobalComponents;
    
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
              <AccountingDocumentSearchForm {...this.props} />
            </div>
            <div className={styles.tableListOperator}>
           
   
              {showListActionBar(this)}
              {partialList&&(
              <div className={styles.searchAlert}>
                	<Alert message={appLocaleName(userContext,"CloseToShowAll")} type="success" closable  afterClose={()=>handleCloseAlert(displayName, this)}/>
              </div>  	
              )}
              
            </div>
            <AccountingDocumentTable
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
        {showDeletionDialog(this,AccountingDocumentModalTable,"accountingDocumentIds")}
        {showAssociateDialog(this)}
      </PageHeaderLayout>
    )
  }
}

export default Form.create()(AccountingDocumentSearch)


