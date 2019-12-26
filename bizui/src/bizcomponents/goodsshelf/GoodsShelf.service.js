
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}goodsShelfManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}goodsShelfManager/loadGoodsShelf/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateStorageSpace = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}goodsShelfManager/requestCandidateStorageSpace/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherStorageSpace = (id, parameters) => {
  const url = `${PREFIX}goodsShelfManager/transferToAnotherStorageSpace/id/anotherStorageSpaceId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateSupplierSpace = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}goodsShelfManager/requestCandidateSupplierSpace/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherSupplierSpace = (id, parameters) => {
  const url = `${PREFIX}goodsShelfManager/transferToAnotherSupplierSpace/id/anotherSupplierSpaceId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateDamageSpace = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}goodsShelfManager/requestCandidateDamageSpace/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherDamageSpace = (id, parameters) => {
  const url = `${PREFIX}goodsShelfManager/transferToAnotherDamageSpace/id/anotherDamageSpaceId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addGoodsShelfStockCount = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsShelfManager/addGoodsShelfStockCount/goodsShelfId/title/countTime/summary/tokensExpr/`
  const goodsShelfId = targetObjectId
  const requestParameters = { ...parameters, goodsShelfId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateGoodsShelfStockCount = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsShelfManager/updateGoodsShelfStockCountProperties/goodsShelfId/id/title/countTime/summary/tokensExpr/`
  const goodsShelfId = targetObjectId
  const requestParameters = { ...parameters, goodsShelfId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeGoodsShelfStockCountList = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsShelfManager/removeGoodsShelfStockCountList/goodsShelfId/goodsShelfStockCountIds/tokensExpr/`
  const requestParameters = { ...parameters, goodsShelfId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addGoodsAllocation = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsShelfManager/addGoodsAllocation/goodsShelfId/location/latitude/longitude/tokensExpr/`
  const goodsShelfId = targetObjectId
  const requestParameters = { ...parameters, goodsShelfId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateGoodsAllocation = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsShelfManager/updateGoodsAllocationProperties/goodsShelfId/id/location/latitude/longitude/tokensExpr/`
  const goodsShelfId = targetObjectId
  const requestParameters = { ...parameters, goodsShelfId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeGoodsAllocationList = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsShelfManager/removeGoodsAllocationList/goodsShelfId/goodsAllocationIds/tokensExpr/`
  const requestParameters = { ...parameters, goodsShelfId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}goodsShelfService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}goodsShelfService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}goodsShelfService/process/`,
    data,
  })
}

const GoodsShelfService = { view,
  load,
  addGoodsShelfStockCount,
  addGoodsAllocation,
  updateGoodsShelfStockCount,
  updateGoodsAllocation,
  removeGoodsShelfStockCountList,
  removeGoodsAllocationList,
  requestCandidateStorageSpace,
  requestCandidateSupplierSpace,
  requestCandidateDamageSpace,
  transferToAnotherStorageSpace,
  transferToAnotherSupplierSpace,
  transferToAnotherDamageSpace, listFunctions, saveRequest, processRequest}
export default GoodsShelfService

