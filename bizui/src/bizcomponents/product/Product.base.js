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


const menuData = {menuName:"Product", menuFor: "product",
  		subItems: [
  {name: 'skuList', displayName:'Sku', icon:'skull',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  parentCategory: 'Parent Category',
  origin: 'Origin',
  remark: 'Remark',
  brand: 'Brand',
  picture: 'Picture',
  lastUpdateTime: 'Last Update Time',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'product') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.parentCategory, dataIndex: 'parentCategory', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.origin, debugtype: 'string', dataIndex: 'origin', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.remark, debugtype: 'string', dataIndex: 'remark', width: '26',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.brand, debugtype: 'string', dataIndex: 'brand', width: '27',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.picture, dataIndex: 'picture', render: (text, record) => renderImageCell(text,record,'Picture') },
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(product,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={product.id}>
	
	<DescriptionList  key={product.id} size="small" col="4">
<Description term="Id">{product.id}</Description> 
<Description term="Name">{product.name}</Description> 
<Description term="Parent Category">{product.parentCategory==null?appLocaleName(userContext,"NotAssigned"):`${product.parentCategory.displayName}(${product.parentCategory.id})`}
</Description>
<Description term="Origin">{product.origin}</Description> 
<Description term="Remark">{product.remark}</Description> 
<Description term="Brand">{product.brand}</Description> 
<Description term="Last Update Time">{ moment(product.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const ProductBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default ProductBase



