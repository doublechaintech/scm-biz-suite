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


const menuData = {menuName:"零售店会员地址", menuFor: "retailStoreMemberAddress",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  owner: '业主',
  mobilePhone: '移动电话',
  address: '地址',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.mobilePhone, debugtype: 'string_china_mobile_phone', dataIndex: 'mobilePhone', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.address, debugtype: 'string', dataIndex: 'address', width: '18',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(retailStoreMemberAddress,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={retailStoreMemberAddress.id}>
	
	<DescriptionList  key={retailStoreMemberAddress.id} size="small" col="4">
<Description term="序号">{retailStoreMemberAddress.id}</Description> 
<Description term="名称">{retailStoreMemberAddress.name}</Description> 
<Description term="业主">{retailStoreMemberAddress.owner==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreMemberAddress.owner.displayName}(${retailStoreMemberAddress.owner.id})`}
</Description>
<Description term="移动电话">{retailStoreMemberAddress.mobilePhone}</Description> 
<Description term="地址">{retailStoreMemberAddress.address}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const RetailStoreMemberAddressBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default RetailStoreMemberAddressBase



