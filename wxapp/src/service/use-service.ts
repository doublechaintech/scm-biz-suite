import { useEffect, useRef, useState } from 'react';
import NavigationService from '@/nice-router/navigation-service';
import { LoadingType } from '@/nice-router/nice-router-util';
import _ from 'lodash';
import Taro from '@tarojs/taro';
import ActionUtil from '@/nice-router/action-util';
import Config from '@/nice-router/nice-router.config';

// boolean类型的控制属性，show，close，toggle
export function useVisible(initial = false) {
  const [visible, setVisible] = useState(initial);
  const show = () => setVisible(true);
  const close = () => setVisible(false);
  const toggle = () => setVisible(!visible);
  return {
    visible,
    show,
    close,
    toggle,
  };
}

export function useLoading(initial = false) {
  const [loading, setLoading] = useState(initial);
  const showLoading = () => setLoading(true);
  const hideLoading = () => setLoading(false);
  return {
    loading,
    showLoading,
    hideLoading,
  };
}

// 这只page的title
export function usePageTitle(value) {
  useEffect(() => {
    let theTitle = _.isString(value) ? value : value?.pageTitle || value?.title;
    Taro.setNavigationBarTitle({
      title: theTitle || Config.name,
    });
  }, [value]);
}

export function useAjaxPullDown(action: any) {
  usePullDown(action);
}

export function usePullDown(action: any) {
  Taro.usePullDownRefresh(() => {
    if (!ActionUtil.isActionLike(action)) {
      Taro.stopPullDownRefresh();
      return;
    }

    NavigationService.view(
      action,
      {},
      {
        dataRefresh: true,
        onSuccess: () => Taro.stopPullDownRefresh(),
        loading: LoadingType.Modal,
      }
    );
  });
}

// 倒计时
export function useCountdown(maxCount = 60, onEndOfCounting?: Function) {
  const [second, setSecond] = useState(maxCount);
  const [counting, setCounting] = useState(false);
  const interval = useRef();

  const startCount = () => setCounting(true);

  useEffect(() => {
    if (!counting) {
      return;
    }
    setCounting(true);
    console.log('countdown....run');
    // @ts-ignore
    interval.current = setInterval(() => {
      setSecond((t) => {
        const result = t - 1;
        console.log('countdown....run....', result);
        if (result === 0) {
          clearInterval(interval.current);
          setCounting(false);
          if (_.isFunction(onEndOfCounting)) {
            onEndOfCounting();
          }
          return maxCount;
        }
        return result;
      });
    }, 1000);
    return () => clearInterval(interval.current);
  }, [counting, maxCount, onEndOfCounting]);
  return {
    second,
    counting,
    startCount,
  };
}
