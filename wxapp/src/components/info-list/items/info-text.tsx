import { View } from '@tarojs/components';
import _ from 'lodash';
import { getExtMode } from '@/nice-router/nice-router-util';

import './styles.scss';

type InfoTextProps = {
  value: string | object;
  mode: 'left' | 'center' | 'bold' | string[];
  className?: string;
};

function InfoText({ value, className, mode = [] }: InfoTextProps) {
  const rootClass = getExtMode(mode).classNames('info-text', className);
  const theValue = _.isObject(value) ? JSON.stringify(value) : value;
  return <View className={rootClass}>{theValue}</View>;
}

export default InfoText;
