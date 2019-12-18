
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}smartPalletManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}smartPalletManager/loadSmartPallet/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateWarehouse = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}smartPalletManager/requestCandidateWarehouse/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherWarehouse = (id, parameters) => {
  const url = `${PREFIX}smartPalletManager/transferToAnotherWarehouse/id/anotherWarehouseId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addGoods = (targetObjectId, parameters) => {
  const url = `${PREFIX}smartPalletManager/addGoods/smartPalletId/name/rfid/uom/maxPackage/expireTime/skuId/receivingSpaceId/goodsAllocationId/shippingSpaceId/transportTaskId/retailStoreId/bizOrderId/retailStoreOrderId/packagingId/tokensExpr/`
  const smartPalletId = targetObjectId
  const requestParameters = { ...parameters, smartPalletId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateGoods = (targetObjectId, parameters) => {
  const url = `${PREFIX}smartPalletManager/updateGoodsProperties/smartPalletId/id/name/rfid/uom/maxPackage/expireTime/tokensExpr/`
  const smartPalletId = targetObjectId
  const requestParameters = { ...parameters, smartPalletId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeGoodsList = (targetObjectId, parameters) => {
  const url = `${PREFIX}smartPalletManager/removeGoodsList/smartPalletId/goodsIds/tokensExpr/`
  const requestParameters = { ...parameters, smartPalletId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}smartPalletService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}smartPalletService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}smartPalletService/process/`,
    data,
  })
}

const SmartPalletService = { view,
  load,
  addGoods,
  updateGoods,
  removeGoodsList,
  requestCandidateWarehouse,
  transferToAnotherWarehouse, listFunctions, saveRequest, processRequest}
export default SmartPalletService

