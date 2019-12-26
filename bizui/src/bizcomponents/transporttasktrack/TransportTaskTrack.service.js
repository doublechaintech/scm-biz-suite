
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}transportTaskTrackManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}transportTaskTrackManager/loadTransportTaskTrack/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateMovement = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transportTaskTrackManager/requestCandidateMovement/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherMovement = (id, parameters) => {
  const url = `${PREFIX}transportTaskTrackManager/transferToAnotherMovement/id/anotherMovementId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}transportTaskTrackService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}transportTaskTrackService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}transportTaskTrackService/process/`,
    data,
  })
}

const TransportTaskTrackService = { view,
  load,
  requestCandidateMovement,
  transferToAnotherMovement, listFunctions, saveRequest, processRequest}
export default TransportTaskTrackService

