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
const menuData = {menuName:"省中心员工", menuFor: "provinceCenterEmployee",
=======

const menuData = {menuName: window.trans('province_center_employee'), menuFor: "provinceCenterEmployee",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('province_center_employee'), menuFor: "provinceCenterEmployee",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('province_center_employee.id'),
  name: window.trans('province_center_employee.name'),
  mobile: window.trans('province_center_employee.mobile'),
  email: window.trans('province_center_employee.email'),
  founded: window.trans('province_center_employee.founded'),
  department: window.trans('province_center_employee.department'),
  provinceCenter: window.trans('province_center_employee.province_center'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'provinceCenterEmployee') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.mobile, debugtype: 'string_china_mobile_phone', dataIndex: 'mobile', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.email, debugtype: 'string_email', dataIndex: 'email', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.department, dataIndex: 'department', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.provinceCenter, dataIndex: 'provinceCenter', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(provinceCenterEmployee,targetComponent)=>{

  const userContext = null
  return (
    <div key={provinceCenterEmployee.id}>
	
      <DescriptionList  key={provinceCenterEmployee.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{provinceCenterEmployee.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{provinceCenterEmployee.name}</Description> 
        <Description term={fieldLabels.mobile} style={{wordBreak: 'break-all'}}>{provinceCenterEmployee.mobile}</Description> 
        <Description term={fieldLabels.email} style={{wordBreak: 'break-all'}}>{provinceCenterEmployee.email}</Description> 
        <Description term={fieldLabels.founded}><div>{ moment(provinceCenterEmployee.founded).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.department}><div>{provinceCenterEmployee.department==null?appLocaleName(userContext,"NotAssigned"):`${provinceCenterEmployee.department.displayName}(${provinceCenterEmployee.department.id})`}
        </div></Description>
        <Description term={fieldLabels.provinceCenter}><div>{provinceCenterEmployee.provinceCenter==null?appLocaleName(userContext,"NotAssigned"):`${provinceCenterEmployee.provinceCenter.displayName}(${provinceCenterEmployee.provinceCenter.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"省中心员工", menuFor: "provinceCenterEmployee",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  name: '名称',
  mobile: '手机',
  email: '电子邮件',
  founded: '成立',
  department: '部门',
  provinceCenter: '省中心',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'provinceCenterEmployee') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.mobile, debugtype: 'string_china_mobile_phone', dataIndex: 'mobile', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.email, debugtype: 'string_email', dataIndex: 'email', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.department, dataIndex: 'department', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.provinceCenter, dataIndex: 'provinceCenter', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(provinceCenterEmployee,targetComponent)=>{

  const userContext = null
  return (
    <div key={provinceCenterEmployee.id}>
	
      <DescriptionList  key={provinceCenterEmployee.id} size="small" col="4">
        <Description term="序号">{provinceCenterEmployee.id}</Description> 
        <Description term="名称">{provinceCenterEmployee.name}</Description> 
        <Description term="手机">{provinceCenterEmployee.mobile}</Description> 
        <Description term="电子邮件">{provinceCenterEmployee.email}</Description> 
        <Description term="成立"><div>{ moment(provinceCenterEmployee.founded).format('YYYY-MM-DD')}</div></Description> 
        <Description term="部门"><div>{provinceCenterEmployee.department==null?appLocaleName(userContext,"NotAssigned"):`${provinceCenterEmployee.department.displayName}(${provinceCenterEmployee.department.id})`}
        </div></Description>
        <Description term="省中心"><div>{provinceCenterEmployee.provinceCenter==null?appLocaleName(userContext,"NotAssigned"):`${provinceCenterEmployee.provinceCenter.displayName}(${provinceCenterEmployee.provinceCenter.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, mobile, email, founded, departmentId, provinceCenterId} = formValuesToPack
	const department = {id: departmentId, version: 2^31}
	const provinceCenter = {id: provinceCenterId, version: 2^31}
	const data = {name, mobile, email, founded, department, provinceCenter}
	return data
}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, mobile, email, founded, departmentId, provinceCenterId} = formValuesToPack
	const department = {id: departmentId, version: 2^31}
	const provinceCenter = {id: provinceCenterId, version: 2^31}
	const data = {name, mobile, email, founded, department, provinceCenter}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, mobile, email, founded, department, provinceCenter} = objectToUnpack
	const departmentId = department ? department.id : null
	const provinceCenterId = provinceCenter ? provinceCenter.id : null
	const data = {name, mobile, email, founded, departmentId, provinceCenterId}
	return data
}
<<<<<<< HEAD

const ProvinceCenterEmployeeBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const ProvinceCenterEmployeeBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default ProvinceCenterEmployeeBase



