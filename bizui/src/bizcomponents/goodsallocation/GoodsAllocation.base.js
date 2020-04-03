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
import styles from './GoodsAllocation.base.less'
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



const menuData = {menuName: window.trans('goods_allocation'), menuFor: "goodsAllocation",
  		subItems: [
  {name: 'goodsList', displayName: window.mtrans('goods','goods_allocation.goods_list',false), type:'goods',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('goods_allocation'), menuFor: "goodsAllocation",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('goods_allocation.id'),
  location: window.trans('goods_allocation.location'),
  latitude: window.trans('goods_allocation.latitude'),
  longitude: window.trans('goods_allocation.longitude'),
  goodsShelf: window.trans('goods_allocation.goods_shelf'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'goodsAllocation') , sorter: true },
  { title: fieldLabels.location, debugtype: 'string', dataIndex: 'location', width: '25',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.latitude, dataIndex: 'latitude', className:'money', render: (text, record) => renderTextCell(text, record), sorter: true  },
  { title: fieldLabels.longitude, dataIndex: 'longitude', className:'money', render: (text, record) => renderTextCell(text, record), sorter: true  },
  { title: fieldLabels.goodsShelf, dataIndex: 'goodsShelf', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)
<<<<<<< HEAD
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
const renderItemOfList=(goodsAllocation, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 4
=======

const renderItemOfList=(goodsAllocation, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
>>>>>>> b1266426b024c6919f91c6b5be4635d10d614fe9
  const userContext = null
  return (
    <Card key={goodsAllocation.id} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(goodsAllocation.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={goodsAllocation.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{goodsAllocation.id}</Description> 
        <Description term={fieldLabels.location} style={{wordBreak: 'break-all'}}>{goodsAllocation.location}</Description> 
        <Description term={fieldLabels.latitude}><div style={{"color":"red"}}>{goodsAllocation.latitude}</div></Description> 
        <Description term={fieldLabels.longitude}><div style={{"color":"red"}}>{goodsAllocation.longitude}</div></Description> 
        <Description term={fieldLabels.goodsShelf}><Tag color='blue' title={`${goodsAllocation.goodsShelf.id}-${goodsAllocation.goodsShelf.displayName}`}>{goodsAllocation.goodsShelf==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(goodsAllocation.goodsShelf.displayName,15)}`}
        </Tag></Description>
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {location, latitude, longitude, goodsShelfId} = formValuesToPack
	const goodsShelf = {id: goodsShelfId, version: 2^31}
	const data = {location, latitude, longitude, goodsShelf}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {location, latitude, longitude, goodsShelf} = objectToUnpack
	const goodsShelfId = goodsShelf ? goodsShelf.id : null
	const data = {location, latitude, longitude, goodsShelfId}
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
const GoodsAllocationBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default GoodsAllocationBase

