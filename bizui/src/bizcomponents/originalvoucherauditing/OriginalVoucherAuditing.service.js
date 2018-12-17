import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}originalVoucherAuditingManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}originalVoucherAuditingManager/loadOriginalVoucherAuditing/${targetObjectId}/${parametersExpr}/`,
  })
}







const addOriginalVoucher = (targetObjectId, parameters) => {
  const url = `${PREFIX}originalVoucherAuditingManager/addOriginalVoucher/originalVoucherAuditingId/title/madeBy/receivedBy/voucherType/voucherImage/belongsToId/tokensExpr/`
  const originalVoucherAuditingId = targetObjectId
  const requestParameters = { ...parameters, originalVoucherAuditingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateOriginalVoucher = (targetObjectId, parameters) => {
  const url = `${PREFIX}originalVoucherAuditingManager/updateOriginalVoucherProperties/originalVoucherAuditingId/id/title/madeBy/receivedBy/voucherType/voucherImage/tokensExpr/`
  const originalVoucherAuditingId = targetObjectId
  const requestParameters = { ...parameters, originalVoucherAuditingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeOriginalVoucherList = (targetObjectId, parameters) => {
  const url = `${PREFIX}originalVoucherAuditingManager/removeOriginalVoucherList/originalVoucherAuditingId/originalVoucherIds/tokensExpr/`
  const requestParameters = { ...parameters, originalVoucherAuditingId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const OriginalVoucherAuditingService = { view,
  load,
  addOriginalVoucher,
  updateOriginalVoucher,
  removeOriginalVoucherList }
export default OriginalVoucherAuditingService

