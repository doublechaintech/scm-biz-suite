import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}accountingDocumentTypeManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}accountingDocumentTypeManager/loadAccountingDocumentType/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateAccountingPeriod = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}accountingDocumentTypeManager/requestCandidateAccountingPeriod/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherAccountingPeriod = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}accountingDocumentTypeManager/transferToAnotherAccountingPeriod/id/anotherAccountingPeriodId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addAccountingDocument = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountingDocumentTypeManager/addAccountingDocument/accountingDocumentTypeId/name/accountingDocumentDate/accountingPeriodId/tokensExpr/`
  const accountingDocumentTypeId = targetObjectId
  const requestParameters = { ...parameters, accountingDocumentTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateAccountingDocument = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountingDocumentTypeManager/updateAccountingDocumentProperties/accountingDocumentTypeId/id/name/accountingDocumentDate/tokensExpr/`
  const accountingDocumentTypeId = targetObjectId
  const requestParameters = { ...parameters, accountingDocumentTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeAccountingDocumentList = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountingDocumentTypeManager/removeAccountingDocumentList/accountingDocumentTypeId/accountingDocumentIds/tokensExpr/`
  const requestParameters = { ...parameters, accountingDocumentTypeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const AccountingDocumentTypeService = { view,
  load,
  addAccountingDocument,
  updateAccountingDocument,
  removeAccountingDocumentList,
  requestCandidateAccountingPeriod,
  transferToAnotherAccountingPeriod }
export default AccountingDocumentTypeService

