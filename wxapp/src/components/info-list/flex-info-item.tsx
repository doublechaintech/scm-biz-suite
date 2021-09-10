import TagList from '@/components/elements/ele-tag/tag-list';
import { isEmpty, isNotEmpty } from '@/nice-router/nice-router-util';
import classNames from 'classnames';
import { View } from '@tarojs/components';

import { isMultiline } from './info-list-util';
import DetailDateTime from './items/info-datetime';
import InfoFile from './items/info-file';
import InfoImage from './items/info-image';
import InfoImageList from './items/info-image-list';
import InfoMobile from './items/info-mobile';
import InfoObjectLink from './items/info-object-link';
import InfoStatus from './items/info-status';
import InfoText from './items/info-text';
import InfoUser from './items/info-user';

import './styles.scss';

export type FlexInfoItemProps = {
  title: string;
  value?: any;
  multiline?: boolean;
  type:
    | 'money'
    | 'longtext'
    | 'mobile'
    | 'auto'
    | 'user'
    | 'status'
    | 'date'
    | 'datetime'
    | 'document'
    | 'image'
    | 'image-list'
    | 'tag-list';
};

function RenderInfoItem(props) {
  const { type } = props;

  if (type === 'money') return <InfoText className='info-money' mode={['bold']} {...props} />;
  if (type === 'longtext') return <InfoText className='info-longtext' {...props} />;
  if (type === 'mobile') return <InfoMobile {...props} />;

  if (type === 'auto') return <InfoObjectLink {...props} />;
  if (type === 'user') return <InfoUser {...props} />;

  if (type === 'status') return <InfoStatus {...props} />;
  if (type === 'date') return <DetailDateTime {...props} />;
  if (type === 'datetime') return <DetailDateTime format='yyyy-MM-dd HH:mm' {...props} />;

  if (type === 'document') return <InfoFile {...props} />;
  if (type === 'image') return <InfoImage {...props} />;
  if (type === 'image-list') return <InfoImageList {...props} />;
  if (type === 'tag-list') return <TagList {...props} />;
  return <InfoText {...props} />;
}

function FlexInfoItem(props: FlexInfoItemProps) {
  const { title, value } = props;

  if (isEmpty(value)) {
    return null;
  }

  const multiline = isMultiline(props);
  console.log('multiline', multiline, props);
  const rootClass = classNames('info-item', {
    'info-item--multiline': multiline,
  });

  return (
    <View className={rootClass}>
      {isNotEmpty(title) && <View className='info-item-title'>{title}</View>}
      <View className='info-item-value'>
        <RenderInfoItem {...props} />
      </View>
    </View>
  );
}

FlexInfoItem.defaultProps = {
  type: 'text',
};

export default FlexInfoItem;
