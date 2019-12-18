import React from 'react'
import { Icon,Divider, Avata, Card, Col} from 'antd'

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



const menuData = {menuName: window.trans('supply_order_delivery'), menuFor: "supplyOrderDelivery",
  		subItems: [
  {name: 'consumerOrderList', displayName: window.mtrans('consumer_order','supply_order_delivery.consumer_order_list',false), type:'consumerOrder',icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'supplyOrderList', displayName: window.mtrans('supply_order','supply_order_delivery.supply_order_list',false), type:'supplyOrder',icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('supply_order_delivery'), menuFor: "supplyOrderDelivery",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('supply_order_delivery.id'),
  who: window.trans('supply_order_delivery.who'),
  deliveryTime: window.trans('supply_order_delivery.delivery_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'supplyOrderDelivery') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.deliveryTime, dataIndex: 'deliveryTime', render: (text, record) =>renderDateCell(text,record), sorter: true },

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(supplyOrderDelivery,targetComponent)=>{

  const userContext = null
  return (
    <div key={supplyOrderDelivery.id}>
	
      <DescriptionList  key={supplyOrderDelivery.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{supplyOrderDelivery.id}</Description> 
        <Description term={fieldLabels.who} style={{wordBreak: 'break-all'}}>{supplyOrderDelivery.who}</Description> 
        <Description term={fieldLabels.deliveryTime}><div>{ moment(supplyOrderDelivery.deliveryTime).format('YYYY-MM-DD')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, deliveryTime} = formValuesToPack

	const data = {who, deliveryTime}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, deliveryTime} = objectToUnpack

	const data = {who, deliveryTime}
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
const SupplyOrderDeliveryBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default SupplyOrderDeliveryBase



