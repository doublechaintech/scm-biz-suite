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


const menuData = {menuName:"Potential Customer Contact Person", menuFor: "potentialCustomerContactPerson",
  		subItems: [
  {name: 'potentialCustomerContactList', displayName:'Potential Customer Contact', icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  mobile: 'Mobile',
  potentialCustomer: 'Potential Customer',
  description: 'Description',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'potentialCustomerContactPerson') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.mobile, debugtype: 'string_china_mobile_phone', dataIndex: 'mobile', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.potentialCustomer, dataIndex: 'potentialCustomer', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '28',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(potentialCustomerContactPerson,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={potentialCustomerContactPerson.id}>
	
	<DescriptionList  key={potentialCustomerContactPerson.id} size="small" col="4">
<Description term="Id">{potentialCustomerContactPerson.id}</Description> 
<Description term="Name">{potentialCustomerContactPerson.name}</Description> 
<Description term="Mobile">{potentialCustomerContactPerson.mobile}</Description> 
<Description term="Potential Customer">{potentialCustomerContactPerson.potentialCustomer==null?appLocaleName(userContext,"NotAssigned"):`${potentialCustomerContactPerson.potentialCustomer.displayName}(${potentialCustomerContactPerson.potentialCustomer.id})`}
</Description>
<Description term="Description">{potentialCustomerContactPerson.description}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const PotentialCustomerContactPersonBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default PotentialCustomerContactPersonBase



