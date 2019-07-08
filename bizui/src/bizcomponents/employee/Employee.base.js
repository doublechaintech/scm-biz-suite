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


const menuData = {menuName:"Employee", menuFor: "employee",
  		subItems: [
  {name: 'employeeCompanyTrainingList', displayName:'Employee Company Training', icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeSkillList', displayName:'Employee Skill', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeePerformanceList', displayName:'Employee Performance', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeWorkExperienceList', displayName:'Employee Work Experience', icon:'phoenix-framework',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeLeaveList', displayName:'Employee Leave', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeInterviewList', displayName:'Employee Interview', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeAttendanceList', displayName:'Employee Attendance', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeQualifierList', displayName:'Employee Qualifier', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeEducationList', displayName:'Employee Education', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeAwardList', displayName:'Employee Award', icon:'award',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeSalarySheetList', displayName:'Employee Salary Sheet', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'payingOffList', displayName:'Paying Off', icon:'coffee',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'Id',
  company: 'Company',
  title: 'Title',
  department: 'Department',
  familyName: 'Family Name',
  givenName: 'Given Name',
  email: 'Email',
  city: 'City',
  address: 'Address',
  cellPhone: 'Cell Phone',
  occupation: 'Occupation',
  responsibleFor: 'Responsible For',
  currentSalaryGrade: 'Current Salary Grade',
  salaryAccount: 'Salary Account',
  jobApplication: 'Job Application',
  professionInterview: 'Profession Interview',
  hrInterview: 'Hr Interview',
  offerApproval: 'Offer Approval',
  offerAcceptance: 'Offer Acceptance',
  employeeBoarding: 'Employee Boarding',
  termination: 'Termination',
  lastUpdateTime: 'Last Update Time',
  currentStatus: 'Current Status',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'employee') , sorter: true },
  { title: fieldLabels.company, dataIndex: 'company', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.department, dataIndex: 'department', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.familyName, debugtype: 'string', dataIndex: 'familyName', width: '5',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.givenName, debugtype: 'string', dataIndex: 'givenName', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.email, debugtype: 'string_email', dataIndex: 'email', width: '17',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.city, debugtype: 'string', dataIndex: 'city', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.address, debugtype: 'string', dataIndex: 'address', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.cellPhone, debugtype: 'string_china_mobile_phone', dataIndex: 'cellPhone', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.occupation, dataIndex: 'occupation', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.responsibleFor, dataIndex: 'responsibleFor', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.currentSalaryGrade, dataIndex: 'currentSalaryGrade', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.salaryAccount, debugtype: 'string', dataIndex: 'salaryAccount', width: '19',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.jobApplication, dataIndex: 'jobApplication', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.professionInterview, dataIndex: 'professionInterview', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.hrInterview, dataIndex: 'hrInterview', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.offerApproval, dataIndex: 'offerApproval', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.offerAcceptance, dataIndex: 'offerAcceptance', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.employeeBoarding, dataIndex: 'employeeBoarding', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.termination, dataIndex: 'termination', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.currentStatus, debugtype: 'string', dataIndex: 'currentStatus', width: '26',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(employee,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={employee.id}>
	
	<DescriptionList  key={employee.id} size="small" col="4">
<Description term="Id">{employee.id}</Description> 
<Description term="Title">{employee.title}</Description> 
<Description term="Department">{employee.department==null?appLocaleName(userContext,"NotAssigned"):`${employee.department.displayName}(${employee.department.id})`}
</Description>
<Description term="Family Name">{employee.familyName}</Description> 
<Description term="Given Name">{employee.givenName}</Description> 
<Description term="Email">{employee.email}</Description> 
<Description term="City">{employee.city}</Description> 
<Description term="Address">{employee.address}</Description> 
<Description term="Cell Phone">{employee.cellPhone}</Description> 
<Description term="Occupation">{employee.occupation==null?appLocaleName(userContext,"NotAssigned"):`${employee.occupation.displayName}(${employee.occupation.id})`}
</Description>
<Description term="Responsible For">{employee.responsibleFor==null?appLocaleName(userContext,"NotAssigned"):`${employee.responsibleFor.displayName}(${employee.responsibleFor.id})`}
</Description>
<Description term="Current Salary Grade">{employee.currentSalaryGrade==null?appLocaleName(userContext,"NotAssigned"):`${employee.currentSalaryGrade.displayName}(${employee.currentSalaryGrade.id})`}
</Description>
<Description term="Salary Account">{employee.salaryAccount}</Description> 
<Description term="Termination">{employee.termination==null?appLocaleName(userContext,"NotAssigned"):`${employee.termination.displayName}(${employee.termination.id})`}
</Description>
<Description term="Last Update Time">{ moment(employee.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
<Description term="Current Status">{employee.currentStatus}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const EmployeeBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default EmployeeBase



