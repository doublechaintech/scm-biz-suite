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
import styles from './TransportTruck.base.less'
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



const menuData = {menuName: window.trans('transport_truck'), menuFor: "transportTruck",
  		subItems: [
  {name: 'transportTaskList', displayName: window.mtrans('transport_task','transport_truck.transport_task_list',false), type:'transportTask',icon:'tasks',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


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
  { title: fieldLabels.contactNumber, debugtype: 'string', dataIndex: 'contactNumber', width: '16',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.vehicleLicenseNumber, debugtype: 'string', dataIndex: 'vehicleLicenseNumber', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.engineNumber, debugtype: 'string', dataIndex: 'engineNumber', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.makeDate, dataIndex: 'makeDate', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.mileage, debugtype: 'string', dataIndex: 'mileage', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.bodyColor, debugtype: 'string', dataIndex: 'bodyColor', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)
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

const renderReferenceItem=(value, targetComponent)=>{
	const userContext = null
	if(!value){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.id){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.displayName){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	
	return <Tag color='blue' title={`${value.displayName}()`}>{leftChars(value.displayName)}</Tag>
	
	
	
	
}
const renderItemOfList=(transportTruck, targetComponent, columCount)=>{
  
  if(!transportTruck){
  	return null
  }
  if(!transportTruck.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`transportTruck-${transportTruck.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(transportTruck.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={transportTruck.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{transportTruck.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{transportTruck.name}</Description> 
        <Description term={fieldLabels.plateNumber} style={{wordBreak: 'break-all'}}>{transportTruck.plateNumber}</Description> 
        <Description term={fieldLabels.contactNumber} style={{wordBreak: 'break-all'}}>{transportTruck.contactNumber}</Description> 
        <Description term={fieldLabels.vehicleLicenseNumber} style={{wordBreak: 'break-all'}}>{transportTruck.vehicleLicenseNumber}</Description> 
        <Description term={fieldLabels.engineNumber} style={{wordBreak: 'break-all'}}>{transportTruck.engineNumber}</Description> 
        <Description term={fieldLabels.makeDate}><div>{ moment(transportTruck.makeDate).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.mileage} style={{wordBreak: 'break-all'}}>{transportTruck.mileage}</Description> 
        <Description term={fieldLabels.bodyColor} style={{wordBreak: 'break-all'}}>{transportTruck.bodyColor}</Description> 
        <Description term={fieldLabels.owner}>{renderReferenceItem(transportTruck.owner)}</Description>

	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, plateNumber, contactNumber, vehicleLicenseNumber, engineNumber, makeDate, mileage, bodyColor, ownerId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const data = {name, plateNumber, contactNumber, vehicleLicenseNumber, engineNumber, makeDate:moment(makeDate).valueOf(), mileage, bodyColor, owner}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, plateNumber, contactNumber, vehicleLicenseNumber, engineNumber, makeDate, mileage, bodyColor, owner} = objectToUnpack
	const ownerId = owner ? owner.id : null
	const data = {name, plateNumber, contactNumber, vehicleLicenseNumber, engineNumber, makeDate:moment(makeDate), mileage, bodyColor, ownerId}
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
const TransportTruckBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default TransportTruckBase

