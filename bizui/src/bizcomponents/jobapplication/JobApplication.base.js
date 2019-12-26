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
const menuData = {menuName:"工作申请", menuFor: "jobApplication",
  		subItems: [
  {name: 'employeeList', displayName:'员工', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('job_application'), menuFor: "jobApplication",
  		subItems: [
  {name: 'employeeList', displayName: window.mtrans('employee','job_application.employee_list',false), type:'employee',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}


<<<<<<< HEAD
const settingMenuData = {menuName:"工作申请", menuFor: "jobApplication",
=======
const settingMenuData = {menuName: window.trans('job_application'), menuFor: "jobApplication",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

const fieldLabels = {
<<<<<<< HEAD
  id: '序号',
  applicationTime: '申请时间',
  who: '谁',
  comments: '评论',
=======
  id: window.trans('job_application.id'),
  applicationTime: window.trans('job_application.application_time'),
  who: window.trans('job_application.who'),
  comments: window.trans('job_application.comments'),
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'jobApplication') , sorter: true },
  { title: fieldLabels.applicationTime, dataIndex: 'applicationTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.comments, debugtype: 'string', dataIndex: 'comments', width: '35',render: (text, record)=>renderTextCell(text,record)},

]
<<<<<<< HEAD
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(jobApplication,targetComponent)=>{

  const userContext = null
  return (
    <div key={jobApplication.id}>
	
      <DescriptionList  key={jobApplication.id} size="small" col="4">
        <Description term="序号">{jobApplication.id}</Description> 
        <Description term="申请时间"><div>{ moment(jobApplication.applicationTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term="谁">{jobApplication.who}</Description> 
        <Description term="评论">{jobApplication.comments}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {applicationTime, who, comments} = formValuesToPack

	const data = {applicationTime, who, comments}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {applicationTime, who, comments} = objectToUnpack
=======


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(jobApplication,targetComponent)=>{

  const userContext = null
  return (
    <div key={jobApplication.id}>
	
      <DescriptionList  key={jobApplication.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{jobApplication.id}</Description> 
        <Description term={fieldLabels.applicationTime}><div>{ moment(jobApplication.applicationTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.who} style={{wordBreak: 'break-all'}}>{jobApplication.who}</Description> 
        <Description term={fieldLabels.comments} style={{wordBreak: 'break-all'}}>{jobApplication.comments}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {applicationTime, who, comments} = formValuesToPack
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

	const data = {applicationTime, who, comments}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {applicationTime, who, comments} = objectToUnpack

<<<<<<< HEAD
const JobApplicationBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
	const data = {applicationTime, who, comments}
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
const JobApplicationBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default JobApplicationBase



