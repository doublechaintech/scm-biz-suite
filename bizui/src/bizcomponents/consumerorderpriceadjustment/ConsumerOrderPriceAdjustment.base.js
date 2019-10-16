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


const menuData = {menuName:"消费品价格调整", menuFor: "consumerOrderPriceAdjustment",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"消费品价格调整", menuFor: "consumerOrderPriceAdjustment",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  bizOrder: '订单',
  amount: '金额',
  provider: '供应商',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'consumerOrderPriceAdjustment') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.bizOrder, dataIndex: 'bizOrder', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.amount, dataIndex: 'amount', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.provider, debugtype: 'string', dataIndex: 'provider', width: '8',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(consumerOrderPriceAdjustment,targetComponent)=>{

  const userContext = null
  return (
    <div key={consumerOrderPriceAdjustment.id}>
	
      <DescriptionList  key={consumerOrderPriceAdjustment.id} size="small" col="4">
        <Description term="序号">{consumerOrderPriceAdjustment.id}</Description> 
        <Description term="名称">{consumerOrderPriceAdjustment.name}</Description> 
        <Description term="订单"><div>{consumerOrderPriceAdjustment.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${consumerOrderPriceAdjustment.bizOrder.displayName}(${consumerOrderPriceAdjustment.bizOrder.id})`}
        </div></Description>
        <Description term="金额"><div style={{"color":"red"}}>{consumerOrderPriceAdjustment.amount}</div></Description> 
        <Description term="供应商">{consumerOrderPriceAdjustment.provider}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, amount, provider, bizOrderId} = formValuesToPack
	const bizOrder = {id: bizOrderId, version: 2^31}
	const data = {name, amount, provider, bizOrder}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, amount, provider, bizOrder} = objectToUnpack
	const bizOrderId = bizOrder ? bizOrder.id : null
	const data = {name, amount, provider, bizOrderId}
	return data
}

const ConsumerOrderPriceAdjustmentBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
export default ConsumerOrderPriceAdjustmentBase



