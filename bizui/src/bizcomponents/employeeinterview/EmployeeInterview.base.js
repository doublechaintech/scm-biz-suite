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



const menuData = {menuName: window.trans('employee_interview'), menuFor: "employeeInterview",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('employee_interview'), menuFor: "employeeInterview",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('employee_interview.id'),
  employee: window.trans('employee_interview.employee'),
  interviewType: window.trans('employee_interview.interview_type'),
  remark: window.trans('employee_interview.remark'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeeInterview') , sorter: true },
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.interviewType, dataIndex: 'interviewType', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.remark, debugtype: 'string', dataIndex: 'remark', width: '14',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(employeeInterview,targetComponent)=>{

  const userContext = null
  return (
    <div key={employeeInterview.id}>
	
      <DescriptionList  key={employeeInterview.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{employeeInterview.id}</Description> 
        <Description term={fieldLabels.employee}><div>{employeeInterview.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeInterview.employee.displayName}(${employeeInterview.employee.id})`}
        </div></Description>
        <Description term={fieldLabels.interviewType}><div>{employeeInterview.interviewType==null?appLocaleName(userContext,"NotAssigned"):`${employeeInterview.interviewType.displayName}(${employeeInterview.interviewType.id})`}
        </div></Description>
        <Description term={fieldLabels.remark} style={{wordBreak: 'break-all'}}>{employeeInterview.remark}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {remark, employeeId, interviewTypeId} = formValuesToPack
	const employee = {id: employeeId, version: 2^31}
	const interviewType = {id: interviewTypeId, version: 2^31}
	const data = {remark, employee, interviewType}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {remark, employee, interviewType} = objectToUnpack
	const employeeId = employee ? employee.id : null
	const interviewTypeId = interviewType ? interviewType.id : null
	const data = {remark, employeeId, interviewTypeId}
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
const EmployeeInterviewBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default EmployeeInterviewBase



