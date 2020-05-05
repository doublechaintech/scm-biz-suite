
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreProvinceCenterManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}retailStoreProvinceCenterManager/loadRetailStoreProvinceCenter/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}retailStoreProvinceCenterManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateCountry = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreProvinceCenterManager/requestCandidateCountry/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCountry = (id, parameters) => {
  const url = `${PREFIX}retailStoreProvinceCenterManager/transferToAnotherCountry/id/anotherCountryId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addProvinceCenterDepartment = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreProvinceCenterManager/addProvinceCenterDepartment/retailStoreProvinceCenterId/name/founded/manager/tokensExpr/`
  const retailStoreProvinceCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreProvinceCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateProvinceCenterDepartment = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreProvinceCenterManager/updateProvinceCenterDepartmentProperties/retailStoreProvinceCenterId/id/name/founded/manager/tokensExpr/`
  const retailStoreProvinceCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreProvinceCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeProvinceCenterDepartmentList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreProvinceCenterManager/removeProvinceCenterDepartmentList/retailStoreProvinceCenterId/provinceCenterDepartmentIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreProvinceCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addProvinceCenterEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreProvinceCenterManager/addProvinceCenterEmployee/retailStoreProvinceCenterId/name/mobile/email/founded/departmentId/tokensExpr/`
  const retailStoreProvinceCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreProvinceCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateProvinceCenterEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreProvinceCenterManager/updateProvinceCenterEmployeeProperties/retailStoreProvinceCenterId/id/name/mobile/email/founded/tokensExpr/`
  const retailStoreProvinceCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreProvinceCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeProvinceCenterEmployeeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreProvinceCenterManager/removeProvinceCenterEmployeeList/retailStoreProvinceCenterId/provinceCenterEmployeeIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreProvinceCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRetailStoreCityServiceCenter = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreProvinceCenterManager/addRetailStoreCityServiceCenter/retailStoreProvinceCenterId/name/founded/tokensExpr/`
  const retailStoreProvinceCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreProvinceCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStoreCityServiceCenter = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreProvinceCenterManager/updateRetailStoreCityServiceCenterProperties/retailStoreProvinceCenterId/id/name/founded/tokensExpr/`
  const retailStoreProvinceCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreProvinceCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreCityServiceCenterList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreProvinceCenterManager/removeRetailStoreCityServiceCenterList/retailStoreProvinceCenterId/retailStoreCityServiceCenterIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreProvinceCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}retailStoreProvinceCenterService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreProvinceCenterService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreProvinceCenterService/process/`,
    data,
  })
}

const RetailStoreProvinceCenterService = { view,
  load,
  addProvinceCenterDepartment,
  addProvinceCenterEmployee,
  addRetailStoreCityServiceCenter,
  updateProvinceCenterDepartment,
  updateProvinceCenterEmployee,
  updateRetailStoreCityServiceCenter,
  removeProvinceCenterDepartmentList,
  removeProvinceCenterEmployeeList,
  removeRetailStoreCityServiceCenterList,
  requestCandidateCountry,
  transferToAnotherCountry, listFunctions, saveRequest, processRequest, queryCandidates}
export default RetailStoreProvinceCenterService

