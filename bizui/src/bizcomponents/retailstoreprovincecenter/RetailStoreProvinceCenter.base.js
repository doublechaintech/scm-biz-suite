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
import styles from './RetailStoreProvinceCenter.base.less'
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



const menuData = {menuName: window.trans('retail_store_province_center'), menuFor: "retailStoreProvinceCenter",
  		subItems: [
  {name: 'provinceCenterEmployeeList', displayName: window.mtrans('province_center_employee','retail_store_province_center.province_center_employee_list',false), type:'provinceCenterEmployee',icon:'align-center',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreCityServiceCenterList', displayName: window.mtrans('retail_store_city_service_center','retail_store_province_center.retail_store_city_service_center_list',false), type:'retailStoreCityServiceCenter',icon:'city',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('retail_store_province_center'), menuFor: "retailStoreProvinceCenter",
  		subItems: [
  {name: 'provinceCenterDepartmentList', displayName: window.mtrans('province_center_department','retail_store_province_center.province_center_department_list',false), type:'provinceCenterDepartment', icon:'align-center',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
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
const renderItemOfList=(retailStoreProvinceCenter, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 4
=======

const renderItemOfList=(retailStoreProvinceCenter, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
>>>>>>> b1266426b024c6919f91c6b5be4635d10d614fe9
  const userContext = null
  return (
    <Card key={retailStoreProvinceCenter.id} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(retailStoreProvinceCenter.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={retailStoreProvinceCenter.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{retailStoreProvinceCenter.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{retailStoreProvinceCenter.name}</Description> 
        <Description term={fieldLabels.founded}><div>{ moment(retailStoreProvinceCenter.founded).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(retailStoreProvinceCenter.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, founded, countryId} = formValuesToPack
	const country = {id: countryId, version: 2^31}
	const data = {name, founded:moment(founded).valueOf(), country}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, founded, country} = objectToUnpack
	const countryId = country ? country.id : null
	const data = {name, founded:moment(founded), countryId}
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
const RetailStoreProvinceCenterBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default RetailStoreProvinceCenterBase

