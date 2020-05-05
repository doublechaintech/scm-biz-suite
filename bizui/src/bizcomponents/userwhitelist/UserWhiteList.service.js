
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}userWhiteListManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}userWhiteListManager/loadUserWhiteList/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}userWhiteListManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateDomain = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}userWhiteListManager/requestCandidateDomain/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherDomain = (id, parameters) => {
  const url = `${PREFIX}userWhiteListManager/transferToAnotherDomain/id/anotherDomainId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}userWhiteListService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}userWhiteListService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}userWhiteListService/process/`,
    data,
  })
}

const UserWhiteListService = { view,
  load,
  requestCandidateDomain,
  transferToAnotherDomain, listFunctions, saveRequest, processRequest, queryCandidates}
export default UserWhiteListService

