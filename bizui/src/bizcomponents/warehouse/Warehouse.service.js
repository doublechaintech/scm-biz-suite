import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}warehouseManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}warehouseManager/loadWarehouse/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateOwner = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}warehouseManager/requestCandidateOwner/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherOwner = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}warehouseManager/transferToAnotherOwner/id/anotherOwnerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addStorageSpace = (targetObjectId, parameters) => {
  const url = `${PREFIX}warehouseManager/addStorageSpace/warehouseId/location/contactNumber/totalArea/latitude/longitude/tokensExpr/`
  const warehouseId = targetObjectId
  const requestParameters = { ...parameters, warehouseId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateStorageSpace = (targetObjectId, parameters) => {
  const url = `${PREFIX}warehouseManager/updateStorageSpaceProperties/warehouseId/id/location/contactNumber/totalArea/latitude/longitude/tokensExpr/`
  const warehouseId = targetObjectId
  const requestParameters = { ...parameters, warehouseId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeStorageSpaceList = (targetObjectId, parameters) => {
  const url = `${PREFIX}warehouseManager/removeStorageSpaceList/warehouseId/storageSpaceIds/tokensExpr/`
  const requestParameters = { ...parameters, warehouseId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addSmartPallet = (targetObjectId, parameters) => {
  const url = `${PREFIX}warehouseManager/addSmartPallet/warehouseId/location/contactNumber/totalArea/latitude/longitude/tokensExpr/`
  const warehouseId = targetObjectId
  const requestParameters = { ...parameters, warehouseId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSmartPallet = (targetObjectId, parameters) => {
  const url = `${PREFIX}warehouseManager/updateSmartPalletProperties/warehouseId/id/location/contactNumber/totalArea/latitude/longitude/tokensExpr/`
  const warehouseId = targetObjectId
  const requestParameters = { ...parameters, warehouseId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSmartPalletList = (targetObjectId, parameters) => {
  const url = `${PREFIX}warehouseManager/removeSmartPalletList/warehouseId/smartPalletIds/tokensExpr/`
  const requestParameters = { ...parameters, warehouseId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addSupplierSpace = (targetObjectId, parameters) => {
  const url = `${PREFIX}warehouseManager/addSupplierSpace/warehouseId/location/contactNumber/totalArea/latitude/longitude/tokensExpr/`
  const warehouseId = targetObjectId
  const requestParameters = { ...parameters, warehouseId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSupplierSpace = (targetObjectId, parameters) => {
  const url = `${PREFIX}warehouseManager/updateSupplierSpaceProperties/warehouseId/id/location/contactNumber/totalArea/latitude/longitude/tokensExpr/`
  const warehouseId = targetObjectId
  const requestParameters = { ...parameters, warehouseId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSupplierSpaceList = (targetObjectId, parameters) => {
  const url = `${PREFIX}warehouseManager/removeSupplierSpaceList/warehouseId/supplierSpaceIds/tokensExpr/`
  const requestParameters = { ...parameters, warehouseId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addReceivingSpace = (targetObjectId, parameters) => {
  const url = `${PREFIX}warehouseManager/addReceivingSpace/warehouseId/location/contactNumber/description/totalArea/latitude/longitude/tokensExpr/`
  const warehouseId = targetObjectId
  const requestParameters = { ...parameters, warehouseId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateReceivingSpace = (targetObjectId, parameters) => {
  const url = `${PREFIX}warehouseManager/updateReceivingSpaceProperties/warehouseId/id/location/contactNumber/description/totalArea/latitude/longitude/tokensExpr/`
  const warehouseId = targetObjectId
  const requestParameters = { ...parameters, warehouseId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeReceivingSpaceList = (targetObjectId, parameters) => {
  const url = `${PREFIX}warehouseManager/removeReceivingSpaceList/warehouseId/receivingSpaceIds/tokensExpr/`
  const requestParameters = { ...parameters, warehouseId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addShippingSpace = (targetObjectId, parameters) => {
  const url = `${PREFIX}warehouseManager/addShippingSpace/warehouseId/location/contactNumber/totalArea/latitude/longitude/description/tokensExpr/`
  const warehouseId = targetObjectId
  const requestParameters = { ...parameters, warehouseId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateShippingSpace = (targetObjectId, parameters) => {
  const url = `${PREFIX}warehouseManager/updateShippingSpaceProperties/warehouseId/id/location/contactNumber/totalArea/latitude/longitude/description/tokensExpr/`
  const warehouseId = targetObjectId
  const requestParameters = { ...parameters, warehouseId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeShippingSpaceList = (targetObjectId, parameters) => {
  const url = `${PREFIX}warehouseManager/removeShippingSpaceList/warehouseId/shippingSpaceIds/tokensExpr/`
  const requestParameters = { ...parameters, warehouseId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addDamageSpace = (targetObjectId, parameters) => {
  const url = `${PREFIX}warehouseManager/addDamageSpace/warehouseId/location/contactNumber/totalArea/latitude/longitude/tokensExpr/`
  const warehouseId = targetObjectId
  const requestParameters = { ...parameters, warehouseId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateDamageSpace = (targetObjectId, parameters) => {
  const url = `${PREFIX}warehouseManager/updateDamageSpaceProperties/warehouseId/id/location/contactNumber/totalArea/latitude/longitude/tokensExpr/`
  const warehouseId = targetObjectId
  const requestParameters = { ...parameters, warehouseId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeDamageSpaceList = (targetObjectId, parameters) => {
  const url = `${PREFIX}warehouseManager/removeDamageSpaceList/warehouseId/damageSpaceIds/tokensExpr/`
  const requestParameters = { ...parameters, warehouseId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addWarehouseAsset = (targetObjectId, parameters) => {
  const url = `${PREFIX}warehouseManager/addWarehouseAsset/warehouseId/name/position/tokensExpr/`
  const warehouseId = targetObjectId
  const requestParameters = { ...parameters, warehouseId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateWarehouseAsset = (targetObjectId, parameters) => {
  const url = `${PREFIX}warehouseManager/updateWarehouseAssetProperties/warehouseId/id/name/position/tokensExpr/`
  const warehouseId = targetObjectId
  const requestParameters = { ...parameters, warehouseId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeWarehouseAssetList = (targetObjectId, parameters) => {
  const url = `${PREFIX}warehouseManager/removeWarehouseAssetList/warehouseId/warehouseAssetIds/tokensExpr/`
  const requestParameters = { ...parameters, warehouseId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const WarehouseService = { view,
  load,
  addStorageSpace,
  addSmartPallet,
  addSupplierSpace,
  addReceivingSpace,
  addShippingSpace,
  addDamageSpace,
  addWarehouseAsset,
  updateStorageSpace,
  updateSmartPallet,
  updateSupplierSpace,
  updateReceivingSpace,
  updateShippingSpace,
  updateDamageSpace,
  updateWarehouseAsset,
  removeStorageSpaceList,
  removeSmartPalletList,
  removeSupplierSpaceList,
  removeReceivingSpaceList,
  removeShippingSpaceList,
  removeDamageSpaceList,
  removeWarehouseAssetList,
  requestCandidateOwner,
  transferToAnotherOwner }
export default WarehouseService

