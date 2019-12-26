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
const menuData = {menuName:"员工工作经验", menuFor: "employeeWorkExperience",
=======

const menuData = {menuName: window.trans('employee_work_experience'), menuFor: "employeeWorkExperience",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD
=======

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
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"员工工作经验", menuFor: "employeeWorkExperience",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  employee: '员工',
  start: '开始',
  end: '结束',
  company: '公司',
  description: '描述',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeeWorkExperience') , sorter: true },
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.start, dataIndex: 'start', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.end, dataIndex: 'end', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.company, debugtype: 'string', dataIndex: 'company', width: '12',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '25',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(employeeWorkExperience,targetComponent)=>{

  const userContext = null
  return (
    <div key={employeeWorkExperience.id}>
	
      <DescriptionList  key={employeeWorkExperience.id} size="small" col="4">
        <Description term="序号">{employeeWorkExperience.id}</Description> 
        <Description term="员工"><div>{employeeWorkExperience.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeWorkExperience.employee.displayName}(${employeeWorkExperience.employee.id})`}
        </div></Description>
        <Description term="开始"><div>{ moment(employeeWorkExperience.start).format('YYYY-MM-DD')}</div></Description> 
        <Description term="结束"><div>{ moment(employeeWorkExperience.end).format('YYYY-MM-DD')}</div></Description> 
        <Description term="公司">{employeeWorkExperience.company}</Description> 
        <Description term="描述">{employeeWorkExperience.description}</Description> 
	
        
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
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {start, end, company, description, employeeId} = formValuesToPack
	const employee = {id: employeeId, version: 2^31}
	const data = {start, end, company, description, employee}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {start, end, company, description, employee} = objectToUnpack
	const employeeId = employee ? employee.id : null
	const data = {start, end, company, description, employeeId}
	return data
}
<<<<<<< HEAD

const EmployeeWorkExperienceBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const EmployeeWorkExperienceBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default EmployeeWorkExperienceBase



