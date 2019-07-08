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


const menuData = {menuName:"Company Training", menuFor: "companyTraining",
  		subItems: [
  {name: 'employeeCompanyTrainingList', displayName:'Employee Company Training', icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'Id',
  title: 'Title',
  company: 'Company',
  instructor: 'Instructor',
  trainingCourseType: 'Training Course Type',
  timeStart: 'Time Start',
  durationHours: 'Duration Hours',
  lastUpdateTime: 'Last Update Time',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'companyTraining') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.company, dataIndex: 'company', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.instructor, dataIndex: 'instructor', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.trainingCourseType, dataIndex: 'trainingCourseType', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.timeStart, dataIndex: 'timeStart', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.durationHours, debugtype: 'int', dataIndex: 'durationHours', width: '5',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(companyTraining,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={companyTraining.id}>
	
	<DescriptionList  key={companyTraining.id} size="small" col="4">
<Description term="Id">{companyTraining.id}</Description> 
<Description term="Title">{companyTraining.title}</Description> 
<Description term="Instructor">{companyTraining.instructor==null?appLocaleName(userContext,"NotAssigned"):`${companyTraining.instructor.displayName}(${companyTraining.instructor.id})`}
</Description>
<Description term="Training Course Type">{companyTraining.trainingCourseType==null?appLocaleName(userContext,"NotAssigned"):`${companyTraining.trainingCourseType.displayName}(${companyTraining.trainingCourseType.id})`}
</Description>
<Description term="Time Start">{ moment(companyTraining.timeStart).format('YYYY-MM-DD')}</Description> 
<Description term="Duration Hours">{companyTraining.durationHours}</Description> 
<Description term="Last Update Time">{ moment(companyTraining.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const CompanyTrainingBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default CompanyTrainingBase



