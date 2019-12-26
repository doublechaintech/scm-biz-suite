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
const menuData = {menuName:"审批工作要约", menuFor: "offerApproval",
  		subItems: [
  {name: 'employeeList', displayName:'员工', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('offer_approval'), menuFor: "offerApproval",
  		subItems: [
  {name: 'employeeList', displayName: window.mtrans('employee','offer_approval.employee_list',false), type:'employee',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}


<<<<<<< HEAD
const settingMenuData = {menuName:"审批工作要约", menuFor: "offerApproval",
=======
const settingMenuData = {menuName: window.trans('offer_approval'), menuFor: "offerApproval",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

const fieldLabels = {
<<<<<<< HEAD
  id: '序号',
  who: '谁',
  approveTime: '批准时间',
  comments: '评论',
=======
  id: window.trans('offer_approval.id'),
  who: window.trans('offer_approval.who'),
  approveTime: window.trans('offer_approval.approve_time'),
  comments: window.trans('offer_approval.comments'),
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'offerApproval') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.approveTime, dataIndex: 'approveTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.comments, debugtype: 'string', dataIndex: 'comments', width: '14',render: (text, record)=>renderTextCell(text,record)},

]
<<<<<<< HEAD
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(offerApproval,targetComponent)=>{

  const userContext = null
  return (
    <div key={offerApproval.id}>
	
      <DescriptionList  key={offerApproval.id} size="small" col="4">
        <Description term="序号">{offerApproval.id}</Description> 
        <Description term="谁">{offerApproval.who}</Description> 
        <Description term="批准时间"><div>{ moment(offerApproval.approveTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term="评论">{offerApproval.comments}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, approveTime, comments} = formValuesToPack

	const data = {who, approveTime, comments}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, approveTime, comments} = objectToUnpack
=======


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(offerApproval,targetComponent)=>{

  const userContext = null
  return (
    <div key={offerApproval.id}>
	
      <DescriptionList  key={offerApproval.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{offerApproval.id}</Description> 
        <Description term={fieldLabels.who} style={{wordBreak: 'break-all'}}>{offerApproval.who}</Description> 
        <Description term={fieldLabels.approveTime}><div>{ moment(offerApproval.approveTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.comments} style={{wordBreak: 'break-all'}}>{offerApproval.comments}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, approveTime, comments} = formValuesToPack
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

	const data = {who, approveTime, comments}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, approveTime, comments} = objectToUnpack

<<<<<<< HEAD
const OfferApprovalBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
	const data = {who, approveTime, comments}
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
const OfferApprovalBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default OfferApprovalBase



