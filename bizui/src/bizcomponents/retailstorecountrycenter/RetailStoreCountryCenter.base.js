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


const menuData = {menuName:"Retail Store Country Center", menuFor: "retailStoreCountryCenter",
  		subItems: [
  {name: 'catalogList', displayName:'Catalog', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '产品管理'},
  {name: 'retailStoreProvinceCenterList', displayName:'Retail Store Province Center', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '组织机构'},
  {name: 'retailStoreList', displayName:'Retail Store', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '加盟管理'},
  {name: 'retailStoreMemberList', displayName:'Retail Store Member', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '会员管理'},
  {name: 'goodsSupplierList', displayName:'Goods Supplier', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '供应管理'},
  {name: 'supplyOrderList', displayName:'Supply Order', icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '供应管理'},
  {name: 'retailStoreOrderList', displayName:'Retail Store Order', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '销售管理'},
  {name: 'warehouseList', displayName:'Warehouse', icon:'warehouse',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '仓配运一体化'},
  {name: 'transportFleetList', displayName:'Transport Fleet', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '仓配运一体化'},
  {name: 'accountSetList', displayName:'Account Set', icon:'headset',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '财务管理'},
  {name: 'levelOneDepartmentList', displayName:'Level One Department', icon:'bone',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '组织机构'},
  {name: 'employeeList', displayName:'Employee', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '人力资源'},
  {name: 'instructorList', displayName:'Instructor', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '人力资源'},
  {name: 'companyTrainingList', displayName:'Company Training', icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '人力资源'},
  
  		],
}

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  serviceNumber: 'Service Number',
  founded: 'Founded',
  webSite: 'Web Site',
  address: 'Address',
  operatedBy: 'Operated By',
  legalRepresentative: 'Legal Representative',
  description: 'Description',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'retailStoreCountryCenter') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.serviceNumber, debugtype: 'string', dataIndex: 'serviceNumber', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.webSite, debugtype: 'string_url', dataIndex: 'webSite', width: '36',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.address, debugtype: 'string', dataIndex: 'address', width: '18',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.operatedBy, debugtype: 'string', dataIndex: 'operatedBy', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.legalRepresentative, debugtype: 'string', dataIndex: 'legalRepresentative', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '17',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(retailStoreCountryCenter,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={retailStoreCountryCenter.id}>
	
	<DescriptionList  key={retailStoreCountryCenter.id} size="small" col="4">
<Description term="Id">{retailStoreCountryCenter.id}</Description> 
<Description term="Name">{retailStoreCountryCenter.name}</Description> 
<Description term="Service Number">{retailStoreCountryCenter.serviceNumber}</Description> 
<Description term="Founded">{ moment(retailStoreCountryCenter.founded).format('YYYY-MM-DD')}</Description> 
<Description term="Web Site">{retailStoreCountryCenter.webSite}</Description> 
<Description term="Address">{retailStoreCountryCenter.address}</Description> 
<Description term="Operated By">{retailStoreCountryCenter.operatedBy}</Description> 
<Description term="Legal Representative">{retailStoreCountryCenter.legalRepresentative}</Description> 
<Description term="Description">{retailStoreCountryCenter.description}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const RetailStoreCountryCenterBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default RetailStoreCountryCenterBase



