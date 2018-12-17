import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}employeeCompanyTrainingManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}employeeCompanyTrainingManager/loadEmployeeCompanyTraining/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateEmployee = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeCompanyTrainingManager/requestCandidateEmployee/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherEmployee = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}employeeCompanyTrainingManager/transferToAnotherEmployee/id/anotherEmployeeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateTraining = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeCompanyTrainingManager/requestCandidateTraining/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherTraining = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}employeeCompanyTrainingManager/transferToAnotherTraining/id/anotherTrainingId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateScoring = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeCompanyTrainingManager/requestCandidateScoring/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherScoring = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}employeeCompanyTrainingManager/transferToAnotherScoring/id/anotherScoringId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const EmployeeCompanyTrainingService = { view,
  load,
  requestCandidateEmployee,
  requestCandidateTraining,
  requestCandidateScoring,
  transferToAnotherEmployee,
  transferToAnotherTraining,
  transferToAnotherScoring }
export default EmployeeCompanyTrainingService

