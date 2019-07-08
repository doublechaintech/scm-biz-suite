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


const menuData = {menuName:"Accounting Document Line", menuFor: "accountingDocumentLine",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  code: 'Code',
  direct: 'Direct',
  amount: 'Amount',
  belongsTo: 'Belongs To',
  accountingSubject: 'Accounting Subject',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
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
<Description term="Id">{accountingDocumentLine.id}</Description> 
<Description term="Name">{accountingDocumentLine.name}</Description> 
<Description term="Code">{accountingDocumentLine.code}</Description> 
<Description term="Direct">{accountingDocumentLine.direct}</Description> 
<Description term="Amount">{accountingDocumentLine.amount}</Description> 
<Description term="Belongs To">{accountingDocumentLine.belongsTo==null?appLocaleName(userContext,"NotAssigned"):`${accountingDocumentLine.belongsTo.displayName}(${accountingDocumentLine.belongsTo.id})`}
</Description>
<Description term="Accounting Subject">{accountingDocumentLine.accountingSubject==null?appLocaleName(userContext,"NotAssigned"):`${accountingDocumentLine.accountingSubject.displayName}(${accountingDocumentLine.accountingSubject.id})`}
</Description>
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const AccountingDocumentLineBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default AccountingDocumentLineBase



