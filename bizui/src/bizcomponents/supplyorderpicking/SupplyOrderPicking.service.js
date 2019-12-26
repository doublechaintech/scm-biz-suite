
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}supplyOrderPickingManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}supplyOrderPickingManager/loadSupplyOrderPicking/${targetObjectId}/${parametersExpr}/`,
  })
}







const addSupplyOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderPickingManager/addSupplyOrder/supplyOrderPickingId/buyerId/sellerId/title/totalAmount/confirmationId/approvalId/processingId/shipmentId/deliveryId/tokensExpr/`
  const supplyOrderPickingId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderPickingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSupplyOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderPickingManager/updateSupplyOrderProperties/supplyOrderPickingId/id/title/totalAmount/tokensExpr/`
  const supplyOrderPickingId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderPickingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSupplyOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderPickingManager/removeSupplyOrderList/supplyOrderPickingId/supplyOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, supplyOrderPickingId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}supplyOrderPickingService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}supplyOrderPickingService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}supplyOrderPickingService/process/`,
    data,
  })
}

const SupplyOrderPickingService = { view,
  load,
  addSupplyOrder,
  updateSupplyOrder,
  removeSupplyOrderList, listFunctions, saveRequest, processRequest}
export default SupplyOrderPickingService

