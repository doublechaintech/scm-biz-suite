
import React from 'react'
import pathToRegexp from 'path-to-regexp'
import { routerRedux } from 'dva/router'
import { notification } from 'antd'
import GlobalComponents from '../../custcomponents';
import appLocaleName from '../../common/Locale.tool'
import modeltool from '../../utils/modeltool'
const {setupModel,hasError,handleClientError,handleServerError,keepValueWithKeySuffix}=modeltool

const notifySuccess=(userContext)=>{

	notification.success({
        message: appLocaleName(userContext,'Success'),
        description: appLocaleName(userContext,'Success'),
      })

}


export default {

  namespace: '_goodsSupplier',

  state: {},

  subscriptions: {
    
    setup({ dispatch, history }) { 
      history.listen((location) => {
      	const modelName = 'goodsSupplier'
      	const parameter = {dispatch,history,location,modelName}
        //console.log("setupModel",setupModel,typeof(setupModel))
      	setupModel(parameter)

      })
    },
  },
  effects: {
    *view({ payload }, { call, put, select }) { 
    
      const cachedData = yield select(state => state._goodsSupplier)
      //if the data in the cache, just show it, there is no delay
      const link = payload.pathname
      //if the data in the cache, just show it, there is no delay
      if(cachedData.class){
        //yield put({ type: 'breadcrumb/gotoLink', payload: { displayName:cachedData.displayName,link }} )
        yield put({ type: 'updateState', payload: cachedData })
        
        if(payload.useCache){
        	return //use cache for returning page
        }
        
      }else{
        yield put({ type: 'showLoading', payload })
      }
      
      const {GoodsSupplierService} = GlobalComponents;
      const data = yield call(GoodsSupplierService.view, payload.id)
      
      const displayName = payload.displayName||data.displayName
      
      
      yield put({ type: 'breadcrumb/gotoLink', payload: { displayName,link }} )
      

      yield put({ type: 'updateState', payload: data })
    },
    *load({ payload }, { call, put }) { 
      const {GoodsSupplierService} = GlobalComponents;
      //yield put({ type: 'showLoading', payload })
      const data = yield call(GoodsSupplierService.load, payload.id, payload.parameters)
      const newPlayload = { ...payload, ...data }
      
      console.log('this is the data id: ', data.id)
      yield put({ type: 'updateState', payload: newPlayload })
    },
    
    *doJob({ payload }, { call, put }) { 
      const userContext = null
      const {TaskService} = GlobalComponents;
      //yield put({ type: 'showLoading', payload })      
      const {serviceNameToCall, id, parameters} = payload;
      if(!serviceNameToCall){
      	handleClientError(appLocaleName(userContext,'ServiceNotRegistered'))
      	return;
      }
      "react/dva_object_model.jsp"
      
      const data = yield call(serviceNameToCall, id, parameters)
      if(handleServerError(data)){
      	return
      }
      const newPlayload = { ...payload, ...data }
      
      console.log('this is the data id: ', data.id)
      yield put({ type: 'updateState', payload: newPlayload })
    },
       
    
    
    *gotoCreateForm({ payload }, { put }) {
      const { id, role } = payload
      yield put(routerRedux.push(`/goodsSupplier/${id}/list/${role}CreateForm`))
    },
    *gotoUpdateForm({ payload }, { put }) {
      const { id, role, selectedRows, currentUpdateIndex } = payload
      const state = { id, role, selectedRows, currentUpdateIndex }
      const location = { pathname: `/goodsSupplier/${id}/list/${role}UpdateForm`, state }
      yield put(routerRedux.push(location))
    },
    *goback({ payload }, { put }) {
      const { id, type,listName } = payload
      yield put(routerRedux.push(`/goodsSupplier/${id}/list/${type}List/${listName}`))
    },




    *addSupplierProduct({ payload }, { call, put }) {
      const userContext = null
      const {GoodsSupplierService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(GoodsSupplierService.addSupplierProduct, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/goodsSupplier/${id}/list/${role}CreateForm'))
      notifySuccess(userContext)
      if (continueNext) {
        return
      }
      const partialList = true
      const newState = {...data, partialList}
      const location = { pathname: `/goodsSupplier/${id}/list/SupplierProductList/供应商的产品+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateSupplierProduct({ payload }, { call, put }) {
      const userContext = null
      const {GoodsSupplierService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(GoodsSupplierService.updateSupplierProduct, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const partialList = true
      
      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex,partialList }
      yield put({ type: 'updateState', payload: newPlayload })
      notifySuccess(userContext)
      
      if (continueNext) {
        return
      }
      const location = { pathname: `/goodsSupplier/${id}/list/SupplierProductList/供应商的产品列表`, state: newPlayload }
      yield put(routerRedux.push(location))
    },
    *gotoNextSupplierProductUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeSupplierProductList({ payload }, { call, put }) {
     const userContext = null
      const {GoodsSupplierService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(GoodsSupplierService.removeSupplierProductList, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }

      yield put({ type: 'updateState', payload: newPlayload })
      notifySuccess(userContext)
    },




    *addSupplyOrder({ payload }, { call, put }) {
      const userContext = null
      const {GoodsSupplierService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(GoodsSupplierService.addSupplyOrder, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/goodsSupplier/${id}/list/${role}CreateForm'))
      notifySuccess(userContext)
      if (continueNext) {
        return
      }
      const partialList = true
      const newState = {...data, partialList}
      const location = { pathname: `/goodsSupplier/${id}/list/SupplyOrderList/供应订单+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateSupplyOrder({ payload }, { call, put }) {
      const userContext = null
      const {GoodsSupplierService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(GoodsSupplierService.updateSupplyOrder, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const partialList = true
      
      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex,partialList }
      yield put({ type: 'updateState', payload: newPlayload })
      notifySuccess(userContext)
      
      if (continueNext) {
        return
      }
      const location = { pathname: `/goodsSupplier/${id}/list/SupplyOrderList/供应订单列表`, state: newPlayload }
      yield put(routerRedux.push(location))
    },
    *gotoNextSupplyOrderUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeSupplyOrderList({ payload }, { call, put }) {
     const userContext = null
      const {GoodsSupplierService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(GoodsSupplierService.removeSupplyOrderList, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }

      yield put({ type: 'updateState', payload: newPlayload })
      notifySuccess(userContext)
    },




    *addAccountSet({ payload }, { call, put }) {
      const userContext = null
      const {GoodsSupplierService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(GoodsSupplierService.addAccountSet, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/goodsSupplier/${id}/list/${role}CreateForm'))
      notifySuccess(userContext)
      if (continueNext) {
        return
      }
      const partialList = true
      const newState = {...data, partialList}
      const location = { pathname: `/goodsSupplier/${id}/list/AccountSetList/账套+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateAccountSet({ payload }, { call, put }) {
      const userContext = null
      const {GoodsSupplierService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(GoodsSupplierService.updateAccountSet, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const partialList = true
      
      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex,partialList }
      yield put({ type: 'updateState', payload: newPlayload })
      notifySuccess(userContext)
      
      if (continueNext) {
        return
      }
      const location = { pathname: `/goodsSupplier/${id}/list/AccountSetList/账套列表`, state: newPlayload }
      yield put(routerRedux.push(location))
    },
    *gotoNextAccountSetUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeAccountSetList({ payload }, { call, put }) {
     const userContext = null
      const {GoodsSupplierService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(GoodsSupplierService.removeAccountSetList, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }

      yield put({ type: 'updateState', payload: newPlayload })
      notifySuccess(userContext)
    },

  },
  
  reducers: {
    updateState(state, action) {
      const payload = { ...action.payload, loading: true }
      const valueToKeep = keepValueWithKeySuffix(state,"Parameters") 
      return { ...valueToKeep, ...payload}
    },
    showLoading(state, action) {
      // const loading=true
      const payload = { ...action.payload, loading: true }
      const valueToKeep = keepValueWithKeySuffix(state,"Parameters") 
      return { ...valueToKeep, ...payload}
    },
  },
}

