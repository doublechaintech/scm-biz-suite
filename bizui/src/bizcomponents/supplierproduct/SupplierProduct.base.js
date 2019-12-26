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

const renderItemOfList=(supplierProduct, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
  const userContext = null
  return (
    <div key={supplierProduct.id}>
	
      <DescriptionList  key={supplierProduct.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{supplierProduct.id}</Description> 
        <Description term={fieldLabels.productName} style={{wordBreak: 'break-all'}}>{supplierProduct.productName}</Description> 
        <Description term={fieldLabels.productDescription} style={{wordBreak: 'break-all'}}>{supplierProduct.productDescription}</Description> 
        <Description term={fieldLabels.productUnit} style={{wordBreak: 'break-all'}}>{supplierProduct.productUnit}</Description> 
        <Description term={fieldLabels.supplier}><div>{supplierProduct.supplier==null?appLocaleName(userContext,"NotAssigned"):`${supplierProduct.supplier.displayName}(${supplierProduct.supplier.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
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
const SupplierProductBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default SupplierProductBase



