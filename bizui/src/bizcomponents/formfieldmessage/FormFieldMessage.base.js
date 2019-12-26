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
const menuData = {menuName:"表单字段的信息", menuFor: "formFieldMessage",
=======

const menuData = {menuName: window.trans('form_field_message'), menuFor: "formFieldMessage",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}


<<<<<<< HEAD
const settingMenuData = {menuName:"表单字段的信息", menuFor: "formFieldMessage",
=======
const settingMenuData = {menuName: window.trans('form_field_message'), menuFor: "formFieldMessage",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

const fieldLabels = {
<<<<<<< HEAD
  id: 'ID',
  title: '标题',
  parameterName: '参数名称',
  form: '形式',
  level: '水平',
=======
  id: window.trans('form_field_message.id'),
  title: window.trans('form_field_message.title'),
  parameterName: window.trans('form_field_message.parameter_name'),
  form: window.trans('form_field_message.form'),
  level: window.trans('form_field_message.level'),
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'formFieldMessage') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.parameterName, debugtype: 'string', dataIndex: 'parameterName', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.form, dataIndex: 'form', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.level, debugtype: 'string', dataIndex: 'level', width: '11',render: (text, record)=>renderTextCell(text,record)},

]
<<<<<<< HEAD
// refernce to https://ant.design/components/list-cn/
=======


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const renderItemOfList=(formFieldMessage,targetComponent)=>{

  const userContext = null
  return (
    <div key={formFieldMessage.id}>
	
<<<<<<< HEAD
      <DescriptionList  key={formFieldMessage.id} size="small" col="4">
        <Description term="ID">{formFieldMessage.id}</Description> 
        <Description term="标题">{formFieldMessage.title}</Description> 
        <Description term="参数名称">{formFieldMessage.parameterName}</Description> 
        <Description term="水平">{formFieldMessage.level}</Description> 
=======
      <DescriptionList  key={formFieldMessage.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{formFieldMessage.id}</Description> 
        <Description term={fieldLabels.title} style={{wordBreak: 'break-all'}}>{formFieldMessage.title}</Description> 
        <Description term={fieldLabels.parameterName} style={{wordBreak: 'break-all'}}>{formFieldMessage.parameterName}</Description> 
        <Description term={fieldLabels.level} style={{wordBreak: 'break-all'}}>{formFieldMessage.level}</Description> 
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
	
        
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
<<<<<<< HEAD

const FormFieldMessageBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const FormFieldMessageBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default FormFieldMessageBase



