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


const menuData = {menuName:"会计科目", menuFor: "accountingSubject",
  		subItems: [
  {name: 'accountingDocumentLineList', displayName:'会计凭证行', icon:'line',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"会计科目", menuFor: "accountingSubject",
  		subItems: [
  
  		],
}

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
	



const AccountingSubjectBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default AccountingSubjectBase



