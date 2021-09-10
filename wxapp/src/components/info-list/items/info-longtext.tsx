import React from 'react';
import { Text, View } from '@tarojs/components';
import { useVisible } from '@/service/use-service';

import _ from 'lodash';
import { getExtMode } from '@/nice-router/nice-router-util';
import './styles.scss';

type InfoLongTextProps = {
  value?: string | object;
  maxLength?: number;
  useFold?: boolean;
  className?: string;
  children?: React.ReactNode;
};

function InfoLongText(props: InfoLongTextProps) {
  const { value = '', maxLength = 200, className, useFold = true } = props;
  let theValue = _.isObject(value) ? JSON.stringify(value) : value;
  if (_.isString(props.children)) {
    theValue = props.children;
  }

  const { visible, toggle } = useVisible(false);

  let showFoldAction = false;
  if (useFold && theValue.length > maxLength) {
    showFoldAction = true;
  }

  const rootClass = getExtMode({ fold: showFoldAction && !visible }).classNames('info-longtext', className);

  return (
    <View className={rootClass}>
      <Text className='info-longtext-value'>{theValue}</Text>
      {showFoldAction && (
        <Text className='info-longtext-action' onClick={toggle}>
          {visible ? '隐藏' : '展开'}
        </Text>
      )}
    </View>
  );
}

export default InfoLongText;
