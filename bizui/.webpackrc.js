const path = require('path');

export default {
  entry: 'src/index.js',
  extraBabelPlugins: [['import', { libraryName: 'antd', libraryDirectory: 'es', style: true }]],
  env: {
    development: {
      extraBabelPlugins: ['dva-hmr'],
    },
  },
  alias: {
    components: path.resolve(__dirname, 'src/components/'),
  },
  ignoreMomentLocale: true,
  theme: './src/theme.js',
  html: {
    template: './src/index.ejs',
  },
  disableDynamicImport: true,
  publicPath: '',
  hash: true,

  proxy: {
    '/v1/': {
      //ci可以自定义名称
      target: 'http://192.168.3.112:8082/v1/', //这是 服务端域名
      changeOrigin: true, //允许域名进行转换
      pathRewrite: { '^/v1': '' }, //将请求url里的ci去掉
    },
    '/retailscm/': {
      //ci可以自定义名称
      target: 'http://s.p4j.cn:8233/retailscm', //这是 服务端域名
      changeOrigin: true, //允许域名进行转换
      pathRewrite: { '^/retailscm': '' }, //将请求url里的ci去掉
    },
  },
};
