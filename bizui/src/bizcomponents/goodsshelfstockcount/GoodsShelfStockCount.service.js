
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}goodsShelfStockCountManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}goodsShelfStockCountManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}goodsShelfStockCountManager/loadGoodsShelfStockCount/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}goodsShelfStockCountManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateShelf = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}goodsShelfStockCountManager/requestCandidateShelf/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherShelf = (id, parameters) => {
  const url = `${PREFIX}goodsShelfStockCountManager/transferToAnotherShelf/id/anotherShelfId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addStockCountIssueTrack = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsShelfStockCountManager/addStockCountIssueTrack/goodsShelfStockCountId/title/countTime/summary/tokensExpr/`
  const goodsShelfStockCountId = targetObjectId
  const requestParameters = { ...parameters, goodsShelfStockCountId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateStockCountIssueTrack = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsShelfStockCountManager/updateStockCountIssueTrackProperties/goodsShelfStockCountId/id/title/countTime/summary/tokensExpr/`
  const goodsShelfStockCountId = targetObjectId
  const requestParameters = { ...parameters, goodsShelfStockCountId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeStockCountIssueTrackList = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsShelfStockCountManager/removeStockCountIssueTrackList/goodsShelfStockCountId/stockCountIssueTrackIds/tokensExpr/`
  const requestParameters = { ...parameters, goodsShelfStockCountId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}goodsShelfStockCountService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}goodsShelfStockCountService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}goodsShelfStockCountService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}goodsShelfStockCountService/process/`,
    data,
  })
}

const GoodsShelfStockCountService = { view,
  load,
  analyze,
  addStockCountIssueTrack,
  updateStockCountIssueTrack,
  removeStockCountIssueTrackList,
  requestCandidateShelf,
  transferToAnotherShelf, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default GoodsShelfStockCountService

