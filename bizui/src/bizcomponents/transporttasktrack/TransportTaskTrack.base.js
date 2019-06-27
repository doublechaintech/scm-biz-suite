import React from 'react'
import { Icon } from 'antd'
import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'

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
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.trackTime, dataIndex: 'trackTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.latitude, debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.longitude, debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.movement, dataIndex: 'movement', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=({transportTaskTrack,targetComponent})=>{

	
	
	const {TransportTaskTrackService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{transportTaskTrack.id}</Description> 
<Description term="跟踪时间">{ moment(transportTaskTrack.trackTime).format('YYYY-MM-DD')}</Description> 
<Description term="纬度">{transportTaskTrack.latitude}</Description> 
<Description term="经度">{transportTaskTrack.longitude}</Description> 
<Description term="运动">{transportTaskTrack.movement==null?appLocaleName(userContext,"NotAssigned"):`${transportTaskTrack.movement.displayName}(${transportTaskTrack.movement.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"运动","transportTask",TransportTaskTrackService.requestCandidateMovement,
	      TransportTaskTrackService.transferToAnotherMovement,"anotherMovementId",transportTaskTrack.movement?transportTaskTrack.movement.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
	
        {buildTransferModal(transportTaskTrack,targetComponent)}
      </DescriptionList>
	)

}
	



const TransportTaskTrackBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default TransportTaskTrackBase



