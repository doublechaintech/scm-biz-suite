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


const menuData = {menuName:"潜在客户联络人", menuFor: "potentialCustomerContactPerson",
  		subItems: [
  {name: 'potentialCustomerContactList', displayName:'潜在客户联系', icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"潜在客户联络人", menuFor: "potentialCustomerContactPerson",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  mobile: '手机',
  potentialCustomer: '潜在的客户',
  description: '描述',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'potentialCustomerContactPerson') , sorter: true },
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
        <Description term="序号">{potentialCustomerContactPerson.id}</Description> 
        <Description term="名称">{potentialCustomerContactPerson.name}</Description> 
        <Description term="手机">{potentialCustomerContactPerson.mobile}</Description> 
        <Description term="潜在的客户"><div>{potentialCustomerContactPerson.potentialCustomer==null?appLocaleName(userContext,"NotAssigned"):`${potentialCustomerContactPerson.potentialCustomer.displayName}(${potentialCustomerContactPerson.potentialCustomer.id})`}
        </div></Description>
        <Description term="描述">{potentialCustomerContactPerson.description}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, mobile, description, potentialCustomerId} = formValuesToPack
	const potentialCustomer = {id: potentialCustomerId, version: 2^31}
	const data = {name, mobile, description, potentialCustomer}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, mobile, description, potentialCustomer} = objectToUnpack
	const potentialCustomerId = potentialCustomer ? potentialCustomer.id : null
	const data = {name, mobile, description, potentialCustomerId}
	return data
}

const PotentialCustomerContactPersonBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
export default PotentialCustomerContactPersonBase



