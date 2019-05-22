import React from 'react'
import { Icon } from 'antd'
import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'

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


const menuData = {menuName:"会计凭证类型", menuFor: "accountingDocumentType",
  		subItems: [
  {name: 'accountingDocumentList', displayName:'会计凭证', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  description: '描述',
  accountingPeriod: '会计期间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'accountingDocumentType') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '74',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.accountingPeriod, dataIndex: 'accountingPeriod', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=({accountingDocumentType,targetComponent})=>{

	
	
	const {AccountingDocumentTypeService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{accountingDocumentType.id}</Description> 
<Description term="名称">{accountingDocumentType.name}</Description> 
<Description term="描述">{accountingDocumentType.description}</Description> 
<Description term="会计期间">{accountingDocumentType.accountingPeriod==null?appLocaleName(userContext,"NotAssigned"):`${accountingDocumentType.accountingPeriod.displayName}(${accountingDocumentType.accountingPeriod.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"会计期间","accountSet",AccountingDocumentTypeService.requestCandidateAccountingPeriod,
	      AccountingDocumentTypeService.transferToAnotherAccountingPeriod,"anotherAccountingPeriodId",accountingDocumentType.accountingPeriod?accountingDocumentType.accountingPeriod.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
	
        {buildTransferModal(accountingDocumentType,targetComponent)}
      </DescriptionList>
	)

}
	



const AccountingDocumentTypeBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default AccountingDocumentTypeBase



