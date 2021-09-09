
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}accountingDocumentTypeManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}accountingDocumentTypeManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}accountingDocumentTypeManager/loadAccountingDocumentType/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}accountingDocumentTypeManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateAccountingPeriod = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}accountingDocumentTypeManager/requestCandidateAccountingPeriod/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherAccountingPeriod = (id, parameters) => {
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



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}accountingDocumentTypeService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}accountingDocumentTypeService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}accountingDocumentTypeService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}accountingDocumentTypeService/process/`,
    data,
  })
}

const AccountingDocumentTypeService = { view,
  load,
  analyze,
  addAccountingDocument,
  updateAccountingDocument,
  removeAccountingDocumentList,
  requestCandidateAccountingPeriod,
  transferToAnotherAccountingPeriod, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default AccountingDocumentTypeService

