
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}employeeSkillManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}employeeSkillManager/loadEmployeeSkill/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateEmployee = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeSkillManager/requestCandidateEmployee/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherEmployee = (id, parameters) => {
  const url = `${PREFIX}employeeSkillManager/transferToAnotherEmployee/id/anotherEmployeeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateSkillType = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeSkillManager/requestCandidateSkillType/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherSkillType = (id, parameters) => {
  const url = `${PREFIX}employeeSkillManager/transferToAnotherSkillType/id/anotherSkillTypeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}employeeSkillService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}employeeSkillService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}employeeSkillService/process/`,
    data,
  })
}

const EmployeeSkillService = { view,
  load,
  requestCandidateEmployee,
  requestCandidateSkillType,
  transferToAnotherEmployee,
  transferToAnotherSkillType, listFunctions, saveRequest, processRequest}
export default EmployeeSkillService

