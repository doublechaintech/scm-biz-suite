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


const menuData = {menuName:"Retail Store", menuFor: "retailStore",
  		subItems: [
  {name: 'consumerOrderList', displayName:'Consumer Order', icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreOrderList', displayName:'Retail Store Order', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'goodsList', displayName:'Goods', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'transportTaskList', displayName:'Transport Task', icon:'tasks',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'accountSetList', displayName:'Account Set', icon:'headset',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  telephone: 'Telephone',
  owner: 'Owner',
  retailStoreCountryCenter: 'Retail Store Country Center',
  cityServiceCenter: 'City Service Center',
  creation: 'Creation',
  investmentInvitation: 'Investment Invitation',
  franchising: 'Franchising',
  decoration: 'Decoration',
  opening: 'Opening',
  closing: 'Closing',
  founded: 'Founded',
  latitude: 'Latitude',
  longitude: 'Longitude',
  description: 'Description',
  lastUpdateTime: 'Last Update Time',
  currentStatus: 'Current Status',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'retailStore') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.telephone, debugtype: 'string', dataIndex: 'telephone', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, debugtype: 'string', dataIndex: 'owner', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.retailStoreCountryCenter, dataIndex: 'retailStoreCountryCenter', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.cityServiceCenter, dataIndex: 'cityServiceCenter', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.creation, dataIndex: 'creation', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.investmentInvitation, dataIndex: 'investmentInvitation', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.franchising, dataIndex: 'franchising', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.decoration, dataIndex: 'decoration', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.opening, dataIndex: 'opening', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.closing, dataIndex: 'closing', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.latitude, debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.longitude, debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '25',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.currentStatus, debugtype: 'string', dataIndex: 'currentStatus', width: '22',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(retailStore,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={retailStore.id}>
	
	<DescriptionList  key={retailStore.id} size="small" col="4">
<Description term="Id">{retailStore.id}</Description> 
<Description term="Name">{retailStore.name}</Description> 
<Description term="Telephone">{retailStore.telephone}</Description> 
<Description term="Owner">{retailStore.owner}</Description> 
<Description term="City Service Center">{retailStore.cityServiceCenter==null?appLocaleName(userContext,"NotAssigned"):`${retailStore.cityServiceCenter.displayName}(${retailStore.cityServiceCenter.id})`}
</Description>
<Description term="Founded">{ moment(retailStore.founded).format('YYYY-MM-DD')}</Description> 
<Description term="Latitude">{retailStore.latitude}</Description> 
<Description term="Longitude">{retailStore.longitude}</Description> 
<Description term="Description">{retailStore.description}</Description> 
<Description term="Last Update Time">{ moment(retailStore.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
<Description term="Current Status">{retailStore.currentStatus}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const RetailStoreBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default RetailStoreBase



