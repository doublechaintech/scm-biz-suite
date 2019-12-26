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
const menuData = {menuName:"通用的形式", menuFor: "genericForm",
  		subItems: [
  {name: 'formMessageList', displayName:'表单信息', icon:'wpforms',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'formFieldMessageList', displayName:'表单字段的信息', icon:'wpforms',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'formFieldList', displayName:'表单字段', icon:'wpforms',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'formActionList', displayName:'表单动作', icon:'wpforms',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('generic_form'), menuFor: "genericForm",
  		subItems: [
  {name: 'formMessageList', displayName: window.mtrans('form_message','generic_form.form_message_list',false), type:'formMessage',icon:'wpforms',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'formFieldMessageList', displayName: window.mtrans('form_field_message','generic_form.form_field_message_list',false), type:'formFieldMessage',icon:'wpforms',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'formFieldList', displayName: window.mtrans('form_field','generic_form.form_field_list',false), type:'formField',icon:'wpforms',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'formActionList', displayName: window.mtrans('form_action','generic_form.form_action_list',false), type:'formAction',icon:'wpforms',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}


<<<<<<< HEAD
const settingMenuData = {menuName:"通用的形式", menuFor: "genericForm",
=======
const settingMenuData = {menuName: window.trans('generic_form'), menuFor: "genericForm",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

const fieldLabels = {
<<<<<<< HEAD
  id: 'ID',
  title: '标题',
  description: '描述',
=======
  id: window.trans('generic_form.id'),
  title: window.trans('generic_form.title'),
  description: window.trans('generic_form.description'),
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'genericForm') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '16',render: (text, record)=>renderTextCell(text,record)},

]
<<<<<<< HEAD
// refernce to https://ant.design/components/list-cn/
=======


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const renderItemOfList=(genericForm,targetComponent)=>{

  const userContext = null
  return (
    <div key={genericForm.id}>
	
<<<<<<< HEAD
      <DescriptionList  key={genericForm.id} size="small" col="4">
        <Description term="ID">{genericForm.id}</Description> 
        <Description term="标题">{genericForm.title}</Description> 
        <Description term="描述">{genericForm.description}</Description> 
=======
      <DescriptionList  key={genericForm.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{genericForm.id}</Description> 
        <Description term={fieldLabels.title} style={{wordBreak: 'break-all'}}>{genericForm.title}</Description> 
        <Description term={fieldLabels.description} style={{wordBreak: 'break-all'}}>{genericForm.description}</Description> 
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
	
        
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
<<<<<<< HEAD

const GenericFormBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const GenericFormBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default GenericFormBase



