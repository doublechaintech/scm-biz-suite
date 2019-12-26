
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}consumerOrderPriceAdjustmentManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}consumerOrderPriceAdjustmentManager/loadConsumerOrderPriceAdjustment/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateBizOrder = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}consumerOrderPriceAdjustmentManager/requestCandidateBizOrder/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBizOrder = (id, parameters) => {
  const url = `${PREFIX}consumerOrderPriceAdjustmentManager/transferToAnotherBizOrder/id/anotherBizOrderId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}consumerOrderPriceAdjustmentService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}consumerOrderPriceAdjustmentService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}consumerOrderPriceAdjustmentService/process/`,
    data,
  })
}

const ConsumerOrderPriceAdjustmentService = { view,
  load,
  requestCandidateBizOrder,
  transferToAnotherBizOrder, listFunctions, saveRequest, processRequest}
export default ConsumerOrderPriceAdjustmentService

