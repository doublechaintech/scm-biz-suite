import React from 'react';
import ActionIcon from '@/components/action-icon/action-icon';
import NavigationService from '@/nice-router/navigation-service';
import { Swiper, SwiperItem, Text, View } from '@tarojs/components';

import classNames from 'classnames';
import { EleObject, IconLike, ImageLike } from '@/nice-router/nice-router-types';
import './styles.scss';

type EleNoticeProps = {
  items: EleObject[];
  customStyle?: React.CSSProperties;
  className?: string;
} & ImageLike &
  IconLike;

function EleNotice(props: EleNoticeProps) {
  const { items, icon, imageUrl, customStyle, className } = props;

  const handleItemClick = (item) => {
    NavigationService.view(item);
  };

  const rootClass = classNames('ele-notice-bar', className);

  return (
    <View className={rootClass} style={customStyle}>
      <ActionIcon className='ele-notice-bar-icon' mode='heightFix' icon={icon} imageUrl={imageUrl} />
      <Swiper className='ele-notice-bar-messages' autoplay circular vertical>
        {items.map((it) => {
          const { id } = it;
          return (
            <SwiperItem key={id} className='ele-notice-bar-messages-item' onClick={handleItemClick.bind(this, it)}>
              <Text className='ele-notice-bar-messages-item-txt'>{it.title}</Text>
            </SwiperItem>
          );
        })}
      </Swiper>
    </View>
  );
}

EleNotice.defaultProps = {
  items: [],
  imageUrl: '',
  customStyle: {},
  imageHeight: 20,
  imageWidth: 20,
};

export default EleNotice;
