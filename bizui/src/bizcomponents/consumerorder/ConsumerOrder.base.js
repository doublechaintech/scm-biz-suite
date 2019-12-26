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
const menuData = {menuName:"消费者订单", menuFor: "consumerOrder",
  		subItems: [
  {name: 'consumerOrderLineItemList', displayName:'消费者订单行项目', icon:'line',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'consumerOrderShippingGroupList', displayName:'消费订单送货分组', icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'consumerOrderPaymentGroupList', displayName:'消费者订单付款组', icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'consumerOrderPriceAdjustmentList', displayName:'消费品价格调整', icon:'ad',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreMemberGiftCardConsumeRecordList', displayName:'零售商店会员卡消费记录', icon:'gift',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('consumer_order'), menuFor: "consumerOrder",
  		subItems: [
  {name: 'consumerOrderLineItemList', displayName: window.mtrans('consumer_order_line_item','consumer_order.consumer_order_line_item_list',false), type:'consumerOrderLineItem',icon:'line',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'consumerOrderShippingGroupList', displayName: window.mtrans('consumer_order_shipping_group','consumer_order.consumer_order_shipping_group_list',false), type:'consumerOrderShippingGroup',icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'consumerOrderPaymentGroupList', displayName: window.mtrans('consumer_order_payment_group','consumer_order.consumer_order_payment_group_list',false), type:'consumerOrderPaymentGroup',icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'consumerOrderPriceAdjustmentList', displayName: window.mtrans('consumer_order_price_adjustment','consumer_order.consumer_order_price_adjustment_list',false), type:'consumerOrderPriceAdjustment',icon:'ad',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreMemberGiftCardConsumeRecordList', displayName: window.mtrans('retail_store_member_gift_card_consume_record','consumer_order.retail_store_member_gift_card_consume_record_list',false), type:'retailStoreMemberGiftCardConsumeRecord',icon:'gift',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('consumer_order'), menuFor: "consumerOrder",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('consumer_order.id'),
  title: window.trans('consumer_order.title'),
  consumer: window.trans('consumer_order.consumer'),
  confirmation: window.trans('consumer_order.confirmation'),
  approval: window.trans('consumer_order.approval'),
  processing: window.trans('consumer_order.processing'),
  shipment: window.trans('consumer_order.shipment'),
  delivery: window.trans('consumer_order.delivery'),
  store: window.trans('consumer_order.store'),
  lastUpdateTime: window.trans('consumer_order.last_update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'consumerOrder') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.consumer, dataIndex: 'consumer', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.confirmation, dataIndex: 'confirmation', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.approval, dataIndex: 'approval', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.processing, dataIndex: 'processing', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.shipment, dataIndex: 'shipment', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.delivery, dataIndex: 'delivery', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.store, dataIndex: 'store', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(consumerOrder,targetComponent)=>{

  const userContext = null
  return (
    <div key={consumerOrder.id}>
	
      <DescriptionList  key={consumerOrder.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{consumerOrder.id}</Description> 
        <Description term={fieldLabels.title} style={{wordBreak: 'break-all'}}>{consumerOrder.title}</Description> 
        <Description term={fieldLabels.consumer}><div>{consumerOrder.consumer==null?appLocaleName(userContext,"NotAssigned"):`${consumerOrder.consumer.displayName}(${consumerOrder.consumer.id})`}
        </div></Description>
        <Description term={fieldLabels.store}><div>{consumerOrder.store==null?appLocaleName(userContext,"NotAssigned"):`${consumerOrder.store.displayName}(${consumerOrder.store.id})`}
        </div></Description>
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(consumerOrder.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"消费者订单", menuFor: "consumerOrder",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  title: '头衔',
  consumer: '消费者',
  confirmation: '确认',
  approval: '验收',
  processing: '处理',
  shipment: '装运',
  delivery: '送货',
  store: '商场',
  lastUpdateTime: '最后更新时间',
  currentStatus: '当前状态',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'consumerOrder') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.consumer, dataIndex: 'consumer', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.confirmation, dataIndex: 'confirmation', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.approval, dataIndex: 'approval', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.processing, dataIndex: 'processing', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.shipment, dataIndex: 'shipment', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.delivery, dataIndex: 'delivery', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.store, dataIndex: 'store', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.currentStatus, debugtype: 'string', dataIndex: 'currentStatus', width: '13',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(consumerOrder,targetComponent)=>{

  const userContext = null
  return (
    <div key={consumerOrder.id}>
	
      <DescriptionList  key={consumerOrder.id} size="small" col="4">
        <Description term="序号">{consumerOrder.id}</Description> 
        <Description term="头衔">{consumerOrder.title}</Description> 
        <Description term="消费者"><div>{consumerOrder.consumer==null?appLocaleName(userContext,"NotAssigned"):`${consumerOrder.consumer.displayName}(${consumerOrder.consumer.id})`}
        </div></Description>
        <Description term="商场"><div>{consumerOrder.store==null?appLocaleName(userContext,"NotAssigned"):`${consumerOrder.store.displayName}(${consumerOrder.store.id})`}
        </div></Description>
        <Description term="最后更新时间"><div>{ moment(consumerOrder.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term="当前状态">{consumerOrder.currentStatus}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
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

const ConsumerOrderBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {title, consumerId, confirmationId, approvalId, processingId, shipmentId, deliveryId, storeId} = formValuesToPack
	const consumer = {id: consumerId, version: 2^31}
	const confirmation = {id: confirmationId, version: 2^31}
	const approval = {id: approvalId, version: 2^31}
	const processing = {id: processingId, version: 2^31}
	const shipment = {id: shipmentId, version: 2^31}
	const delivery = {id: deliveryId, version: 2^31}
	const store = {id: storeId, version: 2^31}
	const data = {title, consumer, confirmation, approval, processing, shipment, delivery, store}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {title, consumer, confirmation, approval, processing, shipment, delivery, store} = objectToUnpack
	const consumerId = consumer ? consumer.id : null
	const confirmationId = confirmation ? confirmation.id : null
	const approvalId = approval ? approval.id : null
	const processingId = processing ? processing.id : null
	const shipmentId = shipment ? shipment.id : null
	const deliveryId = delivery ? delivery.id : null
	const storeId = store ? store.id : null
	const data = {title, consumerId, confirmationId, approvalId, processingId, shipmentId, deliveryId, storeId}
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
const ConsumerOrderBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default ConsumerOrderBase



