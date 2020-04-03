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
import styles from './EmployeeEducation.base.less'
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



const menuData = {menuName: window.trans('employee_education'), menuFor: "employeeEducation",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('employee_education'), menuFor: "employeeEducation",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('employee_education.id'),
  employee: window.trans('employee_education.employee'),
  completeTime: window.trans('employee_education.complete_time'),
  type: window.trans('employee_education.type'),
  remark: window.trans('employee_education.remark'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeeEducation') , sorter: true },
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.completeTime, dataIndex: 'completeTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.type, debugtype: 'string', dataIndex: 'type', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.remark, debugtype: 'string', dataIndex: 'remark', width: '13',render: (text, record)=>renderTextCell(text,record)},

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
const renderItemOfList=(employeeEducation, targetComponent, columCount)=>{
  
  if(!employeeEducation){
  	return null
  }
  if(!employeeEducation.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`employeeEducation-${employeeEducation.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(employeeEducation.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={employeeEducation.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{employeeEducation.id}</Description> 
        <Description term={fieldLabels.employee}>{renderReferenceItem(employeeEducation.employee)}</Description>

        <Description term={fieldLabels.completeTime}><div>{ moment(employeeEducation.completeTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.type} style={{wordBreak: 'break-all'}}>{employeeEducation.type}</Description> 
        <Description term={fieldLabels.remark} style={{wordBreak: 'break-all'}}>{employeeEducation.remark}</Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {completeTime, type, remark, employeeId} = formValuesToPack
	const employee = {id: employeeId, version: 2^31}
	const data = {completeTime:moment(completeTime).valueOf(), type, remark, employee}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {completeTime, type, remark, employee} = objectToUnpack
	const employeeId = employee ? employee.id : null
	const data = {completeTime:moment(completeTime), type, remark, employeeId}
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
const EmployeeEducationBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default EmployeeEducationBase

