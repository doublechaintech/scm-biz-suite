import _ from 'lodash';
import { createAction } from '@/nice-router/nice-router-util';
import GlobalToast from '@/nice-router/global-toast';
import { CandidateValue } from '@/nice-router/nice-router-types';

type ObjectPickerStateType = {
  selectedItems: CandidateValue[];
  inbound: {
    maxSelectCount?: number;
    list?: CandidateValue[];
  };
};

export default {
  namespace: 'objectPicker',
  state: {
    selectedItems: [],
    inbound: {
      maxSelectCount: 1,
      list: [],
    },
  },

  reducers: {
    removeSelectItem(state: ObjectPickerStateType, { payload: item }) {
      const result = _.clone(state.selectedItems);
      _.remove(result, { id: item.id });
      return {
        ...state,
        selectedItems: result,
      };
    },
    selectItem(state: ObjectPickerStateType, { payload: item }) {
      const { selectedItems = [], inbound = {} } = state;
      const { maxSelectCount = 1 } = inbound;

      console.log('inbound', inbound);

      if (maxSelectCount === 1) {
        return {
          ...state,
          selectedItems: [item],
        };
      }

      const result = _.clone(selectedItems);
      const target = _.remove(result, { id: item.id });
      // 已经被选中的，确实能够删除，则删除
      console.log('result', result, 'xx', target);
      if (target.length > 0) {
        return {
          ...state,
          selectedItems: result,
        };
      }

      // 添加 动作 超过最大数
      if (selectedItems.length + 1 > maxSelectCount) {
        GlobalToast.show({ text: `最多只能选择${maxSelectCount}` });
        return state;
      }

      // 添加
      result.push(item);
      return {
        ...state,
        selectedItems: result,
      };
    },
  },
  effects: {
    *saveInbound({ payload = {} }, { put }) {
      yield put(createAction('saveSomeThing')({ inbound: { maxSelectCount: 1, ...payload } }));
    },
  },
  subscriptions: {},
};
