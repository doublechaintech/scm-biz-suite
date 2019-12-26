
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}memberRewardPointManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}memberRewardPointManager/loadMemberRewardPoint/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateOwner = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}memberRewardPointManager/requestCandidateOwner/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherOwner = (id, parameters) => {
  const url = `${PREFIX}memberRewardPointManager/transferToAnotherOwner/id/anotherOwnerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}memberRewardPointService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}memberRewardPointService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}memberRewardPointService/process/`,
    data,
  })
}

const MemberRewardPointService = { view,
  load,
  requestCandidateOwner,
  transferToAnotherOwner, listFunctions, saveRequest, processRequest}
export default MemberRewardPointService

