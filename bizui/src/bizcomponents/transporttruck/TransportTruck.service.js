
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}transportTruckManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}transportTruckManager/loadTransportTruck/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}transportTruckManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateOwner = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transportTruckManager/requestCandidateOwner/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherOwner = (id, parameters) => {
  const url = `${PREFIX}transportTruckManager/transferToAnotherOwner/id/anotherOwnerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addTransportTask = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportTruckManager/addTransportTask/transportTruckId/name/start/beginTime/endId/driverId/belongsToId/latitude/longitude/tokensExpr/`
  const transportTruckId = targetObjectId
  const requestParameters = { ...parameters, transportTruckId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransportTask = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportTruckManager/updateTransportTaskProperties/transportTruckId/id/name/start/beginTime/latitude/longitude/tokensExpr/`
  const transportTruckId = targetObjectId
  const requestParameters = { ...parameters, transportTruckId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransportTaskList = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportTruckManager/removeTransportTaskList/transportTruckId/transportTaskIds/tokensExpr/`
  const requestParameters = { ...parameters, transportTruckId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}transportTruckService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}transportTruckService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}transportTruckService/process/`,
    data,
  })
}

const TransportTruckService = { view,
  load,
  addTransportTask,
  updateTransportTask,
  removeTransportTaskList,
  requestCandidateOwner,
  transferToAnotherOwner, listFunctions, saveRequest, processRequest, queryCandidates}
export default TransportTruckService

