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


const menuData = {menuName:"Goods", menuFor: "goods",
  		subItems: [
  {name: 'goodsMovementList', displayName:'Goods Movement', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  rfid: 'Rfid',
  uom: 'Uom',
  maxPackage: 'Max Package',
  expireTime: 'Expire Time',
  sku: 'Sku',
  receivingSpace: 'Receiving Space',
  goodsAllocation: 'Goods Allocation',
  smartPallet: 'Smart Pallet',
  shippingSpace: 'Shipping Space',
  transportTask: 'Transport Task',
  retailStore: 'Retail Store',
  bizOrder: 'Biz Order',
  retailStoreOrder: 'Retail Store Order',
  packaging: 'Packaging',
  currentStatus: 'Current Status',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'goods') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.rfid, debugtype: 'string', dataIndex: 'rfid', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.uom, debugtype: 'string', dataIndex: 'uom', width: '5',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.maxPackage, debugtype: 'int', dataIndex: 'maxPackage', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.expireTime, dataIndex: 'expireTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.sku, dataIndex: 'sku', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.receivingSpace, dataIndex: 'receivingSpace', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.goodsAllocation, dataIndex: 'goodsAllocation', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.smartPallet, dataIndex: 'smartPallet', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.shippingSpace, dataIndex: 'shippingSpace', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.transportTask, dataIndex: 'transportTask', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.retailStore, dataIndex: 'retailStore', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.bizOrder, dataIndex: 'bizOrder', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.retailStoreOrder, dataIndex: 'retailStoreOrder', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.packaging, dataIndex: 'packaging', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.currentStatus, debugtype: 'string', dataIndex: 'currentStatus', width: '10',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(goods,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={goods.id}>
	
	<DescriptionList  key={goods.id} size="small" col="4">
<Description term="Id">{goods.id}</Description> 
<Description term="Name">{goods.name}</Description> 
<Description term="Rfid">{goods.rfid}</Description> 
<Description term="Uom">{goods.uom}</Description> 
<Description term="Max Package">{goods.maxPackage}</Description> 
<Description term="Expire Time">{ moment(goods.expireTime).format('YYYY-MM-DD')}</Description> 
<Description term="Sku">{goods.sku==null?appLocaleName(userContext,"NotAssigned"):`${goods.sku.displayName}(${goods.sku.id})`}
</Description>
<Description term="Receiving Space">{goods.receivingSpace==null?appLocaleName(userContext,"NotAssigned"):`${goods.receivingSpace.displayName}(${goods.receivingSpace.id})`}
</Description>
<Description term="Goods Allocation">{goods.goodsAllocation==null?appLocaleName(userContext,"NotAssigned"):`${goods.goodsAllocation.displayName}(${goods.goodsAllocation.id})`}
</Description>
<Description term="Smart Pallet">{goods.smartPallet==null?appLocaleName(userContext,"NotAssigned"):`${goods.smartPallet.displayName}(${goods.smartPallet.id})`}
</Description>
<Description term="Shipping Space">{goods.shippingSpace==null?appLocaleName(userContext,"NotAssigned"):`${goods.shippingSpace.displayName}(${goods.shippingSpace.id})`}
</Description>
<Description term="Transport Task">{goods.transportTask==null?appLocaleName(userContext,"NotAssigned"):`${goods.transportTask.displayName}(${goods.transportTask.id})`}
</Description>
<Description term="Retail Store">{goods.retailStore==null?appLocaleName(userContext,"NotAssigned"):`${goods.retailStore.displayName}(${goods.retailStore.id})`}
</Description>
<Description term="Biz Order">{goods.bizOrder==null?appLocaleName(userContext,"NotAssigned"):`${goods.bizOrder.displayName}(${goods.bizOrder.id})`}
</Description>
<Description term="Retail Store Order">{goods.retailStoreOrder==null?appLocaleName(userContext,"NotAssigned"):`${goods.retailStoreOrder.displayName}(${goods.retailStoreOrder.id})`}
</Description>
<Description term="Current Status">{goods.currentStatus}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const GoodsBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default GoodsBase



