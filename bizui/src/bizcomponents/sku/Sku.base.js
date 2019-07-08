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


const menuData = {menuName:"Sku", menuFor: "sku",
  		subItems: [
  {name: 'goodsList', displayName:'Goods', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  size: 'Size',
  product: 'Product',
  barcode: 'Barcode',
  packageType: 'Package Type',
  netContent: 'Net Content',
  price: 'Price',
  picture: 'Picture',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'sku') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.size, debugtype: 'string', dataIndex: 'size', width: '5',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.product, dataIndex: 'product', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.barcode, debugtype: 'string', dataIndex: 'barcode', width: '17',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.packageType, debugtype: 'string', dataIndex: 'packageType', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.netContent, debugtype: 'string', dataIndex: 'netContent', width: '27',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.price, dataIndex: 'price', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.picture, dataIndex: 'picture', render: (text, record) => renderImageCell(text,record,'Picture') },

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(sku,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={sku.id}>
	
	<DescriptionList  key={sku.id} size="small" col="4">
<Description term="Id">{sku.id}</Description> 
<Description term="Name">{sku.name}</Description> 
<Description term="Size">{sku.size}</Description> 
<Description term="Product">{sku.product==null?appLocaleName(userContext,"NotAssigned"):`${sku.product.displayName}(${sku.product.id})`}
</Description>
<Description term="Barcode">{sku.barcode}</Description> 
<Description term="Package Type">{sku.packageType}</Description> 
<Description term="Net Content">{sku.netContent}</Description> 
<Description term="Price">{sku.price}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const SkuBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default SkuBase



