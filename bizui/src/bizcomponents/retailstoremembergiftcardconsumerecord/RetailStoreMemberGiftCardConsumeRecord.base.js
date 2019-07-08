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


const menuData = {menuName:"Retail Store Member Gift Card Consume Record", menuFor: "retailStoreMemberGiftCardConsumeRecord",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'Id',
  occureTime: 'Occure Time',
  owner: 'Owner',
  bizOrder: 'Biz Order',
  number: 'Number',
  amount: 'Amount',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
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
<Description term="Id">{retailStoreMemberGiftCardConsumeRecord.id}</Description> 
<Description term="Occure Time">{ moment(retailStoreMemberGiftCardConsumeRecord.occureTime).format('YYYY-MM-DD')}</Description> 
<Description term="Owner">{retailStoreMemberGiftCardConsumeRecord.owner==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreMemberGiftCardConsumeRecord.owner.displayName}(${retailStoreMemberGiftCardConsumeRecord.owner.id})`}
</Description>
<Description term="Biz Order">{retailStoreMemberGiftCardConsumeRecord.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreMemberGiftCardConsumeRecord.bizOrder.displayName}(${retailStoreMemberGiftCardConsumeRecord.bizOrder.id})`}
</Description>
<Description term="Number">{retailStoreMemberGiftCardConsumeRecord.number}</Description> 
<Description term="Amount">{retailStoreMemberGiftCardConsumeRecord.amount}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const RetailStoreMemberGiftCardConsumeRecordBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default RetailStoreMemberGiftCardConsumeRecordBase



