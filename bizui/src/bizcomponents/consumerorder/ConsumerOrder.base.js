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
import styles from './ConsumerOrder.base.less'
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



const menuData = {menuName: window.trans('consumer_order'), menuFor: "consumerOrder",
  		subItems: [
  {name: 'consumerOrderLineItemList', displayName: window.mtrans('consumer_order_line_item','consumer_order.consumer_order_line_item_list',false), type:'consumerOrderLineItem',icon:'line',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'consumerOrderShippingGroupList', displayName: window.mtrans('consumer_order_shipping_group','consumer_order.consumer_order_shipping_group_list',false), type:'consumerOrderShippingGroup',icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'consumerOrderPaymentGroupList', displayName: window.mtrans('consumer_order_payment_group','consumer_order.consumer_order_payment_group_list',false), type:'consumerOrderPaymentGroup',icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'consumerOrderPriceAdjustmentList', displayName: window.mtrans('consumer_order_price_adjustment','consumer_order.consumer_order_price_adjustment_list',false), type:'consumerOrderPriceAdjustment',icon:'ad',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreMemberGiftCardConsumeRecordList', displayName: window.mtrans('retail_store_member_gift_card_consume_record','consumer_order.retail_store_member_gift_card_consume_record_list',false), type:'retailStoreMemberGiftCardConsumeRecord',icon:'gift',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('consumer_order'), menuFor: "consumerOrder",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('consumer_order.id'),
  title: window.trans('consumer_order.title'),
  consumer: window.trans('consumer_order.consumer'),
  store: window.trans('consumer_order.store'),
  lastUpdateTime: window.trans('consumer_order.last_update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'consumerOrder') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.consumer, dataIndex: 'consumer', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.store, dataIndex: 'store', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

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
const renderItemOfList=(consumerOrder, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 4
=======

const renderItemOfList=(consumerOrder, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
>>>>>>> b1266426b024c6919f91c6b5be4635d10d614fe9
  const userContext = null
  return (
    <Card key={consumerOrder.id} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(consumerOrder.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={consumerOrder.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{consumerOrder.id}</Description> 
        <Description term={fieldLabels.title} style={{wordBreak: 'break-all'}}>{consumerOrder.title}</Description> 
        <Description term={fieldLabels.consumer}><Tag color='blue' title={`${consumerOrder.consumer.id}-${consumerOrder.consumer.displayName}`}>{consumerOrder.consumer==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(consumerOrder.consumer.displayName,15)}`}
        </Tag></Description>
        <Description term={fieldLabels.store}><Tag color='blue' title={`${consumerOrder.store.id}-${consumerOrder.store.displayName}`}>{consumerOrder.store==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(consumerOrder.store.displayName,15)}`}
        </Tag></Description>
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(consumerOrder.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {title, consumerId, storeId} = formValuesToPack
	const consumer = {id: consumerId, version: 2^31}
	const store = {id: storeId, version: 2^31}
	const data = {title, consumer, store}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {title, consumer, store} = objectToUnpack
	const consumerId = consumer ? consumer.id : null
	const storeId = store ? store.id : null
	const data = {title, consumerId, storeId}
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
const ConsumerOrderBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default ConsumerOrderBase

