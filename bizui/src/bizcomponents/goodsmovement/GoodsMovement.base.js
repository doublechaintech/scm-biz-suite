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
const menuData = {menuName:"货物移动", menuFor: "goodsMovement",
=======

const menuData = {menuName: window.trans('goods_movement'), menuFor: "goodsMovement",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD
=======

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
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"货物移动", menuFor: "goodsMovement",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  moveTime: '移动时间',
  facility: '设施',
  facilityId: '设备ID',
  fromIp: '从IP',
  userAgent: '用户代理',
  sessionId: '会话ID',
  latitude: '纬度',
  longitude: '经度',
  goods: '货物',

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
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(goodsMovement,targetComponent)=>{

  const userContext = null
  return (
    <div key={goodsMovement.id}>
	
      <DescriptionList  key={goodsMovement.id} size="small" col="4">
        <Description term="序号">{goodsMovement.id}</Description> 
        <Description term="移动时间"><div>{ moment(goodsMovement.moveTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term="设施">{goodsMovement.facility}</Description> 
        <Description term="设备ID">{goodsMovement.facilityId}</Description> 
        <Description term="从IP">{goodsMovement.fromIp}</Description> 
        <Description term="会话ID">{goodsMovement.sessionId}</Description> 
        <Description term="纬度"><div style={{"color":"red"}}>{goodsMovement.latitude}</div></Description> 
        <Description term="经度"><div style={{"color":"red"}}>{goodsMovement.longitude}</div></Description> 
        <Description term="货物"><div>{goodsMovement.goods==null?appLocaleName(userContext,"NotAssigned"):`${goodsMovement.goods.displayName}(${goodsMovement.goods.id})`}
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
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {moveTime, facility, facilityId, fromIp, sessionId, latitude, longitude, goodsId, userAgent} = formValuesToPack
	const goods = {id: goodsId, version: 2^31}
	const data = {moveTime, facility, facilityId, fromIp, sessionId, latitude, longitude, goods, userAgent}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {moveTime, facility, facilityId, fromIp, sessionId, latitude, longitude, goods, userAgent} = objectToUnpack
	const goodsId = goods ? goods.id : null
	const data = {moveTime, facility, facilityId, fromIp, sessionId, latitude, longitude, goodsId, userAgent}
	return data
}
<<<<<<< HEAD

const GoodsMovementBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const GoodsMovementBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default GoodsMovementBase



