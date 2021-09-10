import _ from 'lodash';
import { isEmpty, log } from './nice-router-util';

export type ViewConfigStateActionType = string | string[];

export type ViewConfigItemType = {
  pageName?: string;
  stateAction?: ViewConfigStateActionType;
};
type ViewConfigType = Record<string, ViewConfigItemType | ViewConfigItemType[]>;

const defaultViewConfig: ViewConfigType = {
  'com.terapico.appview.H5Page': {
    pageName: 'H5Page',
    stateAction: '/nice-router/h5-page',
  },
  'NetworkException.RetryPage': {
    pageName: '/nice-router/network-exception-page',
  },
  // global pages
  'com.terapico.caf.viewcomponent.GenericPage': [
    {
      pageName: '/genericpage/generic-page',
      stateAction: 'genericpage/save',
    },
    {
      pageName: '/genericpage/generic-page2',
      stateAction: 'genericpage2/save',
    },
  ],
  'com.terapico.caf.viewcomponent.GenericFormPage': {
    pageName: '/genericform/genericform-page',
    stateAction: 'genericform/save',
  },
  'com.terapico.appview.ListOfPage': [
    {
      pageName: '/listof/listof-page',
      stateAction: ['listofpage/save', 'listofpage2/clear'],
    },
    {
      pageName: '/listof/listof-page2',
      stateAction: ['listofpage2/save', 'listofpage3/clear'],
    },
    {
      pageName: '/listof/listof-page3',
      stateAction: ['listofpage3/save', 'listofpage4/clear'],
    },
    {
      pageName: '/listof/listof-page4',
      stateAction: ['listofpage4/save', 'listofpage/clear'],
    },
  ],

  'com.terapico.appview.ObjectPickerPage': {
    pageName: '/genericform/object-picker-page',
    stateAction: 'objectPicker/saveInbound',
  },
};

class ViewMappingServiceClass {
  private pointerCache: Record<string, number> = {};
  private _viewConfig: ViewConfigType = {};

  public set viewConfig(vcfg: ViewConfigType) {
    this._viewConfig = {};
    const mergedViewConfig = _.merge(defaultViewConfig, vcfg);
    Object.keys(mergedViewConfig).map((key) => {
      this._viewConfig[key.trim()] = mergedViewConfig[key];
    });
  }

  /**
   *
   * @param backendKey xClass key
   * @param ajax 对于多instance页面，如果是Ajax，就不跳pointer
   */
  getView(backendKey = '', ajax = false): ViewConfigItemType {
    const key = _.trim(backendKey);
    let view = _.get(this._viewConfig, key, {});
    if (isEmpty(view)) {
      const shortKey = key.substr(key.lastIndexOf('.') + 1, key.length);
      log('the key for class', key, 'not found, try to map with shortKey', shortKey);
      view = this._viewConfig[shortKey] || {};
    }
    if (Array.isArray(view)) {
      const pointer: number = _.get(this.pointerCache, backendKey, -1);
      const nextPageIndex = ajax ? pointer : pointer + 1 >= view.length ? 0 : pointer + 1;
      const idx = _.max([nextPageIndex, 0]) as number;
      this.pointerCache[backendKey] = idx;
      return view[idx];
    }
    return view;
  }
}

const ViewMappingService = new ViewMappingServiceClass();
export default ViewMappingService;
