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
  { title: fieldLabels.latitude, debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.longitude, debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.goodsShelf, dataIndex: 'goodsShelf', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(goodsAllocation,targetComponent)=>{

  const userContext = null
  return (
    <div key={goodsAllocation.id}>
	
      <DescriptionList  key={goodsAllocation.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{goodsAllocation.id}</Description> 
        <Description term={fieldLabels.location} style={{wordBreak: 'break-all'}}>{goodsAllocation.location}</Description> 
        <Description term={fieldLabels.latitude}><div style={{"color":"red"}}>{goodsAllocation.latitude}</div></Description> 
        <Description term={fieldLabels.longitude}><div style={{"color":"red"}}>{goodsAllocation.longitude}</div></Description> 
        <Description term={fieldLabels.goodsShelf}><div>{goodsAllocation.goodsShelf==null?appLocaleName(userContext,"NotAssigned"):`${goodsAllocation.goodsShelf.displayName}(${goodsAllocation.goodsShelf.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
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
const GoodsAllocationBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default GoodsAllocationBase



