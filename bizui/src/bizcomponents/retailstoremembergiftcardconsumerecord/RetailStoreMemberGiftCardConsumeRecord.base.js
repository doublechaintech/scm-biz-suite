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
const menuData = {menuName:"零售商店会员卡消费记录", menuFor: "retailStoreMemberGiftCardConsumeRecord",
=======

const menuData = {menuName: window.trans('retail_store_member_gift_card_consume_record'), menuFor: "retailStoreMemberGiftCardConsumeRecord",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('retail_store_member_gift_card_consume_record'), menuFor: "retailStoreMemberGiftCardConsumeRecord",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('retail_store_member_gift_card_consume_record.id'),
  occureTime: window.trans('retail_store_member_gift_card_consume_record.occure_time'),
  owner: window.trans('retail_store_member_gift_card_consume_record.owner'),
  bizOrder: window.trans('retail_store_member_gift_card_consume_record.biz_order'),
  number: window.trans('retail_store_member_gift_card_consume_record.number'),
  amount: window.trans('retail_store_member_gift_card_consume_record.amount'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStoreMemberGiftCardConsumeRecord') , sorter: true },
  { title: fieldLabels.occureTime, dataIndex: 'occureTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.bizOrder, dataIndex: 'bizOrder', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.number, debugtype: 'string', dataIndex: 'number', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.amount, dataIndex: 'amount', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(retailStoreMemberGiftCardConsumeRecord,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreMemberGiftCardConsumeRecord.id}>
	
      <DescriptionList  key={retailStoreMemberGiftCardConsumeRecord.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{retailStoreMemberGiftCardConsumeRecord.id}</Description> 
        <Description term={fieldLabels.occureTime}><div>{ moment(retailStoreMemberGiftCardConsumeRecord.occureTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.owner}><div>{retailStoreMemberGiftCardConsumeRecord.owner==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreMemberGiftCardConsumeRecord.owner.displayName}(${retailStoreMemberGiftCardConsumeRecord.owner.id})`}
        </div></Description>
        <Description term={fieldLabels.bizOrder}><div>{retailStoreMemberGiftCardConsumeRecord.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreMemberGiftCardConsumeRecord.bizOrder.displayName}(${retailStoreMemberGiftCardConsumeRecord.bizOrder.id})`}
        </div></Description>
        <Description term={fieldLabels.number} style={{wordBreak: 'break-all'}}>{retailStoreMemberGiftCardConsumeRecord.number}</Description> 
        <Description term={fieldLabels.amount}><div style={{"color":"red"}}>{retailStoreMemberGiftCardConsumeRecord.amount}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"零售商店会员卡消费记录", menuFor: "retailStoreMemberGiftCardConsumeRecord",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

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
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {occureTime, number, amount, ownerId, bizOrderId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const bizOrder = {id: bizOrderId, version: 2^31}
	const data = {occureTime, number, amount, owner, bizOrder}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {occureTime, number, amount, owner, bizOrder} = objectToUnpack
	const ownerId = owner ? owner.id : null
	const bizOrderId = bizOrder ? bizOrder.id : null
	const data = {occureTime, number, amount, ownerId, bizOrderId}
	return data
}
<<<<<<< HEAD

const RetailStoreMemberGiftCardConsumeRecordBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
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
const RetailStoreMemberGiftCardConsumeRecordBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default RetailStoreMemberGiftCardConsumeRecordBase



