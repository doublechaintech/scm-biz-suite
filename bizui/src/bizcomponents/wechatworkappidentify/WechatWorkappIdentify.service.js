
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}wechatWorkappIdentifyManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}wechatWorkappIdentifyManager/loadWechatWorkappIdentify/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}wechatWorkappIdentifyManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateSecUser = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}wechatWorkappIdentifyManager/requestCandidateSecUser/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherSecUser = (id, parameters) => {
  const url = `${PREFIX}wechatWorkappIdentifyManager/transferToAnotherSecUser/id/anotherSecUserId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}wechatWorkappIdentifyService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}wechatWorkappIdentifyService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}wechatWorkappIdentifyService/process/`,
    data,
  })
}

const WechatWorkappIdentifyService = { view,
  load,
  requestCandidateSecUser,
  transferToAnotherSecUser, listFunctions, saveRequest, processRequest, queryCandidates}
export default WechatWorkappIdentifyService

