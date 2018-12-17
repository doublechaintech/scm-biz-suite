import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}goodsPackagingManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}goodsPackagingManager/loadGoodsPackaging/${targetObjectId}/${parametersExpr}/`,
  })
}







const addGoods = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsPackagingManager/addGoods/goodsPackagingId/name/rfid/uom/maxPackage/expireTime/skuId/receivingSpaceId/goodsAllocationId/smartPalletId/shippingSpaceId/transportTaskId/retailStoreId/bizOrderId/retailStoreOrderId/tokensExpr/`
  const goodsPackagingId = targetObjectId
  const requestParameters = { ...parameters, goodsPackagingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateGoods = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsPackagingManager/updateGoodsProperties/goodsPackagingId/id/name/rfid/uom/maxPackage/expireTime/tokensExpr/`
  const goodsPackagingId = targetObjectId
  const requestParameters = { ...parameters, goodsPackagingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeGoodsList = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsPackagingManager/removeGoodsList/goodsPackagingId/goodsIds/tokensExpr/`
  const requestParameters = { ...parameters, goodsPackagingId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const GoodsPackagingService = { view,
  load,
  addGoods,
  updateGoods,
  removeGoodsList }
export default GoodsPackagingService

