
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}publicKeyTypeManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}publicKeyTypeManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}publicKeyTypeManager/loadPublicKeyType/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}publicKeyTypeManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateDomain = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}publicKeyTypeManager/requestCandidateDomain/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherDomain = (id, parameters) => {
  const url = `${PREFIX}publicKeyTypeManager/transferToAnotherDomain/id/anotherDomainId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addKeyPairIdentity = (targetObjectId, parameters) => {
  const url = `${PREFIX}publicKeyTypeManager/addKeyPairIdentity/publicKeyTypeId/publicKey/secUserId/tokensExpr/`
  const publicKeyTypeId = targetObjectId
  const requestParameters = { ...parameters, publicKeyTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateKeyPairIdentity = (targetObjectId, parameters) => {
  const url = `${PREFIX}publicKeyTypeManager/updateKeyPairIdentityProperties/publicKeyTypeId/id/publicKey/tokensExpr/`
  const publicKeyTypeId = targetObjectId
  const requestParameters = { ...parameters, publicKeyTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeKeyPairIdentityList = (targetObjectId, parameters) => {
  const url = `${PREFIX}publicKeyTypeManager/removeKeyPairIdentityList/publicKeyTypeId/keyPairIdentityIds/tokensExpr/`
  const requestParameters = { ...parameters, publicKeyTypeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}publicKeyTypeService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}publicKeyTypeService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}publicKeyTypeService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}publicKeyTypeService/process/`,
    data,
  })
}

const PublicKeyTypeService = { view,
  load,
  analyze,
  addKeyPairIdentity,
  updateKeyPairIdentity,
  removeKeyPairIdentityList,
  requestCandidateDomain,
  transferToAnotherDomain, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default PublicKeyTypeService

