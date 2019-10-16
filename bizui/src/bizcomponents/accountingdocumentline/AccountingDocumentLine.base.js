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


const menuData = {menuName:"会计凭证行", menuFor: "accountingDocumentLine",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"会计凭证行", menuFor: "accountingDocumentLine",
  		subItems: [
  
  		],
}

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
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, code, direct, amount, belongsTo, accountingSubject} = objectToUnpack
	const belongsToId = belongsTo ? belongsTo.id : null
	const accountingSubjectId = accountingSubject ? accountingSubject.id : null
	const data = {name, code, direct, amount, belongsToId, accountingSubjectId}
	return data
}

const AccountingDocumentLineBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
export default AccountingDocumentLineBase



