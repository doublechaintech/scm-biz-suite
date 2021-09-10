import SearchBar from '@/listof/search-bar';
import EleTabs from '@/components/elements/ele-tabs';
import FlexLineItem, { FlexLineItemProps } from '@/listof/templates/flex-line-item';

type FlexHeaderProps = {
  type?: 'search' | 'tabs' | string;
  tabsType?: string;
  tabs?: any;
} & Partial<FlexLineItemProps>;

export default function FlexHeader(props: FlexHeaderProps) {
  const { type, ...others } = props;
  if (type === 'search') return <SearchBar {...others} />;
  if (type === 'tabs') return <EleTabs {...others} />;
  return <FlexLineItem {...props} />;
}
