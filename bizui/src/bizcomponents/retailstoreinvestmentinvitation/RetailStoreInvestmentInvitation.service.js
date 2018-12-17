import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreInvestmentInvitationManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}retailStoreInvestmentInvitationManager/loadRetailStoreInvestmentInvitation/${targetObjectId}/${parametersExpr}/`,
  })
}







const addRetailStore = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreInvestmentInvitationManager/addRetailStore/retailStoreInvestmentInvitationId/name/telephone/owner/retailStoreCountryCenterId/cityServiceCenterId/founded/latitude/longitude/description/tokensExpr/`
  const retailStoreInvestmentInvitationId = targetObjectId
  const requestParameters = { ...parameters, retailStoreInvestmentInvitationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStore = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreInvestmentInvitationManager/updateRetailStoreProperties/retailStoreInvestmentInvitationId/id/name/telephone/owner/founded/latitude/longitude/description/tokensExpr/`
  const retailStoreInvestmentInvitationId = targetObjectId
  const requestParameters = { ...parameters, retailStoreInvestmentInvitationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreInvestmentInvitationManager/removeRetailStoreList/retailStoreInvestmentInvitationId/retailStoreIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreInvestmentInvitationId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const RetailStoreInvestmentInvitationService = { view,
  load,
  addRetailStore,
  updateRetailStore,
  removeRetailStoreList }
export default RetailStoreInvestmentInvitationService

