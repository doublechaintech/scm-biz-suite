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
import styles from './ConsumerOrderPaymentGroup.base.less'
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



const menuData = {menuName: window.trans('consumer_order_payment_group'), menuFor: "consumerOrderPaymentGroup",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('consumer_order_payment_group'), menuFor: "consumerOrderPaymentGroup",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('consumer_order_payment_group.id'),
  name: window.trans('consumer_order_payment_group.name'),
  bizOrder: window.trans('consumer_order_payment_group.biz_order'),
  cardNumber: window.trans('consumer_order_payment_group.card_number'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'consumerOrderPaymentGroup') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.bizOrder, dataIndex: 'bizOrder', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.cardNumber, debugtype: 'string', dataIndex: 'cardNumber', width: '21',render: (text, record)=>renderTextCell(text,record)},

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
const renderItemOfList=(consumerOrderPaymentGroup, targetComponent, columCount)=>{
  
  if(!consumerOrderPaymentGroup){
  	return null
  }
  if(!consumerOrderPaymentGroup.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`consumerOrderPaymentGroup-${consumerOrderPaymentGroup.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(consumerOrderPaymentGroup.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={consumerOrderPaymentGroup.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{consumerOrderPaymentGroup.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{consumerOrderPaymentGroup.name}</Description> 
        <Description term={fieldLabels.bizOrder}>{renderReferenceItem(consumerOrderPaymentGroup.bizOrder)}</Description>

        <Description term={fieldLabels.cardNumber} style={{wordBreak: 'break-all'}}>{consumerOrderPaymentGroup.cardNumber}</Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, cardNumber, bizOrderId} = formValuesToPack
	const bizOrder = {id: bizOrderId, version: 2^31}
	const data = {name, cardNumber, bizOrder}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, cardNumber, bizOrder} = objectToUnpack
	const bizOrderId = bizOrder ? bizOrder.id : null
	const data = {name, cardNumber, bizOrderId}
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
const ConsumerOrderPaymentGroupBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default ConsumerOrderPaymentGroupBase

