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
const menuData = {menuName:"雇佣终止类型", menuFor: "terminationType",
  		subItems: [
  {name: 'terminationList', displayName:'雇佣终止', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('termination_type'), menuFor: "terminationType",
  		subItems: [
  {name: 'terminationList', displayName: window.mtrans('termination','termination_type.termination_list',false), type:'termination',icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('termination_type'), menuFor: "terminationType",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('termination_type.id'),
  code: window.trans('termination_type.code'),
  company: window.trans('termination_type.company'),
  baseDescription: window.trans('termination_type.base_description'),
  detailDescription: window.trans('termination_type.detail_description'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'terminationType') , sorter: true },
  { title: fieldLabels.code, debugtype: 'string', dataIndex: 'code', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.company, dataIndex: 'company', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.baseDescription, debugtype: 'string', dataIndex: 'baseDescription', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.detailDescription, debugtype: 'string', dataIndex: 'detailDescription', width: '66',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(terminationType,targetComponent)=>{

  const userContext = null
  return (
    <div key={terminationType.id}>
	
      <DescriptionList  key={terminationType.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{terminationType.id}</Description> 
        <Description term={fieldLabels.code} style={{wordBreak: 'break-all'}}>{terminationType.code}</Description> 
        <Description term={fieldLabels.baseDescription} style={{wordBreak: 'break-all'}}>{terminationType.baseDescription}</Description> 
        <Description term={fieldLabels.detailDescription} style={{wordBreak: 'break-all'}}>{terminationType.detailDescription}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"雇佣终止类型", menuFor: "terminationType",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  code: '代码',
  company: '公司',
  baseDescription: '基本描述',
  detailDescription: '详细描述',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'terminationType') , sorter: true },
  { title: fieldLabels.code, debugtype: 'string', dataIndex: 'code', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.company, dataIndex: 'company', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.baseDescription, debugtype: 'string', dataIndex: 'baseDescription', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.detailDescription, debugtype: 'string', dataIndex: 'detailDescription', width: '66',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(terminationType,targetComponent)=>{

  const userContext = null
  return (
    <div key={terminationType.id}>
	
      <DescriptionList  key={terminationType.id} size="small" col="4">
        <Description term="序号">{terminationType.id}</Description> 
        <Description term="代码">{terminationType.code}</Description> 
        <Description term="基本描述">{terminationType.baseDescription}</Description> 
        <Description term="详细描述">{terminationType.detailDescription}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {code, baseDescription, detailDescription, companyId} = formValuesToPack
	const company = {id: companyId, version: 2^31}
	const data = {code, baseDescription, detailDescription, company}
	return data
}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {code, baseDescription, detailDescription, companyId} = formValuesToPack
	const company = {id: companyId, version: 2^31}
	const data = {code, baseDescription, detailDescription, company}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {code, baseDescription, detailDescription, company} = objectToUnpack
	const companyId = company ? company.id : null
	const data = {code, baseDescription, detailDescription, companyId}
	return data
}
<<<<<<< HEAD

const TerminationTypeBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const TerminationTypeBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default TerminationTypeBase



