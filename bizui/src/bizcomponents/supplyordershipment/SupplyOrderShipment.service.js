
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}supplyOrderShipmentManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}supplyOrderShipmentManager/loadSupplyOrderShipment/${targetObjectId}/${parametersExpr}/`,
  })
}







const addConsumerOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderShipmentManager/addConsumerOrder/supplyOrderShipmentId/title/consumerId/confirmationId/approvalId/processingId/deliveryId/storeId/tokensExpr/`
  const supplyOrderShipmentId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderShipmentId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateConsumerOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderShipmentManager/updateConsumerOrderProperties/supplyOrderShipmentId/id/title/tokensExpr/`
  const supplyOrderShipmentId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderShipmentId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeConsumerOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderShipmentManager/removeConsumerOrderList/supplyOrderShipmentId/consumerOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, supplyOrderShipmentId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addSupplyOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderShipmentManager/addSupplyOrder/supplyOrderShipmentId/buyerId/sellerId/title/totalAmount/confirmationId/approvalId/processingId/pickingId/deliveryId/tokensExpr/`
  const supplyOrderShipmentId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderShipmentId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSupplyOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderShipmentManager/updateSupplyOrderProperties/supplyOrderShipmentId/id/title/totalAmount/tokensExpr/`
  const supplyOrderShipmentId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderShipmentId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSupplyOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderShipmentManager/removeSupplyOrderList/supplyOrderShipmentId/supplyOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, supplyOrderShipmentId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}supplyOrderShipmentService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}supplyOrderShipmentService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}supplyOrderShipmentService/process/`,
    data,
  })
}

const SupplyOrderShipmentService = { view,
  load,
  addConsumerOrder,
  addSupplyOrder,
  updateConsumerOrder,
  updateSupplyOrder,
  removeConsumerOrderList,
  removeSupplyOrderList, listFunctions, saveRequest, processRequest}
export default SupplyOrderShipmentService

