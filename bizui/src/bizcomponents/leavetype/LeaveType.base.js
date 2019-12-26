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
const menuData = {menuName:"请假类型", menuFor: "leaveType",
  		subItems: [
  {name: 'employeeLeaveList', displayName:'请假记录', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('leave_type'), menuFor: "leaveType",
  		subItems: [
  {name: 'employeeLeaveList', displayName: window.mtrans('employee_leave','leave_type.employee_leave_list',false), type:'employeeLeave',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('leave_type'), menuFor: "leaveType",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('leave_type.id'),
  code: window.trans('leave_type.code'),
  company: window.trans('leave_type.company'),
  description: window.trans('leave_type.description'),
  detailDescription: window.trans('leave_type.detail_description'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'leaveType') , sorter: true },
  { title: fieldLabels.code, debugtype: 'string', dataIndex: 'code', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.company, dataIndex: 'company', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.detailDescription, debugtype: 'string', dataIndex: 'detailDescription', width: '65',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(leaveType,targetComponent)=>{

  const userContext = null
  return (
    <div key={leaveType.id}>
	
      <DescriptionList  key={leaveType.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{leaveType.id}</Description> 
        <Description term={fieldLabels.code} style={{wordBreak: 'break-all'}}>{leaveType.code}</Description> 
        <Description term={fieldLabels.description} style={{wordBreak: 'break-all'}}>{leaveType.description}</Description> 
        <Description term={fieldLabels.detailDescription} style={{wordBreak: 'break-all'}}>{leaveType.detailDescription}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"请假类型", menuFor: "leaveType",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  code: '代码',
  company: '公司',
  description: '描述',
  detailDescription: '详细描述',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'leaveType') , sorter: true },
  { title: fieldLabels.code, debugtype: 'string', dataIndex: 'code', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.company, dataIndex: 'company', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.detailDescription, debugtype: 'string', dataIndex: 'detailDescription', width: '65',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(leaveType,targetComponent)=>{

  const userContext = null
  return (
    <div key={leaveType.id}>
	
      <DescriptionList  key={leaveType.id} size="small" col="4">
        <Description term="序号">{leaveType.id}</Description> 
        <Description term="代码">{leaveType.code}</Description> 
        <Description term="描述">{leaveType.description}</Description> 
        <Description term="详细描述">{leaveType.detailDescription}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {code, description, detailDescription, companyId} = formValuesToPack
	const company = {id: companyId, version: 2^31}
	const data = {code, description, detailDescription, company}
	return data
}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {code, description, detailDescription, companyId} = formValuesToPack
	const company = {id: companyId, version: 2^31}
	const data = {code, description, detailDescription, company}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {code, description, detailDescription, company} = objectToUnpack
	const companyId = company ? company.id : null
	const data = {code, description, detailDescription, companyId}
	return data
}
<<<<<<< HEAD

const LeaveTypeBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const LeaveTypeBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default LeaveTypeBase



