
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}accountingDocumentAuditingManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}accountingDocumentAuditingManager/loadAccountingDocumentAuditing/${targetObjectId}/${parametersExpr}/`,
  })
}







const addAccountingDocument = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountingDocumentAuditingManager/addAccountingDocument/accountingDocumentAuditingId/name/accountingDocumentDate/accountingPeriodId/documentTypeId/creationId/confirmationId/postingId/tokensExpr/`
  const accountingDocumentAuditingId = targetObjectId
  const requestParameters = { ...parameters, accountingDocumentAuditingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateAccountingDocument = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountingDocumentAuditingManager/updateAccountingDocumentProperties/accountingDocumentAuditingId/id/name/accountingDocumentDate/tokensExpr/`
  const accountingDocumentAuditingId = targetObjectId
  const requestParameters = { ...parameters, accountingDocumentAuditingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeAccountingDocumentList = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountingDocumentAuditingManager/removeAccountingDocumentList/accountingDocumentAuditingId/accountingDocumentIds/tokensExpr/`
  const requestParameters = { ...parameters, accountingDocumentAuditingId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}accountingDocumentAuditingService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}accountingDocumentAuditingService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}accountingDocumentAuditingService/process/`,
    data,
  })
}

const AccountingDocumentAuditingService = { view,
  load,
  addAccountingDocument,
  updateAccountingDocument,
  removeAccountingDocumentList, listFunctions, saveRequest, processRequest}
export default AccountingDocumentAuditingService

