import React from 'react'
import { Icon,Divider, Avatar, Card, Col, Row, Tag, Button,Table} from 'antd'

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
	defaultRenderNumberCell,
	defaultFormatNumber,
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
const renderNumberCell=defaultRenderNumberCell
const formatNumber = defaultFormatNumber

const renderImageListCell=(imageList, record)=>{
	const userContext = null;
	if(!imageList){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(imageList.length === 0){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}

	return (<span>{
		imageList.map(item=>(<img width="40px" key={item.id} title={item.title} src={item.imageUrl}/>))
		}</span>)
}




const menuData = {menuName: window.trans('goods_movement'), menuFor: "goodsMovement",  internalName: "goods_movement",
  		subItems: [

  		],
}


const settingMenuData = {menuName: window.trans('goods_movement'), menuFor: "goodsMovement",  internalName: "goods_movement",
  		subItems: [

  		],
}


const mergedSubItems=()=>{

    const result = []
    menuData.subItems.forEach(item=>{
        result.push({...item, for: "menu"})
    })
    settingMenuData.subItems.forEach(item=>{
        result.push({...item, for: "setting"})
    })
    return result
}
const universalMenuData = {...menuData, subItems: mergedSubItems()}



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
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '6', render: (text, record)=>renderTextCell(text,record,'goodsMovement') , sorter: true },
  { title: fieldLabels.moveTime, dataIndex: 'moveTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.facility, debugtype: 'string', dataIndex: 'facility', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.facilityId, debugtype: 'string', dataIndex: 'facilityId', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.fromIp, debugtype: 'string', dataIndex: 'fromIp', width: '16',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.userAgent, debugtype: 'string', dataIndex: 'userAgent', width: '115',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.sessionId, debugtype: 'string', dataIndex: 'sessionId', width: '35',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.latitude, dataIndex: 'latitude', className:'money', render: (text, record) => renderNumberCell(text, record, 6), sorter: true  },
  { title: fieldLabels.longitude, dataIndex: 'longitude', className:'money', render: (text, record) => renderNumberCell(text, record, 6), sorter: true  },
  { title: fieldLabels.goods, dataIndex: 'goods', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(universalMenuData,targetObject,searchTerm)
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

const renderTextItem=(value, label, targetComponent)=>{
	const userContext = null
	if(!value){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.id){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.displayName){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}

	return <Tag color='blue' title={`${value.displayName}(${value.id})`}>{leftChars(value.displayName)}</Tag>
}
const renderImageItem=(value,label, targetComponent)=>{
	const userContext = null
	if(!value){
		return appLocaleName(userContext,"NotAssigned")
	}

	return <ImagePreview title={label} imageLocation={value}/>
}

const renderDateItem=(value, label,targetComponent)=>{
	const userContext = null
	if(!value){
		return appLocaleName(userContext,"NotAssigned")
	}
	return moment(value).format('YYYY-MM-DD');
}

const renderDateTimeItem=(value,label, targetComponent)=>{
	const userContext = window.userContext
	if(!value){
		return appLocaleName(userContext,"NotAssigned")
	}
	return  moment(value).format('YYYY-MM-DD HH:mm')
}


const renderReferenceItem=(value,label, targetComponent)=>{
	const userContext = null
	if(!value){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.id){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.displayName){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}

	return <Tag color='blue' title={`${value.displayName}(${value.id})`}>{leftChars(value.displayName)}</Tag>
}


const renderImageList=(imageList,label, targetComponent)=>{
	const userContext = null
	if(!imageList){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(imageList.length === 0){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	// return JSON.stringify(imageList)
/*
	the data looks like this
	{"id":"1601","title":"cover_images01",
	"imageUrl":"https://demo.doublechaintech.com/demodata/imageManager/genImage/cover_images010016/400/200/grey/"},
	{"id":"1602","title":"cover_images02",
	"imageUrl":"https://demo.doublechaintech.com/demodata/imageManager/genImage/cover_images020016/400/200/grey/"}
*/
	return (<span>{
		imageList.map(item=>(<img width="40px" key={item.id} title={item.title} src={item.imageUrl}/>))
		}</span>)

}


const renderActionList=(goodsMovement, targetObject, columCount, listName)=>{

	if(!goodsMovement){
		return null
	}
	if(!goodsMovement.actionList){
		return null
	}
	if(goodsMovement.actionList.length === 0){
		return null
	}
	return (
		<div className={styles.overlay}>

			<div className={styles.overlayContent}>
			{goodsMovement.actionList.map(action=>(<Link key={action.id} to={{pathname: action.actionPath.substring(1), state: {ownerId:targetObject.id,action,selectedRows:[goodsMovement]}}} >
				<span className={styles.overlayText}>{action.actionName}</span>
				</Link> ))}
			</div>

		</div>
		)

}

const renderItemOfList=(goodsMovement, targetObject, columCount, listName)=>{

  if(!goodsMovement){
  	return null
  }
  if(!goodsMovement.id){
  	return null
  }


  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
     <Row key={`${listName}-${goodsMovement.id}`} className={styles.itemDesc}>

	<Col span={4}>
		<Avatar size={90} className={styles.avarta} style={{ backgroundColor: genColor()}}>
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
        <Description term={fieldLabels.latitude}><div style={{"color":"red"}}>{formatNumber(goodsMovement.latitude,6)}</div></Description> 
        <Description term={fieldLabels.longitude}><div style={{"color":"red"}}>{formatNumber(goodsMovement.longitude,6)}</div></Description> 
        <Description term={fieldLabels.goods}>{renderReferenceItem(goodsMovement.goods)}</Description>



      </DescriptionList>
     </Col>
      {renderActionList(goodsMovement,targetObject)}
    </Row>
	)

}

const packFormValuesToObject = ( formValuesToPack )=>{
	const {moveTime, facility, facilityId, fromIp, userAgent, sessionId, latitude, longitude, goodsId} = formValuesToPack
	const goods = {id: goodsId, version: 2^31}
	const data = {moveTime:moment(moveTime).valueOf(), facility, facilityId, fromIp, userAgent, sessionId, latitude, longitude, goods}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {moveTime, facility, facilityId, fromIp, userAgent, sessionId, latitude, longitude, goods} = objectToUnpack
	const goodsId = goods ? goods.id : null
	const data = {moveTime:moment(moveTime), facility, facilityId, fromIp, userAgent, sessionId, latitude, longitude, goodsId}
	return data
}


const stepOf=(targetComponent, title, content, position, index, initValue)=>{
	const isMultipleEvent=false
	return {
		title,
		content,
		position,
		packFunction: packFormValuesToObject,
		unpackFunction: unpackObjectToFormValues,
		index,
		initValue,
		isMultipleEvent,
      }
}



const GoodsMovementBase={unpackObjectToFormValues, menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default GoodsMovementBase

