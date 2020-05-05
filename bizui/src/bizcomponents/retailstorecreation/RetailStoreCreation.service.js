
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

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


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}retailStoreCreationManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 






const addRetailStore = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCreationManager/addRetailStore/retailStoreCreationId/name/telephone/owner/retailStoreCountryCenterId/cityServiceCenterId/investmentInvitationId/franchisingId/decorationId/openingId/closingId/founded/latitude/longitude/description/tokensExpr/`
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



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}retailStoreCreationService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreCreationService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreCreationService/process/`,
    data,
  })
}

const RetailStoreCreationService = { view,
  load,
  addRetailStore,
  updateRetailStore,
  removeRetailStoreList, listFunctions, saveRequest, processRequest, queryCandidates}
export default RetailStoreCreationService

