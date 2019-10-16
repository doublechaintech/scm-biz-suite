import React from 'react'
import { Icon,Divider } from 'antd'

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
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


const menuData = {menuName:"员工考勤", menuFor: "employeeAttendance",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"员工考勤", menuFor: "employeeAttendance",
  		subItems: [
  
  		],
}

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
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {enterTime, leaveTime, durationHours, remark, employee} = objectToUnpack
	const employeeId = employee ? employee.id : null
	const data = {enterTime, leaveTime, durationHours, remark, employeeId}
	return data
}

const EmployeeAttendanceBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
export default EmployeeAttendanceBase



