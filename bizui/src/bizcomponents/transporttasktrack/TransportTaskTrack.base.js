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


const menuData = {menuName:"Transport Task Track", menuFor: "transportTaskTrack",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'Id',
  trackTime: 'Track Time',
  latitude: 'Latitude',
  longitude: 'Longitude',
  movement: 'Movement',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
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
<Description term="Id">{transportTaskTrack.id}</Description> 
<Description term="Track Time">{ moment(transportTaskTrack.trackTime).format('YYYY-MM-DD')}</Description> 
<Description term="Latitude">{transportTaskTrack.latitude}</Description> 
<Description term="Longitude">{transportTaskTrack.longitude}</Description> 
<Description term="Movement">{transportTaskTrack.movement==null?appLocaleName(userContext,"NotAssigned"):`${transportTaskTrack.movement.displayName}(${transportTaskTrack.movement.id})`}
</Description>
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const TransportTaskTrackBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default TransportTaskTrackBase



