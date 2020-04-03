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
import styles from './RetailStoreMemberGiftCardConsumeRecord.base.less'
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



const menuData = {menuName: window.trans('retail_store_member_gift_card_consume_record'), menuFor: "retailStoreMemberGiftCardConsumeRecord",
  		subItems: [
  
  		],
}


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
const renderItemOfList=(retailStoreMemberGiftCardConsumeRecord, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={retailStoreMemberGiftCardConsumeRecord.id} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(retailStoreMemberGiftCardConsumeRecord.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={retailStoreMemberGiftCardConsumeRecord.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{retailStoreMemberGiftCardConsumeRecord.id}</Description> 
        <Description term={fieldLabels.occureTime}><div>{ moment(retailStoreMemberGiftCardConsumeRecord.occureTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.owner}><Tag color='blue' title={`${retailStoreMemberGiftCardConsumeRecord.owner.id}-${retailStoreMemberGiftCardConsumeRecord.owner.displayName}`}>{retailStoreMemberGiftCardConsumeRecord.owner==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(retailStoreMemberGiftCardConsumeRecord.owner.displayName,15)}`}
        </Tag></Description>
        <Description term={fieldLabels.bizOrder}><Tag color='blue' title={`${retailStoreMemberGiftCardConsumeRecord.bizOrder.id}-${retailStoreMemberGiftCardConsumeRecord.bizOrder.displayName}`}>{retailStoreMemberGiftCardConsumeRecord.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(retailStoreMemberGiftCardConsumeRecord.bizOrder.displayName,15)}`}
        </Tag></Description>
        <Description term={fieldLabels.number} style={{wordBreak: 'break-all'}}>{retailStoreMemberGiftCardConsumeRecord.number}</Description> 
        <Description term={fieldLabels.amount}><div style={{"color":"red"}}>{retailStoreMemberGiftCardConsumeRecord.amount}</div></Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {occureTime, number, amount, ownerId, bizOrderId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const bizOrder = {id: bizOrderId, version: 2^31}
	const data = {occureTime:moment(occureTime).valueOf(), number, amount, owner, bizOrder}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {occureTime, number, amount, owner, bizOrder} = objectToUnpack
	const ownerId = owner ? owner.id : null
	const bizOrderId = bizOrder ? bizOrder.id : null
	const data = {occureTime:moment(occureTime), number, amount, ownerId, bizOrderId}
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
const RetailStoreMemberGiftCardConsumeRecordBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default RetailStoreMemberGiftCardConsumeRecordBase

