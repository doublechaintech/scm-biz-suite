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



const menuData = {menuName: window.trans('employee_attendance'), menuFor: "employeeAttendance",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('employee_attendance'), menuFor: "employeeAttendance",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('employee_attendance.id'),
  employee: window.trans('employee_attendance.employee'),
  enterTime: window.trans('employee_attendance.enter_time'),
  leaveTime: window.trans('employee_attendance.leave_time'),
  durationHours: window.trans('employee_attendance.duration_hours'),
  remark: window.trans('employee_attendance.remark'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeeAttendance') , sorter: true },
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.enterTime, dataIndex: 'enterTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.leaveTime, dataIndex: 'leaveTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.durationHours, debugtype: 'int', dataIndex: 'durationHours', width: '5',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.remark, debugtype: 'string', dataIndex: 'remark', width: '11',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(employeeAttendance,targetComponent)=>{

  const userContext = null
  return (
    <div key={employeeAttendance.id}>
	
      <DescriptionList  key={employeeAttendance.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{employeeAttendance.id}</Description> 
        <Description term={fieldLabels.employee}><div>{employeeAttendance.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeAttendance.employee.displayName}(${employeeAttendance.employee.id})`}
        </div></Description>
        <Description term={fieldLabels.enterTime}><div>{ moment(employeeAttendance.enterTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.leaveTime}><div>{ moment(employeeAttendance.leaveTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.durationHours}><div style={{"color":"red"}}>{employeeAttendance.durationHours}</div></Description> 
        <Description term={fieldLabels.remark} style={{wordBreak: 'break-all'}}>{employeeAttendance.remark}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {enterTime, leaveTime, durationHours, remark, employeeId} = formValuesToPack
	const employee = {id: employeeId, version: 2^31}
	const data = {enterTime, leaveTime, durationHours, remark, employee}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {enterTime, leaveTime, durationHours, remark, employee} = objectToUnpack
	const employeeId = employee ? employee.id : null
	const data = {enterTime, leaveTime, durationHours, remark, employeeId}
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
const EmployeeAttendanceBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default EmployeeAttendanceBase



