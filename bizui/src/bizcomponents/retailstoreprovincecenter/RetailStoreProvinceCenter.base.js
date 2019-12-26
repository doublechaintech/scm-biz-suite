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
const menuData = {menuName:"双链小超省中心", menuFor: "retailStoreProvinceCenter",
  		subItems: [
  {name: 'provinceCenterEmployeeList', displayName:'省中心员工', icon:'align-center',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreCityServiceCenterList', displayName:'双链小超城市服务中心', icon:'city',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('retail_store_province_center'), menuFor: "retailStoreProvinceCenter",
  		subItems: [
  {name: 'provinceCenterEmployeeList', displayName: window.mtrans('province_center_employee','retail_store_province_center.province_center_employee_list',false), type:'provinceCenterEmployee',icon:'align-center',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreCityServiceCenterList', displayName: window.mtrans('retail_store_city_service_center','retail_store_province_center.retail_store_city_service_center_list',false), type:'retailStoreCityServiceCenter',icon:'city',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD

const settingMenuData = {menuName:"双链小超省中心", menuFor: "retailStoreProvinceCenter",
  		subItems: [
  {name: 'provinceCenterDepartmentList', displayName:'省中心', icon:'align-center',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  founded: '成立',
  country: '国',
  lastUpdateTime: '最后更新时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStoreProvinceCenter') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.country, dataIndex: 'country', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(retailStoreProvinceCenter,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreProvinceCenter.id}>
	
      <DescriptionList  key={retailStoreProvinceCenter.id} size="small" col="4">
        <Description term="序号">{retailStoreProvinceCenter.id}</Description> 
        <Description term="名称">{retailStoreProvinceCenter.name}</Description> 
        <Description term="成立"><div>{ moment(retailStoreProvinceCenter.founded).format('YYYY-MM-DD')}</div></Description> 
        <Description term="最后更新时间"><div>{ moment(retailStoreProvinceCenter.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, founded, countryId} = formValuesToPack
	const country = {id: countryId, version: 2^31}
	const data = {name, founded, country}
	return data
}
=======

const settingMenuData = {menuName: window.trans('retail_store_province_center'), menuFor: "retailStoreProvinceCenter",
  		subItems: [
  {name: 'provinceCenterDepartmentList', displayName: window.mtrans('province_center_department','retail_store_province_center.province_center_department_list',false),type:'provinceCenterDepartment', icon:'align-center',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: window.trans('retail_store_province_center.id'),
  name: window.trans('retail_store_province_center.name'),
  founded: window.trans('retail_store_province_center.founded'),
  country: window.trans('retail_store_province_center.country'),
  lastUpdateTime: window.trans('retail_store_province_center.last_update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStoreProvinceCenter') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.country, dataIndex: 'country', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(retailStoreProvinceCenter,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreProvinceCenter.id}>
	
      <DescriptionList  key={retailStoreProvinceCenter.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{retailStoreProvinceCenter.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{retailStoreProvinceCenter.name}</Description> 
        <Description term={fieldLabels.founded}><div>{ moment(retailStoreProvinceCenter.founded).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(retailStoreProvinceCenter.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, founded, countryId} = formValuesToPack
	const country = {id: countryId, version: 2^31}
	const data = {name, founded, country}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, founded, country} = objectToUnpack
	const countryId = country ? country.id : null
	const data = {name, founded, countryId}
	return data
}
<<<<<<< HEAD

const RetailStoreProvinceCenterBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const RetailStoreProvinceCenterBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default RetailStoreProvinceCenterBase



