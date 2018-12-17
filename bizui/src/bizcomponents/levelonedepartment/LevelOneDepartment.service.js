import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}levelOneDepartmentManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}levelOneDepartmentManager/loadLevelOneDepartment/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateBelongsTo = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}levelOneDepartmentManager/requestCandidateBelongsTo/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBelongsTo = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}levelOneDepartmentManager/transferToAnotherBelongsTo/id/anotherBelongsToId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addLevelTwoDepartment = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelOneDepartmentManager/addLevelTwoDepartment/levelOneDepartmentId/name/description/founded/tokensExpr/`
  const levelOneDepartmentId = targetObjectId
  const requestParameters = { ...parameters, levelOneDepartmentId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateLevelTwoDepartment = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelOneDepartmentManager/updateLevelTwoDepartmentProperties/levelOneDepartmentId/id/name/description/founded/tokensExpr/`
  const levelOneDepartmentId = targetObjectId
  const requestParameters = { ...parameters, levelOneDepartmentId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeLevelTwoDepartmentList = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelOneDepartmentManager/removeLevelTwoDepartmentList/levelOneDepartmentId/levelTwoDepartmentIds/tokensExpr/`
  const requestParameters = { ...parameters, levelOneDepartmentId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const LevelOneDepartmentService = { view,
  load,
  addLevelTwoDepartment,
  updateLevelTwoDepartment,
  removeLevelTwoDepartmentList,
  requestCandidateBelongsTo,
  transferToAnotherBelongsTo }
export default LevelOneDepartmentService

