
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}damageSpaceManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}damageSpaceManager/loadDamageSpace/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}damageSpaceManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateWarehouse = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}damageSpaceManager/requestCandidateWarehouse/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherWarehouse = (id, parameters) => {
  const url = `${PREFIX}damageSpaceManager/transferToAnotherWarehouse/id/anotherWarehouseId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addGoodsShelf = (targetObjectId, parameters) => {
  const url = `${PREFIX}damageSpaceManager/addGoodsShelf/damageSpaceId/location/storageSpaceId/supplierSpaceId/tokensExpr/`
  const damageSpaceId = targetObjectId
  const requestParameters = { ...parameters, damageSpaceId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateGoodsShelf = (targetObjectId, parameters) => {
  const url = `${PREFIX}damageSpaceManager/updateGoodsShelfProperties/damageSpaceId/id/location/tokensExpr/`
  const damageSpaceId = targetObjectId
  const requestParameters = { ...parameters, damageSpaceId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeGoodsShelfList = (targetObjectId, parameters) => {
  const url = `${PREFIX}damageSpaceManager/removeGoodsShelfList/damageSpaceId/goodsShelfIds/tokensExpr/`
  const requestParameters = { ...parameters, damageSpaceId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}damageSpaceService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}damageSpaceService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}damageSpaceService/process/`,
    data,
  })
}

const DamageSpaceService = { view,
  load,
  addGoodsShelf,
  updateGoodsShelf,
  removeGoodsShelfList,
  requestCandidateWarehouse,
  transferToAnotherWarehouse, listFunctions, saveRequest, processRequest, queryCandidates}
export default DamageSpaceService

