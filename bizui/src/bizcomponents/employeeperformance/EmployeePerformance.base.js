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



const menuData = {menuName: window.trans('employee_performance'), menuFor: "employeePerformance",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('employee_performance'), menuFor: "employeePerformance",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('employee_performance.id'),
  employee: window.trans('employee_performance.employee'),
  performanceComment: window.trans('employee_performance.performance_comment'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeePerformance') , sorter: true },
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.performanceComment, debugtype: 'string', dataIndex: 'performanceComment', width: '11',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(employeePerformance,targetComponent)=>{

  const userContext = null
  return (
    <div key={employeePerformance.id}>
	
      <DescriptionList  key={employeePerformance.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{employeePerformance.id}</Description> 
        <Description term={fieldLabels.employee}><div>{employeePerformance.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeePerformance.employee.displayName}(${employeePerformance.employee.id})`}
        </div></Description>
        <Description term={fieldLabels.performanceComment} style={{wordBreak: 'break-all'}}>{employeePerformance.performanceComment}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {performanceComment, employeeId} = formValuesToPack
	const employee = {id: employeeId, version: 2^31}
	const data = {performanceComment, employee}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {performanceComment, employee} = objectToUnpack
	const employeeId = employee ? employee.id : null
	const data = {performanceComment, employeeId}
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
const EmployeePerformanceBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default EmployeePerformanceBase



