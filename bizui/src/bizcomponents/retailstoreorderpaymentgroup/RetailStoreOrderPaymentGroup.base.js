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
const menuData = {menuName:"生超订单付款组", menuFor: "retailStoreOrderPaymentGroup",
=======

const menuData = {menuName: window.trans('retail_store_order_payment_group'), menuFor: "retailStoreOrderPaymentGroup",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD

const settingMenuData = {menuName:"生超订单付款组", menuFor: "retailStoreOrderPaymentGroup",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  bizOrder: '订单',
  cardNumber: '卡号码',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStoreOrderPaymentGroup') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.bizOrder, dataIndex: 'bizOrder', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.cardNumber, debugtype: 'string', dataIndex: 'cardNumber', width: '21',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(retailStoreOrderPaymentGroup,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreOrderPaymentGroup.id}>
	
      <DescriptionList  key={retailStoreOrderPaymentGroup.id} size="small" col="4">
        <Description term="序号">{retailStoreOrderPaymentGroup.id}</Description> 
        <Description term="名称">{retailStoreOrderPaymentGroup.name}</Description> 
        <Description term="订单"><div>{retailStoreOrderPaymentGroup.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreOrderPaymentGroup.bizOrder.displayName}(${retailStoreOrderPaymentGroup.bizOrder.id})`}
        </div></Description>
        <Description term="卡号码">{retailStoreOrderPaymentGroup.cardNumber}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, cardNumber, bizOrderId} = formValuesToPack
	const bizOrder = {id: bizOrderId, version: 2^31}
	const data = {name, cardNumber, bizOrder}
	return data
}
=======

const settingMenuData = {menuName: window.trans('retail_store_order_payment_group'), menuFor: "retailStoreOrderPaymentGroup",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('retail_store_order_payment_group.id'),
  name: window.trans('retail_store_order_payment_group.name'),
  bizOrder: window.trans('retail_store_order_payment_group.biz_order'),
  cardNumber: window.trans('retail_store_order_payment_group.card_number'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStoreOrderPaymentGroup') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.bizOrder, dataIndex: 'bizOrder', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.cardNumber, debugtype: 'string', dataIndex: 'cardNumber', width: '21',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(retailStoreOrderPaymentGroup,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreOrderPaymentGroup.id}>
	
      <DescriptionList  key={retailStoreOrderPaymentGroup.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{retailStoreOrderPaymentGroup.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{retailStoreOrderPaymentGroup.name}</Description> 
        <Description term={fieldLabels.bizOrder}><div>{retailStoreOrderPaymentGroup.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreOrderPaymentGroup.bizOrder.displayName}(${retailStoreOrderPaymentGroup.bizOrder.id})`}
        </div></Description>
        <Description term={fieldLabels.cardNumber} style={{wordBreak: 'break-all'}}>{retailStoreOrderPaymentGroup.cardNumber}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, cardNumber, bizOrderId} = formValuesToPack
	const bizOrder = {id: bizOrderId, version: 2^31}
	const data = {name, cardNumber, bizOrder}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, cardNumber, bizOrder} = objectToUnpack
	const bizOrderId = bizOrder ? bizOrder.id : null
	const data = {name, cardNumber, bizOrderId}
	return data
}
<<<<<<< HEAD

const RetailStoreOrderPaymentGroupBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const RetailStoreOrderPaymentGroupBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default RetailStoreOrderPaymentGroupBase



