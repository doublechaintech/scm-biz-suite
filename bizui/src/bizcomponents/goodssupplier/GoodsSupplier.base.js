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


const menuData = {menuName:"产品供应商", menuFor: "goodsSupplier",
  		subItems: [
  {name: 'supplierProductList', displayName:'供应商的产品', icon:'product-hunt',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'supplyOrderList', displayName:'供应订单', icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'accountSetList', displayName:'账套', icon:'headset',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"产品供应商", menuFor: "goodsSupplier",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  supplyProduct: '供应产品',
  belongTo: '属于',
  contactNumber: '联系电话',
  description: '描述',
  lastUpdateTime: '最后更新时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'goodsSupplier') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.supplyProduct, debugtype: 'string', dataIndex: 'supplyProduct', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.belongTo, dataIndex: 'belongTo', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.contactNumber, debugtype: 'string_china_mobile_phone', dataIndex: 'contactNumber', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '22',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(goodsSupplier,targetComponent)=>{

  const userContext = null
  return (
    <div key={goodsSupplier.id}>
	
      <DescriptionList  key={goodsSupplier.id} size="small" col="4">
        <Description term="序号">{goodsSupplier.id}</Description> 
        <Description term="名称">{goodsSupplier.name}</Description> 
        <Description term="供应产品">{goodsSupplier.supplyProduct}</Description> 
        <Description term="联系电话">{goodsSupplier.contactNumber}</Description> 
        <Description term="描述">{goodsSupplier.description}</Description> 
        <Description term="最后更新时间"><div>{ moment(goodsSupplier.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, supplyProduct, contactNumber, description, belongToId} = formValuesToPack
	const belongTo = {id: belongToId, version: 2^31}
	const data = {name, supplyProduct, contactNumber, description, belongTo}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, supplyProduct, contactNumber, description, belongTo} = objectToUnpack
	const belongToId = belongTo ? belongTo.id : null
	const data = {name, supplyProduct, contactNumber, description, belongToId}
	return data
}

const GoodsSupplierBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
export default GoodsSupplierBase



