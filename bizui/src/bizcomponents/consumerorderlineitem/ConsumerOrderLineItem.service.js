
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}consumerOrderLineItemManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}consumerOrderLineItemManager/loadConsumerOrderLineItem/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateBizOrder = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}consumerOrderLineItemManager/requestCandidateBizOrder/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBizOrder = (id, parameters) => {
  const url = `${PREFIX}consumerOrderLineItemManager/transferToAnotherBizOrder/id/anotherBizOrderId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}consumerOrderLineItemService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}consumerOrderLineItemService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}consumerOrderLineItemService/process/`,
    data,
  })
}

const ConsumerOrderLineItemService = { view,
  load,
  requestCandidateBizOrder,
  transferToAnotherBizOrder, listFunctions, saveRequest, processRequest}
export default ConsumerOrderLineItemService

