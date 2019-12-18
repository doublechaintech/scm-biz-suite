import React from 'react'
import { Icon,Divider, Avata, Card, Col} from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList

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
  { title: fieldLabels.latitude, debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.longitude, debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(transportTask,targetComponent)=>{

  const userContext = null
  return (
    <div key={transportTask.id}>
	
      <DescriptionList  key={transportTask.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{transportTask.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{transportTask.name}</Description> 
        <Description term={fieldLabels.start} style={{wordBreak: 'break-all'}}>{transportTask.start}</Description> 
        <Description term={fieldLabels.beginTime}><div>{ moment(transportTask.beginTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.end}><div>{transportTask.end==null?appLocaleName(userContext,"NotAssigned"):`${transportTask.end.displayName}(${transportTask.end.id})`}
        </div></Description>
        <Description term={fieldLabels.driver}><div>{transportTask.driver==null?appLocaleName(userContext,"NotAssigned"):`${transportTask.driver.displayName}(${transportTask.driver.id})`}
        </div></Description>
        <Description term={fieldLabels.truck}><div>{transportTask.truck==null?appLocaleName(userContext,"NotAssigned"):`${transportTask.truck.displayName}(${transportTask.truck.id})`}
        </div></Description>
        <Description term={fieldLabels.belongsTo}><div>{transportTask.belongsTo==null?appLocaleName(userContext,"NotAssigned"):`${transportTask.belongsTo.displayName}(${transportTask.belongsTo.id})`}
        </div></Description>
        <Description term={fieldLabels.latitude}><div style={{"color":"red"}}>{transportTask.latitude}</div></Description> 
        <Description term={fieldLabels.longitude}><div style={{"color":"red"}}>{transportTask.longitude}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, start, beginTime, latitude, longitude, endId, driverId, truckId, belongsToId} = formValuesToPack
	const end = {id: endId, version: 2^31}
	const driver = {id: driverId, version: 2^31}
	const truck = {id: truckId, version: 2^31}
	const belongsTo = {id: belongsToId, version: 2^31}
	const data = {name, start, beginTime, latitude, longitude, end, driver, truck, belongsTo}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, start, beginTime, latitude, longitude, end, driver, truck, belongsTo} = objectToUnpack
	const endId = end ? end.id : null
	const driverId = driver ? driver.id : null
	const truckId = truck ? truck.id : null
	const belongsToId = belongsTo ? belongsTo.id : null
	const data = {name, start, beginTime, latitude, longitude, endId, driverId, truckId, belongsToId}
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
const TransportTaskBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default TransportTaskBase



