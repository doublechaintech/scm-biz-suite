import _ from 'lodash';

const imageList = [
  'https://nice-router.oss-cn-chengdu.aliyuncs.com/avatar-1.png',
  'https://nice-router.oss-cn-chengdu.aliyuncs.com/avatar-2.jpg',
  'https://nice-router.oss-cn-chengdu.aliyuncs.com/avatar-3.jpg',
  'https://nice-router.oss-cn-chengdu.aliyuncs.com/avatar-4.jpg',
  'https://nice-router.oss-cn-chengdu.aliyuncs.com/avatar-5.jpg',
];

const MockDataCache = {};
const mockResp = (uri: string = '', xClass: string, data: {}, others) => {
  const key = uri.toLowerCase().trim();
  MockDataCache[key] = {
    xClass,
    success: true,
    data,
    ...others,
  };
};
const MockService = {
  mockResp,
  getMockResp: (uri: string = '') => MockDataCache[uri.toLowerCase().trim()],
  randomImage: (): string => _.sample(imageList) || '',
  defaultImage: imageList[2],
};
// 凑活用
export default MockService;
