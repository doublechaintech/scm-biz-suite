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
  { title: fieldLabels.latitude, debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.longitude, debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.goods, dataIndex: 'goods', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(goodsMovement,targetComponent)=>{

  const userContext = null
  return (
    <div key={goodsMovement.id}>
	
      <DescriptionList  key={goodsMovement.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{goodsMovement.id}</Description> 
        <Description term={fieldLabels.moveTime}><div>{ moment(goodsMovement.moveTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term={fieldLabels.facility} style={{wordBreak: 'break-all'}}>{goodsMovement.facility}</Description> 
        <Description term={fieldLabels.facilityId} style={{wordBreak: 'break-all'}}>{goodsMovement.facilityId}</Description> 
        <Description term={fieldLabels.fromIp} style={{wordBreak: 'break-all'}}>{goodsMovement.fromIp}</Description> 
        <Description term={fieldLabels.sessionId} style={{wordBreak: 'break-all'}}>{goodsMovement.sessionId}</Description> 
        <Description term={fieldLabels.latitude}><div style={{"color":"red"}}>{goodsMovement.latitude}</div></Description> 
        <Description term={fieldLabels.longitude}><div style={{"color":"red"}}>{goodsMovement.longitude}</div></Description> 
        <Description term={fieldLabels.goods}><div>{goodsMovement.goods==null?appLocaleName(userContext,"NotAssigned"):`${goodsMovement.goods.displayName}(${goodsMovement.goods.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {moveTime, facility, facilityId, fromIp, sessionId, latitude, longitude, goodsId, userAgent} = formValuesToPack
	const goods = {id: goodsId, version: 2^31}
	const data = {moveTime, facility, facilityId, fromIp, sessionId, latitude, longitude, goods, userAgent}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {moveTime, facility, facilityId, fromIp, sessionId, latitude, longitude, goods, userAgent} = objectToUnpack
	const goodsId = goods ? goods.id : null
	const data = {moveTime, facility, facilityId, fromIp, sessionId, latitude, longitude, goodsId, userAgent}
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
const GoodsMovementBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default GoodsMovementBase



