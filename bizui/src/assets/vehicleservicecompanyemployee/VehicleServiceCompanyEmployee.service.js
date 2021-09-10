import { get, post } from '../../axios/tools'

const getURLPrefix = () => {
  const url = new URL(window.location)
  if (url.hostname === 'localhost') {
    return `http://${url.hostname}:8080/naf/`
  }
  if (url.hostname === '30.30.126.37') {
    return `http://${url.hostname}:8080/naf/`
  }
  return `${url.origin}/cis/`
}

const PREFIX = getURLPrefix()

const view = targetObjectId => {
  return get({
    url: `${PREFIX}vehicleServiceCompanyEmployeeManager/view/${targetObjectId}/`,
  })
}

const joinParameters = parameters => {
  const obj = parameters // {value1: 'prop1', value2: 'prop2', value3: 'prop3'}
  const arr = []
  for (const key in obj) {
    if (obj.hasOwnProperty(key)) {
      arr.push(`${key}=${encodeURIComponent(obj[key])}`)
    }
  }
  const result = arr.join(';')
  return result
}

const joinPostParameters = parameters => {
  const obj = parameters // {value1: 'prop1', value2: 'prop2', value3: 'prop3'}
  const arr = []
  for (const key in obj) {
    if (obj.hasOwnProperty(key)) {
      const value = obj[key]
      if (!Array.isArray(value)) {
        arr.push(key + '=' + encodeURIComponent(value))
      }
      for (const subKey in value) {
        const subvalue = value[subKey]
        arr.push(key + '=' + encodeURIComponent(subvalue))
      }
    }
  }
  const result = arr.join('&')
  return result
}

const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}vehicleServiceCompanyEmployeeManager/loadVehicleServiceCompanyEmployee/${targetObjectId}/${parametersExpr}/`,
  })
}

const addEmployeeDrivingLicense = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/addEmployeeDrivingLicense/employeeId/holderName/licenseType/licenseNumber/expirationDate/image1/image2/image3/image4/image5/tokensExpr/`
  const requestParameters = { ...parameters, tokensExpr: 'none' }

  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const updateEmployeeDrivingLicense = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/updateEmployeeDrivingLicenseProperties/vehicleServiceCompanyEmployeeId/id/holderName/licenseType/licenseNumber/expirationDate/image1/image2/image3/image4/image5/tokensExpr/`
  const vehicleServiceCompanyEmployeeId = targetObjectId
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const removeEmployeeDrivingLicenseList = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/removeEmployeeDrivingLicenseList/vehicleServiceCompanyEmployeeId/employeeDrivingLicenseIds/tokensExpr/`
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId: targetObjectId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const addCompanyEmployeeMessage = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/addCompanyEmployeeMessage/receiverId/senderId/title/messageContent/serviceTypeId/serviceTicket/sendTime/readTime/status/tokensExpr/`
  const requestParameters = { ...parameters, tokensExpr: 'none' }

  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const updateCompanyEmployeeMessage = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/updateCompanyEmployeeMessageProperties/vehicleServiceCompanyEmployeeId/id/title/messageContent/serviceTicket/sendTime/readTime/status/tokensExpr/`
  const vehicleServiceCompanyEmployeeId = targetObjectId
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const removeCompanyEmployeeMessageList = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/removeCompanyEmployeeMessageList/vehicleServiceCompanyEmployeeId/companyEmployeeMessageIds/tokensExpr/`
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId: targetObjectId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const addVehicleInspectionOrderServiceLog = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/addVehicleInspectionOrderServiceLog/responsibleWorkerId/summary/location/serviceTypeId/serviceTicket/mainOrderId/tokensExpr/`
  const requestParameters = { ...parameters, tokensExpr: 'none' }

  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const updateVehicleInspectionOrderServiceLog = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/updateVehicleInspectionOrderServiceLogProperties/vehicleServiceCompanyEmployeeId/id/summary/location/serviceTicket/tokensExpr/`
  const vehicleServiceCompanyEmployeeId = targetObjectId
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const removeVehicleInspectionOrderServiceLogList = (
  targetObjectId,
  parameters
) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/removeVehicleInspectionOrderServiceLogList/vehicleServiceCompanyEmployeeId/vehicleInspectionOrderServiceLogIds/tokensExpr/`
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId: targetObjectId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const addServiceVehicleMovementC2m = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/addServiceVehicleMovementC2m/responsibleWorkerId/serviceStatus/rejectComments/rejectEvidence1/rejectEvidence2/rejectEvidence3/rejectEvidence4/rejectEvidence5/startTime/lastLocation/mainOrderId/movementPurpose/contactName/contactMobileNumber/merchantId/tokensExpr/`
  const requestParameters = { ...parameters, tokensExpr: 'none' }

  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const updateServiceVehicleMovementC2m = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/updateServiceVehicleMovementC2mProperties/vehicleServiceCompanyEmployeeId/id/serviceStatus/rejectComments/rejectEvidence1/rejectEvidence2/rejectEvidence3/rejectEvidence4/rejectEvidence5/startTime/lastLocation/movementPurpose/contactName/contactMobileNumber/tokensExpr/`
  const vehicleServiceCompanyEmployeeId = targetObjectId
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const removeServiceVehicleMovementC2mList = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/removeServiceVehicleMovementC2mList/vehicleServiceCompanyEmployeeId/serviceVehicleMovementC2mIds/tokensExpr/`
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId: targetObjectId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const addServiceVehicleMovementM2m = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/addServiceVehicleMovementM2m/receiverId/driverId/responsibleWorkerId/serviceStatus/rejectComments/rejectEvidence1/rejectEvidence2/rejectEvidence3/rejectEvidence4/rejectEvidence5/startTime/lastLocation/mainOrderId/movementPurpose/tokensExpr/`
  const requestParameters = { ...parameters, tokensExpr: 'none' }

  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const updateServiceVehicleMovementM2m = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/updateServiceVehicleMovementM2mProperties/vehicleServiceCompanyEmployeeId/id/serviceStatus/rejectComments/rejectEvidence1/rejectEvidence2/rejectEvidence3/rejectEvidence4/rejectEvidence5/startTime/lastLocation/movementPurpose/tokensExpr/`
  const vehicleServiceCompanyEmployeeId = targetObjectId
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const removeServiceVehicleMovementM2mList = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/removeServiceVehicleMovementM2mList/vehicleServiceCompanyEmployeeId/serviceVehicleMovementM2mIds/tokensExpr/`
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId: targetObjectId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const addServiceVehicleMovementM2c = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/addServiceVehicleMovementM2c/responsibleWorkerId/serviceStatus/rejectComments/rejectEvidence1/rejectEvidence2/rejectEvidence3/rejectEvidence4/rejectEvidence5/startTime/lastLocation/mainOrderId/movementPurpose/contactName/contactMobileNumber/merchantId/tokensExpr/`
  const requestParameters = { ...parameters, tokensExpr: 'none' }

  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const updateServiceVehicleMovementM2c = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/updateServiceVehicleMovementM2cProperties/vehicleServiceCompanyEmployeeId/id/serviceStatus/rejectComments/rejectEvidence1/rejectEvidence2/rejectEvidence3/rejectEvidence4/rejectEvidence5/startTime/lastLocation/movementPurpose/contactName/contactMobileNumber/tokensExpr/`
  const vehicleServiceCompanyEmployeeId = targetObjectId
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const removeServiceVehicleMovementM2cList = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/removeServiceVehicleMovementM2cList/vehicleServiceCompanyEmployeeId/serviceVehicleMovementM2cIds/tokensExpr/`
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId: targetObjectId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const addServiceFileMovementC2m = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/addServiceFileMovementC2m/responsibleWorkerId/serviceStatus/rejectComments/rejectEvidence1/rejectEvidence2/rejectEvidence3/rejectEvidence4/rejectEvidence5/startTime/lastLocation/mainOrderId/movementPurpose/contactName/contactMobileNumber/merchantId/tokensExpr/`
  const requestParameters = { ...parameters, tokensExpr: 'none' }

  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const updateServiceFileMovementC2m = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/updateServiceFileMovementC2mProperties/vehicleServiceCompanyEmployeeId/id/serviceStatus/rejectComments/rejectEvidence1/rejectEvidence2/rejectEvidence3/rejectEvidence4/rejectEvidence5/startTime/lastLocation/movementPurpose/contactName/contactMobileNumber/tokensExpr/`
  const vehicleServiceCompanyEmployeeId = targetObjectId
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const removeServiceFileMovementC2mList = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/removeServiceFileMovementC2mList/vehicleServiceCompanyEmployeeId/serviceFileMovementC2mIds/tokensExpr/`
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId: targetObjectId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const addServiceFileMovementM2m = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/addServiceFileMovementM2m/receiverId/senderId/responsibleWorkerId/serviceStatus/rejectComments/rejectEvidence1/rejectEvidence2/rejectEvidence3/rejectEvidence4/rejectEvidence5/startTime/lastLocation/mainOrderId/movementPurpose/tokensExpr/`
  const requestParameters = { ...parameters, tokensExpr: 'none' }

  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const updateServiceFileMovementM2m = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/updateServiceFileMovementM2mProperties/vehicleServiceCompanyEmployeeId/id/serviceStatus/rejectComments/rejectEvidence1/rejectEvidence2/rejectEvidence3/rejectEvidence4/rejectEvidence5/startTime/lastLocation/movementPurpose/tokensExpr/`
  const vehicleServiceCompanyEmployeeId = targetObjectId
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const removeServiceFileMovementM2mList = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/removeServiceFileMovementM2mList/vehicleServiceCompanyEmployeeId/serviceFileMovementM2mIds/tokensExpr/`
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId: targetObjectId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const addServiceFileMovementM2c = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/addServiceFileMovementM2c/responsibleWorkerId/serviceStatus/rejectComments/rejectEvidence1/rejectEvidence2/rejectEvidence3/rejectEvidence4/rejectEvidence5/startTime/lastLocation/mainOrderId/movementPurpose/contactName/contactMobileNumber/merchantId/tokensExpr/`
  const requestParameters = { ...parameters, tokensExpr: 'none' }

  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const updateServiceFileMovementM2c = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/updateServiceFileMovementM2cProperties/vehicleServiceCompanyEmployeeId/id/serviceStatus/rejectComments/rejectEvidence1/rejectEvidence2/rejectEvidence3/rejectEvidence4/rejectEvidence5/startTime/lastLocation/movementPurpose/contactName/contactMobileNumber/tokensExpr/`
  const vehicleServiceCompanyEmployeeId = targetObjectId
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const removeServiceFileMovementM2cList = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/removeServiceFileMovementM2cList/vehicleServiceCompanyEmployeeId/serviceFileMovementM2cIds/tokensExpr/`
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId: targetObjectId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const addServiceInsuranceForInspection = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/addServiceInsuranceForInspection/responsibleWorkerId/serviceStatus/orderedInsuranceId/serviceComments/startTime/insuranceNumber/insuranceImage1/insuranceImage2/insuranceImage3/insuranceImage4/insuranceImage5/mainOrderId/tokensExpr/`
  const requestParameters = { ...parameters, tokensExpr: 'none' }

  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const updateServiceInsuranceForInspection = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/updateServiceInsuranceForInspectionProperties/vehicleServiceCompanyEmployeeId/id/serviceStatus/serviceComments/startTime/insuranceNumber/insuranceImage1/insuranceImage2/insuranceImage3/insuranceImage4/insuranceImage5/tokensExpr/`
  const vehicleServiceCompanyEmployeeId = targetObjectId
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const removeServiceInsuranceForInspectionList = (
  targetObjectId,
  parameters
) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/removeServiceInsuranceForInspectionList/vehicleServiceCompanyEmployeeId/serviceInsuranceForInspectionIds/tokensExpr/`
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId: targetObjectId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const addServiceVehicleInspection = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/addServiceVehicleInspection/responsibleWorkerId/serviceStatus/inspectionStationId/inspectionResult/startTime/lastLocation/reportImage1/reportImage2/reportImage3/reportImage4/reportImage5/mainOrderId/tokensExpr/`
  const requestParameters = { ...parameters, tokensExpr: 'none' }

  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const updateServiceVehicleInspection = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/updateServiceVehicleInspectionProperties/vehicleServiceCompanyEmployeeId/id/serviceStatus/inspectionResult/startTime/lastLocation/reportImage1/reportImage2/reportImage3/reportImage4/reportImage5/tokensExpr/`
  const vehicleServiceCompanyEmployeeId = targetObjectId
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const removeServiceVehicleInspectionList = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/removeServiceVehicleInspectionList/vehicleServiceCompanyEmployeeId/serviceVehicleInspectionIds/tokensExpr/`
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId: targetObjectId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const addServiceFileInspection = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/addServiceFileInspection/responsibleWorkerId/serviceStatus/inspectionStationId/inspectionResult/startTime/lastLocation/reportImage1/reportImage2/reportImage3/reportImage4/reportImage5/mainOrderId/tokensExpr/`
  const requestParameters = { ...parameters, tokensExpr: 'none' }

  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const updateServiceFileInspection = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/updateServiceFileInspectionProperties/vehicleServiceCompanyEmployeeId/id/serviceStatus/inspectionResult/startTime/lastLocation/reportImage1/reportImage2/reportImage3/reportImage4/reportImage5/tokensExpr/`
  const vehicleServiceCompanyEmployeeId = targetObjectId
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const removeServiceFileInspectionList = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/removeServiceFileInspectionList/vehicleServiceCompanyEmployeeId/serviceFileInspectionIds/tokensExpr/`
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId: targetObjectId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const addServiceVehicleRepairing = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/addServiceVehicleRepairing/responsibleWorkerId/serviceStatus/rejectComments/startTime/lastLocation/mainOrderId/tokensExpr/`
  const requestParameters = { ...parameters, tokensExpr: 'none' }

  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const updateServiceVehicleRepairing = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/updateServiceVehicleRepairingProperties/vehicleServiceCompanyEmployeeId/id/serviceStatus/rejectComments/startTime/lastLocation/tokensExpr/`
  const vehicleServiceCompanyEmployeeId = targetObjectId
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const removeServiceVehicleRepairingList = (targetObjectId, parameters) => {
  const url = `${PREFIX}vehicleServiceCompanyEmployeeManager/removeServiceVehicleRepairingList/vehicleServiceCompanyEmployeeId/serviceVehicleRepairingIds/tokensExpr/`
  const requestParameters = {
    ...parameters,
    vehicleServiceCompanyEmployeeId: targetObjectId,
    tokensExpr: 'none',
  }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}

const VehicleServiceCompanyEmployeeService = {
  view,
  load,
  addEmployeeDrivingLicense,
  addCompanyEmployeeMessage,
  addVehicleInspectionOrderServiceLog,
  addServiceVehicleMovementC2m,
  addServiceVehicleMovementM2m,
  addServiceVehicleMovementM2c,
  addServiceFileMovementC2m,
  addServiceFileMovementM2m,
  addServiceFileMovementM2c,
  addServiceInsuranceForInspection,
  addServiceVehicleInspection,
  addServiceFileInspection,
  addServiceVehicleRepairing,
  updateEmployeeDrivingLicense,
  updateCompanyEmployeeMessage,
  updateVehicleInspectionOrderServiceLog,
  updateServiceVehicleMovementC2m,
  updateServiceVehicleMovementM2m,
  updateServiceVehicleMovementM2c,
  updateServiceFileMovementC2m,
  updateServiceFileMovementM2m,
  updateServiceFileMovementM2c,
  updateServiceInsuranceForInspection,
  updateServiceVehicleInspection,
  updateServiceFileInspection,
  updateServiceVehicleRepairing,
  removeEmployeeDrivingLicenseList,
  removeCompanyEmployeeMessageList,
  removeVehicleInspectionOrderServiceLogList,
  removeServiceVehicleMovementC2mList,
  removeServiceVehicleMovementM2mList,
  removeServiceVehicleMovementM2cList,
  removeServiceFileMovementC2mList,
  removeServiceFileMovementM2mList,
  removeServiceFileMovementM2cList,
  removeServiceInsuranceForInspectionList,
  removeServiceVehicleInspectionList,
  removeServiceFileInspectionList,
  removeServiceVehicleRepairingList,
}
export default VehicleServiceCompanyEmployeeService
