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
const menuData = {menuName:"双链小超", menuFor: "retailStore",
  		subItems: [
  {name: 'consumerOrderList', displayName:'消费者订单', icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreOrderList', displayName:'生超的订单', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'goodsList', displayName:'货物', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'transportTaskList', displayName:'运输任务', icon:'tasks',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'accountSetList', displayName:'账套', icon:'headset',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('retail_store'), menuFor: "retailStore",
  		subItems: [
  {name: 'consumerOrderList', displayName: window.mtrans('consumer_order','retail_store.consumer_order_list',false), type:'consumerOrder',icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreOrderList', displayName: window.mtrans('retail_store_order','retail_store.retail_store_order_list',false), type:'retailStoreOrder',icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'goodsList', displayName: window.mtrans('goods','retail_store.goods_list',false), type:'goods',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'transportTaskList', displayName: window.mtrans('transport_task','retail_store.transport_task_list',false), type:'transportTask',icon:'tasks',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'accountSetList', displayName: window.mtrans('account_set','retail_store.account_set_list',false), type:'accountSet',icon:'headset',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('retail_store'), menuFor: "retailStore",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('retail_store.id'),
  name: window.trans('retail_store.name'),
  telephone: window.trans('retail_store.telephone'),
  owner: window.trans('retail_store.owner'),
  retailStoreCountryCenter: window.trans('retail_store.retail_store_country_center'),
  cityServiceCenter: window.trans('retail_store.city_service_center'),
  creation: window.trans('retail_store.creation'),
  investmentInvitation: window.trans('retail_store.investment_invitation'),
  franchising: window.trans('retail_store.franchising'),
  decoration: window.trans('retail_store.decoration'),
  opening: window.trans('retail_store.opening'),
  closing: window.trans('retail_store.closing'),
  founded: window.trans('retail_store.founded'),
  latitude: window.trans('retail_store.latitude'),
  longitude: window.trans('retail_store.longitude'),
  description: window.trans('retail_store.description'),
  lastUpdateTime: window.trans('retail_store.last_update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStore') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.telephone, debugtype: 'long', dataIndex: 'telephone', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, debugtype: 'string', dataIndex: 'owner', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.retailStoreCountryCenter, dataIndex: 'retailStoreCountryCenter', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.cityServiceCenter, dataIndex: 'cityServiceCenter', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.creation, dataIndex: 'creation', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.investmentInvitation, dataIndex: 'investmentInvitation', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.franchising, dataIndex: 'franchising', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.decoration, dataIndex: 'decoration', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.opening, dataIndex: 'opening', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.closing, dataIndex: 'closing', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.latitude, debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.longitude, debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '25',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(retailStore,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStore.id}>
	
      <DescriptionList  key={retailStore.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{retailStore.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{retailStore.name}</Description> 
        <Description term={fieldLabels.telephone}><div style={{"color":"red"}}>{retailStore.telephone}</div></Description> 
        <Description term={fieldLabels.owner} style={{wordBreak: 'break-all'}}>{retailStore.owner}</Description> 
        <Description term={fieldLabels.cityServiceCenter}><div>{retailStore.cityServiceCenter==null?appLocaleName(userContext,"NotAssigned"):`${retailStore.cityServiceCenter.displayName}(${retailStore.cityServiceCenter.id})`}
        </div></Description>
        <Description term={fieldLabels.founded}><div>{ moment(retailStore.founded).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.latitude}><div style={{"color":"red"}}>{retailStore.latitude}</div></Description> 
        <Description term={fieldLabels.longitude}><div style={{"color":"red"}}>{retailStore.longitude}</div></Description> 
        <Description term={fieldLabels.description} style={{wordBreak: 'break-all'}}>{retailStore.description}</Description> 
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(retailStore.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"双链小超", menuFor: "retailStore",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  name: '名称',
  telephone: '电话',
  owner: '业主',
  retailStoreCountryCenter: '双链小超全国运营中心',
  cityServiceCenter: '城市服务中心',
  creation: '创建',
  investmentInvitation: '招商',
  franchising: '加盟',
  decoration: '装修',
  opening: '开业',
  closing: '关闭',
  founded: '成立',
  latitude: '纬度',
  longitude: '经度',
  description: '描述',
  lastUpdateTime: '最后更新时间',
  currentStatus: '当前状态',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStore') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.telephone, debugtype: 'string', dataIndex: 'telephone', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, debugtype: 'string', dataIndex: 'owner', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.retailStoreCountryCenter, dataIndex: 'retailStoreCountryCenter', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.cityServiceCenter, dataIndex: 'cityServiceCenter', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.creation, dataIndex: 'creation', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.investmentInvitation, dataIndex: 'investmentInvitation', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.franchising, dataIndex: 'franchising', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.decoration, dataIndex: 'decoration', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.opening, dataIndex: 'opening', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.closing, dataIndex: 'closing', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.latitude, debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.longitude, debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '25',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.currentStatus, debugtype: 'string', dataIndex: 'currentStatus', width: '22',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(retailStore,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStore.id}>
	
      <DescriptionList  key={retailStore.id} size="small" col="4">
        <Description term="序号">{retailStore.id}</Description> 
        <Description term="名称">{retailStore.name}</Description> 
        <Description term="电话">{retailStore.telephone}</Description> 
        <Description term="业主">{retailStore.owner}</Description> 
        <Description term="城市服务中心"><div>{retailStore.cityServiceCenter==null?appLocaleName(userContext,"NotAssigned"):`${retailStore.cityServiceCenter.displayName}(${retailStore.cityServiceCenter.id})`}
        </div></Description>
        <Description term="成立"><div>{ moment(retailStore.founded).format('YYYY-MM-DD')}</div></Description> 
        <Description term="纬度"><div style={{"color":"red"}}>{retailStore.latitude}</div></Description> 
        <Description term="经度"><div style={{"color":"red"}}>{retailStore.longitude}</div></Description> 
        <Description term="描述">{retailStore.description}</Description> 
        <Description term="最后更新时间"><div>{ moment(retailStore.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term="当前状态">{retailStore.currentStatus}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, telephone, owner, founded, latitude, longitude, description, retailStoreCountryCenterId, cityServiceCenterId} = formValuesToPack
	const retailStoreCountryCenter = {id: retailStoreCountryCenterId, version: 2^31}
	const cityServiceCenter = {id: cityServiceCenterId, version: 2^31}
	const data = {name, telephone, owner, founded, latitude, longitude, description, retailStoreCountryCenter, cityServiceCenter}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, telephone, owner, founded, latitude, longitude, description, retailStoreCountryCenter, cityServiceCenter} = objectToUnpack
	const retailStoreCountryCenterId = retailStoreCountryCenter ? retailStoreCountryCenter.id : null
	const cityServiceCenterId = cityServiceCenter ? cityServiceCenter.id : null
	const data = {name, telephone, owner, founded, latitude, longitude, description, retailStoreCountryCenterId, cityServiceCenterId}
	return data
}

const RetailStoreBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, telephone, owner, founded, latitude, longitude, description, retailStoreCountryCenterId, cityServiceCenterId, creationId, investmentInvitationId, franchisingId, decorationId, openingId, closingId} = formValuesToPack
	const retailStoreCountryCenter = {id: retailStoreCountryCenterId, version: 2^31}
	const cityServiceCenter = {id: cityServiceCenterId, version: 2^31}
	const creation = {id: creationId, version: 2^31}
	const investmentInvitation = {id: investmentInvitationId, version: 2^31}
	const franchising = {id: franchisingId, version: 2^31}
	const decoration = {id: decorationId, version: 2^31}
	const opening = {id: openingId, version: 2^31}
	const closing = {id: closingId, version: 2^31}
	const data = {name, telephone, owner, founded, latitude, longitude, description, retailStoreCountryCenter, cityServiceCenter, creation, investmentInvitation, franchising, decoration, opening, closing}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, telephone, owner, founded, latitude, longitude, description, retailStoreCountryCenter, cityServiceCenter, creation, investmentInvitation, franchising, decoration, opening, closing} = objectToUnpack
	const retailStoreCountryCenterId = retailStoreCountryCenter ? retailStoreCountryCenter.id : null
	const cityServiceCenterId = cityServiceCenter ? cityServiceCenter.id : null
	const creationId = creation ? creation.id : null
	const investmentInvitationId = investmentInvitation ? investmentInvitation.id : null
	const franchisingId = franchising ? franchising.id : null
	const decorationId = decoration ? decoration.id : null
	const openingId = opening ? opening.id : null
	const closingId = closing ? closing.id : null
	const data = {name, telephone, owner, founded, latitude, longitude, description, retailStoreCountryCenterId, cityServiceCenterId, creationId, investmentInvitationId, franchisingId, decorationId, openingId, closingId}
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
const RetailStoreBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default RetailStoreBase



