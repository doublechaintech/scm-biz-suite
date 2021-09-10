export default {
  pages: [
    'pages/home/home-page',
    'pages/service-center/service-center-page',
    'pages/me/me-page',
    'pages/test-page',
    'pages/code-scan/code-scan-page',
    // 'pages/biz/listof-test-page', // 有问题

    // base
    'nice-router/h5-page',
    'nice-router/network-exception-page',

    'listof/listof-page',
    'listof/listof-page2',
    'listof/listof-page3',
    'listof/listof-page4',
    'listof/listof-page5',
    //biz
    'pages/login/login-page',
    'pages/detail/detail-page',
    'pages/detail/detail-page2',
    'pages/detail/detail-page3',
    'pages/detail/detail-page4',
    'pages/detail/detail-page5',
  ],
  subPackages: [
    {
      root: 'genericpage/',
      name: 'genericpage',
      pages: ['generic-page', 'generic-page2'],
    },
    {
      root: 'genericform/',
      name: 'genericform',
      pages: ['genericform-page', 'object-picker-page'],
    },
  ],

  // permission: {
  //   'scope.userLocation': {
  //     desc: '你的位置信息将用于小程序位置接口的效果展示',
  //   },
  // },
  window: {
    backgroundTextStyle: 'light',
    navigationBarBackgroundColor: '#28aaff',
    navigationBarTitleText: 'nice-router',
    navigationBarTextStyle: 'white',
    enablePullDownRefresh: true,
  },
  tabBar: {
    color: '#666',
    selectedColor: '#28aaff',
    backgroundColor: '#fafafa',
    borderStyle: 'black',
    list: [
      {
        pagePath: 'pages/home/home-page',
        iconPath: './assets/icon/icon_home_n@2x.png',
        selectedIconPath: './assets/icon/icon_home_s@2x.png',
        text: '首页',
      },

      {
        pagePath: 'pages/service-center/service-center-page',
        iconPath: './assets/icon/icon_service_n@2x.png',
        selectedIconPath: './assets/icon/icon_service_s@2x.png',
        text: '功能大厅',
      },

      {
        pagePath: 'pages/me/me-page',
        iconPath: './assets/icon/icon_me_n@2x.png',
        selectedIconPath: './assets/icon/icon_me_s@2x.png',
        text: '我的',
      },
    ],
  },
};
