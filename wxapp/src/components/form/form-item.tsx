import React from 'react';
import { getExtMode, isNotEmpty, noop } from '@/nice-router/nice-router-util';
import { View } from '@tarojs/components';
import _ from 'lodash';
import GlobalToast from '@/nice-router/global-toast';

import FormItemTail from './form-item-tail';
import FormUtil from '../form/form-util';
import FlexField from './field/flex-field';
import FormItemLabel from './form-item-label';
import './form-item.scss';

type FormItemProps = {
  //TODO
  name: string;
  required?: boolean;
  rules: object[];
  showRequired?: boolean;
  clear?: boolean;
  value?: any;
  errors?: string[];
  bordered?: boolean;
  inline?: boolean;
  disabled?: boolean;
  label?: string;
  title?: string;
  tips?: string;
  onChange?: (name: string, value: any) => void;
  children?: React.ReactNode;
};

function FormItem(props: FormItemProps) {
  const {
    name,
    required,
    rules = [],
    showRequired,
    clear,
    value,
    errors = [],
    bordered,
    inline,
    disabled,
    label,
    title,
    tips,
    onChange = noop,
  } = props;

  const handleChange = (v, e) => {
    console.log('item event maybe you needed', e);
    let fieldValue = FormUtil.getValue(v);
    onChange(name, fieldValue);
  };

  const onClear = () => {
    onChange(name, null);
  };

  const showRequiredIcon = () => {
    if (showRequired) {
      // @ts-ignore
      return _.isNil(required) ? !!rules.find((rule) => rule.required) : required;
    }
    return false;
  };

  const hasError = isNotEmpty(errors);

  const handleShowError = () => GlobalToast.show({ text: errors[0] });

  const layout = inline ? 'horizontal' : 'vertical';

  const rootClass = getExtMode({
    error: hasError,
    [layout]: true,
    bordered,
  }).classNames('form-item');

  const isRequired = showRequiredIcon();

  // 没有disabled，没有错误，有值，显示清理btn，就展示
  const showClear = !disabled && !hasError && clear && isNotEmpty(value);

  const theTail = (
    <FormItemTail showClear={showClear} hasError={hasError} onClear={onClear} onShowError={handleShowError} />
  );

  return (
    <View className={rootClass}>
      <FormItemLabel tips={tips} layout={layout} required={isRequired} tail={layout === 'vertical' ? theTail : null}>
        {label || title}
      </FormItemLabel>

      <View className='form-item-field'>{props.children || <FlexField {...props} onChange={handleChange} />}</View>

      {layout === 'horizontal' && theTail}
    </View>
  );
}

FormItem.defaultProps = {
  name: '',
  clear: false,
  errors: [],
  onChange: noop,
  layout: 'horizontal', //'vertical','float'
  rules: [],
  showRequired: true,
  inline: true,
  bordered: true,
  disabled: false,
};

export default FormItem;
