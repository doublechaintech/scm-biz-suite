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
import styles from './GoodsShelf.base.less'
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



const menuData = {menuName: window.trans('goods_shelf'), menuFor: "goodsShelf",
  		subItems: [
  {name: 'goodsShelfStockCountList', displayName: window.mtrans('goods_shelf_stock_count','goods_shelf.goods_shelf_stock_count_list',false), type:'goodsShelfStockCount',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'goodsAllocationList', displayName: window.mtrans('goods_allocation','goods_shelf.goods_allocation_list',false), type:'goodsAllocation',icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('goods_shelf'), menuFor: "goodsShelf",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('goods_shelf.id'),
  location: window.trans('goods_shelf.location'),
  storageSpace: window.trans('goods_shelf.storage_space'),
  supplierSpace: window.trans('goods_shelf.supplier_space'),
  damageSpace: window.trans('goods_shelf.damage_space'),
  lastUpdateTime: window.trans('goods_shelf.last_update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'goodsShelf') , sorter: true },
  { title: fieldLabels.location, debugtype: 'string', dataIndex: 'location', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.storageSpace, dataIndex: 'storageSpace', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.supplierSpace, dataIndex: 'supplierSpace', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.damageSpace, dataIndex: 'damageSpace', render: (text, record) => renderReferenceCell(text, record), sorter:true},
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
const renderItemOfList=(goodsShelf, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={goodsShelf.id} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(goodsShelf.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={goodsShelf.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{goodsShelf.id}</Description> 
        <Description term={fieldLabels.location} style={{wordBreak: 'break-all'}}>{goodsShelf.location}</Description> 
        <Description term={fieldLabels.storageSpace}><Tag color='blue' title={`${goodsShelf.storageSpace.id}-${goodsShelf.storageSpace.displayName}`}>{goodsShelf.storageSpace==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(goodsShelf.storageSpace.displayName,15)}`}
        </Tag></Description>
        <Description term={fieldLabels.supplierSpace}><Tag color='blue' title={`${goodsShelf.supplierSpace.id}-${goodsShelf.supplierSpace.displayName}`}>{goodsShelf.supplierSpace==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(goodsShelf.supplierSpace.displayName,15)}`}
        </Tag></Description>
        <Description term={fieldLabels.damageSpace}><Tag color='blue' title={`${goodsShelf.damageSpace.id}-${goodsShelf.damageSpace.displayName}`}>{goodsShelf.damageSpace==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(goodsShelf.damageSpace.displayName,15)}`}
        </Tag></Description>
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(goodsShelf.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {location, storageSpaceId, supplierSpaceId, damageSpaceId} = formValuesToPack
	const storageSpace = {id: storageSpaceId, version: 2^31}
	const supplierSpace = {id: supplierSpaceId, version: 2^31}
	const damageSpace = {id: damageSpaceId, version: 2^31}
	const data = {location, storageSpace, supplierSpace, damageSpace}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {location, storageSpace, supplierSpace, damageSpace} = objectToUnpack
	const storageSpaceId = storageSpace ? storageSpace.id : null
	const supplierSpaceId = supplierSpace ? supplierSpace.id : null
	const damageSpaceId = damageSpace ? damageSpace.id : null
	const data = {location, storageSpaceId, supplierSpaceId, damageSpaceId}
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
const GoodsShelfBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default GoodsShelfBase

