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
const menuData = {menuName:"供应商的产品", menuFor: "supplierProduct",
  		subItems: [
  {name: 'productSupplyDurationList', displayName:'产品供应时间', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('supplier_product'), menuFor: "supplierProduct",
  		subItems: [
  {name: 'productSupplyDurationList', displayName: window.mtrans('product_supply_duration','supplier_product.product_supply_duration_list',false), type:'productSupplyDuration',icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD
=======

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

const renderItemOfList=(supplierProduct,targetComponent)=>{

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
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"供应商的产品", menuFor: "supplierProduct",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  productName: '品名',
  productDescription: '产品描述',
  productUnit: '产品单元',
  supplier: '供应商',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'supplierProduct') , sorter: true },
  { title: fieldLabels.productName, debugtype: 'string', dataIndex: 'productName', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.productDescription, debugtype: 'string', dataIndex: 'productDescription', width: '17',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.productUnit, debugtype: 'string', dataIndex: 'productUnit', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.supplier, dataIndex: 'supplier', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(supplierProduct,targetComponent)=>{

  const userContext = null
  return (
    <div key={supplierProduct.id}>
	
      <DescriptionList  key={supplierProduct.id} size="small" col="4">
        <Description term="序号">{supplierProduct.id}</Description> 
        <Description term="品名">{supplierProduct.productName}</Description> 
        <Description term="产品描述">{supplierProduct.productDescription}</Description> 
        <Description term="产品单元">{supplierProduct.productUnit}</Description> 
        <Description term="供应商"><div>{supplierProduct.supplier==null?appLocaleName(userContext,"NotAssigned"):`${supplierProduct.supplier.displayName}(${supplierProduct.supplier.id})`}
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
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {productName, productDescription, productUnit, supplierId} = formValuesToPack
	const supplier = {id: supplierId, version: 2^31}
	const data = {productName, productDescription, productUnit, supplier}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {productName, productDescription, productUnit, supplier} = objectToUnpack
	const supplierId = supplier ? supplier.id : null
	const data = {productName, productDescription, productUnit, supplierId}
	return data
}
<<<<<<< HEAD

const SupplierProductBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
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
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default SupplierProductBase



