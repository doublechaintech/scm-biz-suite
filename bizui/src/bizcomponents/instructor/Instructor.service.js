
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}instructorManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}instructorManager/loadInstructor/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}instructorManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateCompany = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}instructorManager/requestCandidateCompany/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCompany = (id, parameters) => {
  const url = `${PREFIX}instructorManager/transferToAnotherCompany/id/anotherCompanyId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addCompanyTraining = (targetObjectId, parameters) => {
  const url = `${PREFIX}instructorManager/addCompanyTraining/instructorId/title/companyId/trainingCourseTypeId/timeStart/durationHours/tokensExpr/`
  const instructorId = targetObjectId
  const requestParameters = { ...parameters, instructorId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateCompanyTraining = (targetObjectId, parameters) => {
  const url = `${PREFIX}instructorManager/updateCompanyTrainingProperties/instructorId/id/title/timeStart/durationHours/tokensExpr/`
  const instructorId = targetObjectId
  const requestParameters = { ...parameters, instructorId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeCompanyTrainingList = (targetObjectId, parameters) => {
  const url = `${PREFIX}instructorManager/removeCompanyTrainingList/instructorId/companyTrainingIds/tokensExpr/`
  const requestParameters = { ...parameters, instructorId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}instructorService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}instructorService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}instructorService/process/`,
    data,
  })
}

const InstructorService = { view,
  load,
  addCompanyTraining,
  updateCompanyTraining,
  removeCompanyTrainingList,
  requestCandidateCompany,
  transferToAnotherCompany, listFunctions, saveRequest, processRequest, queryCandidates}
export default InstructorService

