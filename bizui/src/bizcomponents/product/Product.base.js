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
import styles from './Product.base.less'
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



const menuData = {menuName: window.trans('product'), menuFor: "product",
  		subItems: [
  {name: 'skuList', displayName: window.mtrans('sku','product.sku_list',false), type:'sku',icon:'skull',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


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
<<<<<<< HEAD
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
const renderItemOfList=(product, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 4
=======

const renderItemOfList=(product, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
>>>>>>> b1266426b024c6919f91c6b5be4635d10d614fe9
  const userContext = null
  return (
    <Card key={product.id} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(product.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={product.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{product.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{product.name}</Description> 
        <Description term={fieldLabels.parentCategory}><Tag color='blue' title={`${product.parentCategory.id}-${product.parentCategory.displayName}`}>{product.parentCategory==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(product.parentCategory.displayName,15)}`}
        </Tag></Description>
        <Description term={fieldLabels.origin} style={{wordBreak: 'break-all'}}>{product.origin}</Description> 
        <Description term={fieldLabels.remark} style={{wordBreak: 'break-all'}}>{product.remark}</Description> 
        <Description term={fieldLabels.brand} style={{wordBreak: 'break-all'}}>{product.brand}</Description> 
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(product.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, origin, remark, brand, parentCategoryId} = formValuesToPack
	const parentCategory = {id: parentCategoryId, version: 2^31}
	const data = {name, origin, remark, brand, parentCategory}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, origin, remark, brand, parentCategory} = objectToUnpack
	const parentCategoryId = parentCategory ? parentCategory.id : null
	const data = {name, origin, remark, brand, parentCategoryId}
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
const ProductBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default ProductBase

