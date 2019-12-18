
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}supplyOrderApprovalManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}supplyOrderApprovalManager/loadSupplyOrderApproval/${targetObjectId}/${parametersExpr}/`,
  })
}







const addConsumerOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderApprovalManager/addConsumerOrder/supplyOrderApprovalId/title/consumerId/confirmationId/processingId/shipmentId/deliveryId/storeId/tokensExpr/`
  const supplyOrderApprovalId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderApprovalId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateConsumerOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderApprovalManager/updateConsumerOrderProperties/supplyOrderApprovalId/id/title/tokensExpr/`
  const supplyOrderApprovalId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderApprovalId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeConsumerOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderApprovalManager/removeConsumerOrderList/supplyOrderApprovalId/consumerOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, supplyOrderApprovalId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addSupplyOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderApprovalManager/addSupplyOrder/supplyOrderApprovalId/buyerId/sellerId/title/totalAmount/confirmationId/processingId/pickingId/shipmentId/deliveryId/tokensExpr/`
  const supplyOrderApprovalId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderApprovalId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSupplyOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderApprovalManager/updateSupplyOrderProperties/supplyOrderApprovalId/id/title/totalAmount/tokensExpr/`
  const supplyOrderApprovalId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderApprovalId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSupplyOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderApprovalManager/removeSupplyOrderList/supplyOrderApprovalId/supplyOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, supplyOrderApprovalId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}supplyOrderApprovalService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}supplyOrderApprovalService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}supplyOrderApprovalService/process/`,
    data,
  })
}

const SupplyOrderApprovalService = { view,
  load,
  addConsumerOrder,
  addSupplyOrder,
  updateConsumerOrder,
  updateSupplyOrder,
  removeConsumerOrderList,
  removeSupplyOrderList, listFunctions, saveRequest, processRequest}
export default SupplyOrderApprovalService

