import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}reportManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}reportManager/loadReport/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateOwner = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}reportManager/requestCandidateOwner/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherOwner = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}reportManager/transferToAnotherOwner/id/anotherOwnerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addReportLine = (targetObjectId, parameters) => {
  const url = `${PREFIX}reportManager/addReportLine/reportId/name/january/february/march/april/may/june/july/august/september/october/november/december/tokensExpr/`
  const reportId = targetObjectId
  const requestParameters = { ...parameters, reportId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateReportLine = (targetObjectId, parameters) => {
  const url = `${PREFIX}reportManager/updateReportLineProperties/reportId/id/name/january/february/march/april/may/june/july/august/september/october/november/december/tokensExpr/`
  const reportId = targetObjectId
  const requestParameters = { ...parameters, reportId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeReportLineList = (targetObjectId, parameters) => {
  const url = `${PREFIX}reportManager/removeReportLineList/reportId/reportLineIds/tokensExpr/`
  const requestParameters = { ...parameters, reportId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const ReportService = { view,
  load,
  addReportLine,
  updateReportLine,
  removeReportLineList,
  requestCandidateOwner,
  transferToAnotherOwner }
export default ReportService

