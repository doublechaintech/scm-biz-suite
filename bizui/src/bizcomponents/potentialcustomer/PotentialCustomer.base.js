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


const menuData = {menuName:"Potential Customer", menuFor: "potentialCustomer",
  		subItems: [
  {name: 'potentialCustomerContactPersonList', displayName:'Potential Customer Contact Person', icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'potentialCustomerContactList', displayName:'Potential Customer Contact', icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'eventAttendanceList', displayName:'Event Attendance', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  mobile: 'Mobile',
  cityServiceCenter: 'City Service Center',
  cityPartner: 'City Partner',
  description: 'Description',
  lastUpdateTime: 'Last Update Time',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'potentialCustomer') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.mobile, debugtype: 'string_china_mobile_phone', dataIndex: 'mobile', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.cityServiceCenter, dataIndex: 'cityServiceCenter', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.cityPartner, dataIndex: 'cityPartner', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(potentialCustomer,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={potentialCustomer.id}>
	
	<DescriptionList  key={potentialCustomer.id} size="small" col="4">
<Description term="Id">{potentialCustomer.id}</Description> 
<Description term="Name">{potentialCustomer.name}</Description> 
<Description term="Mobile">{potentialCustomer.mobile}</Description> 
<Description term="City Service Center">{potentialCustomer.cityServiceCenter==null?appLocaleName(userContext,"NotAssigned"):`${potentialCustomer.cityServiceCenter.displayName}(${potentialCustomer.cityServiceCenter.id})`}
</Description>
<Description term="City Partner">{potentialCustomer.cityPartner==null?appLocaleName(userContext,"NotAssigned"):`${potentialCustomer.cityPartner.displayName}(${potentialCustomer.cityPartner.id})`}
</Description>
<Description term="Description">{potentialCustomer.description}</Description> 
<Description term="Last Update Time">{ moment(potentialCustomer.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const PotentialCustomerBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default PotentialCustomerBase



