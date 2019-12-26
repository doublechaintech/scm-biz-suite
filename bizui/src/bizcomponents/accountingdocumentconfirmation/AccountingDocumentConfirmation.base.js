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
const menuData = {menuName:"会计的确认文件", menuFor: "accountingDocumentConfirmation",
  		subItems: [
  {name: 'accountingDocumentList', displayName:'会计凭证', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('accounting_document_confirmation'), menuFor: "accountingDocumentConfirmation",
  		subItems: [
  {name: 'accountingDocumentList', displayName: window.mtrans('accounting_document','accounting_document_confirmation.accounting_document_list',false), type:'accountingDocument',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}


<<<<<<< HEAD
const settingMenuData = {menuName:"会计的确认文件", menuFor: "accountingDocumentConfirmation",
=======
const settingMenuData = {menuName: window.trans('accounting_document_confirmation'), menuFor: "accountingDocumentConfirmation",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

const fieldLabels = {
<<<<<<< HEAD
  id: '序号',
  who: '谁',
  comments: '评论',
  makeDate: '制造日期',
=======
  id: window.trans('accounting_document_confirmation.id'),
  who: window.trans('accounting_document_confirmation.who'),
  comments: window.trans('accounting_document_confirmation.comments'),
  makeDate: window.trans('accounting_document_confirmation.make_date'),
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'accountingDocumentConfirmation') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.comments, debugtype: 'string', dataIndex: 'comments', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.makeDate, dataIndex: 'makeDate', render: (text, record) =>renderDateCell(text,record), sorter: true },

]
<<<<<<< HEAD
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(accountingDocumentConfirmation,targetComponent)=>{

  const userContext = null
  return (
    <div key={accountingDocumentConfirmation.id}>
	
      <DescriptionList  key={accountingDocumentConfirmation.id} size="small" col="4">
        <Description term="序号">{accountingDocumentConfirmation.id}</Description> 
        <Description term="谁">{accountingDocumentConfirmation.who}</Description> 
        <Description term="评论">{accountingDocumentConfirmation.comments}</Description> 
        <Description term="制造日期"><div>{ moment(accountingDocumentConfirmation.makeDate).format('YYYY-MM-DD')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, comments, makeDate} = formValuesToPack

	const data = {who, comments, makeDate}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, comments, makeDate} = objectToUnpack
=======


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(accountingDocumentConfirmation,targetComponent)=>{

  const userContext = null
  return (
    <div key={accountingDocumentConfirmation.id}>
	
      <DescriptionList  key={accountingDocumentConfirmation.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{accountingDocumentConfirmation.id}</Description> 
        <Description term={fieldLabels.who} style={{wordBreak: 'break-all'}}>{accountingDocumentConfirmation.who}</Description> 
        <Description term={fieldLabels.comments} style={{wordBreak: 'break-all'}}>{accountingDocumentConfirmation.comments}</Description> 
        <Description term={fieldLabels.makeDate}><div>{ moment(accountingDocumentConfirmation.makeDate).format('YYYY-MM-DD')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, comments, makeDate} = formValuesToPack
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

	const data = {who, comments, makeDate}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, comments, makeDate} = objectToUnpack

<<<<<<< HEAD
const AccountingDocumentConfirmationBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
	const data = {who, comments, makeDate}
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
const AccountingDocumentConfirmationBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default AccountingDocumentConfirmationBase



