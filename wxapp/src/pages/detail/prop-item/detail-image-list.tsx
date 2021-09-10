import EleCarousel from '@/components/elements/ele-carousel';
import { View } from '@tarojs/components';
import './styles.scss';

function DetailImageList({ items }) {
  return (
    <View className='detail-image-list'>
      <EleCarousel items={items} indicatorActiveColor='#5ebfff' customStyle={{ borderRadius: '10px' }} />
    </View>
  );
}

export default DetailImageList;
