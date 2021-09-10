import { useVisible } from '@/service/use-service';
import { View } from '@tarojs/components';
import { AtActionSheet } from 'taro-ui';
import ActionField from './action-field';
import './styles.scss';

import Tree, { TreeProps } from './tree/tree';

type EleTreeProps = {
  value?: string;
  title?: string;
  root?: TreeProps;
  onChange?: any;
  disabled?: boolean;
  placeholder?: string;
  label?: string;
};

function findValueFromTheTree(value, treeItem?: TreeProps) {
  const { value: currentValue, title: currentTitle, nodes = [] } = treeItem || {};
  if (currentValue === value) {
    return {
      currentValue: currentValue,
      displayValue: currentTitle,
    };
  }
  for (let i = 0; i < nodes.length; i += 1) {
    const result = findValueFromTheTree(value, nodes[i]);
    if (result) {
      return result;
    }
  }
}

function EleTree(props: EleTreeProps) {
  const { visible, show, close } = useVisible(false);

  const { value, title, root, onChange, disabled, placeholder, label } = props;

  const getValue = () => {
    const result = findValueFromTheTree(value, root);
    if (result) {
      return result;
    }
    return {
      currentValue: value,
      displayValue: value ? title : '',
    };
  };

  const { currentValue, displayValue } = getValue();

  return (
    <ActionField
      onClick={show}
      disabled={disabled}
      value={displayValue}
      placeholder={placeholder}
      toggleStatus={visible}
    >
      <AtActionSheet title={label} onClose={close} isOpened={visible} cancelText='确认'>
        <View style='height:80vh'>
          <Tree {...root} onChange={onChange} selected={currentValue} />
        </View>
      </AtActionSheet>
    </ActionField>
  );
}

EleTree.defaultProps = {
  root: {},
};

export default EleTree;
