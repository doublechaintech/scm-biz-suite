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
const menuData = {menuName:"收货区", menuFor: "receivingSpace",
  		subItems: [
  {name: 'goodsList', displayName:'货物', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('receiving_space'), menuFor: "receivingSpace",
  		subItems: [
  {name: 'goodsList', displayName: window.mtrans('goods','receiving_space.goods_list',false), type:'goods',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('receiving_space'), menuFor: "receivingSpace",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('receiving_space.id'),
  location: window.trans('receiving_space.location'),
  contactNumber: window.trans('receiving_space.contact_number'),
  description: window.trans('receiving_space.description'),
  totalArea: window.trans('receiving_space.total_area'),
  warehouse: window.trans('receiving_space.warehouse'),
  latitude: window.trans('receiving_space.latitude'),
  longitude: window.trans('receiving_space.longitude'),
  lastUpdateTime: window.trans('receiving_space.last_update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'receivingSpace') , sorter: true },
  { title: fieldLabels.location, debugtype: 'string', dataIndex: 'location', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.contactNumber, debugtype: 'long', dataIndex: 'contactNumber', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '17',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.totalArea, debugtype: 'string', dataIndex: 'totalArea', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.warehouse, dataIndex: 'warehouse', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.latitude, debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.longitude, debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(receivingSpace,targetComponent)=>{

  const userContext = null
  return (
    <div key={receivingSpace.id}>
	
      <DescriptionList  key={receivingSpace.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{receivingSpace.id}</Description> 
        <Description term={fieldLabels.location} style={{wordBreak: 'break-all'}}>{receivingSpace.location}</Description> 
        <Description term={fieldLabels.contactNumber}><div style={{"color":"red"}}>{receivingSpace.contactNumber}</div></Description> 
        <Description term={fieldLabels.description} style={{wordBreak: 'break-all'}}>{receivingSpace.description}</Description> 
        <Description term={fieldLabels.totalArea} style={{wordBreak: 'break-all'}}>{receivingSpace.totalArea}</Description> 
        <Description term={fieldLabels.warehouse}><div>{receivingSpace.warehouse==null?appLocaleName(userContext,"NotAssigned"):`${receivingSpace.warehouse.displayName}(${receivingSpace.warehouse.id})`}
        </div></Description>
        <Description term={fieldLabels.latitude}><div style={{"color":"red"}}>{receivingSpace.latitude}</div></Description> 
        <Description term={fieldLabels.longitude}><div style={{"color":"red"}}>{receivingSpace.longitude}</div></Description> 
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(receivingSpace.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"收货区", menuFor: "receivingSpace",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  location: '位置',
  contactNumber: '联系电话',
  description: '描述',
  totalArea: '总面积',
  warehouse: '仓库',
  latitude: '纬度',
  longitude: '经度',
  lastUpdateTime: '最后更新时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'receivingSpace') , sorter: true },
  { title: fieldLabels.location, debugtype: 'string', dataIndex: 'location', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.contactNumber, debugtype: 'string', dataIndex: 'contactNumber', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '17',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.totalArea, debugtype: 'string', dataIndex: 'totalArea', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.warehouse, dataIndex: 'warehouse', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.latitude, debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.longitude, debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(receivingSpace,targetComponent)=>{

  const userContext = null
  return (
    <div key={receivingSpace.id}>
	
      <DescriptionList  key={receivingSpace.id} size="small" col="4">
        <Description term="序号">{receivingSpace.id}</Description> 
        <Description term="位置">{receivingSpace.location}</Description> 
        <Description term="联系电话">{receivingSpace.contactNumber}</Description> 
        <Description term="描述">{receivingSpace.description}</Description> 
        <Description term="总面积">{receivingSpace.totalArea}</Description> 
        <Description term="仓库"><div>{receivingSpace.warehouse==null?appLocaleName(userContext,"NotAssigned"):`${receivingSpace.warehouse.displayName}(${receivingSpace.warehouse.id})`}
        </div></Description>
        <Description term="纬度"><div style={{"color":"red"}}>{receivingSpace.latitude}</div></Description> 
        <Description term="经度"><div style={{"color":"red"}}>{receivingSpace.longitude}</div></Description> 
        <Description term="最后更新时间"><div>{ moment(receivingSpace.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {location, contactNumber, description, totalArea, latitude, longitude, warehouseId} = formValuesToPack
	const warehouse = {id: warehouseId, version: 2^31}
	const data = {location, contactNumber, description, totalArea, latitude, longitude, warehouse}
	return data
}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {location, contactNumber, description, totalArea, latitude, longitude, warehouseId} = formValuesToPack
	const warehouse = {id: warehouseId, version: 2^31}
	const data = {location, contactNumber, description, totalArea, latitude, longitude, warehouse}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {location, contactNumber, description, totalArea, latitude, longitude, warehouse} = objectToUnpack
	const warehouseId = warehouse ? warehouse.id : null
	const data = {location, contactNumber, description, totalArea, latitude, longitude, warehouseId}
	return data
}
<<<<<<< HEAD

const ReceivingSpaceBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const ReceivingSpaceBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default ReceivingSpaceBase



