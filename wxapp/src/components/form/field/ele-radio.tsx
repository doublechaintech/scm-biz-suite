import { useEffect, useState } from 'react';
import _ from 'lodash';
import { getExtMode, isNotEmpty, noop } from '@/nice-router/nice-router-util';
import { Label, Radio, RadioGroup, View } from '@tarojs/components';
import { CandidateValue } from '@/nice-router/nice-router-types';
import './styles.scss';

type EleRadioProps = {
  value: any;
  candidateValues: CandidateValue[];
  onChange?: Function;
  mode?: 'vertical' | 'horizontal';
};

function EleRadio(props: EleRadioProps) {
  const [selected, setSelected] = useState<CandidateValue>();

  const { candidateValues = [], onChange = noop, value, mode = [] } = props;

  useEffect(() => {
    let theSelected = isNotEmpty(value) ? value : _.find(candidateValues, { selected: true });
    setSelected(theSelected || {});
  }, [value, candidateValues]);

  const handleChange = (e) => {
    const item = _.find(candidateValues, { id: e.detail.value });
    setSelected(item);
    onChange(item);
  };
  const rootClass = getExtMode(mode).classNames('ele-radio');

  return (
    <View className={rootClass}>
      <RadioGroup onChange={handleChange}>
        <View className='ele-radio-body'>
          {candidateValues.map((item, idx) => {
            const checked = isNotEmpty(selected) ? selected?.id === item.id : false;
            const key = `radio-${idx}`;
            return (
              <Label className='radio-list__label' for={key} key={key}>
                <Radio className='radio-list__radio' value={item.id} checked={checked}>
                  {item.title}
                </Radio>
              </Label>
            );
          })}
        </View>
      </RadioGroup>
    </View>
  );
}

EleRadio.defaultProps = {
  candidateValues: [],
  onChange: noop,
};

export default EleRadio;
