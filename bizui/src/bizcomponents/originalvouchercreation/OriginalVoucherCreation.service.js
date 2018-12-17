import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}originalVoucherCreationManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}originalVoucherCreationManager/loadOriginalVoucherCreation/${targetObjectId}/${parametersExpr}/`,
  })
}







const addOriginalVoucher = (targetObjectId, parameters) => {
  const url = `${PREFIX}originalVoucherCreationManager/addOriginalVoucher/originalVoucherCreationId/title/madeBy/receivedBy/voucherType/voucherImage/belongsToId/tokensExpr/`
  const originalVoucherCreationId = targetObjectId
  const requestParameters = { ...parameters, originalVoucherCreationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateOriginalVoucher = (targetObjectId, parameters) => {
  const url = `${PREFIX}originalVoucherCreationManager/updateOriginalVoucherProperties/originalVoucherCreationId/id/title/madeBy/receivedBy/voucherType/voucherImage/tokensExpr/`
  const originalVoucherCreationId = targetObjectId
  const requestParameters = { ...parameters, originalVoucherCreationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeOriginalVoucherList = (targetObjectId, parameters) => {
  const url = `${PREFIX}originalVoucherCreationManager/removeOriginalVoucherList/originalVoucherCreationId/originalVoucherIds/tokensExpr/`
  const requestParameters = { ...parameters, originalVoucherCreationId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const OriginalVoucherCreationService = { view,
  load,
  addOriginalVoucher,
  updateOriginalVoucher,
  removeOriginalVoucherList }
export default OriginalVoucherCreationService

