import { useState } from 'react';
import NavigationService from '@/nice-router/navigation-service';
import { AtTabBar } from 'taro-ui';
import { CandidateValue, ImageLike } from '@/nice-router/nice-router-types';

type EleFooterTabItemProps = CandidateValue & ImageLike;
type EleFooterTabsProps = {
  tabs: EleFooterTabItemProps[];
  onClick?: (item: any) => void;
};

function EleFooterTabs(props: EleFooterTabsProps) {
  const [selectedIndex, setSelectedIndex] = useState<number>(0);

  const { tabs, onClick } = props;

  const selectTab = (value: number) => {
    setSelectedIndex(value);
    const selected = tabs[value];
    if (onClick) {
      onClick(selected);
      return;
    }
    NavigationService.view(selected);
  };

  const current = selectedIndex !== null ? selectedIndex : tabs.findIndex((it) => it.selected);
  const tabList: any = tabs.map((it) => ({ ...it, image: it.imageUrl }));

  return <AtTabBar fixed tabList={tabList} onClick={selectTab} current={current} />;
}

EleFooterTabs.defaultProps = {
  tabs: [],
};
export default EleFooterTabs;
