
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreOpeningManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreOpeningManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}retailStoreOpeningManager/loadRetailStoreOpening/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}retailStoreOpeningManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 






const addRetailStore = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOpeningManager/addRetailStore/retailStoreOpeningId/name/telephone/owner/retailStoreCountryCenterId/cityServiceCenterId/creationId/investmentInvitationId/franchisingId/decorationId/closingId/founded/latitude/longitude/description/tokensExpr/`
  const retailStoreOpeningId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOpeningId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStore = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOpeningManager/updateRetailStoreProperties/retailStoreOpeningId/id/name/telephone/owner/founded/latitude/longitude/description/tokensExpr/`
  const retailStoreOpeningId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOpeningId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOpeningManager/removeRetailStoreList/retailStoreOpeningId/retailStoreIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreOpeningId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}retailStoreOpeningService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreOpeningService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreOpeningService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreOpeningService/process/`,
    data,
  })
}

const RetailStoreOpeningService = { view,
  load,
  analyze,
  addRetailStore,
  updateRetailStore,
  removeRetailStoreList, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default RetailStoreOpeningService

