import { View } from '@tarojs/components';
import classNames from 'classnames';
import { isEmpty, isNotEmpty } from '@/nice-router/nice-router-util';
import PropItem from './index';
import './styles.scss';

const SHOW_AS_MULTIPLE_LINE = ['image', 'image-list', 'longtext'];

export default function DetailPropList(props) {
  const { className, list = [] } = props;
  const rootCls = classNames('prop-list', className);
  if (isEmpty(list)) {
    return null;
  }
  return (
    <View className={rootCls}>
      {list.map((schema) => {
        const { id, type, label, item } = schema;
        const multiLine = SHOW_AS_MULTIPLE_LINE.includes(type);
        const itemCls = classNames('prop-list-item', { inline: !multiLine });
        return (
          <View key={id} className={itemCls}>
            {isNotEmpty(label) && <View className='prop-list-item-label'>{label}</View>}
            <View className='prop-list-item-value'>
              <PropItem type={type} item={item} schema={schema} />
            </View>
          </View>
        );
      })}
    </View>
  );
}
