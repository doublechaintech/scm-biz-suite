
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}truckDriverManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}truckDriverManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}truckDriverManager/loadTruckDriver/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}truckDriverManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateBelongsTo = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}truckDriverManager/requestCandidateBelongsTo/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBelongsTo = (id, parameters) => {
  const url = `${PREFIX}truckDriverManager/transferToAnotherBelongsTo/id/anotherBelongsToId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addTransportTask = (targetObjectId, parameters) => {
  const url = `${PREFIX}truckDriverManager/addTransportTask/truckDriverId/name/start/beginTime/endId/truckId/belongsToId/latitude/longitude/tokensExpr/`
  const truckDriverId = targetObjectId
  const requestParameters = { ...parameters, truckDriverId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransportTask = (targetObjectId, parameters) => {
  const url = `${PREFIX}truckDriverManager/updateTransportTaskProperties/truckDriverId/id/name/start/beginTime/latitude/longitude/tokensExpr/`
  const truckDriverId = targetObjectId
  const requestParameters = { ...parameters, truckDriverId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransportTaskList = (targetObjectId, parameters) => {
  const url = `${PREFIX}truckDriverManager/removeTransportTaskList/truckDriverId/transportTaskIds/tokensExpr/`
  const requestParameters = { ...parameters, truckDriverId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}truckDriverService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}truckDriverService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}truckDriverService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}truckDriverService/process/`,
    data,
  })
}

const TruckDriverService = { view,
  load,
  analyze,
  addTransportTask,
  updateTransportTask,
  removeTransportTaskList,
  requestCandidateBelongsTo,
  transferToAnotherBelongsTo, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default TruckDriverService

