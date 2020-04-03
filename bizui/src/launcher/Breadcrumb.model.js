import { routerRedux } from 'dva/router';
import key from 'keymaster';
import { sessionObject } from '../utils/utils';

// console.log("element", )
import defaultLocaleName from './Launcher.locale';
const launcherLocaleName = defaultLocaleName; //you can define your version here to replace default

const userContext = {};

let currentLocation = '';

const hasLinkInArray = (breadcrumbArray, link) => {
  const result = breadcrumbArray.filter(item => item.link == link);

  return result.length > 0;
};

export default {
  namespace: 'breadcrumb',

  state: {
    currentApp: 'app1',
    app1: [{ name: launcherLocaleName(userContext, 'Platform'), link: '/' }],
    menuData: {},
    returnURL: null,
  },

  subscriptions: {},
  effects: {
    *jumpToLink({ payload }, { call, put, select }) {

      const {name,link}=payload
      console.log("jump to link", payload)
      yield put({ type: 'gotoLink', payload: {name,link} })
      yield put(routerRedux.push(link))
      
    },


  },
  reducers: {
    updateState(state, action) {
      return { ...state, ...action.payload };
    },
    removeLink(state, action){
      
      const targetApp = sessionObject('targetApp');
      const oldBreadcrumb = sessionObject(targetApp.id);
      const {link} = action.payload;
      console.log("trying to remove link ", link)
      const currentBreadcrumb = oldBreadcrumb.filter(item => item.link !== link);
      sessionObject(targetApp.id, currentBreadcrumb);
      return { ...state }
    },
    gotoLink(state, action) {
      
      const targetApp = sessionObject('targetApp');
      const storedBreadcrumb = sessionObject(targetApp.id);

      // const appdata=state[state.currentApp];
      if (!storedBreadcrumb) {
        return state;
      }
      const {link} = action.payload;
      const currentBreadcrumb = storedBreadcrumb.map(item=>(
        { ...item, selected: (item.link === link)}
      ))
      console.log("gotoLink", action.payload,currentBreadcrumb)
     
      let {returnURL} = state;
      if (link && link.indexOf('/list/') > 0 && link.indexOf('/cache') < 0) {
        returnURL = link + '/cache';
      }

      const name = action.payload.displayName;

      const index = currentBreadcrumb.findIndex(item => item.link === link);
      console.log('index', index);
      const selected = true
      if (index < 0) {
        currentBreadcrumb.push({ name, link, selected });
        sessionObject(targetApp.id, currentBreadcrumb);
        return { ...state, returnURL };
      }

      sessionObject(targetApp.id, currentBreadcrumb);
      
      // const newBreadcrumb = currentBreadcrumb.slice(0, index + 1);
      // sessionObject(targetApp.id, newBreadcrumb);
      // const newBreadcrumb = currentBreadcrumb.slice(0, index + 1);
      // sessionObject(targetApp.id, newBreadcrumb);
      return { ...state, returnURL , selectedIndex:index};
    },
    selectApp(state, action) {
      console.log(action);
      //const targetAppExpr = sessionStorage.getItem('targetApp');
      const targetApp = action.payload.targetApp;
      const menuData = action.payload.menuData;
      const location = action.payload.location.pathname;

      if (!targetApp) {
        return state;
      }

      const currentBreadcrumb = sessionObject(targetApp.id) || [];

      //this is a new app
      sessionObject('targetApp', targetApp);
      sessionObject('menuData', menuData);

      const name = targetApp.title;
      const link = location;
      const currentAppKey = targetApp.id;
      const index = currentBreadcrumb.findIndex(item => item.link == link);
      if (index < 0) {
        currentBreadcrumb.push({ name, link });
        sessionObject(currentAppKey, currentBreadcrumb);
      }

      return { ...state, targetApp, menuData };
    },
  },
};
