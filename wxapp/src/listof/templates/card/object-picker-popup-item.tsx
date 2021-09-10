import { View } from '@tarojs/components';
import CardTemplate from './card-template';
import NavigationService from '@/nice-router/navigation-service';
import './object-picker-item.scss';

function ObjectPickerPopupItem(props) {
  const { item } = props;
  const handleClick = () => NavigationService.dispatch('objectPicker/removeSelectItem', item);
  return (
    <View className='object-picker-item' onClick={handleClick}>
      <CardTemplate {...props} />
      <View className='object-picker-item-option' onClick={handleClick}>
        移除{' '}
      </View>
    </View>
  );
}

export default ObjectPickerPopupItem;
