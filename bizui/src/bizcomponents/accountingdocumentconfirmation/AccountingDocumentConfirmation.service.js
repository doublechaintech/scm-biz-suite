
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

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
  const url = `${PREFIX}accountingDocumentConfirmationManager/addAccountingDocument/accountingDocumentConfirmationId/name/accountingDocumentDate/accountingPeriodId/documentTypeId/creationId/auditingId/postingId/tokensExpr/`
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



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}accountingDocumentConfirmationService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}accountingDocumentConfirmationService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}accountingDocumentConfirmationService/process/`,
    data,
  })
}

const AccountingDocumentConfirmationService = { view,
  load,
  addAccountingDocument,
  updateAccountingDocument,
  removeAccountingDocumentList, listFunctions, saveRequest, processRequest}
export default AccountingDocumentConfirmationService

