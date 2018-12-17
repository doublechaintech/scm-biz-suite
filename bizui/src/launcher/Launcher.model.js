
import { routerRedux } from 'dva/router'
import key from 'keymaster'
import { notification } from 'antd'
import LauncherService from './Launcher.service'
import GlobalComponents from '../custcomponents'
import SystemConfig  from '../axios/config'

let currentLocation = ''

export default {

  namespace: 'launcher',

  state: { loggedIn: false, name: 'Philip', systemName: SystemConfig.SYSTEM_LOCAL_NAME },


  subscriptions: {
    keyboard({ dispatch }) {
      key('escape', () => {
        if (currentLocation === '/home') {
          return
        }

        const newlocation = { pathname: '/home' }

        dispatch(routerRedux.push(newlocation))
      })
    },
    timer({ dispatch }){

      setInterval(()=>{

        //dispatch({type:"showlog"})

      }, 3000);
    },
    setup({ history }) {
      history.listen((location) => {
        currentLocation = location.pathname
        const { pathname } = location
        // const match = pathToRegexp('/communityApp/:tail').exec(path)
        if (!pathname === ('/') || !pathname.startsWith('/home')) {
          return
          // dispatch action with userId
        }
        console.log('launcher ==============>', location)
        // updateState
        // console.log(1, loggedIn)
        // dispatch({type:"showlogin"})
      })
    },
  },
  effects: {
    *showlog({ payload }, { call, put,select }){
      const loggedIn = yield select(state => state.launcher.loggedIn)
      if(!loggedIn){
        return
      }

      const data = yield call(LauncherService.checkOtherLogin)
      if(data=="OK"){
        //donothing
        return
      }
      if(data=="PROCEED"){
        //donothing
        return
      }
      notification.warn({
        message: '警告',
        description: data
      }) 

    },
    *login({ payload }, { call, put }) {
      const {calcLocationPath,calcMenuData} = GlobalComponents
      const data = yield call(LauncherService.login, payload.username, payload.password)
      console.log('data.........................', data)
      if (!data) {
        notification.warn({
          message: '登录出错',
          description: '用户名/密码出错, 请尝试重新登录'
        }) 
        return
      }
      if (!data.class) {
        notification.warn({
          message: '登录出错',
          description: '用户名/密码出错, 请尝试重新登录'
        }) 
        return
      }
      if (data.class.indexOf('LoginForm') > 0) {
        yield put({ type: 'showlogin', payload: { data } })
        notification.warn({
          message: '登录出错',
          description: '用户名/密码出错, 请尝试重新登录'
        }) 

        return
      }
      if (data.class.indexOf('SecUser') > 0) {
        yield put({ type: 'showhome', payload: { data } })
        return
      }
      const locationPath = calcLocationPath(data.class, data.id, 'dashboard')
      const location = { pathname: `/${locationPath}`, state: data }
      yield put(routerRedux.push(location))
    },
    *gotoApp({ payload }, { call, put }) {
      // console.log("gotoApp has been called", payload)
      const {calcLocationPath,calcMenuData} = GlobalComponents
      const data = yield call(LauncherService.gotoApp, payload.app.id)
      const locationPath = calcLocationPath(data.class, data.id, 'dashboard')
      const location = { pathname: `/${locationPath}`, state: data }
      const targetApp=payload.app;
      console.log('location', location)
      const menuData = calcMenuData(data.class);
      yield put({ type: 'breadcrumb/selectApp', payload: { targetApp,location, menuData} })
      
      yield put(routerRedux.push(location))
      // yield put({type:"showApp",payload:{data}})
    },
    *signOut({ payload }, { call, put }) {
      // console.log("gotoApp has been called", payload)
      const data = yield call(LauncherService.logout)
     
      yield put({ type: 'logout', payload: { data} })
      const location = { pathname: `/home`, state: data }
      yield put(routerRedux.push(location))
     
      // yield put({type:"showApp",payload:{data}})
    },
  },
  reducers: {
    updateState(state, action) {
      return { ...state, ...action.payload }
    },
    showlogin(state) {
      return { ...state, loggedIn: false }
    },
    showhome(state, action) {
      const { data } = action.payload
      return { ...state, loggedIn: true, data }
    },
    logout(state) {
      return { ...state, loggedIn: false }
    },
    showApp(state, action) {
      const { data } = action.payload
      const clazz = data.class

      presentApp(clazz, data)
      return { ...state, loggedIn: true, clazz, data }
    },
  },


}














