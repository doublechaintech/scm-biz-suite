import React from 'react'
import { Icon,Divider } from 'antd'

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
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


const menuData = {menuName:"运输任务跟踪", menuFor: "transportTaskTrack",
  		subItems: [
  
  		],
}

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
	



const TransportTaskTrackBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default TransportTaskTrackBase



