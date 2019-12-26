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
  { title: fieldLabels.leaveDurationHour, debugtype: 'int', dataIndex: 'leaveDurationHour', width: '5',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.remark, debugtype: 'string', dataIndex: 'remark', width: '15',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(employeeLeave, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
  const userContext = null
  return (
    <div key={employeeLeave.id}>
	
      <DescriptionList  key={employeeLeave.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{employeeLeave.id}</Description> 
        <Description term={fieldLabels.who}><div>{employeeLeave.who==null?appLocaleName(userContext,"NotAssigned"):`${employeeLeave.who.displayName}(${employeeLeave.who.id})`}
        </div></Description>
        <Description term={fieldLabels.type}><div>{employeeLeave.type==null?appLocaleName(userContext,"NotAssigned"):`${employeeLeave.type.displayName}(${employeeLeave.type.id})`}
        </div></Description>
        <Description term={fieldLabels.leaveDurationHour}><div style={{"color":"red"}}>{employeeLeave.leaveDurationHour}</div></Description> 
        <Description term={fieldLabels.remark} style={{wordBreak: 'break-all'}}>{employeeLeave.remark}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
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
const EmployeeLeaveBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default EmployeeLeaveBase



