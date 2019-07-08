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


const menuData = {menuName:"Consumer Order Payment Group", menuFor: "consumerOrderPaymentGroup",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  bizOrder: 'Biz Order',
  cardNumber: 'Card Number',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.bizOrder, dataIndex: 'bizOrder', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.cardNumber, debugtype: 'string', dataIndex: 'cardNumber', width: '21',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(consumerOrderPaymentGroup,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={consumerOrderPaymentGroup.id}>
	
	<DescriptionList  key={consumerOrderPaymentGroup.id} size="small" col="4">
<Description term="Id">{consumerOrderPaymentGroup.id}</Description> 
<Description term="Name">{consumerOrderPaymentGroup.name}</Description> 
<Description term="Biz Order">{consumerOrderPaymentGroup.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${consumerOrderPaymentGroup.bizOrder.displayName}(${consumerOrderPaymentGroup.bizOrder.id})`}
</Description>
<Description term="Card Number">{consumerOrderPaymentGroup.cardNumber}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const ConsumerOrderPaymentGroupBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default ConsumerOrderPaymentGroupBase



