
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

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


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}retailStoreClosingManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 






const addRetailStore = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreClosingManager/addRetailStore/retailStoreClosingId/name/telephone/owner/retailStoreCountryCenterId/cityServiceCenterId/creationId/investmentInvitationId/franchisingId/decorationId/openingId/founded/latitude/longitude/description/tokensExpr/`
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



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}retailStoreClosingService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreClosingService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreClosingService/process/`,
    data,
  })
}

const RetailStoreClosingService = { view,
  load,
  addRetailStore,
  updateRetailStore,
  removeRetailStoreList, listFunctions, saveRequest, processRequest, queryCandidates}
export default RetailStoreClosingService

