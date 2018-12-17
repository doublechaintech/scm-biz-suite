import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}supplierSpaceManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}supplierSpaceManager/loadSupplierSpace/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateWarehouse = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}supplierSpaceManager/requestCandidateWarehouse/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherWarehouse = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}supplierSpaceManager/transferToAnotherWarehouse/id/anotherWarehouseId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addGoodsShelf = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplierSpaceManager/addGoodsShelf/supplierSpaceId/location/storageSpaceId/damageSpaceId/tokensExpr/`
  const supplierSpaceId = targetObjectId
  const requestParameters = { ...parameters, supplierSpaceId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateGoodsShelf = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplierSpaceManager/updateGoodsShelfProperties/supplierSpaceId/id/location/tokensExpr/`
  const supplierSpaceId = targetObjectId
  const requestParameters = { ...parameters, supplierSpaceId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeGoodsShelfList = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplierSpaceManager/removeGoodsShelfList/supplierSpaceId/goodsShelfIds/tokensExpr/`
  const requestParameters = { ...parameters, supplierSpaceId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const SupplierSpaceService = { view,
  load,
  addGoodsShelf,
  updateGoodsShelf,
  removeGoodsShelfList,
  requestCandidateWarehouse,
  transferToAnotherWarehouse }
export default SupplierSpaceService

