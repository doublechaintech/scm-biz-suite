import axios from 'axios';
import moment from 'moment';
import { message } from 'antd';
export const joinParameters = (parameters) => {
    const obj = parameters // {value1: 'prop1', value2: 'prop2', value3: 'prop3'}
    const arr = []
    for (const key in obj) {
        if (obj.hasOwnProperty(key)) {
            arr.push(`${key}=${encodeURIComponent(obj[key])}`)
        }
    }
    const result = arr.join(';')
    return result
}
const formatPostData = (value) => {
    
  
    if (typeof value == 'undefined'){
      return null
    }
    if(value==null){
      return null
    }

    if(value._isAMomentObject){
        return moment(value).format('YYYY-MM-DDTHH:mm:ss');
    }
    
  
    return value
}
export const joinPostParameters = (parameters) => {
    const obj = parameters // {value1: 'prop1', value2: 'prop2', value3: 'prop3'}
    console.log("joinPostParameters",parameters)
    const arr = []
    for (const key in obj) {
        if (obj.hasOwnProperty(key)) {
            const value = obj[key]
            
            const postValue = formatPostData(value)
            if(value==null){
              continue
            }
            if (!Array.isArray(value)) {
                arr.push(key + '=' + encodeURIComponent(postValue))
                continue
            }
            for (const subKey in value) {
                const subvalue = value[subKey]
                arr.push(key + '=' + encodeURIComponent(subvalue))
            }
        }
    }
  
  const result = arr.join('&');
  return result;
}
export const PREFIX = "http://localhost:8080/teachain/"

/**
 * 公用post请求
 * @param url       接口地址
 * @param data      接口参数
 * @param msg       接口异常提示
 * @param headers   接口所需header配置
 */

/*const url = `${PREFIX}storeManager/removeEmployeeWorkingStoreList/storeId/employeeWorkingStoreIds/tokensExpr/`
  const requestParameters = { ...parameters, storeId: targetObjectId, tokensExpr: 'none' }
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })*/


export const postForm = ({ url, requestParameters, msg = '接口异常'})=>{

  
  const headers = { 'Content-Type': 'application/x-www-form-urlencoded' }
  return post({
    url,
    data: joinPostParameters(requestParameters),
    headers,
  })
}



export const put = ({ url,data, msg = '接口异常', headers }) =>
    axios
      .put(url, data, headers)
      .then(function(res) {
        console.log('http headers', res.headers);
        const clazz = res.headers['x-class'];
        if (clazz) {
          if (clazz.indexOf('CommonError') > 0 || clazz.indexOf('Exception') > 0) {
            message.error('后台系统出错，请检查错误消息' + res.data);
          }
        }
        return res.data;
      })
      .catch(err => {
        console.log(err);
        message.warn(msg);
      });




export const post = ({ url, data, msg = '接口异常', headers }) =>
  axios
    .post(url, data, headers)
    .then(res => res.data)
    .catch(err => {
      console.log(err);
      message.warn(msg);
    });

//提交表单的时候，把相关的值写到上传的form里面去
