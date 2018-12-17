import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}receivingSpaceManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}receivingSpaceManager/loadReceivingSpace/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateWarehouse = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}receivingSpaceManager/requestCandidateWarehouse/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherWarehouse = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}receivingSpaceManager/transferToAnotherWarehouse/id/anotherWarehouseId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addGoods = (targetObjectId, parameters) => {
  const url = `${PREFIX}receivingSpaceManager/addGoods/receivingSpaceId/name/rfid/uom/maxPackage/expireTime/skuId/goodsAllocationId/smartPalletId/shippingSpaceId/transportTaskId/retailStoreId/bizOrderId/retailStoreOrderId/tokensExpr/`
  const receivingSpaceId = targetObjectId
  const requestParameters = { ...parameters, receivingSpaceId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateGoods = (targetObjectId, parameters) => {
  const url = `${PREFIX}receivingSpaceManager/updateGoodsProperties/receivingSpaceId/id/name/rfid/uom/maxPackage/expireTime/tokensExpr/`
  const receivingSpaceId = targetObjectId
  const requestParameters = { ...parameters, receivingSpaceId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeGoodsList = (targetObjectId, parameters) => {
  const url = `${PREFIX}receivingSpaceManager/removeGoodsList/receivingSpaceId/goodsIds/tokensExpr/`
  const requestParameters = { ...parameters, receivingSpaceId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const ReceivingSpaceService = { view,
  load,
  addGoods,
  updateGoods,
  removeGoodsList,
  requestCandidateWarehouse,
  transferToAnotherWarehouse }
export default ReceivingSpaceService

