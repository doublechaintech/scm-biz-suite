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


const menuData = {menuName:"Paying Off", menuFor: "payingOff",
  		subItems: [
  {name: 'employeeSalarySheetList', displayName:'Employee Salary Sheet', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'Id',
  who: 'Who',
  paidFor: 'Paid For',
  paidTime: 'Paid Time',
  amount: 'Amount',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'payingOff') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.paidFor, dataIndex: 'paidFor', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.paidTime, dataIndex: 'paidTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.amount, dataIndex: 'amount', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(payingOff,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={payingOff.id}>
	
	<DescriptionList  key={payingOff.id} size="small" col="4">
<Description term="Id">{payingOff.id}</Description> 
<Description term="Who">{payingOff.who}</Description> 
<Description term="Paid For">{payingOff.paidFor==null?appLocaleName(userContext,"NotAssigned"):`${payingOff.paidFor.displayName}(${payingOff.paidFor.id})`}
</Description>
<Description term="Paid Time">{ moment(payingOff.paidTime).format('YYYY-MM-DD')}</Description> 
<Description term="Amount">{payingOff.amount}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const PayingOffBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default PayingOffBase



