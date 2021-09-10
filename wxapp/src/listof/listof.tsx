import NavigationService from '@/nice-router/navigation-service';
import { getExtMode, isEmpty, LoadingType } from '@/nice-router/nice-router-util';
import { ScrollView, Text, View } from '@tarojs/components';

import FooterTips from '@/listof/footer-tips';
import { useLoading } from '@/service/use-service';
import ActionUtil from '@/nice-router/action-util';

import { enrichListOfEntity } from '../utils';
import ListofUtil from './listof-util';
import './listof.scss';
import FlexLineItem, { FlexLineItemProps } from './templates/flex-line-item';

export type ListofProps = {
  list?: FlexLineItemProps[];
  items?: FlexLineItemProps[];
  emptyMessage?: string;
  dataContainer?: Record<string, any>;
  listMeta?: Record<string, any>;
  displayMode?: string;
  onItemClick?: Function;
  horizontal?: boolean;
  longList?: boolean;
  height?: number | string;
  mode?: 'horizontal' | 'vertical';
  className?: string;
};

function Listof(props: ListofProps) {
  const { loading, showLoading, hideLoading } = useLoading(false);
  const { list, items, emptyMessage } = props;
  const theList: any[] = list || items || [];

  if (isEmpty(theList)) {
    if (isEmpty(emptyMessage)) {
      return null;
    }
    return <Text className='listof-empty-message'>{emptyMessage}</Text>;
  }

  const { dataContainer, listMeta = {}, displayMode, onItemClick, horizontal = false } = props;
  const { longList = false, mode, className, height } = props;

  const hasNextPage = ActionUtil.isActionLike(listMeta);
  //longList=无限循环list 展示footer
  let showFooter = longList;
  //但是，如果没有下一页，且list比较小, 就不展示footer了
  if (!hasNextPage && theList.length < 15) {
    showFooter = false;
  }

  const loadMore = () => {
    if (!hasNextPage) {
      return;
    }

    showLoading();
    NavigationService.ajax(
      listMeta,
      {},
      {
        loading: LoadingType.BarLoading,
        arrayMerge: 'append',
        onSuccess: () => {
          hideLoading();
        },
      }
    );
  };

  // @ts-ignore
  const flexLineItems = enrichListOfEntity({ dataContainer, targetList: theList });

  const itemWidth = ListofUtil.getItemWidth(displayMode);
  const rootClass = getExtMode({ horizontal }, mode).classNames('listof-view', className);
  const containerClass = getExtMode({ multiple: itemWidth }).classNames('listof-view-container');

  return (
    <ScrollView
      className={rootClass}
      scrollY={!horizontal}
      scrollX={horizontal}
      lowerThreshold={100}
      onScrollToLower={loadMore}
      style={{ height }}
    >
      <View className={containerClass}>
        {flexLineItems.map((item, index) => (
          <FlexLineItem
            key={`${item.id}_${item.code}_${item.title}`}
            index={index}
            item={item}
            onItemClick={onItemClick}
            displayMode={displayMode}
            horizontal={horizontal}
          />
        ))}
      </View>

      {showFooter && <FooterTips hasNextPage={hasNextPage} loading={loading} onLoadMore={loadMore} />}
    </ScrollView>
  );
}

export default Listof;
