
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

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


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}cityEventManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateCityServiceCenter = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}cityEventManager/requestCandidateCityServiceCenter/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCityServiceCenter = (id, parameters) => {
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



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}cityEventService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}cityEventService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}cityEventService/process/`,
    data,
  })
}

const CityEventService = { view,
  load,
  addEventAttendance,
  updateEventAttendance,
  removeEventAttendanceList,
  requestCandidateCityServiceCenter,
  transferToAnotherCityServiceCenter, listFunctions, saveRequest, processRequest, queryCandidates}
export default CityEventService

