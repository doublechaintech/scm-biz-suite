import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}transportFleetManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}transportFleetManager/loadTransportFleet/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateOwner = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}transportFleetManager/requestCandidateOwner/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherOwner = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}transportFleetManager/transferToAnotherOwner/id/anotherOwnerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addTransportTruck = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportFleetManager/addTransportTruck/transportFleetId/name/plateNumber/contactNumber/vehicleLicenseNumber/engineNumber/makeDate/mileage/bodyColor/tokensExpr/`
  const transportFleetId = targetObjectId
  const requestParameters = { ...parameters, transportFleetId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransportTruck = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportFleetManager/updateTransportTruckProperties/transportFleetId/id/name/plateNumber/contactNumber/vehicleLicenseNumber/engineNumber/makeDate/mileage/bodyColor/tokensExpr/`
  const transportFleetId = targetObjectId
  const requestParameters = { ...parameters, transportFleetId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransportTruckList = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportFleetManager/removeTransportTruckList/transportFleetId/transportTruckIds/tokensExpr/`
  const requestParameters = { ...parameters, transportFleetId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTruckDriver = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportFleetManager/addTruckDriver/transportFleetId/name/driverLicenseNumber/contactNumber/tokensExpr/`
  const transportFleetId = targetObjectId
  const requestParameters = { ...parameters, transportFleetId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTruckDriver = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportFleetManager/updateTruckDriverProperties/transportFleetId/id/name/driverLicenseNumber/contactNumber/tokensExpr/`
  const transportFleetId = targetObjectId
  const requestParameters = { ...parameters, transportFleetId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTruckDriverList = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportFleetManager/removeTruckDriverList/transportFleetId/truckDriverIds/tokensExpr/`
  const requestParameters = { ...parameters, transportFleetId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTransportTask = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportFleetManager/addTransportTask/transportFleetId/name/start/beginTime/endId/driverId/truckId/latitude/longitude/tokensExpr/`
  const transportFleetId = targetObjectId
  const requestParameters = { ...parameters, transportFleetId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransportTask = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportFleetManager/updateTransportTaskProperties/transportFleetId/id/name/start/beginTime/latitude/longitude/tokensExpr/`
  const transportFleetId = targetObjectId
  const requestParameters = { ...parameters, transportFleetId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransportTaskList = (targetObjectId, parameters) => {
  const url = `${PREFIX}transportFleetManager/removeTransportTaskList/transportFleetId/transportTaskIds/tokensExpr/`
  const requestParameters = { ...parameters, transportFleetId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const TransportFleetService = { view,
  load,
  addTransportTruck,
  addTruckDriver,
  addTransportTask,
  updateTransportTruck,
  updateTruckDriver,
  updateTransportTask,
  removeTransportTruckList,
  removeTruckDriverList,
  removeTransportTaskList,
  requestCandidateOwner,
  transferToAnotherOwner }
export default TransportFleetService

