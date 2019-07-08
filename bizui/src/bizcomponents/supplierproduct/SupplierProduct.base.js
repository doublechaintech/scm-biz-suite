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


const menuData = {menuName:"Supplier Product", menuFor: "supplierProduct",
  		subItems: [
  {name: 'productSupplyDurationList', displayName:'Product Supply Duration', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'Id',
  productName: 'Product Name',
  productDescription: 'Product Description',
  productUnit: 'Product Unit',
  supplier: 'Supplier',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'supplierProduct') , sorter: true },
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
<Description term="Id">{supplierProduct.id}</Description> 
<Description term="Product Name">{supplierProduct.productName}</Description> 
<Description term="Product Description">{supplierProduct.productDescription}</Description> 
<Description term="Product Unit">{supplierProduct.productUnit}</Description> 
<Description term="Supplier">{supplierProduct.supplier==null?appLocaleName(userContext,"NotAssigned"):`${supplierProduct.supplier.displayName}(${supplierProduct.supplier.id})`}
</Description>
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const SupplierProductBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default SupplierProductBase



