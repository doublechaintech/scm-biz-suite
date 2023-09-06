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
import styles from './ReceivingSpace.base.less'
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




const menuData = {menuName: window.trans('receiving_space'), menuFor: "receivingSpace",  internalName: "receiving_space",
  		subItems: [
  {name: 'goodsList', displayName: window.mtrans('goods','receiving_space.goods_list',false), type:'goods',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},

  		],
}


const settingMenuData = {menuName: window.trans('receiving_space'), menuFor: "receivingSpace",  internalName: "receiving_space",
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
  id: window.trans('receiving_space.id'),
  location: window.trans('receiving_space.location'),
  contactNumber: window.trans('receiving_space.contact_number'),
  description: window.trans('receiving_space.description'),
  totalArea: window.trans('receiving_space.total_area'),
  warehouse: window.trans('receiving_space.warehouse'),
  latitude: window.trans('receiving_space.latitude'),
  longitude: window.trans('receiving_space.longitude'),
  lastUpdateTime: window.trans('receiving_space.last_update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '6', render: (text, record)=>renderTextCell(text,record,'receivingSpace') , sorter: true },
  { title: fieldLabels.location, debugtype: 'string', dataIndex: 'location', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.contactNumber, debugtype: 'string', dataIndex: 'contactNumber', width: '16',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '17',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.totalArea, debugtype: 'string', dataIndex: 'totalArea', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.warehouse, dataIndex: 'warehouse', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.latitude, dataIndex: 'latitude', className:'money', render: (text, record) => renderNumberCell(text, record, 6), sorter: true  },
  { title: fieldLabels.longitude, dataIndex: 'longitude', className:'money', render: (text, record) => renderNumberCell(text, record, 6), sorter: true  },
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

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


const renderActionList=(receivingSpace, targetObject, columCount, listName)=>{

	if(!receivingSpace){
		return null
	}
	if(!receivingSpace.actionList){
		return null
	}
	if(receivingSpace.actionList.length === 0){
		return null
	}
	return (
		<div className={styles.overlay}>

			<div className={styles.overlayContent}>
			{receivingSpace.actionList.map(action=>(<Link key={action.id} to={{pathname: action.actionPath.substring(1), state: {ownerId:targetObject.id,action,selectedRows:[receivingSpace]}}} >
				<span className={styles.overlayText}>{action.actionName}</span>
				</Link> ))}
			</div>

		</div>
		)

}

const renderItemOfList=(receivingSpace, targetObject, columCount, listName)=>{

  if(!receivingSpace){
  	return null
  }
  if(!receivingSpace.id){
  	return null
  }


  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
     <Row key={`${listName}-${receivingSpace.id}`} className={styles.itemDesc}>

	<Col span={4}>
		<Avatar size={90} className={styles.avarta} style={{ backgroundColor: genColor()}}>
			{leftChars(receivingSpace.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  



      <DescriptionList  key={receivingSpace.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{receivingSpace.id}</Description> 
        <Description term={fieldLabels.location} style={{wordBreak: 'break-all'}}>{receivingSpace.location}</Description> 
        <Description term={fieldLabels.contactNumber} style={{wordBreak: 'break-all'}}>{receivingSpace.contactNumber}</Description> 
        <Description term={fieldLabels.description} style={{wordBreak: 'break-all'}}>{receivingSpace.description}</Description> 
        <Description term={fieldLabels.totalArea} style={{wordBreak: 'break-all'}}>{receivingSpace.totalArea}</Description> 
        <Description term={fieldLabels.warehouse}>{renderReferenceItem(receivingSpace.warehouse)}</Description>

        <Description term={fieldLabels.latitude}><div style={{"color":"red"}}>{formatNumber(receivingSpace.latitude,6)}</div></Description> 
        <Description term={fieldLabels.longitude}><div style={{"color":"red"}}>{formatNumber(receivingSpace.longitude,6)}</div></Description> 
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(receivingSpace.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 


      </DescriptionList>
     </Col>
      {renderActionList(receivingSpace,targetObject)}
    </Row>
	)

}

const packFormValuesToObject = ( formValuesToPack )=>{
	const {location, contactNumber, description, totalArea, warehouseId, latitude, longitude, lastUpdateTime} = formValuesToPack
	const warehouse = {id: warehouseId, version: 2^31}
	const data = {location, contactNumber, description, totalArea, warehouse, latitude, longitude, lastUpdateTime:moment(lastUpdateTime).valueOf()}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {location, contactNumber, description, totalArea, warehouse, latitude, longitude, lastUpdateTime} = objectToUnpack
	const warehouseId = warehouse ? warehouse.id : null
	const data = {location, contactNumber, description, totalArea, warehouseId, latitude, longitude, lastUpdateTime:moment(lastUpdateTime)}
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



const ReceivingSpaceBase={unpackObjectToFormValues, menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default ReceivingSpaceBase

