
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}supplyOrderProcessingManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}supplyOrderProcessingManager/loadSupplyOrderProcessing/${targetObjectId}/${parametersExpr}/`,
  })
}







const addConsumerOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderProcessingManager/addConsumerOrder/supplyOrderProcessingId/title/consumerId/confirmationId/approvalId/shipmentId/deliveryId/storeId/tokensExpr/`
  const supplyOrderProcessingId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderProcessingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateConsumerOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderProcessingManager/updateConsumerOrderProperties/supplyOrderProcessingId/id/title/tokensExpr/`
  const supplyOrderProcessingId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderProcessingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeConsumerOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderProcessingManager/removeConsumerOrderList/supplyOrderProcessingId/consumerOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, supplyOrderProcessingId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addSupplyOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderProcessingManager/addSupplyOrder/supplyOrderProcessingId/buyerId/sellerId/title/totalAmount/confirmationId/approvalId/pickingId/shipmentId/deliveryId/tokensExpr/`
  const supplyOrderProcessingId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderProcessingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSupplyOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderProcessingManager/updateSupplyOrderProperties/supplyOrderProcessingId/id/title/totalAmount/tokensExpr/`
  const supplyOrderProcessingId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderProcessingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSupplyOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderProcessingManager/removeSupplyOrderList/supplyOrderProcessingId/supplyOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, supplyOrderProcessingId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}supplyOrderProcessingService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}supplyOrderProcessingService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}supplyOrderProcessingService/process/`,
    data,
  })
}

const SupplyOrderProcessingService = { view,
  load,
  addConsumerOrder,
  addSupplyOrder,
  updateConsumerOrder,
  updateSupplyOrder,
  removeConsumerOrderList,
  removeSupplyOrderList, listFunctions, saveRequest, processRequest}
export default SupplyOrderProcessingService

