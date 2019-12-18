
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreOrderProcessingManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}retailStoreOrderProcessingManager/loadRetailStoreOrderProcessing/${targetObjectId}/${parametersExpr}/`,
  })
}







const addRetailStoreOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderProcessingManager/addRetailStoreOrder/retailStoreOrderProcessingId/buyerId/sellerId/title/totalAmount/confirmationId/approvalId/pickingId/shipmentId/deliveryId/tokensExpr/`
  const retailStoreOrderProcessingId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderProcessingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStoreOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderProcessingManager/updateRetailStoreOrderProperties/retailStoreOrderProcessingId/id/title/totalAmount/tokensExpr/`
  const retailStoreOrderProcessingId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderProcessingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderProcessingManager/removeRetailStoreOrderList/retailStoreOrderProcessingId/retailStoreOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreOrderProcessingId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}retailStoreOrderProcessingService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreOrderProcessingService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreOrderProcessingService/process/`,
    data,
  })
}

const RetailStoreOrderProcessingService = { view,
  load,
  addRetailStoreOrder,
  updateRetailStoreOrder,
  removeRetailStoreOrderList, listFunctions, saveRequest, processRequest}
export default RetailStoreOrderProcessingService

