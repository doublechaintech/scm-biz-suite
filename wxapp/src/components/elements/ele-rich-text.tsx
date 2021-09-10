import '@tarojs/taro/html.css';
import { RichText } from '@tarojs/components';

export type EleRichTextProps = {
  content?: string;
};

function EleRichText({ content = '' }: EleRichTextProps) {
  return <RichText space='nbsp' nodes={content} />;
}

export default EleRichText;
