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



const menuData = {menuName: window.trans('product_supply_duration'), menuFor: "productSupplyDuration",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('product_supply_duration'), menuFor: "productSupplyDuration",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('product_supply_duration.id'),
  quantity: window.trans('product_supply_duration.quantity'),
  duration: window.trans('product_supply_duration.duration'),
  price: window.trans('product_supply_duration.price'),
  product: window.trans('product_supply_duration.product'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'productSupplyDuration') , sorter: true },
  { title: fieldLabels.quantity, debugtype: 'int', dataIndex: 'quantity', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.duration, debugtype: 'string', dataIndex: 'duration', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.price, dataIndex: 'price', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.product, dataIndex: 'product', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(productSupplyDuration,targetComponent)=>{

  const userContext = null
  return (
    <div key={productSupplyDuration.id}>
	
      <DescriptionList  key={productSupplyDuration.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{productSupplyDuration.id}</Description> 
        <Description term={fieldLabels.quantity}><div style={{"color":"red"}}>{productSupplyDuration.quantity}</div></Description> 
        <Description term={fieldLabels.duration} style={{wordBreak: 'break-all'}}>{productSupplyDuration.duration}</Description> 
        <Description term={fieldLabels.price}><div style={{"color":"red"}}>{productSupplyDuration.price}</div></Description> 
        <Description term={fieldLabels.product}><div>{productSupplyDuration.product==null?appLocaleName(userContext,"NotAssigned"):`${productSupplyDuration.product.displayName}(${productSupplyDuration.product.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {quantity, duration, price, productId} = formValuesToPack
	const product = {id: productId, version: 2^31}
	const data = {quantity, duration, price, product}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {quantity, duration, price, product} = objectToUnpack
	const productId = product ? product.id : null
	const data = {quantity, duration, price, productId}
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
const ProductSupplyDurationBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default ProductSupplyDurationBase



