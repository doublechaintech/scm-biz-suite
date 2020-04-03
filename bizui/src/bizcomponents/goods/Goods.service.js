
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}goodsManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}goodsManager/loadGoods/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateSku = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}goodsManager/requestCandidateSku/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherSku = (id, parameters) => {
  const url = `${PREFIX}goodsManager/transferToAnotherSku/id/anotherSkuId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateReceivingSpace = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}goodsManager/requestCandidateReceivingSpace/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherReceivingSpace = (id, parameters) => {
  const url = `${PREFIX}goodsManager/transferToAnotherReceivingSpace/id/anotherReceivingSpaceId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateGoodsAllocation = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}goodsManager/requestCandidateGoodsAllocation/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherGoodsAllocation = (id, parameters) => {
  const url = `${PREFIX}goodsManager/transferToAnotherGoodsAllocation/id/anotherGoodsAllocationId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateSmartPallet = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}goodsManager/requestCandidateSmartPallet/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherSmartPallet = (id, parameters) => {
  const url = `${PREFIX}goodsManager/transferToAnotherSmartPallet/id/anotherSmartPalletId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateShippingSpace = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}goodsManager/requestCandidateShippingSpace/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherShippingSpace = (id, parameters) => {
  const url = `${PREFIX}goodsManager/transferToAnotherShippingSpace/id/anotherShippingSpaceId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateTransportTask = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}goodsManager/requestCandidateTransportTask/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherTransportTask = (id, parameters) => {
  const url = `${PREFIX}goodsManager/transferToAnotherTransportTask/id/anotherTransportTaskId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateRetailStore = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}goodsManager/requestCandidateRetailStore/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherRetailStore = (id, parameters) => {
  const url = `${PREFIX}goodsManager/transferToAnotherRetailStore/id/anotherRetailStoreId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateBizOrder = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}goodsManager/requestCandidateBizOrder/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBizOrder = (id, parameters) => {
  const url = `${PREFIX}goodsManager/transferToAnotherBizOrder/id/anotherBizOrderId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateRetailStoreOrder = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}goodsManager/requestCandidateRetailStoreOrder/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherRetailStoreOrder = (id, parameters) => {
  const url = `${PREFIX}goodsManager/transferToAnotherRetailStoreOrder/id/anotherRetailStoreOrderId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addGoodsMovement = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsManager/addGoodsMovement/goodsId/moveTime/facility/facilityId/fromIp/userAgent/sessionId/latitude/longitude/tokensExpr/`
  const goodsId = targetObjectId
  const requestParameters = { ...parameters, goodsId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateGoodsMovement = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsManager/updateGoodsMovementProperties/goodsId/id/moveTime/facility/facilityId/fromIp/userAgent/sessionId/latitude/longitude/tokensExpr/`
  const goodsId = targetObjectId
  const requestParameters = { ...parameters, goodsId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeGoodsMovementList = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsManager/removeGoodsMovementList/goodsId/goodsMovementIds/tokensExpr/`
  const requestParameters = { ...parameters, goodsId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}goodsService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}goodsService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}goodsService/process/`,
    data,
  })
}

const GoodsService = { view,
  load,
  addGoodsMovement,
  updateGoodsMovement,
  removeGoodsMovementList,
  requestCandidateSku,
  requestCandidateReceivingSpace,
  requestCandidateGoodsAllocation,
  requestCandidateSmartPallet,
  requestCandidateShippingSpace,
  requestCandidateTransportTask,
  requestCandidateRetailStore,
  requestCandidateBizOrder,
  requestCandidateRetailStoreOrder,
  transferToAnotherSku,
  transferToAnotherReceivingSpace,
  transferToAnotherGoodsAllocation,
  transferToAnotherSmartPallet,
  transferToAnotherShippingSpace,
  transferToAnotherTransportTask,
  transferToAnotherRetailStore,
  transferToAnotherBizOrder,
  transferToAnotherRetailStoreOrder, listFunctions, saveRequest, processRequest}
export default GoodsService

