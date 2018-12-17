import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreCreationManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}retailStoreCreationManager/loadRetailStoreCreation/${targetObjectId}/${parametersExpr}/`,
  })
}







const addRetailStore = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCreationManager/addRetailStore/retailStoreCreationId/name/telephone/owner/retailStoreCountryCenterId/cityServiceCenterId/founded/latitude/longitude/description/tokensExpr/`
  const retailStoreCreationId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCreationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStore = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCreationManager/updateRetailStoreProperties/retailStoreCreationId/id/name/telephone/owner/founded/latitude/longitude/description/tokensExpr/`
  const retailStoreCreationId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCreationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCreationManager/removeRetailStoreList/retailStoreCreationId/retailStoreIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCreationId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const RetailStoreCreationService = { view,
  load,
  addRetailStore,
  updateRetailStore,
  removeRetailStoreList }
export default RetailStoreCreationService

