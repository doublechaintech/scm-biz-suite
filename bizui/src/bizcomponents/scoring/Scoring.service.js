
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}scoringManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}scoringManager/loadScoring/${targetObjectId}/${parametersExpr}/`,
  })
}







const addEmployeeCompanyTraining = (targetObjectId, parameters) => {
  const url = `${PREFIX}scoringManager/addEmployeeCompanyTraining/scoringId/employeeId/trainingId/tokensExpr/`
  const scoringId = targetObjectId
  const requestParameters = { ...parameters, scoringId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployeeCompanyTraining = (targetObjectId, parameters) => {
  const url = `${PREFIX}scoringManager/updateEmployeeCompanyTrainingProperties/scoringId/id/tokensExpr/`
  const scoringId = targetObjectId
  const requestParameters = { ...parameters, scoringId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeCompanyTrainingList = (targetObjectId, parameters) => {
  const url = `${PREFIX}scoringManager/removeEmployeeCompanyTrainingList/scoringId/employeeCompanyTrainingIds/tokensExpr/`
  const requestParameters = { ...parameters, scoringId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}scoringService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}scoringService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}scoringService/process/`,
    data,
  })
}

const ScoringService = { view,
  load,
  addEmployeeCompanyTraining,
  updateEmployeeCompanyTraining,
  removeEmployeeCompanyTrainingList, listFunctions, saveRequest, processRequest}
export default ScoringService

