
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}provinceCenterDepartmentManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}provinceCenterDepartmentManager/loadProvinceCenterDepartment/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateProvinceCenter = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}provinceCenterDepartmentManager/requestCandidateProvinceCenter/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherProvinceCenter = (id, parameters) => {
  const url = `${PREFIX}provinceCenterDepartmentManager/transferToAnotherProvinceCenter/id/anotherProvinceCenterId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addProvinceCenterEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}provinceCenterDepartmentManager/addProvinceCenterEmployee/provinceCenterDepartmentId/name/mobile/email/founded/provinceCenterId/tokensExpr/`
  const provinceCenterDepartmentId = targetObjectId
  const requestParameters = { ...parameters, provinceCenterDepartmentId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateProvinceCenterEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}provinceCenterDepartmentManager/updateProvinceCenterEmployeeProperties/provinceCenterDepartmentId/id/name/mobile/email/founded/tokensExpr/`
  const provinceCenterDepartmentId = targetObjectId
  const requestParameters = { ...parameters, provinceCenterDepartmentId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeProvinceCenterEmployeeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}provinceCenterDepartmentManager/removeProvinceCenterEmployeeList/provinceCenterDepartmentId/provinceCenterEmployeeIds/tokensExpr/`
  const requestParameters = { ...parameters, provinceCenterDepartmentId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}provinceCenterDepartmentService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}provinceCenterDepartmentService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}provinceCenterDepartmentService/process/`,
    data,
  })
}

const ProvinceCenterDepartmentService = { view,
  load,
  addProvinceCenterEmployee,
  updateProvinceCenterEmployee,
  removeProvinceCenterEmployeeList,
  requestCandidateProvinceCenter,
  transferToAnotherProvinceCenter, listFunctions, saveRequest, processRequest}
export default ProvinceCenterDepartmentService

