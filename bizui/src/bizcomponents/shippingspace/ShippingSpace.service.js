import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}shippingSpaceManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}shippingSpaceManager/loadShippingSpace/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateWarehouse = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}shippingSpaceManager/requestCandidateWarehouse/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherWarehouse = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}shippingSpaceManager/transferToAnotherWarehouse/id/anotherWarehouseId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addGoods = (targetObjectId, parameters) => {
  const url = `${PREFIX}shippingSpaceManager/addGoods/shippingSpaceId/name/rfid/uom/maxPackage/expireTime/skuId/receivingSpaceId/goodsAllocationId/smartPalletId/transportTaskId/retailStoreId/bizOrderId/retailStoreOrderId/tokensExpr/`
  const shippingSpaceId = targetObjectId
  const requestParameters = { ...parameters, shippingSpaceId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateGoods = (targetObjectId, parameters) => {
  const url = `${PREFIX}shippingSpaceManager/updateGoodsProperties/shippingSpaceId/id/name/rfid/uom/maxPackage/expireTime/tokensExpr/`
  const shippingSpaceId = targetObjectId
  const requestParameters = { ...parameters, shippingSpaceId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeGoodsList = (targetObjectId, parameters) => {
  const url = `${PREFIX}shippingSpaceManager/removeGoodsList/shippingSpaceId/goodsIds/tokensExpr/`
  const requestParameters = { ...parameters, shippingSpaceId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const ShippingSpaceService = { view,
  load,
  addGoods,
  updateGoods,
  removeGoodsList,
  requestCandidateWarehouse,
  transferToAnotherWarehouse }
export default ShippingSpaceService

