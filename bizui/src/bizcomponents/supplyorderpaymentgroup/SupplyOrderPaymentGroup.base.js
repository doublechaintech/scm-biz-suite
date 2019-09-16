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


const menuData = {menuName:"供应订单付款组", menuFor: "supplyOrderPaymentGroup",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"供应订单付款组", menuFor: "supplyOrderPaymentGroup",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  bizOrder: '订单',
  cardNumber: '卡号码',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'supplyOrderPaymentGroup') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.bizOrder, dataIndex: 'bizOrder', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.cardNumber, debugtype: 'string', dataIndex: 'cardNumber', width: '21',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(supplyOrderPaymentGroup,targetComponent)=>{

  const userContext = null
  return (
    <div key={supplyOrderPaymentGroup.id}>
	
      <DescriptionList  key={supplyOrderPaymentGroup.id} size="small" col="4">
        <Description term="序号">{supplyOrderPaymentGroup.id}</Description> 
        <Description term="名称">{supplyOrderPaymentGroup.name}</Description> 
        <Description term="订单"><div>{supplyOrderPaymentGroup.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${supplyOrderPaymentGroup.bizOrder.displayName}(${supplyOrderPaymentGroup.bizOrder.id})`}
        </div></Description>
        <Description term="卡号码">{supplyOrderPaymentGroup.cardNumber}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const SupplyOrderPaymentGroupBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default SupplyOrderPaymentGroupBase



