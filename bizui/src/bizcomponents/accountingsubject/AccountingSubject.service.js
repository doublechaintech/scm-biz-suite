import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}accountingSubjectManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}accountingSubjectManager/loadAccountingSubject/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateAccountSet = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}accountingSubjectManager/requestCandidateAccountSet/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherAccountSet = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}accountingSubjectManager/transferToAnotherAccountSet/id/anotherAccountSetId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addAccountingDocumentLine = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountingSubjectManager/addAccountingDocumentLine/accountingSubjectId/name/code/direct/amount/belongsToId/tokensExpr/`
  const accountingSubjectId = targetObjectId
  const requestParameters = { ...parameters, accountingSubjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateAccountingDocumentLine = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountingSubjectManager/updateAccountingDocumentLineProperties/accountingSubjectId/id/name/code/direct/amount/tokensExpr/`
  const accountingSubjectId = targetObjectId
  const requestParameters = { ...parameters, accountingSubjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeAccountingDocumentLineList = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountingSubjectManager/removeAccountingDocumentLineList/accountingSubjectId/accountingDocumentLineIds/tokensExpr/`
  const requestParameters = { ...parameters, accountingSubjectId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const AccountingSubjectService = { view,
  load,
  addAccountingDocumentLine,
  updateAccountingDocumentLine,
  removeAccountingDocumentLineList,
  requestCandidateAccountSet,
  transferToAnotherAccountSet }
export default AccountingSubjectService

