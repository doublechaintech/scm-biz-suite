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
import styles from './TransportTaskTrack.base.less'
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
  { title: fieldLabels.latitude, dataIndex: 'latitude', className:'money', render: (text, record) => renderTextCell(text, record), sorter: true  },
  { title: fieldLabels.longitude, dataIndex: 'longitude', className:'money', render: (text, record) => renderTextCell(text, record), sorter: true  },
  { title: fieldLabels.movement, dataIndex: 'movement', render: (text, record) => renderReferenceCell(text, record), sorter:true},

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
const renderItemOfList=(transportTaskTrack, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={transportTaskTrack.id} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(transportTaskTrack.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={transportTaskTrack.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{transportTaskTrack.id}</Description> 
        <Description term={fieldLabels.trackTime}><div>{ moment(transportTaskTrack.trackTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.latitude}><div style={{"color":"red"}}>{transportTaskTrack.latitude}</div></Description> 
        <Description term={fieldLabels.longitude}><div style={{"color":"red"}}>{transportTaskTrack.longitude}</div></Description> 
        <Description term={fieldLabels.movement}><Tag color='blue' title={`${transportTaskTrack.movement.id}-${transportTaskTrack.movement.displayName}`}>{transportTaskTrack.movement==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(transportTaskTrack.movement.displayName,15)}`}
        </Tag></Description>
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {trackTime, latitude, longitude, movementId} = formValuesToPack
	const movement = {id: movementId, version: 2^31}
	const data = {trackTime:moment(trackTime).valueOf(), latitude, longitude, movement}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {trackTime, latitude, longitude, movement} = objectToUnpack
	const movementId = movement ? movement.id : null
	const data = {trackTime:moment(trackTime), latitude, longitude, movementId}
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
const TransportTaskTrackBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default TransportTaskTrackBase

