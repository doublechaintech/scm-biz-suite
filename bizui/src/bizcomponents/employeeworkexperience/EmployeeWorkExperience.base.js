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

const renderItemOfList=(employeeWorkExperience,targetComponent)=>{

  const userContext = null
  return (
    <div key={employeeWorkExperience.id}>
	
      <DescriptionList  key={employeeWorkExperience.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{employeeWorkExperience.id}</Description> 
        <Description term={fieldLabels.employee}><div>{employeeWorkExperience.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeWorkExperience.employee.displayName}(${employeeWorkExperience.employee.id})`}
        </div></Description>
        <Description term={fieldLabels.start}><div>{ moment(employeeWorkExperience.start).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.end}><div>{ moment(employeeWorkExperience.end).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.company} style={{wordBreak: 'break-all'}}>{employeeWorkExperience.company}</Description> 
        <Description term={fieldLabels.description} style={{wordBreak: 'break-all'}}>{employeeWorkExperience.description}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {start, end, company, description, employeeId} = formValuesToPack
	const employee = {id: employeeId, version: 2^31}
	const data = {start, end, company, description, employee}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {start, end, company, description, employee} = objectToUnpack
	const employeeId = employee ? employee.id : null
	const data = {start, end, company, description, employeeId}
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
const EmployeeWorkExperienceBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default EmployeeWorkExperienceBase



