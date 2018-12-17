import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}productManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}productManager/loadProduct/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateParentCategory = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}productManager/requestCandidateParentCategory/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherParentCategory = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}productManager/transferToAnotherParentCategory/id/anotherParentCategoryId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addSku = (targetObjectId, parameters) => {
  const url = `${PREFIX}productManager/addSku/productId/name/size/barcode/packageType/netContent/price/picture/tokensExpr/`
  const productId = targetObjectId
  const requestParameters = { ...parameters, productId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSku = (targetObjectId, parameters) => {
  const url = `${PREFIX}productManager/updateSkuProperties/productId/id/name/size/barcode/packageType/netContent/price/picture/tokensExpr/`
  const productId = targetObjectId
  const requestParameters = { ...parameters, productId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSkuList = (targetObjectId, parameters) => {
  const url = `${PREFIX}productManager/removeSkuList/productId/skuIds/tokensExpr/`
  const requestParameters = { ...parameters, productId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const ProductService = { view,
  load,
  addSku,
  updateSku,
  removeSkuList,
  requestCandidateParentCategory,
  transferToAnotherParentCategory }
export default ProductService

