
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

  namespace: '_employee',

  state: {},

  subscriptions: {
    
    setup({ dispatch, history }) { 
      history.listen((location) => {
      	const modelName = 'employee'
      	const parameter = {dispatch,history,location,modelName}
        //console.log("setupModel",setupModel,typeof(setupModel))
      	setupModel(parameter)

      })
    },
  },
  effects: {
    *view({ payload }, { call, put, select }) { 
    
      const cachedData = yield select(state => state._employee)
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
      
      const {EmployeeService} = GlobalComponents;
      const data = yield call(EmployeeService.view, payload.id)
      
      const displayName = payload.displayName||data.displayName
      
      
      yield put({ type: 'breadcrumb/gotoLink', payload: { displayName,link }} )
      

      yield put({ type: 'updateState', payload: data })
    },
    *load({ payload }, { call, put }) { 
      const {EmployeeService} = GlobalComponents;
      //yield put({ type: 'showLoading', payload })
      const data = yield call(EmployeeService.load, payload.id, payload.parameters)
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
      yield put(routerRedux.push(`/employee/${id}/list/${role}CreateForm`))
    },
    *gotoUpdateForm({ payload }, { put }) {
      const { id, role, selectedRows, currentUpdateIndex } = payload
      const state = { id, role, selectedRows, currentUpdateIndex }
      const location = { pathname: `/employee/${id}/list/${role}UpdateForm`, state }
      yield put(routerRedux.push(location))
    },
    *goback({ payload }, { put }) {
      const { id, type,listName } = payload
      yield put(routerRedux.push(`/employee/${id}/list/${type}List/${listName}`))
    },




    *addEmployeeCompanyTraining({ payload }, { call, put }) {
<<<<<<< HEAD
=======
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.addEmployeeCompanyTraining, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/employee/${id}/list/${role}CreateForm'))
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
      const location = { pathname: `/employee/${id}/list/\EmployeeCompanyTrainingList/员工参与的公司培训列表`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateEmployeeCompanyTraining({ payload }, { call, put }) {
=======
      const location = { pathname: `/employee/${id}/list/EmployeeCompanyTrainingList/员工参与的公司培训+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateEmployeeCompanyTraining({ payload }, { call, put }) {
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.updateEmployeeCompanyTraining, id, parameters)
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
      const location = { pathname: `/employee/${id}/list/\EmployeeCompanyTrainingList/员工参与的公司培训列表`, state: newPlayload }
=======
      const location = { pathname: `/employee/${id}/list/EmployeeCompanyTrainingList/员工参与的公司培训列表`, state: newPlayload }
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      yield put(routerRedux.push(location))
    },
    *gotoNextEmployeeCompanyTrainingUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeEmployeeCompanyTrainingList({ payload }, { call, put }) {
<<<<<<< HEAD
=======
     const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.removeEmployeeCompanyTrainingList, id, parameters)
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




    *addEmployeeSkill({ payload }, { call, put }) {
<<<<<<< HEAD
=======
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.addEmployeeSkill, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/employee/${id}/list/${role}CreateForm'))
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
      const location = { pathname: `/employee/${id}/list/\EmployeeSkillList/员工技能列表`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateEmployeeSkill({ payload }, { call, put }) {
=======
      const location = { pathname: `/employee/${id}/list/EmployeeSkillList/员工技能+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateEmployeeSkill({ payload }, { call, put }) {
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.updateEmployeeSkill, id, parameters)
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
      const location = { pathname: `/employee/${id}/list/\EmployeeSkillList/员工技能列表`, state: newPlayload }
=======
      const location = { pathname: `/employee/${id}/list/EmployeeSkillList/员工技能列表`, state: newPlayload }
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      yield put(routerRedux.push(location))
    },
    *gotoNextEmployeeSkillUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeEmployeeSkillList({ payload }, { call, put }) {
<<<<<<< HEAD
=======
     const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.removeEmployeeSkillList, id, parameters)
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




    *addEmployeePerformance({ payload }, { call, put }) {
<<<<<<< HEAD
=======
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.addEmployeePerformance, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/employee/${id}/list/${role}CreateForm'))
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
      const location = { pathname: `/employee/${id}/list/\EmployeePerformanceList/员工绩效列表`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateEmployeePerformance({ payload }, { call, put }) {
=======
      const location = { pathname: `/employee/${id}/list/EmployeePerformanceList/员工绩效+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateEmployeePerformance({ payload }, { call, put }) {
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.updateEmployeePerformance, id, parameters)
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
      const location = { pathname: `/employee/${id}/list/\EmployeePerformanceList/员工绩效列表`, state: newPlayload }
=======
      const location = { pathname: `/employee/${id}/list/EmployeePerformanceList/员工绩效列表`, state: newPlayload }
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      yield put(routerRedux.push(location))
    },
    *gotoNextEmployeePerformanceUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeEmployeePerformanceList({ payload }, { call, put }) {
<<<<<<< HEAD
=======
     const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.removeEmployeePerformanceList, id, parameters)
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




    *addEmployeeWorkExperience({ payload }, { call, put }) {
<<<<<<< HEAD
=======
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.addEmployeeWorkExperience, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/employee/${id}/list/${role}CreateForm'))
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
      const location = { pathname: `/employee/${id}/list/\EmployeeWorkExperienceList/员工工作经验列表`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateEmployeeWorkExperience({ payload }, { call, put }) {
=======
      const location = { pathname: `/employee/${id}/list/EmployeeWorkExperienceList/员工工作经验+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateEmployeeWorkExperience({ payload }, { call, put }) {
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.updateEmployeeWorkExperience, id, parameters)
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
      const location = { pathname: `/employee/${id}/list/\EmployeeWorkExperienceList/员工工作经验列表`, state: newPlayload }
=======
      const location = { pathname: `/employee/${id}/list/EmployeeWorkExperienceList/员工工作经验列表`, state: newPlayload }
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      yield put(routerRedux.push(location))
    },
    *gotoNextEmployeeWorkExperienceUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeEmployeeWorkExperienceList({ payload }, { call, put }) {
<<<<<<< HEAD
=======
     const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.removeEmployeeWorkExperienceList, id, parameters)
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




    *addEmployeeLeave({ payload }, { call, put }) {
<<<<<<< HEAD
=======
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.addEmployeeLeave, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/employee/${id}/list/${role}CreateForm'))
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
      const location = { pathname: `/employee/${id}/list/\EmployeeLeaveList/请假记录列表`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateEmployeeLeave({ payload }, { call, put }) {
=======
      const location = { pathname: `/employee/${id}/list/EmployeeLeaveList/请假记录+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateEmployeeLeave({ payload }, { call, put }) {
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.updateEmployeeLeave, id, parameters)
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
      const location = { pathname: `/employee/${id}/list/\EmployeeLeaveList/请假记录列表`, state: newPlayload }
=======
      const location = { pathname: `/employee/${id}/list/EmployeeLeaveList/请假记录列表`, state: newPlayload }
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      yield put(routerRedux.push(location))
    },
    *gotoNextEmployeeLeaveUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeEmployeeLeaveList({ payload }, { call, put }) {
<<<<<<< HEAD
=======
     const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.removeEmployeeLeaveList, id, parameters)
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




    *addEmployeeInterview({ payload }, { call, put }) {
<<<<<<< HEAD
=======
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.addEmployeeInterview, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/employee/${id}/list/${role}CreateForm'))
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
      const location = { pathname: `/employee/${id}/list/\EmployeeInterviewList/员工面试列表`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateEmployeeInterview({ payload }, { call, put }) {
=======
      const location = { pathname: `/employee/${id}/list/EmployeeInterviewList/员工面试+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateEmployeeInterview({ payload }, { call, put }) {
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.updateEmployeeInterview, id, parameters)
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
      const location = { pathname: `/employee/${id}/list/\EmployeeInterviewList/员工面试列表`, state: newPlayload }
=======
      const location = { pathname: `/employee/${id}/list/EmployeeInterviewList/员工面试列表`, state: newPlayload }
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      yield put(routerRedux.push(location))
    },
    *gotoNextEmployeeInterviewUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeEmployeeInterviewList({ payload }, { call, put }) {
<<<<<<< HEAD
=======
     const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.removeEmployeeInterviewList, id, parameters)
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




    *addEmployeeAttendance({ payload }, { call, put }) {
<<<<<<< HEAD
=======
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.addEmployeeAttendance, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/employee/${id}/list/${role}CreateForm'))
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
      const location = { pathname: `/employee/${id}/list/\EmployeeAttendanceList/员工考勤列表`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateEmployeeAttendance({ payload }, { call, put }) {
=======
      const location = { pathname: `/employee/${id}/list/EmployeeAttendanceList/员工考勤+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateEmployeeAttendance({ payload }, { call, put }) {
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.updateEmployeeAttendance, id, parameters)
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
      const location = { pathname: `/employee/${id}/list/\EmployeeAttendanceList/员工考勤列表`, state: newPlayload }
=======
      const location = { pathname: `/employee/${id}/list/EmployeeAttendanceList/员工考勤列表`, state: newPlayload }
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      yield put(routerRedux.push(location))
    },
    *gotoNextEmployeeAttendanceUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeEmployeeAttendanceList({ payload }, { call, put }) {
<<<<<<< HEAD
=======
     const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.removeEmployeeAttendanceList, id, parameters)
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




    *addEmployeeQualifier({ payload }, { call, put }) {
<<<<<<< HEAD
=======
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.addEmployeeQualifier, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/employee/${id}/list/${role}CreateForm'))
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
      const location = { pathname: `/employee/${id}/list/\EmployeeQualifierList/员工资质列表`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateEmployeeQualifier({ payload }, { call, put }) {
=======
      const location = { pathname: `/employee/${id}/list/EmployeeQualifierList/员工资质+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateEmployeeQualifier({ payload }, { call, put }) {
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.updateEmployeeQualifier, id, parameters)
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
      const location = { pathname: `/employee/${id}/list/\EmployeeQualifierList/员工资质列表`, state: newPlayload }
=======
      const location = { pathname: `/employee/${id}/list/EmployeeQualifierList/员工资质列表`, state: newPlayload }
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      yield put(routerRedux.push(location))
    },
    *gotoNextEmployeeQualifierUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeEmployeeQualifierList({ payload }, { call, put }) {
<<<<<<< HEAD
=======
     const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.removeEmployeeQualifierList, id, parameters)
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




    *addEmployeeEducation({ payload }, { call, put }) {
<<<<<<< HEAD
=======
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.addEmployeeEducation, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/employee/${id}/list/${role}CreateForm'))
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
      const location = { pathname: `/employee/${id}/list/\EmployeeEducationList/员工教育列表`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateEmployeeEducation({ payload }, { call, put }) {
=======
      const location = { pathname: `/employee/${id}/list/EmployeeEducationList/员工教育+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateEmployeeEducation({ payload }, { call, put }) {
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.updateEmployeeEducation, id, parameters)
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
      const location = { pathname: `/employee/${id}/list/\EmployeeEducationList/员工教育列表`, state: newPlayload }
=======
      const location = { pathname: `/employee/${id}/list/EmployeeEducationList/员工教育列表`, state: newPlayload }
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      yield put(routerRedux.push(location))
    },
    *gotoNextEmployeeEducationUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeEmployeeEducationList({ payload }, { call, put }) {
<<<<<<< HEAD
=======
     const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.removeEmployeeEducationList, id, parameters)
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




    *addEmployeeAward({ payload }, { call, put }) {
<<<<<<< HEAD
=======
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.addEmployeeAward, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/employee/${id}/list/${role}CreateForm'))
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
      const location = { pathname: `/employee/${id}/list/\EmployeeAwardList/员工嘉奖列表`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateEmployeeAward({ payload }, { call, put }) {
=======
      const location = { pathname: `/employee/${id}/list/EmployeeAwardList/员工嘉奖+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateEmployeeAward({ payload }, { call, put }) {
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.updateEmployeeAward, id, parameters)
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
      const location = { pathname: `/employee/${id}/list/\EmployeeAwardList/员工嘉奖列表`, state: newPlayload }
=======
      const location = { pathname: `/employee/${id}/list/EmployeeAwardList/员工嘉奖列表`, state: newPlayload }
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      yield put(routerRedux.push(location))
    },
    *gotoNextEmployeeAwardUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeEmployeeAwardList({ payload }, { call, put }) {
<<<<<<< HEAD
=======
     const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.removeEmployeeAwardList, id, parameters)
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




    *addEmployeeSalarySheet({ payload }, { call, put }) {
<<<<<<< HEAD
=======
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.addEmployeeSalarySheet, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/employee/${id}/list/${role}CreateForm'))
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
      const location = { pathname: `/employee/${id}/list/\EmployeeSalarySheetList/工资单列表`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateEmployeeSalarySheet({ payload }, { call, put }) {
=======
      const location = { pathname: `/employee/${id}/list/EmployeeSalarySheetList/工资单+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateEmployeeSalarySheet({ payload }, { call, put }) {
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.updateEmployeeSalarySheet, id, parameters)
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
      const location = { pathname: `/employee/${id}/list/\EmployeeSalarySheetList/工资单列表`, state: newPlayload }
=======
      const location = { pathname: `/employee/${id}/list/EmployeeSalarySheetList/工资单列表`, state: newPlayload }
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      yield put(routerRedux.push(location))
    },
    *gotoNextEmployeeSalarySheetUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeEmployeeSalarySheetList({ payload }, { call, put }) {
<<<<<<< HEAD
=======
     const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.removeEmployeeSalarySheetList, id, parameters)
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




    *addPayingOff({ payload }, { call, put }) {
<<<<<<< HEAD
=======
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.addPayingOff, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/employee/${id}/list/${role}CreateForm'))
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
      const location = { pathname: `/employee/${id}/list/\PayingOffList/工资支付列表`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updatePayingOff({ payload }, { call, put }) {
=======
      const location = { pathname: `/employee/${id}/list/PayingOffList/工资支付+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updatePayingOff({ payload }, { call, put }) {
      const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.updatePayingOff, id, parameters)
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
      const location = { pathname: `/employee/${id}/list/\PayingOffList/工资支付列表`, state: newPlayload }
=======
      const location = { pathname: `/employee/${id}/list/PayingOffList/工资支付列表`, state: newPlayload }
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      yield put(routerRedux.push(location))
    },
    *gotoNextPayingOffUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removePayingOffList({ payload }, { call, put }) {
<<<<<<< HEAD
=======
     const userContext = null
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
      const {EmployeeService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(EmployeeService.removePayingOffList, id, parameters)
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

