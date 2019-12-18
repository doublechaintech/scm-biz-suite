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



const menuData = {menuName: window.trans('transport_task_track'), menuFor: "transportTaskTrack",
  		subItems: [
  
  		],
}


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

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {trackTime, latitude, longitude, movementId} = formValuesToPack
	const movement = {id: movementId, version: 2^31}
	const data = {trackTime, latitude, longitude, movement}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {trackTime, latitude, longitude, movement} = objectToUnpack
	const movementId = movement ? movement.id : null
	const data = {trackTime, latitude, longitude, movementId}
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
const TransportTaskTrackBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default TransportTaskTrackBase



