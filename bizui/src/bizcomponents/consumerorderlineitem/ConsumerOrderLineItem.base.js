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


const menuData = {menuName:"Consumer Order Line Item", menuFor: "consumerOrderLineItem",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'Id',
  bizOrder: 'Biz Order',
  skuId: 'Sku Id',
  skuName: 'Sku Name',
  price: 'Price',
  quantity: 'Quantity',
  amount: 'Amount',
  lastUpdateTime: 'Last Update Time',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.bizOrder, dataIndex: 'bizOrder', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.skuId, debugtype: 'string', dataIndex: 'skuId', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.skuName, debugtype: 'string', dataIndex: 'skuName', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.price, dataIndex: 'price', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.quantity, debugtype: 'double', dataIndex: 'quantity', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.amount, dataIndex: 'amount', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(consumerOrderLineItem,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={consumerOrderLineItem.id}>
	
	<DescriptionList  key={consumerOrderLineItem.id} size="small" col="4">
<Description term="Id">{consumerOrderLineItem.id}</Description> 
<Description term="Biz Order">{consumerOrderLineItem.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${consumerOrderLineItem.bizOrder.displayName}(${consumerOrderLineItem.bizOrder.id})`}
</Description>
<Description term="Sku Id">{consumerOrderLineItem.skuId}</Description> 
<Description term="Sku Name">{consumerOrderLineItem.skuName}</Description> 
<Description term="Price">{consumerOrderLineItem.price}</Description> 
<Description term="Quantity">{consumerOrderLineItem.quantity}</Description> 
<Description term="Amount">{consumerOrderLineItem.amount}</Description> 
<Description term="Last Update Time">{ moment(consumerOrderLineItem.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const ConsumerOrderLineItemBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default ConsumerOrderLineItemBase



