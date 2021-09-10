import { View } from '@tarojs/components';
import classNames from 'classnames';
import _ from 'lodash';

import './styles.scss';

type DetailTextProps = {
  value?: any;
  inline?: boolean;
  className?: string;
};

function DetailText({ value, inline = true, className }: DetailTextProps) {
  const rootClass = classNames('detail-text', className, { inline });
  return <View className={rootClass}>{_.isObject(value) ? JSON.stringify(value) : value}</View>;
}

export default DetailText;
