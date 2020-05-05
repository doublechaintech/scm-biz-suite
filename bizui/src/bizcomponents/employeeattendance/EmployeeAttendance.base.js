import React from 'react'
import { Icon,Divider, Avatar, Card, Col, Tag} from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
import styles from './EmployeeAttendance.base.less'
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
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '6', render: (text, record)=>renderTextCell(text,record,'employeeAttendance') , sorter: true },
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.enterTime, dataIndex: 'enterTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.leaveTime, dataIndex: 'leaveTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.durationHours, dataIndex: 'durationHours', className:'money', render: (text, record) => renderTextCell(text, record), sorter: true  },
  { title: fieldLabels.remark, debugtype: 'string', dataIndex: 'remark', width: '11',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)
const colorList = ['#f56a00', '#7265e6', '#ffbf00', '#00a2ae'];
let counter = 0;
const genColor=()=>{
	counter++;
	return colorList[counter%colorList.length];
}
const followColor=()=>{
	return 'green';
	// return colorList[counter%colorList.length];
}
const leftChars=(value, left)=>{
	const chars = left || 4
	if(!value){
		return "N/A"
	}
	return value.substring(0,chars);
}

const renderTextItem=(value, label, targetComponent)=>{
	const userContext = null
	if(!value){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.id){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.displayName){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	
	return <Tag color='blue' title={`${value.displayName}(${value.id})`}>{leftChars(value.displayName)}</Tag>
}
const renderImageItem=(value,label, targetComponent)=>{
	const userContext = null
	if(!value){
		return appLocaleName(userContext,"NotAssigned")
	}
	
	return <ImagePreview title={label} imageLocation={value}/>
}

const renderDateItem=(value, label,targetComponent)=>{
	const userContext = null
	if(!value){
		return appLocaleName(userContext,"NotAssigned")
	}
	return moment(value).format('YYYY-MM-DD');
}

const renderDateTimeItem=(value,label, targetComponent)=>{
	const userContext = window.userContext
	if(!value){
		return appLocaleName(userContext,"NotAssigned")
	}
	return  moment(value).format('YYYY-MM-DD HH:mm')
}


const renderReferenceItem=(value,label, targetComponent)=>{
	const userContext = null
	if(!value){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.id){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.displayName){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	
	return <Tag color='blue' title={`${value.displayName}(${value.id})`}>{leftChars(value.displayName)}</Tag>
}

const renderItemOfList=(employeeAttendance, targetComponent, columCount, listName)=>{
  
  if(!employeeAttendance){
  	return null
  }
  if(!employeeAttendance.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`${listName}-${employeeAttendance.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(employeeAttendance.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={employeeAttendance.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{employeeAttendance.id}</Description> 
        <Description term={fieldLabels.employee}>{renderReferenceItem(employeeAttendance.employee)}</Description>

        <Description term={fieldLabels.enterTime}><div>{ moment(employeeAttendance.enterTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.leaveTime}><div>{ moment(employeeAttendance.leaveTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.durationHours}><div style={{"color":"red"}}>{employeeAttendance.durationHours}</div></Description> 
        <Description term={fieldLabels.remark} style={{wordBreak: 'break-all'}}>{employeeAttendance.remark}</Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {enterTime, leaveTime, durationHours, remark, employeeId} = formValuesToPack
	const employee = {id: employeeId, version: 2^31}
	const data = {enterTime:moment(enterTime).valueOf(), leaveTime:moment(leaveTime).valueOf(), durationHours, remark, employee}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {enterTime, leaveTime, durationHours, remark, employee} = objectToUnpack
	const employeeId = employee ? employee.id : null
	const data = {enterTime:moment(enterTime), leaveTime:moment(leaveTime), durationHours, remark, employeeId}
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
const EmployeeAttendanceBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default EmployeeAttendanceBase

