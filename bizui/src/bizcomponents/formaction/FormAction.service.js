<<<<<<< HEAD
import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

=======

import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}formActionManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}formActionManager/loadFormAction/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateForm = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}formActionManager/requestCandidateForm/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherForm = (id, parameters) => {
<<<<<<< HEAD
  //const parametersExpr = joinParameters(parameters)
=======
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  const url = `${PREFIX}formActionManager/transferToAnotherForm/id/anotherFormId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






<<<<<<< HEAD
const FormActionService = { view,
  load,
  requestCandidateForm,
  transferToAnotherForm }
=======

// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}formActionService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}formActionService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}formActionService/process/`,
    data,
  })
}

const FormActionService = { view,
  load,
  requestCandidateForm,
  transferToAnotherForm, listFunctions, saveRequest, processRequest}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default FormActionService

