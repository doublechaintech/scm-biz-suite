import ActionCenterService from './ActionCenter.service'
import { notification } from 'antd'
export default {

    namespace: 'actioncenter',
  
    state: {},
  
    subscriptions: {
      
      setup({ dispatch, history }) { 
        
      },
    },
    effects: {
      *executeAction({ payload }, { call, put }) { 
        //const {ProvinceService} = GlobalComponents;
        const {action, url,successAction}= payload
        if(!url){
            return
        }
       // yield put({ type: 'showLoading', payload })
        const data = yield call(ActionCenterService.execute, payload.url)
        console.log("action center received data",data) 
        //const {successAction} = payload.successAction
        notification.success({
            message: `${action.actionName}成功`,
            description: `${action.actionName}执行成功`,
          })
        yield put(successAction)



        
      },
      
  
    },
    
    reducers: {
      updateState(state, action) {
        const payload = { ...action.payload, loading: false }
        return { ...payload }
      },
      
    },
  }
  
  
  
  
  
  
  
  