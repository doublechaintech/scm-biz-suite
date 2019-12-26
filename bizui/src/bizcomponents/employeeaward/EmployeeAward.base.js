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



const menuData = {menuName: window.trans('employee_award'), menuFor: "employeeAward",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('employee_award'), menuFor: "employeeAward",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('employee_award.id'),
  employee: window.trans('employee_award.employee'),
  completeTime: window.trans('employee_award.complete_time'),
  type: window.trans('employee_award.type'),
  remark: window.trans('employee_award.remark'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeeAward') , sorter: true },
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.completeTime, dataIndex: 'completeTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.type, debugtype: 'string', dataIndex: 'type', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.remark, debugtype: 'string', dataIndex: 'remark', width: '13',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(employeeAward, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
  const userContext = null
  return (
    <div key={employeeAward.id}>
	
      <DescriptionList  key={employeeAward.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{employeeAward.id}</Description> 
        <Description term={fieldLabels.employee}><div>{employeeAward.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeAward.employee.displayName}(${employeeAward.employee.id})`}
        </div></Description>
        <Description term={fieldLabels.completeTime}><div>{ moment(employeeAward.completeTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.type} style={{wordBreak: 'break-all'}}>{employeeAward.type}</Description> 
        <Description term={fieldLabels.remark} style={{wordBreak: 'break-all'}}>{employeeAward.remark}</Description> 
	
        
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
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {completeTime, type, remark, employee} = objectToUnpack
	const employeeId = employee ? employee.id : null
	const data = {completeTime, type, remark, employeeId}
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
const EmployeeAwardBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default EmployeeAwardBase



