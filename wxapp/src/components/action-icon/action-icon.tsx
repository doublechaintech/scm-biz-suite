import { isEmpty, isNotEmpty } from '@/nice-router/nice-router-util';
import ServerImage, { ServerImageProps } from '@/server-image/server-image';
import { Text, View } from '@tarojs/components';
import classNames from 'classnames';
import { IconLike, ImageLike } from '@/nice-router/nice-router-types';

import './action-icon.scss';

type ActionIconProps = IconLike & ImageLike & ServerImageProps;

/**
 *  有icon，优先展示ICON
 */
export default function ActionIcon(props: ActionIconProps) {
  const { icon = '', imageUrl, className, mode } = props;
  if (isEmpty(icon) && isEmpty(imageUrl)) {
    return null;
  }

  if (isNotEmpty(icon)) {
    const isBizFont = icon.startsWith('bizfont-');
    const rootClass = classNames(
      'iconfont',
      {
        bizfont: isBizFont,
        [icon]: isBizFont,
        [`iconfont-${icon}`]: !isBizFont,
      },
      className,
      mode
    );
    return (
      <View className='action-icon'>
        <Text className={rootClass} />
      </View>
    );
  }

  const rootClass = classNames('action-icon', 'action-image', className);

  return (
    <View className={rootClass}>
      <ServerImage customStyle={{ width: '100%', height: '100%' }} mode={mode} src={imageUrl} />
    </View>
  );
}
