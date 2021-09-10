import ServerImage from '@/server-image/server-image';
import { View } from '@tarojs/components';
import Taro from '@tarojs/taro';
import classNames from 'classnames';
import TagList from '@/components/elements/ele-tag/tag-list';
import { isNotEmpty } from '@/nice-router/nice-router-util';
import { EleTagProps } from '@/components/elements/ele-tag/ele-tag';
import { EleObject, IconLike, ImageLike } from '@/nice-router/nice-router-types';
import './styles.scss';

type EleStoreLocationProps = {
  address?: string;
  iconColor?: string;
  phoneNumber?: string;
  summary?: string;
  tags?: EleTagProps[];
  longitude?: string;
  latitude?: string;
  className?: string;
} & ImageLike &
  IconLike &
  EleObject;

function EleStoreLocation(props: EleStoreLocationProps) {
  const { longitude, latitude, address, phoneNumber, tags, className, brief, title, imageUrl } = props;

  const makePhoneCall = () => {
    if (phoneNumber) {
      // noinspection JSIgnoredPromiseFromCall
      Taro.makePhoneCall({
        phoneNumber,
      });
    }
  };

  const showLocation = () => {
    if (longitude && latitude) {
      const location = {
        latitude: parseFloat(latitude),
        longitude: parseFloat(longitude),
        scale: 18,
        name: address,
      };
      // noinspection JSIgnoredPromiseFromCall
      Taro.openLocation(location);
    }
  };

  const rootClass = classNames('ele-store-location', className);

  return (
    <View className={rootClass}>
      <View className='header'>
        <ServerImage className='header-image' src={imageUrl} mode='widthFix' />
        <View className='header-right'>
          <View className='header-right-name'>{title}</View>
          {isNotEmpty(brief) && <View className='header-right-summary'>{brief}</View>}
          <TagList items={tags} />
        </View>
      </View>
      {isNotEmpty(address) && (
        <View className='info-item' onClick={showLocation}>
          <View className='iconfont iconfont-location' />
          <View className='info-item-txt'>{address}</View>
        </View>
      )}

      {isNotEmpty(phoneNumber) && (
        <View className='info-item' onClick={makePhoneCall}>
          <View className='iconfont iconfont-phone' />
          <View className='info-item-txt'>{phoneNumber}</View>
        </View>
      )}
    </View>
  );
}

export default EleStoreLocation;
