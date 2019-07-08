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


const menuData = {menuName:"Retail Store City Service Center", menuFor: "retailStoreCityServiceCenter",
  		subItems: [
  {name: 'cityPartnerList', displayName:'City Partner', icon:'city',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'potentialCustomerList', displayName:'Potential Customer', icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'cityEventList', displayName:'City Event', icon:'city',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreList', displayName:'Retail Store', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  founded: 'Founded',
  belongsTo: 'Belongs To',
  lastUpdateTime: 'Last Update Time',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'retailStoreCityServiceCenter') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.belongsTo, dataIndex: 'belongsTo', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(retailStoreCityServiceCenter,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={retailStoreCityServiceCenter.id}>
	
	<DescriptionList  key={retailStoreCityServiceCenter.id} size="small" col="4">
<Description term="Id">{retailStoreCityServiceCenter.id}</Description> 
<Description term="Name">{retailStoreCityServiceCenter.name}</Description> 
<Description term="Founded">{ moment(retailStoreCityServiceCenter.founded).format('YYYY-MM-DD')}</Description> 
<Description term="Belongs To">{retailStoreCityServiceCenter.belongsTo==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreCityServiceCenter.belongsTo.displayName}(${retailStoreCityServiceCenter.belongsTo.id})`}
</Description>
<Description term="Last Update Time">{ moment(retailStoreCityServiceCenter.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const RetailStoreCityServiceCenterBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default RetailStoreCityServiceCenterBase



