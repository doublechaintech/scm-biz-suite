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
const menuData = {menuName:"人力资源部面试", menuFor: "hrInterview",
  		subItems: [
  {name: 'employeeList', displayName:'员工', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('hr_interview'), menuFor: "hrInterview",
  		subItems: [
  {name: 'employeeList', displayName: window.mtrans('employee','hr_interview.employee_list',false), type:'employee',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}


<<<<<<< HEAD
const settingMenuData = {menuName:"人力资源部面试", menuFor: "hrInterview",
=======
const settingMenuData = {menuName: window.trans('hr_interview'), menuFor: "hrInterview",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

const fieldLabels = {
<<<<<<< HEAD
  id: '序号',
  who: '谁',
  interviewTime: '面试时间',
  comments: '评论',
=======
  id: window.trans('hr_interview.id'),
  who: window.trans('hr_interview.who'),
  interviewTime: window.trans('hr_interview.interview_time'),
  comments: window.trans('hr_interview.comments'),
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'hrInterview') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.interviewTime, dataIndex: 'interviewTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.comments, debugtype: 'string', dataIndex: 'comments', width: '17',render: (text, record)=>renderTextCell(text,record)},

]
<<<<<<< HEAD
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(hrInterview,targetComponent)=>{

  const userContext = null
  return (
    <div key={hrInterview.id}>
	
      <DescriptionList  key={hrInterview.id} size="small" col="4">
        <Description term="序号">{hrInterview.id}</Description> 
        <Description term="谁">{hrInterview.who}</Description> 
        <Description term="面试时间"><div>{ moment(hrInterview.interviewTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term="评论">{hrInterview.comments}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, interviewTime, comments} = formValuesToPack

	const data = {who, interviewTime, comments}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, interviewTime, comments} = objectToUnpack
=======


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(hrInterview,targetComponent)=>{

  const userContext = null
  return (
    <div key={hrInterview.id}>
	
      <DescriptionList  key={hrInterview.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{hrInterview.id}</Description> 
        <Description term={fieldLabels.who} style={{wordBreak: 'break-all'}}>{hrInterview.who}</Description> 
        <Description term={fieldLabels.interviewTime}><div>{ moment(hrInterview.interviewTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.comments} style={{wordBreak: 'break-all'}}>{hrInterview.comments}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, interviewTime, comments} = formValuesToPack
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

	const data = {who, interviewTime, comments}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, interviewTime, comments} = objectToUnpack

<<<<<<< HEAD
const HrInterviewBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
	const data = {who, interviewTime, comments}
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
const HrInterviewBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default HrInterviewBase



