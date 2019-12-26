
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}originalVoucherManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}originalVoucherManager/loadOriginalVoucher/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateBelongsTo = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}originalVoucherManager/requestCandidateBelongsTo/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBelongsTo = (id, parameters) => {
  const url = `${PREFIX}originalVoucherManager/transferToAnotherBelongsTo/id/anotherBelongsToId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateCreation = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}originalVoucherManager/requestCandidateCreation/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCreation = (id, parameters) => {
  const url = `${PREFIX}originalVoucherManager/transferToAnotherCreation/id/anotherCreationId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateConfirmation = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}originalVoucherManager/requestCandidateConfirmation/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherConfirmation = (id, parameters) => {
  const url = `${PREFIX}originalVoucherManager/transferToAnotherConfirmation/id/anotherConfirmationId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateAuditing = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}originalVoucherManager/requestCandidateAuditing/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherAuditing = (id, parameters) => {
  const url = `${PREFIX}originalVoucherManager/transferToAnotherAuditing/id/anotherAuditingId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}originalVoucherService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}originalVoucherService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}originalVoucherService/process/`,
    data,
  })
}

const OriginalVoucherService = { view,
  load,
  requestCandidateBelongsTo,
  requestCandidateCreation,
  requestCandidateConfirmation,
  requestCandidateAuditing,
  transferToAnotherBelongsTo,
  transferToAnotherCreation,
  transferToAnotherConfirmation,
  transferToAnotherAuditing, listFunctions, saveRequest, processRequest}
export default OriginalVoucherService

