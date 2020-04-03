import React from 'react'
import { Icon,Divider, Avatar, Card, Col, Tag} from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
import styles from './GoodsSupplier.base.less'
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



const menuData = {menuName: window.trans('goods_supplier'), menuFor: "goodsSupplier",
  		subItems: [
  {name: 'supplierProductList', displayName: window.mtrans('supplier_product','goods_supplier.supplier_product_list',false), type:'supplierProduct',icon:'product-hunt',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'supplyOrderList', displayName: window.mtrans('supply_order','goods_supplier.supply_order_list',false), type:'supplyOrder',icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'accountSetList', displayName: window.mtrans('account_set','goods_supplier.account_set_list',false), type:'accountSet',icon:'headset',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('goods_supplier'), menuFor: "goodsSupplier",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('goods_supplier.id'),
  name: window.trans('goods_supplier.name'),
  supplyProduct: window.trans('goods_supplier.supply_product'),
  belongTo: window.trans('goods_supplier.belong_to'),
  contactNumber: window.trans('goods_supplier.contact_number'),
  description: window.trans('goods_supplier.description'),
  lastUpdateTime: window.trans('goods_supplier.last_update_time'),

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


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)
const colorList = ['#f56a00', '#7265e6', '#ffbf00', '#00a2ae'];
let counter = 0;
const genColor=()=>{
	counter++;
	return colorList[counter%colorList.length];
}
const followColor=()=>{
	return 'green';
	// return colorList[counter%colorList.length];
}
const leftChars=(value, left)=>{
	const chars = left || 4
	if(!value){
		return "N/A"
	}
	return value.substring(0,chars);
}
const renderItemOfList=(goodsSupplier, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={goodsSupplier.id} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(goodsSupplier.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={goodsSupplier.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{goodsSupplier.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{goodsSupplier.name}</Description> 
        <Description term={fieldLabels.supplyProduct} style={{wordBreak: 'break-all'}}>{goodsSupplier.supplyProduct}</Description> 
        <Description term={fieldLabels.contactNumber} style={{wordBreak: 'break-all'}}>{goodsSupplier.contactNumber}</Description> 
        <Description term={fieldLabels.description} style={{wordBreak: 'break-all'}}>{goodsSupplier.description}</Description> 
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(goodsSupplier.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
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
const GoodsSupplierBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default GoodsSupplierBase

