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
const menuData = {menuName:"消费者的订单审批", menuFor: "consumerOrderApproval",
=======

const menuData = {menuName: window.trans('consumer_order_approval'), menuFor: "consumerOrderApproval",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}


<<<<<<< HEAD
const settingMenuData = {menuName:"消费者的订单审批", menuFor: "consumerOrderApproval",
=======
const settingMenuData = {menuName: window.trans('consumer_order_approval'), menuFor: "consumerOrderApproval",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

const fieldLabels = {
<<<<<<< HEAD
  id: '序号',
  who: '谁',
  approveTime: '批准时间',
=======
  id: window.trans('consumer_order_approval.id'),
  who: window.trans('consumer_order_approval.who'),
  approveTime: window.trans('consumer_order_approval.approve_time'),
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'consumerOrderApproval') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.approveTime, dataIndex: 'approveTime', render: (text, record) =>renderDateCell(text,record), sorter: true },

]
<<<<<<< HEAD
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(consumerOrderApproval,targetComponent)=>{

  const userContext = null
  return (
    <div key={consumerOrderApproval.id}>
	
      <DescriptionList  key={consumerOrderApproval.id} size="small" col="4">
        <Description term="序号">{consumerOrderApproval.id}</Description> 
        <Description term="谁">{consumerOrderApproval.who}</Description> 
        <Description term="批准时间"><div>{ moment(consumerOrderApproval.approveTime).format('YYYY-MM-DD')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, approveTime} = formValuesToPack

	const data = {who, approveTime}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, approveTime} = objectToUnpack
=======


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(consumerOrderApproval,targetComponent)=>{

  const userContext = null
  return (
    <div key={consumerOrderApproval.id}>
	
      <DescriptionList  key={consumerOrderApproval.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{consumerOrderApproval.id}</Description> 
        <Description term={fieldLabels.who} style={{wordBreak: 'break-all'}}>{consumerOrderApproval.who}</Description> 
        <Description term={fieldLabels.approveTime}><div>{ moment(consumerOrderApproval.approveTime).format('YYYY-MM-DD')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, approveTime} = formValuesToPack
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

	const data = {who, approveTime}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, approveTime} = objectToUnpack

<<<<<<< HEAD
const ConsumerOrderApprovalBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
	const data = {who, approveTime}
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
const ConsumerOrderApprovalBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default ConsumerOrderApprovalBase



