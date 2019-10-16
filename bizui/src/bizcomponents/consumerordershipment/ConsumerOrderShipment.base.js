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


const menuData = {menuName:"消费者的订单发货", menuFor: "consumerOrderShipment",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"消费者的订单发货", menuFor: "consumerOrderShipment",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  who: '谁',
  shipTime: '船的时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'consumerOrderShipment') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.shipTime, dataIndex: 'shipTime', render: (text, record) =>renderDateCell(text,record), sorter: true },

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(consumerOrderShipment,targetComponent)=>{

  const userContext = null
  return (
    <div key={consumerOrderShipment.id}>
	
      <DescriptionList  key={consumerOrderShipment.id} size="small" col="4">
        <Description term="序号">{consumerOrderShipment.id}</Description> 
        <Description term="谁">{consumerOrderShipment.who}</Description> 
        <Description term="船的时间"><div>{ moment(consumerOrderShipment.shipTime).format('YYYY-MM-DD')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, shipTime} = formValuesToPack

	const data = {who, shipTime}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, shipTime} = objectToUnpack

	const data = {who, shipTime}
	return data
}

const ConsumerOrderShipmentBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
export default ConsumerOrderShipmentBase



