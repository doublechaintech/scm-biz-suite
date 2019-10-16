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


const menuData = {menuName:"表单动作", menuFor: "formAction",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"表单动作", menuFor: "formAction",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  label: '标签',
  localeKey: '语言环境的关键',
  actionKey: '操作',
  level: '水平',
  url: 'url',
  form: '形式',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'formAction') , sorter: true },
  { title: fieldLabels.label, debugtype: 'string', dataIndex: 'label', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.localeKey, debugtype: 'string', dataIndex: 'localeKey', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.actionKey, debugtype: 'string', dataIndex: 'actionKey', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.level, debugtype: 'string', dataIndex: 'level', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.url, debugtype: 'string', dataIndex: 'url', width: '46',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.form, dataIndex: 'form', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(formAction,targetComponent)=>{

  const userContext = null
  return (
    <div key={formAction.id}>
	
      <DescriptionList  key={formAction.id} size="small" col="4">
        <Description term="ID">{formAction.id}</Description> 
        <Description term="标签">{formAction.label}</Description> 
        <Description term="语言环境的关键">{formAction.localeKey}</Description> 
        <Description term="操作">{formAction.actionKey}</Description> 
        <Description term="水平">{formAction.level}</Description> 
        <Description term="url">{formAction.url}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {label, localeKey, actionKey, level, url, formId} = formValuesToPack
	const form = {id: formId, version: 2^31}
	const data = {label, localeKey, actionKey, level, url, form}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {label, localeKey, actionKey, level, url, form} = objectToUnpack
	const formId = form ? form.id : null
	const data = {label, localeKey, actionKey, level, url, formId}
	return data
}

const FormActionBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
export default FormActionBase



