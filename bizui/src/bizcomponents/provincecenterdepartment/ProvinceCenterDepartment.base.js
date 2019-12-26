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



const menuData = {menuName: window.trans('province_center_department'), menuFor: "provinceCenterDepartment",
  		subItems: [
  {name: 'provinceCenterEmployeeList', displayName: window.mtrans('province_center_employee','province_center_department.province_center_employee_list',false), type:'provinceCenterEmployee',icon:'align-center',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('province_center_department'), menuFor: "provinceCenterDepartment",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('province_center_department.id'),
  name: window.trans('province_center_department.name'),
  founded: window.trans('province_center_department.founded'),
  provinceCenter: window.trans('province_center_department.province_center'),
  manager: window.trans('province_center_department.manager'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'provinceCenterDepartment') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.provinceCenter, dataIndex: 'provinceCenter', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.manager, debugtype: 'string', dataIndex: 'manager', width: '7',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(provinceCenterDepartment, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
  const userContext = null
  return (
    <div key={provinceCenterDepartment.id}>
	
      <DescriptionList  key={provinceCenterDepartment.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{provinceCenterDepartment.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{provinceCenterDepartment.name}</Description> 
        <Description term={fieldLabels.founded}><div>{ moment(provinceCenterDepartment.founded).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.provinceCenter}><div>{provinceCenterDepartment.provinceCenter==null?appLocaleName(userContext,"NotAssigned"):`${provinceCenterDepartment.provinceCenter.displayName}(${provinceCenterDepartment.provinceCenter.id})`}
        </div></Description>
        <Description term={fieldLabels.manager} style={{wordBreak: 'break-all'}}>{provinceCenterDepartment.manager}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, founded, manager, provinceCenterId} = formValuesToPack
	const provinceCenter = {id: provinceCenterId, version: 2^31}
	const data = {name, founded, manager, provinceCenter}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, founded, manager, provinceCenter} = objectToUnpack
	const provinceCenterId = provinceCenter ? provinceCenter.id : null
	const data = {name, founded, manager, provinceCenterId}
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
const ProvinceCenterDepartmentBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default ProvinceCenterDepartmentBase



