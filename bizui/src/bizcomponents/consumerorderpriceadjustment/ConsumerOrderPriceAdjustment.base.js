import React from 'react'
<<<<<<< HEAD
import { Icon,Divider } from 'antd'
=======
import { Icon,Divider, Avata, Card, Col} from 'antd'
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
<<<<<<< HEAD
=======

>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
<<<<<<< HEAD
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
=======
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
	defaultSearchLocalData,
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
<<<<<<< HEAD
=======
const renderAvatarCell=defaultRenderAvatarCell
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


<<<<<<< HEAD
const menuData = {menuName:"消费品价格调整", menuFor: "consumerOrderPriceAdjustment",
=======

const menuData = {menuName: window.trans('consumer_order_price_adjustment'), menuFor: "consumerOrderPriceAdjustment",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('consumer_order_price_adjustment'), menuFor: "consumerOrderPriceAdjustment",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('consumer_order_price_adjustment.id'),
  name: window.trans('consumer_order_price_adjustment.name'),
  bizOrder: window.trans('consumer_order_price_adjustment.biz_order'),
  amount: window.trans('consumer_order_price_adjustment.amount'),
  provider: window.trans('consumer_order_price_adjustment.provider'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'consumerOrderPriceAdjustment') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.bizOrder, dataIndex: 'bizOrder', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.amount, dataIndex: 'amount', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.provider, debugtype: 'string', dataIndex: 'provider', width: '8',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(consumerOrderPriceAdjustment,targetComponent)=>{

  const userContext = null
  return (
    <div key={consumerOrderPriceAdjustment.id}>
	
      <DescriptionList  key={consumerOrderPriceAdjustment.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{consumerOrderPriceAdjustment.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{consumerOrderPriceAdjustment.name}</Description> 
        <Description term={fieldLabels.bizOrder}><div>{consumerOrderPriceAdjustment.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${consumerOrderPriceAdjustment.bizOrder.displayName}(${consumerOrderPriceAdjustment.bizOrder.id})`}
        </div></Description>
        <Description term={fieldLabels.amount}><div style={{"color":"red"}}>{consumerOrderPriceAdjustment.amount}</div></Description> 
        <Description term={fieldLabels.provider} style={{wordBreak: 'break-all'}}>{consumerOrderPriceAdjustment.provider}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"消费品价格调整", menuFor: "consumerOrderPriceAdjustment",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

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
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, amount, provider, bizOrderId} = formValuesToPack
	const bizOrder = {id: bizOrderId, version: 2^31}
	const data = {name, amount, provider, bizOrder}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, amount, provider, bizOrder} = objectToUnpack
	const bizOrderId = bizOrder ? bizOrder.id : null
	const data = {name, amount, provider, bizOrderId}
	return data
}
<<<<<<< HEAD

const ConsumerOrderPriceAdjustmentBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
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
const ConsumerOrderPriceAdjustmentBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default ConsumerOrderPriceAdjustmentBase



