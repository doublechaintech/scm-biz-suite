import EleButton from '@/components/elements/ele-button';
import { Image, View } from '@tarojs/components';

import NavigationService from './navigation-service';
import networkImage from './network.png';
import './styles.scss';

function refresh() {
  NavigationService.dispatch('niceRouter/retry');
}

function NetworkExceptionPage() {
  return (
    <View className='network-exception-page'>
      <View className='network-exception-page-image'>
        <Image style='width:100%;height:100%' src={networkImage} mode='widthFix' />
      </View>
      <View className='network-exception-page-tips'>
        <View className='network-exception-page-tips-txt'>网络状态待提升</View>
        <View className='network-exception-page-tips-btn'>
          <EleButton onClick={refresh}>查看解决方案</EleButton>
        </View>
      </View>
    </View>
  );
}

NetworkExceptionPage.onPullDownRefresh = refresh;

export default NetworkExceptionPage;
