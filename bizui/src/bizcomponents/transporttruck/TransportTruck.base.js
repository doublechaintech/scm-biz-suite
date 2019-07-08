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


const menuData = {menuName:"Transport Truck", menuFor: "transportTruck",
  		subItems: [
  {name: 'transportTaskList', displayName:'Transport Task', icon:'tasks',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  plateNumber: 'Plate Number',
  contactNumber: 'Contact Number',
  vehicleLicenseNumber: 'Vehicle License Number',
  engineNumber: 'Engine Number',
  makeDate: 'Make Date',
  mileage: 'Mileage',
  bodyColor: 'Body Color',
  owner: 'Owner',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'transportTruck') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.plateNumber, debugtype: 'string', dataIndex: 'plateNumber', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.contactNumber, debugtype: 'string', dataIndex: 'contactNumber', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.vehicleLicenseNumber, debugtype: 'string', dataIndex: 'vehicleLicenseNumber', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.engineNumber, debugtype: 'string', dataIndex: 'engineNumber', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.makeDate, dataIndex: 'makeDate', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.mileage, debugtype: 'string', dataIndex: 'mileage', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.bodyColor, debugtype: 'string', dataIndex: 'bodyColor', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(transportTruck,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={transportTruck.id}>
	
	<DescriptionList  key={transportTruck.id} size="small" col="4">
<Description term="Id">{transportTruck.id}</Description> 
<Description term="Name">{transportTruck.name}</Description> 
<Description term="Plate Number">{transportTruck.plateNumber}</Description> 
<Description term="Contact Number">{transportTruck.contactNumber}</Description> 
<Description term="Vehicle License Number">{transportTruck.vehicleLicenseNumber}</Description> 
<Description term="Engine Number">{transportTruck.engineNumber}</Description> 
<Description term="Make Date">{ moment(transportTruck.makeDate).format('YYYY-MM-DD')}</Description> 
<Description term="Mileage">{transportTruck.mileage}</Description> 
<Description term="Body Color">{transportTruck.bodyColor}</Description> 
<Description term="Owner">{transportTruck.owner==null?appLocaleName(userContext,"NotAssigned"):`${transportTruck.owner.displayName}(${transportTruck.owner.id})`}
</Description>
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const TransportTruckBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default TransportTruckBase



