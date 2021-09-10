import { useState } from 'react';
import { ScrollView } from '@tarojs/components';
import { AtCurtain } from 'taro-ui';

import EleFlex from './ele-flex';

export default function ElePopup(props: Record<string, any>) {
  const [show, setShow] = useState(true);
  const onClose = () => setShow(false);

  return (
    <AtCurtain isOpened={show} onClose={onClose}>
      <ScrollView scrollY scrollWithAnimation scrollTop={0} style='max-height: 750rpx;'>
        <EleFlex {...props} />
      </ScrollView>
    </AtCurtain>
  );
}
