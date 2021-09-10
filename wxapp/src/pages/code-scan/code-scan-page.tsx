import { useEffect, useState } from 'react';
import Taro from '@tarojs/taro';
import { Text, View } from '@tarojs/components';
import NavigationService from '@/nice-router/navigation-service';

import EleButton from '@/components/elements/ele-button';
import './code-scan.scss';
import { ActionLike, EleObject } from '@/nice-router/nice-router-types';

const CURRENT_LINK_TO_URL = 'scan';

function CodeScanPage() {
  const [root, setRoot] = useState<EleObject & ActionLike>({});
  const { brief = '专属功能', title = '扫码点我', linkToUrl } = root;

  useEffect(() => {
    NavigationService.ajax(
      CURRENT_LINK_TO_URL,
      {},
      {
        onSuccess: (resp) => {
          setRoot(resp);
        },
      }
    );
  }, []);

  const handleClickScan = async () => {
    const res = await Taro.scanCode({});
    const result = encodeURIComponent(res.result);
    NavigationService.view(linkToUrl, { result });
  };

  return (
    <View className='code-scan-page'>
      <View className='code-scan-page-header'>
        <View className='scan-icon' onClick={handleClickScan}>
          <Text className='iconfont iconfont-scan' />
        </View>
        <View className='scan-btn' onClick={handleClickScan}>
          <EleButton>{title}</EleButton>
        </View>
      </View>

      <View className='code-scan-page-body'>{brief}</View>
    </View>
  );
}

export default CodeScanPage;
