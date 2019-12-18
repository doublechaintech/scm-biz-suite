import React from 'react'
import { Icon,Divider, Avata, Card, Col} from 'antd'

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
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
	defaultSearchLocalData,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderAvatarCell=defaultRenderAvatarCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell



const menuData = {menuName: window.trans('accounting_document_type'), menuFor: "accountingDocumentType",
  		subItems: [
  {name: 'accountingDocumentList', displayName: window.mtrans('accounting_document','accounting_document_type.accounting_document_list',false), type:'accountingDocument',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('accounting_document_type'), menuFor: "accountingDocumentType",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('accounting_document_type.id'),
  name: window.trans('accounting_document_type.name'),
  description: window.trans('accounting_document_type.description'),
  accountingPeriod: window.trans('accounting_document_type.accounting_period'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'accountingDocumentType') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '74',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.accountingPeriod, dataIndex: 'accountingPeriod', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(accountingDocumentType,targetComponent)=>{

  const userContext = null
  return (
    <div key={accountingDocumentType.id}>
	
      <DescriptionList  key={accountingDocumentType.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{accountingDocumentType.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{accountingDocumentType.name}</Description> 
        <Description term={fieldLabels.description} style={{wordBreak: 'break-all'}}>{accountingDocumentType.description}</Description> 
        <Description term={fieldLabels.accountingPeriod}><div>{accountingDocumentType.accountingPeriod==null?appLocaleName(userContext,"NotAssigned"):`${accountingDocumentType.accountingPeriod.displayName}(${accountingDocumentType.accountingPeriod.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, description, accountingPeriodId} = formValuesToPack
	const accountingPeriod = {id: accountingPeriodId, version: 2^31}
	const data = {name, description, accountingPeriod}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, description, accountingPeriod} = objectToUnpack
	const accountingPeriodId = accountingPeriod ? accountingPeriod.id : null
	const data = {name, description, accountingPeriodId}
	return data
}
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
const AccountingDocumentTypeBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default AccountingDocumentTypeBase



