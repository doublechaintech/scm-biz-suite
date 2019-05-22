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


const menuData = {menuName:"供应订单送货分组", menuFor: "supplyOrderShippingGroup",
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
const renderItemOfList=({supplyOrderShippingGroup,targetComponent})=>{

	
	
	const {SupplyOrderShippingGroupService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{supplyOrderShippingGroup.id}</Description> 
<Description term="名称">{supplyOrderShippingGroup.name}</Description> 
<Description term="订单">{supplyOrderShippingGroup.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${supplyOrderShippingGroup.bizOrder.displayName}(${supplyOrderShippingGroup.bizOrder.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"订单","supplyOrder",SupplyOrderShippingGroupService.requestCandidateBizOrder,
	      SupplyOrderShippingGroupService.transferToAnotherBizOrder,"anotherBizOrderId",supplyOrderShippingGroup.bizOrder?supplyOrderShippingGroup.bizOrder.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="金额">{supplyOrderShippingGroup.amount}</Description> 
	
        {buildTransferModal(supplyOrderShippingGroup,targetComponent)}
      </DescriptionList>
	)

}
	



const SupplyOrderShippingGroupBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default SupplyOrderShippingGroupBase



