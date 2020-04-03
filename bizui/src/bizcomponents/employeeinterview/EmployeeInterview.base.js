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
import styles from './EmployeeInterview.base.less'
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
const renderItemOfList=(employeeInterview, targetComponent, columCount)=>{
  
  if(!employeeInterview){
  	return null
  }
  if(!employeeInterview.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`employeeInterview-${employeeInterview.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(employeeInterview.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={employeeInterview.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{employeeInterview.id}</Description> 
        <Description term={fieldLabels.employee}>{renderReferenceItem(employeeInterview.employee)}</Description>

        <Description term={fieldLabels.interviewType}>{renderReferenceItem(employeeInterview.interviewType)}</Description>

        <Description term={fieldLabels.remark} style={{wordBreak: 'break-all'}}>{employeeInterview.remark}</Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
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
const EmployeeInterviewBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default EmployeeInterviewBase

