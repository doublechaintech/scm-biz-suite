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
const menuData = {menuName:"产品", menuFor: "product",
  		subItems: [
  {name: 'skuList', displayName:'SKU', icon:'skull',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('product'), menuFor: "product",
  		subItems: [
  {name: 'skuList', displayName: window.mtrans('sku','product.sku_list',false), type:'sku',icon:'skull',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('product'), menuFor: "product",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('product.id'),
  name: window.trans('product.name'),
  parentCategory: window.trans('product.parent_category'),
  origin: window.trans('product.origin'),
  remark: window.trans('product.remark'),
  brand: window.trans('product.brand'),
  picture: window.trans('product.picture'),
  lastUpdateTime: window.trans('product.last_update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'product') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.parentCategory, dataIndex: 'parentCategory', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.origin, debugtype: 'string', dataIndex: 'origin', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.remark, debugtype: 'string', dataIndex: 'remark', width: '26',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.brand, debugtype: 'string', dataIndex: 'brand', width: '27',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.picture, dataIndex: 'picture', render: (text, record) => renderImageCell(text,record,'product.picture') },
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(product,targetComponent)=>{

  const userContext = null
  return (
    <div key={product.id}>
	
      <DescriptionList  key={product.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{product.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{product.name}</Description> 
        <Description term={fieldLabels.parentCategory}><div>{product.parentCategory==null?appLocaleName(userContext,"NotAssigned"):`${product.parentCategory.displayName}(${product.parentCategory.id})`}
        </div></Description>
        <Description term={fieldLabels.origin} style={{wordBreak: 'break-all'}}>{product.origin}</Description> 
        <Description term={fieldLabels.remark} style={{wordBreak: 'break-all'}}>{product.remark}</Description> 
        <Description term={fieldLabels.brand} style={{wordBreak: 'break-all'}}>{product.brand}</Description> 
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(product.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"产品", menuFor: "product",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  name: '名称',
  parentCategory: '父类',
  origin: '产地',
  remark: '备注',
  brand: '品牌',
  picture: '图片',
  lastUpdateTime: '最后更新时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'product') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.parentCategory, dataIndex: 'parentCategory', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.origin, debugtype: 'string', dataIndex: 'origin', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.remark, debugtype: 'string', dataIndex: 'remark', width: '26',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.brand, debugtype: 'string', dataIndex: 'brand', width: '27',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.picture, dataIndex: 'picture', render: (text, record) => renderImageCell(text,record,'图片') },
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(product,targetComponent)=>{

  const userContext = null
  return (
    <div key={product.id}>
	
      <DescriptionList  key={product.id} size="small" col="4">
        <Description term="序号">{product.id}</Description> 
        <Description term="名称">{product.name}</Description> 
        <Description term="父类"><div>{product.parentCategory==null?appLocaleName(userContext,"NotAssigned"):`${product.parentCategory.displayName}(${product.parentCategory.id})`}
        </div></Description>
        <Description term="产地">{product.origin}</Description> 
        <Description term="备注">{product.remark}</Description> 
        <Description term="品牌">{product.brand}</Description> 
        <Description term="最后更新时间"><div>{ moment(product.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, origin, remark, brand, parentCategoryId} = formValuesToPack
	const parentCategory = {id: parentCategoryId, version: 2^31}
	const data = {name, origin, remark, brand, parentCategory}
	return data
}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, origin, remark, brand, parentCategoryId} = formValuesToPack
	const parentCategory = {id: parentCategoryId, version: 2^31}
	const data = {name, origin, remark, brand, parentCategory}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, origin, remark, brand, parentCategory} = objectToUnpack
	const parentCategoryId = parentCategory ? parentCategory.id : null
	const data = {name, origin, remark, brand, parentCategoryId}
	return data
}
<<<<<<< HEAD

const ProductBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const ProductBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default ProductBase



