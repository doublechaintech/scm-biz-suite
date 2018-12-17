import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreClosingManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}retailStoreClosingManager/loadRetailStoreClosing/${targetObjectId}/${parametersExpr}/`,
  })
}







const addRetailStore = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreClosingManager/addRetailStore/retailStoreClosingId/name/telephone/owner/retailStoreCountryCenterId/cityServiceCenterId/founded/latitude/longitude/description/tokensExpr/`
  const retailStoreClosingId = targetObjectId
  const requestParameters = { ...parameters, retailStoreClosingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStore = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreClosingManager/updateRetailStoreProperties/retailStoreClosingId/id/name/telephone/owner/founded/latitude/longitude/description/tokensExpr/`
  const retailStoreClosingId = targetObjectId
  const requestParameters = { ...parameters, retailStoreClosingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreClosingManager/removeRetailStoreList/retailStoreClosingId/retailStoreIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreClosingId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const RetailStoreClosingService = { view,
  load,
  addRetailStore,
  updateRetailStore,
  removeRetailStoreList }
export default RetailStoreClosingService

