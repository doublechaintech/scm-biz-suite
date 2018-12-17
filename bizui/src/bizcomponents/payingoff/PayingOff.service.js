import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}payingOffManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}payingOffManager/loadPayingOff/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePaidFor = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}payingOffManager/requestCandidatePaidFor/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPaidFor = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
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


const PayingOffService = { view,
  load,
  addEmployeeSalarySheet,
  updateEmployeeSalarySheet,
  removeEmployeeSalarySheetList,
  requestCandidatePaidFor,
  transferToAnotherPaidFor }
export default PayingOffService

