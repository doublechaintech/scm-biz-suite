
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

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







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}consumerOrderShipmentService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}consumerOrderShipmentService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}consumerOrderShipmentService/process/`,
    data,
  })
}

const ConsumerOrderShipmentService = { view,
  load, listFunctions, saveRequest, processRequest}
export default ConsumerOrderShipmentService

