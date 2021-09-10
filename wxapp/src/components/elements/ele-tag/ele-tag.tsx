import React from 'react';
import { getExtMode, noop } from '@/nice-router/nice-router-util';
import { Text } from '@tarojs/components';
import _ from 'lodash';
import { CandidateValue } from '@/nice-router/nice-router-types';
import './ele-tag.scss';

export type EleTagProps = {
  hidden?: boolean;
  disabled?: boolean;
  selected?: boolean;
  size?: 'small' | 'normal';
  children?: React.ReactNode;
  mode?: 'red' | 'primary' | string[];
  className?: string;
  onClick?: Function;
} & Partial<CandidateValue>;

export default function EleTag(props: EleTagProps) {
  const { hidden, disabled, selected, mode, className, title, onClick = noop, size = 'normal' } = props;
  const clickable = !disabled && _.isFunction(onClick);
  const rootClass = getExtMode({ disabled, selected, [size]: true }, mode).classNames('ele-tag', className, {
    hidden,
    clickable,
  });
  const handleClick = () => {
    if (clickable) {
      onClick(props);
    }
  };

  return (
    <Text className={rootClass} onClick={handleClick}>
      {props.children || title}
    </Text>
  );
}
