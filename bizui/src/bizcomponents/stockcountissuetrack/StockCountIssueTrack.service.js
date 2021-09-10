
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}stockCountIssueTrackManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}stockCountIssueTrackManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}stockCountIssueTrackManager/loadStockCountIssueTrack/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}stockCountIssueTrackManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateStockCount = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}stockCountIssueTrackManager/requestCandidateStockCount/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherStockCount = (id, parameters) => {
  const url = `${PREFIX}stockCountIssueTrackManager/transferToAnotherStockCount/id/anotherStockCountId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}stockCountIssueTrackService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}stockCountIssueTrackService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}stockCountIssueTrackService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}stockCountIssueTrackService/process/`,
    data,
  })
}

const StockCountIssueTrackService = { view,
  load,
  analyze,
  requestCandidateStockCount,
  transferToAnotherStockCount, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default StockCountIssueTrackService

