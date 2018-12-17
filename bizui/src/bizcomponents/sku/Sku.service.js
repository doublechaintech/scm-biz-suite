import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}skuManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}skuManager/loadSku/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateProduct = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}skuManager/requestCandidateProduct/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherProduct = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}skuManager/transferToAnotherProduct/id/anotherProductId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addGoods = (targetObjectId, parameters) => {
  const url = `${PREFIX}skuManager/addGoods/skuId/name/rfid/uom/maxPackage/expireTime/receivingSpaceId/goodsAllocationId/smartPalletId/shippingSpaceId/transportTaskId/retailStoreId/bizOrderId/retailStoreOrderId/tokensExpr/`
  const skuId = targetObjectId
  const requestParameters = { ...parameters, skuId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateGoods = (targetObjectId, parameters) => {
  const url = `${PREFIX}skuManager/updateGoodsProperties/skuId/id/name/rfid/uom/maxPackage/expireTime/tokensExpr/`
  const skuId = targetObjectId
  const requestParameters = { ...parameters, skuId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeGoodsList = (targetObjectId, parameters) => {
  const url = `${PREFIX}skuManager/removeGoodsList/skuId/goodsIds/tokensExpr/`
  const requestParameters = { ...parameters, skuId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const SkuService = { view,
  load,
  addGoods,
  updateGoods,
  removeGoodsList,
  requestCandidateProduct,
  transferToAnotherProduct }
export default SkuService

