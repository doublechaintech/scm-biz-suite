import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreFranchisingManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}retailStoreFranchisingManager/loadRetailStoreFranchising/${targetObjectId}/${parametersExpr}/`,
  })
}







const addRetailStore = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreFranchisingManager/addRetailStore/retailStoreFranchisingId/name/telephone/owner/retailStoreCountryCenterId/cityServiceCenterId/founded/latitude/longitude/description/tokensExpr/`
  const retailStoreFranchisingId = targetObjectId
  const requestParameters = { ...parameters, retailStoreFranchisingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStore = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreFranchisingManager/updateRetailStoreProperties/retailStoreFranchisingId/id/name/telephone/owner/founded/latitude/longitude/description/tokensExpr/`
  const retailStoreFranchisingId = targetObjectId
  const requestParameters = { ...parameters, retailStoreFranchisingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreFranchisingManager/removeRetailStoreList/retailStoreFranchisingId/retailStoreIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreFranchisingId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const RetailStoreFranchisingService = { view,
  load,
  addRetailStore,
  updateRetailStore,
  removeRetailStoreList }
export default RetailStoreFranchisingService

