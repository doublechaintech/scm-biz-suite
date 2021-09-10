import React from 'react';
import ActionUtil from '@/nice-router/action-util';

import NavigationService from '@/nice-router/navigation-service';
import { isEmpty, isNotEmpty } from '@/nice-router/nice-router-util';
import ServerImage from '@/server-image/server-image';
import { Swiper, SwiperItem, Video, View } from '@tarojs/components';
import Taro from '@tarojs/taro';
import classNames from 'classnames';
import { SwiperProps } from '@tarojs/components/types/Swiper';
import { ImageSize } from '@/server-image/image-tools';
import { ActionLike, ImageLike, VideoLike } from '@/nice-router/nice-router-types';
import { ImageProps } from '@tarojs/components/types/Image';
import './styles.scss';

export type EleCarouselItem = ActionLike & ImageLike & VideoLike;

export type EleCarouselProps = {
  items?: EleCarouselItem[];
  customStyle?: React.CSSProperties;
  imageMode?: ImageProps.mode;
} & SwiperProps;

function EleCarousel(props: EleCarouselProps) {
  const {
    items = [],
    autoplay,
    interval,
    duration,
    circular,
    indicatorColor,
    indicatorActiveColor,
    indicatorDots,
    customStyle,
    className,
    imageMode,
  } = props;

  if (isEmpty(items)) {
    return null;
  }

  const handleClick = async (item: EleCarouselItem = {}) => {
    const { videoUrl = '', imageUrl } = item;
    console.log('carousel viewed', item);

    if (isNotEmpty(videoUrl)) {
      return;
    }

    if (ActionUtil.isActionLike(item)) {
      NavigationService.view(item);
      return;
    }

    if (isEmpty(videoUrl) && isNotEmpty(imageUrl)) {
      await Taro.previewImage({ urls: [imageUrl || ''] });
    }
  };

  const showDots = indicatorDots === null ? items.length > 1 : indicatorDots;

  const rootClass = classNames('ele-carousel', className);
  return (
    <View className={rootClass} style={customStyle}>
      <Swiper
        autoplay={autoplay}
        interval={interval}
        duration={duration}
        circular={circular}
        indicatorColor={indicatorColor}
        indicatorActiveColor={indicatorActiveColor}
        indicatorDots={showDots}
        className='ele-carousel-item'
      >
        {items.map((it, idx) => {
          const { videoUrl = '', imageUrl } = it;
          // @ts-ignore
          const key = `carousel-${idx}-${it.id}`;

          return (
            <SwiperItem key={key} onClick={() => handleClick(it)} className='ele-carousel-item'>
              {videoUrl.length > 0 ? (
                <Video
                  className='ele-carousel-item'
                  src={videoUrl}
                  controls
                  poster={imageUrl}
                  loop
                  muted={false}
                  direction={90}
                />
              ) : (
                // @ts-ignore
                <ServerImage className='ele-carousel-item' src={it.imageUrl} mode={imageMode} size={ImageSize.Large} />
              )}
            </SwiperItem>
          );
        })}
      </Swiper>
    </View>
  );
}

EleCarousel.defaultProps = {
  items: [],
  autoplay: false,
  interval: 5000,
  duration: 1000,
  circular: true,
  indicatorColor: 'rgba(255, 255, 255, 0.6)',
  indicatorActiveColor: '#fff',
  customStyle: {},
  mode: 'aspectFill',
};

export default EleCarousel;
