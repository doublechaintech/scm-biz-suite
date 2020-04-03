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
import styles from './EmployeeWorkExperience.base.less'
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



const menuData = {menuName: window.trans('employee_work_experience'), menuFor: "employeeWorkExperience",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('employee_work_experience'), menuFor: "employeeWorkExperience",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('employee_work_experience.id'),
  employee: window.trans('employee_work_experience.employee'),
  start: window.trans('employee_work_experience.start'),
  end: window.trans('employee_work_experience.end'),
  company: window.trans('employee_work_experience.company'),
  description: window.trans('employee_work_experience.description'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeeWorkExperience') , sorter: true },
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.start, dataIndex: 'start', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.end, dataIndex: 'end', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.company, debugtype: 'string', dataIndex: 'company', width: '12',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '25',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)
<<<<<<< HEAD
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
const renderItemOfList=(employeeWorkExperience, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 4
=======

const renderItemOfList=(employeeWorkExperience, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
>>>>>>> b1266426b024c6919f91c6b5be4635d10d614fe9
  const userContext = null
  return (
    <Card key={employeeWorkExperience.id} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(employeeWorkExperience.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={employeeWorkExperience.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{employeeWorkExperience.id}</Description> 
        <Description term={fieldLabels.employee}><Tag color='blue' title={`${employeeWorkExperience.employee.id}-${employeeWorkExperience.employee.displayName}`}>{employeeWorkExperience.employee==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(employeeWorkExperience.employee.displayName,15)}`}
        </Tag></Description>
        <Description term={fieldLabels.start}><div>{ moment(employeeWorkExperience.start).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.end}><div>{ moment(employeeWorkExperience.end).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.company} style={{wordBreak: 'break-all'}}>{employeeWorkExperience.company}</Description> 
        <Description term={fieldLabels.description} style={{wordBreak: 'break-all'}}>{employeeWorkExperience.description}</Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {start, end, company, description, employeeId} = formValuesToPack
	const employee = {id: employeeId, version: 2^31}
	const data = {start:moment(start).valueOf(), end:moment(end).valueOf(), company, description, employee}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {start, end, company, description, employee} = objectToUnpack
	const employeeId = employee ? employee.id : null
	const data = {start:moment(start), end:moment(end), company, description, employeeId}
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
const EmployeeWorkExperienceBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default EmployeeWorkExperienceBase

