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
const menuData = {menuName:"消费者订单行项目", menuFor: "consumerOrderLineItem",
=======

const menuData = {menuName: window.trans('consumer_order_line_item'), menuFor: "consumerOrderLineItem",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('consumer_order_line_item'), menuFor: "consumerOrderLineItem",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('consumer_order_line_item.id'),
  bizOrder: window.trans('consumer_order_line_item.biz_order'),
  skuId: window.trans('consumer_order_line_item.sku_id'),
  skuName: window.trans('consumer_order_line_item.sku_name'),
  price: window.trans('consumer_order_line_item.price'),
  quantity: window.trans('consumer_order_line_item.quantity'),
  amount: window.trans('consumer_order_line_item.amount'),
  lastUpdateTime: window.trans('consumer_order_line_item.last_update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'consumerOrderLineItem') , sorter: true },
  { title: fieldLabels.bizOrder, dataIndex: 'bizOrder', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.skuId, debugtype: 'string', dataIndex: 'skuId', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.skuName, debugtype: 'string', dataIndex: 'skuName', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.price, dataIndex: 'price', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.quantity, debugtype: 'double', dataIndex: 'quantity', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.amount, dataIndex: 'amount', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(consumerOrderLineItem,targetComponent)=>{

  const userContext = null
  return (
    <div key={consumerOrderLineItem.id}>
	
      <DescriptionList  key={consumerOrderLineItem.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{consumerOrderLineItem.id}</Description> 
        <Description term={fieldLabels.bizOrder}><div>{consumerOrderLineItem.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${consumerOrderLineItem.bizOrder.displayName}(${consumerOrderLineItem.bizOrder.id})`}
        </div></Description>
        <Description term={fieldLabels.skuId} style={{wordBreak: 'break-all'}}>{consumerOrderLineItem.skuId}</Description> 
        <Description term={fieldLabels.skuName} style={{wordBreak: 'break-all'}}>{consumerOrderLineItem.skuName}</Description> 
        <Description term={fieldLabels.price}><div style={{"color":"red"}}>{consumerOrderLineItem.price}</div></Description> 
        <Description term={fieldLabels.quantity}><div style={{"color":"red"}}>{consumerOrderLineItem.quantity}</div></Description> 
        <Description term={fieldLabels.amount}><div style={{"color":"red"}}>{consumerOrderLineItem.amount}</div></Description> 
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(consumerOrderLineItem.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"消费者订单行项目", menuFor: "consumerOrderLineItem",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  bizOrder: '订单',
  skuId: '产品ID',
  skuName: '产品名称',
  price: '价格',
  quantity: '数量',
  amount: '金额',
  lastUpdateTime: '最后更新时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'consumerOrderLineItem') , sorter: true },
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
        <Description term="序号">{consumerOrderLineItem.id}</Description> 
        <Description term="订单"><div>{consumerOrderLineItem.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${consumerOrderLineItem.bizOrder.displayName}(${consumerOrderLineItem.bizOrder.id})`}
        </div></Description>
        <Description term="产品ID">{consumerOrderLineItem.skuId}</Description> 
        <Description term="产品名称">{consumerOrderLineItem.skuName}</Description> 
        <Description term="价格"><div style={{"color":"red"}}>{consumerOrderLineItem.price}</div></Description> 
        <Description term="数量"><div style={{"color":"red"}}>{consumerOrderLineItem.quantity}</div></Description> 
        <Description term="金额"><div style={{"color":"red"}}>{consumerOrderLineItem.amount}</div></Description> 
        <Description term="最后更新时间"><div>{ moment(consumerOrderLineItem.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {skuId, skuName, price, quantity, amount, bizOrderId} = formValuesToPack
	const bizOrder = {id: bizOrderId, version: 2^31}
	const data = {skuId, skuName, price, quantity, amount, bizOrder}
	return data
}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {skuId, skuName, price, quantity, amount, bizOrderId} = formValuesToPack
	const bizOrder = {id: bizOrderId, version: 2^31}
	const data = {skuId, skuName, price, quantity, amount, bizOrder}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {skuId, skuName, price, quantity, amount, bizOrder} = objectToUnpack
	const bizOrderId = bizOrder ? bizOrder.id : null
	const data = {skuId, skuName, price, quantity, amount, bizOrderId}
	return data
}
<<<<<<< HEAD

const ConsumerOrderLineItemBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const ConsumerOrderLineItemBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default ConsumerOrderLineItemBase



