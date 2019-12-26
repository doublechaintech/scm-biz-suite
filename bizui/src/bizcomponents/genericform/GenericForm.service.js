
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}genericFormManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}genericFormManager/loadGenericForm/${targetObjectId}/${parametersExpr}/`,
  })
}







const addFormMessage = (targetObjectId, parameters) => {
  const url = `${PREFIX}genericFormManager/addFormMessage/genericFormId/title/level/tokensExpr/`
  const genericFormId = targetObjectId
  const requestParameters = { ...parameters, genericFormId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateFormMessage = (targetObjectId, parameters) => {
  const url = `${PREFIX}genericFormManager/updateFormMessageProperties/genericFormId/id/title/level/tokensExpr/`
  const genericFormId = targetObjectId
  const requestParameters = { ...parameters, genericFormId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeFormMessageList = (targetObjectId, parameters) => {
  const url = `${PREFIX}genericFormManager/removeFormMessageList/genericFormId/formMessageIds/tokensExpr/`
  const requestParameters = { ...parameters, genericFormId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addFormFieldMessage = (targetObjectId, parameters) => {
  const url = `${PREFIX}genericFormManager/addFormFieldMessage/genericFormId/title/parameterName/level/tokensExpr/`
  const genericFormId = targetObjectId
  const requestParameters = { ...parameters, genericFormId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateFormFieldMessage = (targetObjectId, parameters) => {
  const url = `${PREFIX}genericFormManager/updateFormFieldMessageProperties/genericFormId/id/title/parameterName/level/tokensExpr/`
  const genericFormId = targetObjectId
  const requestParameters = { ...parameters, genericFormId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeFormFieldMessageList = (targetObjectId, parameters) => {
  const url = `${PREFIX}genericFormManager/removeFormFieldMessageList/genericFormId/formFieldMessageIds/tokensExpr/`
  const requestParameters = { ...parameters, genericFormId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addFormField = (targetObjectId, parameters) => {
  const url = `${PREFIX}genericFormManager/addFormField/genericFormId/label/localeKey/parameterName/type/placeholder/defaultValue/description/fieldGroup/minimumValue/maximumValue/required/disabled/customRendering/candidateValues/suggestValues/tokensExpr/`
  const genericFormId = targetObjectId
  const requestParameters = { ...parameters, genericFormId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateFormField = (targetObjectId, parameters) => {
  const url = `${PREFIX}genericFormManager/updateFormFieldProperties/genericFormId/id/label/localeKey/parameterName/type/placeholder/defaultValue/description/fieldGroup/minimumValue/maximumValue/required/disabled/customRendering/candidateValues/suggestValues/tokensExpr/`
  const genericFormId = targetObjectId
  const requestParameters = { ...parameters, genericFormId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeFormFieldList = (targetObjectId, parameters) => {
  const url = `${PREFIX}genericFormManager/removeFormFieldList/genericFormId/formFieldIds/tokensExpr/`
  const requestParameters = { ...parameters, genericFormId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addFormAction = (targetObjectId, parameters) => {
  const url = `${PREFIX}genericFormManager/addFormAction/genericFormId/label/localeKey/actionKey/level/url/tokensExpr/`
  const genericFormId = targetObjectId
  const requestParameters = { ...parameters, genericFormId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateFormAction = (targetObjectId, parameters) => {
  const url = `${PREFIX}genericFormManager/updateFormActionProperties/genericFormId/id/label/localeKey/actionKey/level/url/tokensExpr/`
  const genericFormId = targetObjectId
  const requestParameters = { ...parameters, genericFormId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeFormActionList = (targetObjectId, parameters) => {
  const url = `${PREFIX}genericFormManager/removeFormActionList/genericFormId/formActionIds/tokensExpr/`
  const requestParameters = { ...parameters, genericFormId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}genericFormService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}genericFormService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}genericFormService/process/`,
    data,
  })
}

const GenericFormService = { view,
  load,
  addFormMessage,
  addFormFieldMessage,
  addFormField,
  addFormAction,
  updateFormMessage,
  updateFormFieldMessage,
  updateFormField,
  updateFormAction,
  removeFormMessageList,
  removeFormFieldMessageList,
  removeFormFieldList,
  removeFormActionList, listFunctions, saveRequest, processRequest}
export default GenericFormService

