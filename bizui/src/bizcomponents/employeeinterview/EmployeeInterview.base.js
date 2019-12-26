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
const menuData = {menuName:"员工面试", menuFor: "employeeInterview",
=======

const menuData = {menuName: window.trans('employee_interview'), menuFor: "employeeInterview",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD

const settingMenuData = {menuName:"员工面试", menuFor: "employeeInterview",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  employee: '员工',
  interviewType: '面试类型',
  remark: '备注',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeeInterview') , sorter: true },
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.interviewType, dataIndex: 'interviewType', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.remark, debugtype: 'string', dataIndex: 'remark', width: '14',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(employeeInterview,targetComponent)=>{

  const userContext = null
  return (
    <div key={employeeInterview.id}>
	
      <DescriptionList  key={employeeInterview.id} size="small" col="4">
        <Description term="序号">{employeeInterview.id}</Description> 
        <Description term="员工"><div>{employeeInterview.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeInterview.employee.displayName}(${employeeInterview.employee.id})`}
        </div></Description>
        <Description term="面试类型"><div>{employeeInterview.interviewType==null?appLocaleName(userContext,"NotAssigned"):`${employeeInterview.interviewType.displayName}(${employeeInterview.interviewType.id})`}
        </div></Description>
        <Description term="备注">{employeeInterview.remark}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {remark, employeeId, interviewTypeId} = formValuesToPack
	const employee = {id: employeeId, version: 2^31}
	const interviewType = {id: interviewTypeId, version: 2^31}
	const data = {remark, employee, interviewType}
	return data
}
=======

const settingMenuData = {menuName: window.trans('employee_interview'), menuFor: "employeeInterview",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('employee_interview.id'),
  employee: window.trans('employee_interview.employee'),
  interviewType: window.trans('employee_interview.interview_type'),
  remark: window.trans('employee_interview.remark'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeeInterview') , sorter: true },
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.interviewType, dataIndex: 'interviewType', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.remark, debugtype: 'string', dataIndex: 'remark', width: '14',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(employeeInterview,targetComponent)=>{

  const userContext = null
  return (
    <div key={employeeInterview.id}>
	
      <DescriptionList  key={employeeInterview.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{employeeInterview.id}</Description> 
        <Description term={fieldLabels.employee}><div>{employeeInterview.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeInterview.employee.displayName}(${employeeInterview.employee.id})`}
        </div></Description>
        <Description term={fieldLabels.interviewType}><div>{employeeInterview.interviewType==null?appLocaleName(userContext,"NotAssigned"):`${employeeInterview.interviewType.displayName}(${employeeInterview.interviewType.id})`}
        </div></Description>
        <Description term={fieldLabels.remark} style={{wordBreak: 'break-all'}}>{employeeInterview.remark}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {remark, employeeId, interviewTypeId} = formValuesToPack
	const employee = {id: employeeId, version: 2^31}
	const interviewType = {id: interviewTypeId, version: 2^31}
	const data = {remark, employee, interviewType}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {remark, employee, interviewType} = objectToUnpack
	const employeeId = employee ? employee.id : null
	const interviewTypeId = interviewType ? interviewType.id : null
	const data = {remark, employeeId, interviewTypeId}
	return data
}
<<<<<<< HEAD

const EmployeeInterviewBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const EmployeeInterviewBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default EmployeeInterviewBase



