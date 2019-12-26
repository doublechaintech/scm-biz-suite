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



const menuData = {menuName: window.trans('generic_form'), menuFor: "genericForm",
  		subItems: [
  {name: 'formMessageList', displayName: window.mtrans('form_message','generic_form.form_message_list',false), type:'formMessage',icon:'wpforms',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'formFieldMessageList', displayName: window.mtrans('form_field_message','generic_form.form_field_message_list',false), type:'formFieldMessage',icon:'wpforms',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'formFieldList', displayName: window.mtrans('form_field','generic_form.form_field_list',false), type:'formField',icon:'wpforms',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'formActionList', displayName: window.mtrans('form_action','generic_form.form_action_list',false), type:'formAction',icon:'wpforms',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('generic_form'), menuFor: "genericForm",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('generic_form.id'),
  title: window.trans('generic_form.title'),
  description: window.trans('generic_form.description'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'genericForm') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '16',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(genericForm, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
  const userContext = null
  return (
    <div key={genericForm.id}>
	
      <DescriptionList  key={genericForm.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{genericForm.id}</Description> 
        <Description term={fieldLabels.title} style={{wordBreak: 'break-all'}}>{genericForm.title}</Description> 
        <Description term={fieldLabels.description} style={{wordBreak: 'break-all'}}>{genericForm.description}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {title, description} = formValuesToPack

	const data = {title, description}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {title, description} = objectToUnpack

	const data = {title, description}
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
const GenericFormBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default GenericFormBase



