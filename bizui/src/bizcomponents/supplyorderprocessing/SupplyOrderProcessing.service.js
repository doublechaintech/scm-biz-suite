import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


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
  const url = `${PREFIX}supplyOrderProcessingManager/addConsumerOrder/supplyOrderProcessingId/title/consumerId/storeId/tokensExpr/`
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
  const url = `${PREFIX}supplyOrderProcessingManager/addSupplyOrder/supplyOrderProcessingId/buyerId/sellerId/title/totalAmount/tokensExpr/`
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


const SupplyOrderProcessingService = { view,
  load,
  addConsumerOrder,
  addSupplyOrder,
  updateConsumerOrder,
  updateSupplyOrder,
  removeConsumerOrderList,
  removeSupplyOrderList }
export default SupplyOrderProcessingService

