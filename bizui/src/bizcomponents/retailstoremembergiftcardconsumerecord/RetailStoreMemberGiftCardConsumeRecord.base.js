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


const menuData = {menuName:"零售商店会员卡消费记录", menuFor: "retailStoreMemberGiftCardConsumeRecord",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"零售商店会员卡消费记录", menuFor: "retailStoreMemberGiftCardConsumeRecord",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  occureTime: '发生时间',
  owner: '业主',
  bizOrder: '订单',
  number: '数',
  amount: '金额',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStoreMemberGiftCardConsumeRecord') , sorter: true },
  { title: fieldLabels.occureTime, dataIndex: 'occureTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.bizOrder, dataIndex: 'bizOrder', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.number, debugtype: 'string', dataIndex: 'number', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.amount, dataIndex: 'amount', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(retailStoreMemberGiftCardConsumeRecord,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreMemberGiftCardConsumeRecord.id}>
	
      <DescriptionList  key={retailStoreMemberGiftCardConsumeRecord.id} size="small" col="4">
        <Description term="序号">{retailStoreMemberGiftCardConsumeRecord.id}</Description> 
        <Description term="发生时间"><div>{ moment(retailStoreMemberGiftCardConsumeRecord.occureTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term="业主"><div>{retailStoreMemberGiftCardConsumeRecord.owner==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreMemberGiftCardConsumeRecord.owner.displayName}(${retailStoreMemberGiftCardConsumeRecord.owner.id})`}
        </div></Description>
        <Description term="订单"><div>{retailStoreMemberGiftCardConsumeRecord.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreMemberGiftCardConsumeRecord.bizOrder.displayName}(${retailStoreMemberGiftCardConsumeRecord.bizOrder.id})`}
        </div></Description>
        <Description term="数">{retailStoreMemberGiftCardConsumeRecord.number}</Description> 
        <Description term="金额"><div style={{"color":"red"}}>{retailStoreMemberGiftCardConsumeRecord.amount}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {occureTime, number, amount, ownerId, bizOrderId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const bizOrder = {id: bizOrderId, version: 2^31}
	const data = {occureTime, number, amount, owner, bizOrder}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {occureTime, number, amount, owner, bizOrder} = objectToUnpack
	const ownerId = owner ? owner.id : null
	const bizOrderId = bizOrder ? bizOrder.id : null
	const data = {occureTime, number, amount, ownerId, bizOrderId}
	return data
}

const RetailStoreMemberGiftCardConsumeRecordBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
export default RetailStoreMemberGiftCardConsumeRecordBase



