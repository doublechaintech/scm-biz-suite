
import axios from 'axios';
import { message } from 'antd';
import { SYSTEM_SHORT_NAME } from './config';
import moment from 'moment';
import SystemConfig from './config';
import PictureEdit from '../components/PictureEdit';
import ImageUpload from '../components/ImageUpload';
import OssPictureEdit from '../components/OSSPictureEdit';

export const ImageComponent = OssPictureEdit
//for BBT only
//export const ImageComponent = ImageUpload;

/**
 * 公用get请求
 * @param url       接口地址
 * @param msg       接口异常提示
 * @param headers   接口所需header配置
 */
//axios.defaults.headers.common['Authorization'] = AUTH_TOKEN;
export const get1 = ({
  url,
  msg = '从服务器取得数据失败，请检查网络，或者咨询服务器管理员',
  headers,
}) =>
  axios
    .get(url, { headers: headers, withCredentials: true })
    .then(res => res.data)
    .catch(err => {
      console.log(url);
      message.warn(msg);
    });

export const get2 = ({
  url,
  msg = '从服务器取得数据失败，请检查网络，或者咨询服务器管理员',
  headers,
}) => {
  const config = { method: 'get', url: url, headers: headers, withCredentials: false };
  //res => {console.log(res.headers);console.log(res.data);return res.data;
  axios
    .get(url, headers)
    .then(res => res.data)
    .catch(err => {
      console.log('err', err);
      console.log(url);
      message.warn(msg);
    });
};
axios.defaults.withCredentials = true;
export const get3 = ({ url, msg = '接口异常', headers }) =>
  axios
    .get(url, { headers, withCredentials: false })
    .then(res => res.data)
    .catch(err => {
      console.log(err);
      message.warn(msg);
    });

export const get = ({ url, msg = '接口异常', headers }) =>
  axios
    .get(url, headers)
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

export const getURLPrefix = () => {
  const url = new URL(window.location);
  if (url.hostname === 'clariones.doublechaintech.com') {
    //return `http://${url.hostname}:8080/naf/`
    return `http://clariones.doublechaintech.com/naf/`;
  }
  if (url.hostname === '30.30.126.37') {
    return `http://${url.hostname}:8080/naf/`;
  }
  if (url.hostname === 'localhost') {
    return `http://${url.hostname}:8080/${SYSTEM_SHORT_NAME}/`
  }
  if (url.hostname === '127.0.0.1') {
    return `https://app.art0x.com/moyi/`
  }
  //return `http://xm.jl51.com.cn/cis/`

  return `${url.origin}/${SYSTEM_SHORT_NAME}/`;
  //return `${url.origin}/${SYSTEM_SHORT_NAME}/`
};

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
    console.log("value", value)
  
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

export const PREFIX = getURLPrefix();
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



export const post = ({ url, data, msg = '接口异常', headers }) =>
  axios
    .post(url, data, headers)
    .then(res => res.data)
    .catch(err => {
      console.log(err);
      message.warn(msg);
    });

//提交表单的时候，把相关的值写到上传的form里面去

export const mapBackToImageValuesFlatResponse = convertedImagesValues => {
  const targetImages = [];
  Object.keys(convertedImagesValues).map(key => {
    if (!convertedImagesValues || !convertedImagesValues[key] || !convertedImagesValues[key][0]) {
      return;
    }
    const value = convertedImagesValues[key][0];
    if (value.response) {
      if (value.response.indexOf('//') === 0) {
        targetImages[key] = value.response;
        return;
      }
      if (value.response.indexOf('http://') === 0) {
        targetImages[key] = value.response;
        return;
      }
      if (value.response.indexOf('https://') === 0) {
        targetImages[key] = value.response;
        return;
      }
      targetImages[key] = imageURLPrefix + value.response;
      return;
    }
    if (value.url) {
      targetImages[key] = value.url;
      return;
    }
  });
  return targetImages;
};
export const mapBackToImageValuesSkynetMediaServer = convertedImagesValues => {
  const targetImages = [];
  Object.keys(convertedImagesValues).map(key => {
    if (!convertedImagesValues || !convertedImagesValues[key] || !convertedImagesValues[key][0]) {
      return;
    }
    const value = convertedImagesValues[key][0];
    if (!value.response) {
      //no response yet
      console.log('No response yet for ', key);
      targetImages[key] = value.url;
      return;
    }
    if (!value.response.status) {
      console.log('No status yet for ', key);
      targetImages[key] = value.url;
      return;
    }
    if (!(value.response.status === 'success')) {
      console.log('Get a failed response  for ', key);
      targetImages[key] = value.url;
      return;
    }
    if (!value.response.resourceUris) {
      console.log('This is a server internal error, No URIs yet for ', key);
      targetImages[key] = value.url;
      return;
    }
    const uri = value.response.resourceUris[0];
    //{"status":"success","resourceUris":["public/example/product/shores/girls/pid456/skuid456/235/19/144/172/p456s456main.picture.png"]}
    targetImages[key] = SystemConfig.MEDIA_PREFIX + uri;
  });
  return targetImages;
};
//export const mapBackToImageValues = mapBackToImageValuesSkynetMediaServer;
export  const mapBackToImageValues = mapBackToImageValuesFlatResponse;
//BBT

export const mapFromImageValues = (selectedRow, imageKeys) => {
  const targetImages = {};
  const buildFileList = (key, value) => {
    if (value) {
      return [{ uid: key, url: value }];
    }
    return [];
  };
  imageKeys.map(key => {
    targetImages[key] = buildFileList(key, selectedRow[key]);
  });
  console.log('targetImages', targetImages);
  return targetImages;
};



export function playSound(sound){
  var audio = new Audio(sound+'.mp3');
  audio.play();
}
