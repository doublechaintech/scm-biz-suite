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


const menuData = {menuName:"表单字段", menuFor: "formField",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"表单字段", menuFor: "formField",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  label: '标签',
  localeKey: '语言环境的关键',
  parameterName: '参数名称',
  type: '类型',
  form: '形式',
  placeholder: '占位符',
  defaultValue: '默认值',
  description: '描述',
  fieldGroup: '字段组',
  minimumValue: '最小值',
  maximumValue: '最大值',
  required: '要求',
  disabled: '禁用',
  customRendering: '自定义渲染',
  candidateValues: '候选人的价值观',
  suggestValues: '建议值',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'formField') , sorter: true },
  { title: fieldLabels.label, debugtype: 'string', dataIndex: 'label', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.localeKey, debugtype: 'string', dataIndex: 'localeKey', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.parameterName, debugtype: 'string', dataIndex: 'parameterName', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.type, debugtype: 'string', dataIndex: 'type', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.form, dataIndex: 'form', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.placeholder, debugtype: 'string', dataIndex: 'placeholder', width: '16',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.defaultValue, debugtype: 'string', dataIndex: 'defaultValue', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '16',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.fieldGroup, debugtype: 'string', dataIndex: 'fieldGroup', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.minimumValue, debugtype: 'string', dataIndex: 'minimumValue', width: '19',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.maximumValue, debugtype: 'string', dataIndex: 'maximumValue', width: '22',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.required, dataIndex: 'required', render: (text, record) =>renderBooleanCell(text, record), sorter:true },
  { title: fieldLabels.disabled, dataIndex: 'disabled', render: (text, record) =>renderBooleanCell(text, record), sorter:true },
  { title: fieldLabels.customRendering, dataIndex: 'customRendering', render: (text, record) =>renderBooleanCell(text, record), sorter:true },
  { title: fieldLabels.candidateValues, debugtype: 'string', dataIndex: 'candidateValues', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.suggestValues, debugtype: 'string', dataIndex: 'suggestValues', width: '7',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(formField,targetComponent)=>{

  const userContext = null
  return (
    <div key={formField.id}>
	
      <DescriptionList  key={formField.id} size="small" col="4">
        <Description term="ID">{formField.id}</Description> 
        <Description term="标签">{formField.label}</Description> 
        <Description term="语言环境的关键">{formField.localeKey}</Description> 
        <Description term="参数名称">{formField.parameterName}</Description> 
        <Description term="类型">{formField.type}</Description> 
        <Description term="占位符">{formField.placeholder}</Description> 
        <Description term="默认值">{formField.defaultValue}</Description> 
        <Description term="描述">{formField.description}</Description> 
        <Description term="字段组">{formField.fieldGroup}</Description> 
        <Description term="最小值">{formField.minimumValue}</Description> 
        <Description term="最大值">{formField.maximumValue}</Description> 
        <Description term="候选人的价值观">{formField.candidateValues}</Description> 
        <Description term="建议值">{formField.suggestValues}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {label, localeKey, parameterName, type, placeholder, defaultValue, description, fieldGroup, minimumValue, maximumValue, candidateValues, suggestValues, formId} = formValuesToPack
	const form = {id: formId, version: 2^31}
	const data = {label, localeKey, parameterName, type, placeholder, defaultValue, description, fieldGroup, minimumValue, maximumValue, candidateValues, suggestValues, form}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {label, localeKey, parameterName, type, placeholder, defaultValue, description, fieldGroup, minimumValue, maximumValue, candidateValues, suggestValues, form} = objectToUnpack
	const formId = form ? form.id : null
	const data = {label, localeKey, parameterName, type, placeholder, defaultValue, description, fieldGroup, minimumValue, maximumValue, candidateValues, suggestValues, formId}
	return data
}

const FormFieldBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
export default FormFieldBase



