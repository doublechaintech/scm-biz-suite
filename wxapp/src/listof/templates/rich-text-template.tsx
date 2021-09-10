import { View } from '@tarojs/components';
import EleRichText, { EleRichTextProps } from '@/components/elements/ele-rich-text';
import './flex-line-item.scss';

export default function RichTextTemplate({ content }: EleRichTextProps) {
  return (
    <View className='rich-text'>
      <EleRichText content={content} />
    </View>
  );
}
