
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

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


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}productSupplyDurationManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateProduct = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}productSupplyDurationManager/requestCandidateProduct/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherProduct = (id, parameters) => {
  const url = `${PREFIX}productSupplyDurationManager/transferToAnotherProduct/id/anotherProductId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}productSupplyDurationService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}productSupplyDurationService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}productSupplyDurationService/process/`,
    data,
  })
}

const ProductSupplyDurationService = { view,
  load,
  requestCandidateProduct,
  transferToAnotherProduct, listFunctions, saveRequest, processRequest, queryCandidates}
export default ProductSupplyDurationService

