import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}eventAttendanceManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}eventAttendanceManager/loadEventAttendance/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePotentialCustomer = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}eventAttendanceManager/requestCandidatePotentialCustomer/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPotentialCustomer = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}eventAttendanceManager/transferToAnotherPotentialCustomer/id/anotherPotentialCustomerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateCityEvent = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}eventAttendanceManager/requestCandidateCityEvent/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCityEvent = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}eventAttendanceManager/transferToAnotherCityEvent/id/anotherCityEventId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const EventAttendanceService = { view,
  load,
  requestCandidatePotentialCustomer,
  requestCandidateCityEvent,
  transferToAnotherPotentialCustomer,
  transferToAnotherCityEvent }
export default EventAttendanceService

