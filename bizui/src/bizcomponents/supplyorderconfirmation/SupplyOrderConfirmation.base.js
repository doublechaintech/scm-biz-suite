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


const menuData = {menuName:"供应订单确认", menuFor: "supplyOrderConfirmation",
  		subItems: [
  {name: 'consumerOrderList', displayName:'消费者订单', icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'supplyOrderList', displayName:'供应订单', icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: '序号',
  who: '谁',
  confirmTime: '确认时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'supplyOrderConfirmation') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.confirmTime, dataIndex: 'confirmTime', render: (text, record) =>renderDateCell(text,record), sorter: true },

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(supplyOrderConfirmation,targetComponent)=>{

  const userContext = null
  return (
    <div key={supplyOrderConfirmation.id}>
	
      <DescriptionList  key={supplyOrderConfirmation.id} size="small" col="4">
        <Description term="序号">{supplyOrderConfirmation.id}</Description> 
        <Description term="谁">{supplyOrderConfirmation.who}</Description> 
        <Description term="确认时间"><div>{ moment(supplyOrderConfirmation.confirmTime).format('YYYY-MM-DD')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const SupplyOrderConfirmationBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default SupplyOrderConfirmationBase



