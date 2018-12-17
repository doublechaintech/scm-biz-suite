import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}accountingPeriodManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}accountingPeriodManager/loadAccountingPeriod/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateAccountSet = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}accountingPeriodManager/requestCandidateAccountSet/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherAccountSet = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}accountingPeriodManager/transferToAnotherAccountSet/id/anotherAccountSetId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addAccountingDocument = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountingPeriodManager/addAccountingDocument/accountingPeriodId/name/accountingDocumentDate/documentTypeId/tokensExpr/`
  const accountingPeriodId = targetObjectId
  const requestParameters = { ...parameters, accountingPeriodId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateAccountingDocument = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountingPeriodManager/updateAccountingDocumentProperties/accountingPeriodId/id/name/accountingDocumentDate/tokensExpr/`
  const accountingPeriodId = targetObjectId
  const requestParameters = { ...parameters, accountingPeriodId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeAccountingDocumentList = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountingPeriodManager/removeAccountingDocumentList/accountingPeriodId/accountingDocumentIds/tokensExpr/`
  const requestParameters = { ...parameters, accountingPeriodId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const AccountingPeriodService = { view,
  load,
  addAccountingDocument,
  updateAccountingDocument,
  removeAccountingDocumentList,
  requestCandidateAccountSet,
  transferToAnotherAccountSet }
export default AccountingPeriodService

