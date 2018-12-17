import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreOrderManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}retailStoreOrderManager/loadRetailStoreOrder/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateBuyer = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreOrderManager/requestCandidateBuyer/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBuyer = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}retailStoreOrderManager/transferToAnotherBuyer/id/anotherBuyerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateSeller = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreOrderManager/requestCandidateSeller/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherSeller = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}retailStoreOrderManager/transferToAnotherSeller/id/anotherSellerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateConfirmation = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreOrderManager/requestCandidateConfirmation/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherConfirmation = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}retailStoreOrderManager/transferToAnotherConfirmation/id/anotherConfirmationId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateApproval = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreOrderManager/requestCandidateApproval/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherApproval = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}retailStoreOrderManager/transferToAnotherApproval/id/anotherApprovalId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateProcessing = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreOrderManager/requestCandidateProcessing/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherProcessing = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}retailStoreOrderManager/transferToAnotherProcessing/id/anotherProcessingId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidatePicking = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreOrderManager/requestCandidatePicking/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPicking = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}retailStoreOrderManager/transferToAnotherPicking/id/anotherPickingId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateShipment = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreOrderManager/requestCandidateShipment/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherShipment = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}retailStoreOrderManager/transferToAnotherShipment/id/anotherShipmentId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateDelivery = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreOrderManager/requestCandidateDelivery/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherDelivery = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}retailStoreOrderManager/transferToAnotherDelivery/id/anotherDeliveryId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addRetailStoreOrderLineItem = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/addRetailStoreOrderLineItem/retailStoreOrderId/skuId/skuName/amount/quantity/unitOfMeasurement/tokensExpr/`
  const retailStoreOrderId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStoreOrderLineItem = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/updateRetailStoreOrderLineItemProperties/retailStoreOrderId/id/skuId/skuName/amount/quantity/unitOfMeasurement/tokensExpr/`
  const retailStoreOrderId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreOrderLineItemList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/removeRetailStoreOrderLineItemList/retailStoreOrderId/retailStoreOrderLineItemIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreOrderId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRetailStoreOrderShippingGroup = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/addRetailStoreOrderShippingGroup/retailStoreOrderId/name/amount/tokensExpr/`
  const retailStoreOrderId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStoreOrderShippingGroup = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/updateRetailStoreOrderShippingGroupProperties/retailStoreOrderId/id/name/amount/tokensExpr/`
  const retailStoreOrderId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreOrderShippingGroupList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/removeRetailStoreOrderShippingGroupList/retailStoreOrderId/retailStoreOrderShippingGroupIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreOrderId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRetailStoreOrderPaymentGroup = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/addRetailStoreOrderPaymentGroup/retailStoreOrderId/name/cardNumber/tokensExpr/`
  const retailStoreOrderId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStoreOrderPaymentGroup = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/updateRetailStoreOrderPaymentGroupProperties/retailStoreOrderId/id/name/cardNumber/tokensExpr/`
  const retailStoreOrderId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreOrderPaymentGroupList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/removeRetailStoreOrderPaymentGroupList/retailStoreOrderId/retailStoreOrderPaymentGroupIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreOrderId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addGoods = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/addGoods/retailStoreOrderId/name/rfid/uom/maxPackage/expireTime/skuId/receivingSpaceId/goodsAllocationId/smartPalletId/shippingSpaceId/transportTaskId/retailStoreId/bizOrderId/tokensExpr/`
  const retailStoreOrderId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateGoods = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/updateGoodsProperties/retailStoreOrderId/id/name/rfid/uom/maxPackage/expireTime/tokensExpr/`
  const retailStoreOrderId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeGoodsList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/removeGoodsList/retailStoreOrderId/goodsIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreOrderId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const RetailStoreOrderService = { view,
  load,
  addRetailStoreOrderLineItem,
  addRetailStoreOrderShippingGroup,
  addRetailStoreOrderPaymentGroup,
  addGoods,
  updateRetailStoreOrderLineItem,
  updateRetailStoreOrderShippingGroup,
  updateRetailStoreOrderPaymentGroup,
  updateGoods,
  removeRetailStoreOrderLineItemList,
  removeRetailStoreOrderShippingGroupList,
  removeRetailStoreOrderPaymentGroupList,
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
export default RetailStoreOrderService

