
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}consumerOrderPaymentGroupManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}consumerOrderPaymentGroupManager/loadConsumerOrderPaymentGroup/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateBizOrder = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}consumerOrderPaymentGroupManager/requestCandidateBizOrder/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBizOrder = (id, parameters) => {
  const url = `${PREFIX}consumerOrderPaymentGroupManager/transferToAnotherBizOrder/id/anotherBizOrderId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}consumerOrderPaymentGroupService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}consumerOrderPaymentGroupService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}consumerOrderPaymentGroupService/process/`,
    data,
  })
}

const ConsumerOrderPaymentGroupService = { view,
  load,
  requestCandidateBizOrder,
  transferToAnotherBizOrder, listFunctions, saveRequest, processRequest}
export default ConsumerOrderPaymentGroupService

