
import pathToRegexp from 'path-to-regexp';
import { routerRedux } from 'dva/router';
import { notification } from 'antd';
// import key from 'keymaster';
import CommunityService from './Community.service';



const hasError = (data) => {
  if (!data.class) {
    return false;
  }
  if (data.class.indexOf('Exception') > 0) {
    return true;
  }
  if (data.class.indexOf('LoginForm') > 0) {
    return true;
  }
  return false;
};

const handleServerError = (data) => {
  if (data.message) {
    notification.error({
      message: data.message,
      description: data.message,
    });
    return;
  }
  if (data.messageList[0]) {
    // console.error('error ', data.messageList[0].sourcePosition);
    notification.error({
      message: data.messageList[0].sourcePosition,
      description: data.messageList[0].body,
    });
  }
};

export default {

  namespace: '_community',

  state: {},

  subscriptions: {
    
    setup({ dispatch, history }) { 
      history.listen((location) => {
        const { pathname } = location;
        if (!pathname.startsWith('/community')) {
          return;
        }
        const newstate = location.state;
        if (newstate) {
          dispatch({ type: 'updateState', payload: newstate });
          return;
        }
        const dashboardmatch = pathToRegexp('/community/:id/dashboard').exec(pathname);
        if (dashboardmatch) {
          const id = dashboardmatch[1];
          dispatch({ type: 'view', payload: { id } });
          return;
        }
        const editDetailMatch = pathToRegexp('/community/:id/editDetail').exec(pathname);
        if (editDetailMatch) {
          const id = editDetailMatch[1];
          dispatch({ type: 'view', payload: { id } });
          return;
        }
        const match = pathToRegexp('/community/:id/list/:listName').exec(pathname);
        if (!match) {
          return;
          //  dispatch action with userId
        }
        const id = match[1];
        dispatch({ type: 'view', payload: { id } });
      });
    },
  },
  effects: {
    *view({ payload }, { call, put }) { 
      yield put({ type: 'showLoading', payload });
      const data = yield call(CommunityService.view, payload.id);
      console.log('this is the data id:', data.id);
      yield put({ type: 'updateState', payload: data });
    },
    *load({ payload }, { call, put }) { 
      yield put({ type: 'showLoading', payload });
      const data = yield call(CommunityService.load, payload.id, payload.parameters);
      
      const newPlayload = { ...payload, ...data };
      
      console.log('this is the data id: ', data.id);
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *gotoCreateForm({ payload }, { put }) {
      const { id, type } = payload;
      yield put(routerRedux.push(`/community/${id}/list/${type}CreateForm`));
    },
    *gotoUpdateForm({ payload }, { put }) {
      const { id, type, selectedRows, currentUpdateIndex } = payload;
      const state = { id, type, selectedRows, currentUpdateIndex };
      const location = { pathname: `/community/${id}/list/${type}UpdateForm`, state };
      yield put(routerRedux.push(location));
    },
    *goback({ payload }, { put }) {
      const { id, type } = payload;
      yield put(routerRedux.push(`/community/${id}/list/${type}List`));
    },

    *addInvitationCode({ payload }, { call, put }) {
      const { id, type, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.addInvitationCode, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/community/${id}/list/${type}CreateForm'));
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
      if (continueNext) {
        return;
      }
      const location = { pathname: `/community/${id}/list/${type}List`, state: data };
      yield put(routerRedux.push(location));
    },
    *updateInvitationCode({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.updateInvitationCode, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
        
      if (continueNext) {
        return;
      }
      const location = { pathname: `/community/${id}/list/${type}List`, state: newPlayload };
      yield put(routerRedux.push(location));
    },
    *gotoNextInvitationCodeUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removeInvitationCodeList({ payload }, { call, put }) {
      const { id, type, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.removeInvitationCodeList, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
        
      // yield put(routerRedux.push(`/community/${id}/list/${type}CreateForm`));
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
      // const location = { pathname: `community/${id}/list/${type}List`, state: data};
      // yield put(routerRedux.push(location));
    },

    *addHomePage({ payload }, { call, put }) {
      const { id, type, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.addHomePage, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/community/${id}/list/${type}CreateForm'));
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
      if (continueNext) {
        return;
      }
      const location = { pathname: `/community/${id}/list/${type}List`, state: data };
      yield put(routerRedux.push(location));
    },
    *updateHomePage({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.updateHomePage, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
        
      if (continueNext) {
        return;
      }
      const location = { pathname: `/community/${id}/list/${type}List`, state: newPlayload };
      yield put(routerRedux.push(location));
    },
    *gotoNextHomePageUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removeHomePageList({ payload }, { call, put }) {
      const { id, type, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.removeHomePageList, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
        
      // yield put(routerRedux.push(`/community/${id}/list/${type}CreateForm`));
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
      // const location = { pathname: `community/${id}/list/${type}List`, state: data};
      // yield put(routerRedux.push(location));
    },

    *addEncyclopediaItem({ payload }, { call, put }) {
      const { id, type, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.addEncyclopediaItem, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/community/${id}/list/${type}CreateForm'));
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
      if (continueNext) {
        return;
      }
      const location = { pathname: `/community/${id}/list/${type}List`, state: data };
      yield put(routerRedux.push(location));
    },
    *updateEncyclopediaItem({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.updateEncyclopediaItem, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
        
      if (continueNext) {
        return;
      }
      const location = { pathname: `/community/${id}/list/${type}List`, state: newPlayload };
      yield put(routerRedux.push(location));
    },
    *gotoNextEncyclopediaItemUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removeEncyclopediaItemList({ payload }, { call, put }) {
      const { id, type, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.removeEncyclopediaItemList, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
        
      // yield put(routerRedux.push(`/community/${id}/list/${type}CreateForm`));
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
      // const location = { pathname: `community/${id}/list/${type}List`, state: data};
      // yield put(routerRedux.push(location));
    },

    *addTaskPage({ payload }, { call, put }) {
      const { id, type, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.addTaskPage, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/community/${id}/list/${type}CreateForm'));
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
      if (continueNext) {
        return;
      }
      const location = { pathname: `/community/${id}/list/${type}List`, state: data };
      yield put(routerRedux.push(location));
    },
    *updateTaskPage({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.updateTaskPage, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
        
      if (continueNext) {
        return;
      }
      const location = { pathname: `/community/${id}/list/${type}List`, state: newPlayload };
      yield put(routerRedux.push(location));
    },
    *gotoNextTaskPageUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removeTaskPageList({ payload }, { call, put }) {
      const { id, type, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.removeTaskPageList, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
        
      // yield put(routerRedux.push(`/community/${id}/list/${type}CreateForm`));
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
      // const location = { pathname: `community/${id}/list/${type}List`, state: data};
      // yield put(routerRedux.push(location));
    },

    *addCommunityUser({ payload }, { call, put }) {
      const { id, type, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.addCommunityUser, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/community/${id}/list/${type}CreateForm'));
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
      if (continueNext) {
        return;
      }
      const location = { pathname: `/community/${id}/list/${type}List`, state: data };
      yield put(routerRedux.push(location));
    },
    *updateCommunityUser({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.updateCommunityUser, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
        
      if (continueNext) {
        return;
      }
      const location = { pathname: `/community/${id}/list/${type}List`, state: newPlayload };
      yield put(routerRedux.push(location));
    },
    *gotoNextCommunityUserUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removeCommunityUserList({ payload }, { call, put }) {
      const { id, type, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.removeCommunityUserList, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
        
      // yield put(routerRedux.push(`/community/${id}/list/${type}CreateForm`));
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
      // const location = { pathname: `community/${id}/list/${type}List`, state: data};
      // yield put(routerRedux.push(location));
    },

    *addTask({ payload }, { call, put }) {
      const { id, type, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.addTask, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/community/${id}/list/${type}CreateForm'));
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
      if (continueNext) {
        return;
      }
      const location = { pathname: `/community/${id}/list/${type}List`, state: data };
      yield put(routerRedux.push(location));
    },
    *updateTask({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.updateTask, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
        
      if (continueNext) {
        return;
      }
      const location = { pathname: `/community/${id}/list/${type}List`, state: newPlayload };
      yield put(routerRedux.push(location));
    },
    *gotoNextTaskUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removeTaskList({ payload }, { call, put }) {
      const { id, type, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.removeTaskList, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
        
      // yield put(routerRedux.push(`/community/${id}/list/${type}CreateForm`));
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
      // const location = { pathname: `community/${id}/list/${type}List`, state: data};
      // yield put(routerRedux.push(location));
    },

    *addGroupPage({ payload }, { call, put }) {
      const { id, type, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.addGroupPage, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/community/${id}/list/${type}CreateForm'));
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
      if (continueNext) {
        return;
      }
      const location = { pathname: `/community/${id}/list/${type}List`, state: data };
      yield put(routerRedux.push(location));
    },
    *updateGroupPage({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.updateGroupPage, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
        
      if (continueNext) {
        return;
      }
      const location = { pathname: `/community/${id}/list/${type}List`, state: newPlayload };
      yield put(routerRedux.push(location));
    },
    *gotoNextGroupPageUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removeGroupPageList({ payload }, { call, put }) {
      const { id, type, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.removeGroupPageList, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
        
      // yield put(routerRedux.push(`/community/${id}/list/${type}CreateForm`));
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
      // const location = { pathname: `community/${id}/list/${type}List`, state: data};
      // yield put(routerRedux.push(location));
    },

    *addThread({ payload }, { call, put }) {
      const { id, type, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.addThread, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/community/${id}/list/${type}CreateForm'));
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
      if (continueNext) {
        return;
      }
      const location = { pathname: `/community/${id}/list/${type}List`, state: data };
      yield put(routerRedux.push(location));
    },
    *updateThread({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.updateThread, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
        
      if (continueNext) {
        return;
      }
      const location = { pathname: `/community/${id}/list/${type}List`, state: newPlayload };
      yield put(routerRedux.push(location));
    },
    *gotoNextThreadUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removeThreadList({ payload }, { call, put }) {
      const { id, type, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(CommunityService.removeThreadList, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
        
      // yield put(routerRedux.push(`/community/${id}/list/${type}CreateForm`));
      notification.success({
        message: '执行成功',
        description: '执行成功',
      });
      // const location = { pathname: `community/${id}/list/${type}List`, state: data};
      // yield put(routerRedux.push(location));
    },

  },
  
  reducers: {
    updateState(state, action) {
      const payload = { ...action.payload, loading: false };
      return { ...payload };
    },
    showLoading(state, action) {
      // const loading=true;
      const payload = { ...action.payload, loading: true };
      return { ...payload };
    },
  },
};

