import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


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
  const url = `${PREFIX}originalVoucherConfirmationManager/addOriginalVoucher/originalVoucherConfirmationId/title/madeBy/receivedBy/voucherType/voucherImage/belongsToId/tokensExpr/`
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


const OriginalVoucherConfirmationService = { view,
  load,
  addOriginalVoucher,
  updateOriginalVoucher,
  removeOriginalVoucherList }
export default OriginalVoucherConfirmationService

