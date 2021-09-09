
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}potentialCustomerContactManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}potentialCustomerContactManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}potentialCustomerContactManager/loadPotentialCustomerContact/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}potentialCustomerContactManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidatePotentialCustomer = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}potentialCustomerContactManager/requestCandidatePotentialCustomer/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPotentialCustomer = (id, parameters) => {
  const url = `${PREFIX}potentialCustomerContactManager/transferToAnotherPotentialCustomer/id/anotherPotentialCustomerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateCityPartner = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}potentialCustomerContactManager/requestCandidateCityPartner/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCityPartner = (id, parameters) => {
  const url = `${PREFIX}potentialCustomerContactManager/transferToAnotherCityPartner/id/anotherCityPartnerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateContactTo = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}potentialCustomerContactManager/requestCandidateContactTo/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherContactTo = (id, parameters) => {
  const url = `${PREFIX}potentialCustomerContactManager/transferToAnotherContactTo/id/anotherContactToId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}potentialCustomerContactService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}potentialCustomerContactService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}potentialCustomerContactService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}potentialCustomerContactService/process/`,
    data,
  })
}

const PotentialCustomerContactService = { view,
  load,
  analyze,
  requestCandidatePotentialCustomer,
  requestCandidateCityPartner,
  requestCandidateContactTo,
  transferToAnotherPotentialCustomer,
  transferToAnotherCityPartner,
  transferToAnotherContactTo, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default PotentialCustomerContactService

