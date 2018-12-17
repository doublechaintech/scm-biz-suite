import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}employeeManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}employeeManager/loadEmployee/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateCompany = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeManager/requestCandidateCompany/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCompany = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}employeeManager/transferToAnotherCompany/id/anotherCompanyId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateDepartment = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeManager/requestCandidateDepartment/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherDepartment = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}employeeManager/transferToAnotherDepartment/id/anotherDepartmentId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateOccupation = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeManager/requestCandidateOccupation/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherOccupation = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}employeeManager/transferToAnotherOccupation/id/anotherOccupationId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateResponsibleFor = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeManager/requestCandidateResponsibleFor/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherResponsibleFor = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}employeeManager/transferToAnotherResponsibleFor/id/anotherResponsibleForId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateCurrentSalaryGrade = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeManager/requestCandidateCurrentSalaryGrade/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCurrentSalaryGrade = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}employeeManager/transferToAnotherCurrentSalaryGrade/id/anotherCurrentSalaryGradeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateJobApplication = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeManager/requestCandidateJobApplication/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherJobApplication = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}employeeManager/transferToAnotherJobApplication/id/anotherJobApplicationId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateProfessionInterview = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeManager/requestCandidateProfessionInterview/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherProfessionInterview = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}employeeManager/transferToAnotherProfessionInterview/id/anotherProfessionInterviewId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateHrInterview = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeManager/requestCandidateHrInterview/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherHrInterview = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}employeeManager/transferToAnotherHrInterview/id/anotherHrInterviewId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateOfferApproval = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeManager/requestCandidateOfferApproval/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherOfferApproval = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}employeeManager/transferToAnotherOfferApproval/id/anotherOfferApprovalId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateOfferAcceptance = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeManager/requestCandidateOfferAcceptance/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherOfferAcceptance = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}employeeManager/transferToAnotherOfferAcceptance/id/anotherOfferAcceptanceId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateEmployeeBoarding = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeManager/requestCandidateEmployeeBoarding/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherEmployeeBoarding = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}employeeManager/transferToAnotherEmployeeBoarding/id/anotherEmployeeBoardingId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateTermination = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeManager/requestCandidateTermination/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherTermination = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}employeeManager/transferToAnotherTermination/id/anotherTerminationId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addEmployeeCompanyTraining = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/addEmployeeCompanyTraining/employeeId/trainingId/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployeeCompanyTraining = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/updateEmployeeCompanyTrainingProperties/employeeId/id/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeCompanyTrainingList = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/removeEmployeeCompanyTrainingList/employeeId/employeeCompanyTrainingIds/tokensExpr/`
  const requestParameters = { ...parameters, employeeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addEmployeeSkill = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/addEmployeeSkill/employeeId/skillTypeId/description/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployeeSkill = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/updateEmployeeSkillProperties/employeeId/id/description/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeSkillList = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/removeEmployeeSkillList/employeeId/employeeSkillIds/tokensExpr/`
  const requestParameters = { ...parameters, employeeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addEmployeePerformance = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/addEmployeePerformance/employeeId/performanceComment/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployeePerformance = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/updateEmployeePerformanceProperties/employeeId/id/performanceComment/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeePerformanceList = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/removeEmployeePerformanceList/employeeId/employeePerformanceIds/tokensExpr/`
  const requestParameters = { ...parameters, employeeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addEmployeeWorkExperience = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/addEmployeeWorkExperience/employeeId/start/end/company/description/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployeeWorkExperience = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/updateEmployeeWorkExperienceProperties/employeeId/id/start/end/company/description/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeWorkExperienceList = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/removeEmployeeWorkExperienceList/employeeId/employeeWorkExperienceIds/tokensExpr/`
  const requestParameters = { ...parameters, employeeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addEmployeeLeave = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/addEmployeeLeave/employeeId/typeId/leaveDurationHour/remark/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployeeLeave = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/updateEmployeeLeaveProperties/employeeId/id/leaveDurationHour/remark/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeLeaveList = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/removeEmployeeLeaveList/employeeId/employeeLeaveIds/tokensExpr/`
  const requestParameters = { ...parameters, employeeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addEmployeeInterview = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/addEmployeeInterview/employeeId/interviewTypeId/remark/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployeeInterview = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/updateEmployeeInterviewProperties/employeeId/id/remark/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeInterviewList = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/removeEmployeeInterviewList/employeeId/employeeInterviewIds/tokensExpr/`
  const requestParameters = { ...parameters, employeeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addEmployeeAttendance = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/addEmployeeAttendance/employeeId/enterTime/leaveTime/durationHours/remark/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployeeAttendance = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/updateEmployeeAttendanceProperties/employeeId/id/enterTime/leaveTime/durationHours/remark/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeAttendanceList = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/removeEmployeeAttendanceList/employeeId/employeeAttendanceIds/tokensExpr/`
  const requestParameters = { ...parameters, employeeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addEmployeeQualifier = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/addEmployeeQualifier/employeeId/qualifiedTime/type/level/remark/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployeeQualifier = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/updateEmployeeQualifierProperties/employeeId/id/qualifiedTime/type/level/remark/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeQualifierList = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/removeEmployeeQualifierList/employeeId/employeeQualifierIds/tokensExpr/`
  const requestParameters = { ...parameters, employeeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addEmployeeEducation = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/addEmployeeEducation/employeeId/completeTime/type/remark/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployeeEducation = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/updateEmployeeEducationProperties/employeeId/id/completeTime/type/remark/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeEducationList = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/removeEmployeeEducationList/employeeId/employeeEducationIds/tokensExpr/`
  const requestParameters = { ...parameters, employeeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addEmployeeAward = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/addEmployeeAward/employeeId/completeTime/type/remark/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployeeAward = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/updateEmployeeAwardProperties/employeeId/id/completeTime/type/remark/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeAwardList = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/removeEmployeeAwardList/employeeId/employeeAwardIds/tokensExpr/`
  const requestParameters = { ...parameters, employeeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addEmployeeSalarySheet = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/addEmployeeSalarySheet/employeeId/currentSalaryGradeId/baseSalary/bonus/reward/personalTax/socialSecurity/housingFound/jobInsurance/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployeeSalarySheet = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/updateEmployeeSalarySheetProperties/employeeId/id/baseSalary/bonus/reward/personalTax/socialSecurity/housingFound/jobInsurance/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeSalarySheetList = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/removeEmployeeSalarySheetList/employeeId/employeeSalarySheetIds/tokensExpr/`
  const requestParameters = { ...parameters, employeeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addPayingOff = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/addPayingOff/employeeId/who/paidTime/amount/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updatePayingOff = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/updatePayingOffProperties/employeeId/id/who/paidTime/amount/tokensExpr/`
  const employeeId = targetObjectId
  const requestParameters = { ...parameters, employeeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removePayingOffList = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeManager/removePayingOffList/employeeId/payingOffIds/tokensExpr/`
  const requestParameters = { ...parameters, employeeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const EmployeeService = { view,
  load,
  addEmployeeCompanyTraining,
  addEmployeeSkill,
  addEmployeePerformance,
  addEmployeeWorkExperience,
  addEmployeeLeave,
  addEmployeeInterview,
  addEmployeeAttendance,
  addEmployeeQualifier,
  addEmployeeEducation,
  addEmployeeAward,
  addEmployeeSalarySheet,
  addPayingOff,
  updateEmployeeCompanyTraining,
  updateEmployeeSkill,
  updateEmployeePerformance,
  updateEmployeeWorkExperience,
  updateEmployeeLeave,
  updateEmployeeInterview,
  updateEmployeeAttendance,
  updateEmployeeQualifier,
  updateEmployeeEducation,
  updateEmployeeAward,
  updateEmployeeSalarySheet,
  updatePayingOff,
  removeEmployeeCompanyTrainingList,
  removeEmployeeSkillList,
  removeEmployeePerformanceList,
  removeEmployeeWorkExperienceList,
  removeEmployeeLeaveList,
  removeEmployeeInterviewList,
  removeEmployeeAttendanceList,
  removeEmployeeQualifierList,
  removeEmployeeEducationList,
  removeEmployeeAwardList,
  removeEmployeeSalarySheetList,
  removePayingOffList,
  requestCandidateCompany,
  requestCandidateDepartment,
  requestCandidateOccupation,
  requestCandidateResponsibleFor,
  requestCandidateCurrentSalaryGrade,
  requestCandidateJobApplication,
  requestCandidateProfessionInterview,
  requestCandidateHrInterview,
  requestCandidateOfferApproval,
  requestCandidateOfferAcceptance,
  requestCandidateEmployeeBoarding,
  requestCandidateTermination,
  transferToAnotherCompany,
  transferToAnotherDepartment,
  transferToAnotherOccupation,
  transferToAnotherResponsibleFor,
  transferToAnotherCurrentSalaryGrade,
  transferToAnotherJobApplication,
  transferToAnotherProfessionInterview,
  transferToAnotherHrInterview,
  transferToAnotherOfferApproval,
  transferToAnotherOfferAcceptance,
  transferToAnotherEmployeeBoarding,
  transferToAnotherTermination }
export default EmployeeService

