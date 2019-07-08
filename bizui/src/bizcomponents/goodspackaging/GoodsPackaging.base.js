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


const menuData = {menuName:"Goods Packaging", menuFor: "goodsPackaging",
  		subItems: [
  {name: 'goodsList', displayName:'Goods', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'Id',
  packageName: 'Package Name',
  rfid: 'Rfid',
  packageTime: 'Package Time',
  description: 'Description',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'goodsPackaging') , sorter: true },
  { title: fieldLabels.packageName, debugtype: 'string', dataIndex: 'packageName', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.rfid, debugtype: 'string', dataIndex: 'rfid', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.packageTime, dataIndex: 'packageTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '13',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(goodsPackaging,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={goodsPackaging.id}>
	
	<DescriptionList  key={goodsPackaging.id} size="small" col="4">
<Description term="Id">{goodsPackaging.id}</Description> 
<Description term="Package Name">{goodsPackaging.packageName}</Description> 
<Description term="Rfid">{goodsPackaging.rfid}</Description> 
<Description term="Package Time">{ moment(goodsPackaging.packageTime).format('YYYY-MM-DD')}</Description> 
<Description term="Description">{goodsPackaging.description}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const GoodsPackagingBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default GoodsPackagingBase



