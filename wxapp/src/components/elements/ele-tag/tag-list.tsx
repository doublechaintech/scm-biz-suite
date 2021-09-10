import { useEffect, useState } from 'react';
import { View } from '@tarojs/components';
import _ from 'lodash';
import { noop } from '@/nice-router/nice-router-util';
import EleTag, { EleTagProps } from '@/components/elements/ele-tag/ele-tag';
import './tag-list.scss';

type TagListProps = {
  onItemClick?: Function;
  onChange?: Function;
  multiple?: boolean;
  disabled?: boolean;
  items?: EleTagProps[];
};

export default function TagList(props: TagListProps) {
  const [tagList, setTagList] = useState<EleTagProps[]>([]);
  const { onItemClick = noop, onChange = noop, multiple = false, disabled } = props;

  useEffect(() => {
    setTagList(props.items || []);
  }, [props]);

  const handleClick = (item) => {
    if (disabled) {
      return;
    }

    const theItem = {
      ...item,
      selected: !item.selected,
    };
    const result = _.clone(tagList).map((it) => {
      if (it.id === item.id) {
        return theItem;
      }
      return multiple ? it : { ...it, selected: false };
    });

    onItemClick(theItem);
    onChange(result);
    setTagList(result);
  };

  return (
    <View className='tag-list'>
      {tagList.map((it, idx) => {
        const tag = _.isString(it) ? { title: it, id: `tag-${idx}` } : it;
        const key = `tag-item-${idx}-${tag.id}-${it.title}`;
        return <EleTag key={key} {...tag} onClick={handleClick.bind(null, it)} />;
      })}
    </View>
  );
}
