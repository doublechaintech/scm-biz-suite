import { isEmpty, isNotEmpty, noop } from '@/nice-router/nice-router-util';

import { useVisible } from '@/service/use-service';
import { Text, View } from '@tarojs/components';
import classNames from 'classnames';
import './style.scss';

export type TreeProps = {
  id?: string;
  selected?: boolean;
  onChange?: Function;
  value?: any;
  disabled?: boolean;
  nodes: TreeProps[];
  expandAll?: boolean;
  title?: string;
  brief?: string;
};

function Tree(props: TreeProps) {
  const { visible, toggle } = useVisible();
  const { selected, onChange = noop, value, disabled, nodes, expandAll, title, brief } = props;
  const handleItemSelect = () => {
    if (disabled) {
      return;
    }
    const isLeaf = isEmpty(nodes);
    if (isLeaf) {
      onChange(value);
    } else {
      toggle();
    }
  };

  const isTrunk = isNotEmpty(nodes);
  const isSelected = selected === value;
  const subTreeClass = classNames('tree-subtree', { hidden: !visible });
  const treeItemClass = classNames('tree-item', { selected: isSelected, disabled });

  return (
    <View className='tree'>
      <View className={treeItemClass} onClick={handleItemSelect}>
        {isTrunk && (
          <View className='tree-item-action-icon'>
            {visible ? <View className='iconfont iconfont-down' /> : <View className='iconfont iconfont-right' />}
          </View>
        )}

        <Text className='tree-item-title'>{title}</Text>
        <Text className='tree-item-brief'>{brief}</Text>

        {isSelected && (
          <View className='tree-item-selected-icon'>
            <View className='iconfont iconfont-check' />
          </View>
        )}
      </View>

      <View className={subTreeClass}>
        {nodes.map((it, idx) => (
          <Tree key={`${it.id}_${idx}`} selected={selected} onChange={onChange} expandAll={expandAll} {...it} />
        ))}
      </View>
    </View>
  );
}

Tree.defaultProps = {
  expandAll: false,
  nodes: [],
  onChange: noop,
};

export default Tree;
