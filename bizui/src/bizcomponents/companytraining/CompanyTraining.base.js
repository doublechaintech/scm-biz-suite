import React from 'react'
import { Icon } from 'antd'
import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'

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


const menuData = {menuName:"公司培训", menuFor: "companyTraining",
  		subItems: [
  {name: 'employeeCompanyTrainingList', displayName:'员工参与的公司培训', icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: '序号',
  title: '头衔',
  company: '公司',
  instructor: '讲师',
  trainingCourseType: '培训课程类型',
  timeStart: '时间开始',
  durationHours: '持续时间',
  lastUpdateTime: '最后更新时间',

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
const renderItemOfList=({companyTraining,targetComponent})=>{

	
	
	const {CompanyTrainingService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{companyTraining.id}</Description> 
<Description term="头衔">{companyTraining.title}</Description> 
<Description term="讲师">{companyTraining.instructor==null?appLocaleName(userContext,"NotAssigned"):`${companyTraining.instructor.displayName}(${companyTraining.instructor.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"讲师","instructor",CompanyTrainingService.requestCandidateInstructor,
	      CompanyTrainingService.transferToAnotherInstructor,"anotherInstructorId",companyTraining.instructor?companyTraining.instructor.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="培训课程类型">{companyTraining.trainingCourseType==null?appLocaleName(userContext,"NotAssigned"):`${companyTraining.trainingCourseType.displayName}(${companyTraining.trainingCourseType.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"培训课程类型","trainingCourseType",CompanyTrainingService.requestCandidateTrainingCourseType,
	      CompanyTrainingService.transferToAnotherTrainingCourseType,"anotherTrainingCourseTypeId",companyTraining.trainingCourseType?companyTraining.trainingCourseType.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="时间开始">{ moment(companyTraining.timeStart).format('YYYY-MM-DD')}</Description> 
<Description term="持续时间">{companyTraining.durationHours}</Description> 
<Description term="最后更新时间">{ moment(companyTraining.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(companyTraining,targetComponent)}
      </DescriptionList>
	)

}
	



const CompanyTrainingBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default CompanyTrainingBase



