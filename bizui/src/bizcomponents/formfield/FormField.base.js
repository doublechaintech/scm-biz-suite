import React from 'react'
import { Icon,Divider, Avatar, Card, Col, Tag} from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
import styles from './FormField.base.less'
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
	defaultSearchLocalData,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderAvatarCell=defaultRenderAvatarCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell



const menuData = {menuName: window.trans('form_field'), menuFor: "formField",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('form_field'), menuFor: "formField",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('form_field.id'),
  label: window.trans('form_field.label'),
  localeKey: window.trans('form_field.locale_key'),
  parameterName: window.trans('form_field.parameter_name'),
  type: window.trans('form_field.type'),
  form: window.trans('form_field.form'),
  placeholder: window.trans('form_field.placeholder'),
  defaultValue: window.trans('form_field.default_value'),
  description: window.trans('form_field.description'),
  fieldGroup: window.trans('form_field.field_group'),
  minimumValue: window.trans('form_field.minimum_value'),
  maximumValue: window.trans('form_field.maximum_value'),
  required: window.trans('form_field.required'),
  disabled: window.trans('form_field.disabled'),
  customRendering: window.trans('form_field.custom_rendering'),
  candidateValues: window.trans('form_field.candidate_values'),
  suggestValues: window.trans('form_field.suggest_values'),

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


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)
const colorList = ['#f56a00', '#7265e6', '#ffbf00', '#00a2ae'];
let counter = 0;
const genColor=()=>{
	counter++;
	return colorList[counter%colorList.length];
}
const followColor=()=>{
	return 'green';
	// return colorList[counter%colorList.length];
}
const leftChars=(value, left)=>{
	const chars = left || 4
	if(!value){
		return "N/A"
	}
	return value.substring(0,chars);
}

const renderReferenceItem=(value, targetComponent)=>{
	const userContext = null
	if(!value){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.id){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.displayName){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	
	return <Tag color='blue' title={`${value.displayName}()`}>{leftChars(value.displayName)}</Tag>
	
	
	
	
}
const renderItemOfList=(formField, targetComponent, columCount)=>{
  
  if(!formField){
  	return null
  }
  if(!formField.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`formField-${formField.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(formField.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={formField.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{formField.id}</Description> 
        <Description term={fieldLabels.label} style={{wordBreak: 'break-all'}}>{formField.label}</Description> 
        <Description term={fieldLabels.localeKey} style={{wordBreak: 'break-all'}}>{formField.localeKey}</Description> 
        <Description term={fieldLabels.parameterName} style={{wordBreak: 'break-all'}}>{formField.parameterName}</Description> 
        <Description term={fieldLabels.type} style={{wordBreak: 'break-all'}}>{formField.type}</Description> 
        <Description term={fieldLabels.placeholder} style={{wordBreak: 'break-all'}}>{formField.placeholder}</Description> 
        <Description term={fieldLabels.defaultValue} style={{wordBreak: 'break-all'}}>{formField.defaultValue}</Description> 
        <Description term={fieldLabels.description} style={{wordBreak: 'break-all'}}>{formField.description}</Description> 
        <Description term={fieldLabels.fieldGroup} style={{wordBreak: 'break-all'}}>{formField.fieldGroup}</Description> 
        <Description term={fieldLabels.minimumValue} style={{wordBreak: 'break-all'}}>{formField.minimumValue}</Description> 
        <Description term={fieldLabels.maximumValue} style={{wordBreak: 'break-all'}}>{formField.maximumValue}</Description> 
        <Description term={fieldLabels.candidateValues} style={{wordBreak: 'break-all'}}>{formField.candidateValues}</Description> 
        <Description term={fieldLabels.suggestValues} style={{wordBreak: 'break-all'}}>{formField.suggestValues}</Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
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
const stepOf=(targetComponent, title, content, position, index)=>{
	return {
		title,
		content,
		position,
		packFunction: packFormValuesToObject,
		unpackFunction: unpackObjectToFormValues,
		index,
      }
}
const FormFieldBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default FormFieldBase

