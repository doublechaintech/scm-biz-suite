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
const menuData = {menuName:"生超的订单", menuFor: "retailStoreOrder",
  		subItems: [
  {name: 'retailStoreOrderLineItemList', displayName:'双链小超订单行项目', icon:'line',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreOrderShippingGroupList', displayName:'生超订单送货分组', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreOrderPaymentGroupList', displayName:'生超订单付款组', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'goodsList', displayName:'货物', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('retail_store_order'), menuFor: "retailStoreOrder",
  		subItems: [
  {name: 'retailStoreOrderLineItemList', displayName: window.mtrans('retail_store_order_line_item','retail_store_order.retail_store_order_line_item_list',false), type:'retailStoreOrderLineItem',icon:'line',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreOrderShippingGroupList', displayName: window.mtrans('retail_store_order_shipping_group','retail_store_order.retail_store_order_shipping_group_list',false), type:'retailStoreOrderShippingGroup',icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreOrderPaymentGroupList', displayName: window.mtrans('retail_store_order_payment_group','retail_store_order.retail_store_order_payment_group_list',false), type:'retailStoreOrderPaymentGroup',icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'goodsList', displayName: window.mtrans('goods','retail_store_order.goods_list',false), type:'goods',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD
=======

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
  confirmation: window.trans('retail_store_order.confirmation'),
  approval: window.trans('retail_store_order.approval'),
  processing: window.trans('retail_store_order.processing'),
  picking: window.trans('retail_store_order.picking'),
  shipment: window.trans('retail_store_order.shipment'),
  delivery: window.trans('retail_store_order.delivery'),
  lastUpdateTime: window.trans('retail_store_order.last_update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStoreOrder') , sorter: true },
  { title: fieldLabels.buyer, dataIndex: 'buyer', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.seller, dataIndex: 'seller', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '18',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.totalAmount, dataIndex: 'totalAmount', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.confirmation, dataIndex: 'confirmation', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.approval, dataIndex: 'approval', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.processing, dataIndex: 'processing', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.picking, dataIndex: 'picking', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.shipment, dataIndex: 'shipment', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.delivery, dataIndex: 'delivery', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(retailStoreOrder,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreOrder.id}>
	
      <DescriptionList  key={retailStoreOrder.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{retailStoreOrder.id}</Description> 
        <Description term={fieldLabels.buyer}><div>{retailStoreOrder.buyer==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreOrder.buyer.displayName}(${retailStoreOrder.buyer.id})`}
        </div></Description>
        <Description term={fieldLabels.title} style={{wordBreak: 'break-all'}}>{retailStoreOrder.title}</Description> 
        <Description term={fieldLabels.totalAmount}><div style={{"color":"red"}}>{retailStoreOrder.totalAmount}</div></Description> 
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(retailStoreOrder.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"生超的订单", menuFor: "retailStoreOrder",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  buyer: '买方',
  seller: '卖方',
  title: '头衔',
  totalAmount: '总金额',
  confirmation: '确认',
  approval: '验收',
  processing: '处理',
  picking: '捡货',
  shipment: '装运',
  delivery: '送货',
  lastUpdateTime: '最后更新时间',
  currentStatus: '当前状态',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStoreOrder') , sorter: true },
  { title: fieldLabels.buyer, dataIndex: 'buyer', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.seller, dataIndex: 'seller', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '18',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.totalAmount, dataIndex: 'totalAmount', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.confirmation, dataIndex: 'confirmation', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.approval, dataIndex: 'approval', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.processing, dataIndex: 'processing', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.picking, dataIndex: 'picking', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.shipment, dataIndex: 'shipment', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.delivery, dataIndex: 'delivery', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.currentStatus, debugtype: 'string', dataIndex: 'currentStatus', width: '13',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(retailStoreOrder,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreOrder.id}>
	
      <DescriptionList  key={retailStoreOrder.id} size="small" col="4">
        <Description term="序号">{retailStoreOrder.id}</Description> 
        <Description term="买方"><div>{retailStoreOrder.buyer==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreOrder.buyer.displayName}(${retailStoreOrder.buyer.id})`}
        </div></Description>
        <Description term="头衔">{retailStoreOrder.title}</Description> 
        <Description term="总金额"><div style={{"color":"red"}}>{retailStoreOrder.totalAmount}</div></Description> 
        <Description term="最后更新时间"><div>{ moment(retailStoreOrder.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term="当前状态">{retailStoreOrder.currentStatus}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
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

const RetailStoreOrderBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {title, totalAmount, buyerId, sellerId, confirmationId, approvalId, processingId, pickingId, shipmentId, deliveryId} = formValuesToPack
	const buyer = {id: buyerId, version: 2^31}
	const seller = {id: sellerId, version: 2^31}
	const confirmation = {id: confirmationId, version: 2^31}
	const approval = {id: approvalId, version: 2^31}
	const processing = {id: processingId, version: 2^31}
	const picking = {id: pickingId, version: 2^31}
	const shipment = {id: shipmentId, version: 2^31}
	const delivery = {id: deliveryId, version: 2^31}
	const data = {title, totalAmount, buyer, seller, confirmation, approval, processing, picking, shipment, delivery}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {title, totalAmount, buyer, seller, confirmation, approval, processing, picking, shipment, delivery} = objectToUnpack
	const buyerId = buyer ? buyer.id : null
	const sellerId = seller ? seller.id : null
	const confirmationId = confirmation ? confirmation.id : null
	const approvalId = approval ? approval.id : null
	const processingId = processing ? processing.id : null
	const pickingId = picking ? picking.id : null
	const shipmentId = shipment ? shipment.id : null
	const deliveryId = delivery ? delivery.id : null
	const data = {title, totalAmount, buyerId, sellerId, confirmationId, approvalId, processingId, pickingId, shipmentId, deliveryId}
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
const RetailStoreOrderBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default RetailStoreOrderBase



