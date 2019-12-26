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
const menuData = {menuName:"消费者订单交货", menuFor: "consumerOrderDelivery",
=======

const menuData = {menuName: window.trans('consumer_order_delivery'), menuFor: "consumerOrderDelivery",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}


<<<<<<< HEAD
const settingMenuData = {menuName:"消费者订单交货", menuFor: "consumerOrderDelivery",
=======
const settingMenuData = {menuName: window.trans('consumer_order_delivery'), menuFor: "consumerOrderDelivery",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

const fieldLabels = {
<<<<<<< HEAD
  id: '序号',
  who: '谁',
  deliveryTime: '交货时间',
=======
  id: window.trans('consumer_order_delivery.id'),
  who: window.trans('consumer_order_delivery.who'),
  deliveryTime: window.trans('consumer_order_delivery.delivery_time'),
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'consumerOrderDelivery') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.deliveryTime, dataIndex: 'deliveryTime', render: (text, record) =>renderDateCell(text,record), sorter: true },

]
<<<<<<< HEAD
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(consumerOrderDelivery,targetComponent)=>{

  const userContext = null
  return (
    <div key={consumerOrderDelivery.id}>
	
      <DescriptionList  key={consumerOrderDelivery.id} size="small" col="4">
        <Description term="序号">{consumerOrderDelivery.id}</Description> 
        <Description term="谁">{consumerOrderDelivery.who}</Description> 
        <Description term="交货时间"><div>{ moment(consumerOrderDelivery.deliveryTime).format('YYYY-MM-DD')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, deliveryTime} = formValuesToPack

	const data = {who, deliveryTime}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, deliveryTime} = objectToUnpack
=======


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(consumerOrderDelivery,targetComponent)=>{

  const userContext = null
  return (
    <div key={consumerOrderDelivery.id}>
	
      <DescriptionList  key={consumerOrderDelivery.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{consumerOrderDelivery.id}</Description> 
        <Description term={fieldLabels.who} style={{wordBreak: 'break-all'}}>{consumerOrderDelivery.who}</Description> 
        <Description term={fieldLabels.deliveryTime}><div>{ moment(consumerOrderDelivery.deliveryTime).format('YYYY-MM-DD')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, deliveryTime} = formValuesToPack
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

	const data = {who, deliveryTime}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, deliveryTime} = objectToUnpack

<<<<<<< HEAD
const ConsumerOrderDeliveryBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
	const data = {who, deliveryTime}
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
const ConsumerOrderDeliveryBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default ConsumerOrderDeliveryBase



