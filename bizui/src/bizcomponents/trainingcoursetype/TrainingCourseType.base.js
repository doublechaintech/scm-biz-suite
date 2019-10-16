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


const menuData = {menuName:"培训课程类型", menuFor: "trainingCourseType",
  		subItems: [
  {name: 'companyTrainingList', displayName:'公司培训', icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"培训课程类型", menuFor: "trainingCourseType",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  code: '代码',
  company: '公司',
  name: '名称',
  description: '描述',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'trainingCourseType') , sorter: true },
  { title: fieldLabels.code, debugtype: 'string', dataIndex: 'code', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.company, dataIndex: 'company', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '20',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(trainingCourseType,targetComponent)=>{

  const userContext = null
  return (
    <div key={trainingCourseType.id}>
	
      <DescriptionList  key={trainingCourseType.id} size="small" col="4">
        <Description term="序号">{trainingCourseType.id}</Description> 
        <Description term="代码">{trainingCourseType.code}</Description> 
        <Description term="名称">{trainingCourseType.name}</Description> 
        <Description term="描述">{trainingCourseType.description}</Description> 
	
        
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

const TrainingCourseTypeBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
export default TrainingCourseTypeBase



