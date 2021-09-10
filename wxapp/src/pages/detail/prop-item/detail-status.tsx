import { isNotEmpty } from '@/nice-router/nice-router-util';
import { Text, View } from '@tarojs/components';
import classNames from 'classnames';
import _ from 'lodash';

import './styles.scss';

const LEVEL = ['default', 'primary', 'normal', 'warn', 'danger'];

function getLevel({ level }) {
  return level || _.sample(LEVEL); // sample for demo
}

function DetailStatus(props) {
  const { name, code } = props;
  // const { name, code,level } = props
  const level = getLevel(props);
  const statusIconClass = classNames('detail-status-icon', { [level]: isNotEmpty(level) });

  return (
    <View className='detail-status'>
      <View className={statusIconClass} />
      <Text>
        {name} ({code})
      </Text>
    </View>
  );
}

export default DetailStatus;
