import React from 'react';
import { toRpx } from '@/utils/index';
import { View } from '@tarojs/components';
import classNames from 'classnames';
import { AtDivider } from 'taro-ui';
import { isNotEmpty } from '@/nice-router/nice-router-util';

type EleBreakLineProps = {
  color?: string;
  height?: number;
  title?: string;
  fontColor?: string;
  customStyle?: React.CSSProperties;
  className?: string;
};

function EleBreakLine(props: EleBreakLineProps) {
  const { color, height, title, fontColor, customStyle, className } = props;
  const fixedHeight = toRpx(height);

  const style = isNotEmpty(title)
    ? customStyle
    : {
        height: fixedHeight,
        backgroundColor: color,
        margin: '10rpx 0',
        ...customStyle,
      };

  const rootClass = classNames('ele-break-line', className);
  return (
    <View className={rootClass} style={style}>
      {isNotEmpty(title) && <AtDivider height={fixedHeight} content={title} fontColor={fontColor} lineColor={color} />}
    </View>
  );
}

EleBreakLine.defaultProps = {
  color: '#ddd',
  height: 1,
  text: '',
  fontColor: '#ddd',
  customStyle: {},
};
export default EleBreakLine;
