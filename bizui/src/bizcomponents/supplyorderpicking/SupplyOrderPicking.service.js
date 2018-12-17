import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


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
  const url = `${PREFIX}supplyOrderPickingManager/addSupplyOrder/supplyOrderPickingId/buyerId/sellerId/title/totalAmount/tokensExpr/`
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


const SupplyOrderPickingService = { view,
  load,
  addSupplyOrder,
  updateSupplyOrder,
  removeSupplyOrderList }
export default SupplyOrderPickingService

