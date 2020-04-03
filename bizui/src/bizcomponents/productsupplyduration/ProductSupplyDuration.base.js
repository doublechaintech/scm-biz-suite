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
import styles from './ProductSupplyDuration.base.less'
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
  { title: fieldLabels.quantity, dataIndex: 'quantity', className:'money', render: (text, record) => renderTextCell(text, record), sorter: true  },
  { title: fieldLabels.duration, debugtype: 'string', dataIndex: 'duration', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.price, dataIndex: 'price', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.product, dataIndex: 'product', render: (text, record) => renderReferenceCell(text, record), sorter:true},

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
const renderItemOfList=(productSupplyDuration, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={productSupplyDuration.id} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(productSupplyDuration.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={productSupplyDuration.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{productSupplyDuration.id}</Description> 
        <Description term={fieldLabels.quantity}><div style={{"color":"red"}}>{productSupplyDuration.quantity}</div></Description> 
        <Description term={fieldLabels.duration} style={{wordBreak: 'break-all'}}>{productSupplyDuration.duration}</Description> 
        <Description term={fieldLabels.price}><div style={{"color":"red"}}>{productSupplyDuration.price}</div></Description> 
        <Description term={fieldLabels.product}><Tag color='blue' title={`${productSupplyDuration.product.id}-${productSupplyDuration.product.displayName}`}>{productSupplyDuration.product==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(productSupplyDuration.product.displayName,15)}`}
        </Tag></Description>
	
        
      </DescriptionList>
     </Col>
    </Card>
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
const ProductSupplyDurationBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default ProductSupplyDurationBase

