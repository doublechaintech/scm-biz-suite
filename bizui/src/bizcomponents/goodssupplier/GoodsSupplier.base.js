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


const menuData = {menuName:"Goods Supplier", menuFor: "goodsSupplier",
  		subItems: [
  {name: 'supplierProductList', displayName:'Supplier Product', icon:'product-hunt',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'supplyOrderList', displayName:'Supply Order', icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'accountSetList', displayName:'Account Set', icon:'headset',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  supplyProduct: 'Supply Product',
  belongTo: 'Belong To',
  contactNumber: 'Contact Number',
  description: 'Description',
  lastUpdateTime: 'Last Update Time',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'goodsSupplier') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.supplyProduct, debugtype: 'string', dataIndex: 'supplyProduct', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.belongTo, dataIndex: 'belongTo', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.contactNumber, debugtype: 'string_china_mobile_phone', dataIndex: 'contactNumber', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '22',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(goodsSupplier,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={goodsSupplier.id}>
	
	<DescriptionList  key={goodsSupplier.id} size="small" col="4">
<Description term="Id">{goodsSupplier.id}</Description> 
<Description term="Name">{goodsSupplier.name}</Description> 
<Description term="Supply Product">{goodsSupplier.supplyProduct}</Description> 
<Description term="Contact Number">{goodsSupplier.contactNumber}</Description> 
<Description term="Description">{goodsSupplier.description}</Description> 
<Description term="Last Update Time">{ moment(goodsSupplier.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const GoodsSupplierBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default GoodsSupplierBase



