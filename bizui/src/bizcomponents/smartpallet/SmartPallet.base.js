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
import styles from './SmartPallet.base.less'
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



const menuData = {menuName: window.trans('smart_pallet'), menuFor: "smartPallet",
  		subItems: [
  {name: 'goodsList', displayName: window.mtrans('goods','smart_pallet.goods_list',false), type:'goods',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('smart_pallet'), menuFor: "smartPallet",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('smart_pallet.id'),
  location: window.trans('smart_pallet.location'),
  contactNumber: window.trans('smart_pallet.contact_number'),
  totalArea: window.trans('smart_pallet.total_area'),
  latitude: window.trans('smart_pallet.latitude'),
  longitude: window.trans('smart_pallet.longitude'),
  warehouse: window.trans('smart_pallet.warehouse'),
  lastUpdateTime: window.trans('smart_pallet.last_update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'smartPallet') , sorter: true },
  { title: fieldLabels.location, debugtype: 'string', dataIndex: 'location', width: '30',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.contactNumber, debugtype: 'string', dataIndex: 'contactNumber', width: '16',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.totalArea, debugtype: 'string', dataIndex: 'totalArea', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.latitude, dataIndex: 'latitude', className:'money', render: (text, record) => renderTextCell(text, record), sorter: true  },
  { title: fieldLabels.longitude, dataIndex: 'longitude', className:'money', render: (text, record) => renderTextCell(text, record), sorter: true  },
  { title: fieldLabels.warehouse, dataIndex: 'warehouse', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

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

const renderReferenceItem=(value, targetComponent)=>{
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
	
	return <Tag color='blue' title={`${value.displayName}()`}>{leftChars(value.displayName)}</Tag>
	
	
	
	
}
const renderItemOfList=(smartPallet, targetComponent, columCount)=>{
  
  if(!smartPallet){
  	return null
  }
  if(!smartPallet.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`smartPallet-${smartPallet.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(smartPallet.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={smartPallet.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{smartPallet.id}</Description> 
        <Description term={fieldLabels.location} style={{wordBreak: 'break-all'}}>{smartPallet.location}</Description> 
        <Description term={fieldLabels.contactNumber} style={{wordBreak: 'break-all'}}>{smartPallet.contactNumber}</Description> 
        <Description term={fieldLabels.totalArea} style={{wordBreak: 'break-all'}}>{smartPallet.totalArea}</Description> 
        <Description term={fieldLabels.latitude}><div style={{"color":"red"}}>{smartPallet.latitude}</div></Description> 
        <Description term={fieldLabels.longitude}><div style={{"color":"red"}}>{smartPallet.longitude}</div></Description> 
        <Description term={fieldLabels.warehouse}>{renderReferenceItem(smartPallet.warehouse)}</Description>

        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(smartPallet.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {location, contactNumber, totalArea, latitude, longitude, warehouseId} = formValuesToPack
	const warehouse = {id: warehouseId, version: 2^31}
	const data = {location, contactNumber, totalArea, latitude, longitude, warehouse}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {location, contactNumber, totalArea, latitude, longitude, warehouse} = objectToUnpack
	const warehouseId = warehouse ? warehouse.id : null
	const data = {location, contactNumber, totalArea, latitude, longitude, warehouseId}
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
const SmartPalletBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default SmartPalletBase

