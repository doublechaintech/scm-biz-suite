import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}moyiManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}moyiManager/loadMoyi/${targetObjectId}/${parametersExpr}/`,
  })
}






const MoyiService = { view,
  load }
export default MoyiService

