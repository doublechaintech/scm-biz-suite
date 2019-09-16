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


const menuData = {menuName:"零售店会员礼品卡", menuFor: "retailStoreMemberGiftCard",
  		subItems: [
  {name: 'retailStoreMemberGiftCardConsumeRecordList', displayName:'零售商店会员卡消费记录', icon:'gift',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"零售店会员礼品卡", menuFor: "retailStoreMemberGiftCard",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  owner: '业主',
  number: '数',
  remain: '保持',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStoreMemberGiftCard') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.number, debugtype: 'string', dataIndex: 'number', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.remain, dataIndex: 'remain', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(retailStoreMemberGiftCard,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreMemberGiftCard.id}>
	
      <DescriptionList  key={retailStoreMemberGiftCard.id} size="small" col="4">
        <Description term="序号">{retailStoreMemberGiftCard.id}</Description> 
        <Description term="名称">{retailStoreMemberGiftCard.name}</Description> 
        <Description term="业主"><div>{retailStoreMemberGiftCard.owner==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreMemberGiftCard.owner.displayName}(${retailStoreMemberGiftCard.owner.id})`}
        </div></Description>
        <Description term="数">{retailStoreMemberGiftCard.number}</Description> 
        <Description term="保持"><div style={{"color":"red"}}>{retailStoreMemberGiftCard.remain}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const RetailStoreMemberGiftCardBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default RetailStoreMemberGiftCardBase



