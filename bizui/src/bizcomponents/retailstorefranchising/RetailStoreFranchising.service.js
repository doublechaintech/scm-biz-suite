
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

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


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}retailStoreFranchisingManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 






const addRetailStore = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreFranchisingManager/addRetailStore/retailStoreFranchisingId/name/telephone/owner/retailStoreCountryCenterId/cityServiceCenterId/creationId/investmentInvitationId/decorationId/openingId/closingId/founded/latitude/longitude/description/tokensExpr/`
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



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}retailStoreFranchisingService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreFranchisingService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreFranchisingService/process/`,
    data,
  })
}

const RetailStoreFranchisingService = { view,
  load,
  addRetailStore,
  updateRetailStore,
  removeRetailStoreList, listFunctions, saveRequest, processRequest, queryCandidates}
export default RetailStoreFranchisingService

