
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}supplyOrderLineItemManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}supplyOrderLineItemManager/loadSupplyOrderLineItem/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateBizOrder = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}supplyOrderLineItemManager/requestCandidateBizOrder/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBizOrder = (id, parameters) => {
  const url = `${PREFIX}supplyOrderLineItemManager/transferToAnotherBizOrder/id/anotherBizOrderId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}supplyOrderLineItemService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}supplyOrderLineItemService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}supplyOrderLineItemService/process/`,
    data,
  })
}

const SupplyOrderLineItemService = { view,
  load,
  requestCandidateBizOrder,
  transferToAnotherBizOrder, listFunctions, saveRequest, processRequest}
export default SupplyOrderLineItemService

