import React from 'react'
import { Icon } from 'antd'
import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'

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


const menuData = {menuName:"生超订单送货分组", menuFor: "retailStoreOrderShippingGroup",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  bizOrder: '订单',
  amount: '金额',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.bizOrder, dataIndex: 'bizOrder', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.amount, dataIndex: 'amount', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=({retailStoreOrderShippingGroup,targetComponent})=>{

	
	
	const {RetailStoreOrderShippingGroupService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreOrderShippingGroup.id}</Description> 
<Description term="名称">{retailStoreOrderShippingGroup.name}</Description> 
<Description term="订单">{retailStoreOrderShippingGroup.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreOrderShippingGroup.bizOrder.displayName}(${retailStoreOrderShippingGroup.bizOrder.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"订单","retailStoreOrder",RetailStoreOrderShippingGroupService.requestCandidateBizOrder,
	      RetailStoreOrderShippingGroupService.transferToAnotherBizOrder,"anotherBizOrderId",retailStoreOrderShippingGroup.bizOrder?retailStoreOrderShippingGroup.bizOrder.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="金额">{retailStoreOrderShippingGroup.amount}</Description> 
	
        {buildTransferModal(retailStoreOrderShippingGroup,targetComponent)}
      </DescriptionList>
	)

}
	



const RetailStoreOrderShippingGroupBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default RetailStoreOrderShippingGroupBase



