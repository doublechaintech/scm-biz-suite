
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreCountryCenterManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}retailStoreCountryCenterManager/loadRetailStoreCountryCenter/${targetObjectId}/${parametersExpr}/`,
  })
}







const addCatalog = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addCatalog/retailStoreCountryCenterId/name/subCount/amount/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateCatalog = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updateCatalogProperties/retailStoreCountryCenterId/id/name/subCount/amount/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeCatalogList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removeCatalogList/retailStoreCountryCenterId/catalogIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRetailStoreProvinceCenter = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addRetailStoreProvinceCenter/retailStoreCountryCenterId/name/founded/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStoreProvinceCenter = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updateRetailStoreProvinceCenterProperties/retailStoreCountryCenterId/id/name/founded/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreProvinceCenterList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removeRetailStoreProvinceCenterList/retailStoreCountryCenterId/retailStoreProvinceCenterIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRetailStore = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addRetailStore/retailStoreCountryCenterId/name/telephone/owner/cityServiceCenterId/creationId/investmentInvitationId/franchisingId/decorationId/openingId/closingId/founded/latitude/longitude/description/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStore = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updateRetailStoreProperties/retailStoreCountryCenterId/id/name/telephone/owner/founded/latitude/longitude/description/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removeRetailStoreList/retailStoreCountryCenterId/retailStoreIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRetailStoreMember = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addRetailStoreMember/retailStoreCountryCenterId/name/mobilePhone/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStoreMember = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updateRetailStoreMemberProperties/retailStoreCountryCenterId/id/name/mobilePhone/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreMemberList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removeRetailStoreMemberList/retailStoreCountryCenterId/retailStoreMemberIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addGoodsSupplier = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addGoodsSupplier/retailStoreCountryCenterId/name/supplyProduct/contactNumber/description/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateGoodsSupplier = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updateGoodsSupplierProperties/retailStoreCountryCenterId/id/name/supplyProduct/contactNumber/description/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeGoodsSupplierList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removeGoodsSupplierList/retailStoreCountryCenterId/goodsSupplierIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addSupplyOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addSupplyOrder/retailStoreCountryCenterId/sellerId/title/totalAmount/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSupplyOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updateSupplyOrderProperties/retailStoreCountryCenterId/id/title/totalAmount/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSupplyOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removeSupplyOrderList/retailStoreCountryCenterId/supplyOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRetailStoreOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addRetailStoreOrder/retailStoreCountryCenterId/buyerId/title/totalAmount/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStoreOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updateRetailStoreOrderProperties/retailStoreCountryCenterId/id/title/totalAmount/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removeRetailStoreOrderList/retailStoreCountryCenterId/retailStoreOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addWarehouse = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addWarehouse/retailStoreCountryCenterId/location/contactNumber/totalArea/latitude/longitude/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateWarehouse = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updateWarehouseProperties/retailStoreCountryCenterId/id/location/contactNumber/totalArea/latitude/longitude/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeWarehouseList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removeWarehouseList/retailStoreCountryCenterId/warehouseIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTransportFleet = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addTransportFleet/retailStoreCountryCenterId/name/contactNumber/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTransportFleet = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updateTransportFleetProperties/retailStoreCountryCenterId/id/name/contactNumber/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTransportFleetList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removeTransportFleetList/retailStoreCountryCenterId/transportFleetIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addAccountSet = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addAccountSet/retailStoreCountryCenterId/name/yearSet/effectiveDate/accountingSystem/domesticCurrencyCode/domesticCurrencyName/openingBank/accountNumber/retailStoreId/goodsSupplierId/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateAccountSet = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updateAccountSetProperties/retailStoreCountryCenterId/id/name/yearSet/effectiveDate/accountingSystem/domesticCurrencyCode/domesticCurrencyName/openingBank/accountNumber/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeAccountSetList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removeAccountSetList/retailStoreCountryCenterId/accountSetIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addLevelOneDepartment = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addLevelOneDepartment/retailStoreCountryCenterId/name/description/manager/founded/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateLevelOneDepartment = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updateLevelOneDepartmentProperties/retailStoreCountryCenterId/id/name/description/manager/founded/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeLevelOneDepartmentList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removeLevelOneDepartmentList/retailStoreCountryCenterId/levelOneDepartmentIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addSkillType = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addSkillType/retailStoreCountryCenterId/code/description/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSkillType = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updateSkillTypeProperties/retailStoreCountryCenterId/id/code/description/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSkillTypeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removeSkillTypeList/retailStoreCountryCenterId/skillTypeIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addResponsibilityType = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addResponsibilityType/retailStoreCountryCenterId/code/baseDescription/detailDescription/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateResponsibilityType = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updateResponsibilityTypeProperties/retailStoreCountryCenterId/id/code/baseDescription/detailDescription/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeResponsibilityTypeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removeResponsibilityTypeList/retailStoreCountryCenterId/responsibilityTypeIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTerminationReason = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addTerminationReason/retailStoreCountryCenterId/code/description/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTerminationReason = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updateTerminationReasonProperties/retailStoreCountryCenterId/id/code/description/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTerminationReasonList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removeTerminationReasonList/retailStoreCountryCenterId/terminationReasonIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTerminationType = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addTerminationType/retailStoreCountryCenterId/code/baseDescription/detailDescription/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTerminationType = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updateTerminationTypeProperties/retailStoreCountryCenterId/id/code/baseDescription/detailDescription/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTerminationTypeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removeTerminationTypeList/retailStoreCountryCenterId/terminationTypeIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addOccupationType = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addOccupationType/retailStoreCountryCenterId/code/description/detailDescription/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateOccupationType = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updateOccupationTypeProperties/retailStoreCountryCenterId/id/code/description/detailDescription/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeOccupationTypeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removeOccupationTypeList/retailStoreCountryCenterId/occupationTypeIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addLeaveType = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addLeaveType/retailStoreCountryCenterId/code/description/detailDescription/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateLeaveType = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updateLeaveTypeProperties/retailStoreCountryCenterId/id/code/description/detailDescription/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeLeaveTypeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removeLeaveTypeList/retailStoreCountryCenterId/leaveTypeIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addSalaryGrade = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addSalaryGrade/retailStoreCountryCenterId/code/name/detailDescription/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSalaryGrade = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updateSalaryGradeProperties/retailStoreCountryCenterId/id/code/name/detailDescription/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSalaryGradeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removeSalaryGradeList/retailStoreCountryCenterId/salaryGradeIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addInterviewType = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addInterviewType/retailStoreCountryCenterId/code/description/detailDescription/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateInterviewType = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updateInterviewTypeProperties/retailStoreCountryCenterId/id/code/description/detailDescription/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeInterviewTypeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removeInterviewTypeList/retailStoreCountryCenterId/interviewTypeIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTrainingCourseType = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addTrainingCourseType/retailStoreCountryCenterId/code/name/description/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTrainingCourseType = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updateTrainingCourseTypeProperties/retailStoreCountryCenterId/id/code/name/description/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTrainingCourseTypeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removeTrainingCourseTypeList/retailStoreCountryCenterId/trainingCourseTypeIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addPublicHoliday = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addPublicHoliday/retailStoreCountryCenterId/code/name/description/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updatePublicHoliday = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updatePublicHolidayProperties/retailStoreCountryCenterId/id/code/name/description/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removePublicHolidayList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removePublicHolidayList/retailStoreCountryCenterId/publicHolidayIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addEmployee/retailStoreCountryCenterId/title/departmentId/familyName/givenName/email/city/address/cellPhone/occupationId/responsibleForId/currentSalaryGradeId/salaryAccount/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updateEmployeeProperties/retailStoreCountryCenterId/id/title/familyName/givenName/email/city/address/cellPhone/salaryAccount/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removeEmployeeList/retailStoreCountryCenterId/employeeIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addInstructor = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addInstructor/retailStoreCountryCenterId/title/familyName/givenName/cellPhone/email/introduction/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateInstructor = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updateInstructorProperties/retailStoreCountryCenterId/id/title/familyName/givenName/cellPhone/email/introduction/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeInstructorList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removeInstructorList/retailStoreCountryCenterId/instructorIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addCompanyTraining = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/addCompanyTraining/retailStoreCountryCenterId/title/instructorId/trainingCourseTypeId/timeStart/durationHours/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateCompanyTraining = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/updateCompanyTrainingProperties/retailStoreCountryCenterId/id/title/timeStart/durationHours/tokensExpr/`
  const retailStoreCountryCenterId = targetObjectId
  const requestParameters = { ...parameters, retailStoreCountryCenterId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeCompanyTrainingList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreCountryCenterManager/removeCompanyTrainingList/retailStoreCountryCenterId/companyTrainingIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreCountryCenterId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}retailStoreCountryCenterService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreCountryCenterService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreCountryCenterService/process/`,
    data,
  })
}

const RetailStoreCountryCenterService = { view,
  load,
  addCatalog,
  addRetailStoreProvinceCenter,
  addRetailStore,
  addRetailStoreMember,
  addGoodsSupplier,
  addSupplyOrder,
  addRetailStoreOrder,
  addWarehouse,
  addTransportFleet,
  addAccountSet,
  addLevelOneDepartment,
  addSkillType,
  addResponsibilityType,
  addTerminationReason,
  addTerminationType,
  addOccupationType,
  addLeaveType,
  addSalaryGrade,
  addInterviewType,
  addTrainingCourseType,
  addPublicHoliday,
  addEmployee,
  addInstructor,
  addCompanyTraining,
  updateCatalog,
  updateRetailStoreProvinceCenter,
  updateRetailStore,
  updateRetailStoreMember,
  updateGoodsSupplier,
  updateSupplyOrder,
  updateRetailStoreOrder,
  updateWarehouse,
  updateTransportFleet,
  updateAccountSet,
  updateLevelOneDepartment,
  updateSkillType,
  updateResponsibilityType,
  updateTerminationReason,
  updateTerminationType,
  updateOccupationType,
  updateLeaveType,
  updateSalaryGrade,
  updateInterviewType,
  updateTrainingCourseType,
  updatePublicHoliday,
  updateEmployee,
  updateInstructor,
  updateCompanyTraining,
  removeCatalogList,
  removeRetailStoreProvinceCenterList,
  removeRetailStoreList,
  removeRetailStoreMemberList,
  removeGoodsSupplierList,
  removeSupplyOrderList,
  removeRetailStoreOrderList,
  removeWarehouseList,
  removeTransportFleetList,
  removeAccountSetList,
  removeLevelOneDepartmentList,
  removeSkillTypeList,
  removeResponsibilityTypeList,
  removeTerminationReasonList,
  removeTerminationTypeList,
  removeOccupationTypeList,
  removeLeaveTypeList,
  removeSalaryGradeList,
  removeInterviewTypeList,
  removeTrainingCourseTypeList,
  removePublicHolidayList,
  removeEmployeeList,
  removeInstructorList,
  removeCompanyTrainingList, listFunctions, saveRequest, processRequest}
export default RetailStoreCountryCenterService

