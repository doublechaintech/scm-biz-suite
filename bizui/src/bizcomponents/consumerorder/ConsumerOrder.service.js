
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

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


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}consumerOrderManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateConsumer = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}consumerOrderManager/requestCandidateConsumer/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherConsumer = (id, parameters) => {
  const url = `${PREFIX}consumerOrderManager/transferToAnotherConsumer/id/anotherConsumerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateStore = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}consumerOrderManager/requestCandidateStore/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherStore = (id, parameters) => {
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



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}consumerOrderService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}consumerOrderService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}consumerOrderService/process/`,
    data,
  })
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
  requestCandidateStore,
  transferToAnotherConsumer,
  transferToAnotherStore, listFunctions, saveRequest, processRequest, queryCandidates}
export default ConsumerOrderService

