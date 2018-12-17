import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreOrderConfirmationManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}retailStoreOrderConfirmationManager/loadRetailStoreOrderConfirmation/${targetObjectId}/${parametersExpr}/`,
  })
}







const addRetailStoreOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderConfirmationManager/addRetailStoreOrder/retailStoreOrderConfirmationId/buyerId/sellerId/title/totalAmount/tokensExpr/`
  const retailStoreOrderConfirmationId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderConfirmationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStoreOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderConfirmationManager/updateRetailStoreOrderProperties/retailStoreOrderConfirmationId/id/title/totalAmount/tokensExpr/`
  const retailStoreOrderConfirmationId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderConfirmationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderConfirmationManager/removeRetailStoreOrderList/retailStoreOrderConfirmationId/retailStoreOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreOrderConfirmationId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const RetailStoreOrderConfirmationService = { view,
  load,
  addRetailStoreOrder,
  updateRetailStoreOrder,
  removeRetailStoreOrderList }
export default RetailStoreOrderConfirmationService

