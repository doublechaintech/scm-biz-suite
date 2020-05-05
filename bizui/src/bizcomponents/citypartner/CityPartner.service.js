
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}cityPartnerManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}cityPartnerManager/loadCityPartner/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}cityPartnerManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateCityServiceCenter = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}cityPartnerManager/requestCandidateCityServiceCenter/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCityServiceCenter = (id, parameters) => {
  const url = `${PREFIX}cityPartnerManager/transferToAnotherCityServiceCenter/id/anotherCityServiceCenterId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addPotentialCustomer = (targetObjectId, parameters) => {
  const url = `${PREFIX}cityPartnerManager/addPotentialCustomer/cityPartnerId/name/mobile/cityServiceCenterId/description/tokensExpr/`
  const cityPartnerId = targetObjectId
  const requestParameters = { ...parameters, cityPartnerId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updatePotentialCustomer = (targetObjectId, parameters) => {
  const url = `${PREFIX}cityPartnerManager/updatePotentialCustomerProperties/cityPartnerId/id/name/mobile/description/tokensExpr/`
  const cityPartnerId = targetObjectId
  const requestParameters = { ...parameters, cityPartnerId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removePotentialCustomerList = (targetObjectId, parameters) => {
  const url = `${PREFIX}cityPartnerManager/removePotentialCustomerList/cityPartnerId/potentialCustomerIds/tokensExpr/`
  const requestParameters = { ...parameters, cityPartnerId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addPotentialCustomerContact = (targetObjectId, parameters) => {
  const url = `${PREFIX}cityPartnerManager/addPotentialCustomerContact/cityPartnerId/name/contactDate/contactMethod/potentialCustomerId/contactToId/description/tokensExpr/`
  const cityPartnerId = targetObjectId
  const requestParameters = { ...parameters, cityPartnerId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updatePotentialCustomerContact = (targetObjectId, parameters) => {
  const url = `${PREFIX}cityPartnerManager/updatePotentialCustomerContactProperties/cityPartnerId/id/name/contactDate/contactMethod/description/tokensExpr/`
  const cityPartnerId = targetObjectId
  const requestParameters = { ...parameters, cityPartnerId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removePotentialCustomerContactList = (targetObjectId, parameters) => {
  const url = `${PREFIX}cityPartnerManager/removePotentialCustomerContactList/cityPartnerId/potentialCustomerContactIds/tokensExpr/`
  const requestParameters = { ...parameters, cityPartnerId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}cityPartnerService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}cityPartnerService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}cityPartnerService/process/`,
    data,
  })
}

const CityPartnerService = { view,
  load,
  addPotentialCustomer,
  addPotentialCustomerContact,
  updatePotentialCustomer,
  updatePotentialCustomerContact,
  removePotentialCustomerList,
  removePotentialCustomerContactList,
  requestCandidateCityServiceCenter,
  transferToAnotherCityServiceCenter, listFunctions, saveRequest, processRequest, queryCandidates}
export default CityPartnerService

