
<<<<<<< HEAD

=======
import React from 'react'
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
import pathToRegexp from 'path-to-regexp'
import { routerRedux } from 'dva/router'
import { notification } from 'antd'
import GlobalComponents from '../../custcomponents';
<<<<<<< HEAD

import modeltool from '../../utils/modeltool'
const {setupModel,hasError,handleClientError,handleServerError,keepValueWithKeySuffix}=modeltool

=======
import appLocaleName from '../../common/Locale.tool'
import modeltool from '../../utils/modeltool'
const {setupModel,hasError,handleClientError,handleServerError,keepValueWithKeySuffix}=modeltool

const notifySuccess=(userContext)=>{

	notification.success({
        message: appLocaleName(userContext,'Success'),
        description: appLocaleName(userContext,'Success'),
      })

}

>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

export default {

  namespace: '_retailStoreMember',

  state: {},

  subscriptions: {
    
    setup({ dispatch, history }) { 
      history.listen((location) => {
      	const modelName = 'retailStoreMember'
      	const parameter = {dispatch,history,location,modelName}
        //console.log("setupModel",setupModel,typeof(setupModel))
      	setupModel(parameter)

      })
    },
  },
  effects: {
    *view({ payload }, { call, put, select }) { 
    
      const cachedData = yield select(state => state._retailStoreMember)
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
      
      const {RetailStoreMemberService} = GlobalComponents;
      const data = yield call(RetailStoreMemberService.view, payload.id)
      
      const displayName = payload.displayName||data.displayName
      
      
      yield put({ type: 'breadcrumb/gotoLink', payload: { displayName,link }} )
      

      yield put({ type: 'updateState', payload: data })
    },
    *load({ payload }, { call, put }) { 
      const {RetailStoreMemberService} = GlobalComponents;
      //yield put({ type: 'showLoading', payload })
      const data = yield call(RetailStoreMemberService.load, payload.id, payload.parameters)
      const newPlayload = { ...payload, ...data }
      
      console.log('this is the data id: ', data.id)
      yield put({ type: 'updateState', payload: newPlayload })
    },
    
    *doJob({ payload }, { call, put }) { 
<<<<<<< HEAD
=======
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {TaskService} = GlobalComponents;
      //yield put({ type: 'showLoading', payload })      
      const {serviceNameToCall, id, parameters} = payload;
      if(!serviceNameToCall){
<<<<<<< HEAD
      	handleClientError("没有提供后台服务的名字, 该服务没有注册")
      	return;
      }
      
=======
      	handleClientError(appLocaleName(userContext,'ServiceNotRegistered'))
      	return;
      }
      "react/dva_object_model.jsp"
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      
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
      yield put(routerRedux.push(`/retailStoreMember/${id}/list/${role}CreateForm`))
    },
    *gotoUpdateForm({ payload }, { put }) {
      const { id, role, selectedRows, currentUpdateIndex } = payload
      const state = { id, role, selectedRows, currentUpdateIndex }
      const location = { pathname: `/retailStoreMember/${id}/list/${role}UpdateForm`, state }
      yield put(routerRedux.push(location))
    },
    *goback({ payload }, { put }) {
      const { id, type,listName } = payload
      yield put(routerRedux.push(`/retailStoreMember/${id}/list/${type}List/${listName}`))
    },




    *addConsumerOrder({ payload }, { call, put }) {
<<<<<<< HEAD
=======
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {RetailStoreMemberService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreMemberService.addConsumerOrder, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/retailStoreMember/${id}/list/${role}CreateForm'))
<<<<<<< HEAD
      notification.success({
        message: '执行成功',
        description: '执行成功',
      })
=======
      notifySuccess(userContext)
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      if (continueNext) {
        return
      }
      const partialList = true
      const newState = {...data, partialList}
<<<<<<< HEAD
      const location = { pathname: `/retailStoreMember/${id}/list/\ConsumerOrderList/消费者订单列表`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateConsumerOrder({ payload }, { call, put }) {
=======
      const location = { pathname: `/retailStoreMember/${id}/list/ConsumerOrderList/消费者订单+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateConsumerOrder({ payload }, { call, put }) {
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {RetailStoreMemberService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreMemberService.updateConsumerOrder, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const partialList = true
      
      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex,partialList }
      yield put({ type: 'updateState', payload: newPlayload })
<<<<<<< HEAD
      notification.success({
        message: '执行成功',
        description: '执行成功',
      })
=======
      notifySuccess(userContext)
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      
      if (continueNext) {
        return
      }
<<<<<<< HEAD
      const location = { pathname: `/retailStoreMember/${id}/list/\ConsumerOrderList/消费者订单列表`, state: newPlayload }
=======
      const location = { pathname: `/retailStoreMember/${id}/list/ConsumerOrderList/消费者订单列表`, state: newPlayload }
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      yield put(routerRedux.push(location))
    },
    *gotoNextConsumerOrderUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeConsumerOrderList({ payload }, { call, put }) {
<<<<<<< HEAD
=======
     const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {RetailStoreMemberService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreMemberService.removeConsumerOrderList, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }

      yield put({ type: 'updateState', payload: newPlayload })
<<<<<<< HEAD
        
     
      notification.success({
        message: '执行成功',
        description: '执行成功',
      })

=======
      notifySuccess(userContext)
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    },




    *addRetailStoreMemberCoupon({ payload }, { call, put }) {
<<<<<<< HEAD
=======
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {RetailStoreMemberService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreMemberService.addRetailStoreMemberCoupon, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/retailStoreMember/${id}/list/${role}CreateForm'))
<<<<<<< HEAD
      notification.success({
        message: '执行成功',
        description: '执行成功',
      })
=======
      notifySuccess(userContext)
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      if (continueNext) {
        return
      }
      const partialList = true
      const newState = {...data, partialList}
<<<<<<< HEAD
      const location = { pathname: `/retailStoreMember/${id}/list/\RetailStoreMemberCouponList/生超会员优惠券列表`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateRetailStoreMemberCoupon({ payload }, { call, put }) {
=======
      const location = { pathname: `/retailStoreMember/${id}/list/RetailStoreMemberCouponList/生超会员优惠券+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateRetailStoreMemberCoupon({ payload }, { call, put }) {
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {RetailStoreMemberService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreMemberService.updateRetailStoreMemberCoupon, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const partialList = true
      
      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex,partialList }
      yield put({ type: 'updateState', payload: newPlayload })
<<<<<<< HEAD
      notification.success({
        message: '执行成功',
        description: '执行成功',
      })
=======
      notifySuccess(userContext)
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      
      if (continueNext) {
        return
      }
<<<<<<< HEAD
      const location = { pathname: `/retailStoreMember/${id}/list/\RetailStoreMemberCouponList/生超会员优惠券列表`, state: newPlayload }
=======
      const location = { pathname: `/retailStoreMember/${id}/list/RetailStoreMemberCouponList/生超会员优惠券列表`, state: newPlayload }
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      yield put(routerRedux.push(location))
    },
    *gotoNextRetailStoreMemberCouponUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeRetailStoreMemberCouponList({ payload }, { call, put }) {
<<<<<<< HEAD
=======
     const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {RetailStoreMemberService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreMemberService.removeRetailStoreMemberCouponList, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }

      yield put({ type: 'updateState', payload: newPlayload })
<<<<<<< HEAD
        
     
      notification.success({
        message: '执行成功',
        description: '执行成功',
      })

=======
      notifySuccess(userContext)
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    },




    *addMemberWishlist({ payload }, { call, put }) {
<<<<<<< HEAD
=======
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {RetailStoreMemberService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreMemberService.addMemberWishlist, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/retailStoreMember/${id}/list/${role}CreateForm'))
<<<<<<< HEAD
      notification.success({
        message: '执行成功',
        description: '执行成功',
      })
=======
      notifySuccess(userContext)
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      if (continueNext) {
        return
      }
      const partialList = true
      const newState = {...data, partialList}
<<<<<<< HEAD
      const location = { pathname: `/retailStoreMember/${id}/list/\MemberWishlistList/会员收藏列表`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateMemberWishlist({ payload }, { call, put }) {
=======
      const location = { pathname: `/retailStoreMember/${id}/list/MemberWishlistList/会员收藏+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateMemberWishlist({ payload }, { call, put }) {
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {RetailStoreMemberService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreMemberService.updateMemberWishlist, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const partialList = true
      
      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex,partialList }
      yield put({ type: 'updateState', payload: newPlayload })
<<<<<<< HEAD
      notification.success({
        message: '执行成功',
        description: '执行成功',
      })
=======
      notifySuccess(userContext)
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      
      if (continueNext) {
        return
      }
<<<<<<< HEAD
      const location = { pathname: `/retailStoreMember/${id}/list/\MemberWishlistList/会员收藏列表`, state: newPlayload }
=======
      const location = { pathname: `/retailStoreMember/${id}/list/MemberWishlistList/会员收藏列表`, state: newPlayload }
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      yield put(routerRedux.push(location))
    },
    *gotoNextMemberWishlistUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeMemberWishlistList({ payload }, { call, put }) {
<<<<<<< HEAD
=======
     const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {RetailStoreMemberService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreMemberService.removeMemberWishlistList, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }

      yield put({ type: 'updateState', payload: newPlayload })
<<<<<<< HEAD
        
     
      notification.success({
        message: '执行成功',
        description: '执行成功',
      })

=======
      notifySuccess(userContext)
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    },




    *addMemberRewardPoint({ payload }, { call, put }) {
<<<<<<< HEAD
=======
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {RetailStoreMemberService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreMemberService.addMemberRewardPoint, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/retailStoreMember/${id}/list/${role}CreateForm'))
<<<<<<< HEAD
      notification.success({
        message: '执行成功',
        description: '执行成功',
      })
=======
      notifySuccess(userContext)
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      if (continueNext) {
        return
      }
      const partialList = true
      const newState = {...data, partialList}
<<<<<<< HEAD
      const location = { pathname: `/retailStoreMember/${id}/list/\MemberRewardPointList/会员奖励点列表`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateMemberRewardPoint({ payload }, { call, put }) {
=======
      const location = { pathname: `/retailStoreMember/${id}/list/MemberRewardPointList/会员奖励点+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateMemberRewardPoint({ payload }, { call, put }) {
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {RetailStoreMemberService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreMemberService.updateMemberRewardPoint, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const partialList = true
      
      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex,partialList }
      yield put({ type: 'updateState', payload: newPlayload })
<<<<<<< HEAD
      notification.success({
        message: '执行成功',
        description: '执行成功',
      })
=======
      notifySuccess(userContext)
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      
      if (continueNext) {
        return
      }
<<<<<<< HEAD
      const location = { pathname: `/retailStoreMember/${id}/list/\MemberRewardPointList/会员奖励点列表`, state: newPlayload }
=======
      const location = { pathname: `/retailStoreMember/${id}/list/MemberRewardPointList/会员奖励点列表`, state: newPlayload }
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      yield put(routerRedux.push(location))
    },
    *gotoNextMemberRewardPointUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeMemberRewardPointList({ payload }, { call, put }) {
<<<<<<< HEAD
=======
     const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {RetailStoreMemberService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreMemberService.removeMemberRewardPointList, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }

      yield put({ type: 'updateState', payload: newPlayload })
<<<<<<< HEAD
        
     
      notification.success({
        message: '执行成功',
        description: '执行成功',
      })

=======
      notifySuccess(userContext)
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    },




    *addMemberRewardPointRedemption({ payload }, { call, put }) {
<<<<<<< HEAD
=======
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {RetailStoreMemberService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreMemberService.addMemberRewardPointRedemption, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/retailStoreMember/${id}/list/${role}CreateForm'))
<<<<<<< HEAD
      notification.success({
        message: '执行成功',
        description: '执行成功',
      })
=======
      notifySuccess(userContext)
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      if (continueNext) {
        return
      }
      const partialList = true
      const newState = {...data, partialList}
<<<<<<< HEAD
      const location = { pathname: `/retailStoreMember/${id}/list/\MemberRewardPointRedemptionList/会员奖励点赎回列表`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateMemberRewardPointRedemption({ payload }, { call, put }) {
=======
      const location = { pathname: `/retailStoreMember/${id}/list/MemberRewardPointRedemptionList/会员奖励点赎回+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateMemberRewardPointRedemption({ payload }, { call, put }) {
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {RetailStoreMemberService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreMemberService.updateMemberRewardPointRedemption, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const partialList = true
      
      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex,partialList }
      yield put({ type: 'updateState', payload: newPlayload })
<<<<<<< HEAD
      notification.success({
        message: '执行成功',
        description: '执行成功',
      })
=======
      notifySuccess(userContext)
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      
      if (continueNext) {
        return
      }
<<<<<<< HEAD
      const location = { pathname: `/retailStoreMember/${id}/list/\MemberRewardPointRedemptionList/会员奖励点赎回列表`, state: newPlayload }
=======
      const location = { pathname: `/retailStoreMember/${id}/list/MemberRewardPointRedemptionList/会员奖励点赎回列表`, state: newPlayload }
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      yield put(routerRedux.push(location))
    },
    *gotoNextMemberRewardPointRedemptionUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeMemberRewardPointRedemptionList({ payload }, { call, put }) {
<<<<<<< HEAD
=======
     const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {RetailStoreMemberService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreMemberService.removeMemberRewardPointRedemptionList, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }

      yield put({ type: 'updateState', payload: newPlayload })
<<<<<<< HEAD
        
     
      notification.success({
        message: '执行成功',
        description: '执行成功',
      })

=======
      notifySuccess(userContext)
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    },




    *addRetailStoreMemberAddress({ payload }, { call, put }) {
<<<<<<< HEAD
=======
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {RetailStoreMemberService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreMemberService.addRetailStoreMemberAddress, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/retailStoreMember/${id}/list/${role}CreateForm'))
<<<<<<< HEAD
      notification.success({
        message: '执行成功',
        description: '执行成功',
      })
=======
      notifySuccess(userContext)
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      if (continueNext) {
        return
      }
      const partialList = true
      const newState = {...data, partialList}
<<<<<<< HEAD
      const location = { pathname: `/retailStoreMember/${id}/list/\RetailStoreMemberAddressList/零售店会员地址列表`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateRetailStoreMemberAddress({ payload }, { call, put }) {
=======
      const location = { pathname: `/retailStoreMember/${id}/list/RetailStoreMemberAddressList/零售店会员地址+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateRetailStoreMemberAddress({ payload }, { call, put }) {
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {RetailStoreMemberService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreMemberService.updateRetailStoreMemberAddress, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const partialList = true
      
      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex,partialList }
      yield put({ type: 'updateState', payload: newPlayload })
<<<<<<< HEAD
      notification.success({
        message: '执行成功',
        description: '执行成功',
      })
=======
      notifySuccess(userContext)
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      
      if (continueNext) {
        return
      }
<<<<<<< HEAD
      const location = { pathname: `/retailStoreMember/${id}/list/\RetailStoreMemberAddressList/零售店会员地址列表`, state: newPlayload }
=======
      const location = { pathname: `/retailStoreMember/${id}/list/RetailStoreMemberAddressList/零售店会员地址列表`, state: newPlayload }
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      yield put(routerRedux.push(location))
    },
    *gotoNextRetailStoreMemberAddressUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeRetailStoreMemberAddressList({ payload }, { call, put }) {
<<<<<<< HEAD
=======
     const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {RetailStoreMemberService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreMemberService.removeRetailStoreMemberAddressList, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }

      yield put({ type: 'updateState', payload: newPlayload })
<<<<<<< HEAD
        
     
      notification.success({
        message: '执行成功',
        description: '执行成功',
      })

=======
      notifySuccess(userContext)
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
    },




    *addRetailStoreMemberGiftCard({ payload }, { call, put }) {
<<<<<<< HEAD
=======
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {RetailStoreMemberService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreMemberService.addRetailStoreMemberGiftCard, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/retailStoreMember/${id}/list/${role}CreateForm'))
<<<<<<< HEAD
      notification.success({
        message: '执行成功',
        description: '执行成功',
      })
=======
      notifySuccess(userContext)
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      if (continueNext) {
        return
      }
      const partialList = true
      const newState = {...data, partialList}
<<<<<<< HEAD
      const location = { pathname: `/retailStoreMember/${id}/list/\RetailStoreMemberGiftCardList/零售店会员礼品卡列表`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateRetailStoreMemberGiftCard({ payload }, { call, put }) {
=======
      const location = { pathname: `/retailStoreMember/${id}/list/RetailStoreMemberGiftCardList/零售店会员礼品卡+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateRetailStoreMemberGiftCard({ payload }, { call, put }) {
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {RetailStoreMemberService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreMemberService.updateRetailStoreMemberGiftCard, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const partialList = true
      
      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex,partialList }
      yield put({ type: 'updateState', payload: newPlayload })
<<<<<<< HEAD
      notification.success({
        message: '执行成功',
        description: '执行成功',
      })
=======
      notifySuccess(userContext)
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      
      if (continueNext) {
        return
      }
<<<<<<< HEAD
      const location = { pathname: `/retailStoreMember/${id}/list/\RetailStoreMemberGiftCardList/零售店会员礼品卡列表`, state: newPlayload }
=======
      const location = { pathname: `/retailStoreMember/${id}/list/RetailStoreMemberGiftCardList/零售店会员礼品卡列表`, state: newPlayload }
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      yield put(routerRedux.push(location))
    },
    *gotoNextRetailStoreMemberGiftCardUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeRetailStoreMemberGiftCardList({ payload }, { call, put }) {
<<<<<<< HEAD
=======
     const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {RetailStoreMemberService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(RetailStoreMemberService.removeRetailStoreMemberGiftCardList, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }

      yield put({ type: 'updateState', payload: newPlayload })
<<<<<<< HEAD
        
     
      notification.success({
        message: '执行成功',
        description: '执行成功',
      })

=======
      notifySuccess(userContext)
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
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

