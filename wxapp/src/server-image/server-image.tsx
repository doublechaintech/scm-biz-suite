import React from 'react';
import { Image } from '@tarojs/components';
import classNames from 'classnames';
import { isH5 } from '@/utils/index';
import { ImageProps } from '@tarojs/components/types/Image';
import ImageTools, { ImageSize } from './image-tools';
import './styles.scss';

export type ServerImageProps = {
  className?: string;
  src?: string;
  uri?: string;
  size?: ImageSize;
  customStyle?: React.CSSProperties;
} & Partial<ImageProps>;

function ServerImage(props: ServerImageProps) {
  const { mode = 'aspectFill', className, src, uri, size, customStyle = {}, ...others } = props;
  const rootCls = classNames('server-image', className, {
    'server-image--h5': isH5() && (mode === 'widthFix' || mode === 'heightFix'),
  });
  const remotePath = ImageTools.getServerImagUrl(src || uri, size);

  return <Image className={rootCls} style={customStyle} src={remotePath} mode={mode} {...others} />;
}

export default ServerImage;
