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
const menuData = {menuName:"雇佣终止的原因", menuFor: "terminationReason",
  		subItems: [
  {name: 'terminationList', displayName:'雇佣终止', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('termination_reason'), menuFor: "terminationReason",
  		subItems: [
  {name: 'terminationList', displayName: window.mtrans('termination','termination_reason.termination_list',false), type:'termination',icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD

const settingMenuData = {menuName:"雇佣终止的原因", menuFor: "terminationReason",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  code: '代码',
  company: '公司',
  description: '描述',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'terminationReason') , sorter: true },
  { title: fieldLabels.code, debugtype: 'string', dataIndex: 'code', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.company, dataIndex: 'company', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '13',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(terminationReason,targetComponent)=>{

  const userContext = null
  return (
    <div key={terminationReason.id}>
	
      <DescriptionList  key={terminationReason.id} size="small" col="4">
        <Description term="序号">{terminationReason.id}</Description> 
        <Description term="代码">{terminationReason.code}</Description> 
        <Description term="描述">{terminationReason.description}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {code, description, companyId} = formValuesToPack
	const company = {id: companyId, version: 2^31}
	const data = {code, description, company}
	return data
}
=======

const settingMenuData = {menuName: window.trans('termination_reason'), menuFor: "terminationReason",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('termination_reason.id'),
  code: window.trans('termination_reason.code'),
  company: window.trans('termination_reason.company'),
  description: window.trans('termination_reason.description'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'terminationReason') , sorter: true },
  { title: fieldLabels.code, debugtype: 'string', dataIndex: 'code', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.company, dataIndex: 'company', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '13',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(terminationReason,targetComponent)=>{

  const userContext = null
  return (
    <div key={terminationReason.id}>
	
      <DescriptionList  key={terminationReason.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{terminationReason.id}</Description> 
        <Description term={fieldLabels.code} style={{wordBreak: 'break-all'}}>{terminationReason.code}</Description> 
        <Description term={fieldLabels.description} style={{wordBreak: 'break-all'}}>{terminationReason.description}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {code, description, companyId} = formValuesToPack
	const company = {id: companyId, version: 2^31}
	const data = {code, description, company}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {code, description, company} = objectToUnpack
	const companyId = company ? company.id : null
	const data = {code, description, companyId}
	return data
}
<<<<<<< HEAD

const TerminationReasonBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const TerminationReasonBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default TerminationReasonBase



