
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}accountingPeriodManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}accountingPeriodManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}accountingPeriodManager/loadAccountingPeriod/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}accountingPeriodManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateAccountSet = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}accountingPeriodManager/requestCandidateAccountSet/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherAccountSet = (id, parameters) => {
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



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}accountingPeriodService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}accountingPeriodService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}accountingPeriodService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}accountingPeriodService/process/`,
    data,
  })
}

const AccountingPeriodService = { view,
  load,
  analyze,
  addAccountingDocument,
  updateAccountingDocument,
  removeAccountingDocumentList,
  requestCandidateAccountSet,
  transferToAnotherAccountSet, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default AccountingPeriodService

