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
const menuData = {menuName:"运输车队", menuFor: "transportFleet",
  		subItems: [
  {name: 'transportTruckList', displayName:'运输车', icon:'truck',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'truckDriverList', displayName:'卡车司机', icon:'truck',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'transportTaskList', displayName:'运输任务', icon:'tasks',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('transport_fleet'), menuFor: "transportFleet",
  		subItems: [
  {name: 'transportTruckList', displayName: window.mtrans('transport_truck','transport_fleet.transport_truck_list',false), type:'transportTruck',icon:'truck',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'truckDriverList', displayName: window.mtrans('truck_driver','transport_fleet.truck_driver_list',false), type:'truckDriver',icon:'truck',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'transportTaskList', displayName: window.mtrans('transport_task','transport_fleet.transport_task_list',false), type:'transportTask',icon:'tasks',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD

const settingMenuData = {menuName:"运输车队", menuFor: "transportFleet",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  contactNumber: '联系电话',
  owner: '业主',
  lastUpdateTime: '最后更新时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'transportFleet') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.contactNumber, debugtype: 'string', dataIndex: 'contactNumber', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(transportFleet,targetComponent)=>{

  const userContext = null
  return (
    <div key={transportFleet.id}>
	
      <DescriptionList  key={transportFleet.id} size="small" col="4">
        <Description term="序号">{transportFleet.id}</Description> 
        <Description term="名称">{transportFleet.name}</Description> 
        <Description term="联系电话">{transportFleet.contactNumber}</Description> 
        <Description term="最后更新时间"><div>{ moment(transportFleet.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, contactNumber, ownerId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const data = {name, contactNumber, owner}
	return data
}
=======

const settingMenuData = {menuName: window.trans('transport_fleet'), menuFor: "transportFleet",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('transport_fleet.id'),
  name: window.trans('transport_fleet.name'),
  contactNumber: window.trans('transport_fleet.contact_number'),
  owner: window.trans('transport_fleet.owner'),
  lastUpdateTime: window.trans('transport_fleet.last_update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'transportFleet') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.contactNumber, debugtype: 'long', dataIndex: 'contactNumber', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(transportFleet,targetComponent)=>{

  const userContext = null
  return (
    <div key={transportFleet.id}>
	
      <DescriptionList  key={transportFleet.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{transportFleet.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{transportFleet.name}</Description> 
        <Description term={fieldLabels.contactNumber}><div style={{"color":"red"}}>{transportFleet.contactNumber}</div></Description> 
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(transportFleet.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, contactNumber, ownerId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const data = {name, contactNumber, owner}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, contactNumber, owner} = objectToUnpack
	const ownerId = owner ? owner.id : null
	const data = {name, contactNumber, ownerId}
	return data
}
<<<<<<< HEAD

const TransportFleetBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const TransportFleetBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default TransportFleetBase



