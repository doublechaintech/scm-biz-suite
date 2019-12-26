import React from 'react'
<<<<<<< HEAD
import { Icon,Divider } from 'antd'
=======
import { Icon,Divider, Avata, Card, Col} from 'antd'
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
<<<<<<< HEAD
=======

>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
<<<<<<< HEAD
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
=======
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
	defaultSearchLocalData,
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
<<<<<<< HEAD
=======
const renderAvatarCell=defaultRenderAvatarCell
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


<<<<<<< HEAD
const menuData = {menuName:"表单动作", menuFor: "formAction",
=======

const menuData = {menuName: window.trans('form_action'), menuFor: "formAction",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}


<<<<<<< HEAD
const settingMenuData = {menuName:"表单动作", menuFor: "formAction",
=======
const settingMenuData = {menuName: window.trans('form_action'), menuFor: "formAction",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

const fieldLabels = {
<<<<<<< HEAD
  id: 'ID',
  label: '标签',
  localeKey: '语言环境的关键',
  actionKey: '操作',
  level: '水平',
  url: 'url',
  form: '形式',
=======
  id: window.trans('form_action.id'),
  label: window.trans('form_action.label'),
  localeKey: window.trans('form_action.locale_key'),
  actionKey: window.trans('form_action.action_key'),
  level: window.trans('form_action.level'),
  url: window.trans('form_action.url'),
  form: window.trans('form_action.form'),
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

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
<<<<<<< HEAD
// refernce to https://ant.design/components/list-cn/
=======


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const renderItemOfList=(formAction,targetComponent)=>{

  const userContext = null
  return (
    <div key={formAction.id}>
	
<<<<<<< HEAD
      <DescriptionList  key={formAction.id} size="small" col="4">
        <Description term="ID">{formAction.id}</Description> 
        <Description term="标签">{formAction.label}</Description> 
        <Description term="语言环境的关键">{formAction.localeKey}</Description> 
        <Description term="操作">{formAction.actionKey}</Description> 
        <Description term="水平">{formAction.level}</Description> 
        <Description term="url">{formAction.url}</Description> 
=======
      <DescriptionList  key={formAction.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{formAction.id}</Description> 
        <Description term={fieldLabels.label} style={{wordBreak: 'break-all'}}>{formAction.label}</Description> 
        <Description term={fieldLabels.localeKey} style={{wordBreak: 'break-all'}}>{formAction.localeKey}</Description> 
        <Description term={fieldLabels.actionKey} style={{wordBreak: 'break-all'}}>{formAction.actionKey}</Description> 
        <Description term={fieldLabels.level} style={{wordBreak: 'break-all'}}>{formAction.level}</Description> 
        <Description term={fieldLabels.url} style={{wordBreak: 'break-all'}}>{formAction.url}</Description> 
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
	
        
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
<<<<<<< HEAD

const FormActionBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
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
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default FormActionBase



