
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreInvestmentInvitationManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreInvestmentInvitationManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}retailStoreInvestmentInvitationManager/loadRetailStoreInvestmentInvitation/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}retailStoreInvestmentInvitationManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 






const addRetailStore = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreInvestmentInvitationManager/addRetailStore/retailStoreInvestmentInvitationId/name/telephone/owner/retailStoreCountryCenterId/cityServiceCenterId/creationId/franchisingId/decorationId/openingId/closingId/founded/latitude/longitude/description/tokensExpr/`
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



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}retailStoreInvestmentInvitationService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreInvestmentInvitationService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreInvestmentInvitationService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreInvestmentInvitationService/process/`,
    data,
  })
}

const RetailStoreInvestmentInvitationService = { view,
  load,
  analyze,
  addRetailStore,
  updateRetailStore,
  removeRetailStoreList, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default RetailStoreInvestmentInvitationService

