
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}retailStoreManager/loadRetailStore/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateRetailStoreCountryCenter = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreManager/requestCandidateRetailStoreCountryCenter/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherRetailStoreCountryCenter = (id, parameters) => {
  const url = `${PREFIX}retailStoreManager/transferToAnotherRetailStoreCountryCenter/id/anotherRetailStoreCountryCenterId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateCityServiceCenter = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreManager/requestCandidateCityServiceCenter/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCityServiceCenter = (id, parameters) => {
  const url = `${PREFIX}retailStoreManager/transferToAnotherCityServiceCenter/id/anotherCityServiceCenterId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateCreation = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreManager/requestCandidateCreation/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCreation = (id, parameters) => {
  const url = `${PREFIX}retailStoreManager/transferToAnotherCreation/id/anotherCreationId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateInvestmentInvitation = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreManager/requestCandidateInvestmentInvitation/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherInvestmentInvitation = (id, parameters) => {
  const url = `${PREFIX}retailStoreManager/transferToAnotherInvestmentInvitation/id/anotherInvestmentInvitationId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateFranchising = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreManager/requestCandidateFranchising/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherFranchising = (id, parameters) => {
  const url = `${PREFIX}retailStoreManager/transferToAnotherFranchising/id/anotherFranchisingId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateDecoration = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreManager/requestCandidateDecoration/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherDecoration = (id, parameters) => {
  const url = `${PREFIX}retailStoreManager/transferToAnotherDecoration/id/anotherDecorationId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateOpening = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreManager/requestCandidateOpening/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherOpening = (id, parameters) => {
  const url = `${PREFIX}retailStoreManager/transferToAnotherOpening/id/anotherOpeningId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateClosing = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreManager/requestCandidateClosing/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherClosing = (id, parameters) => {
  const url = `${PREFIX}retailStoreManager/transferToAnotherClosing/id/anotherClosingId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addConsumerOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreManager/addConsumerOrder/retailStoreId/title/consumerId/confirmationId/approvalId/processingId/shipmentId/deliveryId/tokensExpr/`
  const retailStoreId = targetObjectId
  const requestParameters = { ...parameters, retailStoreId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateConsumerOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreManager/updateConsumerOrderProperties/retailStoreId/id/title/tokensExpr/`
  const retailStoreId = targetObjectId
  const requestParameters = { ...parameters, retailStoreId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeConsumerOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreManager/removeConsumerOrderList/retailStoreId/consumerOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRetailStoreOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreManager/addRetailStoreOrder/retailStoreId/sellerId/title/totalAmount/confirmationId/approvalId/processingId/pickingId/shipmentId/deliveryId/tokensExpr/`
  const retailStoreId = targetObjectId
  const requestParameters = { ...parameters, retailStoreId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStoreOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreManager/updateRetailStoreOrderProperties/retailStoreId/id/title/totalAmount/tokensExpr/`
  const retailStoreId = targetObjectId
  const requestParameters = { ...parameters, retailStoreId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreManager/removeRetailStoreOrderList/retailStoreId/retailStoreOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addGoods = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreManager/addGoods/retailStoreId/name/rfid/uom/maxPackage/expireTime/skuId/receivingSpaceId/goodsAllocationId/smartPalletId/shippingSpaceId/transportTaskId/bizOrderId/retailStoreOrderId/packagingId/tokensExpr/`
  const retailStoreId = targetObjectId
  const requestParameters = { ...parameters, retailStoreId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateGoods = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreManager/updateGoodsProperties/retailStoreId/id/name/rfid/uom/maxPackage/expireTime/tokensExpr/`
  const retailStoreId = targetObjectId
  const requestParameters = { ...parameters, retailStoreId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeGoodsList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreManager/removeGoodsList/retailStoreId/goodsIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTransportTask = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreManager/addTransportTask/retailStoreId/name/start/beginTime/driverId/truckId/belongsToId/latitude/longitude/tokensExpr/`
  const retailStoreId = targetObjectId
  const requestParameters = { ...parameters, retailStoreId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransportTask = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreManager/updateTransportTaskProperties/retailStoreId/id/name/start/beginTime/latitude/longitude/tokensExpr/`
  const retailStoreId = targetObjectId
  const requestParameters = { ...parameters, retailStoreId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransportTaskList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreManager/removeTransportTaskList/retailStoreId/transportTaskIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addAccountSet = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreManager/addAccountSet/retailStoreId/name/yearSet/effectiveDate/accountingSystem/domesticCurrencyCode/domesticCurrencyName/openingBank/accountNumber/countryCenterId/goodsSupplierId/tokensExpr/`
  const retailStoreId = targetObjectId
  const requestParameters = { ...parameters, retailStoreId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateAccountSet = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreManager/updateAccountSetProperties/retailStoreId/id/name/yearSet/effectiveDate/accountingSystem/domesticCurrencyCode/domesticCurrencyName/openingBank/accountNumber/tokensExpr/`
  const retailStoreId = targetObjectId
  const requestParameters = { ...parameters, retailStoreId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeAccountSetList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreManager/removeAccountSetList/retailStoreId/accountSetIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}retailStoreService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreService/process/`,
    data,
  })
}

const RetailStoreService = { view,
  load,
  addConsumerOrder,
  addRetailStoreOrder,
  addGoods,
  addTransportTask,
  addAccountSet,
  updateConsumerOrder,
  updateRetailStoreOrder,
  updateGoods,
  updateTransportTask,
  updateAccountSet,
  removeConsumerOrderList,
  removeRetailStoreOrderList,
  removeGoodsList,
  removeTransportTaskList,
  removeAccountSetList,
  requestCandidateRetailStoreCountryCenter,
  requestCandidateCityServiceCenter,
  requestCandidateCreation,
  requestCandidateInvestmentInvitation,
  requestCandidateFranchising,
  requestCandidateDecoration,
  requestCandidateOpening,
  requestCandidateClosing,
  transferToAnotherRetailStoreCountryCenter,
  transferToAnotherCityServiceCenter,
  transferToAnotherCreation,
  transferToAnotherInvestmentInvitation,
  transferToAnotherFranchising,
  transferToAnotherDecoration,
  transferToAnotherOpening,
  transferToAnotherClosing, listFunctions, saveRequest, processRequest}
export default RetailStoreService

