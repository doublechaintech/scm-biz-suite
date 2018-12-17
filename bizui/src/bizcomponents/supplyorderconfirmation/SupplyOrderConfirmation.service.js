import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}supplyOrderConfirmationManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}supplyOrderConfirmationManager/loadSupplyOrderConfirmation/${targetObjectId}/${parametersExpr}/`,
  })
}







const addConsumerOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderConfirmationManager/addConsumerOrder/supplyOrderConfirmationId/title/consumerId/storeId/tokensExpr/`
  const supplyOrderConfirmationId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderConfirmationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateConsumerOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderConfirmationManager/updateConsumerOrderProperties/supplyOrderConfirmationId/id/title/tokensExpr/`
  const supplyOrderConfirmationId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderConfirmationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeConsumerOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderConfirmationManager/removeConsumerOrderList/supplyOrderConfirmationId/consumerOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, supplyOrderConfirmationId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addSupplyOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderConfirmationManager/addSupplyOrder/supplyOrderConfirmationId/buyerId/sellerId/title/totalAmount/tokensExpr/`
  const supplyOrderConfirmationId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderConfirmationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSupplyOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderConfirmationManager/updateSupplyOrderProperties/supplyOrderConfirmationId/id/title/totalAmount/tokensExpr/`
  const supplyOrderConfirmationId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderConfirmationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSupplyOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderConfirmationManager/removeSupplyOrderList/supplyOrderConfirmationId/supplyOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, supplyOrderConfirmationId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const SupplyOrderConfirmationService = { view,
  load,
  addConsumerOrder,
  addSupplyOrder,
  updateConsumerOrder,
  updateSupplyOrder,
  removeConsumerOrderList,
  removeSupplyOrderList }
export default SupplyOrderConfirmationService

