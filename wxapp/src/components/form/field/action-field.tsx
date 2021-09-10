import React from 'react';
import { getExtMode, isEmpty, noop } from '@/nice-router/nice-router-util';
import { View } from '@tarojs/components';
import _ from 'lodash';
import classNames from 'classnames';
import './action-field.scss';

type ActionFieldProps = {
  value: string | { title: string };
  placeholder?: string;
  disabled?: boolean;
  onClick?: Function;
  className?: string;
  toggleStatus?: boolean;
  children?: React.ReactNode;
};

function ActionField(props: ActionFieldProps) {
  const { value, placeholder, disabled, onClick = noop, className, toggleStatus } = props;

  const handleClick = () => {
    if (!disabled) {
      onClick();
    }
  };

  const theValue = _.isObject(value) ? value?.title : value;

  const contentClass = getExtMode({
    placeholder: isEmpty(theValue),
    disabled,
  }).classNames('action-field-content');

  const rootClass = classNames('action-field', className);
  return (
    <View className={rootClass}>
      <View className={contentClass} onClick={handleClick}>
        {theValue || placeholder}
      </View>

      {!_.isNil(toggleStatus) && (
        <View
          className={`iconfont iconfont-${toggleStatus ? 'down' : 'right'} action-field-picker-icon`}
          onClick={handleClick}
        />
      )}

      {!disabled && props.children}
    </View>
  );
}

ActionField.defaultProps = {
  disabled: false,
  onClick: noop,
};
export default ActionField;
