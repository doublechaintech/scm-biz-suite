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
import styles from './EmployeeLeave.base.less'
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



const menuData = {menuName: window.trans('employee_leave'), menuFor: "employeeLeave",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('employee_leave'), menuFor: "employeeLeave",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('employee_leave.id'),
  who: window.trans('employee_leave.who'),
  type: window.trans('employee_leave.type'),
  leaveDurationHour: window.trans('employee_leave.leave_duration_hour'),
  remark: window.trans('employee_leave.remark'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeeLeave') , sorter: true },
  { title: fieldLabels.who, dataIndex: 'who', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.type, dataIndex: 'type', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.leaveDurationHour, dataIndex: 'leaveDurationHour', className:'money', render: (text, record) => renderTextCell(text, record), sorter: true  },
  { title: fieldLabels.remark, debugtype: 'string', dataIndex: 'remark', width: '15',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)
<<<<<<< HEAD
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
const renderItemOfList=(employeeLeave, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 4
=======

const renderItemOfList=(employeeLeave, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
>>>>>>> b1266426b024c6919f91c6b5be4635d10d614fe9
  const userContext = null
  return (
    <Card key={employeeLeave.id} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(employeeLeave.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={employeeLeave.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{employeeLeave.id}</Description> 
        <Description term={fieldLabels.who}><Tag color='blue' title={`${employeeLeave.who.id}-${employeeLeave.who.displayName}`}>{employeeLeave.who==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(employeeLeave.who.displayName,15)}`}
        </Tag></Description>
        <Description term={fieldLabels.type}><Tag color='blue' title={`${employeeLeave.type.id}-${employeeLeave.type.displayName}`}>{employeeLeave.type==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(employeeLeave.type.displayName,15)}`}
        </Tag></Description>
        <Description term={fieldLabels.leaveDurationHour}><div style={{"color":"red"}}>{employeeLeave.leaveDurationHour}</div></Description> 
        <Description term={fieldLabels.remark} style={{wordBreak: 'break-all'}}>{employeeLeave.remark}</Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {leaveDurationHour, remark, whoId, typeId} = formValuesToPack
	const who = {id: whoId, version: 2^31}
	const type = {id: typeId, version: 2^31}
	const data = {leaveDurationHour, remark, who, type}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {leaveDurationHour, remark, who, type} = objectToUnpack
	const whoId = who ? who.id : null
	const typeId = type ? type.id : null
	const data = {leaveDurationHour, remark, whoId, typeId}
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
const EmployeeLeaveBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default EmployeeLeaveBase

