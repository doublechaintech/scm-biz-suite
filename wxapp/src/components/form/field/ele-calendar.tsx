import { useState } from 'react';
import { isEmpty, noop } from '@/nice-router/nice-router-util';
import { useVisible } from '@/service/use-service';
import { formatTime, transToDate } from '@/utils/index';
import { Picker } from '@tarojs/components';
import { AtActionSheet, AtCalendar } from 'taro-ui';
import { ModeClass } from '@/nice-router/nice-router-types';

import ActionField from './action-field';
import './ele-calendar.scss';

type EleCalendarProps = {
  onChange?: Function;
  placeholder?: string;
  label?: string;
  value?: string;
  disabled?: boolean;
} & ModeClass;

/**
 * 有时候弹不出来，记得在外层包一个View
 *
 * @param props
 * @returns {JSX.Element}
 * @constructor
 */
function EleCalendar(props: EleCalendarProps) {
  const [date, setDate] = useState('');
  const [showCalendar, setShowCalendar] = useState(true);
  const { visible, show: showPopup, close: closePopup } = useVisible(false);
  const { mode, onChange = noop, placeholder, label, value, disabled } = props;

  const show = () => {
    showPopup();
    setShowCalendar(true);
  };
  const close = () => {
    closePopup();
    setShowCalendar(false);
  };

  const handleDateSelected = (e) => {
    const { start: startDate } = e.value;
    close();
    if (mode === 'date') {
      onChange(startDate);
      return;
    }
    setDate(startDate);
  };

  const handleTimeChange = (e) => {
    const {
      detail: { value: time },
    } = e;
    onChange(`${date} ${time}`);
  };

  const getDateTime = () => {
    console.log('getDate-time', value);
    const dateValue = transToDate(value);

    if (dateValue) {
      const fmt = mode === 'datetime' ? 'yyyy-MM-dd HH:mm' : 'yyyy-MM-dd';
      const displayValue = formatTime(dateValue, fmt);
      let [displayDate, displayTime] = displayValue.split(' ');
      return {
        displayValue,
        displayDate,
        displayTime,
      };
    }

    if (mode === 'datetime' && isEmpty(dateValue)) {
      return {
        displayTime: formatTime(Date.now(), 'HH:mm'),
      };
    }

    return {};
  };

  const { displayValue, displayDate, displayTime } = getDateTime();

  // action-sheet 里面的那个view不要干掉，不然日历有问题????? TODO
  return (
    <ActionField
      onClick={show}
      disabled={disabled}
      value={displayValue}
      placeholder={placeholder}
      className='ele-calendar'
    >
      <AtActionSheet title={label} onClose={close} isOpened={visible} cancelText='取消'>
        {mode === 'date' && <AtCalendar isVertical currentDate={displayDate} onSelectDate={handleDateSelected} />}
        {mode === 'datetime' && (
          <Picker mode='time' value={displayTime} onChange={handleTimeChange} onCancel={close}>
            {showCalendar && <AtCalendar isVertical currentDate={date} onSelectDate={handleDateSelected} />}
          </Picker>
        )}
      </AtActionSheet>
    </ActionField>
  );
}

EleCalendar.defaultProps = {
  placeholder: '请选择',
  onChange: noop,
  mode: 'date',
  // mode: 'datetime',
  value: '',
  disabled: false,
};

export default EleCalendar;
