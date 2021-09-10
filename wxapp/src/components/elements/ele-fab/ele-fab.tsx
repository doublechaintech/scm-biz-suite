import EleButton, { EleButtonProps } from '@/components/elements/ele-button';
import { View } from '@tarojs/components';
import { getExtMode } from '@/nice-router/nice-router-util';
import './ele-fab.scss';

type EleFabProps = {
  mode?: 'round' | 'left-side';
} & EleButtonProps;

export default function EleFab(props: EleFabProps) {
  const { mode = 'round', className, ...others } = props;
  const rootClass = getExtMode(mode).classNames('ele-fab', className);
  return (
    <View className={rootClass}>
      <EleButton mode='ghost' {...others} />
    </View>
  );
}
