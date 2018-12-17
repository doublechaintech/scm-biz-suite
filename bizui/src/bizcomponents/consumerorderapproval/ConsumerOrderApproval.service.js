import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


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






const ConsumerOrderApprovalService = { view,
  load }
export default ConsumerOrderApprovalService

