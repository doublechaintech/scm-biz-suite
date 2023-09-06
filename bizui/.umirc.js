// ref: https://umijs.org/config/
//mfsu: {}, not working with material design
import { chainWebpack } from './chain-webpack';
//http://192.168.3.145:8082/v1
export default {
  publicPath: './',
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
      //'target': 'https://cmstest.ggas.com/cmes/', //这是 服务端域名
      //'target': 'https://cmstest.ggas.com/cmes/', //这是 服务端域名
      //'target': 'http://iot.tuopaishede.cn:8080/cmes/', //这是 服务端域名
      //'target': 'https://cms4g-dev.think-to.com/cmes/', //这是 服务端域名
      //'target': 'https://cms4g.think-to.com/cmes/', //这是 服务端域名
      target: 'https://s.p4j.cn:8233/retailscm', //这是 服务端域名
      changeOrigin: true, //允许域名进行转换
      pathRewrite: { '^/retailscm': '' }, //将请求url里的ci去掉
    },
  },

  chainWebpack,
  plugins: [],
};
