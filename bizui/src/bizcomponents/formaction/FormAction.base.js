import React from 'react'
import { Icon,Divider, Avata, Card, Col} from 'antd'

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



const menuData = {menuName: window.trans('form_action'), menuFor: "formAction",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('form_action'), menuFor: "formAction",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('form_action.id'),
  label: window.trans('form_action.label'),
  localeKey: window.trans('form_action.locale_key'),
  actionKey: window.trans('form_action.action_key'),
  level: window.trans('form_action.level'),
  url: window.trans('form_action.url'),
  form: window.trans('form_action.form'),

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


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(formAction, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
  const userContext = null
  return (
    <div key={formAction.id}>
	
      <DescriptionList  key={formAction.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{formAction.id}</Description> 
        <Description term={fieldLabels.label} style={{wordBreak: 'break-all'}}>{formAction.label}</Description> 
        <Description term={fieldLabels.localeKey} style={{wordBreak: 'break-all'}}>{formAction.localeKey}</Description> 
        <Description term={fieldLabels.actionKey} style={{wordBreak: 'break-all'}}>{formAction.actionKey}</Description> 
        <Description term={fieldLabels.level} style={{wordBreak: 'break-all'}}>{formAction.level}</Description> 
        <Description term={fieldLabels.url} style={{wordBreak: 'break-all'}}>{formAction.url}</Description> 
	
        
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
const FormActionBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default FormActionBase



