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



const menuData = {menuName: window.trans('training_course_type'), menuFor: "trainingCourseType",
  		subItems: [
  {name: 'companyTrainingList', displayName: window.mtrans('company_training','training_course_type.company_training_list',false), type:'companyTraining',icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('training_course_type'), menuFor: "trainingCourseType",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('training_course_type.id'),
  code: window.trans('training_course_type.code'),
  company: window.trans('training_course_type.company'),
  name: window.trans('training_course_type.name'),
  description: window.trans('training_course_type.description'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'trainingCourseType') , sorter: true },
  { title: fieldLabels.code, debugtype: 'string', dataIndex: 'code', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.company, dataIndex: 'company', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '20',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(trainingCourseType,targetComponent)=>{

  const userContext = null
  return (
    <div key={trainingCourseType.id}>
	
      <DescriptionList  key={trainingCourseType.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{trainingCourseType.id}</Description> 
        <Description term={fieldLabels.code} style={{wordBreak: 'break-all'}}>{trainingCourseType.code}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{trainingCourseType.name}</Description> 
        <Description term={fieldLabels.description} style={{wordBreak: 'break-all'}}>{trainingCourseType.description}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {code, name, description, companyId} = formValuesToPack
	const company = {id: companyId, version: 2^31}
	const data = {code, name, description, company}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {code, name, description, company} = objectToUnpack
	const companyId = company ? company.id : null
	const data = {code, name, description, companyId}
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
const TrainingCourseTypeBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default TrainingCourseTypeBase



