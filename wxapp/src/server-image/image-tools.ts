import _ from 'lodash';
import { isEmpty } from '@/nice-router/nice-router-util';

// const logo = require('./images/default_id_icon.png')

export enum ImageSize {
  Thumbnail,
  Tiny,
  Small,
  Middle,
  Normal,
  Large,
  XLarge,
  Origin,
}

const isSkipUrl = (url = '') => {
  return (
    !/^(http|https):/.test(url) || // 不是http（本地文件）
    url.indexOf('x-oss-process') > -1 || // 或者已经包含style
    (url.indexOf('?') > -1 && url.indexOf('=') > -1)
  );
};

const getServerImagUrl = (uri: string = '', size: ImageSize = ImageSize.Normal) => {
  const url = _.trim(uri);
  if (isEmpty(url) || isSkipUrl(url)) {
    console.log("image uri don't need styled");
    return url;
  }
  if (size === ImageSize.Thumbnail) return `${url}?x-oss-process=style/thumbnail`;
  if (size === ImageSize.Tiny) return `${url}?x-oss-process=style/tiny`;
  if (size === ImageSize.Small) return `${url}?x-oss-process=style/small`;
  if (size === ImageSize.Middle) return `${url}?x-oss-process=style/middle`;
  if (size === ImageSize.Normal) return `${url}?x-oss-process=style/normal`;
  if (size === ImageSize.Large) return `${url}?x-oss-process=style/large`;
  if (size === ImageSize.XLarge) return `${url}?x-oss-process=style/xlarge`;
  if (size === ImageSize.Origin) return `${url}?x-oss-process=style/origin`;
  return url;
};

const ImageTools = {
  getServerImagUrl,
};
export default ImageTools;
