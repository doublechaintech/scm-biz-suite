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
const menuData = {menuName:"零售店会员地址", menuFor: "retailStoreMemberAddress",
=======

const menuData = {menuName: window.trans('retail_store_member_address'), menuFor: "retailStoreMemberAddress",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('retail_store_member_address'), menuFor: "retailStoreMemberAddress",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('retail_store_member_address.id'),
  name: window.trans('retail_store_member_address.name'),
  owner: window.trans('retail_store_member_address.owner'),
  mobilePhone: window.trans('retail_store_member_address.mobile_phone'),
  address: window.trans('retail_store_member_address.address'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStoreMemberAddress') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.mobilePhone, debugtype: 'string_china_mobile_phone', dataIndex: 'mobilePhone', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.address, debugtype: 'string', dataIndex: 'address', width: '18',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(retailStoreMemberAddress,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreMemberAddress.id}>
	
      <DescriptionList  key={retailStoreMemberAddress.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{retailStoreMemberAddress.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{retailStoreMemberAddress.name}</Description> 
        <Description term={fieldLabels.owner}><div>{retailStoreMemberAddress.owner==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreMemberAddress.owner.displayName}(${retailStoreMemberAddress.owner.id})`}
        </div></Description>
        <Description term={fieldLabels.mobilePhone} style={{wordBreak: 'break-all'}}>{retailStoreMemberAddress.mobilePhone}</Description> 
        <Description term={fieldLabels.address} style={{wordBreak: 'break-all'}}>{retailStoreMemberAddress.address}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"零售店会员地址", menuFor: "retailStoreMemberAddress",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  name: '名称',
  owner: '业主',
  mobilePhone: '移动电话',
  address: '地址',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStoreMemberAddress') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.mobilePhone, debugtype: 'string_china_mobile_phone', dataIndex: 'mobilePhone', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.address, debugtype: 'string', dataIndex: 'address', width: '18',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(retailStoreMemberAddress,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreMemberAddress.id}>
	
      <DescriptionList  key={retailStoreMemberAddress.id} size="small" col="4">
        <Description term="序号">{retailStoreMemberAddress.id}</Description> 
        <Description term="名称">{retailStoreMemberAddress.name}</Description> 
        <Description term="业主"><div>{retailStoreMemberAddress.owner==null?appLocaleName(userContext,"NotAssigned"):`${retailStoreMemberAddress.owner.displayName}(${retailStoreMemberAddress.owner.id})`}
        </div></Description>
        <Description term="移动电话">{retailStoreMemberAddress.mobilePhone}</Description> 
        <Description term="地址">{retailStoreMemberAddress.address}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, mobilePhone, address, ownerId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const data = {name, mobilePhone, address, owner}
	return data
}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, mobilePhone, address, ownerId} = formValuesToPack
	const owner = {id: ownerId, version: 2^31}
	const data = {name, mobilePhone, address, owner}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, mobilePhone, address, owner} = objectToUnpack
	const ownerId = owner ? owner.id : null
	const data = {name, mobilePhone, address, ownerId}
	return data
}
<<<<<<< HEAD

const RetailStoreMemberAddressBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const RetailStoreMemberAddressBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default RetailStoreMemberAddressBase



