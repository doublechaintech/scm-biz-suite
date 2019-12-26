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



const menuData = {menuName: window.trans('form_message'), menuFor: "formMessage",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('form_message'), menuFor: "formMessage",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('form_message.id'),
  title: window.trans('form_message.title'),
  form: window.trans('form_message.form'),
  level: window.trans('form_message.level'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'formMessage') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.form, dataIndex: 'form', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.level, debugtype: 'string', dataIndex: 'level', width: '11',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(formMessage, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
  const userContext = null
  return (
    <div key={formMessage.id}>
	
      <DescriptionList  key={formMessage.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{formMessage.id}</Description> 
        <Description term={fieldLabels.title} style={{wordBreak: 'break-all'}}>{formMessage.title}</Description> 
        <Description term={fieldLabels.level} style={{wordBreak: 'break-all'}}>{formMessage.level}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {title, level, formId} = formValuesToPack
	const form = {id: formId, version: 2^31}
	const data = {title, level, form}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {title, level, form} = objectToUnpack
	const formId = form ? form.id : null
	const data = {title, level, formId}
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
const FormMessageBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default FormMessageBase



