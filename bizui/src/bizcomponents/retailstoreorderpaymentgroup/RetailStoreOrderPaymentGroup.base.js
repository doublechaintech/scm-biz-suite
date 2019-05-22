import React from 'react'
import { Icon } from 'antd'
import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'

const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


const menuData = {menuName:"生超订单付款组", menuFor: "retailStoreOrderPaymentGroup",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  bizOrder: '订单',
  cardNumber: '卡号码',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.bizOrder, dataIndex: 'bizOrder', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.cardNumber, debugtype: 'string', dataIndex: 'cardNumber', width: '21',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=({retailStoreOrderPaymentGroup,targetComponent})=>{

	
	
	const {RetailStoreOrderPaymentGroupService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreOrderPaymentGroup.id}</Description> 
<Description term="名称">{retailStoreOrderPaymentGroup.name}</Description> 
<Description term="订单">{retailStoreOrderPaymentGroup.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreOrderPaymentGroup.bizOrder.displayName}(${retailStoreOrderPaymentGroup.bizOrder.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"订单","retailStoreOrder",RetailStoreOrderPaymentGroupService.requestCandidateBizOrder,
	      RetailStoreOrderPaymentGroupService.transferToAnotherBizOrder,"anotherBizOrderId",retailStoreOrderPaymentGroup.bizOrder?retailStoreOrderPaymentGroup.bizOrder.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="卡号码">{retailStoreOrderPaymentGroup.cardNumber}</Description> 
	
        {buildTransferModal(retailStoreOrderPaymentGroup,targetComponent)}
      </DescriptionList>
	)

}
	



const RetailStoreOrderPaymentGroupBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default RetailStoreOrderPaymentGroupBase



