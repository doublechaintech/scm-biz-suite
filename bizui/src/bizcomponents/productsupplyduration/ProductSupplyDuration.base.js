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
const menuData = {menuName:"产品供应时间", menuFor: "productSupplyDuration",
=======

const menuData = {menuName: window.trans('product_supply_duration'), menuFor: "productSupplyDuration",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD
=======

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
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"产品供应时间", menuFor: "productSupplyDuration",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  quantity: '数量',
  duration: '持续时间',
  price: '价格',
  product: '产品',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'productSupplyDuration') , sorter: true },
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
        <Description term="序号">{productSupplyDuration.id}</Description> 
        <Description term="数量"><div style={{"color":"red"}}>{productSupplyDuration.quantity}</div></Description> 
        <Description term="持续时间">{productSupplyDuration.duration}</Description> 
        <Description term="价格"><div style={{"color":"red"}}>{productSupplyDuration.price}</div></Description> 
        <Description term="产品"><div>{productSupplyDuration.product==null?appLocaleName(userContext,"NotAssigned"):`${productSupplyDuration.product.displayName}(${productSupplyDuration.product.id})`}
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
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {quantity, duration, price, productId} = formValuesToPack
	const product = {id: productId, version: 2^31}
	const data = {quantity, duration, price, product}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {quantity, duration, price, product} = objectToUnpack
	const productId = product ? product.id : null
	const data = {quantity, duration, price, productId}
	return data
}
<<<<<<< HEAD

const ProductSupplyDurationBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const ProductSupplyDurationBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default ProductSupplyDurationBase



