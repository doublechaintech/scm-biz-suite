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


const menuData = {menuName:"Accounting Period", menuFor: "accountingPeriod",
  		subItems: [
  {name: 'accountingDocumentList', displayName:'Accounting Document', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  startDate: 'Start Date',
  endDate: 'End Date',
  accountSet: 'Account Set',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'accountingPeriod') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '12',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.startDate, dataIndex: 'startDate', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.endDate, dataIndex: 'endDate', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.accountSet, dataIndex: 'accountSet', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(accountingPeriod,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={accountingPeriod.id}>
	
	<DescriptionList  key={accountingPeriod.id} size="small" col="4">
<Description term="Id">{accountingPeriod.id}</Description> 
<Description term="Name">{accountingPeriod.name}</Description> 
<Description term="Start Date">{ moment(accountingPeriod.startDate).format('YYYY-MM-DD')}</Description> 
<Description term="End Date">{ moment(accountingPeriod.endDate).format('YYYY-MM-DD')}</Description> 
<Description term="Account Set">{accountingPeriod.accountSet==null?appLocaleName(userContext,"NotAssigned"):`${accountingPeriod.accountSet.displayName}(${accountingPeriod.accountSet.id})`}
</Description>
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const AccountingPeriodBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default AccountingPeriodBase



