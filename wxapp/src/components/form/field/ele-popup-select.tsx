import { isEmpty, noop } from '@/nice-router/nice-router-util';
import { useVisible } from '@/service/use-service';
import _ from 'lodash';
import { AtActionSheet, AtActionSheetItem, AtCheckbox, AtRadio } from 'taro-ui';
import { CandidateValue } from '@/nice-router/nice-router-types';
import ActionField from './action-field';
import './styles.scss';

type ElePopupSelectProps = {
  onChange?: Function;
  multiple?: boolean;
  value: string | string[];
  placeholder?: string;
  label?: string;
  candidateValues: CandidateValue[];
  disabled?: boolean;
};

function ElePopupSelect(props: ElePopupSelectProps) {
  const { visible, show, close } = useVisible(false);

  const { onChange = noop, multiple, value, placeholder, label, candidateValues, disabled } = props;

  const handleChange = (v) => {
    onChange(v);
    if (!multiple) {
      close();
    }
  };

  const getValue = () => {
    let currentValue = value;
    if (isEmpty(value)) {
      currentValue = multiple ? [] : '';
    }
    if (multiple && _.isString(value)) {
      currentValue = [value];
    }

    const displayValue = candidateValues
      // @ts-ignore
      .filter((it) => (multiple ? currentValue.includes(it.id) : currentValue === it.id))
      .map((it) => it.title)
      .join('、');

    return {
      currentValue,
      displayValue,
    };
  };

  const { currentValue, displayValue } = getValue();

  const options = candidateValues.map((it) => ({
    label: it.title,
    value: it.id,
    ...it,
  }));

  const cancelText = multiple ? '确定' : '取消';

  return (
    <ActionField
      onClick={show}
      disabled={disabled}
      value={displayValue}
      placeholder={placeholder}
      toggleStatus={visible}
    >
      <AtActionSheet title={label} onClose={close} isOpened={visible} cancelText={cancelText}>
        <AtActionSheetItem className='popup-view'>
          {multiple ? (
            // @ts-ignore
            <AtCheckbox options={options} selectedList={currentValue} onChange={handleChange} />
          ) : (
            // @ts-ignore
            <AtRadio options={options} value={currentValue} onClick={handleChange} />
          )}
        </AtActionSheetItem>
      </AtActionSheet>
    </ActionField>
  );
}

ElePopupSelect.defaultProps = {
  multiple: false,
  value: [],
  candidateValues: [],
};

export default ElePopupSelect;
