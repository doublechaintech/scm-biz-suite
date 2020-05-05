
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}transportTaskManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}transportTaskManager/loadTransportTask/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}transportTaskManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateEnd = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transportTaskManager/requestCandidateEnd/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherEnd = (id, parameters) => {
  const url = `${PREFIX}transportTaskManager/transferToAnotherEnd/id/anotherEndId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateDriver = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transportTaskManager/requestCandidateDriver/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherDriver = (id, parameters) => {
  const url = `${PREFIX}transportTaskManager/transferToAnotherDriver/id/anotherDriverId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateTruck = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transportTaskManager/requestCandidateTruck/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherTruck = (id, parameters) => {
  const url = `${PREFIX}transportTaskManager/transferToAnotherTruck/id/anotherTruckId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateBelongsTo = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transportTaskManager/requestCandidateBelongsTo/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBelongsTo = (id, parameters) => {
  const url = `${PREFIX}transportTaskManager/transferToAnotherBelongsTo/id/anotherBelongsToId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addGoods = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportTaskManager/addGoods/transportTaskId/name/rfid/uom/maxPackage/expireTime/skuId/receivingSpaceId/goodsAllocationId/smartPalletId/shippingSpaceId/retailStoreId/bizOrderId/retailStoreOrderId/tokensExpr/`
  const transportTaskId = targetObjectId
  const requestParameters = { ...parameters, transportTaskId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateGoods = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportTaskManager/updateGoodsProperties/transportTaskId/id/name/rfid/uom/maxPackage/expireTime/tokensExpr/`
  const transportTaskId = targetObjectId
  const requestParameters = { ...parameters, transportTaskId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeGoodsList = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportTaskManager/removeGoodsList/transportTaskId/goodsIds/tokensExpr/`
  const requestParameters = { ...parameters, transportTaskId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTransportTaskTrack = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportTaskManager/addTransportTaskTrack/transportTaskId/trackTime/latitude/longitude/tokensExpr/`
  const transportTaskId = targetObjectId
  const requestParameters = { ...parameters, transportTaskId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransportTaskTrack = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportTaskManager/updateTransportTaskTrackProperties/transportTaskId/id/trackTime/latitude/longitude/tokensExpr/`
  const transportTaskId = targetObjectId
  const requestParameters = { ...parameters, transportTaskId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransportTaskTrackList = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportTaskManager/removeTransportTaskTrackList/transportTaskId/transportTaskTrackIds/tokensExpr/`
  const requestParameters = { ...parameters, transportTaskId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}transportTaskService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}transportTaskService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}transportTaskService/process/`,
    data,
  })
}

const TransportTaskService = { view,
  load,
  addGoods,
  addTransportTaskTrack,
  updateGoods,
  updateTransportTaskTrack,
  removeGoodsList,
  removeTransportTaskTrackList,
  requestCandidateEnd,
  requestCandidateDriver,
  requestCandidateTruck,
  requestCandidateBelongsTo,
  transferToAnotherEnd,
  transferToAnotherDriver,
  transferToAnotherTruck,
  transferToAnotherBelongsTo, listFunctions, saveRequest, processRequest, queryCandidates}
export default TransportTaskService

