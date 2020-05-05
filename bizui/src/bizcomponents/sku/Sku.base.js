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
import styles from './Sku.base.less'
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
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '6', render: (text, record)=>renderTextCell(text,record,'sku') , sorter: true },
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

const renderTextItem=(value, label, targetComponent)=>{
	const userContext = null
	if(!value){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.id){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.displayName){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	
	return <Tag color='blue' title={`${value.displayName}(${value.id})`}>{leftChars(value.displayName)}</Tag>
}
const renderImageItem=(value,label, targetComponent)=>{
	const userContext = null
	if(!value){
		return appLocaleName(userContext,"NotAssigned")
	}
	
	return <ImagePreview title={label} imageLocation={value}/>
}

const renderDateItem=(value, label,targetComponent)=>{
	const userContext = null
	if(!value){
		return appLocaleName(userContext,"NotAssigned")
	}
	return moment(value).format('YYYY-MM-DD');
}

const renderDateTimeItem=(value,label, targetComponent)=>{
	const userContext = window.userContext
	if(!value){
		return appLocaleName(userContext,"NotAssigned")
	}
	return  moment(value).format('YYYY-MM-DD HH:mm')
}


const renderReferenceItem=(value,label, targetComponent)=>{
	const userContext = null
	if(!value){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.id){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.displayName){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	
	return <Tag color='blue' title={`${value.displayName}(${value.id})`}>{leftChars(value.displayName)}</Tag>
}

const renderItemOfList=(sku, targetComponent, columCount, listName)=>{
  
  if(!sku){
  	return null
  }
  if(!sku.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`${listName}-${sku.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(sku.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={sku.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{sku.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{sku.name}</Description> 
        <Description term={fieldLabels.size} style={{wordBreak: 'break-all'}}>{sku.size}</Description> 
        <Description term={fieldLabels.product}>{renderReferenceItem(sku.product)}</Description>

        <Description term={fieldLabels.barcode} style={{wordBreak: 'break-all'}}>{sku.barcode}</Description> 
        <Description term={fieldLabels.packageType} style={{wordBreak: 'break-all'}}>{sku.packageType}</Description> 
        <Description term={fieldLabels.netContent} style={{wordBreak: 'break-all'}}>{sku.netContent}</Description> 
        <Description term={fieldLabels.price}><div style={{"color":"red"}}>{sku.price}</div></Description> 
        <Description term={fieldLabels.picture}><div><ImagePreview imageTitle={fieldLabels.picture} imageLocation={sku.picture}/></div></Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
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
const SkuBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default SkuBase

