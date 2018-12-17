import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}stockCountIssueTrackManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}stockCountIssueTrackManager/loadStockCountIssueTrack/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateStockCount = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}stockCountIssueTrackManager/requestCandidateStockCount/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherStockCount = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}stockCountIssueTrackManager/transferToAnotherStockCount/id/anotherStockCountId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const StockCountIssueTrackService = { view,
  load,
  requestCandidateStockCount,
  transferToAnotherStockCount }
export default StockCountIssueTrackService

