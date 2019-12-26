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
const menuData = {menuName:"员工技能", menuFor: "employeeSkill",
=======

const menuData = {menuName: window.trans('employee_skill'), menuFor: "employeeSkill",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD

const settingMenuData = {menuName:"员工技能", menuFor: "employeeSkill",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  employee: '员工',
  skillType: '技能类型',
  description: '描述',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeeSkill') , sorter: true },
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.skillType, dataIndex: 'skillType', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '11',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(employeeSkill,targetComponent)=>{

  const userContext = null
  return (
    <div key={employeeSkill.id}>
	
      <DescriptionList  key={employeeSkill.id} size="small" col="4">
        <Description term="序号">{employeeSkill.id}</Description> 
        <Description term="员工"><div>{employeeSkill.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeSkill.employee.displayName}(${employeeSkill.employee.id})`}
        </div></Description>
        <Description term="技能类型"><div>{employeeSkill.skillType==null?appLocaleName(userContext,"NotAssigned"):`${employeeSkill.skillType.displayName}(${employeeSkill.skillType.id})`}
        </div></Description>
        <Description term="描述">{employeeSkill.description}</Description> 
	
        
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
=======

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

const renderItemOfList=(employeeSkill,targetComponent)=>{

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
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {description, employee, skillType} = objectToUnpack
	const employeeId = employee ? employee.id : null
	const skillTypeId = skillType ? skillType.id : null
	const data = {description, employeeId, skillTypeId}
	return data
}
<<<<<<< HEAD

const EmployeeSkillBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
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
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default EmployeeSkillBase



