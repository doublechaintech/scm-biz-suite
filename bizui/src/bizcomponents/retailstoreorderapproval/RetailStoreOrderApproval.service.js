
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreOrderApprovalManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}retailStoreOrderApprovalManager/loadRetailStoreOrderApproval/${targetObjectId}/${parametersExpr}/`,
  })
}







const addRetailStoreOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderApprovalManager/addRetailStoreOrder/retailStoreOrderApprovalId/buyerId/sellerId/title/totalAmount/confirmationId/processingId/pickingId/shipmentId/deliveryId/tokensExpr/`
  const retailStoreOrderApprovalId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderApprovalId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStoreOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderApprovalManager/updateRetailStoreOrderProperties/retailStoreOrderApprovalId/id/title/totalAmount/tokensExpr/`
  const retailStoreOrderApprovalId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderApprovalId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderApprovalManager/removeRetailStoreOrderList/retailStoreOrderApprovalId/retailStoreOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreOrderApprovalId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}retailStoreOrderApprovalService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreOrderApprovalService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreOrderApprovalService/process/`,
    data,
  })
}

const RetailStoreOrderApprovalService = { view,
  load,
  addRetailStoreOrder,
  updateRetailStoreOrder,
  removeRetailStoreOrderList, listFunctions, saveRequest, processRequest}
export default RetailStoreOrderApprovalService

