import { useEffect, useState } from 'react';
import { View } from '@tarojs/components';
import { AtSearchBar } from 'taro-ui';
import NavigationService from '@/nice-router/navigation-service';
import './search-bar.scss';

export default function SearchBar(props) {
  const [keyword, setKeyword] = useState('');
  const { title, extraData = {} } = props;

  const { pKeyword = '', ...others } = extraData;

  useEffect(() => {
    setKeyword(pKeyword);
  }, [pKeyword]);
  const handleSearch = () => {
    NavigationService.ajax(props, { keyword });
  };
  return (
    <View className='search-bar'>
      <AtSearchBar value={keyword} onChange={setKeyword} actionName={title} onActionClick={handleSearch} {...others} />
    </View>
  );
}
