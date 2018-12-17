import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}accountingDocumentPostingManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}accountingDocumentPostingManager/loadAccountingDocumentPosting/${targetObjectId}/${parametersExpr}/`,
  })
}







const addAccountingDocument = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountingDocumentPostingManager/addAccountingDocument/accountingDocumentPostingId/name/accountingDocumentDate/accountingPeriodId/documentTypeId/tokensExpr/`
  const accountingDocumentPostingId = targetObjectId
  const requestParameters = { ...parameters, accountingDocumentPostingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateAccountingDocument = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountingDocumentPostingManager/updateAccountingDocumentProperties/accountingDocumentPostingId/id/name/accountingDocumentDate/tokensExpr/`
  const accountingDocumentPostingId = targetObjectId
  const requestParameters = { ...parameters, accountingDocumentPostingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeAccountingDocumentList = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountingDocumentPostingManager/removeAccountingDocumentList/accountingDocumentPostingId/accountingDocumentIds/tokensExpr/`
  const requestParameters = { ...parameters, accountingDocumentPostingId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const AccountingDocumentPostingService = { view,
  load,
  addAccountingDocument,
  updateAccountingDocument,
  removeAccountingDocumentList }
export default AccountingDocumentPostingService

