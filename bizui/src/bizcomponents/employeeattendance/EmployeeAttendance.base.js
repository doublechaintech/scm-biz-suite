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
const menuData = {menuName:"员工考勤", menuFor: "employeeAttendance",
=======

const menuData = {menuName: window.trans('employee_attendance'), menuFor: "employeeAttendance",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD
=======

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
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"员工考勤", menuFor: "employeeAttendance",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  employee: '员工',
  enterTime: '进入时间',
  leaveTime: '离开的时候',
  durationHours: '持续时间',
  remark: '备注',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeeAttendance') , sorter: true },
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.enterTime, dataIndex: 'enterTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.leaveTime, dataIndex: 'leaveTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.durationHours, debugtype: 'int', dataIndex: 'durationHours', width: '5',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.remark, debugtype: 'string', dataIndex: 'remark', width: '11',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(employeeAttendance,targetComponent)=>{

  const userContext = null
  return (
    <div key={employeeAttendance.id}>
	
      <DescriptionList  key={employeeAttendance.id} size="small" col="4">
        <Description term="序号">{employeeAttendance.id}</Description> 
        <Description term="员工"><div>{employeeAttendance.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeAttendance.employee.displayName}(${employeeAttendance.employee.id})`}
        </div></Description>
        <Description term="进入时间"><div>{ moment(employeeAttendance.enterTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term="离开的时候"><div>{ moment(employeeAttendance.leaveTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term="持续时间"><div style={{"color":"red"}}>{employeeAttendance.durationHours}</div></Description> 
        <Description term="备注">{employeeAttendance.remark}</Description> 
	
        
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
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {enterTime, leaveTime, durationHours, remark, employeeId} = formValuesToPack
	const employee = {id: employeeId, version: 2^31}
	const data = {enterTime, leaveTime, durationHours, remark, employee}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {enterTime, leaveTime, durationHours, remark, employee} = objectToUnpack
	const employeeId = employee ? employee.id : null
	const data = {enterTime, leaveTime, durationHours, remark, employeeId}
	return data
}
<<<<<<< HEAD

const EmployeeAttendanceBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const EmployeeAttendanceBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default EmployeeAttendanceBase



