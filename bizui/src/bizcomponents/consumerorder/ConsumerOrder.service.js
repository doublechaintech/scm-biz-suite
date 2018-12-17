import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}consumerOrderManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}consumerOrderManager/loadConsumerOrder/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateConsumer = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}consumerOrderManager/requestCandidateConsumer/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherConsumer = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}consumerOrderManager/transferToAnotherConsumer/id/anotherConsumerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateConfirmation = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}consumerOrderManager/requestCandidateConfirmation/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherConfirmation = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}consumerOrderManager/transferToAnotherConfirmation/id/anotherConfirmationId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateApproval = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}consumerOrderManager/requestCandidateApproval/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherApproval = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}consumerOrderManager/transferToAnotherApproval/id/anotherApprovalId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateProcessing = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}consumerOrderManager/requestCandidateProcessing/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherProcessing = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}consumerOrderManager/transferToAnotherProcessing/id/anotherProcessingId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateShipment = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}consumerOrderManager/requestCandidateShipment/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherShipment = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}consumerOrderManager/transferToAnotherShipment/id/anotherShipmentId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateDelivery = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}consumerOrderManager/requestCandidateDelivery/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherDelivery = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}consumerOrderManager/transferToAnotherDelivery/id/anotherDeliveryId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateStore = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}consumerOrderManager/requestCandidateStore/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherStore = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}consumerOrderManager/transferToAnotherStore/id/anotherStoreId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addConsumerOrderLineItem = (targetObjectId, parameters) => {
  const url = `${PREFIX}consumerOrderManager/addConsumerOrderLineItem/consumerOrderId/skuId/skuName/price/quantity/amount/tokensExpr/`
  const consumerOrderId = targetObjectId
  const requestParameters = { ...parameters, consumerOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateConsumerOrderLineItem = (targetObjectId, parameters) => {
  const url = `${PREFIX}consumerOrderManager/updateConsumerOrderLineItemProperties/consumerOrderId/id/skuId/skuName/price/quantity/amount/tokensExpr/`
  const consumerOrderId = targetObjectId
  const requestParameters = { ...parameters, consumerOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeConsumerOrderLineItemList = (targetObjectId, parameters) => {
  const url = `${PREFIX}consumerOrderManager/removeConsumerOrderLineItemList/consumerOrderId/consumerOrderLineItemIds/tokensExpr/`
  const requestParameters = { ...parameters, consumerOrderId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addConsumerOrderShippingGroup = (targetObjectId, parameters) => {
  const url = `${PREFIX}consumerOrderManager/addConsumerOrderShippingGroup/consumerOrderId/name/amount/tokensExpr/`
  const consumerOrderId = targetObjectId
  const requestParameters = { ...parameters, consumerOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateConsumerOrderShippingGroup = (targetObjectId, parameters) => {
  const url = `${PREFIX}consumerOrderManager/updateConsumerOrderShippingGroupProperties/consumerOrderId/id/name/amount/tokensExpr/`
  const consumerOrderId = targetObjectId
  const requestParameters = { ...parameters, consumerOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeConsumerOrderShippingGroupList = (targetObjectId, parameters) => {
  const url = `${PREFIX}consumerOrderManager/removeConsumerOrderShippingGroupList/consumerOrderId/consumerOrderShippingGroupIds/tokensExpr/`
  const requestParameters = { ...parameters, consumerOrderId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addConsumerOrderPaymentGroup = (targetObjectId, parameters) => {
  const url = `${PREFIX}consumerOrderManager/addConsumerOrderPaymentGroup/consumerOrderId/name/cardNumber/tokensExpr/`
  const consumerOrderId = targetObjectId
  const requestParameters = { ...parameters, consumerOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateConsumerOrderPaymentGroup = (targetObjectId, parameters) => {
  const url = `${PREFIX}consumerOrderManager/updateConsumerOrderPaymentGroupProperties/consumerOrderId/id/name/cardNumber/tokensExpr/`
  const consumerOrderId = targetObjectId
  const requestParameters = { ...parameters, consumerOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeConsumerOrderPaymentGroupList = (targetObjectId, parameters) => {
  const url = `${PREFIX}consumerOrderManager/removeConsumerOrderPaymentGroupList/consumerOrderId/consumerOrderPaymentGroupIds/tokensExpr/`
  const requestParameters = { ...parameters, consumerOrderId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addConsumerOrderPriceAdjustment = (targetObjectId, parameters) => {
  const url = `${PREFIX}consumerOrderManager/addConsumerOrderPriceAdjustment/consumerOrderId/name/amount/provider/tokensExpr/`
  const consumerOrderId = targetObjectId
  const requestParameters = { ...parameters, consumerOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateConsumerOrderPriceAdjustment = (targetObjectId, parameters) => {
  const url = `${PREFIX}consumerOrderManager/updateConsumerOrderPriceAdjustmentProperties/consumerOrderId/id/name/amount/provider/tokensExpr/`
  const consumerOrderId = targetObjectId
  const requestParameters = { ...parameters, consumerOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeConsumerOrderPriceAdjustmentList = (targetObjectId, parameters) => {
  const url = `${PREFIX}consumerOrderManager/removeConsumerOrderPriceAdjustmentList/consumerOrderId/consumerOrderPriceAdjustmentIds/tokensExpr/`
  const requestParameters = { ...parameters, consumerOrderId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRetailStoreMemberGiftCardConsumeRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}consumerOrderManager/addRetailStoreMemberGiftCardConsumeRecord/consumerOrderId/occureTime/ownerId/number/amount/tokensExpr/`
  const consumerOrderId = targetObjectId
  const requestParameters = { ...parameters, consumerOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStoreMemberGiftCardConsumeRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}consumerOrderManager/updateRetailStoreMemberGiftCardConsumeRecordProperties/consumerOrderId/id/occureTime/number/amount/tokensExpr/`
  const consumerOrderId = targetObjectId
  const requestParameters = { ...parameters, consumerOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreMemberGiftCardConsumeRecordList = (targetObjectId, parameters) => {
  const url = `${PREFIX}consumerOrderManager/removeRetailStoreMemberGiftCardConsumeRecordList/consumerOrderId/retailStoreMemberGiftCardConsumeRecordIds/tokensExpr/`
  const requestParameters = { ...parameters, consumerOrderId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const ConsumerOrderService = { view,
  load,
  addConsumerOrderLineItem,
  addConsumerOrderShippingGroup,
  addConsumerOrderPaymentGroup,
  addConsumerOrderPriceAdjustment,
  addRetailStoreMemberGiftCardConsumeRecord,
  updateConsumerOrderLineItem,
  updateConsumerOrderShippingGroup,
  updateConsumerOrderPaymentGroup,
  updateConsumerOrderPriceAdjustment,
  updateRetailStoreMemberGiftCardConsumeRecord,
  removeConsumerOrderLineItemList,
  removeConsumerOrderShippingGroupList,
  removeConsumerOrderPaymentGroupList,
  removeConsumerOrderPriceAdjustmentList,
  removeRetailStoreMemberGiftCardConsumeRecordList,
  requestCandidateConsumer,
  requestCandidateConfirmation,
  requestCandidateApproval,
  requestCandidateProcessing,
  requestCandidateShipment,
  requestCandidateDelivery,
  requestCandidateStore,
  transferToAnotherConsumer,
  transferToAnotherConfirmation,
  transferToAnotherApproval,
  transferToAnotherProcessing,
  transferToAnotherShipment,
  transferToAnotherDelivery,
  transferToAnotherStore }
export default ConsumerOrderService

