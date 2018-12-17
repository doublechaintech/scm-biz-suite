import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}storageSpaceManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}storageSpaceManager/loadStorageSpace/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateWarehouse = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}storageSpaceManager/requestCandidateWarehouse/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherWarehouse = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}storageSpaceManager/transferToAnotherWarehouse/id/anotherWarehouseId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addGoodsShelf = (targetObjectId, parameters) => {
  const url = `${PREFIX}storageSpaceManager/addGoodsShelf/storageSpaceId/location/supplierSpaceId/damageSpaceId/tokensExpr/`
  const storageSpaceId = targetObjectId
  const requestParameters = { ...parameters, storageSpaceId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateGoodsShelf = (targetObjectId, parameters) => {
  const url = `${PREFIX}storageSpaceManager/updateGoodsShelfProperties/storageSpaceId/id/location/tokensExpr/`
  const storageSpaceId = targetObjectId
  const requestParameters = { ...parameters, storageSpaceId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeGoodsShelfList = (targetObjectId, parameters) => {
  const url = `${PREFIX}storageSpaceManager/removeGoodsShelfList/storageSpaceId/goodsShelfIds/tokensExpr/`
  const requestParameters = { ...parameters, storageSpaceId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const StorageSpaceService = { view,
  load,
  addGoodsShelf,
  updateGoodsShelf,
  removeGoodsShelfList,
  requestCandidateWarehouse,
  transferToAnotherWarehouse }
export default StorageSpaceService

