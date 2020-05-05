
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

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


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}accountingSubjectManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateAccountSet = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}accountingSubjectManager/requestCandidateAccountSet/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherAccountSet = (id, parameters) => {
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



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}accountingSubjectService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}accountingSubjectService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}accountingSubjectService/process/`,
    data,
  })
}

const AccountingSubjectService = { view,
  load,
  addAccountingDocumentLine,
  updateAccountingDocumentLine,
  removeAccountingDocumentLineList,
  requestCandidateAccountSet,
  transferToAnotherAccountSet, listFunctions, saveRequest, processRequest, queryCandidates}
export default AccountingSubjectService

