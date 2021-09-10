import { noop } from '@/nice-router/nice-router-util';
import { AtInput } from 'taro-ui';
import { AtInputProps } from 'taro-ui/types/input';

//'text' | 'number' | 'password' | 'phone' | 'idcard' | 'digit'

type EleNumberInputProps = {
  formatter?: (v: any) => any;
  parser?: (v: any) => any;
} & AtInputProps;

const defaultFormatter = (v) => v;
const defaultParser = (v) => v;
const EleNumberInput = (props: EleNumberInputProps) => {
  const { name, value, onChange = noop, formatter = defaultFormatter, parser = defaultParser, ...others } = props;
  const formattedValue = formatter(value);
  return (
    <AtInput
      name={name}
      // border={false}
      type='number'
      {...others}
      value={formattedValue}
      border={false}
      onChange={(v) => onChange(parser(v))}
    />
  );
};

export default EleNumberInput;
