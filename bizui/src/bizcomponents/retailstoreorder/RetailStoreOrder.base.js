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
import styles from './RetailStoreOrder.base.less'
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



const menuData = {menuName: window.trans('retail_store_order'), menuFor: "retailStoreOrder",
  		subItems: [
  {name: 'retailStoreOrderLineItemList', displayName: window.mtrans('retail_store_order_line_item','retail_store_order.retail_store_order_line_item_list',false), type:'retailStoreOrderLineItem',icon:'line',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreOrderShippingGroupList', displayName: window.mtrans('retail_store_order_shipping_group','retail_store_order.retail_store_order_shipping_group_list',false), type:'retailStoreOrderShippingGroup',icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreOrderPaymentGroupList', displayName: window.mtrans('retail_store_order_payment_group','retail_store_order.retail_store_order_payment_group_list',false), type:'retailStoreOrderPaymentGroup',icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'goodsList', displayName: window.mtrans('goods','retail_store_order.goods_list',false), type:'goods',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('retail_store_order'), menuFor: "retailStoreOrder",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('retail_store_order.id'),
  buyer: window.trans('retail_store_order.buyer'),
  seller: window.trans('retail_store_order.seller'),
  title: window.trans('retail_store_order.title'),
  totalAmount: window.trans('retail_store_order.total_amount'),
  lastUpdateTime: window.trans('retail_store_order.last_update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStoreOrder') , sorter: true },
  { title: fieldLabels.buyer, dataIndex: 'buyer', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.seller, dataIndex: 'seller', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '18',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.totalAmount, dataIndex: 'totalAmount', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
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
const renderItemOfList=(retailStoreOrder, targetComponent, columCount)=>{
  
  if(!retailStoreOrder){
  	return null
  }
  if(!retailStoreOrder.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`retailStoreOrder-${retailStoreOrder.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(retailStoreOrder.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={retailStoreOrder.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{retailStoreOrder.id}</Description> 
        <Description term={fieldLabels.buyer}>{renderReferenceItem(retailStoreOrder.buyer)}</Description>

        <Description term={fieldLabels.title} style={{wordBreak: 'break-all'}}>{retailStoreOrder.title}</Description> 
        <Description term={fieldLabels.totalAmount}><div style={{"color":"red"}}>{retailStoreOrder.totalAmount}</div></Description> 
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(retailStoreOrder.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {title, totalAmount, buyerId, sellerId} = formValuesToPack
	const buyer = {id: buyerId, version: 2^31}
	const seller = {id: sellerId, version: 2^31}
	const data = {title, totalAmount, buyer, seller}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {title, totalAmount, buyer, seller} = objectToUnpack
	const buyerId = buyer ? buyer.id : null
	const sellerId = seller ? seller.id : null
	const data = {title, totalAmount, buyerId, sellerId}
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
const RetailStoreOrderBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default RetailStoreOrderBase

