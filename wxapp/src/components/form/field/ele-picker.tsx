// @ts-nocheck
import { useEffect, useState } from 'react';
import _ from 'lodash';
import { Picker, View } from '@tarojs/components';
import { isEmpty, isNotEmpty } from '@/nice-router/nice-router-util';
import { useVisible } from '@/service/use-service';
import classNames from 'classnames';

import { CandidateValue } from '@/nice-router/nice-router-types';
import './styles.scss';

export type ElePickerProps = {
  value?: string | CandidateValue | CandidateValue[];
  onChange?: (values: CandidateValue[]) => void;
  placeholder?: string;
  candidateValues: CandidateValue[];
  numberOfColumn?: number;
  disabled?: boolean;
  mode?: 'multiSelector' | 'selector';
};

const getOptions = (v) => _.get(v, 'candidateValues', []);
const getValue = (list, idx = 0) => _.get(list, idx, {});
const getTips = (value, placeholder) => {
  if (Array.isArray(value) && isNotEmpty(value)) {
    return _.trim(value.map((it) => it.title || it).join('-'), '-');
  }
  if (isNotEmpty(value)) {
    return value.title || value;
  }
  return placeholder;
};

function ElePicker(props: ElePickerProps) {
  const [tips, setTips] = useState();
  const { visible, show, close } = useVisible(false);
  const [range, setRange] = useState([]);
  const {
    value,
    onChange,
    placeholder,
    candidateValues: source,
    numberOfColumn = 3,
    disabled,
    mode = 'multiSelector',
  } = props;

  useEffect(() => {
    if (isNotEmpty(source)) {
      const newTips = getTips(value, placeholder);
      setTips(newTips);
      reBuildRangeList(0);
    }
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [value, source, placeholder]);

  const reBuildRangeList = (col, idx = 0) => {
    setRange((pre: any) => {
      const tempRange = col === 0 ? [source] : _.clone(pre);
      for (let i = col; i < numberOfColumn; i++) {
        const v = getValue(tempRange[i], i === col ? idx : 0);
        const list = getOptions(v);
        if (isEmpty(list)) {
          break;
        }
        tempRange[i + 1] = list;
      }
      return tempRange;
    });
  };

  const handleCommit = (e) => {
    const targetValue = e.detail.value;

    let selected = targetValue;

    if (_.isArray(selected)) {
      selected = selected.map((it, idx) => range[idx][it] || '');
      const newTips = getTips(selected, placeholder);
      setTips(newTips);
    } else if (source) {
      selected = source[targetValue];
      setTips(selected ? selected.title : '');
      // selectedValue = selected ? selected.id : ''
    }

    if (onChange) {
      const result = selected.map((it) => ({ id: it.id, title: it.title }));
      onChange(result);
    }
    // setInnerDisplayValue(innerDisplayValue)
    close();
  };

  const handleColumnChange = (e) => {
    const { column, value: selectedValueIdx } = e.detail;
    console.log('column...', column);
    reBuildRangeList(column, selectedValueIdx);
  };

  const tipsClass = classNames('tips', {
    placeholder: tips === placeholder,
  });

  return (
    <View className='ele-picker'>
      <Picker
        disabled={disabled}
        mode={mode}
        onChange={handleCommit}
        range={range}
        rangeKey='title'
        onColumnChange={handleColumnChange}
        onCancel={close}
        onClick={show}
      >
        <View className='ele-picker-body'>
          <View className={tipsClass}>{tips}</View>
          {visible ? <View className='iconfont iconfont-down' /> : <View className='iconfont iconfont-right' />}
        </View>
      </Picker>
    </View>
  );
}

ElePicker.defaultProps = {
  mode: 'multiSelector',
  displayMode: 'right-brief',
  customStyle: {},
  name: '',
  displayValue: '',
  candidateValues: [],
  placeholder: '请选择',
};

export default ElePicker;
