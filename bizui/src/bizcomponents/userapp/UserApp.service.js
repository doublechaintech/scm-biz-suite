
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}userAppManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}userAppManager/loadUserApp/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}userAppManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateSecUser = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}userAppManager/requestCandidateSecUser/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherSecUser = (id, parameters) => {
  const url = `${PREFIX}userAppManager/transferToAnotherSecUser/id/anotherSecUserId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addQuickLink = (targetObjectId, parameters) => {
  const url = `${PREFIX}userAppManager/addQuickLink/userAppId/name/icon/imagePath/linkTarget/tokensExpr/`
  const userAppId = targetObjectId
  const requestParameters = { ...parameters, userAppId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateQuickLink = (targetObjectId, parameters) => {
  const url = `${PREFIX}userAppManager/updateQuickLinkProperties/userAppId/id/name/icon/imagePath/linkTarget/tokensExpr/`
  const userAppId = targetObjectId
  const requestParameters = { ...parameters, userAppId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeQuickLinkList = (targetObjectId, parameters) => {
  const url = `${PREFIX}userAppManager/removeQuickLinkList/userAppId/quickLinkIds/tokensExpr/`
  const requestParameters = { ...parameters, userAppId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addListAccess = (targetObjectId, parameters) => {
  const url = `${PREFIX}userAppManager/addListAccess/userAppId/name/internalName/readPermission/createPermission/deletePermission/updatePermission/executionPermission/tokensExpr/`
  const userAppId = targetObjectId
  const requestParameters = { ...parameters, userAppId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateListAccess = (targetObjectId, parameters) => {
  const url = `${PREFIX}userAppManager/updateListAccessProperties/userAppId/id/name/internalName/readPermission/createPermission/deletePermission/updatePermission/executionPermission/tokensExpr/`
  const userAppId = targetObjectId
  const requestParameters = { ...parameters, userAppId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeListAccessList = (targetObjectId, parameters) => {
  const url = `${PREFIX}userAppManager/removeListAccessList/userAppId/listAccessIds/tokensExpr/`
  const requestParameters = { ...parameters, userAppId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}userAppService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}userAppService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}userAppService/process/`,
    data,
  })
}

const UserAppService = { view,
  load,
  addQuickLink,
  addListAccess,
  updateQuickLink,
  updateListAccess,
  removeQuickLinkList,
  removeListAccessList,
  requestCandidateSecUser,
  transferToAnotherSecUser, listFunctions, saveRequest, processRequest, queryCandidates}
export default UserAppService

