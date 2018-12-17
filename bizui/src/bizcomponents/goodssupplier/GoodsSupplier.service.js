import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}goodsSupplierManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}goodsSupplierManager/loadGoodsSupplier/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateBelongTo = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}goodsSupplierManager/requestCandidateBelongTo/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBelongTo = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}goodsSupplierManager/transferToAnotherBelongTo/id/anotherBelongToId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addSupplierProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsSupplierManager/addSupplierProduct/goodsSupplierId/productName/productDescription/productUnit/tokensExpr/`
  const goodsSupplierId = targetObjectId
  const requestParameters = { ...parameters, goodsSupplierId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSupplierProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsSupplierManager/updateSupplierProductProperties/goodsSupplierId/id/productName/productDescription/productUnit/tokensExpr/`
  const goodsSupplierId = targetObjectId
  const requestParameters = { ...parameters, goodsSupplierId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSupplierProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsSupplierManager/removeSupplierProductList/goodsSupplierId/supplierProductIds/tokensExpr/`
  const requestParameters = { ...parameters, goodsSupplierId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addSupplyOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsSupplierManager/addSupplyOrder/goodsSupplierId/buyerId/title/totalAmount/tokensExpr/`
  const goodsSupplierId = targetObjectId
  const requestParameters = { ...parameters, goodsSupplierId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSupplyOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsSupplierManager/updateSupplyOrderProperties/goodsSupplierId/id/title/totalAmount/tokensExpr/`
  const goodsSupplierId = targetObjectId
  const requestParameters = { ...parameters, goodsSupplierId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSupplyOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsSupplierManager/removeSupplyOrderList/goodsSupplierId/supplyOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, goodsSupplierId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addAccountSet = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsSupplierManager/addAccountSet/goodsSupplierId/name/yearSet/effectiveDate/accountingSystem/domesticCurrencyCode/domesticCurrencyName/openingBank/accountNumber/countryCenterId/retailStoreId/tokensExpr/`
  const goodsSupplierId = targetObjectId
  const requestParameters = { ...parameters, goodsSupplierId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateAccountSet = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsSupplierManager/updateAccountSetProperties/goodsSupplierId/id/name/yearSet/effectiveDate/accountingSystem/domesticCurrencyCode/domesticCurrencyName/openingBank/accountNumber/tokensExpr/`
  const goodsSupplierId = targetObjectId
  const requestParameters = { ...parameters, goodsSupplierId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeAccountSetList = (targetObjectId, parameters) => {
  const url = `${PREFIX}goodsSupplierManager/removeAccountSetList/goodsSupplierId/accountSetIds/tokensExpr/`
  const requestParameters = { ...parameters, goodsSupplierId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const GoodsSupplierService = { view,
  load,
  addSupplierProduct,
  addSupplyOrder,
  addAccountSet,
  updateSupplierProduct,
  updateSupplyOrder,
  updateAccountSet,
  removeSupplierProductList,
  removeSupplyOrderList,
  removeAccountSetList,
  requestCandidateBelongTo,
  transferToAnotherBelongTo }
export default GoodsSupplierService

