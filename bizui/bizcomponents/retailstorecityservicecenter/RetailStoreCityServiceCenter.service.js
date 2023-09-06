
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreCityServiceCenterManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreCityServiceCenterManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}retailStoreCityServiceCenterManager/loadRetailStoreCityServiceCenter/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}retailStoreCityServiceCenterManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateBelongsTo = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreCityServiceCenterManager/requestCandidateBelongsTo/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBelongsTo = (id, parameters) => {
  const url = `${PREFIX}retailStoreCityServiceCenterManager/transferToAnotherBelongsTo/id/anotherBelongsToId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addCityPartner = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCityServiceCenterManager/addCityPartner/retailStoreCityServiceCenterId/name/mobile/description/tokensExpr/`
  const retailStoreCityServiceCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCityServiceCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateCityPartner = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCityServiceCenterManager/updateCityPartnerProperties/retailStoreCityServiceCenterId/id/name/mobile/description/tokensExpr/`
  const retailStoreCityServiceCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCityServiceCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeCityPartnerList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCityServiceCenterManager/removeCityPartnerList/retailStoreCityServiceCenterId/cityPartnerIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCityServiceCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addPotentialCustomer = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCityServiceCenterManager/addPotentialCustomer/retailStoreCityServiceCenterId/name/mobile/cityPartnerId/description/tokensExpr/`
  const retailStoreCityServiceCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCityServiceCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updatePotentialCustomer = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCityServiceCenterManager/updatePotentialCustomerProperties/retailStoreCityServiceCenterId/id/name/mobile/description/tokensExpr/`
  const retailStoreCityServiceCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCityServiceCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removePotentialCustomerList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCityServiceCenterManager/removePotentialCustomerList/retailStoreCityServiceCenterId/potentialCustomerIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCityServiceCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addCityEvent = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCityServiceCenterManager/addCityEvent/retailStoreCityServiceCenterId/name/mobile/description/tokensExpr/`
  const retailStoreCityServiceCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCityServiceCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateCityEvent = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCityServiceCenterManager/updateCityEventProperties/retailStoreCityServiceCenterId/id/name/mobile/description/tokensExpr/`
  const retailStoreCityServiceCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCityServiceCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeCityEventList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCityServiceCenterManager/removeCityEventList/retailStoreCityServiceCenterId/cityEventIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCityServiceCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRetailStore = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCityServiceCenterManager/addRetailStore/retailStoreCityServiceCenterId/name/telephone/owner/retailStoreCountryCenterId/creationId/investmentInvitationId/franchisingId/decorationId/openingId/closingId/founded/latitude/longitude/description/tokensExpr/`
  const retailStoreCityServiceCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCityServiceCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStore = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCityServiceCenterManager/updateRetailStoreProperties/retailStoreCityServiceCenterId/id/name/telephone/owner/founded/latitude/longitude/description/tokensExpr/`
  const retailStoreCityServiceCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCityServiceCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCityServiceCenterManager/removeRetailStoreList/retailStoreCityServiceCenterId/retailStoreIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCityServiceCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}retailStoreCityServiceCenterService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreCityServiceCenterService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreCityServiceCenterService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreCityServiceCenterService/process/`,
    data,
  })
}

const RetailStoreCityServiceCenterService = { view,
  load,
  analyze,
  addCityPartner,
  addPotentialCustomer,
  addCityEvent,
  addRetailStore,
  updateCityPartner,
  updatePotentialCustomer,
  updateCityEvent,
  updateRetailStore,
  removeCityPartnerList,
  removePotentialCustomerList,
  removeCityEventList,
  removeRetailStoreList,
  requestCandidateBelongsTo,
  transferToAnotherBelongsTo, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default RetailStoreCityServiceCenterService

