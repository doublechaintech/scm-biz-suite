
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}accountSetManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}accountSetManager/loadAccountSet/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateCountryCenter = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}accountSetManager/requestCandidateCountryCenter/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCountryCenter = (id, parameters) => {
  const url = `${PREFIX}accountSetManager/transferToAnotherCountryCenter/id/anotherCountryCenterId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateRetailStore = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}accountSetManager/requestCandidateRetailStore/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherRetailStore = (id, parameters) => {
  const url = `${PREFIX}accountSetManager/transferToAnotherRetailStore/id/anotherRetailStoreId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateGoodsSupplier = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}accountSetManager/requestCandidateGoodsSupplier/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherGoodsSupplier = (id, parameters) => {
  const url = `${PREFIX}accountSetManager/transferToAnotherGoodsSupplier/id/anotherGoodsSupplierId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addAccountingSubject = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountSetManager/addAccountingSubject/accountSetId/accountingSubjectCode/accountingSubjectName/accountingSubjectClassCode/accountingSubjectClassName/tokensExpr/`
  const accountSetId = targetObjectId
  const requestParameters = { ...parameters, accountSetId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateAccountingSubject = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountSetManager/updateAccountingSubjectProperties/accountSetId/id/accountingSubjectCode/accountingSubjectName/accountingSubjectClassCode/accountingSubjectClassName/tokensExpr/`
  const accountSetId = targetObjectId
  const requestParameters = { ...parameters, accountSetId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeAccountingSubjectList = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountSetManager/removeAccountingSubjectList/accountSetId/accountingSubjectIds/tokensExpr/`
  const requestParameters = { ...parameters, accountSetId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addAccountingPeriod = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountSetManager/addAccountingPeriod/accountSetId/name/startDate/endDate/tokensExpr/`
  const accountSetId = targetObjectId
  const requestParameters = { ...parameters, accountSetId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateAccountingPeriod = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountSetManager/updateAccountingPeriodProperties/accountSetId/id/name/startDate/endDate/tokensExpr/`
  const accountSetId = targetObjectId
  const requestParameters = { ...parameters, accountSetId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeAccountingPeriodList = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountSetManager/removeAccountingPeriodList/accountSetId/accountingPeriodIds/tokensExpr/`
  const requestParameters = { ...parameters, accountSetId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addAccountingDocumentType = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountSetManager/addAccountingDocumentType/accountSetId/name/description/tokensExpr/`
  const accountSetId = targetObjectId
  const requestParameters = { ...parameters, accountSetId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateAccountingDocumentType = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountSetManager/updateAccountingDocumentTypeProperties/accountSetId/id/name/description/tokensExpr/`
  const accountSetId = targetObjectId
  const requestParameters = { ...parameters, accountSetId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeAccountingDocumentTypeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}accountSetManager/removeAccountingDocumentTypeList/accountSetId/accountingDocumentTypeIds/tokensExpr/`
  const requestParameters = { ...parameters, accountSetId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}accountSetService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}accountSetService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}accountSetService/process/`,
    data,
  })
}

const AccountSetService = { view,
  load,
  addAccountingSubject,
  addAccountingPeriod,
  addAccountingDocumentType,
  updateAccountingSubject,
  updateAccountingPeriod,
  updateAccountingDocumentType,
  removeAccountingSubjectList,
  removeAccountingPeriodList,
  removeAccountingDocumentTypeList,
  requestCandidateCountryCenter,
  requestCandidateRetailStore,
  requestCandidateGoodsSupplier,
  transferToAnotherCountryCenter,
  transferToAnotherRetailStore,
  transferToAnotherGoodsSupplier, listFunctions, saveRequest, processRequest}
export default AccountSetService

