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


const menuData = {menuName:"Retail Store Member Coupon", menuFor: "retailStoreMemberCoupon",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  owner: 'Owner',
  number: 'Number',
  lastUpdateTime: 'Last Update Time',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.number, debugtype: 'string', dataIndex: 'number', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(retailStoreMemberCoupon,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={retailStoreMemberCoupon.id}>
	
	<DescriptionList  key={retailStoreMemberCoupon.id} size="small" col="4">
<Description term="Id">{retailStoreMemberCoupon.id}</Description> 
<Description term="Name">{retailStoreMemberCoupon.name}</Description> 
<Description term="Owner">{retailStoreMemberCoupon.owner==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreMemberCoupon.owner.displayName}(${retailStoreMemberCoupon.owner.id})`}
</Description>
<Description term="Number">{retailStoreMemberCoupon.number}</Description> 
<Description term="Last Update Time">{ moment(retailStoreMemberCoupon.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const RetailStoreMemberCouponBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default RetailStoreMemberCouponBase



