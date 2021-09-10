import React from 'react';
import { Text, View } from '@tarojs/components';
import { getExtMode, isEmpty } from '@/nice-router/nice-router-util';
import './status-flag.scss';

interface StatusFlagProps {
  title?: string;
  size?: 'normal' | 'small';
}

const StatusFlag: React.FC<StatusFlagProps> = (props) => {
  const { title = '', size = 'normal' } = props;
  if (isEmpty(title)) {
    return null;
  }
  const length = title.length;
  const txtClass = getExtMode({
    txt_large: length < 3,
    txt_normal: length === 3,
    txt_small: title.length === 4,
    txt_tiny: title.length > 4,
  }).classNames('status-flag-txt');

  const rootClass = getExtMode({ [size]: size }).classNames('status-flag');

  return (
    <View className={rootClass}>
      <View className='status-flag-bg' />
      <Text className={txtClass}>{title}</Text>
    </View>
  );
};

export default StatusFlag;
