import ServerImage from '@/server-image/server-image';
import { Text, View } from '@tarojs/components';
import { ActionListLike, EleObject, ImageLike, TitleValue } from '@/nice-router/nice-router-types';

import StatusFlag from '@/components/elements/ele-card/status-flag';
import EleActionList from '@/components/elements/action-list/ele-action-list';
import { getExtMode } from '@/nice-router/nice-router-util';
import CardInfoTable from '@/components/ele-table/card-info-table';
import ListofUtil from '../../listof-util';
import './styles.scss';

type AutoItemProps = {
  status: string;
  infoList?: TitleValue[];
  mode?: 'only-title' | 'image-on-bottom' | 'small';
} & ActionListLike &
  EleObject;

type AutoTemplateProps = {
  item: AutoItemProps;
  showImageCount?: number;
  mode?: 'only-title' | 'image-on-bottom' | 'small';
};

function AutoTemplate(props: AutoTemplateProps) {
  const { item, showImageCount = 3 } = props;
  const { title, brief, infoList = [], status, actionList } = item;

  let list: ImageLike[] = [];
  if (showImageCount > 0) {
    const tempList = ListofUtil.getImageList(item);
    const size = Math.min(showImageCount, tempList.length);
    list = tempList.slice(0, size);
  }

  const rootClass = getExtMode(props.mode, item.mode, { 'only-title': !brief }).classNames('auto');

  return (
    <View className={rootClass}>
      <StatusFlag title={status} size='normal' />
      {list.length > 0 && (
        <View className='auto-image-list'>
          {list.map((it: any, index) => {
            const key = `auto-${index}-${item.id}`;
            return (
              <View key={key} className='auto-image-list-item' style={{ marginLeft: index === 0 ? 0 : '5rpx' }}>
                <ServerImage customStyle={{ width: '100%', height: '100%' }} src={it.imageUrl} />
              </View>
            );
          })}
        </View>
      )}

      <View className='auto-info'>
        <Text className='auto-info-title'>{title}</Text>
        {brief && <Text className='auto-info-brief'>{brief}</Text>}
        {infoList.length > 0 && <CardInfoTable data={infoList} />}
      </View>

      <EleActionList mode={['right', 'small']} className='auto-action-bar' items={actionList} />
    </View>
  );
}

AutoTemplate.defaultProps = {
  item: {},
  showImageCount: 3,
};

export default AutoTemplate;
