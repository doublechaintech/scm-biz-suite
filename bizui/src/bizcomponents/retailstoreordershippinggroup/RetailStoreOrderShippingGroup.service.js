
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreOrderShippingGroupManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}retailStoreOrderShippingGroupManager/loadRetailStoreOrderShippingGroup/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateBizOrder = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreOrderShippingGroupManager/requestCandidateBizOrder/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBizOrder = (id, parameters) => {
  const url = `${PREFIX}retailStoreOrderShippingGroupManager/transferToAnotherBizOrder/id/anotherBizOrderId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}retailStoreOrderShippingGroupService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreOrderShippingGroupService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreOrderShippingGroupService/process/`,
    data,
  })
}

const RetailStoreOrderShippingGroupService = { view,
  load,
  requestCandidateBizOrder,
  transferToAnotherBizOrder, listFunctions, saveRequest, processRequest}
export default RetailStoreOrderShippingGroupService

