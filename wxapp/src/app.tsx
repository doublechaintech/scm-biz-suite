import React from 'react';
import { noop } from '@/nice-router/nice-router-util';
import { isH5, isWeapp } from '@/utils/index';
import Taro from '@tarojs/taro';
import { Provider } from 'react-redux';

import './app.scss';
import dva from './dva';
import models from './models/model-center';
import Config from '@/nice-router/nice-router.config';
import { TheCustomizedProjectConfigurationDontUseItDirectly } from './utils/config';

// 如果需要在 h5 环境中开启 React Devtools
// 取消以下注释：
// if (isDevEnv() && isH5()) {
//   require('nerv-devtools')
// }

if (isH5()) {
  // h5中useShareAppMessage不支持，临时设置不报错处理
  // TODO  未来某个版本可能会支持share，再移除
  if (!Taro.useShareAppMessage) {
    Taro.useShareAppMessage = noop;
  }
}

const dvaApp = dva.createApp({
  initialState: {},
  enableLog: false,
  models: models,
});
const store = dvaApp.getStore();

// do initial
Config.start && Config.start(TheCustomizedProjectConfigurationDontUseItDirectly, dvaApp);

// end initial

class App extends React.Component {
  componentDidMount() {
    if (isWeapp()) {
      this.updateWeapp();
    }
  }

  updateWeapp = () => {
    if (Taro.canIUse('getUpdateManager')) {
      const updateManager = Taro.getUpdateManager();
      updateManager.onCheckForUpdate(() => {
        console.log('checking app update .......');
      });
      updateManager.onUpdateReady(() => {
        // noinspection JSIgnoredPromiseFromCall
        Taro.showModal({
          title: '更新提示',
          content: '新版本已经准备好，是否重启应用？',
          success: function(res) {
            if (res.confirm) {
              updateManager.applyUpdate();
            }
          },
        });
      });
      updateManager.onUpdateFailed(() => {
        // noinspection JSIgnoredPromiseFromCall
        Taro.showModal({
          title: '更新提示',
          content: '新版本下载失败，请检查你的微信',
          showCancel: false,
        });
      });
    } else {
      // noinspection JSIgnoredPromiseFromCall
      Taro.showModal({
        title: '微信升级',
        content: '当前微信版本过低，部分功能无法使用，请升级到最新版本',
        showCancel: false,
      });
    }
  };

  // 在 App 类中的 render() 函数没有实际作用
  // 请勿修改此函数
  render() {
    return <Provider store={store}> {this.props.children} </Provider>;
  }
}

export default App;
