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
const menuData = {menuName:"员工入职", menuFor: "employeeBoarding",
  		subItems: [
  {name: 'employeeList', displayName:'员工', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('employee_boarding'), menuFor: "employeeBoarding",
  		subItems: [
  {name: 'employeeList', displayName: window.mtrans('employee','employee_boarding.employee_list',false), type:'employee',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}


<<<<<<< HEAD
const settingMenuData = {menuName:"员工入职", menuFor: "employeeBoarding",
=======
const settingMenuData = {menuName: window.trans('employee_boarding'), menuFor: "employeeBoarding",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

const fieldLabels = {
<<<<<<< HEAD
  id: '序号',
  who: '谁',
  employTime: '使用时间',
  comments: '评论',
=======
  id: window.trans('employee_boarding.id'),
  who: window.trans('employee_boarding.who'),
  employTime: window.trans('employee_boarding.employ_time'),
  comments: window.trans('employee_boarding.comments'),
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeeBoarding') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.employTime, dataIndex: 'employTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.comments, debugtype: 'string', dataIndex: 'comments', width: '15',render: (text, record)=>renderTextCell(text,record)},

]
<<<<<<< HEAD
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(employeeBoarding,targetComponent)=>{

  const userContext = null
  return (
    <div key={employeeBoarding.id}>
	
      <DescriptionList  key={employeeBoarding.id} size="small" col="4">
        <Description term="序号">{employeeBoarding.id}</Description> 
        <Description term="谁">{employeeBoarding.who}</Description> 
        <Description term="使用时间"><div>{ moment(employeeBoarding.employTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term="评论">{employeeBoarding.comments}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, employTime, comments} = formValuesToPack

	const data = {who, employTime, comments}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, employTime, comments} = objectToUnpack
=======


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(employeeBoarding,targetComponent)=>{

  const userContext = null
  return (
    <div key={employeeBoarding.id}>
	
      <DescriptionList  key={employeeBoarding.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{employeeBoarding.id}</Description> 
        <Description term={fieldLabels.who} style={{wordBreak: 'break-all'}}>{employeeBoarding.who}</Description> 
        <Description term={fieldLabels.employTime}><div>{ moment(employeeBoarding.employTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.comments} style={{wordBreak: 'break-all'}}>{employeeBoarding.comments}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, employTime, comments} = formValuesToPack
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

	const data = {who, employTime, comments}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, employTime, comments} = objectToUnpack

<<<<<<< HEAD
const EmployeeBoardingBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
	const data = {who, employTime, comments}
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
const EmployeeBoardingBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default EmployeeBoardingBase



