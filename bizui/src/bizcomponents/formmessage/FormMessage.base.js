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


const menuData = {menuName:"表单信息", menuFor: "formMessage",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"表单信息", menuFor: "formMessage",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  title: '标题',
  form: '形式',
  level: '水平',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'formMessage') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.form, dataIndex: 'form', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.level, debugtype: 'string', dataIndex: 'level', width: '11',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(formMessage,targetComponent)=>{

  const userContext = null
  return (
    <div key={formMessage.id}>
	
      <DescriptionList  key={formMessage.id} size="small" col="4">
        <Description term="ID">{formMessage.id}</Description> 
        <Description term="标题">{formMessage.title}</Description> 
        <Description term="水平">{formMessage.level}</Description> 
	
        
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

const FormMessageBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
export default FormMessageBase



