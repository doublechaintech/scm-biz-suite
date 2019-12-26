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



const menuData = {menuName: window.trans('employee_qualifier'), menuFor: "employeeQualifier",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('employee_qualifier'), menuFor: "employeeQualifier",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('employee_qualifier.id'),
  employee: window.trans('employee_qualifier.employee'),
  qualifiedTime: window.trans('employee_qualifier.qualified_time'),
  type: window.trans('employee_qualifier.type'),
  level: window.trans('employee_qualifier.level'),
  remark: window.trans('employee_qualifier.remark'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeeQualifier') , sorter: true },
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.qualifiedTime, dataIndex: 'qualifiedTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.type, debugtype: 'string', dataIndex: 'type', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.level, debugtype: 'string', dataIndex: 'level', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.remark, debugtype: 'string', dataIndex: 'remark', width: '13',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(employeeQualifier, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
  const userContext = null
  return (
    <div key={employeeQualifier.id}>
	
      <DescriptionList  key={employeeQualifier.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{employeeQualifier.id}</Description> 
        <Description term={fieldLabels.employee}><div>{employeeQualifier.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeQualifier.employee.displayName}(${employeeQualifier.employee.id})`}
        </div></Description>
        <Description term={fieldLabels.qualifiedTime}><div>{ moment(employeeQualifier.qualifiedTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.type} style={{wordBreak: 'break-all'}}>{employeeQualifier.type}</Description> 
        <Description term={fieldLabels.level} style={{wordBreak: 'break-all'}}>{employeeQualifier.level}</Description> 
        <Description term={fieldLabels.remark} style={{wordBreak: 'break-all'}}>{employeeQualifier.remark}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {qualifiedTime, type, level, remark, employeeId} = formValuesToPack
	const employee = {id: employeeId, version: 2^31}
	const data = {qualifiedTime, type, level, remark, employee}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {qualifiedTime, type, level, remark, employee} = objectToUnpack
	const employeeId = employee ? employee.id : null
	const data = {qualifiedTime, type, level, remark, employeeId}
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
const EmployeeQualifierBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default EmployeeQualifierBase



