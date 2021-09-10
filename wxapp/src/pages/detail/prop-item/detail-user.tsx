import NavigationService from '@/nice-router/navigation-service';
import { isNotEmpty } from '@/nice-router/nice-router-util';
import ImageTools, { ImageSize } from '@/server-image/image-tools';
import ServerImage from '@/server-image/server-image';
import { Text, View } from '@tarojs/components';
import Taro from '@tarojs/taro';
import _ from 'lodash';
import './styles.scss';

function DetailUser(props) {
  const { id, schema } = props;
  const { displayMode } = schema;
  const title = props[displayMode.title];
  const imageUrl = props[displayMode.imageUrl];
  const brief = props[displayMode.brief] || '牛逼';

  const onClick = _.debounce(() => {
    NavigationService.view(schema.linkToUrl, { id });
  }, 500);

  const onImagePreview = () => {
    const url = ImageTools.getServerImagUrl(imageUrl, ImageSize.Origin);
    Taro.previewImage({ urls: [url] });
  };

  return (
    <View className='detail-user'>
      <View className='detail-user-avatar' onClick={onImagePreview}>
        <ServerImage src={imageUrl} size={ImageSize.Middle} />
      </View>
      <View className='detail-user-content' onClick={onClick}>
        <Text className='detail-user-content-title'>{title}</Text>
        {isNotEmpty(brief) && <Text className='detail-user-content-brief'>{brief}</Text>}
      </View>
    </View>
  );
}

DetailUser.defaultProps = {
  schema: {
    displayMode: '{}',
  },
};

export default DetailUser;
