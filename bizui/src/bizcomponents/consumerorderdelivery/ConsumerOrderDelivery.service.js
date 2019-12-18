
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

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







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}consumerOrderDeliveryService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}consumerOrderDeliveryService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}consumerOrderDeliveryService/process/`,
    data,
  })
}

const ConsumerOrderDeliveryService = { view,
  load, listFunctions, saveRequest, processRequest}
export default ConsumerOrderDeliveryService

