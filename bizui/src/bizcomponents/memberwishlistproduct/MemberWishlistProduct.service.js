
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}memberWishlistProductManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}memberWishlistProductManager/loadMemberWishlistProduct/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateOwner = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}memberWishlistProductManager/requestCandidateOwner/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherOwner = (id, parameters) => {
  const url = `${PREFIX}memberWishlistProductManager/transferToAnotherOwner/id/anotherOwnerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}memberWishlistProductService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}memberWishlistProductService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}memberWishlistProductService/process/`,
    data,
  })
}

const MemberWishlistProductService = { view,
  load,
  requestCandidateOwner,
  transferToAnotherOwner, listFunctions, saveRequest, processRequest}
export default MemberWishlistProductService

