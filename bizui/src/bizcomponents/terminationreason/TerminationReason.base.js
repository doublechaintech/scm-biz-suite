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


const menuData = {menuName:"雇佣终止的原因", menuFor: "terminationReason",
  		subItems: [
  {name: 'terminationList', displayName:'雇佣终止', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"雇佣终止的原因", menuFor: "terminationReason",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  code: '代码',
  company: '公司',
  description: '描述',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'terminationReason') , sorter: true },
  { title: fieldLabels.code, debugtype: 'string', dataIndex: 'code', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.company, dataIndex: 'company', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '13',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(terminationReason,targetComponent)=>{

  const userContext = null
  return (
    <div key={terminationReason.id}>
	
      <DescriptionList  key={terminationReason.id} size="small" col="4">
        <Description term="序号">{terminationReason.id}</Description> 
        <Description term="代码">{terminationReason.code}</Description> 
        <Description term="描述">{terminationReason.description}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {code, description, companyId} = formValuesToPack
	const company = {id: companyId, version: 2^31}
	const data = {code, description, company}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {code, description, company} = objectToUnpack
	const companyId = company ? company.id : null
	const data = {code, description, companyId}
	return data
}

const TerminationReasonBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
export default TerminationReasonBase



