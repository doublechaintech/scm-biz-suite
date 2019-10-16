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


const menuData = {menuName:"工作申请", menuFor: "jobApplication",
  		subItems: [
  {name: 'employeeList', displayName:'员工', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"工作申请", menuFor: "jobApplication",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  applicationTime: '申请时间',
  who: '谁',
  comments: '评论',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'jobApplication') , sorter: true },
  { title: fieldLabels.applicationTime, dataIndex: 'applicationTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.comments, debugtype: 'string', dataIndex: 'comments', width: '35',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(jobApplication,targetComponent)=>{

  const userContext = null
  return (
    <div key={jobApplication.id}>
	
      <DescriptionList  key={jobApplication.id} size="small" col="4">
        <Description term="序号">{jobApplication.id}</Description> 
        <Description term="申请时间"><div>{ moment(jobApplication.applicationTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term="谁">{jobApplication.who}</Description> 
        <Description term="评论">{jobApplication.comments}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {applicationTime, who, comments} = formValuesToPack

	const data = {applicationTime, who, comments}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {applicationTime, who, comments} = objectToUnpack

	const data = {applicationTime, who, comments}
	return data
}

const JobApplicationBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
export default JobApplicationBase



