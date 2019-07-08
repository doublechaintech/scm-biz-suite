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


const menuData = {menuName:"Potential Customer Contact", menuFor: "potentialCustomerContact",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  contactDate: 'Contact Date',
  contactMethod: 'Contact Method',
  potentialCustomer: 'Potential Customer',
  cityPartner: 'City Partner',
  contactTo: 'Contact To',
  description: 'Description',
  lastUpdateTime: 'Last Update Time',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.contactDate, dataIndex: 'contactDate', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.contactMethod, debugtype: 'string', dataIndex: 'contactMethod', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.potentialCustomer, dataIndex: 'potentialCustomer', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.cityPartner, dataIndex: 'cityPartner', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.contactTo, dataIndex: 'contactTo', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(potentialCustomerContact,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={potentialCustomerContact.id}>
	
	<DescriptionList  key={potentialCustomerContact.id} size="small" col="4">
<Description term="Id">{potentialCustomerContact.id}</Description> 
<Description term="Name">{potentialCustomerContact.name}</Description> 
<Description term="Contact Date">{ moment(potentialCustomerContact.contactDate).format('YYYY-MM-DD')}</Description> 
<Description term="Contact Method">{potentialCustomerContact.contactMethod}</Description> 
<Description term="Potential Customer">{potentialCustomerContact.potentialCustomer==null?appLocaleName(userContext,"NotAssigned"):`${potentialCustomerContact.potentialCustomer.displayName}(${potentialCustomerContact.potentialCustomer.id})`}
</Description>
<Description term="City Partner">{potentialCustomerContact.cityPartner==null?appLocaleName(userContext,"NotAssigned"):`${potentialCustomerContact.cityPartner.displayName}(${potentialCustomerContact.cityPartner.id})`}
</Description>
<Description term="Contact To">{potentialCustomerContact.contactTo==null?appLocaleName(userContext,"NotAssigned"):`${potentialCustomerContact.contactTo.displayName}(${potentialCustomerContact.contactTo.id})`}
</Description>
<Description term="Description">{potentialCustomerContact.description}</Description> 
<Description term="Last Update Time">{ moment(potentialCustomerContact.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const PotentialCustomerContactBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default PotentialCustomerContactBase



