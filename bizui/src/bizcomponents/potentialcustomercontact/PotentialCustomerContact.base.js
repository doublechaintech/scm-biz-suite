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


const menuData = {menuName:"潜在客户联系", menuFor: "potentialCustomerContact",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"潜在客户联系", menuFor: "potentialCustomerContact",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  contactDate: '接触日期',
  contactMethod: '接触法',
  potentialCustomer: '潜在的客户',
  cityPartner: '城市合伙人',
  contactTo: '接触',
  description: '描述',
  lastUpdateTime: '最后更新时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'potentialCustomerContact') , sorter: true },
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
        <Description term="序号">{potentialCustomerContact.id}</Description> 
        <Description term="名称">{potentialCustomerContact.name}</Description> 
        <Description term="接触日期"><div>{ moment(potentialCustomerContact.contactDate).format('YYYY-MM-DD')}</div></Description> 
        <Description term="接触法">{potentialCustomerContact.contactMethod}</Description> 
        <Description term="潜在的客户"><div>{potentialCustomerContact.potentialCustomer==null?appLocaleName(userContext,"NotAssigned"):`${potentialCustomerContact.potentialCustomer.displayName}(${potentialCustomerContact.potentialCustomer.id})`}
        </div></Description>
        <Description term="城市合伙人"><div>{potentialCustomerContact.cityPartner==null?appLocaleName(userContext,"NotAssigned"):`${potentialCustomerContact.cityPartner.displayName}(${potentialCustomerContact.cityPartner.id})`}
        </div></Description>
        <Description term="接触"><div>{potentialCustomerContact.contactTo==null?appLocaleName(userContext,"NotAssigned"):`${potentialCustomerContact.contactTo.displayName}(${potentialCustomerContact.contactTo.id})`}
        </div></Description>
        <Description term="描述">{potentialCustomerContact.description}</Description> 
        <Description term="最后更新时间"><div>{ moment(potentialCustomerContact.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, contactDate, contactMethod, description, potentialCustomerId, cityPartnerId, contactToId} = formValuesToPack
	const potentialCustomer = {id: potentialCustomerId, version: 2^31}
	const cityPartner = {id: cityPartnerId, version: 2^31}
	const contactTo = {id: contactToId, version: 2^31}
	const data = {name, contactDate, contactMethod, description, potentialCustomer, cityPartner, contactTo}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, contactDate, contactMethod, description, potentialCustomer, cityPartner, contactTo} = objectToUnpack
	const potentialCustomerId = potentialCustomer ? potentialCustomer.id : null
	const cityPartnerId = cityPartner ? cityPartner.id : null
	const contactToId = contactTo ? contactTo.id : null
	const data = {name, contactDate, contactMethod, description, potentialCustomerId, cityPartnerId, contactToId}
	return data
}

const PotentialCustomerContactBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
export default PotentialCustomerContactBase



