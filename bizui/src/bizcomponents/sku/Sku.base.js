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
const menuData = {menuName:"SKU", menuFor: "sku",
  		subItems: [
  {name: 'goodsList', displayName:'货物', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('sku'), menuFor: "sku",
  		subItems: [
  {name: 'goodsList', displayName: window.mtrans('goods','sku.goods_list',false), type:'goods',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD
=======

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
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"SKU", menuFor: "sku",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  name: '名称',
  size: '大小',
  product: '产品',
  barcode: '条码',
  packageType: '包装类型',
  netContent: '净含量',
  price: '价格',
  picture: '图片',

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
  { title: fieldLabels.picture, dataIndex: 'picture', render: (text, record) => renderImageCell(text,record,'图片') },

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(sku,targetComponent)=>{

  const userContext = null
  return (
    <div key={sku.id}>
	
      <DescriptionList  key={sku.id} size="small" col="4">
        <Description term="序号">{sku.id}</Description> 
        <Description term="名称">{sku.name}</Description> 
        <Description term="大小">{sku.size}</Description> 
        <Description term="产品"><div>{sku.product==null?appLocaleName(userContext,"NotAssigned"):`${sku.product.displayName}(${sku.product.id})`}
        </div></Description>
        <Description term="条码">{sku.barcode}</Description> 
        <Description term="包装类型">{sku.packageType}</Description> 
        <Description term="净含量">{sku.netContent}</Description> 
        <Description term="价格"><div style={{"color":"red"}}>{sku.price}</div></Description> 
	
        
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
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, size, barcode, packageType, netContent, price, productId} = formValuesToPack
	const product = {id: productId, version: 2^31}
	const data = {name, size, barcode, packageType, netContent, price, product}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, size, barcode, packageType, netContent, price, product} = objectToUnpack
	const productId = product ? product.id : null
	const data = {name, size, barcode, packageType, netContent, price, productId}
	return data
}
<<<<<<< HEAD

const SkuBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const SkuBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default SkuBase



