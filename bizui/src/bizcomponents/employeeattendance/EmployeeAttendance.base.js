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


const menuData = {menuName:"Employee Attendance", menuFor: "employeeAttendance",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'Id',
  employee: 'Employee',
  enterTime: 'Enter Time',
  leaveTime: 'Leave Time',
  durationHours: 'Duration Hours',
  remark: 'Remark',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
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
<Description term="Id">{employeeAttendance.id}</Description> 
<Description term="Employee">{employeeAttendance.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeAttendance.employee.displayName}(${employeeAttendance.employee.id})`}
</Description>
<Description term="Enter Time">{ moment(employeeAttendance.enterTime).format('YYYY-MM-DD')}</Description> 
<Description term="Leave Time">{ moment(employeeAttendance.leaveTime).format('YYYY-MM-DD')}</Description> 
<Description term="Duration Hours">{employeeAttendance.durationHours}</Description> 
<Description term="Remark">{employeeAttendance.remark}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const EmployeeAttendanceBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default EmployeeAttendanceBase



