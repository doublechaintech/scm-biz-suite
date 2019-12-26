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



const menuData = {menuName: window.trans('occupation_type'), menuFor: "occupationType",
  		subItems: [
  {name: 'employeeList', displayName: window.mtrans('employee','occupation_type.employee_list',false), type:'employee',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('occupation_type'), menuFor: "occupationType",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('occupation_type.id'),
  code: window.trans('occupation_type.code'),
  company: window.trans('occupation_type.company'),
  description: window.trans('occupation_type.description'),
  detailDescription: window.trans('occupation_type.detail_description'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'occupationType') , sorter: true },
  { title: fieldLabels.code, debugtype: 'string', dataIndex: 'code', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.company, dataIndex: 'company', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.detailDescription, debugtype: 'string', dataIndex: 'detailDescription', width: '65',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(occupationType, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
  const userContext = null
  return (
    <div key={occupationType.id}>
	
      <DescriptionList  key={occupationType.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{occupationType.id}</Description> 
        <Description term={fieldLabels.code} style={{wordBreak: 'break-all'}}>{occupationType.code}</Description> 
        <Description term={fieldLabels.description} style={{wordBreak: 'break-all'}}>{occupationType.description}</Description> 
        <Description term={fieldLabels.detailDescription} style={{wordBreak: 'break-all'}}>{occupationType.detailDescription}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {code, description, detailDescription, companyId} = formValuesToPack
	const company = {id: companyId, version: 2^31}
	const data = {code, description, detailDescription, company}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {code, description, detailDescription, company} = objectToUnpack
	const companyId = company ? company.id : null
	const data = {code, description, detailDescription, companyId}
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
const OccupationTypeBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default OccupationTypeBase



