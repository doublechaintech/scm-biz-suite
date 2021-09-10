/* eslint-disable consistent-return */
import { isNotEmpty } from '@/nice-router/nice-router-util';
import _ from 'lodash';

export type StoreDataPayload = {
  navigationOption: {
    statInPage?: boolean;
    arrayMerge?: 'replace' | 'append';
    dataRefresh?: boolean;
    viewHashString?: string;
  };
} & Record<string, any>;

function replaceArray(objValue, srcValue) {
  if (Array.isArray(objValue)) {
    return srcValue;
  }
}

function concatArray(objValue, srcValue) {
  if (Array.isArray(objValue)) {
    return objValue.concat(srcValue);
  }
}

function mergeState(
  preState: StoreDataPayload = {} as StoreDataPayload,
  newState: StoreDataPayload = {} as StoreDataPayload,
  doMerge = false,
  arrayMerge = 'append'
) {
  const { viewHashString: preHash } = preState;
  const { viewHashString: newHash } = newState;

  // 数据没有变化
  if (isNotEmpty(newHash) && preHash === newHash) {
    return null;
  }

  // 不进行merge操作
  if (!doMerge) {
    return newState;
  }

  // merge 对象, 不指定array的merge方法，默认为concat data to legacy array
  const processor = arrayMerge === 'replace' ? replaceArray : concatArray;
  // 小程序下没问题，但是H5中，redux做的浅比较，ajax会有问题
  // const result = mergeWith(preState, newState, processor)
  const result = _.mergeWith({}, preState, newState, processor);
  console.log('merged result', result);

  return result;
}

const createDefault = (namespace) => ({
  namespace,
  state: {},
  effects: {},
  reducers: {
    clear() {
      return {};
    },
    saveSomeThing(state: StoreDataPayload, { payload }: { payload: StoreDataPayload }) {
      return {
        ...state,
        ...payload,
      };
    },
    save(state: StoreDataPayload, { payload }: { payload: StoreDataPayload }) {
      const { navigationOption, ...resp } = payload;
      const { statInPage, arrayMerge, dataRefresh } = navigationOption;
      // 如果是refresh page 就不merge数据
      const doMerge = dataRefresh ? false : statInPage;
      // @ts-ignore
      const result = mergeState(state, resp, doMerge, arrayMerge);
      return result || state;
    },
  },
});

const ModelTools = {
  mergeState,
  createDefault,
};
export default ModelTools;
