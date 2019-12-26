import React from 'react'
<<<<<<< HEAD
import { Icon,Divider } from 'antd'
=======
import { Icon,Divider, Avata, Card, Col} from 'antd'
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
<<<<<<< HEAD
=======

>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
<<<<<<< HEAD
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
=======
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
	defaultSearchLocalData,
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
<<<<<<< HEAD
=======
const renderAvatarCell=defaultRenderAvatarCell
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


<<<<<<< HEAD
const menuData = {menuName:"供应货", menuFor: "supplyOrderShipment",
  		subItems: [
  {name: 'consumerOrderList', displayName:'消费者订单', icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'supplyOrderList', displayName:'供应订单', icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('supply_order_shipment'), menuFor: "supplyOrderShipment",
  		subItems: [
  {name: 'consumerOrderList', displayName: window.mtrans('consumer_order','supply_order_shipment.consumer_order_list',false), type:'consumerOrder',icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'supplyOrderList', displayName: window.mtrans('supply_order','supply_order_shipment.supply_order_list',false), type:'supplyOrder',icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}


<<<<<<< HEAD
const settingMenuData = {menuName:"供应货", menuFor: "supplyOrderShipment",
=======
const settingMenuData = {menuName: window.trans('supply_order_shipment'), menuFor: "supplyOrderShipment",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

const fieldLabels = {
<<<<<<< HEAD
  id: '序号',
  who: '谁',
  shipTime: '船的时间',
=======
  id: window.trans('supply_order_shipment.id'),
  who: window.trans('supply_order_shipment.who'),
  shipTime: window.trans('supply_order_shipment.ship_time'),
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'supplyOrderShipment') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.shipTime, dataIndex: 'shipTime', render: (text, record) =>renderDateCell(text,record), sorter: true },

]
<<<<<<< HEAD
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(supplyOrderShipment,targetComponent)=>{

  const userContext = null
  return (
    <div key={supplyOrderShipment.id}>
	
      <DescriptionList  key={supplyOrderShipment.id} size="small" col="4">
        <Description term="序号">{supplyOrderShipment.id}</Description> 
        <Description term="谁">{supplyOrderShipment.who}</Description> 
        <Description term="船的时间"><div>{ moment(supplyOrderShipment.shipTime).format('YYYY-MM-DD')}</div></Description> 
	
        
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
=======


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(supplyOrderShipment,targetComponent)=>{

  const userContext = null
  return (
    <div key={supplyOrderShipment.id}>
	
      <DescriptionList  key={supplyOrderShipment.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{supplyOrderShipment.id}</Description> 
        <Description term={fieldLabels.who} style={{wordBreak: 'break-all'}}>{supplyOrderShipment.who}</Description> 
        <Description term={fieldLabels.shipTime}><div>{ moment(supplyOrderShipment.shipTime).format('YYYY-MM-DD')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, shipTime} = formValuesToPack
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

	const data = {who, shipTime}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, shipTime} = objectToUnpack

<<<<<<< HEAD
const SupplyOrderShipmentBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
	const data = {who, shipTime}
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
const SupplyOrderShipmentBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default SupplyOrderShipmentBase



