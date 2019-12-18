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



const menuData = {menuName: window.trans('accounting_period'), menuFor: "accountingPeriod",
  		subItems: [
  {name: 'accountingDocumentList', displayName: window.mtrans('accounting_document','accounting_period.accounting_document_list',false), type:'accountingDocument',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('accounting_period'), menuFor: "accountingPeriod",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('accounting_period.id'),
  name: window.trans('accounting_period.name'),
  startDate: window.trans('accounting_period.start_date'),
  endDate: window.trans('accounting_period.end_date'),
  accountSet: window.trans('accounting_period.account_set'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'accountingPeriod') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '12',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.startDate, dataIndex: 'startDate', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.endDate, dataIndex: 'endDate', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.accountSet, dataIndex: 'accountSet', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(accountingPeriod,targetComponent)=>{

  const userContext = null
  return (
    <div key={accountingPeriod.id}>
	
      <DescriptionList  key={accountingPeriod.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{accountingPeriod.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{accountingPeriod.name}</Description> 
        <Description term={fieldLabels.startDate}><div>{ moment(accountingPeriod.startDate).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.endDate}><div>{ moment(accountingPeriod.endDate).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.accountSet}><div>{accountingPeriod.accountSet==null?appLocaleName(userContext,"NotAssigned"):`${accountingPeriod.accountSet.displayName}(${accountingPeriod.accountSet.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, startDate, endDate, accountSetId} = formValuesToPack
	const accountSet = {id: accountSetId, version: 2^31}
	const data = {name, startDate, endDate, accountSet}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, startDate, endDate, accountSet} = objectToUnpack
	const accountSetId = accountSet ? accountSet.id : null
	const data = {name, startDate, endDate, accountSetId}
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
const AccountingPeriodBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default AccountingPeriodBase



