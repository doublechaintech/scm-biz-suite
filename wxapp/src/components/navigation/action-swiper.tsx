import _ from 'lodash';
import { Swiper, SwiperItem, View } from '@tarojs/components';
import NavigationBox from '@/components/navigation/navigation-box';
import { ActionListLike } from '@/nice-router/nice-router-types';

import './action-swiper.scss';

function ActionSwiper(props: ActionListLike) {
  const { actionList = [] } = props;
  const group = _.chunk(actionList, 5).map((it, idx) => ({ list: it, id: idx }));
  const showDots = group.length > 1;

  console.log('groups', group);
  return (
    <View className='swiper-action-list'>
      <Swiper
        autoplay={false}
        circular={false}
        indicatorActiveColor='#d2ab66'
        indicatorDots={showDots}
        className='swiper-action-list-swiper'
      >
        {group.map((it) => (
          <SwiperItem key={it.id}>
            <NavigationBox items={it.list} />
          </SwiperItem>
        ))}
      </Swiper>
    </View>
  );
}

export default ActionSwiper;
