import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}terminationReasonManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}terminationReasonManager/loadTerminationReason/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateCompany = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}terminationReasonManager/requestCandidateCompany/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCompany = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}terminationReasonManager/transferToAnotherCompany/id/anotherCompanyId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addTermination = (targetObjectId, parameters) => {
  const url = `${PREFIX}terminationReasonManager/addTermination/terminationReasonId/typeId/comment/tokensExpr/`
  const terminationReasonId = targetObjectId
  const requestParameters = { ...parameters, terminationReasonId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTermination = (targetObjectId, parameters) => {
  const url = `${PREFIX}terminationReasonManager/updateTerminationProperties/terminationReasonId/id/comment/tokensExpr/`
  const terminationReasonId = targetObjectId
  const requestParameters = { ...parameters, terminationReasonId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTerminationList = (targetObjectId, parameters) => {
  const url = `${PREFIX}terminationReasonManager/removeTerminationList/terminationReasonId/terminationIds/tokensExpr/`
  const requestParameters = { ...parameters, terminationReasonId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const TerminationReasonService = { view,
  load,
  addTermination,
  updateTermination,
  removeTerminationList,
  requestCandidateCompany,
  transferToAnotherCompany }
export default TerminationReasonService

