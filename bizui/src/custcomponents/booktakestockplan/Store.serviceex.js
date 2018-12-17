import { get, post,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

//bookManager/actionBookWarehousingWithIsbn/storeId/scannedIsbn/bookCopyVendorId/bookCopySharingType/
const getMethod = (ownerClass, id, filterKey, pageNo) => {
    //const parametersExpr = joinParameters(parameters)
    return get({
      url: `${PREFIX}secUserManager/requestCandidateDomain/${ownerClass}/${id}/${filterKey}/${pageNo}/`,
    })
}

//bookManager/actionBookWarehousingWithIsbn/storeId/scannedIsbn/bookCopyVendorId/bookCopySharingType/

const takeStockByEmployee = (parameters) => {
  //public  Store removeBookCopy(ShuxiangUserContext userContext, String storeId, 
  //	String bookCopyId, int bookCopyVersion,String [] tokensExpr)
  //String planId, String bookCopyIdOrQrCode
  const url = `${PREFIX}bookTakeStockPlanManager/bookcopyScanned/planId/bookCopyIdOrQrCode/`
  const requestParameters = { ...parameters}

  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })

}







  const BookStoreExService = { 
    takeStockByEmployee }
  export default BookStoreExService

