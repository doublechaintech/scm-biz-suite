import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}supplyOrderManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}supplyOrderManager/loadSupplyOrder/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateBuyer = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}supplyOrderManager/requestCandidateBuyer/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBuyer = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
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
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}supplyOrderManager/transferToAnotherSeller/id/anotherSellerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateConfirmation = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}supplyOrderManager/requestCandidateConfirmation/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherConfirmation = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}supplyOrderManager/transferToAnotherConfirmation/id/anotherConfirmationId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateApproval = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}supplyOrderManager/requestCandidateApproval/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherApproval = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}supplyOrderManager/transferToAnotherApproval/id/anotherApprovalId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateProcessing = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}supplyOrderManager/requestCandidateProcessing/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherProcessing = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}supplyOrderManager/transferToAnotherProcessing/id/anotherProcessingId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidatePicking = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}supplyOrderManager/requestCandidatePicking/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPicking = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}supplyOrderManager/transferToAnotherPicking/id/anotherPickingId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateShipment = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}supplyOrderManager/requestCandidateShipment/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherShipment = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}supplyOrderManager/transferToAnotherShipment/id/anotherShipmentId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateDelivery = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}supplyOrderManager/requestCandidateDelivery/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherDelivery = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}supplyOrderManager/transferToAnotherDelivery/id/anotherDeliveryId/`
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


const SupplyOrderService = { view,
  load,
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
  requestCandidateConfirmation,
  requestCandidateApproval,
  requestCandidateProcessing,
  requestCandidatePicking,
  requestCandidateShipment,
  requestCandidateDelivery,
  transferToAnotherBuyer,
  transferToAnotherSeller,
  transferToAnotherConfirmation,
  transferToAnotherApproval,
  transferToAnotherProcessing,
  transferToAnotherPicking,
  transferToAnotherShipment,
  transferToAnotherDelivery }
export default SupplyOrderService

