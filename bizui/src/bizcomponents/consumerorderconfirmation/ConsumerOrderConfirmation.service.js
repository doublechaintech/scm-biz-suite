import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}consumerOrderConfirmationManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}consumerOrderConfirmationManager/loadConsumerOrderConfirmation/${targetObjectId}/${parametersExpr}/`,
  })
}






const ConsumerOrderConfirmationService = { view,
  load }
export default ConsumerOrderConfirmationService

