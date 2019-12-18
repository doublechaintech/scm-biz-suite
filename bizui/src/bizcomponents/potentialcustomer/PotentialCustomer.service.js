
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}potentialCustomerManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}potentialCustomerManager/loadPotentialCustomer/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateCityServiceCenter = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}potentialCustomerManager/requestCandidateCityServiceCenter/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCityServiceCenter = (id, parameters) => {
  const url = `${PREFIX}potentialCustomerManager/transferToAnotherCityServiceCenter/id/anotherCityServiceCenterId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateCityPartner = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}potentialCustomerManager/requestCandidateCityPartner/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCityPartner = (id, parameters) => {
  const url = `${PREFIX}potentialCustomerManager/transferToAnotherCityPartner/id/anotherCityPartnerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addPotentialCustomerContactPerson = (targetObjectId, parameters) => {
  const url = `${PREFIX}potentialCustomerManager/addPotentialCustomerContactPerson/potentialCustomerId/name/mobile/description/tokensExpr/`
  const potentialCustomerId = targetObjectId
  const requestParameters = { ...parameters, potentialCustomerId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updatePotentialCustomerContactPerson = (targetObjectId, parameters) => {
  const url = `${PREFIX}potentialCustomerManager/updatePotentialCustomerContactPersonProperties/potentialCustomerId/id/name/mobile/description/tokensExpr/`
  const potentialCustomerId = targetObjectId
  const requestParameters = { ...parameters, potentialCustomerId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removePotentialCustomerContactPersonList = (targetObjectId, parameters) => {
  const url = `${PREFIX}potentialCustomerManager/removePotentialCustomerContactPersonList/potentialCustomerId/potentialCustomerContactPersonIds/tokensExpr/`
  const requestParameters = { ...parameters, potentialCustomerId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addPotentialCustomerContact = (targetObjectId, parameters) => {
  const url = `${PREFIX}potentialCustomerManager/addPotentialCustomerContact/potentialCustomerId/name/contactDate/contactMethod/cityPartnerId/contactToId/description/tokensExpr/`
  const potentialCustomerId = targetObjectId
  const requestParameters = { ...parameters, potentialCustomerId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updatePotentialCustomerContact = (targetObjectId, parameters) => {
  const url = `${PREFIX}potentialCustomerManager/updatePotentialCustomerContactProperties/potentialCustomerId/id/name/contactDate/contactMethod/description/tokensExpr/`
  const potentialCustomerId = targetObjectId
  const requestParameters = { ...parameters, potentialCustomerId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removePotentialCustomerContactList = (targetObjectId, parameters) => {
  const url = `${PREFIX}potentialCustomerManager/removePotentialCustomerContactList/potentialCustomerId/potentialCustomerContactIds/tokensExpr/`
  const requestParameters = { ...parameters, potentialCustomerId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addEventAttendance = (targetObjectId, parameters) => {
  const url = `${PREFIX}potentialCustomerManager/addEventAttendance/potentialCustomerId/name/cityEventId/description/tokensExpr/`
  const potentialCustomerId = targetObjectId
  const requestParameters = { ...parameters, potentialCustomerId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEventAttendance = (targetObjectId, parameters) => {
  const url = `${PREFIX}potentialCustomerManager/updateEventAttendanceProperties/potentialCustomerId/id/name/description/tokensExpr/`
  const potentialCustomerId = targetObjectId
  const requestParameters = { ...parameters, potentialCustomerId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEventAttendanceList = (targetObjectId, parameters) => {
  const url = `${PREFIX}potentialCustomerManager/removeEventAttendanceList/potentialCustomerId/eventAttendanceIds/tokensExpr/`
  const requestParameters = { ...parameters, potentialCustomerId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}potentialCustomerService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}potentialCustomerService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}potentialCustomerService/process/`,
    data,
  })
}

const PotentialCustomerService = { view,
  load,
  addPotentialCustomerContactPerson,
  addPotentialCustomerContact,
  addEventAttendance,
  updatePotentialCustomerContactPerson,
  updatePotentialCustomerContact,
  updateEventAttendance,
  removePotentialCustomerContactPersonList,
  removePotentialCustomerContactList,
  removeEventAttendanceList,
  requestCandidateCityServiceCenter,
  requestCandidateCityPartner,
  transferToAnotherCityServiceCenter,
  transferToAnotherCityPartner, listFunctions, saveRequest, processRequest}
export default PotentialCustomerService

