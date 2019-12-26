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
const menuData = {menuName:"运输车", menuFor: "transportTruck",
  		subItems: [
  {name: 'transportTaskList', displayName:'运输任务', icon:'tasks',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('transport_truck'), menuFor: "transportTruck",
  		subItems: [
  {name: 'transportTaskList', displayName: window.mtrans('transport_task','transport_truck.transport_task_list',false), type:'transportTask',icon:'tasks',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('transport_truck'), menuFor: "transportTruck",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('transport_truck.id'),
  name: window.trans('transport_truck.name'),
  plateNumber: window.trans('transport_truck.plate_number'),
  contactNumber: window.trans('transport_truck.contact_number'),
  vehicleLicenseNumber: window.trans('transport_truck.vehicle_license_number'),
  engineNumber: window.trans('transport_truck.engine_number'),
  makeDate: window.trans('transport_truck.make_date'),
  mileage: window.trans('transport_truck.mileage'),
  bodyColor: window.trans('transport_truck.body_color'),
  owner: window.trans('transport_truck.owner'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'transportTruck') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.plateNumber, debugtype: 'string', dataIndex: 'plateNumber', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.contactNumber, debugtype: 'long', dataIndex: 'contactNumber', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.vehicleLicenseNumber, debugtype: 'string', dataIndex: 'vehicleLicenseNumber', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.engineNumber, debugtype: 'string', dataIndex: 'engineNumber', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.makeDate, dataIndex: 'makeDate', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.mileage, debugtype: 'string', dataIndex: 'mileage', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.bodyColor, debugtype: 'string', dataIndex: 'bodyColor', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(transportTruck,targetComponent)=>{

  const userContext = null
  return (
    <div key={transportTruck.id}>
	
      <DescriptionList  key={transportTruck.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{transportTruck.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{transportTruck.name}</Description> 
        <Description term={fieldLabels.plateNumber} style={{wordBreak: 'break-all'}}>{transportTruck.plateNumber}</Description> 
        <Description term={fieldLabels.contactNumber}><div style={{"color":"red"}}>{transportTruck.contactNumber}</div></Description> 
        <Description term={fieldLabels.vehicleLicenseNumber} style={{wordBreak: 'break-all'}}>{transportTruck.vehicleLicenseNumber}</Description> 
        <Description term={fieldLabels.engineNumber} style={{wordBreak: 'break-all'}}>{transportTruck.engineNumber}</Description> 
        <Description term={fieldLabels.makeDate}><div>{ moment(transportTruck.makeDate).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.mileage} style={{wordBreak: 'break-all'}}>{transportTruck.mileage}</Description> 
        <Description term={fieldLabels.bodyColor} style={{wordBreak: 'break-all'}}>{transportTruck.bodyColor}</Description> 
        <Description term={fieldLabels.owner}><div>{transportTruck.owner==null?appLocaleName(userContext,"NotAssigned"):`${transportTruck.owner.displayName}(${transportTruck.owner.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"运输车", menuFor: "transportTruck",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  name: '名称',
  plateNumber: '车牌号码',
  contactNumber: '联系电话',
  vehicleLicenseNumber: '汽车牌照号码',
  engineNumber: '发动机号',
  makeDate: '制造日期',
  mileage: '里程',
  bodyColor: '车身颜色',
  owner: '业主',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'transportTruck') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.plateNumber, debugtype: 'string', dataIndex: 'plateNumber', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.contactNumber, debugtype: 'string', dataIndex: 'contactNumber', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.vehicleLicenseNumber, debugtype: 'string', dataIndex: 'vehicleLicenseNumber', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.engineNumber, debugtype: 'string', dataIndex: 'engineNumber', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.makeDate, dataIndex: 'makeDate', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.mileage, debugtype: 'string', dataIndex: 'mileage', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.bodyColor, debugtype: 'string', dataIndex: 'bodyColor', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(transportTruck,targetComponent)=>{

  const userContext = null
  return (
    <div key={transportTruck.id}>
	
      <DescriptionList  key={transportTruck.id} size="small" col="4">
        <Description term="序号">{transportTruck.id}</Description> 
        <Description term="名称">{transportTruck.name}</Description> 
        <Description term="车牌号码">{transportTruck.plateNumber}</Description> 
        <Description term="联系电话">{transportTruck.contactNumber}</Description> 
        <Description term="汽车牌照号码">{transportTruck.vehicleLicenseNumber}</Description> 
        <Description term="发动机号">{transportTruck.engineNumber}</Description> 
        <Description term="制造日期"><div>{ moment(transportTruck.makeDate).format('YYYY-MM-DD')}</div></Description> 
        <Description term="里程">{transportTruck.mileage}</Description> 
        <Description term="车身颜色">{transportTruck.bodyColor}</Description> 
        <Description term="业主"><div>{transportTruck.owner==null?appLocaleName(userContext,"NotAssigned"):`${transportTruck.owner.displayName}(${transportTruck.owner.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, plateNumber, contactNumber, vehicleLicenseNumber, engineNumber, makeDate, mileage, bodyColor, ownerId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const data = {name, plateNumber, contactNumber, vehicleLicenseNumber, engineNumber, makeDate, mileage, bodyColor, owner}
	return data
}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, plateNumber, contactNumber, vehicleLicenseNumber, engineNumber, makeDate, mileage, bodyColor, ownerId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const data = {name, plateNumber, contactNumber, vehicleLicenseNumber, engineNumber, makeDate, mileage, bodyColor, owner}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, plateNumber, contactNumber, vehicleLicenseNumber, engineNumber, makeDate, mileage, bodyColor, owner} = objectToUnpack
	const ownerId = owner ? owner.id : null
	const data = {name, plateNumber, contactNumber, vehicleLicenseNumber, engineNumber, makeDate, mileage, bodyColor, ownerId}
	return data
}
<<<<<<< HEAD

const TransportTruckBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const TransportTruckBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default TransportTruckBase



