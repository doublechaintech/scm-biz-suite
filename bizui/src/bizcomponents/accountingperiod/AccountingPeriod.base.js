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


const menuData = {menuName:"会计期间", menuFor: "accountingPeriod",
  		subItems: [
  {name: 'accountingDocumentList', displayName:'会计凭证', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"会计期间", menuFor: "accountingPeriod",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  startDate: '开始日期',
  endDate: '结束日期',
  accountSet: '账套',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'accountingPeriod') , sorter: true },
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
        <Description term="序号">{accountingPeriod.id}</Description> 
        <Description term="名称">{accountingPeriod.name}</Description> 
        <Description term="开始日期"><div>{ moment(accountingPeriod.startDate).format('YYYY-MM-DD')}</div></Description> 
        <Description term="结束日期"><div>{ moment(accountingPeriod.endDate).format('YYYY-MM-DD')}</div></Description> 
        <Description term="账套"><div>{accountingPeriod.accountSet==null?appLocaleName(userContext,"NotAssigned"):`${accountingPeriod.accountSet.displayName}(${accountingPeriod.accountSet.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, startDate, endDate, accountSetId} = formValuesToPack
	const accountSet = {id: accountSetId, version: 2^31}
	const data = {name, startDate, endDate, accountSet}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, startDate, endDate, accountSet} = objectToUnpack
	const accountSetId = accountSet ? accountSet.id : null
	const data = {name, startDate, endDate, accountSetId}
	return data
}

const AccountingPeriodBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
export default AccountingPeriodBase



