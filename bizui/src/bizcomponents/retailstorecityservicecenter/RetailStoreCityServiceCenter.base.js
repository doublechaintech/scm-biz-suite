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
const menuData = {menuName:"双链小超城市服务中心", menuFor: "retailStoreCityServiceCenter",
  		subItems: [
  {name: 'cityPartnerList', displayName:'城市合伙人', icon:'city',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'potentialCustomerList', displayName:'潜在的客户', icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'cityEventList', displayName:'城市活动', icon:'city',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreList', displayName:'双链小超', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('retail_store_city_service_center'), menuFor: "retailStoreCityServiceCenter",
  		subItems: [
  {name: 'cityPartnerList', displayName: window.mtrans('city_partner','retail_store_city_service_center.city_partner_list',false), type:'cityPartner',icon:'city',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'potentialCustomerList', displayName: window.mtrans('potential_customer','retail_store_city_service_center.potential_customer_list',false), type:'potentialCustomer',icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'cityEventList', displayName: window.mtrans('city_event','retail_store_city_service_center.city_event_list',false), type:'cityEvent',icon:'city',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreList', displayName: window.mtrans('retail_store','retail_store_city_service_center.retail_store_list',false), type:'retailStore',icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD

const settingMenuData = {menuName:"双链小超城市服务中心", menuFor: "retailStoreCityServiceCenter",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  founded: '成立',
  belongsTo: '属于',
  lastUpdateTime: '最后更新时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStoreCityServiceCenter') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.belongsTo, dataIndex: 'belongsTo', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(retailStoreCityServiceCenter,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreCityServiceCenter.id}>
	
      <DescriptionList  key={retailStoreCityServiceCenter.id} size="small" col="4">
        <Description term="序号">{retailStoreCityServiceCenter.id}</Description> 
        <Description term="名称">{retailStoreCityServiceCenter.name}</Description> 
        <Description term="成立"><div>{ moment(retailStoreCityServiceCenter.founded).format('YYYY-MM-DD')}</div></Description> 
        <Description term="属于"><div>{retailStoreCityServiceCenter.belongsTo==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreCityServiceCenter.belongsTo.displayName}(${retailStoreCityServiceCenter.belongsTo.id})`}
        </div></Description>
        <Description term="最后更新时间"><div>{ moment(retailStoreCityServiceCenter.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, founded, belongsToId} = formValuesToPack
	const belongsTo = {id: belongsToId, version: 2^31}
	const data = {name, founded, belongsTo}
	return data
}
=======

const settingMenuData = {menuName: window.trans('retail_store_city_service_center'), menuFor: "retailStoreCityServiceCenter",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('retail_store_city_service_center.id'),
  name: window.trans('retail_store_city_service_center.name'),
  founded: window.trans('retail_store_city_service_center.founded'),
  belongsTo: window.trans('retail_store_city_service_center.belongs_to'),
  lastUpdateTime: window.trans('retail_store_city_service_center.last_update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStoreCityServiceCenter') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.belongsTo, dataIndex: 'belongsTo', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(retailStoreCityServiceCenter,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreCityServiceCenter.id}>
	
      <DescriptionList  key={retailStoreCityServiceCenter.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{retailStoreCityServiceCenter.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{retailStoreCityServiceCenter.name}</Description> 
        <Description term={fieldLabels.founded}><div>{ moment(retailStoreCityServiceCenter.founded).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.belongsTo}><div>{retailStoreCityServiceCenter.belongsTo==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreCityServiceCenter.belongsTo.displayName}(${retailStoreCityServiceCenter.belongsTo.id})`}
        </div></Description>
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(retailStoreCityServiceCenter.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, founded, belongsToId} = formValuesToPack
	const belongsTo = {id: belongsToId, version: 2^31}
	const data = {name, founded, belongsTo}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, founded, belongsTo} = objectToUnpack
	const belongsToId = belongsTo ? belongsTo.id : null
	const data = {name, founded, belongsToId}
	return data
}
<<<<<<< HEAD

const RetailStoreCityServiceCenterBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const RetailStoreCityServiceCenterBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default RetailStoreCityServiceCenterBase



