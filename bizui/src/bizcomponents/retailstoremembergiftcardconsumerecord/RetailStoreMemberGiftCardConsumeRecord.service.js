
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreMemberGiftCardConsumeRecordManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}retailStoreMemberGiftCardConsumeRecordManager/loadRetailStoreMemberGiftCardConsumeRecord/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateOwner = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreMemberGiftCardConsumeRecordManager/requestCandidateOwner/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherOwner = (id, parameters) => {
  const url = `${PREFIX}retailStoreMemberGiftCardConsumeRecordManager/transferToAnotherOwner/id/anotherOwnerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateBizOrder = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreMemberGiftCardConsumeRecordManager/requestCandidateBizOrder/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBizOrder = (id, parameters) => {
  const url = `${PREFIX}retailStoreMemberGiftCardConsumeRecordManager/transferToAnotherBizOrder/id/anotherBizOrderId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}retailStoreMemberGiftCardConsumeRecordService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreMemberGiftCardConsumeRecordService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreMemberGiftCardConsumeRecordService/process/`,
    data,
  })
}

const RetailStoreMemberGiftCardConsumeRecordService = { view,
  load,
  requestCandidateOwner,
  requestCandidateBizOrder,
  transferToAnotherOwner,
  transferToAnotherBizOrder, listFunctions, saveRequest, processRequest}
export default RetailStoreMemberGiftCardConsumeRecordService

