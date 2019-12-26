
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreDecorationManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}retailStoreDecorationManager/loadRetailStoreDecoration/${targetObjectId}/${parametersExpr}/`,
  })
}







const addRetailStore = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreDecorationManager/addRetailStore/retailStoreDecorationId/name/telephone/owner/retailStoreCountryCenterId/cityServiceCenterId/creationId/investmentInvitationId/franchisingId/openingId/closingId/founded/latitude/longitude/description/tokensExpr/`
  const retailStoreDecorationId = targetObjectId
  const requestParameters = { ...parameters, retailStoreDecorationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStore = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreDecorationManager/updateRetailStoreProperties/retailStoreDecorationId/id/name/telephone/owner/founded/latitude/longitude/description/tokensExpr/`
  const retailStoreDecorationId = targetObjectId
  const requestParameters = { ...parameters, retailStoreDecorationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreDecorationManager/removeRetailStoreList/retailStoreDecorationId/retailStoreIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreDecorationId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}retailStoreDecorationService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreDecorationService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreDecorationService/process/`,
    data,
  })
}

const RetailStoreDecorationService = { view,
  load,
  addRetailStore,
  updateRetailStore,
  removeRetailStoreList, listFunctions, saveRequest, processRequest}
export default RetailStoreDecorationService

