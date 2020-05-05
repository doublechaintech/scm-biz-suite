
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}trainingCourseTypeManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}trainingCourseTypeManager/loadTrainingCourseType/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}trainingCourseTypeManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateCompany = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}trainingCourseTypeManager/requestCandidateCompany/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCompany = (id, parameters) => {
  const url = `${PREFIX}trainingCourseTypeManager/transferToAnotherCompany/id/anotherCompanyId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addCompanyTraining = (targetObjectId, parameters) => {
  const url = `${PREFIX}trainingCourseTypeManager/addCompanyTraining/trainingCourseTypeId/title/companyId/instructorId/timeStart/durationHours/tokensExpr/`
  const trainingCourseTypeId = targetObjectId
  const requestParameters = { ...parameters, trainingCourseTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateCompanyTraining = (targetObjectId, parameters) => {
  const url = `${PREFIX}trainingCourseTypeManager/updateCompanyTrainingProperties/trainingCourseTypeId/id/title/timeStart/durationHours/tokensExpr/`
  const trainingCourseTypeId = targetObjectId
  const requestParameters = { ...parameters, trainingCourseTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeCompanyTrainingList = (targetObjectId, parameters) => {
  const url = `${PREFIX}trainingCourseTypeManager/removeCompanyTrainingList/trainingCourseTypeId/companyTrainingIds/tokensExpr/`
  const requestParameters = { ...parameters, trainingCourseTypeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}trainingCourseTypeService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}trainingCourseTypeService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}trainingCourseTypeService/process/`,
    data,
  })
}

const TrainingCourseTypeService = { view,
  load,
  addCompanyTraining,
  updateCompanyTraining,
  removeCompanyTrainingList,
  requestCandidateCompany,
  transferToAnotherCompany, listFunctions, saveRequest, processRequest, queryCandidates}
export default TrainingCourseTypeService

