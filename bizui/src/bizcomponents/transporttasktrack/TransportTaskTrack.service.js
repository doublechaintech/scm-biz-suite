import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


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
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}transportTaskTrackManager/transferToAnotherMovement/id/anotherMovementId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const TransportTaskTrackService = { view,
  load,
  requestCandidateMovement,
  transferToAnotherMovement }
export default TransportTaskTrackService

