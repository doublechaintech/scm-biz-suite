import React from 'react'
import { Icon,Divider } from 'antd'

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
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


const menuData = {menuName:"生超的订单", menuFor: "retailStoreOrder",
  		subItems: [
  {name: 'retailStoreOrderLineItemList', displayName:'双链小超订单行项目', icon:'line',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreOrderShippingGroupList', displayName:'生超订单送货分组', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreOrderPaymentGroupList', displayName:'生超订单付款组', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'goodsList', displayName:'货物', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"生超的订单", menuFor: "retailStoreOrder",
  		subItems: [
  
  		],
}

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
	



const RetailStoreOrderBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default RetailStoreOrderBase



