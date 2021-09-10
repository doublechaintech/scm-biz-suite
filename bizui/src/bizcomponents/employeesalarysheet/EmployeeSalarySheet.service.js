
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}employeeSalarySheetManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}employeeSalarySheetManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}employeeSalarySheetManager/loadEmployeeSalarySheet/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}employeeSalarySheetManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateEmployee = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeSalarySheetManager/requestCandidateEmployee/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherEmployee = (id, parameters) => {
  const url = `${PREFIX}employeeSalarySheetManager/transferToAnotherEmployee/id/anotherEmployeeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateCurrentSalaryGrade = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeSalarySheetManager/requestCandidateCurrentSalaryGrade/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCurrentSalaryGrade = (id, parameters) => {
  const url = `${PREFIX}employeeSalarySheetManager/transferToAnotherCurrentSalaryGrade/id/anotherCurrentSalaryGradeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidatePayingOff = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeSalarySheetManager/requestCandidatePayingOff/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPayingOff = (id, parameters) => {
  const url = `${PREFIX}employeeSalarySheetManager/transferToAnotherPayingOff/id/anotherPayingOffId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}employeeSalarySheetService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}employeeSalarySheetService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}employeeSalarySheetService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}employeeSalarySheetService/process/`,
    data,
  })
}

const EmployeeSalarySheetService = { view,
  load,
  analyze,
  requestCandidateEmployee,
  requestCandidateCurrentSalaryGrade,
  requestCandidatePayingOff,
  transferToAnotherEmployee,
  transferToAnotherCurrentSalaryGrade,
  transferToAnotherPayingOff, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default EmployeeSalarySheetService

