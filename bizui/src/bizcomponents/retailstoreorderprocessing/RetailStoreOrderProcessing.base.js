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
const menuData = {menuName:"生超订单处理", menuFor: "retailStoreOrderProcessing",
  		subItems: [
  {name: 'retailStoreOrderList', displayName:'生超的订单', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('retail_store_order_processing'), menuFor: "retailStoreOrderProcessing",
  		subItems: [
  {name: 'retailStoreOrderList', displayName: window.mtrans('retail_store_order','retail_store_order_processing.retail_store_order_list',false), type:'retailStoreOrder',icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}


<<<<<<< HEAD
const settingMenuData = {menuName:"生超订单处理", menuFor: "retailStoreOrderProcessing",
=======
const settingMenuData = {menuName: window.trans('retail_store_order_processing'), menuFor: "retailStoreOrderProcessing",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

const fieldLabels = {
<<<<<<< HEAD
  id: '序号',
  who: '谁',
  processTime: '过程的时间',
=======
  id: window.trans('retail_store_order_processing.id'),
  who: window.trans('retail_store_order_processing.who'),
  processTime: window.trans('retail_store_order_processing.process_time'),
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStoreOrderProcessing') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.processTime, dataIndex: 'processTime', render: (text, record) =>renderDateCell(text,record), sorter: true },

]
<<<<<<< HEAD
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(retailStoreOrderProcessing,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreOrderProcessing.id}>
	
      <DescriptionList  key={retailStoreOrderProcessing.id} size="small" col="4">
        <Description term="序号">{retailStoreOrderProcessing.id}</Description> 
        <Description term="谁">{retailStoreOrderProcessing.who}</Description> 
        <Description term="过程的时间"><div>{ moment(retailStoreOrderProcessing.processTime).format('YYYY-MM-DD')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, processTime} = formValuesToPack

	const data = {who, processTime}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, processTime} = objectToUnpack
=======


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(retailStoreOrderProcessing,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreOrderProcessing.id}>
	
      <DescriptionList  key={retailStoreOrderProcessing.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{retailStoreOrderProcessing.id}</Description> 
        <Description term={fieldLabels.who} style={{wordBreak: 'break-all'}}>{retailStoreOrderProcessing.who}</Description> 
        <Description term={fieldLabels.processTime}><div>{ moment(retailStoreOrderProcessing.processTime).format('YYYY-MM-DD')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, processTime} = formValuesToPack
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

	const data = {who, processTime}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, processTime} = objectToUnpack

<<<<<<< HEAD
const RetailStoreOrderProcessingBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
	const data = {who, processTime}
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
const RetailStoreOrderProcessingBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default RetailStoreOrderProcessingBase



