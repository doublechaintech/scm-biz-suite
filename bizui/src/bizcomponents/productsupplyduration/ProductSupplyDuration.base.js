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


const menuData = {menuName:"Product Supply Duration", menuFor: "productSupplyDuration",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'Id',
  quantity: 'Quantity',
  duration: 'Duration',
  price: 'Price',
  product: 'Product',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.quantity, debugtype: 'int', dataIndex: 'quantity', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.duration, debugtype: 'string', dataIndex: 'duration', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.price, dataIndex: 'price', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.product, dataIndex: 'product', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(productSupplyDuration,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={productSupplyDuration.id}>
	
	<DescriptionList  key={productSupplyDuration.id} size="small" col="4">
<Description term="Id">{productSupplyDuration.id}</Description> 
<Description term="Quantity">{productSupplyDuration.quantity}</Description> 
<Description term="Duration">{productSupplyDuration.duration}</Description> 
<Description term="Price">{productSupplyDuration.price}</Description> 
<Description term="Product">{productSupplyDuration.product==null?appLocaleName(userContext,"NotAssigned"):`${productSupplyDuration.product.displayName}(${productSupplyDuration.product.id})`}
</Description>
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const ProductSupplyDurationBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default ProductSupplyDurationBase



