import { View } from '@tarojs/components';

import EleActionList from '@/components/elements/action-list/ele-action-list';
import './styles.scss';

function DetailFile({ documentUrl }) {
  return (
    <View className='detail-file'>
      <EleActionList
        mode='small'
        items={[
          {
            id: 'open-document',
            type: 'open-document',
            linkToUrl: documentUrl,
            title: '查看',
          },
          {
            id: 'download-document',
            type: 'download',
            linkToUrl: documentUrl,
            title: '下载',
          },
          {
            id: 'download-copy',
            type: 'copy',
            title: '分享',
            extraData: documentUrl,
          },
        ]}
      />
    </View>
  );
}

export default DetailFile;
