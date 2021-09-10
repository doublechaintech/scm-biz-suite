import { getExtMode } from '@/nice-router/nice-router-util';
import { Text, View } from '@tarojs/components';
import _ from 'lodash';

import './styles.scss';

const LEVEL = ['default', 'primary', 'normal', 'warn', 'danger'];

type InfoStatusProps = {
  name: string;
  level: 'default' | 'primary' | 'normal' | 'warn' | 'danger';
  code: string;
};

function getLevel(level) {
  return level || _.sample(LEVEL); // sample for demo
}

function InfoStatus(props: InfoStatusProps) {
  const { name, code, level } = props;
  const statusIconClass = getExtMode({
    [level]: getLevel(level),
  }).classNames('info-status-icon');

  return (
    <View className='info-status'>
      <View className={statusIconClass} />
      <Text>
        {name} ({code})
      </Text>
    </View>
  );
}

export default InfoStatus;
