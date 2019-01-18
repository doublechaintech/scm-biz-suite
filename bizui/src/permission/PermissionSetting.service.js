
import { postForm,PREFIX} from '../axios/tools'

const requestCandidateSecUser = (ownerClass, id, filterKey, pageNo) => {
   
    const url = `${PREFIX}userAppManager/requestCandidateSecUser/ownerClass/id/filterKey/pageNo/`
    const requestParameters = {id, ownerClass,filterKey, pageNo}
    
    return postForm({url,requestParameters})
}	


//testIfHasManagementAccess

const testIfHasManagementAccess = (objectType, objectId) => {

  
  const url = `${PREFIX}secUserManager/testIfHasManagementAccess/objectType/objectId/`
  const requestParameters = {objectType, objectId}
  console.log("requestParameters", requestParameters)
  return postForm({url,requestParameters})
}	
const loadUserAppWithUser = (secUserId,objectType, objectId, title, appIcon) => {

  
  const url = `${PREFIX}secUserManager/loadUserAppWithUser/secUserId/objectType/objectId/title/appIcon/`
  const requestParameters = {secUserId,objectType, objectId, title, appIcon}
  console.log("requestParameters", requestParameters)
  return postForm({url,requestParameters})
}	

const updateAppPermission = (secUserId,userAppId, version, permission) => {
  const url = `${PREFIX}secUserManager/updateAppPermission/secUserId/userAppId/version/permission/`
  const requestParameters = {secUserId,userAppId,version,permission}
  console.log("requestParameters", requestParameters)
  return postForm({url,requestParameters})
}	

const updateListAccess = (secUserId,userAppId, displayName, permissionTokens) => {

  const url = `${PREFIX}secUserManager/updateListAccess/secUserId/userAppId/displayName/permissionTokens/`
  const requestParameters = {secUserId,userAppId,displayName,permissionTokens}
  console.log("requestParameters", requestParameters)
  return postForm({url,requestParameters})
}	


const hasItemReadPermission=(item)=>{
  if(!item){
    return false
  }
  
  if(!item.metaInfo){
    return true //for old code
  }
  if(!item.metaInfo.accessInfo){
    return false 
  }
  if(!item.metaInfo.accessInfo.readPermission){
    return false
  }
  return true
}

const hasItemCreatePermission=(item)=>{
  if(!item){
    return false
  }
  if(!item.addFunction){
    return false
  }
  if(!item.metaInfo){
    return true //for old code
  }
  if(!item.metaInfo.accessInfo){
    return false 
  }
  if(!item.metaInfo.accessInfo.createPermission){
    return false
  }
  return true
}

const hasCreatePermission=(metaInfo)=>{

  if(!metaInfo){
    return true //for old code
  }
  if(!metaInfo.accessInfo){
    return false 
  }
  if(!metaInfo.accessInfo.createPermission){
    return false
  }
  return true
}

const hasReadPermission=(metaInfo)=>{

  if(!metaInfo){
    return true //for old code
  }
  if(!metaInfo.accessInfo){
    return false 
  }
  if(!metaInfo.accessInfo.readPermission){
    return false
  }
  return true
}


const hasUpdatePermission=(metaInfo)=>{

 
  if(!metaInfo){
    return true //for old code
  }
  if(!metaInfo.accessInfo){
    return false 
  }
  if(!metaInfo.accessInfo.updatePermission){
    return false
  }
  return true
}

const hasDeletePermission=(metaInfo)=>{

 
  if(!metaInfo){
    return true //for old code
  }
  if(!metaInfo.accessInfo){
    return false 
  }
  if(!metaInfo.accessInfo.deletePermission){
    return false
  }
  return true
}


const hasExecutionPermission=(metaInfo)=>{

 
  if(!metaInfo){
    return true //for old code
  }
  if(!metaInfo.accessInfo){
    return false 
  }
  if(!metaInfo.accessInfo.executionPermission){
    return false
  }
  return true
}

const filterForMenuPermission = (item, targetObject, targetComponent) => {

  

  if(!item){
    return false
  }
  const itemName = item.name
  if(!itemName){
    return false
  }
  if(!targetObject){
    return false
  }
  
  const metaInfo = targetObject[itemName+"MetaInfo"]
  if(!metaInfo){
    return true
  }
  
  if(!metaInfo.accessInfo){
    return true //for old code
  }
  console.log("item", item,"metaInfo", metaInfo)
  if(!metaInfo.accessInfo.readPermission){
    return false 
  }
  

  return true

}

const PermissionSettingService = {
  requestCandidateSecUser,loadUserAppWithUser,updateAppPermission,updateListAccess,hasItemReadPermission,
  hasCreatePermission,hasExecutionPermission,hasDeletePermission,hasUpdatePermission,hasReadPermission,hasItemCreatePermission,
  testIfHasManagementAccess,filterForMenuPermission

}

export default PermissionSettingService

