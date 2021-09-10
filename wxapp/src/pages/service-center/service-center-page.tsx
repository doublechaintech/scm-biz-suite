import { useEffect, useState } from 'react';
import NavigationBox from '@/components/navigation/navigation-box';
import NavigationService from '@/nice-router/navigation-service';
import { usePageTitle, usePullDown } from '@/service/use-service';
import { View } from '@tarojs/components';
import classNames from 'classnames';
import _ from 'lodash';
import { AtGrid, AtSearchBar } from 'taro-ui';
import { useSelector } from 'react-redux';
import EleTag from '@/components/elements/ele-tag/ele-tag';
import './styles.scss';
import { ApiConfig } from '@/utils/config';

function ServiceCenterPage() {
  const root = useSelector((state) => state.serviceCenter);
  const [keyword, setKeyword] = useState<string>('');
  const [searchHistory, setSearchHistory] = useState<string[]>([]);

  const { pageTitle } = root;
  usePageTitle(pageTitle);
  usePullDown(ApiConfig.FooterServiceCenter);

  useEffect(() => {
    NavigationService.view(ApiConfig.FooterServiceCenter);
  }, []);

  const handleKeywordSearch = (value: string) => setKeyword(value);

  const onSearchActionClick = () => {
    console.log('开始搜索');
    const txt = _.trim(keyword);
    const notInSearchHistory = searchHistory.findIndex((it) => it === txt) === -1;
    if (notInSearchHistory) {
      const list: any = [txt].concat(searchHistory.slice(0, 5));
      setSearchHistory(list);
    }
  };

  const handleClick = (action) => {
    NavigationService.view(action);
  };

  const { actionList = [], sectionList = [] } = root;
  const historyCls = classNames('search-bar-history', {
    // 'space-around': searchHistory.length === 4,
  });

  const serviceGroup = _.groupBy(sectionList, 'viewGroup');
  const serviceGroupList: any[] = [];

  _.forEach(serviceGroup, (serviceList, groupName = '') => {
    const gridData = serviceList.map((it) => {
      return {
        ...it,
        value: it.title,
        image: it.icon || it.imageUrl,
      };
    });

    const name = groupName === '__no_group' ? '菜单' : groupName;
    serviceGroupList.push({
      id: name,
      name,
      gridData,
    });
  });

  return (
    <View className='service-center-page'>
      <View className='search-bar'>
        <AtSearchBar actionName='搜一下' value={keyword} onChange={setKeyword} onActionClick={onSearchActionClick} />

        {searchHistory.length > 0 && (
          <View className={historyCls}>
            {searchHistory.map((it: string, idx) => {
              return (
                <EleTag
                  key={it + idx}
                  className='search-bar-history-keyword'
                  onClick={handleKeywordSearch.bind(this, it)}
                >
                  {it}
                </EleTag>
              );
            })}
          </View>
        )}
      </View>

      {actionList.length > 0 && (
        <View className='change-request-bar'>
          <NavigationBox items={actionList} title='常用功能' />
        </View>
      )}

      {serviceGroupList.map((it) => {
        const { id, name, gridData } = it;
        return (
          <View className='view-group' key={id}>
            <View className='view-group-title'>{name}</View>
            <View className='grid-container'>
              <AtGrid mode='square' className='service-grid' data={gridData} onClick={handleClick} />
            </View>
          </View>
        );
      })}
    </View>
  );
}

export default ServiceCenterPage;
