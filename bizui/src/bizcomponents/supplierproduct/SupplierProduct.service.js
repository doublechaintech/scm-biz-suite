
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}supplierProductManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}supplierProductManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}supplierProductManager/loadSupplierProduct/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}supplierProductManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateSupplier = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}supplierProductManager/requestCandidateSupplier/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherSupplier = (id, parameters) => {
  const url = `${PREFIX}supplierProductManager/transferToAnotherSupplier/id/anotherSupplierId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addProductSupplyDuration = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplierProductManager/addProductSupplyDuration/supplierProductId/quantity/duration/price/tokensExpr/`
  const supplierProductId = targetObjectId
  const requestParameters = { ...parameters, supplierProductId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateProductSupplyDuration = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplierProductManager/updateProductSupplyDurationProperties/supplierProductId/id/quantity/duration/price/tokensExpr/`
  const supplierProductId = targetObjectId
  const requestParameters = { ...parameters, supplierProductId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeProductSupplyDurationList = (targetObjectId, parameters) => {
  const url = `${PREFIX}supplierProductManager/removeProductSupplyDurationList/supplierProductId/productSupplyDurationIds/tokensExpr/`
  const requestParameters = { ...parameters, supplierProductId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}supplierProductService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}supplierProductService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}supplierProductService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}supplierProductService/process/`,
    data,
  })
}

const SupplierProductService = { view,
  load,
  analyze,
  addProductSupplyDuration,
  updateProductSupplyDuration,
  removeProductSupplyDurationList,
  requestCandidateSupplier,
  transferToAnotherSupplier, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default SupplierProductService

