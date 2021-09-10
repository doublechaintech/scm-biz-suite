import { useVisible } from '@/service/use-service';
import { View, WebView } from '@tarojs/components';
import { AtActivityIndicator } from 'taro-ui';
import { Current } from '@tarojs/taro';

export type H5PageProps = {
  uri: string;
};

export default function H5Page() {
  const { visible, close } = useVisible(true);
  const { uri = '' } = (Current.router?.params || {}) as H5PageProps;
  const src = decodeURIComponent(uri);
  console.log('action path in H5', src);
  return (
    <View>
      <AtActivityIndicator isOpened={visible} size={50} mode='center' />
      <WebView src={src} onLoad={close} />
    </View>
  );
}
