import NavigationService from '@/nice-router/navigation-service';
import { isNotEmpty } from '@/nice-router/nice-router-util';
import ImageTools, { ImageSize } from '@/server-image/image-tools';
import ServerImage from '@/server-image/server-image';
import { Text, View } from '@tarojs/components';
import Taro from '@tarojs/taro';
import ActionUtil from '@/nice-router/action-util';
import _ from 'lodash';
import classNames from 'classnames';
import { ActionLike, EleObject, ImageLike } from '@/nice-router/nice-router-types';
import './styles.scss';

type InfoUserProps = ImageLike & EleObject & ActionLike;

function InfoUser(props: InfoUserProps) {
  const { id, title, brief, imageUrl } = props;

  const onClick = _.debounce(() => {
    NavigationService.view(props, { id });
  }, 500);

  const onImagePreview = () => {
    const url = ImageTools.getServerImagUrl(imageUrl, ImageSize.Origin);
    Taro.previewImage({ urls: [url] });
  };

  const contentClass = classNames('info-user-content', {
    clickable: ActionUtil.isActionLike(props),
  });

  return (
    <View className='info-user'>
      <View className='info-user-avatar' onClick={onImagePreview}>
        <ServerImage src={imageUrl} size={ImageSize.Middle} />
      </View>
      <View className={contentClass} onClick={onClick}>
        <Text className='info-user-content-title'>{title}</Text>
        {isNotEmpty(brief) && <Text className='info-user-content-brief'>{brief}</Text>}
      </View>
    </View>
  );
}

InfoUser.defaultProps = {
  id: '',
  title: '',
  brief: '',
  imageUrl: '',
  linkToUrl: '',
};

export default InfoUser;
