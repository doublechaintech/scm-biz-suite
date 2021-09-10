import NavigationService from '@/nice-router/navigation-service';
import { isNotEmpty } from '@/nice-router/nice-router-util';
import { Text, View } from '@tarojs/components';
import _ from 'lodash';

import './styles.scss';

function DetailObject(props) {
  const { id, schema } = props;
  const { displayMode } = schema;
  const title = props[displayMode.title];
  const brief = props[displayMode.brief];

  const onClick = _.debounce(() => {
    NavigationService.view(schema.linkToUrl, { id });
  }, 500);

  return (
    <View className='detail-object' onClick={onClick}>
      <Text className='detail-object-title'>{title}</Text>
      {isNotEmpty(brief) && <Text className='detail-object-brief'>({brief})</Text>}
    </View>
  );
}

DetailObject.defaultProps = {
  schema: {
    displayMode: '{}',
  },
};

export default DetailObject;
