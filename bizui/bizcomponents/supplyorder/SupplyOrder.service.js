
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}supplyOrderManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}supplyOrderManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}supplyOrderManager/loadSupplyOrder/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}supplyOrderManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateBuyer = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}supplyOrderManager/requestCandidateBuyer/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBuyer = (id, parameters) => {
  const url = `${PREFIX}supplyOrderManager/transferToAnotherBuyer/id/anotherBuyerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateSeller = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}supplyOrderManager/requestCandidateSeller/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherSeller = (id, parameters) => {
  const url = `${PREFIX}supplyOrderManager/transferToAnotherSeller/id/anotherSellerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addSupplyOrderLineItem = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderManager/addSupplyOrderLineItem/supplyOrderId/skuId/skuName/amount/quantity/unitOfMeasurement/tokensExpr/`
  const supplyOrderId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSupplyOrderLineItem = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderManager/updateSupplyOrderLineItemProperties/supplyOrderId/id/skuId/skuName/amount/quantity/unitOfMeasurement/tokensExpr/`
  const supplyOrderId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSupplyOrderLineItemList = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderManager/removeSupplyOrderLineItemList/supplyOrderId/supplyOrderLineItemIds/tokensExpr/`
  const requestParameters = { ...parameters, supplyOrderId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addSupplyOrderShippingGroup = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderManager/addSupplyOrderShippingGroup/supplyOrderId/name/amount/tokensExpr/`
  const supplyOrderId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSupplyOrderShippingGroup = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderManager/updateSupplyOrderShippingGroupProperties/supplyOrderId/id/name/amount/tokensExpr/`
  const supplyOrderId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSupplyOrderShippingGroupList = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderManager/removeSupplyOrderShippingGroupList/supplyOrderId/supplyOrderShippingGroupIds/tokensExpr/`
  const requestParameters = { ...parameters, supplyOrderId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addSupplyOrderPaymentGroup = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderManager/addSupplyOrderPaymentGroup/supplyOrderId/name/cardNumber/tokensExpr/`
  const supplyOrderId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSupplyOrderPaymentGroup = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderManager/updateSupplyOrderPaymentGroupProperties/supplyOrderId/id/name/cardNumber/tokensExpr/`
  const supplyOrderId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSupplyOrderPaymentGroupList = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderManager/removeSupplyOrderPaymentGroupList/supplyOrderId/supplyOrderPaymentGroupIds/tokensExpr/`
  const requestParameters = { ...parameters, supplyOrderId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addGoods = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderManager/addGoods/supplyOrderId/name/rfid/uom/maxPackage/expireTime/skuId/receivingSpaceId/goodsAllocationId/smartPalletId/shippingSpaceId/transportTaskId/retailStoreId/retailStoreOrderId/tokensExpr/`
  const supplyOrderId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateGoods = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderManager/updateGoodsProperties/supplyOrderId/id/name/rfid/uom/maxPackage/expireTime/tokensExpr/`
  const supplyOrderId = targetObjectId
  const requestParameters = { ...parameters, supplyOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeGoodsList = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplyOrderManager/removeGoodsList/supplyOrderId/goodsIds/tokensExpr/`
  const requestParameters = { ...parameters, supplyOrderId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}supplyOrderService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}supplyOrderService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}supplyOrderService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}supplyOrderService/process/`,
    data,
  })
}

const SupplyOrderService = { view,
  load,
  analyze,
  addSupplyOrderLineItem,
  addSupplyOrderShippingGroup,
  addSupplyOrderPaymentGroup,
  addGoods,
  updateSupplyOrderLineItem,
  updateSupplyOrderShippingGroup,
  updateSupplyOrderPaymentGroup,
  updateGoods,
  removeSupplyOrderLineItemList,
  removeSupplyOrderShippingGroupList,
  removeSupplyOrderPaymentGroupList,
  removeGoodsList,
  requestCandidateBuyer,
  requestCandidateSeller,
  transferToAnotherBuyer,
  transferToAnotherSeller, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default SupplyOrderService

