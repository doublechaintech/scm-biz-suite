import React from 'react'
import { Icon,Divider } from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
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


const menuData = {menuName:"Retail Store Order Line Item", menuFor: "retailStoreOrderLineItem",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'Id',
  bizOrder: 'Biz Order',
  skuId: 'Sku Id',
  skuName: 'Sku Name',
  amount: 'Amount',
  quantity: 'Quantity',
  unitOfMeasurement: 'Unit Of Measurement',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.bizOrder, dataIndex: 'bizOrder', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.skuId, debugtype: 'string', dataIndex: 'skuId', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.skuName, debugtype: 'string', dataIndex: 'skuName', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.amount, dataIndex: 'amount', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.quantity, debugtype: 'int', dataIndex: 'quantity', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.unitOfMeasurement, debugtype: 'string', dataIndex: 'unitOfMeasurement', width: '6',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(retailStoreOrderLineItem,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={retailStoreOrderLineItem.id}>
	
	<DescriptionList  key={retailStoreOrderLineItem.id} size="small" col="4">
<Description term="Id">{retailStoreOrderLineItem.id}</Description> 
<Description term="Biz Order">{retailStoreOrderLineItem.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreOrderLineItem.bizOrder.displayName}(${retailStoreOrderLineItem.bizOrder.id})`}
</Description>
<Description term="Sku Id">{retailStoreOrderLineItem.skuId}</Description> 
<Description term="Sku Name">{retailStoreOrderLineItem.skuName}</Description> 
<Description term="Amount">{retailStoreOrderLineItem.amount}</Description> 
<Description term="Quantity">{retailStoreOrderLineItem.quantity}</Description> 
<Description term="Unit Of Measurement">{retailStoreOrderLineItem.unitOfMeasurement}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const RetailStoreOrderLineItemBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default RetailStoreOrderLineItemBase



