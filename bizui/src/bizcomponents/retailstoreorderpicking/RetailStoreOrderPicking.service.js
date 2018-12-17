import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


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
  const url = `${PREFIX}retailStoreOrderPickingManager/addRetailStoreOrder/retailStoreOrderPickingId/buyerId/sellerId/title/totalAmount/tokensExpr/`
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


const RetailStoreOrderPickingService = { view,
  load,
  addRetailStoreOrder,
  updateRetailStoreOrder,
  removeRetailStoreOrderList }
export default RetailStoreOrderPickingService

