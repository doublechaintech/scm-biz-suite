
import pathToRegexp from 'path-to-regexp'
import { notification } from 'antd'
const hasError = (data) => {
    if (!data.class) {
        return false
    }
    if (data.class.indexOf('Exception') > 0) {
        return true
    }
    if (data.class.indexOf('LoginForm') > 0) {
        return true
    }
    return false
}
const handleClientError = (message) => {
    notification.error({
        message: message,
        description: message,
    })
}

const handleServerError = (data) => {
    if (data.class) {
        if (data.class.indexOf("Exception") < 0) {
            return false
        }
    }
    if (data.message) {
        notification.error({
            message: data.message,
            description: data.message,
        })

    }
    if (data.messageList[0]) {
        // console.error('error ', data.messageList[0].sourcePosition)
        notification.error({
            message: data.messageList[0].sourcePosition,
            description: data.messageList[0].body,
        })
    }
    return true
}
const setupModel = ({ dispatch, history, location, modelName }) => {
    const { pathname } = location
    const prefix = modelName //not start with /
    if (!pathname.startsWith(`/${modelName}`)) {
        return
    }
    const newstate = location.state
    if (newstate) {
        dispatch({ type: 'updateState', payload: newstate })
        return
    }
    const dashboardmatch = pathToRegexp(`/${modelName}/:id/dashboard`).exec(pathname)
    if (dashboardmatch) {
        const id = dashboardmatch[1]
        dispatch({ type: 'view', payload: { id, pathname } })
        return
    }


    const profilematch = pathToRegexp(`/${modelName}/:id/profile`).exec(pathname)
    if (profilematch) {
        const id = profilematch[1]
        dispatch({ type: 'view', payload: { id, pathname } })
        return
    }
    const editDetailMatch = pathToRegexp(`/${modelName}/:id/editDetail`).exec(pathname)
    if (editDetailMatch) {
        const id = editDetailMatch[1]
        dispatch({ type: 'view', payload: { id, pathname } })
        return
    }

    const viewDetailMatch = pathToRegexp(`/${modelName}/:id/viewDetail`).exec(pathname)
    if (viewDetailMatch) {
        const id = viewDetailMatch[1]
        dispatch({ type: 'view', payload: { id, pathname } })
        return
    }

    const match = pathToRegexp(`/${modelName}/:id/list/:listName/:listDisplayName`).exec(pathname)
    if (match) {
        const id = match[1]
        const listName= match[2]
        const displayName = match[3]
        dispatch({ type: 'view', payload: { id, pathname,listName, displayName } })
    }
    const othermatch = pathToRegexp(`/${modelName}/:id/:subpage`).exec(pathname)
    if (othermatch) {
        const id = othermatch[1]
        dispatch({ type: 'view', payload: { id, pathname } })
        
    }

}
const keepValueWithKeySuffix=(targetObject,suffix)=>{

    const filteredValues = {}
    for(var key in targetObject){
        if(!key.endsWith(suffix)){
          continue
        }
        const value = targetObject[key]
        if(!value){
          continue
        }
        filteredValues[key] = value
       
    }
    return filteredValues
  
  }
const modeltool={hasError,setupModel,handleClientError,handleServerError,keepValueWithKeySuffix}
export default modeltool
