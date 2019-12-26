<<<<<<< HEAD
import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

=======

import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}formFieldMessageManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}formFieldMessageManager/loadFormFieldMessage/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateForm = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}formFieldMessageManager/requestCandidateForm/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherForm = (id, parameters) => {
<<<<<<< HEAD
  //const parametersExpr = joinParameters(parameters)
=======
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  const url = `${PREFIX}formFieldMessageManager/transferToAnotherForm/id/anotherFormId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






<<<<<<< HEAD
const FormFieldMessageService = { view,
  load,
  requestCandidateForm,
  transferToAnotherForm }
=======

// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}formFieldMessageService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}formFieldMessageService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}formFieldMessageService/process/`,
    data,
  })
}

const FormFieldMessageService = { view,
  load,
  requestCandidateForm,
  transferToAnotherForm, listFunctions, saveRequest, processRequest}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default FormFieldMessageService

