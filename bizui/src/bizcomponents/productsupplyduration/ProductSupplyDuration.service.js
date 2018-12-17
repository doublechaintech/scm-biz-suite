import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}productSupplyDurationManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}productSupplyDurationManager/loadProductSupplyDuration/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateProduct = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}productSupplyDurationManager/requestCandidateProduct/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherProduct = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}productSupplyDurationManager/transferToAnotherProduct/id/anotherProductId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const ProductSupplyDurationService = { view,
  load,
  requestCandidateProduct,
  transferToAnotherProduct }
export default ProductSupplyDurationService

