import { useEffect, useState } from 'react';
import SectionBar from '@/components/section-bar/section-bar';
import Listof from '@/listof/listof';
import { View } from '@tarojs/components';

import NavigationService from '@/nice-router/navigation-service';

import './styles.scss';

function HelloDaaSPage() {
  const [root, setRoot] = useState<any>({});

  useEffect(() => {
    NavigationService.ajax(
      'mock-listof-test/',
      {},
      {
        onSuccess: (resp) => {
          setRoot(resp);
        },
      }
    );
  }, []);
  const {
    singleItemList = [],
    productList = [],
    newsList = [],
    cardList = [],
    userList = [],
    movieList = [],
    businessCardList = [],
  } = root;
  return (
    <View className='hello-daas'>
      <SectionBar title='卡片-大卡片' brief='big-card' />
      <Listof list={businessCardList} displayMode='big-card' />
      <Listof list={movieList} displayMode='big-card' />

      <SectionBar title='卡片-水平卡片' brief='h-card' />
      <Listof list={singleItemList} displayMode='h-card' />

      <SectionBar title='卡片-垂直卡片(两个装)' brief='v-card' />
      <Listof list={singleItemList} displayMode='v-card' />

      <SectionBar title='卡片-用户卡片' brief='user' />
      <Listof list={userList} displayMode='user' />

      <SectionBar title='基础卡片' brief='card' />
      <View className='note'>通过mode来控制card，获取更多效果</View>
      <View className='note'>
        mode=horizontal|vertical, circle, avatar,vertical-small, small|large,default|normal|primary|warn|darger
      </View>
      <Listof list={cardList} displayMode='card' />

      {/*<SectionBar title='上图+下文字，水平滑动' brief='displayMode：image-on-top-horizontal' />*/}
      <SectionBar title='电商-商品' brief='product' />
      <Listof list={productList} displayMode='product' />

      <SectionBar title='图文-水平滑动' brief='article-small' />
      <Listof list={movieList} displayMode='article-small' horizontal />

      <SectionBar title='通用图文-Auto系列' />
      <View className='note'> displayMode=auto|single-image|double-image|three-image</View>
      <Listof list={newsList} displayMode='auto' />

      <SectionBar title='图片在下方的Auto' brief='image-on-bottom' />
      <Listof list={newsList.slice(1, 2)} displayMode='image-on-bottom' />
    </View>
  );
}

export default HelloDaaSPage;
