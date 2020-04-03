
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}goodsAllocationManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}goodsAllocationManager/loadGoodsAllocation/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateGoodsShelf = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}goodsAllocationManager/requestCandidateGoodsShelf/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherGoodsShelf = (id, parameters) => {
  const url = `${PREFIX}goodsAllocationManager/transferToAnotherGoodsShelf/id/anotherGoodsShelfId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addGoods = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsAllocationManager/addGoods/goodsAllocationId/name/rfid/uom/maxPackage/expireTime/skuId/receivingSpaceId/smartPalletId/shippingSpaceId/transportTaskId/retailStoreId/bizOrderId/retailStoreOrderId/tokensExpr/`
  const goodsAllocationId = targetObjectId
  const requestParameters = { ...parameters, goodsAllocationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateGoods = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsAllocationManager/updateGoodsProperties/goodsAllocationId/id/name/rfid/uom/maxPackage/expireTime/tokensExpr/`
  const goodsAllocationId = targetObjectId
  const requestParameters = { ...parameters, goodsAllocationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeGoodsList = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsAllocationManager/removeGoodsList/goodsAllocationId/goodsIds/tokensExpr/`
  const requestParameters = { ...parameters, goodsAllocationId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}goodsAllocationService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}goodsAllocationService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}goodsAllocationService/process/`,
    data,
  })
}

const GoodsAllocationService = { view,
  load,
  addGoods,
  updateGoods,
  removeGoodsList,
  requestCandidateGoodsShelf,
  transferToAnotherGoodsShelf, listFunctions, saveRequest, processRequest}
export default GoodsAllocationService

