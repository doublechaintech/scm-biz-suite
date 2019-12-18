
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}supplyOrderDeliveryManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}supplyOrderDeliveryManager/loadSupplyOrderDelivery/${targetObjectId}/${parametersExpr}/`,
  })
}







const addConsumerOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderDeliveryManager/addConsumerOrder/supplyOrderDeliveryId/title/consumerId/confirmationId/approvalId/processingId/shipmentId/storeId/tokensExpr/`
  const supplyOrderDeliveryId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderDeliveryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateConsumerOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderDeliveryManager/updateConsumerOrderProperties/supplyOrderDeliveryId/id/title/tokensExpr/`
  const supplyOrderDeliveryId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderDeliveryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeConsumerOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderDeliveryManager/removeConsumerOrderList/supplyOrderDeliveryId/consumerOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, supplyOrderDeliveryId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addSupplyOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderDeliveryManager/addSupplyOrder/supplyOrderDeliveryId/buyerId/sellerId/title/totalAmount/confirmationId/approvalId/processingId/pickingId/shipmentId/tokensExpr/`
  const supplyOrderDeliveryId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderDeliveryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSupplyOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderDeliveryManager/updateSupplyOrderProperties/supplyOrderDeliveryId/id/title/totalAmount/tokensExpr/`
  const supplyOrderDeliveryId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderDeliveryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSupplyOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderDeliveryManager/removeSupplyOrderList/supplyOrderDeliveryId/supplyOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, supplyOrderDeliveryId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}supplyOrderDeliveryService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}supplyOrderDeliveryService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}supplyOrderDeliveryService/process/`,
    data,
  })
}

const SupplyOrderDeliveryService = { view,
  load,
  addConsumerOrder,
  addSupplyOrder,
  updateConsumerOrder,
  updateSupplyOrder,
  removeConsumerOrderList,
  removeSupplyOrderList, listFunctions, saveRequest, processRequest}
export default SupplyOrderDeliveryService

