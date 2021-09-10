import BasePage from '@/components/base-page';
import ActionHeader from '@/components/biz/action-header';
import SectionBar from '@/components/section-bar/section-bar';
import Listof from '@/listof/listof';
import NavigationService from '@/nice-router/navigation-service';
import { useAjaxPullDown, usePageTitle } from '@/service/use-service';

import EleActionList from '@/components/elements/action-list/ele-action-list';
import { getActionListByGroupName, groupActionAsList } from '@/utils/index';
import { Block, View } from '@tarojs/components';
import { AtGrid } from 'taro-ui';
import { isNotEmpty } from '@/nice-router/nice-router-util';
import EleRichText from '@/components/elements/ele-rich-text';
import './styles.scss';
import DetailPropList from './prop-item/detail-prop-list';

function DetailPageBase(props) {
  const { pageTitle, richContent } = props;
  usePageTitle(pageTitle);
  useAjaxPullDown(props);
  const { propList, sectionList, slideList } = props;
  const shortcutActionList = getActionListByGroupName(props.actionList, 'short_cut');
  const footerActionList = getActionListByGroupName(props.actionList, 'footer');
  const actionGroupList = groupActionAsList(props.actionList, [], ['short_cut', 'footer', 'fab']);
  const fabAction = getActionListByGroupName(props.actionList, 'fab')[0];

  const handleClick = (action, id) => {
    NavigationService.view(action, { id });
  };

  const commonPropList = propList.map((it) => {
    return {
      ...it,
      item: props[it.fieldName],
    };
  });

  return (
    <BasePage>
      <View className='detail-page'>
        <ActionHeader slideList={slideList} actionList={shortcutActionList} />
        {isNotEmpty(fabAction) && (
          <View className='detail-page-fab' onClick={() => NavigationService.view(fabAction)}>
            {fabAction.title}
          </View>
        )}

        {isNotEmpty(richContent) && <EleRichText content={richContent} />}

        <DetailPropList list={commonPropList} className={sectionList.length > 0 && 'hasSection'} />

        {actionGroupList.map((group) => {
          console.log('group....', group);
          const data: any = group.actionList.map((it) => ({
            ...it,
            value: it.title,
            image: it.imageUrl,
            iconInfo: it.icon,
          }));
          return (
            <View key={group.id} className='action-list'>
              <SectionBar title={group.name} />
              <View className='action-list-grid'>
                <AtGrid mode='square' className='service-grid' data={data} onClick={handleClick} />
              </View>
            </View>
          );
        })}

        {sectionList.map((section) => {
          const { id, title, linkToUrl, brief, displayMode, horizontal } = section;
          const list = props[id] || [];
          const specialProps = horizontal
            ? {
                containerClass: ['space-between-container', 'section-list-container'],
                horizontal: true,
                height: 175,
                bordered: false,
              }
            : {};
          return (
            <Block key={`${id}_${title}`}>
              <View className='section-list-section-bar'>
                <SectionBar title={title} brief={brief} linkToUrl={linkToUrl} />
              </View>
              <Listof list={list} displayMode={displayMode} {...specialProps} />
            </Block>
          );
        })}

        <EleActionList mode={['footer-bar', 'colorful']} items={footerActionList} />
      </View>
    </BasePage>
  );
}

DetailPageBase.defaultProps = {
  propList: [],
  actionList: [],
  sectionList: [],
  footerActionList: [],
};

export default DetailPageBase;
