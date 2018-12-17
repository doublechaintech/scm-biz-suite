import { get, post,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

//bookManager/actionBookWarehousingWithIsbn/storeId/scannedIsbn/bookCopyVendorId/bookCopySharingType/
const getMethod = (ownerClass, id, filterKey, pageNo) => {
    //const parametersExpr = joinParameters(parameters)
    return get({
      url: `${PREFIX}secUserManager/requestCandidateDomain/${ownerClass}/${id}/${filterKey}/${pageNo}/`,
    })
}

//bookManager/actionBookWarehousingWithIsbn/storeId/scannedIsbn/bookCopyVendorId/bookCopySharingType/


const actionBookWarehousingWithIsbn = (targetObjectId, parameters) => {
    const url = `${PREFIX}bookManager/actionBookWarehousingWithIsbn/storeId/scannedIsbn/bookCopyVendorId/bookCopySharingType/`
    const requestParameters = { ...parameters}
  
    const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
    return post({
      url,
      data: joinPostParameters(requestParameters),
      headers,
    })
  }



  
const addUserApp = (targetObjectId, parameters) => {
    const url = `${PREFIX}secUserManager/addUserApp/secUserId/title/appIcon/fullAccess/permission/objectType/objectId/location/tokensExpr/`
    const requestParameters = { ...parameters, tokensExpr: 'none' }
  
    const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
    return post({
      url,
      data: joinPostParameters(requestParameters),
      headers,
    })
  }



  const BookStoreExService = { actionBookWarehousingWithIsbn }
  export default BookStoreExService