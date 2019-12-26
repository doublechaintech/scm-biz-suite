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
const menuData = {menuName:"会计凭证行", menuFor: "accountingDocumentLine",
=======

const menuData = {menuName: window.trans('accounting_document_line'), menuFor: "accountingDocumentLine",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD
=======

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

const renderItemOfList=(accountingDocumentLine,targetComponent)=>{

  const userContext = null
  return (
    <div key={accountingDocumentLine.id}>
	
      <DescriptionList  key={accountingDocumentLine.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{accountingDocumentLine.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{accountingDocumentLine.name}</Description> 
        <Description term={fieldLabels.code} style={{wordBreak: 'break-all'}}>{accountingDocumentLine.code}</Description> 
        <Description term={fieldLabels.direct} style={{wordBreak: 'break-all'}}>{accountingDocumentLine.direct}</Description> 
        <Description term={fieldLabels.amount}><div style={{"color":"red"}}>{accountingDocumentLine.amount}</div></Description> 
        <Description term={fieldLabels.belongsTo}><div>{accountingDocumentLine.belongsTo==null?appLocaleName(userContext,"NotAssigned"):`${accountingDocumentLine.belongsTo.displayName}(${accountingDocumentLine.belongsTo.id})`}
        </div></Description>
        <Description term={fieldLabels.accountingSubject}><div>{accountingDocumentLine.accountingSubject==null?appLocaleName(userContext,"NotAssigned"):`${accountingDocumentLine.accountingSubject.displayName}(${accountingDocumentLine.accountingSubject.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"会计凭证行", menuFor: "accountingDocumentLine",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  name: '名称',
  code: '代码',
  direct: '直接',
  amount: '金额',
  belongsTo: '属于',
  accountingSubject: '会计科目',

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
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(accountingDocumentLine,targetComponent)=>{

  const userContext = null
  return (
    <div key={accountingDocumentLine.id}>
	
      <DescriptionList  key={accountingDocumentLine.id} size="small" col="4">
        <Description term="序号">{accountingDocumentLine.id}</Description> 
        <Description term="名称">{accountingDocumentLine.name}</Description> 
        <Description term="代码">{accountingDocumentLine.code}</Description> 
        <Description term="直接">{accountingDocumentLine.direct}</Description> 
        <Description term="金额"><div style={{"color":"red"}}>{accountingDocumentLine.amount}</div></Description> 
        <Description term="属于"><div>{accountingDocumentLine.belongsTo==null?appLocaleName(userContext,"NotAssigned"):`${accountingDocumentLine.belongsTo.displayName}(${accountingDocumentLine.belongsTo.id})`}
        </div></Description>
        <Description term="会计科目"><div>{accountingDocumentLine.accountingSubject==null?appLocaleName(userContext,"NotAssigned"):`${accountingDocumentLine.accountingSubject.displayName}(${accountingDocumentLine.accountingSubject.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, code, direct, amount, belongsToId, accountingSubjectId} = formValuesToPack
	const belongsTo = {id: belongsToId, version: 2^31}
	const accountingSubject = {id: accountingSubjectId, version: 2^31}
	const data = {name, code, direct, amount, belongsTo, accountingSubject}
	return data
}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, code, direct, amount, belongsToId, accountingSubjectId} = formValuesToPack
	const belongsTo = {id: belongsToId, version: 2^31}
	const accountingSubject = {id: accountingSubjectId, version: 2^31}
	const data = {name, code, direct, amount, belongsTo, accountingSubject}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, code, direct, amount, belongsTo, accountingSubject} = objectToUnpack
	const belongsToId = belongsTo ? belongsTo.id : null
	const accountingSubjectId = accountingSubject ? accountingSubject.id : null
	const data = {name, code, direct, amount, belongsToId, accountingSubjectId}
	return data
}
<<<<<<< HEAD

const AccountingDocumentLineBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const AccountingDocumentLineBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default AccountingDocumentLineBase



