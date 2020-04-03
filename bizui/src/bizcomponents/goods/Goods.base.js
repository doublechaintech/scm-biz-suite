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
import styles from './Goods.base.less'
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



const menuData = {menuName: window.trans('goods'), menuFor: "goods",
  		subItems: [
  {name: 'goodsMovementList', displayName: window.mtrans('goods_movement','goods.goods_movement_list',false), type:'goodsMovement',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('goods'), menuFor: "goods",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('goods.id'),
  name: window.trans('goods.name'),
  rfid: window.trans('goods.rfid'),
  uom: window.trans('goods.uom'),
  maxPackage: window.trans('goods.max_package'),
  expireTime: window.trans('goods.expire_time'),
  sku: window.trans('goods.sku'),
  receivingSpace: window.trans('goods.receiving_space'),
  goodsAllocation: window.trans('goods.goods_allocation'),
  smartPallet: window.trans('goods.smart_pallet'),
  shippingSpace: window.trans('goods.shipping_space'),
  transportTask: window.trans('goods.transport_task'),
  retailStore: window.trans('goods.retail_store'),
  bizOrder: window.trans('goods.biz_order'),
  retailStoreOrder: window.trans('goods.retail_store_order'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'goods') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.rfid, debugtype: 'string', dataIndex: 'rfid', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.uom, debugtype: 'string', dataIndex: 'uom', width: '5',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.maxPackage, dataIndex: 'maxPackage', className:'money', render: (text, record) => renderTextCell(text, record), sorter: true  },
  { title: fieldLabels.expireTime, dataIndex: 'expireTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.sku, dataIndex: 'sku', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.receivingSpace, dataIndex: 'receivingSpace', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.goodsAllocation, dataIndex: 'goodsAllocation', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.smartPallet, dataIndex: 'smartPallet', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.shippingSpace, dataIndex: 'shippingSpace', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.transportTask, dataIndex: 'transportTask', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.retailStore, dataIndex: 'retailStore', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.bizOrder, dataIndex: 'bizOrder', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.retailStoreOrder, dataIndex: 'retailStoreOrder', render: (text, record) => renderReferenceCell(text, record), sorter:true},

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
const renderItemOfList=(goods, targetComponent, columCount)=>{
  
  if(!goods){
  	return null
  }
  if(!goods.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`goods-${goods.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(goods.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={goods.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{goods.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{goods.name}</Description> 
        <Description term={fieldLabels.rfid} style={{wordBreak: 'break-all'}}>{goods.rfid}</Description> 
        <Description term={fieldLabels.uom} style={{wordBreak: 'break-all'}}>{goods.uom}</Description> 
        <Description term={fieldLabels.maxPackage}><div style={{"color":"red"}}>{goods.maxPackage}</div></Description> 
        <Description term={fieldLabels.expireTime}><div>{ moment(goods.expireTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.sku}>{renderReferenceItem(goods.sku)}</Description>

        <Description term={fieldLabels.receivingSpace}>{renderReferenceItem(goods.receivingSpace)}</Description>

        <Description term={fieldLabels.goodsAllocation}>{renderReferenceItem(goods.goodsAllocation)}</Description>

        <Description term={fieldLabels.smartPallet}>{renderReferenceItem(goods.smartPallet)}</Description>

        <Description term={fieldLabels.shippingSpace}>{renderReferenceItem(goods.shippingSpace)}</Description>

        <Description term={fieldLabels.transportTask}>{renderReferenceItem(goods.transportTask)}</Description>

        <Description term={fieldLabels.retailStore}>{renderReferenceItem(goods.retailStore)}</Description>

        <Description term={fieldLabels.bizOrder}>{renderReferenceItem(goods.bizOrder)}</Description>

        <Description term={fieldLabels.retailStoreOrder}>{renderReferenceItem(goods.retailStoreOrder)}</Description>

	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId} = formValuesToPack
	const sku = {id: skuId, version: 2^31}
	const receivingSpace = {id: receivingSpaceId, version: 2^31}
	const goodsAllocation = {id: goodsAllocationId, version: 2^31}
	const smartPallet = {id: smartPalletId, version: 2^31}
	const shippingSpace = {id: shippingSpaceId, version: 2^31}
	const transportTask = {id: transportTaskId, version: 2^31}
	const retailStore = {id: retailStoreId, version: 2^31}
	const bizOrder = {id: bizOrderId, version: 2^31}
	const retailStoreOrder = {id: retailStoreOrderId, version: 2^31}
	const data = {name, rfid, uom, maxPackage, expireTime:moment(expireTime).valueOf(), sku, receivingSpace, goodsAllocation, smartPallet, shippingSpace, transportTask, retailStore, bizOrder, retailStoreOrder}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, rfid, uom, maxPackage, expireTime, sku, receivingSpace, goodsAllocation, smartPallet, shippingSpace, transportTask, retailStore, bizOrder, retailStoreOrder} = objectToUnpack
	const skuId = sku ? sku.id : null
	const receivingSpaceId = receivingSpace ? receivingSpace.id : null
	const goodsAllocationId = goodsAllocation ? goodsAllocation.id : null
	const smartPalletId = smartPallet ? smartPallet.id : null
	const shippingSpaceId = shippingSpace ? shippingSpace.id : null
	const transportTaskId = transportTask ? transportTask.id : null
	const retailStoreId = retailStore ? retailStore.id : null
	const bizOrderId = bizOrder ? bizOrder.id : null
	const retailStoreOrderId = retailStoreOrder ? retailStoreOrder.id : null
	const data = {name, rfid, uom, maxPackage, expireTime:moment(expireTime), skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId, retailStoreOrderId}
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
const GoodsBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default GoodsBase

