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



const menuData = {menuName: window.trans('employee'), menuFor: "employee",
  		subItems: [
  {name: 'employeeCompanyTrainingList', displayName: window.mtrans('employee_company_training','employee.employee_company_training_list',false), type:'employeeCompanyTraining',icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeSkillList', displayName: window.mtrans('employee_skill','employee.employee_skill_list',false), type:'employeeSkill',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeePerformanceList', displayName: window.mtrans('employee_performance','employee.employee_performance_list',false), type:'employeePerformance',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeWorkExperienceList', displayName: window.mtrans('employee_work_experience','employee.employee_work_experience_list',false), type:'employeeWorkExperience',icon:'phoenix-framework',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeLeaveList', displayName: window.mtrans('employee_leave','employee.employee_leave_list',false), type:'employeeLeave',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeInterviewList', displayName: window.mtrans('employee_interview','employee.employee_interview_list',false), type:'employeeInterview',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeAttendanceList', displayName: window.mtrans('employee_attendance','employee.employee_attendance_list',false), type:'employeeAttendance',icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeQualifierList', displayName: window.mtrans('employee_qualifier','employee.employee_qualifier_list',false), type:'employeeQualifier',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeEducationList', displayName: window.mtrans('employee_education','employee.employee_education_list',false), type:'employeeEducation',icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeAwardList', displayName: window.mtrans('employee_award','employee.employee_award_list',false), type:'employeeAward',icon:'award',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeSalarySheetList', displayName: window.mtrans('employee_salary_sheet','employee.employee_salary_sheet_list',false), type:'employeeSalarySheet',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'payingOffList', displayName: window.mtrans('paying_off','employee.paying_off_list',false), type:'payingOff',icon:'coffee',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('employee'), menuFor: "employee",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('employee.id'),
  company: window.trans('employee.company'),
  title: window.trans('employee.title'),
  department: window.trans('employee.department'),
  familyName: window.trans('employee.family_name'),
  givenName: window.trans('employee.given_name'),
  email: window.trans('employee.email'),
  city: window.trans('employee.city'),
  address: window.trans('employee.address'),
  cellPhone: window.trans('employee.cell_phone'),
  occupation: window.trans('employee.occupation'),
  responsibleFor: window.trans('employee.responsible_for'),
  currentSalaryGrade: window.trans('employee.current_salary_grade'),
  salaryAccount: window.trans('employee.salary_account'),
  jobApplication: window.trans('employee.job_application'),
  professionInterview: window.trans('employee.profession_interview'),
  hrInterview: window.trans('employee.hr_interview'),
  offerApproval: window.trans('employee.offer_approval'),
  offerAcceptance: window.trans('employee.offer_acceptance'),
  employeeBoarding: window.trans('employee.employee_boarding'),
  termination: window.trans('employee.termination'),
  lastUpdateTime: window.trans('employee.last_update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employee') , sorter: true },
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

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(employee,targetComponent)=>{

  const userContext = null
  return (
    <div key={employee.id}>
	
      <DescriptionList  key={employee.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{employee.id}</Description> 
        <Description term={fieldLabels.title} style={{wordBreak: 'break-all'}}>{employee.title}</Description> 
        <Description term={fieldLabels.department}><div>{employee.department==null?appLocaleName(userContext,"NotAssigned"):`${employee.department.displayName}(${employee.department.id})`}
        </div></Description>
        <Description term={fieldLabels.familyName} style={{wordBreak: 'break-all'}}>{employee.familyName}</Description> 
        <Description term={fieldLabels.givenName} style={{wordBreak: 'break-all'}}>{employee.givenName}</Description> 
        <Description term={fieldLabels.email} style={{wordBreak: 'break-all'}}>{employee.email}</Description> 
        <Description term={fieldLabels.city} style={{wordBreak: 'break-all'}}>{employee.city}</Description> 
        <Description term={fieldLabels.address} style={{wordBreak: 'break-all'}}>{employee.address}</Description> 
        <Description term={fieldLabels.cellPhone} style={{wordBreak: 'break-all'}}>{employee.cellPhone}</Description> 
        <Description term={fieldLabels.occupation}><div>{employee.occupation==null?appLocaleName(userContext,"NotAssigned"):`${employee.occupation.displayName}(${employee.occupation.id})`}
        </div></Description>
        <Description term={fieldLabels.responsibleFor}><div>{employee.responsibleFor==null?appLocaleName(userContext,"NotAssigned"):`${employee.responsibleFor.displayName}(${employee.responsibleFor.id})`}
        </div></Description>
        <Description term={fieldLabels.currentSalaryGrade}><div>{employee.currentSalaryGrade==null?appLocaleName(userContext,"NotAssigned"):`${employee.currentSalaryGrade.displayName}(${employee.currentSalaryGrade.id})`}
        </div></Description>
        <Description term={fieldLabels.salaryAccount} style={{wordBreak: 'break-all'}}>{employee.salaryAccount}</Description> 
        <Description term={fieldLabels.termination}><div>{employee.termination==null?appLocaleName(userContext,"NotAssigned"):`${employee.termination.displayName}(${employee.termination.id})`}
        </div></Description>
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(employee.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {title, familyName, givenName, email, city, address, cellPhone, salaryAccount, companyId, departmentId, occupationId, responsibleForId, currentSalaryGradeId, jobApplicationId, professionInterviewId, hrInterviewId, offerApprovalId, offerAcceptanceId, employeeBoardingId, terminationId} = formValuesToPack
	const company = {id: companyId, version: 2^31}
	const department = {id: departmentId, version: 2^31}
	const occupation = {id: occupationId, version: 2^31}
	const responsibleFor = {id: responsibleForId, version: 2^31}
	const currentSalaryGrade = {id: currentSalaryGradeId, version: 2^31}
	const jobApplication = {id: jobApplicationId, version: 2^31}
	const professionInterview = {id: professionInterviewId, version: 2^31}
	const hrInterview = {id: hrInterviewId, version: 2^31}
	const offerApproval = {id: offerApprovalId, version: 2^31}
	const offerAcceptance = {id: offerAcceptanceId, version: 2^31}
	const employeeBoarding = {id: employeeBoardingId, version: 2^31}
	const termination = {id: terminationId, version: 2^31}
	const data = {title, familyName, givenName, email, city, address, cellPhone, salaryAccount, company, department, occupation, responsibleFor, currentSalaryGrade, jobApplication, professionInterview, hrInterview, offerApproval, offerAcceptance, employeeBoarding, termination}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {title, familyName, givenName, email, city, address, cellPhone, salaryAccount, company, department, occupation, responsibleFor, currentSalaryGrade, jobApplication, professionInterview, hrInterview, offerApproval, offerAcceptance, employeeBoarding, termination} = objectToUnpack
	const companyId = company ? company.id : null
	const departmentId = department ? department.id : null
	const occupationId = occupation ? occupation.id : null
	const responsibleForId = responsibleFor ? responsibleFor.id : null
	const currentSalaryGradeId = currentSalaryGrade ? currentSalaryGrade.id : null
	const jobApplicationId = jobApplication ? jobApplication.id : null
	const professionInterviewId = professionInterview ? professionInterview.id : null
	const hrInterviewId = hrInterview ? hrInterview.id : null
	const offerApprovalId = offerApproval ? offerApproval.id : null
	const offerAcceptanceId = offerAcceptance ? offerAcceptance.id : null
	const employeeBoardingId = employeeBoarding ? employeeBoarding.id : null
	const terminationId = termination ? termination.id : null
	const data = {title, familyName, givenName, email, city, address, cellPhone, salaryAccount, companyId, departmentId, occupationId, responsibleForId, currentSalaryGradeId, jobApplicationId, professionInterviewId, hrInterviewId, offerApprovalId, offerAcceptanceId, employeeBoardingId, terminationId}
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
const EmployeeBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default EmployeeBase



