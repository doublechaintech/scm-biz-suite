import React from 'react'
import { Icon,Divider, Avatar, Card, Col, Tag} from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
import styles from './ConsumerOrderLineItem.base.less'
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



const menuData = {menuName: window.trans('consumer_order_line_item'), menuFor: "consumerOrderLineItem",
  		subItems: [
  
  		],
}


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
  { title: fieldLabels.quantity, dataIndex: 'quantity', className:'money', render: (text, record) => renderTextCell(text, record), sorter: true  },
  { title: fieldLabels.amount, dataIndex: 'amount', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)
const colorList = ['#f56a00', '#7265e6', '#ffbf00', '#00a2ae'];
let counter = 0;
const genColor=()=>{
	counter++;
	return colorList[counter%colorList.length];
}
const followColor=()=>{
	return 'green';
	// return colorList[counter%colorList.length];
}
const leftChars=(value, left)=>{
	const chars = left || 4
	if(!value){
		return "N/A"
	}
	return value.substring(0,chars);
}

const renderReferenceItem=(value, targetComponent)=>{
	const userContext = null
	if(!value){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.id){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.displayName){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	
	return <Tag color='blue' title={`${value.displayName}()`}>{leftChars(value.displayName)}</Tag>
	
	
	
	
}
const renderItemOfList=(consumerOrderLineItem, targetComponent, columCount)=>{
  
  if(!consumerOrderLineItem){
  	return null
  }
  if(!consumerOrderLineItem.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`consumerOrderLineItem-${consumerOrderLineItem.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(consumerOrderLineItem.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={consumerOrderLineItem.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{consumerOrderLineItem.id}</Description> 
        <Description term={fieldLabels.bizOrder}>{renderReferenceItem(consumerOrderLineItem.bizOrder)}</Description>

        <Description term={fieldLabels.skuId} style={{wordBreak: 'break-all'}}>{consumerOrderLineItem.skuId}</Description> 
        <Description term={fieldLabels.skuName} style={{wordBreak: 'break-all'}}>{consumerOrderLineItem.skuName}</Description> 
        <Description term={fieldLabels.price}><div style={{"color":"red"}}>{consumerOrderLineItem.price}</div></Description> 
        <Description term={fieldLabels.quantity}><div style={{"color":"red"}}>{consumerOrderLineItem.quantity}</div></Description> 
        <Description term={fieldLabels.amount}><div style={{"color":"red"}}>{consumerOrderLineItem.amount}</div></Description> 
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(consumerOrderLineItem.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {skuId, skuName, price, quantity, amount, bizOrderId} = formValuesToPack
	const bizOrder = {id: bizOrderId, version: 2^31}
	const data = {skuId, skuName, price, quantity, amount, bizOrder}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {skuId, skuName, price, quantity, amount, bizOrder} = objectToUnpack
	const bizOrderId = bizOrder ? bizOrder.id : null
	const data = {skuId, skuName, price, quantity, amount, bizOrderId}
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
const ConsumerOrderLineItemBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default ConsumerOrderLineItemBase

