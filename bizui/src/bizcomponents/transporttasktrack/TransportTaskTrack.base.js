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
const menuData = {menuName:"运输任务跟踪", menuFor: "transportTaskTrack",
=======

const menuData = {menuName: window.trans('transport_task_track'), menuFor: "transportTaskTrack",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('transport_task_track'), menuFor: "transportTaskTrack",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('transport_task_track.id'),
  trackTime: window.trans('transport_task_track.track_time'),
  latitude: window.trans('transport_task_track.latitude'),
  longitude: window.trans('transport_task_track.longitude'),
  movement: window.trans('transport_task_track.movement'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'transportTaskTrack') , sorter: true },
  { title: fieldLabels.trackTime, dataIndex: 'trackTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.latitude, debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.longitude, debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.movement, dataIndex: 'movement', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(transportTaskTrack,targetComponent)=>{

  const userContext = null
  return (
    <div key={transportTaskTrack.id}>
	
      <DescriptionList  key={transportTaskTrack.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{transportTaskTrack.id}</Description> 
        <Description term={fieldLabels.trackTime}><div>{ moment(transportTaskTrack.trackTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.latitude}><div style={{"color":"red"}}>{transportTaskTrack.latitude}</div></Description> 
        <Description term={fieldLabels.longitude}><div style={{"color":"red"}}>{transportTaskTrack.longitude}</div></Description> 
        <Description term={fieldLabels.movement}><div>{transportTaskTrack.movement==null?appLocaleName(userContext,"NotAssigned"):`${transportTaskTrack.movement.displayName}(${transportTaskTrack.movement.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"运输任务跟踪", menuFor: "transportTaskTrack",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  trackTime: '跟踪时间',
  latitude: '纬度',
  longitude: '经度',
  movement: '运动',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'transportTaskTrack') , sorter: true },
  { title: fieldLabels.trackTime, dataIndex: 'trackTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.latitude, debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.longitude, debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.movement, dataIndex: 'movement', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(transportTaskTrack,targetComponent)=>{

  const userContext = null
  return (
    <div key={transportTaskTrack.id}>
	
      <DescriptionList  key={transportTaskTrack.id} size="small" col="4">
        <Description term="序号">{transportTaskTrack.id}</Description> 
        <Description term="跟踪时间"><div>{ moment(transportTaskTrack.trackTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term="纬度"><div style={{"color":"red"}}>{transportTaskTrack.latitude}</div></Description> 
        <Description term="经度"><div style={{"color":"red"}}>{transportTaskTrack.longitude}</div></Description> 
        <Description term="运动"><div>{transportTaskTrack.movement==null?appLocaleName(userContext,"NotAssigned"):`${transportTaskTrack.movement.displayName}(${transportTaskTrack.movement.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {trackTime, latitude, longitude, movementId} = formValuesToPack
	const movement = {id: movementId, version: 2^31}
	const data = {trackTime, latitude, longitude, movement}
	return data
}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {trackTime, latitude, longitude, movementId} = formValuesToPack
	const movement = {id: movementId, version: 2^31}
	const data = {trackTime, latitude, longitude, movement}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {trackTime, latitude, longitude, movement} = objectToUnpack
	const movementId = movement ? movement.id : null
	const data = {trackTime, latitude, longitude, movementId}
	return data
}
<<<<<<< HEAD

const TransportTaskTrackBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const TransportTaskTrackBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default TransportTaskTrackBase



