import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}consumerOrderProcessingManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}consumerOrderProcessingManager/loadConsumerOrderProcessing/${targetObjectId}/${parametersExpr}/`,
  })
}






const ConsumerOrderProcessingService = { view,
  load }
export default ConsumerOrderProcessingService

