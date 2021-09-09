
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}skillTypeManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}skillTypeManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}skillTypeManager/loadSkillType/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}skillTypeManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateCompany = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}skillTypeManager/requestCandidateCompany/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCompany = (id, parameters) => {
  const url = `${PREFIX}skillTypeManager/transferToAnotherCompany/id/anotherCompanyId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addEmployeeSkill = (targetObjectId, parameters) => {
  const url = `${PREFIX}skillTypeManager/addEmployeeSkill/skillTypeId/employeeId/description/tokensExpr/`
  const skillTypeId = targetObjectId
  const requestParameters = { ...parameters, skillTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployeeSkill = (targetObjectId, parameters) => {
  const url = `${PREFIX}skillTypeManager/updateEmployeeSkillProperties/skillTypeId/id/description/tokensExpr/`
  const skillTypeId = targetObjectId
  const requestParameters = { ...parameters, skillTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeSkillList = (targetObjectId, parameters) => {
  const url = `${PREFIX}skillTypeManager/removeEmployeeSkillList/skillTypeId/employeeSkillIds/tokensExpr/`
  const requestParameters = { ...parameters, skillTypeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}skillTypeService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}skillTypeService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}skillTypeService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}skillTypeService/process/`,
    data,
  })
}

const SkillTypeService = { view,
  load,
  analyze,
  addEmployeeSkill,
  updateEmployeeSkill,
  removeEmployeeSkillList,
  requestCandidateCompany,
  transferToAnotherCompany, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default SkillTypeService

