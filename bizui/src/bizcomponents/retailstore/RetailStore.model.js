
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

  namespace: '_retailStore',

  state: {},

  subscriptions: {
    
    setup({ dispatch, history }) { 
      history.listen((location) => {
      	const modelName = 'retailStore'
      	const parameter = {dispatch,history,location,modelName}
        //console.log("setupModel",setupModel,typeof(setupModel))
      	setupModel(parameter)

      })
    },
  },
  effects: {
    *view({ payload }, { call, put, select }) { 
    
      const cachedData = yield select(state => state._retailStore)
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
      
      const {RetailStoreService} = GlobalComponents;
      const data = yield call(RetailStoreService.view, payload.id)
      
      const displayName = payload.displayName||data.displayName
      
      
      yield put({ type: 'breadcrumb/gotoLink', payload: { displayName,link }} )
      

      yield put({ type: 'updateState', payload: data })
    },
    *load({ payload }, { call, put }) { 
      const {RetailStoreService} = GlobalComponents;
      //yield put({ type: 'showLoading', payload })
      const data = yield call(RetailStoreService.load, payload.id, payload.parameters)
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
      yield put(routerRedux.push(`/retailStore/${id}/list/${role}CreateForm`))
    },
    *gotoUpdateForm({ payload }, { put }) {
      const { id, role, selectedRows, currentUpdateIndex } = payload
      const state = { id, role, selectedRows, currentUpdateIndex }
      const location = { pathname: `/retailStore/${id}/list/${role}UpdateForm`, state }
      yield put(routerRedux.push(location))
    },
    *goback({ payload }, { put }) {
      const { id, type,listName } = payload
      yield put(routerRedux.push(`/retailStore/${id}/list/${type}List/${listName}`))
    },




    *addConsumerOrder({ payload }, { call, put }) {
      const userContext = null
      const {RetailStoreService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreService.addConsumerOrder, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/retailStore/${id}/list/${role}CreateForm'))
      notifySuccess(userContext)
      if (continueNext) {
        return
      }
      const partialList = true
      const newState = {...data, partialList}
      const location = { pathname: `/retailStore/${id}/list/ConsumerOrderList/消费者订单+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateConsumerOrder({ payload }, { call, put }) {
      const userContext = null
      const {RetailStoreService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreService.updateConsumerOrder, id, parameters)
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
      const location = { pathname: `/retailStore/${id}/list/ConsumerOrderList/消费者订单列表`, state: newPlayload }
      yield put(routerRedux.push(location))
    },
    *gotoNextConsumerOrderUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeConsumerOrderList({ payload }, { call, put }) {
     const userContext = null
      const {RetailStoreService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreService.removeConsumerOrderList, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }

      yield put({ type: 'updateState', payload: newPlayload })
      notifySuccess(userContext)
    },




    *addRetailStoreOrder({ payload }, { call, put }) {
      const userContext = null
      const {RetailStoreService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreService.addRetailStoreOrder, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/retailStore/${id}/list/${role}CreateForm'))
      notifySuccess(userContext)
      if (continueNext) {
        return
      }
      const partialList = true
      const newState = {...data, partialList}
      const location = { pathname: `/retailStore/${id}/list/RetailStoreOrderList/生超的订单+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateRetailStoreOrder({ payload }, { call, put }) {
      const userContext = null
      const {RetailStoreService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreService.updateRetailStoreOrder, id, parameters)
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
      const location = { pathname: `/retailStore/${id}/list/RetailStoreOrderList/生超的订单列表`, state: newPlayload }
      yield put(routerRedux.push(location))
    },
    *gotoNextRetailStoreOrderUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeRetailStoreOrderList({ payload }, { call, put }) {
     const userContext = null
      const {RetailStoreService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreService.removeRetailStoreOrderList, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }

      yield put({ type: 'updateState', payload: newPlayload })
      notifySuccess(userContext)
    },




    *addGoods({ payload }, { call, put }) {
      const userContext = null
      const {RetailStoreService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreService.addGoods, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/retailStore/${id}/list/${role}CreateForm'))
      notifySuccess(userContext)
      if (continueNext) {
        return
      }
      const partialList = true
      const newState = {...data, partialList}
      const location = { pathname: `/retailStore/${id}/list/GoodsList/货物+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateGoods({ payload }, { call, put }) {
      const userContext = null
      const {RetailStoreService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreService.updateGoods, id, parameters)
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
      const location = { pathname: `/retailStore/${id}/list/GoodsList/货物列表`, state: newPlayload }
      yield put(routerRedux.push(location))
    },
    *gotoNextGoodsUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeGoodsList({ payload }, { call, put }) {
     const userContext = null
      const {RetailStoreService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreService.removeGoodsList, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }

      yield put({ type: 'updateState', payload: newPlayload })
      notifySuccess(userContext)
    },




    *addTransportTask({ payload }, { call, put }) {
      const userContext = null
      const {RetailStoreService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreService.addTransportTask, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/retailStore/${id}/list/${role}CreateForm'))
      notifySuccess(userContext)
      if (continueNext) {
        return
      }
      const partialList = true
      const newState = {...data, partialList}
      const location = { pathname: `/retailStore/${id}/list/TransportTaskList/运输任务+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateTransportTask({ payload }, { call, put }) {
      const userContext = null
      const {RetailStoreService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreService.updateTransportTask, id, parameters)
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
      const location = { pathname: `/retailStore/${id}/list/TransportTaskList/运输任务列表`, state: newPlayload }
      yield put(routerRedux.push(location))
    },
    *gotoNextTransportTaskUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeTransportTaskList({ payload }, { call, put }) {
     const userContext = null
      const {RetailStoreService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreService.removeTransportTaskList, id, parameters)
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
      const {RetailStoreService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreService.addAccountSet, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/retailStore/${id}/list/${role}CreateForm'))
      notifySuccess(userContext)
      if (continueNext) {
        return
      }
      const partialList = true
      const newState = {...data, partialList}
      const location = { pathname: `/retailStore/${id}/list/AccountSetList/账套+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateAccountSet({ payload }, { call, put }) {
      const userContext = null
      const {RetailStoreService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreService.updateAccountSet, id, parameters)
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
      const location = { pathname: `/retailStore/${id}/list/AccountSetList/账套列表`, state: newPlayload }
      yield put(routerRedux.push(location))
    },
    *gotoNextAccountSetUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeAccountSetList({ payload }, { call, put }) {
     const userContext = null
      const {RetailStoreService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreService.removeAccountSetList, id, parameters)
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

