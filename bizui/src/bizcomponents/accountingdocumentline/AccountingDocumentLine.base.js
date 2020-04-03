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
import styles from './AccountingDocumentLine.base.less'
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



const menuData = {menuName: window.trans('accounting_document_line'), menuFor: "accountingDocumentLine",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('accounting_document_line'), menuFor: "accountingDocumentLine",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('accounting_document_line.id'),
  name: window.trans('accounting_document_line.name'),
  code: window.trans('accounting_document_line.code'),
  direct: window.trans('accounting_document_line.direct'),
  amount: window.trans('accounting_document_line.amount'),
  belongsTo: window.trans('accounting_document_line.belongs_to'),
  accountingSubject: window.trans('accounting_document_line.accounting_subject'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'accountingDocumentLine') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.code, debugtype: 'string', dataIndex: 'code', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.direct, debugtype: 'string', dataIndex: 'direct', width: '5',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.amount, dataIndex: 'amount', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.belongsTo, dataIndex: 'belongsTo', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.accountingSubject, dataIndex: 'accountingSubject', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)
<<<<<<< HEAD
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
const renderItemOfList=(accountingDocumentLine, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 4
=======

const renderItemOfList=(accountingDocumentLine, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
>>>>>>> b1266426b024c6919f91c6b5be4635d10d614fe9
  const userContext = null
  return (
    <Card key={accountingDocumentLine.id} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(accountingDocumentLine.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={accountingDocumentLine.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{accountingDocumentLine.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{accountingDocumentLine.name}</Description> 
        <Description term={fieldLabels.code} style={{wordBreak: 'break-all'}}>{accountingDocumentLine.code}</Description> 
        <Description term={fieldLabels.direct} style={{wordBreak: 'break-all'}}>{accountingDocumentLine.direct}</Description> 
        <Description term={fieldLabels.amount}><div style={{"color":"red"}}>{accountingDocumentLine.amount}</div></Description> 
        <Description term={fieldLabels.belongsTo}><Tag color='blue' title={`${accountingDocumentLine.belongsTo.id}-${accountingDocumentLine.belongsTo.displayName}`}>{accountingDocumentLine.belongsTo==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(accountingDocumentLine.belongsTo.displayName,15)}`}
        </Tag></Description>
        <Description term={fieldLabels.accountingSubject}><Tag color='blue' title={`${accountingDocumentLine.accountingSubject.id}-${accountingDocumentLine.accountingSubject.displayName}`}>{accountingDocumentLine.accountingSubject==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(accountingDocumentLine.accountingSubject.displayName,15)}`}
        </Tag></Description>
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, code, direct, amount, belongsToId, accountingSubjectId} = formValuesToPack
	const belongsTo = {id: belongsToId, version: 2^31}
	const accountingSubject = {id: accountingSubjectId, version: 2^31}
	const data = {name, code, direct, amount, belongsTo, accountingSubject}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, code, direct, amount, belongsTo, accountingSubject} = objectToUnpack
	const belongsToId = belongsTo ? belongsTo.id : null
	const accountingSubjectId = accountingSubject ? accountingSubject.id : null
	const data = {name, code, direct, amount, belongsToId, accountingSubjectId}
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
const AccountingDocumentLineBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default AccountingDocumentLineBase

