import React from 'react'
import { Icon,Divider, Avata, Card, Col} from 'antd'

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
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
	defaultSearchLocalData,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderAvatarCell=defaultRenderAvatarCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell



const menuData = {menuName: window.trans('retail_store_order_line_item'), menuFor: "retailStoreOrderLineItem",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('retail_store_order_line_item'), menuFor: "retailStoreOrderLineItem",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('retail_store_order_line_item.id'),
  bizOrder: window.trans('retail_store_order_line_item.biz_order'),
  skuId: window.trans('retail_store_order_line_item.sku_id'),
  skuName: window.trans('retail_store_order_line_item.sku_name'),
  amount: window.trans('retail_store_order_line_item.amount'),
  quantity: window.trans('retail_store_order_line_item.quantity'),
  unitOfMeasurement: window.trans('retail_store_order_line_item.unit_of_measurement'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStoreOrderLineItem') , sorter: true },
  { title: fieldLabels.bizOrder, dataIndex: 'bizOrder', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.skuId, debugtype: 'string', dataIndex: 'skuId', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.skuName, debugtype: 'string', dataIndex: 'skuName', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.amount, dataIndex: 'amount', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.quantity, debugtype: 'int', dataIndex: 'quantity', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.unitOfMeasurement, debugtype: 'string', dataIndex: 'unitOfMeasurement', width: '6',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(retailStoreOrderLineItem,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreOrderLineItem.id}>
	
      <DescriptionList  key={retailStoreOrderLineItem.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{retailStoreOrderLineItem.id}</Description> 
        <Description term={fieldLabels.bizOrder}><div>{retailStoreOrderLineItem.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreOrderLineItem.bizOrder.displayName}(${retailStoreOrderLineItem.bizOrder.id})`}
        </div></Description>
        <Description term={fieldLabels.skuId} style={{wordBreak: 'break-all'}}>{retailStoreOrderLineItem.skuId}</Description> 
        <Description term={fieldLabels.skuName} style={{wordBreak: 'break-all'}}>{retailStoreOrderLineItem.skuName}</Description> 
        <Description term={fieldLabels.amount}><div style={{"color":"red"}}>{retailStoreOrderLineItem.amount}</div></Description> 
        <Description term={fieldLabels.quantity}><div style={{"color":"red"}}>{retailStoreOrderLineItem.quantity}</div></Description> 
        <Description term={fieldLabels.unitOfMeasurement} style={{wordBreak: 'break-all'}}>{retailStoreOrderLineItem.unitOfMeasurement}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {skuId, skuName, amount, quantity, unitOfMeasurement, bizOrderId} = formValuesToPack
	const bizOrder = {id: bizOrderId, version: 2^31}
	const data = {skuId, skuName, amount, quantity, unitOfMeasurement, bizOrder}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {skuId, skuName, amount, quantity, unitOfMeasurement, bizOrder} = objectToUnpack
	const bizOrderId = bizOrder ? bizOrder.id : null
	const data = {skuId, skuName, amount, quantity, unitOfMeasurement, bizOrderId}
	return data
}
const stepOf=(targetComponent, title, content, position, index)=>{
	return {
		title,
		content,
		position,
		packFunction: packFormValuesToObject,
		unpackFunction: unpackObjectToFormValues,
		index,
      }
}
const RetailStoreOrderLineItemBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default RetailStoreOrderLineItemBase



