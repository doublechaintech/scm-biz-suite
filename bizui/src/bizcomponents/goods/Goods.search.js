
import React, { PureComponent } from 'react'
import { connect } from 'dva'
import Result from '../../components/Result'
import { Row, Col, Card, Form, Input, Select, Icon, Button, Dropdown, Menu, InputNumber, DatePicker, Modal, message,Alert } from 'antd';
import GlobalComponents from '../../custcomponents'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './Goods.search.less'
import ListViewTool from '../../common/ListView.tool'
import GoodsBase from './Goods.base'
import PermissionSettingService from '../../permission/PermissionSetting.service'
import appLocaleName from '../../common/Locale.tool'
<<<<<<< HEAD

=======
const {fieldLabels} = GoodsBase
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
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
  
  const { SkuAssociateForm } = GlobalComponents
  const { ReceivingSpaceAssociateForm } = GlobalComponents
  const { GoodsAllocationAssociateForm } = GlobalComponents
  const { SmartPalletAssociateForm } = GlobalComponents
  const { ShippingSpaceAssociateForm } = GlobalComponents
  const { TransportTaskAssociateForm } = GlobalComponents
  const { RetailStoreAssociateForm } = GlobalComponents
  const { SupplyOrderAssociateForm } = GlobalComponents
  const { RetailStoreOrderAssociateForm } = GlobalComponents
  const { GoodsPackagingAssociateForm } = GlobalComponents


  return (
  <div>
  
   
  
    <SkuAssociateForm 
	visible={currentAssociateModal==='sku'} 
	data={{goodsList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'sku')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'sku')}/> <ReceivingSpaceAssociateForm 
	visible={currentAssociateModal==='receivingSpace'} 
	data={{goodsList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'receivingSpace')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'receivingSpace')}/> <GoodsAllocationAssociateForm 
	visible={currentAssociateModal==='goodsAllocation'} 
	data={{goodsList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'goodsAllocation')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'goodsAllocation')}/> <SmartPalletAssociateForm 
	visible={currentAssociateModal==='smartPallet'} 
	data={{goodsList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'smartPallet')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'smartPallet')}/> <ShippingSpaceAssociateForm 
	visible={currentAssociateModal==='shippingSpace'} 
	data={{goodsList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'shippingSpace')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'shippingSpace')}/> <TransportTaskAssociateForm 
	visible={currentAssociateModal==='transportTask'} 
	data={{goodsList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'transportTask')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'transportTask')}/> <RetailStoreAssociateForm 
	visible={currentAssociateModal==='retailStore'} 
	data={{goodsList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'retailStore')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'retailStore')}/> <SupplyOrderAssociateForm 
	visible={currentAssociateModal==='bizOrder'} 
	data={{goodsList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'bizOrder')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'bizOrder')}/> <RetailStoreOrderAssociateForm 
	visible={currentAssociateModal==='retailStoreOrder'} 
	data={{goodsList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'retailStoreOrder')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'retailStoreOrder')}/> <GoodsPackagingAssociateForm 
	visible={currentAssociateModal==='packaging'} 
	data={{goodsList:selectedRows}} owner={owner}  
	onCancel={()=>toggleAssociateModalVisible(targetComponent,'packaging')} 
	onCreate={()=>toggleAssociateModalVisible(targetComponent,'packaging')}/> 
 


    </div>
    
    
    
    )
}


class GoodsSearch extends PureComponent {
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
    const {GoodsTable} = GlobalComponents;
    const {GoodsSearchForm} = GlobalComponents;
    const {GoodsModalTable} = GlobalComponents;
    
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
              <GoodsSearchForm {...this.props} />
            </div>
            <div className={styles.tableListOperator}>
           
   
              {showListActionBar(this)}
              {partialList&&(
              <div className={styles.searchAlert}>
                	<Alert message={appLocaleName(userContext,"CloseToShowAll")} type="success" closable  afterClose={()=>handleCloseAlert(displayName, this)}/>
              </div>  	
              )}
              
            </div>
            <GoodsTable
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
        {showDeletionDialog(this,GoodsModalTable,"goodsIds")}
        {showAssociateDialog(this)}
      </PageHeaderLayout>
    )
  }
}

export default Form.create()(GoodsSearch)


