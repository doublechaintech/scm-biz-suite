import _ from 'lodash';
import classNames from 'classnames';

export enum LoadingType {
  None,
  Top,
  Modal,
  FetchingNext,
  BarLoading,
}

export const createAction = (type?: string) => (payload?: any) => ({ type, payload });
export const noop = () => {};

export const sleep = async (longTime) => new Promise((resolve) => setTimeout(resolve, longTime));

export function log(...params) {
  console.log('%c nice-router: ', 'color:#8add4c; text-shadow: 0.5px 0.5px 0.5px grey', ...params);
}

// null=> true
// true=> true
// 1 => false
// [1,2]=> false
// {} => true
// {a:'1'} => false
export const isEmpty = (value) => {
  if (_.isNumber(value) || _.isBoolean(value)) {
    return false;
  }
  if (_.isNil(value)) {
    return true;
  }
  if (_.isString(value)) {
    return value.length === 0;
  }
  return _.isEmpty(value);
};
export const isNotEmpty = (value) => {
  return !isEmpty(value);
};
export const toBoolean = (value) => {
  if (isEmpty(value)) {
    return false;
  }
  if (_.isString(value)) {
    const p = value.toLowerCase().trim();
    if (p === 'true') {
      return true;
    }
    if (p === 'false') {
      return false;
    }
  }
  return value;
};

export function parseJSON(json) {
  if (_.isObject()) {
    return json;
  }
  if (_.isString(json)) {
    try {
      return JSON.parse(json);
    } catch (e) {
      return {};
    }
  }
  console.warn('shouldBeObject is not controlled value', json);
  return json;
}

export function mergeMode() {
  return _.flatten(arguments).filter(isNotEmpty);
}

/**
 *
 * mode
 *
 * @returns {{mode: (function(*=): (*)), classNames: (function(*=, ...[*]=): string)}}
 */
export function getExtMode(...props: any[]) {
  const modeList = _.flatten(props).filter(isNotEmpty);

  const buildWithPrefix = (prefix) => {
    if (isEmpty(prefix)) {
      return prefix;
    }
    const list = modeList.map((it) => {
      if (_.isObject(it)) {
        return _.keys(it).map((key) => (it[key] ? key : ''));
      }
      return it;
    });
    return _.flatten(list)
      .filter((it) => isNotEmpty(it))
      .map((it) => `${prefix}--${_.trim(it)}`);
  };

  return {
    mode: buildWithPrefix,
    classNames: function(prefix: any, ...others: any[]) {
      return classNames(prefix, others, buildWithPrefix(prefix));
    },
  };
}
