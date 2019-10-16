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


const menuData = {menuName:"工资支付", menuFor: "payingOff",
  		subItems: [
  {name: 'employeeSalarySheetList', displayName:'工资单', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"工资支付", menuFor: "payingOff",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  who: '谁',
  paidFor: '支付',
  paidTime: '支付时间',
  amount: '金额',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'payingOff') , sorter: true },
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
        <Description term="序号">{payingOff.id}</Description> 
        <Description term="谁">{payingOff.who}</Description> 
        <Description term="支付"><div>{payingOff.paidFor==null?appLocaleName(userContext,"NotAssigned"):`${payingOff.paidFor.displayName}(${payingOff.paidFor.id})`}
        </div></Description>
        <Description term="支付时间"><div>{ moment(payingOff.paidTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term="金额"><div style={{"color":"red"}}>{payingOff.amount}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, paidTime, amount, paidForId} = formValuesToPack
	const paidFor = {id: paidForId, version: 2^31}
	const data = {who, paidTime, amount, paidFor}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, paidTime, amount, paidFor} = objectToUnpack
	const paidForId = paidFor ? paidFor.id : null
	const data = {who, paidTime, amount, paidForId}
	return data
}

const PayingOffBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
export default PayingOffBase



