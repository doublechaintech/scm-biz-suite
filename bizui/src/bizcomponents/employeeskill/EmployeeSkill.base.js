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



const menuData = {menuName: window.trans('employee_skill'), menuFor: "employeeSkill",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('employee_skill'), menuFor: "employeeSkill",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('employee_skill.id'),
  employee: window.trans('employee_skill.employee'),
  skillType: window.trans('employee_skill.skill_type'),
  description: window.trans('employee_skill.description'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeeSkill') , sorter: true },
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.skillType, dataIndex: 'skillType', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '11',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(employeeSkill, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
  const userContext = null
  return (
    <div key={employeeSkill.id}>
	
      <DescriptionList  key={employeeSkill.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{employeeSkill.id}</Description> 
        <Description term={fieldLabels.employee}><div>{employeeSkill.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeSkill.employee.displayName}(${employeeSkill.employee.id})`}
        </div></Description>
        <Description term={fieldLabels.skillType}><div>{employeeSkill.skillType==null?appLocaleName(userContext,"NotAssigned"):`${employeeSkill.skillType.displayName}(${employeeSkill.skillType.id})`}
        </div></Description>
        <Description term={fieldLabels.description} style={{wordBreak: 'break-all'}}>{employeeSkill.description}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {description, employeeId, skillTypeId} = formValuesToPack
	const employee = {id: employeeId, version: 2^31}
	const skillType = {id: skillTypeId, version: 2^31}
	const data = {description, employee, skillType}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {description, employee, skillType} = objectToUnpack
	const employeeId = employee ? employee.id : null
	const skillTypeId = skillType ? skillType.id : null
	const data = {description, employeeId, skillTypeId}
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
const EmployeeSkillBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default EmployeeSkillBase



