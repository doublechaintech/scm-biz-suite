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
import styles from './TransportTask.base.less'
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



const menuData = {menuName: window.trans('transport_task'), menuFor: "transportTask",
  		subItems: [
  {name: 'goodsList', displayName: window.mtrans('goods','transport_task.goods_list',false), type:'goods',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'transportTaskTrackList', displayName: window.mtrans('transport_task_track','transport_task.transport_task_track_list',false), type:'transportTaskTrack',icon:'tasks',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('transport_task'), menuFor: "transportTask",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('transport_task.id'),
  name: window.trans('transport_task.name'),
  start: window.trans('transport_task.start'),
  beginTime: window.trans('transport_task.begin_time'),
  end: window.trans('transport_task.end'),
  driver: window.trans('transport_task.driver'),
  truck: window.trans('transport_task.truck'),
  belongsTo: window.trans('transport_task.belongs_to'),
  latitude: window.trans('transport_task.latitude'),
  longitude: window.trans('transport_task.longitude'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'transportTask') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.start, debugtype: 'string', dataIndex: 'start', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.beginTime, dataIndex: 'beginTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.end, dataIndex: 'end', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.driver, dataIndex: 'driver', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.truck, dataIndex: 'truck', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.belongsTo, dataIndex: 'belongsTo', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.latitude, dataIndex: 'latitude', className:'money', render: (text, record) => renderTextCell(text, record), sorter: true  },
  { title: fieldLabels.longitude, dataIndex: 'longitude', className:'money', render: (text, record) => renderTextCell(text, record), sorter: true  },

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
const renderItemOfList=(transportTask, targetComponent, columCount)=>{
  
  if(!transportTask){
  	return null
  }
  if(!transportTask.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`transportTask-${transportTask.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(transportTask.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={transportTask.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{transportTask.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{transportTask.name}</Description> 
        <Description term={fieldLabels.start} style={{wordBreak: 'break-all'}}>{transportTask.start}</Description> 
        <Description term={fieldLabels.beginTime}><div>{ moment(transportTask.beginTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.end}>{renderReferenceItem(transportTask.end)}</Description>

        <Description term={fieldLabels.driver}>{renderReferenceItem(transportTask.driver)}</Description>

        <Description term={fieldLabels.truck}>{renderReferenceItem(transportTask.truck)}</Description>

        <Description term={fieldLabels.belongsTo}>{renderReferenceItem(transportTask.belongsTo)}</Description>

        <Description term={fieldLabels.latitude}><div style={{"color":"red"}}>{transportTask.latitude}</div></Description> 
        <Description term={fieldLabels.longitude}><div style={{"color":"red"}}>{transportTask.longitude}</div></Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, start, beginTime, latitude, longitude, endId, driverId, truckId, belongsToId} = formValuesToPack
	const end = {id: endId, version: 2^31}
	const driver = {id: driverId, version: 2^31}
	const truck = {id: truckId, version: 2^31}
	const belongsTo = {id: belongsToId, version: 2^31}
	const data = {name, start, beginTime:moment(beginTime).valueOf(), latitude, longitude, end, driver, truck, belongsTo}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, start, beginTime, latitude, longitude, end, driver, truck, belongsTo} = objectToUnpack
	const endId = end ? end.id : null
	const driverId = driver ? driver.id : null
	const truckId = truck ? truck.id : null
	const belongsToId = belongsTo ? belongsTo.id : null
	const data = {name, start, beginTime:moment(beginTime), latitude, longitude, endId, driverId, truckId, belongsToId}
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
const TransportTaskBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default TransportTaskBase

