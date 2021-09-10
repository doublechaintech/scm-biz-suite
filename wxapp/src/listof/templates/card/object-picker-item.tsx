import { Text, View } from '@tarojs/components';
import NavigationService from '@/nice-router/navigation-service';
import { EleCardProps } from '@/components/elements/ele-card/ele-card';
import CardTemplate from './card-template';
import './object-picker-item.scss';

type ObjectPickerItemItemProps = {
  checked?: boolean;
} & EleCardProps;

type ObjectPickerItemProps = {
  item: ObjectPickerItemItemProps;
};

function ObjectPickerItem(props: ObjectPickerItemProps) {
  const { item } = props;
  const handleClick = () => NavigationService.dispatch('objectPicker/selectItem', item);
  return (
    <View className='object-picker-item' onClick={handleClick}>
      <View className='object-picker-item-option'>
        <Text className={`iconfont iconfont-radio${item.checked ? '-checked' : ''}`} />
      </View>
      <CardTemplate {...props} />
    </View>
  );
}

export default ObjectPickerItem;
