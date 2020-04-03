import React from 'react'
import { Icon,Divider, Avatar, Card, Col, Tag} from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
import styles from './AccountingDocument.base.less'
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



const menuData = {menuName: window.trans('accounting_document'), menuFor: "accountingDocument",
  		subItems: [
  {name: 'originalVoucherList', displayName: window.mtrans('original_voucher','accounting_document.original_voucher_list',false), type:'originalVoucher',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'accountingDocumentLineList', displayName: window.mtrans('accounting_document_line','accounting_document.accounting_document_line_list',false), type:'accountingDocumentLine',icon:'line',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('accounting_document'), menuFor: "accountingDocument",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('accounting_document.id'),
  name: window.trans('accounting_document.name'),
  accountingDocumentDate: window.trans('accounting_document.accounting_document_date'),
  accountingPeriod: window.trans('accounting_document.accounting_period'),
  documentType: window.trans('accounting_document.document_type'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'accountingDocument') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.accountingDocumentDate, dataIndex: 'accountingDocumentDate', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.accountingPeriod, dataIndex: 'accountingPeriod', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.documentType, dataIndex: 'documentType', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)
const colorList = ['#f56a00', '#7265e6', '#ffbf00', '#00a2ae'];
let counter = 0;
const genColor=()=>{
	counter++;
	return colorList[counter%colorList.length];
}
const followColor=()=>{
	return 'green';
	// return colorList[counter%colorList.length];
}
const leftChars=(value, left)=>{
	const chars = left || 4
	if(!value){
		return "N/A"
	}
	return value.substring(0,chars);
}
const renderItemOfList=(accountingDocument, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={accountingDocument.id} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(accountingDocument.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={accountingDocument.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{accountingDocument.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{accountingDocument.name}</Description> 
        <Description term={fieldLabels.accountingDocumentDate}><div>{ moment(accountingDocument.accountingDocumentDate).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.accountingPeriod}><Tag color='blue' title={`${accountingDocument.accountingPeriod.id}-${accountingDocument.accountingPeriod.displayName}`}>{accountingDocument.accountingPeriod==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(accountingDocument.accountingPeriod.displayName,15)}`}
        </Tag></Description>
        <Description term={fieldLabels.documentType}><Tag color='blue' title={`${accountingDocument.documentType.id}-${accountingDocument.documentType.displayName}`}>{accountingDocument.documentType==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(accountingDocument.documentType.displayName,15)}`}
        </Tag></Description>
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, accountingDocumentDate, accountingPeriodId, documentTypeId} = formValuesToPack
	const accountingPeriod = {id: accountingPeriodId, version: 2^31}
	const documentType = {id: documentTypeId, version: 2^31}
	const data = {name, accountingDocumentDate:moment(accountingDocumentDate).valueOf(), accountingPeriod, documentType}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, accountingDocumentDate, accountingPeriod, documentType} = objectToUnpack
	const accountingPeriodId = accountingPeriod ? accountingPeriod.id : null
	const documentTypeId = documentType ? documentType.id : null
	const data = {name, accountingDocumentDate:moment(accountingDocumentDate), accountingPeriodId, documentTypeId}
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
const AccountingDocumentBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default AccountingDocumentBase

