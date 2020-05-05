
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}companyTrainingManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}companyTrainingManager/loadCompanyTraining/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}companyTrainingManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateCompany = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}companyTrainingManager/requestCandidateCompany/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCompany = (id, parameters) => {
  const url = `${PREFIX}companyTrainingManager/transferToAnotherCompany/id/anotherCompanyId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateInstructor = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}companyTrainingManager/requestCandidateInstructor/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherInstructor = (id, parameters) => {
  const url = `${PREFIX}companyTrainingManager/transferToAnotherInstructor/id/anotherInstructorId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateTrainingCourseType = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}companyTrainingManager/requestCandidateTrainingCourseType/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherTrainingCourseType = (id, parameters) => {
  const url = `${PREFIX}companyTrainingManager/transferToAnotherTrainingCourseType/id/anotherTrainingCourseTypeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addEmployeeCompanyTraining = (targetObjectId, parameters) => {
  const url = `${PREFIX}companyTrainingManager/addEmployeeCompanyTraining/companyTrainingId/employeeId/scoringId/tokensExpr/`
  const companyTrainingId = targetObjectId
  const requestParameters = { ...parameters, companyTrainingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployeeCompanyTraining = (targetObjectId, parameters) => {
  const url = `${PREFIX}companyTrainingManager/updateEmployeeCompanyTrainingProperties/companyTrainingId/id/tokensExpr/`
  const companyTrainingId = targetObjectId
  const requestParameters = { ...parameters, companyTrainingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeCompanyTrainingList = (targetObjectId, parameters) => {
  const url = `${PREFIX}companyTrainingManager/removeEmployeeCompanyTrainingList/companyTrainingId/employeeCompanyTrainingIds/tokensExpr/`
  const requestParameters = { ...parameters, companyTrainingId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}companyTrainingService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}companyTrainingService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}companyTrainingService/process/`,
    data,
  })
}

const CompanyTrainingService = { view,
  load,
  addEmployeeCompanyTraining,
  updateEmployeeCompanyTraining,
  removeEmployeeCompanyTrainingList,
  requestCandidateCompany,
  requestCandidateInstructor,
  requestCandidateTrainingCourseType,
  transferToAnotherCompany,
  transferToAnotherInstructor,
  transferToAnotherTrainingCourseType, listFunctions, saveRequest, processRequest, queryCandidates}
export default CompanyTrainingService

