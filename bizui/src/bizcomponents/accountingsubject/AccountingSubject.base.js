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
const menuData = {menuName:"会计科目", menuFor: "accountingSubject",
  		subItems: [
  {name: 'accountingDocumentLineList', displayName:'会计凭证行', icon:'line',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('accounting_subject'), menuFor: "accountingSubject",
  		subItems: [
  {name: 'accountingDocumentLineList', displayName: window.mtrans('accounting_document_line','accounting_subject.accounting_document_line_list',false), type:'accountingDocumentLine',icon:'line',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('accounting_subject'), menuFor: "accountingSubject",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('accounting_subject.id'),
  accountingSubjectCode: window.trans('accounting_subject.accounting_subject_code'),
  accountingSubjectName: window.trans('accounting_subject.accounting_subject_name'),
  accountingSubjectClassCode: window.trans('accounting_subject.accounting_subject_class_code'),
  accountingSubjectClassName: window.trans('accounting_subject.accounting_subject_class_name'),
  accountSet: window.trans('accounting_subject.account_set'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'accountingSubject') , sorter: true },
  { title: fieldLabels.accountingSubjectCode, debugtype: 'string', dataIndex: 'accountingSubjectCode', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.accountingSubjectName, debugtype: 'string', dataIndex: 'accountingSubjectName', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.accountingSubjectClassCode, debugtype: 'int', dataIndex: 'accountingSubjectClassCode', width: '5',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.accountingSubjectClassName, debugtype: 'string', dataIndex: 'accountingSubjectClassName', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.accountSet, dataIndex: 'accountSet', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(accountingSubject,targetComponent)=>{

  const userContext = null
  return (
    <div key={accountingSubject.id}>
	
      <DescriptionList  key={accountingSubject.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{accountingSubject.id}</Description> 
        <Description term={fieldLabels.accountingSubjectCode} style={{wordBreak: 'break-all'}}>{accountingSubject.accountingSubjectCode}</Description> 
        <Description term={fieldLabels.accountingSubjectName} style={{wordBreak: 'break-all'}}>{accountingSubject.accountingSubjectName}</Description> 
        <Description term={fieldLabels.accountingSubjectClassCode}><div style={{"color":"red"}}>{accountingSubject.accountingSubjectClassCode}</div></Description> 
        <Description term={fieldLabels.accountingSubjectClassName} style={{wordBreak: 'break-all'}}>{accountingSubject.accountingSubjectClassName}</Description> 
        <Description term={fieldLabels.accountSet}><div>{accountingSubject.accountSet==null?appLocaleName(userContext,"NotAssigned"):`${accountingSubject.accountSet.displayName}(${accountingSubject.accountSet.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"会计科目", menuFor: "accountingSubject",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  accountingSubjectCode: '会计科目代码',
  accountingSubjectName: '会计科目名称',
  accountingSubjectClassCode: '会计科目类别代码',
  accountingSubjectClassName: '会计科目类别名称',
  accountSet: '账套',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'accountingSubject') , sorter: true },
  { title: fieldLabels.accountingSubjectCode, debugtype: 'string', dataIndex: 'accountingSubjectCode', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.accountingSubjectName, debugtype: 'string', dataIndex: 'accountingSubjectName', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.accountingSubjectClassCode, debugtype: 'int', dataIndex: 'accountingSubjectClassCode', width: '5',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.accountingSubjectClassName, debugtype: 'string', dataIndex: 'accountingSubjectClassName', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.accountSet, dataIndex: 'accountSet', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(accountingSubject,targetComponent)=>{

  const userContext = null
  return (
    <div key={accountingSubject.id}>
	
      <DescriptionList  key={accountingSubject.id} size="small" col="4">
        <Description term="序号">{accountingSubject.id}</Description> 
        <Description term="会计科目代码">{accountingSubject.accountingSubjectCode}</Description> 
        <Description term="会计科目名称">{accountingSubject.accountingSubjectName}</Description> 
        <Description term="会计科目类别代码"><div style={{"color":"red"}}>{accountingSubject.accountingSubjectClassCode}</div></Description> 
        <Description term="会计科目类别名称">{accountingSubject.accountingSubjectClassName}</Description> 
        <Description term="账套"><div>{accountingSubject.accountSet==null?appLocaleName(userContext,"NotAssigned"):`${accountingSubject.accountSet.displayName}(${accountingSubject.accountSet.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {accountingSubjectCode, accountingSubjectName, accountingSubjectClassCode, accountingSubjectClassName, accountSetId} = formValuesToPack
	const accountSet = {id: accountSetId, version: 2^31}
	const data = {accountingSubjectCode, accountingSubjectName, accountingSubjectClassCode, accountingSubjectClassName, accountSet}
	return data
}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {accountingSubjectCode, accountingSubjectName, accountingSubjectClassCode, accountingSubjectClassName, accountSetId} = formValuesToPack
	const accountSet = {id: accountSetId, version: 2^31}
	const data = {accountingSubjectCode, accountingSubjectName, accountingSubjectClassCode, accountingSubjectClassName, accountSet}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {accountingSubjectCode, accountingSubjectName, accountingSubjectClassCode, accountingSubjectClassName, accountSet} = objectToUnpack
	const accountSetId = accountSet ? accountSet.id : null
	const data = {accountingSubjectCode, accountingSubjectName, accountingSubjectClassCode, accountingSubjectClassName, accountSetId}
	return data
}
<<<<<<< HEAD

const AccountingSubjectBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const AccountingSubjectBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default AccountingSubjectBase



