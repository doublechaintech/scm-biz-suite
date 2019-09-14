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


const menuData = {menuName:"消费者订单行项目", menuFor: "consumerOrderLineItem",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  bizOrder: '订单',
  skuId: '产品ID',
  skuName: '产品名称',
  price: '价格',
  quantity: '数量',
  amount: '金额',
  lastUpdateTime: '最后更新时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'consumerOrderLineItem') , sorter: true },
  { title: fieldLabels.bizOrder, dataIndex: 'bizOrder', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.skuId, debugtype: 'string', dataIndex: 'skuId', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.skuName, debugtype: 'string', dataIndex: 'skuName', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.price, dataIndex: 'price', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.quantity, debugtype: 'double', dataIndex: 'quantity', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.amount, dataIndex: 'amount', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(consumerOrderLineItem,targetComponent)=>{

  const userContext = null
  return (
    <div key={consumerOrderLineItem.id}>
	
      <DescriptionList  key={consumerOrderLineItem.id} size="small" col="4">
        <Description term="序号">{consumerOrderLineItem.id}</Description> 
        <Description term="订单"><div>{consumerOrderLineItem.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${consumerOrderLineItem.bizOrder.displayName}(${consumerOrderLineItem.bizOrder.id})`}
        </div></Description>
        <Description term="产品ID">{consumerOrderLineItem.skuId}</Description> 
        <Description term="产品名称">{consumerOrderLineItem.skuName}</Description> 
        <Description term="价格"><div style={{"color":"red"}}>{consumerOrderLineItem.price}</div></Description> 
        <Description term="数量"><div style={{"color":"red"}}>{consumerOrderLineItem.quantity}</div></Description> 
        <Description term="金额"><div style={{"color":"red"}}>{consumerOrderLineItem.amount}</div></Description> 
        <Description term="最后更新时间"><div>{ moment(consumerOrderLineItem.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const ConsumerOrderLineItemBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default ConsumerOrderLineItemBase



