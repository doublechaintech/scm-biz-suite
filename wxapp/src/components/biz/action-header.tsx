import EleCarousel from '@/components/elements/ele-carousel';
import NavigationBox from '@/components/navigation/navigation-box';
import { isNotEmpty } from '@/nice-router/nice-router-util';
import { View } from '@tarojs/components';

import './styles.scss';

function ActionHeader(props) {
  const { slideList = [], actionList = [] } = props;
  return (
    <View className='action-header'>
      {isNotEmpty(slideList) && (
        <EleCarousel className='action-header-carousel' items={slideList} indicatorActiveColor='#28AAFF' />
      )}

      {actionList.length > 0 && (
        <View className='action-header-shortcut'>
          <NavigationBox items={actionList} mode='round-top' />
        </View>
      )}
    </View>
  );
}

export default ActionHeader;
