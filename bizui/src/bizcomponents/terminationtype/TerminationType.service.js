import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}terminationTypeManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}terminationTypeManager/loadTerminationType/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateCompany = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}terminationTypeManager/requestCandidateCompany/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCompany = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}terminationTypeManager/transferToAnotherCompany/id/anotherCompanyId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addTermination = (targetObjectId, parameters) => {
  const url = `${PREFIX}terminationTypeManager/addTermination/terminationTypeId/reasonId/comment/tokensExpr/`
  const terminationTypeId = targetObjectId
  const requestParameters = { ...parameters, terminationTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTermination = (targetObjectId, parameters) => {
  const url = `${PREFIX}terminationTypeManager/updateTerminationProperties/terminationTypeId/id/comment/tokensExpr/`
  const terminationTypeId = targetObjectId
  const requestParameters = { ...parameters, terminationTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTerminationList = (targetObjectId, parameters) => {
  const url = `${PREFIX}terminationTypeManager/removeTerminationList/terminationTypeId/terminationIds/tokensExpr/`
  const requestParameters = { ...parameters, terminationTypeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const TerminationTypeService = { view,
  load,
  addTermination,
  updateTermination,
  removeTerminationList,
  requestCandidateCompany,
  transferToAnotherCompany }
export default TerminationTypeService

