import { View } from '@tarojs/components';
import { ITouchEvent } from '@tarojs/components/types/common';
import './form-item-tail.scss';

type FormItemTailProps = {
  showClear?: boolean;
  hasError?: boolean;
  onClear: (e: ITouchEvent) => void;
  onShowError: (e: ITouchEvent) => void;
};

export default function FormItemTail(props: FormItemTailProps) {
  const { showClear, hasError, onClear, onShowError } = props;

  return (
    <View className='form-item-tail'>
      {showClear && <View className='iconfont iconfont-close-circle' onClick={onClear} />}
      {hasError && <View className='iconfont iconfont-warning-circle' onClick={onShowError} />}
    </View>
  );
}
