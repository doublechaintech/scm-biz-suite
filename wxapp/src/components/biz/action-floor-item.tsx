import ServerImage from '@/server-image/server-image';
import { Text, View } from '@tarojs/components';

import EleButton, { EleButtonProps } from '@/components/elements/ele-button';
import { getExtMode, isEmpty } from '@/nice-router/nice-router-util';
import './action-floor.scss';

type ActionFloorItemProps = {
  color?: 'blue';
} & Omit<EleButtonProps, 'mode'>;

function ActionFloorItem(props: ActionFloorItemProps) {
  const { title, brief, imageUrl, color, ...others } = props || {};
  if (isEmpty(title) && isEmpty(brief) && isEmpty(imageUrl)) {
    return null;
  }

  const rootCls = getExtMode(color).classNames('action-floor-item');
  return (
    <EleButton {...others} mode='ghost' className={rootCls}>
      {imageUrl ? (
        <ServerImage className='action-floor-item-image' mode='scaleToFill' src={imageUrl} />
      ) : (
        <View className='action-floor-item-title'>{title}</View>
      )}
      <View className='action-floor-item-brief'>
        <Text className='action-floor-item-brief-txt'>{brief}</Text>
      </View>
    </EleButton>
  );
}

ActionFloorItem.defaultProps = {
  action: {},
};

export default ActionFloorItem;
