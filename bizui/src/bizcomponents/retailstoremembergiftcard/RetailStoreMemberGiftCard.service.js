
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreMemberGiftCardManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreMemberGiftCardManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}retailStoreMemberGiftCardManager/loadRetailStoreMemberGiftCard/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}retailStoreMemberGiftCardManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateOwner = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreMemberGiftCardManager/requestCandidateOwner/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherOwner = (id, parameters) => {
  const url = `${PREFIX}retailStoreMemberGiftCardManager/transferToAnotherOwner/id/anotherOwnerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addRetailStoreMemberGiftCardConsumeRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberGiftCardManager/addRetailStoreMemberGiftCardConsumeRecord/retailStoreMemberGiftCardId/occureTime/bizOrderId/number/amount/tokensExpr/`
  const retailStoreMemberGiftCardId = targetObjectId
  const requestParameters = { ...parameters, retailStoreMemberGiftCardId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStoreMemberGiftCardConsumeRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberGiftCardManager/updateRetailStoreMemberGiftCardConsumeRecordProperties/retailStoreMemberGiftCardId/id/occureTime/number/amount/tokensExpr/`
  const retailStoreMemberGiftCardId = targetObjectId
  const requestParameters = { ...parameters, retailStoreMemberGiftCardId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreMemberGiftCardConsumeRecordList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberGiftCardManager/removeRetailStoreMemberGiftCardConsumeRecordList/retailStoreMemberGiftCardId/retailStoreMemberGiftCardConsumeRecordIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreMemberGiftCardId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}retailStoreMemberGiftCardService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreMemberGiftCardService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreMemberGiftCardService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreMemberGiftCardService/process/`,
    data,
  })
}

const RetailStoreMemberGiftCardService = { view,
  load,
  analyze,
  addRetailStoreMemberGiftCardConsumeRecord,
  updateRetailStoreMemberGiftCardConsumeRecord,
  removeRetailStoreMemberGiftCardConsumeRecordList,
  requestCandidateOwner,
  transferToAnotherOwner, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default RetailStoreMemberGiftCardService

