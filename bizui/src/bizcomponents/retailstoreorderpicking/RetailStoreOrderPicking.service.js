
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreOrderPickingManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}retailStoreOrderPickingManager/loadRetailStoreOrderPicking/${targetObjectId}/${parametersExpr}/`,
  })
}







const addRetailStoreOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderPickingManager/addRetailStoreOrder/retailStoreOrderPickingId/buyerId/sellerId/title/totalAmount/confirmationId/approvalId/processingId/shipmentId/deliveryId/tokensExpr/`
  const retailStoreOrderPickingId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderPickingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStoreOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderPickingManager/updateRetailStoreOrderProperties/retailStoreOrderPickingId/id/title/totalAmount/tokensExpr/`
  const retailStoreOrderPickingId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderPickingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderPickingManager/removeRetailStoreOrderList/retailStoreOrderPickingId/retailStoreOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreOrderPickingId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}retailStoreOrderPickingService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreOrderPickingService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreOrderPickingService/process/`,
    data,
  })
}

const RetailStoreOrderPickingService = { view,
  load,
  addRetailStoreOrder,
  updateRetailStoreOrder,
  removeRetailStoreOrderList, listFunctions, saveRequest, processRequest}
export default RetailStoreOrderPickingService

