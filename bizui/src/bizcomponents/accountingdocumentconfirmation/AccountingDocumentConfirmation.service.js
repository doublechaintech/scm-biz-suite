import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}accountingDocumentConfirmationManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}accountingDocumentConfirmationManager/loadAccountingDocumentConfirmation/${targetObjectId}/${parametersExpr}/`,
  })
}







const addAccountingDocument = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountingDocumentConfirmationManager/addAccountingDocument/accountingDocumentConfirmationId/name/accountingDocumentDate/accountingPeriodId/documentTypeId/tokensExpr/`
  const accountingDocumentConfirmationId = targetObjectId
  const requestParameters = { ...parameters, accountingDocumentConfirmationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateAccountingDocument = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountingDocumentConfirmationManager/updateAccountingDocumentProperties/accountingDocumentConfirmationId/id/name/accountingDocumentDate/tokensExpr/`
  const accountingDocumentConfirmationId = targetObjectId
  const requestParameters = { ...parameters, accountingDocumentConfirmationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeAccountingDocumentList = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountingDocumentConfirmationManager/removeAccountingDocumentList/accountingDocumentConfirmationId/accountingDocumentIds/tokensExpr/`
  const requestParameters = { ...parameters, accountingDocumentConfirmationId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const AccountingDocumentConfirmationService = { view,
  load,
  addAccountingDocument,
  updateAccountingDocument,
  removeAccountingDocumentList }
export default AccountingDocumentConfirmationService

