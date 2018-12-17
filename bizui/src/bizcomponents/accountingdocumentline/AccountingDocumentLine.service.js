import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}accountingDocumentLineManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}accountingDocumentLineManager/loadAccountingDocumentLine/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateBelongsTo = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}accountingDocumentLineManager/requestCandidateBelongsTo/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBelongsTo = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}accountingDocumentLineManager/transferToAnotherBelongsTo/id/anotherBelongsToId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateAccountingSubject = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}accountingDocumentLineManager/requestCandidateAccountingSubject/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherAccountingSubject = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}accountingDocumentLineManager/transferToAnotherAccountingSubject/id/anotherAccountingSubjectId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const AccountingDocumentLineService = { view,
  load,
  requestCandidateBelongsTo,
  requestCandidateAccountingSubject,
  transferToAnotherBelongsTo,
  transferToAnotherAccountingSubject }
export default AccountingDocumentLineService

