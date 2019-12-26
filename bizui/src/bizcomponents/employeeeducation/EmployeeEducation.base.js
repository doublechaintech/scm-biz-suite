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
const menuData = {menuName:"员工教育", menuFor: "employeeEducation",
=======

const menuData = {menuName: window.trans('employee_education'), menuFor: "employeeEducation",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD
=======

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

const renderItemOfList=(employeeEducation,targetComponent)=>{

  const userContext = null
  return (
    <div key={employeeEducation.id}>
	
      <DescriptionList  key={employeeEducation.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{employeeEducation.id}</Description> 
        <Description term={fieldLabels.employee}><div>{employeeEducation.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeEducation.employee.displayName}(${employeeEducation.employee.id})`}
        </div></Description>
        <Description term={fieldLabels.completeTime}><div>{ moment(employeeEducation.completeTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.type} style={{wordBreak: 'break-all'}}>{employeeEducation.type}</Description> 
        <Description term={fieldLabels.remark} style={{wordBreak: 'break-all'}}>{employeeEducation.remark}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"员工教育", menuFor: "employeeEducation",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  employee: '员工',
  completeTime: '完成时间',
  type: '类型',
  remark: '备注',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeeEducation') , sorter: true },
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.completeTime, dataIndex: 'completeTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.type, debugtype: 'string', dataIndex: 'type', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.remark, debugtype: 'string', dataIndex: 'remark', width: '13',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(employeeEducation,targetComponent)=>{

  const userContext = null
  return (
    <div key={employeeEducation.id}>
	
      <DescriptionList  key={employeeEducation.id} size="small" col="4">
        <Description term="序号">{employeeEducation.id}</Description> 
        <Description term="员工"><div>{employeeEducation.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeEducation.employee.displayName}(${employeeEducation.employee.id})`}
        </div></Description>
        <Description term="完成时间"><div>{ moment(employeeEducation.completeTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term="类型">{employeeEducation.type}</Description> 
        <Description term="备注">{employeeEducation.remark}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {completeTime, type, remark, employeeId} = formValuesToPack
	const employee = {id: employeeId, version: 2^31}
	const data = {completeTime, type, remark, employee}
	return data
}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {completeTime, type, remark, employeeId} = formValuesToPack
	const employee = {id: employeeId, version: 2^31}
	const data = {completeTime, type, remark, employee}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {completeTime, type, remark, employee} = objectToUnpack
	const employeeId = employee ? employee.id : null
	const data = {completeTime, type, remark, employeeId}
	return data
}
<<<<<<< HEAD

const EmployeeEducationBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const EmployeeEducationBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default EmployeeEducationBase



