
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}originalVoucherConfirmationManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}originalVoucherConfirmationManager/loadOriginalVoucherConfirmation/${targetObjectId}/${parametersExpr}/`,
  })
}







const addOriginalVoucher = (targetObjectId, parameters) => {
  const url = `${PREFIX}originalVoucherConfirmationManager/addOriginalVoucher/originalVoucherConfirmationId/title/madeBy/receivedBy/voucherType/voucherImage/belongsToId/creationId/auditingId/tokensExpr/`
  const originalVoucherConfirmationId = targetObjectId
  const requestParameters = { ...parameters, originalVoucherConfirmationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateOriginalVoucher = (targetObjectId, parameters) => {
  const url = `${PREFIX}originalVoucherConfirmationManager/updateOriginalVoucherProperties/originalVoucherConfirmationId/id/title/madeBy/receivedBy/voucherType/voucherImage/tokensExpr/`
  const originalVoucherConfirmationId = targetObjectId
  const requestParameters = { ...parameters, originalVoucherConfirmationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeOriginalVoucherList = (targetObjectId, parameters) => {
  const url = `${PREFIX}originalVoucherConfirmationManager/removeOriginalVoucherList/originalVoucherConfirmationId/originalVoucherIds/tokensExpr/`
  const requestParameters = { ...parameters, originalVoucherConfirmationId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}originalVoucherConfirmationService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}originalVoucherConfirmationService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}originalVoucherConfirmationService/process/`,
    data,
  })
}

const OriginalVoucherConfirmationService = { view,
  load,
  addOriginalVoucher,
  updateOriginalVoucher,
  removeOriginalVoucherList, listFunctions, saveRequest, processRequest}
export default OriginalVoucherConfirmationService

