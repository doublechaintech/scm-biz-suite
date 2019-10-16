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


const menuData = {menuName:"表单字段的信息", menuFor: "formFieldMessage",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"表单字段的信息", menuFor: "formFieldMessage",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  title: '标题',
  parameterName: '参数名称',
  form: '形式',
  level: '水平',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'formFieldMessage') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.parameterName, debugtype: 'string', dataIndex: 'parameterName', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.form, dataIndex: 'form', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.level, debugtype: 'string', dataIndex: 'level', width: '11',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(formFieldMessage,targetComponent)=>{

  const userContext = null
  return (
    <div key={formFieldMessage.id}>
	
      <DescriptionList  key={formFieldMessage.id} size="small" col="4">
        <Description term="ID">{formFieldMessage.id}</Description> 
        <Description term="标题">{formFieldMessage.title}</Description> 
        <Description term="参数名称">{formFieldMessage.parameterName}</Description> 
        <Description term="水平">{formFieldMessage.level}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {title, parameterName, level, formId} = formValuesToPack
	const form = {id: formId, version: 2^31}
	const data = {title, parameterName, level, form}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {title, parameterName, level, form} = objectToUnpack
	const formId = form ? form.id : null
	const data = {title, parameterName, level, formId}
	return data
}

const FormFieldMessageBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
export default FormFieldMessageBase



