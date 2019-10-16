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


const menuData = {menuName:"供应订单行项目", menuFor: "supplyOrderLineItem",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"供应订单行项目", menuFor: "supplyOrderLineItem",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  bizOrder: '订单',
  skuId: '产品ID',
  skuName: '产品名称',
  amount: '金额',
  quantity: '数量',
  unitOfMeasurement: '测量单位',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'supplyOrderLineItem') , sorter: true },
  { title: fieldLabels.bizOrder, dataIndex: 'bizOrder', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.skuId, debugtype: 'string', dataIndex: 'skuId', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.skuName, debugtype: 'string', dataIndex: 'skuName', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.amount, dataIndex: 'amount', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.quantity, debugtype: 'int', dataIndex: 'quantity', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.unitOfMeasurement, debugtype: 'string', dataIndex: 'unitOfMeasurement', width: '6',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(supplyOrderLineItem,targetComponent)=>{

  const userContext = null
  return (
    <div key={supplyOrderLineItem.id}>
	
      <DescriptionList  key={supplyOrderLineItem.id} size="small" col="4">
        <Description term="序号">{supplyOrderLineItem.id}</Description> 
        <Description term="订单"><div>{supplyOrderLineItem.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${supplyOrderLineItem.bizOrder.displayName}(${supplyOrderLineItem.bizOrder.id})`}
        </div></Description>
        <Description term="产品ID">{supplyOrderLineItem.skuId}</Description> 
        <Description term="产品名称">{supplyOrderLineItem.skuName}</Description> 
        <Description term="金额"><div style={{"color":"red"}}>{supplyOrderLineItem.amount}</div></Description> 
        <Description term="数量"><div style={{"color":"red"}}>{supplyOrderLineItem.quantity}</div></Description> 
        <Description term="测量单位">{supplyOrderLineItem.unitOfMeasurement}</Description> 
	
        
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

const SupplyOrderLineItemBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
export default SupplyOrderLineItemBase



