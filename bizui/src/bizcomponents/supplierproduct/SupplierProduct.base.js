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
import styles from './SupplierProduct.base.less'
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



const menuData = {menuName: window.trans('supplier_product'), menuFor: "supplierProduct",
  		subItems: [
  {name: 'productSupplyDurationList', displayName: window.mtrans('product_supply_duration','supplier_product.product_supply_duration_list',false), type:'productSupplyDuration',icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('supplier_product'), menuFor: "supplierProduct",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('supplier_product.id'),
  productName: window.trans('supplier_product.product_name'),
  productDescription: window.trans('supplier_product.product_description'),
  productUnit: window.trans('supplier_product.product_unit'),
  supplier: window.trans('supplier_product.supplier'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'supplierProduct') , sorter: true },
  { title: fieldLabels.productName, debugtype: 'string', dataIndex: 'productName', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.productDescription, debugtype: 'string', dataIndex: 'productDescription', width: '17',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.productUnit, debugtype: 'string', dataIndex: 'productUnit', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.supplier, dataIndex: 'supplier', render: (text, record) => renderReferenceCell(text, record), sorter:true},

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

const renderReferenceItem=(value, targetComponent)=>{
	const userContext = null
	if(!value){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.id){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.displayName){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	
	return <Tag color='blue' title={`${value.displayName}()`}>{leftChars(value.displayName)}</Tag>
	
	
	
	
}
const renderItemOfList=(supplierProduct, targetComponent, columCount)=>{
  
  if(!supplierProduct){
  	return null
  }
  if(!supplierProduct.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`supplierProduct-${supplierProduct.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(supplierProduct.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={supplierProduct.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{supplierProduct.id}</Description> 
        <Description term={fieldLabels.productName} style={{wordBreak: 'break-all'}}>{supplierProduct.productName}</Description> 
        <Description term={fieldLabels.productDescription} style={{wordBreak: 'break-all'}}>{supplierProduct.productDescription}</Description> 
        <Description term={fieldLabels.productUnit} style={{wordBreak: 'break-all'}}>{supplierProduct.productUnit}</Description> 
        <Description term={fieldLabels.supplier}>{renderReferenceItem(supplierProduct.supplier)}</Description>

	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {productName, productDescription, productUnit, supplierId} = formValuesToPack
	const supplier = {id: supplierId, version: 2^31}
	const data = {productName, productDescription, productUnit, supplier}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {productName, productDescription, productUnit, supplier} = objectToUnpack
	const supplierId = supplier ? supplier.id : null
	const data = {productName, productDescription, productUnit, supplierId}
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
const SupplierProductBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default SupplierProductBase

