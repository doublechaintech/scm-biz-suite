
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}payingOffManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}payingOffManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}payingOffManager/loadPayingOff/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}payingOffManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidatePaidFor = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}payingOffManager/requestCandidatePaidFor/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPaidFor = (id, parameters) => {
  const url = `${PREFIX}payingOffManager/transferToAnotherPaidFor/id/anotherPaidForId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addEmployeeSalarySheet = (targetObjectId, parameters) => {
  const url = `${PREFIX}payingOffManager/addEmployeeSalarySheet/payingOffId/employeeId/currentSalaryGradeId/baseSalary/bonus/reward/personalTax/socialSecurity/housingFound/jobInsurance/tokensExpr/`
  const payingOffId = targetObjectId
  const requestParameters = { ...parameters, payingOffId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployeeSalarySheet = (targetObjectId, parameters) => {
  const url = `${PREFIX}payingOffManager/updateEmployeeSalarySheetProperties/payingOffId/id/baseSalary/bonus/reward/personalTax/socialSecurity/housingFound/jobInsurance/tokensExpr/`
  const payingOffId = targetObjectId
  const requestParameters = { ...parameters, payingOffId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeSalarySheetList = (targetObjectId, parameters) => {
  const url = `${PREFIX}payingOffManager/removeEmployeeSalarySheetList/payingOffId/employeeSalarySheetIds/tokensExpr/`
  const requestParameters = { ...parameters, payingOffId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}payingOffService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}payingOffService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}payingOffService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}payingOffService/process/`,
    data,
  })
}

const PayingOffService = { view,
  load,
  analyze,
  addEmployeeSalarySheet,
  updateEmployeeSalarySheet,
  removeEmployeeSalarySheetList,
  requestCandidatePaidFor,
  transferToAnotherPaidFor, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default PayingOffService

