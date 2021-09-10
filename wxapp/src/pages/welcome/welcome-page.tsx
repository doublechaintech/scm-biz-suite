import { useEffect } from 'react';
import EleCarousel from '@/components/elements/ele-carousel';
import ActionFloor from '@/components/biz/action-floor';
import SectionBar from '@/components/section-bar/section-bar';
import Listof from '@/listof/listof';
import { useAjaxPullDown, usePageTitle } from '@/service/use-service';
import { View } from '@tarojs/components';
import { useSelector } from 'react-redux';
import NavigationService from '@/nice-router/navigation-service';

import './home.scss';

function WelcomePage(props) {
  const root = useSelector((state) => state.home);
  usePageTitle(root);
  useAjaxPullDown(props);

  useEffect(() => {
    NavigationService.ajax('mock-home-page/');
  }, []);

  const { slideList = [], actionList = [], productList = [] } = root;

  return (
    <View className='home-page'>
      <EleCarousel className='home-page-carousel' items={slideList} />
      <View className='home-page-action-floor'>
        <ActionFloor actionList={actionList} />
        <SectionBar title='促销抢购' linkToUrl='page:///pages/biz/listof-test-page' />
        <Listof list={productList} displayMode='product' />
        <Listof list={productList} displayMode='product' />
      </View>
    </View>
  );
}

export default WelcomePage;
