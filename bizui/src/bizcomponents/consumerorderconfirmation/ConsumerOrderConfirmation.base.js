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


const menuData = {menuName:"客户订单确认", menuFor: "consumerOrderConfirmation",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"客户订单确认", menuFor: "consumerOrderConfirmation",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  who: '谁',
  confirmTime: '确认时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'consumerOrderConfirmation') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.confirmTime, dataIndex: 'confirmTime', render: (text, record) =>renderDateCell(text,record), sorter: true },

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(consumerOrderConfirmation,targetComponent)=>{

  const userContext = null
  return (
    <div key={consumerOrderConfirmation.id}>
	
      <DescriptionList  key={consumerOrderConfirmation.id} size="small" col="4">
        <Description term="序号">{consumerOrderConfirmation.id}</Description> 
        <Description term="谁">{consumerOrderConfirmation.who}</Description> 
        <Description term="确认时间"><div>{ moment(consumerOrderConfirmation.confirmTime).format('YYYY-MM-DD')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, confirmTime} = formValuesToPack

	const data = {who, confirmTime}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, confirmTime} = objectToUnpack

	const data = {who, confirmTime}
	return data
}

const ConsumerOrderConfirmationBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
export default ConsumerOrderConfirmationBase



