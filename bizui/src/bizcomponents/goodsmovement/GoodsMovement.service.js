import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


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
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}goodsMovementManager/transferToAnotherGoods/id/anotherGoodsId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const GoodsMovementService = { view,
  load,
  requestCandidateGoods,
  transferToAnotherGoods }
export default GoodsMovementService

