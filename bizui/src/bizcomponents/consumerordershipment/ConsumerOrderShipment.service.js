import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}consumerOrderShipmentManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}consumerOrderShipmentManager/loadConsumerOrderShipment/${targetObjectId}/${parametersExpr}/`,
  })
}






const ConsumerOrderShipmentService = { view,
  load }
export default ConsumerOrderShipmentService

