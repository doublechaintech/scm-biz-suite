import React from 'react';
import { getExtMode, isNotEmpty } from '@/nice-router/nice-router-util';
import { useVisible } from '@/service/use-service';
import _ from 'lodash';
import { Text, View } from '@tarojs/components';
import { AtActionSheet } from 'taro-ui';
import './form-item-label.scss';

type FormItemLabelTips = {
  title?: string;
  brief: string;
};

type FormItemLabelProps = {
  required?: boolean;
  tips?: string | FormItemLabelTips;
  layout?: 'vertical' | 'horizontal';
  tail?: React.ReactNode;
  children?: React.ReactNode;
};

function FormItemLabel(props: FormItemLabelProps) {
  const { visible, show, close } = useVisible(false);
  const { required = true, tips, layout = 'horizontal', tail } = props;

  const hasTips = isNotEmpty(tips);

  const rootClass = getExtMode({ [layout]: true }).classNames('form-item-label', {
    clickable: hasTips,
  });

  const handleShowTips = () => {
    if (hasTips) {
      show();
    }
  };

  return (
    <View className={rootClass} onClick={handleShowTips}>
      <Text className='form-item-label-title'>
        {required && <Text className='form-item-label-required'>*</Text>}
        {props.children}
      </Text>
      {isNotEmpty(tips) && <Text className='iconfont iconfont-question-circle' />}
      {tail}
      <AtActionSheet onClose={close} isOpened={visible}>
        <View className='form-item-label-tips'>
          <View className='form-item-label-tips-title'>{_.get(tips, 'title', '')}</View>
          <View className='form-item-label-tips-brief'>{_.get(tips, 'brief', tips)}</View>
        </View>
      </AtActionSheet>
    </View>
  );
}

export default FormItemLabel;
