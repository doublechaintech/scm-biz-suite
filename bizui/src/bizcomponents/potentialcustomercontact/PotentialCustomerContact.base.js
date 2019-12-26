import React from 'react'
<<<<<<< HEAD
import { Icon,Divider } from 'antd'
=======
import { Icon,Divider, Avata, Card, Col} from 'antd'
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
<<<<<<< HEAD
=======

>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
<<<<<<< HEAD
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
=======
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
	defaultSearchLocalData,
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
<<<<<<< HEAD
=======
const renderAvatarCell=defaultRenderAvatarCell
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


<<<<<<< HEAD
const menuData = {menuName:"潜在客户联系", menuFor: "potentialCustomerContact",
=======

const menuData = {menuName: window.trans('potential_customer_contact'), menuFor: "potentialCustomerContact",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('potential_customer_contact'), menuFor: "potentialCustomerContact",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('potential_customer_contact.id'),
  name: window.trans('potential_customer_contact.name'),
  contactDate: window.trans('potential_customer_contact.contact_date'),
  contactMethod: window.trans('potential_customer_contact.contact_method'),
  potentialCustomer: window.trans('potential_customer_contact.potential_customer'),
  cityPartner: window.trans('potential_customer_contact.city_partner'),
  contactTo: window.trans('potential_customer_contact.contact_to'),
  description: window.trans('potential_customer_contact.description'),
  lastUpdateTime: window.trans('potential_customer_contact.last_update_time'),

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


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(potentialCustomerContact,targetComponent)=>{

  const userContext = null
  return (
    <div key={potentialCustomerContact.id}>
	
      <DescriptionList  key={potentialCustomerContact.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{potentialCustomerContact.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{potentialCustomerContact.name}</Description> 
        <Description term={fieldLabels.contactDate}><div>{ moment(potentialCustomerContact.contactDate).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.contactMethod} style={{wordBreak: 'break-all'}}>{potentialCustomerContact.contactMethod}</Description> 
        <Description term={fieldLabels.potentialCustomer}><div>{potentialCustomerContact.potentialCustomer==null?appLocaleName(userContext,"NotAssigned"):`${potentialCustomerContact.potentialCustomer.displayName}(${potentialCustomerContact.potentialCustomer.id})`}
        </div></Description>
        <Description term={fieldLabels.cityPartner}><div>{potentialCustomerContact.cityPartner==null?appLocaleName(userContext,"NotAssigned"):`${potentialCustomerContact.cityPartner.displayName}(${potentialCustomerContact.cityPartner.id})`}
        </div></Description>
        <Description term={fieldLabels.contactTo}><div>{potentialCustomerContact.contactTo==null?appLocaleName(userContext,"NotAssigned"):`${potentialCustomerContact.contactTo.displayName}(${potentialCustomerContact.contactTo.id})`}
        </div></Description>
        <Description term={fieldLabels.description} style={{wordBreak: 'break-all'}}>{potentialCustomerContact.description}</Description> 
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(potentialCustomerContact.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"潜在客户联系", menuFor: "potentialCustomerContact",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

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
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, contactDate, contactMethod, description, potentialCustomerId, cityPartnerId, contactToId} = formValuesToPack
	const potentialCustomer = {id: potentialCustomerId, version: 2^31}
	const cityPartner = {id: cityPartnerId, version: 2^31}
	const contactTo = {id: contactToId, version: 2^31}
	const data = {name, contactDate, contactMethod, description, potentialCustomer, cityPartner, contactTo}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, contactDate, contactMethod, description, potentialCustomer, cityPartner, contactTo} = objectToUnpack
	const potentialCustomerId = potentialCustomer ? potentialCustomer.id : null
	const cityPartnerId = cityPartner ? cityPartner.id : null
	const contactToId = contactTo ? contactTo.id : null
	const data = {name, contactDate, contactMethod, description, potentialCustomerId, cityPartnerId, contactToId}
	return data
}
<<<<<<< HEAD

const PotentialCustomerContactBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
const stepOf=(targetComponent, title, content, position, index)=>{
	return {
		title,
		content,
		position,
		packFunction: packFormValuesToObject,
		unpackFunction: unpackObjectToFormValues,
		index,
      }
}
const PotentialCustomerContactBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default PotentialCustomerContactBase



