
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

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
  const url = `${PREFIX}eventAttendanceManager/transferToAnotherCityEvent/id/anotherCityEventId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}eventAttendanceService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}eventAttendanceService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}eventAttendanceService/process/`,
    data,
  })
}

const EventAttendanceService = { view,
  load,
  requestCandidatePotentialCustomer,
  requestCandidateCityEvent,
  transferToAnotherPotentialCustomer,
  transferToAnotherCityEvent, listFunctions, saveRequest, processRequest}
export default EventAttendanceService

