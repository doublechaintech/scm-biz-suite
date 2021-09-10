import { useVisible } from '@/service/use-service';
import { noop } from '@/nice-router/nice-router-util';
import TagList from '@/components/elements/ele-tag/tag-list';
import ActionField from '@/components/form/field/action-field';
import { AtFloatLayout } from 'taro-ui';
import { View } from '@tarojs/components';
import { CandidateValue } from '@/nice-router/nice-router-types';
import './ele-tag-picker.scss';

type EleTagPickerProps = {
  title?: string;
  value?: any;
  candidateValues?: CandidateValue[];
  onChange?: Function;
  disabled?: boolean;
  placeholder?: string;
};

export default function EleTagPicker(props: EleTagPickerProps) {
  const { visible, toggle, close } = useVisible(false);

  const { title, value, candidateValues, onChange = noop, disabled, placeholder = '请选择...', ...others } = props;

  const handleClick = () => !disabled && toggle();

  const handleCommit = (item) => {
    onChange(item);
    close();
  };

  const theValue = value?.title || value;

  return (
    <ActionField
      className='ele-tag-pricker'
      onClick={handleClick}
      disabled={disabled}
      value={theValue}
      placeholder={placeholder}
      toggleStatus={visible}
    >
      <AtFloatLayout className='large-float-layout' isOpened={visible} onClose={close} title={title}>
        <View className='ele-tag-pricker-body'>
          <TagList {...others} items={candidateValues} onItemClick={handleCommit} />
        </View>
      </AtFloatLayout>
    </ActionField>
  );
}
