import { toRpx } from '@/utils/index';
import { View } from '@tarojs/components';

type EleWhiteSpaceProps = {
  height: number;
  color: string;
};

function EleWhiteSpace({ height, color }: EleWhiteSpaceProps) {
  return <View style={{ height: toRpx(height), backgroundColor: color }} />;
}

EleWhiteSpace.defaultProps = {
  height: 30,
  color: '#fff',
};
export default EleWhiteSpace;
