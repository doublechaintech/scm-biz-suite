import { useEffect, useState } from 'react';
import { AtCheckbox, AtRadio } from 'taro-ui';
import { isNotEmpty, noop } from '@/nice-router/nice-router-util';
import { View } from '@tarojs/components';
import { CandidateValue } from '@/nice-router/nice-router-types';
import './styles.scss';

type EleCheckboxProps = {
  candidateValues?: CandidateValue[];
  onChange?: Function;
  value: string[];
  radio?: boolean;
};

function EleCheckbox(props: EleCheckboxProps) {
  const [selected, setSelected] = useState<string[]>();

  const { candidateValues = [], onChange = noop, value, radio = false } = props;

  useEffect(() => {
    if (isNotEmpty(value)) {
      setSelected(value);
    }
  }, [value]);

  const handleClick = (items) => {
    setSelected(items);
    onChange(items);
  };

  const options = candidateValues.map((it) => ({
    value: it.id,
    label: it.title,
    ...it,
  }));

  return (
    <View className='ele-checkbox'>
      {radio ? (
        // @ts-ignore
        <AtRadio options={options} value={selected} onClick={handleClick} />
      ) : (
        // @ts-ignore
        <AtCheckbox options={options} selectedList={selected} onChange={handleClick} />
      )}
    </View>
  );
}

EleCheckbox.defaultProps = {
  candidateValues: [],
  onChange: noop,
  radio: false,
};

export default EleCheckbox;
