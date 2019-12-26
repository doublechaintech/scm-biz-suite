
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}consumerOrderApprovalManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}consumerOrderApprovalManager/loadConsumerOrderApproval/${targetObjectId}/${parametersExpr}/`,
  })
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}consumerOrderApprovalService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}consumerOrderApprovalService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}consumerOrderApprovalService/process/`,
    data,
  })
}

const ConsumerOrderApprovalService = { view,
  load, listFunctions, saveRequest, processRequest}
export default ConsumerOrderApprovalService

