import { useEffect, useState } from 'react';
import NavigationBox from '@/components/navigation/navigation-box';
import MockService from '@/nice-router/request/mock-service';
import ServerImage from '@/server-image/server-image';
import { usePageTitle, usePullDown } from '@/service/use-service';
import { ApiConfig } from '@/utils/config';
import { View } from '@tarojs/components';
import { useSelector } from 'react-redux';
import { useDidShow } from '@tarojs/runtime';
import NavigationService from '@/nice-router/navigation-service';
import { isNotEmpty } from '@/nice-router/nice-router-util';
import EleActionList from '@/components/elements/action-list/ele-action-list';
import Listof from '@/listof/listof';
import EleButton, { EleButtonProps } from '@/components/elements/ele-button';
import classNames from 'classnames';
import './me.scss';

const defaultActionList = [
  {
    id: '4',
    code: 'FINE_DECORATION',
    imageUrl: MockService.randomImage(),
    title: '发起申请',
  },
  {
    id: '3',
    code: 'BIZ_CHAIN',
    icon: 'app-2',
    title: '我发起',
  },
];

function MePage() {
  const root = useSelector((state) => state.me);
  const [footerActionList, setFooterActionList] = useState<EleButtonProps[]>([]);

  usePageTitle(root);
  usePullDown(ApiConfig.FooterMe);
  useEffect(() => {
    NavigationService.ajax(ApiConfig.FooterMe);
  }, []);
  const handleGoLogin = () => NavigationService.navigate('/pages/login/login-page');
  const handleLogout = () => {
    NavigationService.dispatch('app/logout');
    NavigationService.dispatch('me/clear');
    NavigationService.ajax(ApiConfig.Logout);
  };
  useEffect(() => {
    if (isNotEmpty(root)) {
      setFooterActionList([{ id: 'goLogout', title: '退出登录', onClick: handleLogout }]);
    } else {
      setFooterActionList([{ id: 'goLogin', title: '去登陆', onClick: handleGoLogin }]);
    }
  }, [root]);
  useDidShow(() => NavigationService.ajax(ApiConfig.FooterMe));

  const handleUpdateProfileInfo = (e) => console.log('111', e);

  const {
    actionList = defaultActionList,
    navigationLineItems = [],
    name,
    brief,
    userLike = false,
    useMobile = false,
    avatar,
  } = root;

  let userBrief = brief;
  if (useMobile) {
    if (brief) {
      userBrief = `${brief} (更新)`;
    } else {
      userBrief = '授权获取号码';
    }
  }

  const actionListCls = classNames('me-page-header-actions', { 'user-like': userLike });
  return (
    <View className='me-page'>
      <View className='me-page-header'>
        {userLike && (
          <View className='me-page-header-info'>
            <EleButton
              mode='ghost'
              openType='getUserInfo'
              className='transparent-btn'
              onGetUserInfo={handleUpdateProfileInfo}
            >
              <ServerImage className='me-avatar' src={avatar || MockService.randomImage()} />
            </EleButton>

            <View className='me-title'>
              {name && <View className='me-title-name'>{name}</View>}
              <EleButton mode='ghost' openType='getPhoneNumber' className='transparent-btn' disabled={!useMobile}>
                <View className='me-title-brief'>{userBrief}</View>
              </EleButton>
            </View>
          </View>
        )}
        <View className={actionListCls}>
          <NavigationBox items={actionList} />
        </View>
      </View>

      <View className='me-page-body'>
        <Listof items={navigationLineItems} displayMode='navigation-line' />
      </View>

      <EleActionList mode='full' items={footerActionList} />
    </View>
  );
}

export default MePage;
