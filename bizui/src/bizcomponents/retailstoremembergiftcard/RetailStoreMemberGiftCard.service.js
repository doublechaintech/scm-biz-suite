import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreMemberGiftCardManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}retailStoreMemberGiftCardManager/loadRetailStoreMemberGiftCard/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateOwner = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreMemberGiftCardManager/requestCandidateOwner/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherOwner = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
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


const RetailStoreMemberGiftCardService = { view,
  load,
  addRetailStoreMemberGiftCardConsumeRecord,
  updateRetailStoreMemberGiftCardConsumeRecord,
  removeRetailStoreMemberGiftCardConsumeRecordList,
  requestCandidateOwner,
  transferToAnotherOwner }
export default RetailStoreMemberGiftCardService

