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



const menuData = {menuName: window.trans('sku'), menuFor: "sku",
  		subItems: [
  {name: 'goodsList', displayName: window.mtrans('goods','sku.goods_list',false), type:'goods',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('sku'), menuFor: "sku",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('sku.id'),
  name: window.trans('sku.name'),
  size: window.trans('sku.size'),
  product: window.trans('sku.product'),
  barcode: window.trans('sku.barcode'),
  packageType: window.trans('sku.package_type'),
  netContent: window.trans('sku.net_content'),
  price: window.trans('sku.price'),
  picture: window.trans('sku.picture'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'sku') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.size, debugtype: 'string', dataIndex: 'size', width: '5',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.product, dataIndex: 'product', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.barcode, debugtype: 'string', dataIndex: 'barcode', width: '17',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.packageType, debugtype: 'string', dataIndex: 'packageType', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.netContent, debugtype: 'string', dataIndex: 'netContent', width: '27',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.price, dataIndex: 'price', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.picture, dataIndex: 'picture', render: (text, record) => renderImageCell(text,record,'sku.picture') },

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(sku,targetComponent)=>{

  const userContext = null
  return (
    <div key={sku.id}>
	
      <DescriptionList  key={sku.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{sku.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{sku.name}</Description> 
        <Description term={fieldLabels.size} style={{wordBreak: 'break-all'}}>{sku.size}</Description> 
        <Description term={fieldLabels.product}><div>{sku.product==null?appLocaleName(userContext,"NotAssigned"):`${sku.product.displayName}(${sku.product.id})`}
        </div></Description>
        <Description term={fieldLabels.barcode} style={{wordBreak: 'break-all'}}>{sku.barcode}</Description> 
        <Description term={fieldLabels.packageType} style={{wordBreak: 'break-all'}}>{sku.packageType}</Description> 
        <Description term={fieldLabels.netContent} style={{wordBreak: 'break-all'}}>{sku.netContent}</Description> 
        <Description term={fieldLabels.price}><div style={{"color":"red"}}>{sku.price}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, size, barcode, packageType, netContent, price, productId} = formValuesToPack
	const product = {id: productId, version: 2^31}
	const data = {name, size, barcode, packageType, netContent, price, product}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, size, barcode, packageType, netContent, price, product} = objectToUnpack
	const productId = product ? product.id : null
	const data = {name, size, barcode, packageType, netContent, price, productId}
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
const SkuBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default SkuBase



