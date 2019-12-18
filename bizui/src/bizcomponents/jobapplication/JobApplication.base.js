import React from 'react'
import { Icon,Divider, Avata, Card, Col} from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList

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



const menuData = {menuName: window.trans('job_application'), menuFor: "jobApplication",
  		subItems: [
  {name: 'employeeList', displayName: window.mtrans('employee','job_application.employee_list',false), type:'employee',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('job_application'), menuFor: "jobApplication",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('job_application.id'),
  applicationTime: window.trans('job_application.application_time'),
  who: window.trans('job_application.who'),
  comments: window.trans('job_application.comments'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'jobApplication') , sorter: true },
  { title: fieldLabels.applicationTime, dataIndex: 'applicationTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.comments, debugtype: 'string', dataIndex: 'comments', width: '35',render: (text, record)=>renderTextCell(text,record)},

]


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

	const data = {applicationTime, who, comments}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {applicationTime, who, comments} = objectToUnpack

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
export default JobApplicationBase



