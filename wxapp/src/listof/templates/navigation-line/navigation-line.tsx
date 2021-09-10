import { View } from '@tarojs/components';
import ActionIcon from '@/components/action-icon/action-icon';
import { isEmpty } from '@/nice-router/nice-router-util';
import ActionUtil from '@/nice-router/action-util';
import EleButton, { EleButtonProps } from '@/components/elements/ele-button';

import './navigation-line.scss';

type NavigationLineProps = {
  secondTitle?: string;
  prefixIcon?: string;
  prefixImageUrl?: string;
} & EleButtonProps;

export default function NavigationLine(props: NavigationLineProps) {
  const { title, secondTitle, brief, icon, imageUrl, prefixIcon, prefixImageUrl, ...others } = props;

  const useDefaultPrefix = isEmpty(prefixIcon) && isEmpty(prefixImageUrl);

  let showDefaultRightIcon = ActionUtil.isActionLike(props) && isEmpty(icon) && isEmpty(imageUrl);
  const theAction = showDefaultRightIcon ? 'right' : icon;

  return (
    <EleButton mode='ghost' {...others}>
      <View className='navigation-line'>
        <View className='navigation-line-header'>
          {useDefaultPrefix ? (
            <View className='navigation-line-header-prefix' />
          ) : (
            <ActionIcon icon={prefixIcon} imageUrl={prefixImageUrl} />
          )}
        </View>

        <View className='navigation-line-body'>
          <View className='navigation-line-title'>{title}</View>
          <View className='navigation-line-second-title'>{secondTitle}</View>
        </View>

        <View className='navigation-line-footer'>
          <View className='navigation-line-brief'>{brief}</View>
          <ActionIcon icon={theAction} imageUrl={imageUrl} />
        </View>
      </View>
    </EleButton>
  );
}
