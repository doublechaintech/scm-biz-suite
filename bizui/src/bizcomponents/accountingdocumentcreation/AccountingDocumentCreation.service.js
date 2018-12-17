import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}accountingDocumentCreationManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}accountingDocumentCreationManager/loadAccountingDocumentCreation/${targetObjectId}/${parametersExpr}/`,
  })
}







const addAccountingDocument = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountingDocumentCreationManager/addAccountingDocument/accountingDocumentCreationId/name/accountingDocumentDate/accountingPeriodId/documentTypeId/tokensExpr/`
  const accountingDocumentCreationId = targetObjectId
  const requestParameters = { ...parameters, accountingDocumentCreationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateAccountingDocument = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountingDocumentCreationManager/updateAccountingDocumentProperties/accountingDocumentCreationId/id/name/accountingDocumentDate/tokensExpr/`
  const accountingDocumentCreationId = targetObjectId
  const requestParameters = { ...parameters, accountingDocumentCreationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeAccountingDocumentList = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountingDocumentCreationManager/removeAccountingDocumentList/accountingDocumentCreationId/accountingDocumentIds/tokensExpr/`
  const requestParameters = { ...parameters, accountingDocumentCreationId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const AccountingDocumentCreationService = { view,
  load,
  addAccountingDocument,
  updateAccountingDocument,
  removeAccountingDocumentList }
export default AccountingDocumentCreationService

