
import React, { PureComponent } from 'react'
import { connect } from 'dva'
import Result from '../../components/Result'
import { Row, Col, Card, Form, Input, Select, Icon, Button, Dropdown, Menu, InputNumber, DatePicker, Modal, message,Alert } from 'antd';
import GlobalComponents from '../../custcomponents'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './Employee.search.less'
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
  const { LevelThreeDepartmentAssociateForm } = GlobalComponents
  const { OccupationTypeAssociateForm } = GlobalComponents
  const { ResponsibilityTypeAssociateForm } = GlobalComponents
  const { SalaryGradeAssociateForm } = GlobalComponents
  const { JobApplicationAssociateForm } = GlobalComponents
  const { ProfessionInterviewAssociateForm } = GlobalComponents
  const { HrInterviewAssociateForm } = GlobalComponents
  const { OfferApprovalAssociateForm } = GlobalComponents
  const { OfferAcceptanceAssociateForm } = GlobalComponents
  const { EmployeeBoardingAssociateForm } = GlobalComponents
  const { TerminationAssociateForm } = GlobalComponents


  return (
  <div>
  
    <JobApplicationAssociateForm 
	visible={currentAssociateModal==='jobApplication'} 
	data={{employeeList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'jobApplication')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'jobApplication')}/> <ProfessionInterviewAssociateForm 
	visible={currentAssociateModal==='professionInterview'} 
	data={{employeeList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'professionInterview')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'professionInterview')}/> <HrInterviewAssociateForm 
	visible={currentAssociateModal==='hrInterview'} 
	data={{employeeList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'hrInterview')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'hrInterview')}/> <OfferApprovalAssociateForm 
	visible={currentAssociateModal==='offerApproval'} 
	data={{employeeList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'offerApproval')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'offerApproval')}/> <OfferAcceptanceAssociateForm 
	visible={currentAssociateModal==='offerAcceptance'} 
	data={{employeeList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'offerAcceptance')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'offerAcceptance')}/> <EmployeeBoardingAssociateForm 
	visible={currentAssociateModal==='employeeBoarding'} 
	data={{employeeList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'employeeBoarding')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'employeeBoarding')}/> <TerminationAssociateForm 
	visible={currentAssociateModal==='termination'} 
	data={{employeeList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'termination')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'termination')}/>
  
    <RetailStoreCountryCenterAssociateForm 
	visible={currentAssociateModal==='company'} 
	data={{employeeList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'company')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'company')}/> <LevelThreeDepartmentAssociateForm 
	visible={currentAssociateModal==='department'} 
	data={{employeeList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'department')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'department')}/> <OccupationTypeAssociateForm 
	visible={currentAssociateModal==='occupation'} 
	data={{employeeList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'occupation')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'occupation')}/> <ResponsibilityTypeAssociateForm 
	visible={currentAssociateModal==='responsibleFor'} 
	data={{employeeList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'responsibleFor')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'responsibleFor')}/> <SalaryGradeAssociateForm 
	visible={currentAssociateModal==='currentSalaryGrade'} 
	data={{employeeList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'currentSalaryGrade')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'currentSalaryGrade')}/> 
 


    </div>
    
    
    
    )
}


class EmployeeSearch extends PureComponent {
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
    const {EmployeeTable} = GlobalComponents;
    const {EmployeeSearchForm} = GlobalComponents;
    const {EmployeeModalTable} = GlobalComponents;
    
    
  
    return (
      <PageHeaderLayout title={`${displayName}:${this.props.name}列表`}>
        <Card bordered={false}>
          <div className={styles.tableList}>
            <div className={styles.tableListForm}>
              <EmployeeSearchForm {...this.props} />
            </div>
            <div className={styles.tableListOperator}>
           
   
              {showListActionBar(this)}
              {partialList&&(
              <div className={styles.searchAlert}>
                	<Alert message="下面显示最近更新结果，关闭显示全部" type="success" closable  afterClose={()=>handleCloseAlert(displayName, this)}/>
              </div>  	
              )}
              
            </div>
            <EmployeeTable
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
        {showDeletionDialog(this,EmployeeModalTable,"employeeIds")}
        {showAssociateDialog(this)}
      </PageHeaderLayout>
    )
  }
}

export default Form.create()(EmployeeSearch)


