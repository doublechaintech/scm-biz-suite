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


const menuData = {menuName:"Smart Pallet", menuFor: "smartPallet",
  		subItems: [
  {name: 'goodsList', displayName:'Goods', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'Id',
  location: 'Location',
  contactNumber: 'Contact Number',
  totalArea: 'Total Area',
  latitude: 'Latitude',
  longitude: 'Longitude',
  warehouse: 'Warehouse',
  lastUpdateTime: 'Last Update Time',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'smartPallet') , sorter: true },
  { title: fieldLabels.location, debugtype: 'string', dataIndex: 'location', width: '30',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.contactNumber, debugtype: 'string', dataIndex: 'contactNumber', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.totalArea, debugtype: 'string', dataIndex: 'totalArea', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.latitude, debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.longitude, debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.warehouse, dataIndex: 'warehouse', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(smartPallet,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={smartPallet.id}>
	
	<DescriptionList  key={smartPallet.id} size="small" col="4">
<Description term="Id">{smartPallet.id}</Description> 
<Description term="Location">{smartPallet.location}</Description> 
<Description term="Contact Number">{smartPallet.contactNumber}</Description> 
<Description term="Total Area">{smartPallet.totalArea}</Description> 
<Description term="Latitude">{smartPallet.latitude}</Description> 
<Description term="Longitude">{smartPallet.longitude}</Description> 
<Description term="Warehouse">{smartPallet.warehouse==null?appLocaleName(userContext,"NotAssigned"):`${smartPallet.warehouse.displayName}(${smartPallet.warehouse.id})`}
</Description>
<Description term="Last Update Time">{ moment(smartPallet.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const SmartPalletBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default SmartPalletBase



