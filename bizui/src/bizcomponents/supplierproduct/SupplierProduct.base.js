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


const menuData = {menuName:"供应商的产品", menuFor: "supplierProduct",
  		subItems: [
  {name: 'productSupplyDurationList', displayName:'产品供应时间', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"供应商的产品", menuFor: "supplierProduct",
  		subItems: [
  
  		],
}

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
	



const SupplierProductBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default SupplierProductBase



