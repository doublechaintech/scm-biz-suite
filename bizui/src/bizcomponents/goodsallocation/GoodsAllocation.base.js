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
const menuData = {menuName:"货位", menuFor: "goodsAllocation",
  		subItems: [
  {name: 'goodsList', displayName:'货物', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('goods_allocation'), menuFor: "goodsAllocation",
  		subItems: [
  {name: 'goodsList', displayName: window.mtrans('goods','goods_allocation.goods_list',false), type:'goods',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD
=======

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
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"货位", menuFor: "goodsAllocation",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  location: '位置',
  latitude: '纬度',
  longitude: '经度',
  goodsShelf: '货架',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'goodsAllocation') , sorter: true },
  { title: fieldLabels.location, debugtype: 'string', dataIndex: 'location', width: '25',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.latitude, debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.longitude, debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.goodsShelf, dataIndex: 'goodsShelf', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(goodsAllocation,targetComponent)=>{

  const userContext = null
  return (
    <div key={goodsAllocation.id}>
	
      <DescriptionList  key={goodsAllocation.id} size="small" col="4">
        <Description term="序号">{goodsAllocation.id}</Description> 
        <Description term="位置">{goodsAllocation.location}</Description> 
        <Description term="纬度"><div style={{"color":"red"}}>{goodsAllocation.latitude}</div></Description> 
        <Description term="经度"><div style={{"color":"red"}}>{goodsAllocation.longitude}</div></Description> 
        <Description term="货架"><div>{goodsAllocation.goodsShelf==null?appLocaleName(userContext,"NotAssigned"):`${goodsAllocation.goodsShelf.displayName}(${goodsAllocation.goodsShelf.id})`}
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
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {location, latitude, longitude, goodsShelfId} = formValuesToPack
	const goodsShelf = {id: goodsShelfId, version: 2^31}
	const data = {location, latitude, longitude, goodsShelf}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {location, latitude, longitude, goodsShelf} = objectToUnpack
	const goodsShelfId = goodsShelf ? goodsShelf.id : null
	const data = {location, latitude, longitude, goodsShelfId}
	return data
}
<<<<<<< HEAD

const GoodsAllocationBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const GoodsAllocationBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default GoodsAllocationBase



