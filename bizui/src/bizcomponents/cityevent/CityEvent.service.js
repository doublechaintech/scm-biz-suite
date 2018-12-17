import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}cityEventManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}cityEventManager/loadCityEvent/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateCityServiceCenter = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}cityEventManager/requestCandidateCityServiceCenter/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCityServiceCenter = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}cityEventManager/transferToAnotherCityServiceCenter/id/anotherCityServiceCenterId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addEventAttendance = (targetObjectId, parameters) => {
  const url = `${PREFIX}cityEventManager/addEventAttendance/cityEventId/name/potentialCustomerId/description/tokensExpr/`
  const cityEventId = targetObjectId
  const requestParameters = { ...parameters, cityEventId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEventAttendance = (targetObjectId, parameters) => {
  const url = `${PREFIX}cityEventManager/updateEventAttendanceProperties/cityEventId/id/name/description/tokensExpr/`
  const cityEventId = targetObjectId
  const requestParameters = { ...parameters, cityEventId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEventAttendanceList = (targetObjectId, parameters) => {
  const url = `${PREFIX}cityEventManager/removeEventAttendanceList/cityEventId/eventAttendanceIds/tokensExpr/`
  const requestParameters = { ...parameters, cityEventId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const CityEventService = { view,
  load,
  addEventAttendance,
  updateEventAttendance,
  removeEventAttendanceList,
  requestCandidateCityServiceCenter,
  transferToAnotherCityServiceCenter }
export default CityEventService

