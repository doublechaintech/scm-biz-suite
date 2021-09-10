import { useEffect } from 'react';
import EleCarousel from '@/components/elements/ele-carousel';
import SectionBar from '@/components/section-bar/section-bar';
import Listof from '@/listof/listof';
import NavigationService from '@/nice-router/navigation-service';
import { useAjaxPullDown, usePageTitle } from '@/service/use-service';
import { View } from '@tarojs/components';
import { useSelector } from 'react-redux';

import './home.scss';
import { ApiConfig } from '@/utils/config';
import ActionFloor from '@/components/biz/action-floor';

const defaultImageUrl = 'http://www.eastphoto.cn/indexImages/ep-012136603.jpg';

function HomePage() {
  const root = useSelector((state) => state.home);
  usePageTitle(root);
  useAjaxPullDown(root);

  useEffect(() => {
    NavigationService.view(ApiConfig.FooterHome);
  }, []);

  const { slideList = defaultSlideList, actionList = [], sectionList = defaultSectionList } = root;

  return (
    <View className='home-page'>
      <EleCarousel className='home-page-carousel' items={slideList} />
      <View className='home-page-action-floor'>
        <ActionFloor actionList={actionList} />
      </View>
      {sectionList.map((section) => {
        const { id, title, linkToUrl, brief, displayMode } = section;
        const list = root[id] || [];
        return (
          <View key={`${id}_${title}`} className='home-page-section'>
            <SectionBar title={title} brief={brief} linkToUrl={linkToUrl} />
            <Listof list={list} displayMode={displayMode} />
          </View>
        );
      })}
    </View>
  );
}

export default HomePage;

const defaultSlideList = [
  { id: 1, videoUrl: defaultImageUrl, imageUrl: defaultImageUrl },
  { id: 2, imageUrl: defaultImageUrl },
];
const defaultSectionList = [{ id: 1, title: '业务列表', brief: 'EnglishName', linkToUrl: './', list: [] }];
