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


const menuData = {menuName:"通用的形式", menuFor: "genericForm",
  		subItems: [
  {name: 'formMessageList', displayName:'表单信息', icon:'wpforms',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'formFieldMessageList', displayName:'表单字段的信息', icon:'wpforms',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'formFieldList', displayName:'表单字段', icon:'wpforms',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'formActionList', displayName:'表单动作', icon:'wpforms',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"通用的形式", menuFor: "genericForm",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  title: '标题',
  description: '描述',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'genericForm') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '16',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(genericForm,targetComponent)=>{

  const userContext = null
  return (
    <div key={genericForm.id}>
	
      <DescriptionList  key={genericForm.id} size="small" col="4">
        <Description term="ID">{genericForm.id}</Description> 
        <Description term="标题">{genericForm.title}</Description> 
        <Description term="描述">{genericForm.description}</Description> 
	
        
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

const GenericFormBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
export default GenericFormBase



