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
import styles from './GoodsMovement.base.less'
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



const menuData = {menuName: window.trans('goods_movement'), menuFor: "goodsMovement",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('goods_movement'), menuFor: "goodsMovement",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('goods_movement.id'),
  moveTime: window.trans('goods_movement.move_time'),
  facility: window.trans('goods_movement.facility'),
  facilityId: window.trans('goods_movement.facility_id'),
  fromIp: window.trans('goods_movement.from_ip'),
  userAgent: window.trans('goods_movement.user_agent'),
  sessionId: window.trans('goods_movement.session_id'),
  latitude: window.trans('goods_movement.latitude'),
  longitude: window.trans('goods_movement.longitude'),
  goods: window.trans('goods_movement.goods'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'goodsMovement') , sorter: true },
  { title: fieldLabels.moveTime, dataIndex: 'moveTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.facility, debugtype: 'string', dataIndex: 'facility', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.facilityId, debugtype: 'string', dataIndex: 'facilityId', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.fromIp, debugtype: 'string', dataIndex: 'fromIp', width: '16',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.userAgent, debugtype: 'string', dataIndex: 'userAgent', width: '115',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.sessionId, debugtype: 'string', dataIndex: 'sessionId', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.latitude, dataIndex: 'latitude', className:'money', render: (text, record) => renderTextCell(text, record), sorter: true  },
  { title: fieldLabels.longitude, dataIndex: 'longitude', className:'money', render: (text, record) => renderTextCell(text, record), sorter: true  },
  { title: fieldLabels.goods, dataIndex: 'goods', render: (text, record) => renderReferenceCell(text, record), sorter:true},

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
const renderItemOfList=(goodsMovement, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={goodsMovement.id} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(goodsMovement.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={goodsMovement.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{goodsMovement.id}</Description> 
        <Description term={fieldLabels.moveTime}><div>{ moment(goodsMovement.moveTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term={fieldLabels.facility} style={{wordBreak: 'break-all'}}>{goodsMovement.facility}</Description> 
        <Description term={fieldLabels.facilityId} style={{wordBreak: 'break-all'}}>{goodsMovement.facilityId}</Description> 
        <Description term={fieldLabels.fromIp} style={{wordBreak: 'break-all'}}>{goodsMovement.fromIp}</Description> 
        <Description term={fieldLabels.sessionId} style={{wordBreak: 'break-all'}}>{goodsMovement.sessionId}</Description> 
        <Description term={fieldLabels.latitude}><div style={{"color":"red"}}>{goodsMovement.latitude}</div></Description> 
        <Description term={fieldLabels.longitude}><div style={{"color":"red"}}>{goodsMovement.longitude}</div></Description> 
        <Description term={fieldLabels.goods}><Tag color='blue' title={`${goodsMovement.goods.id}-${goodsMovement.goods.displayName}`}>{goodsMovement.goods==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(goodsMovement.goods.displayName,15)}`}
        </Tag></Description>
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {moveTime, facility, facilityId, fromIp, sessionId, latitude, longitude, goodsId, userAgent} = formValuesToPack
	const goods = {id: goodsId, version: 2^31}
	const data = {moveTime:moment(moveTime).valueOf(), facility, facilityId, fromIp, sessionId, latitude, longitude, goods, userAgent}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {moveTime, facility, facilityId, fromIp, sessionId, latitude, longitude, goods, userAgent} = objectToUnpack
	const goodsId = goods ? goods.id : null
	const data = {moveTime:moment(moveTime), facility, facilityId, fromIp, sessionId, latitude, longitude, goodsId, userAgent}
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
const GoodsMovementBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default GoodsMovementBase

