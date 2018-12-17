import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}consumerOrderDeliveryManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}consumerOrderDeliveryManager/loadConsumerOrderDelivery/${targetObjectId}/${parametersExpr}/`,
  })
}






const ConsumerOrderDeliveryService = { view,
  load }
export default ConsumerOrderDeliveryService

