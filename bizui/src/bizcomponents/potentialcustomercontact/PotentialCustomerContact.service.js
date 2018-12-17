import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}potentialCustomerContactManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}potentialCustomerContactManager/loadPotentialCustomerContact/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePotentialCustomer = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}potentialCustomerContactManager/requestCandidatePotentialCustomer/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPotentialCustomer = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
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
  //const parametersExpr = joinParameters(parameters)
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
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}potentialCustomerContactManager/transferToAnotherContactTo/id/anotherContactToId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const PotentialCustomerContactService = { view,
  load,
  requestCandidatePotentialCustomer,
  requestCandidateCityPartner,
  requestCandidateContactTo,
  transferToAnotherPotentialCustomer,
  transferToAnotherCityPartner,
  transferToAnotherContactTo }
export default PotentialCustomerContactService

