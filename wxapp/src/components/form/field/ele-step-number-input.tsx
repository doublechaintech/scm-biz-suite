import { AtInputNumber } from 'taro-ui';
import { AtInputNumberProps } from 'taro-ui/types/input-number';

// max,min, step
const EleStepNumberInput = (props: AtInputNumberProps) => {
  return <AtInputNumber {...props} />;
};

export default EleStepNumberInput;
