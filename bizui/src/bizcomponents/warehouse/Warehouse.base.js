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
const menuData = {menuName:"仓库", menuFor: "warehouse",
  		subItems: [
  {name: 'storageSpaceList', displayName:'存货区', icon:'backspace',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'smartPalletList', displayName:'智能托盘', icon:'pallet',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'supplierSpaceList', displayName:'供应商的空间', icon:'backspace',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'receivingSpaceList', displayName:'收货区', icon:'backspace',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'shippingSpaceList', displayName:'发货区', icon:'backspace',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'damageSpaceList', displayName:'残次货物存放区', icon:'backspace',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'warehouseAssetList', displayName:'仓库资产', icon:'warehouse',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('warehouse'), menuFor: "warehouse",
  		subItems: [
  {name: 'storageSpaceList', displayName: window.mtrans('storage_space','warehouse.storage_space_list',false), type:'storageSpace',icon:'backspace',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'smartPalletList', displayName: window.mtrans('smart_pallet','warehouse.smart_pallet_list',false), type:'smartPallet',icon:'pallet',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'supplierSpaceList', displayName: window.mtrans('supplier_space','warehouse.supplier_space_list',false), type:'supplierSpace',icon:'backspace',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'receivingSpaceList', displayName: window.mtrans('receiving_space','warehouse.receiving_space_list',false), type:'receivingSpace',icon:'backspace',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'shippingSpaceList', displayName: window.mtrans('shipping_space','warehouse.shipping_space_list',false), type:'shippingSpace',icon:'backspace',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'damageSpaceList', displayName: window.mtrans('damage_space','warehouse.damage_space_list',false), type:'damageSpace',icon:'backspace',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'warehouseAssetList', displayName: window.mtrans('warehouse_asset','warehouse.warehouse_asset_list',false), type:'warehouseAsset',icon:'warehouse',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('warehouse'), menuFor: "warehouse",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('warehouse.id'),
  location: window.trans('warehouse.location'),
  contactNumber: window.trans('warehouse.contact_number'),
  totalArea: window.trans('warehouse.total_area'),
  owner: window.trans('warehouse.owner'),
  latitude: window.trans('warehouse.latitude'),
  longitude: window.trans('warehouse.longitude'),
  lastUpdateTime: window.trans('warehouse.last_update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'warehouse') , sorter: true },
  { title: fieldLabels.location, debugtype: 'string', dataIndex: 'location', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.contactNumber, debugtype: 'long', dataIndex: 'contactNumber', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.totalArea, debugtype: 'string', dataIndex: 'totalArea', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.latitude, debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.longitude, debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(warehouse,targetComponent)=>{

  const userContext = null
  return (
    <div key={warehouse.id}>
	
      <DescriptionList  key={warehouse.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{warehouse.id}</Description> 
        <Description term={fieldLabels.location} style={{wordBreak: 'break-all'}}>{warehouse.location}</Description> 
        <Description term={fieldLabels.contactNumber}><div style={{"color":"red"}}>{warehouse.contactNumber}</div></Description> 
        <Description term={fieldLabels.totalArea} style={{wordBreak: 'break-all'}}>{warehouse.totalArea}</Description> 
        <Description term={fieldLabels.latitude}><div style={{"color":"red"}}>{warehouse.latitude}</div></Description> 
        <Description term={fieldLabels.longitude}><div style={{"color":"red"}}>{warehouse.longitude}</div></Description> 
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(warehouse.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"仓库", menuFor: "warehouse",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  location: '位置',
  contactNumber: '联系电话',
  totalArea: '总面积',
  owner: '业主',
  latitude: '纬度',
  longitude: '经度',
  lastUpdateTime: '最后更新时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'warehouse') , sorter: true },
  { title: fieldLabels.location, debugtype: 'string', dataIndex: 'location', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.contactNumber, debugtype: 'string', dataIndex: 'contactNumber', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.totalArea, debugtype: 'string', dataIndex: 'totalArea', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.latitude, debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.longitude, debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(warehouse,targetComponent)=>{

  const userContext = null
  return (
    <div key={warehouse.id}>
	
      <DescriptionList  key={warehouse.id} size="small" col="4">
        <Description term="序号">{warehouse.id}</Description> 
        <Description term="位置">{warehouse.location}</Description> 
        <Description term="联系电话">{warehouse.contactNumber}</Description> 
        <Description term="总面积">{warehouse.totalArea}</Description> 
        <Description term="纬度"><div style={{"color":"red"}}>{warehouse.latitude}</div></Description> 
        <Description term="经度"><div style={{"color":"red"}}>{warehouse.longitude}</div></Description> 
        <Description term="最后更新时间"><div>{ moment(warehouse.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {location, contactNumber, totalArea, latitude, longitude, ownerId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const data = {location, contactNumber, totalArea, latitude, longitude, owner}
	return data
}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {location, contactNumber, totalArea, latitude, longitude, ownerId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const data = {location, contactNumber, totalArea, latitude, longitude, owner}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {location, contactNumber, totalArea, latitude, longitude, owner} = objectToUnpack
	const ownerId = owner ? owner.id : null
	const data = {location, contactNumber, totalArea, latitude, longitude, ownerId}
	return data
}
<<<<<<< HEAD

const WarehouseBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const WarehouseBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default WarehouseBase



