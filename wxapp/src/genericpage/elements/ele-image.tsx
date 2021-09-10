import React from 'react';
import ServerImage from '@/server-image/server-image';
import { View } from '@tarojs/components';
import classNames from 'classnames';
import { ImageLike } from '@/nice-router/nice-router-types';
import { ImageProps } from '@tarojs/components/types/Image';

import './styles.scss';

type EleImageProps = {
  src?: string;
  className?: string;
  customStyle?: React.CSSProperties;
} & ImageLike &
  Partial<ImageProps>;

function EleImage(props: EleImageProps) {
  const { imageUrl, src, className, customStyle, mode } = props;
  const rootClass = classNames('ele-image', className);
  const path = imageUrl || src;
  return (
    <View className={rootClass} style={customStyle}>
      {path ? (
        <ServerImage src={path} customStyle={customStyle} mode={mode} />
      ) : (
        <View className='image-placeholder' style={customStyle}>
          <View className='iconfont file-image' />
        </View>
      )}
    </View>
  );
}

EleImage.defaultProps = {
  customStyle: {},
};

export default EleImage;
