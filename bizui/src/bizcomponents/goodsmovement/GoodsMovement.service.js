
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}goodsMovementManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}goodsMovementManager/loadGoodsMovement/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateGoods = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}goodsMovementManager/requestCandidateGoods/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherGoods = (id, parameters) => {
  const url = `${PREFIX}goodsMovementManager/transferToAnotherGoods/id/anotherGoodsId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}goodsMovementService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}goodsMovementService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}goodsMovementService/process/`,
    data,
  })
}

const GoodsMovementService = { view,
  load,
  requestCandidateGoods,
  transferToAnotherGoods, listFunctions, saveRequest, processRequest}
export default GoodsMovementService

