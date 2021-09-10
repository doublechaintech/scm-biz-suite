import ActionIcon from '@/components/action-icon/action-icon';
import { getExtMode, isNotEmpty } from '@/nice-router/nice-router-util';
import { Text, View } from '@tarojs/components';

import EleBadge from '@/components/elements/ele-badge/ele-badge';
import EleButton, { EleButtonProps } from '@/components/elements/ele-button';

import './navigation-box.scss';

type NavigationBoxItem = { badge?: number } & EleButtonProps;

type NavigationBoxProps = {
  title?: string;
  items: NavigationBoxItem[];
  mode?: 'round-bottom' | 'round-top';
  className?: string;
};

function NavigationBox(props: NavigationBoxProps) {
  const { title: actionBarTitle = '', items = [], className, mode } = props;

  const rootClass = getExtMode(mode, { center: items.length <= 5 }).classNames('navigation-box', className);

  return (
    <View className={rootClass}>
      {isNotEmpty(actionBarTitle) && <View className='navigation-box-title'>{actionBarTitle}</View>}
      <View className='navigation-box-actions'>
        {items.map((it) => {
          const { icon, imageUrl, title, badge, disabled } = it;
          const itemClass = getExtMode({ disabled }).classNames('navigation-box-item');

          return (
            <EleButton mode='ghost' key={`${it.id}_${it.code}`} className={itemClass} {...it}>
              <EleBadge value={badge}>
                <ActionIcon icon={icon} imageUrl={imageUrl} />
                <Text className='navigation-box-item-title'>{title}</Text>
              </EleBadge>
            </EleButton>
          );
        })}
      </View>
    </View>
  );
}

export default NavigationBox;
