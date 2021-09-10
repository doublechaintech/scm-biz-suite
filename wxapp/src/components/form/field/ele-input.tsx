import { View } from '@tarojs/components';
import { AtInput } from 'taro-ui';
import { AtInputProps } from 'taro-ui/types/input';

// type: text, password, number, idcard, digit, phone
// type: money
// className: "", noLabel, noBorder, underLine

export default function EleInput(props: AtInputProps) {
  return (
    <View>
      <AtInput border={false} {...props} />
    </View>
  );
}
