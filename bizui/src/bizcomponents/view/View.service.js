
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}viewManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}viewManager/loadView/${targetObjectId}/${parametersExpr}/`,
  })
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}viewService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}viewService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}viewService/process/`,
    data,
  })
}

const ViewService = { view,
  load, listFunctions, saveRequest, processRequest}
export default ViewService

