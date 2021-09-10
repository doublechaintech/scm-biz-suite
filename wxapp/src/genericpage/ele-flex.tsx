import React from 'react';
import EleButton from '@/components/elements/ele-button';
import EleCard from '@/components/elements/ele-card/ele-card';
import EleCarousel from '@/components/elements/ele-carousel';
import EleQrcode from '@/components/elements/ele-qrcode';
import EleRichText from '@/components/elements/ele-rich-text';
//从主要包中引入
import EleForm from '@/components/form/ele-form';
import { isH5 } from '@/utils/index';
import { View } from '@tarojs/components';
import classNames from 'classnames';
import Listof from '@/listof/listof';

import ElePopup from './ele-popup';
import EleBreakLine from './elements/ele-break-line';
import EleFab from '../components/elements/ele-fab/ele-fab';
import EleFooterTabs from './elements/ele-footer-tabs';
import EleImage from './elements/ele-image';
//generic-page 专用，不分享给其他包的
import EleMoreActions from './elements/ele-more-actions';
import EleNavigationBox from './elements/ele-navigation-box';
import EleNotice from './elements/ele-notice';
import EleStoreLocation from './elements/ele-store-location';
import EleText from './elements/ele-text';
import EleWhiteSpace from './elements/ele-white-space';

import './styles.scss';

type EleFlexItem = {
  id: string;
  type: string;
};

type EleFlexProps = {
  flex?: number;
  kids: EleFlexItem[];
  customStyle?: React.CSSProperties;
  className?: string;
};

/**
 * 其他组件模块用的ui组件，要扔到主App去share
 */
function EleFlex(props: EleFlexProps) {
  const { flex, kids, customStyle = {}, className } = props;
  const rootClass = classNames(className, { 'flex-column': !className });
  return (
    <View className={rootClass} style={{ flex, ...customStyle }}>
      {kids.map((it: any, idx) => {
        const key = `ele-flex-item-${idx}-${it.id}`;
        if (it.type === 'text') return <EleText key={key} {...it} />;
        if (it.type === 'image') return <EleImage key={key} {...it} />;
        if (it.type === 'button') return <EleButton key={key} {...it} />;
        if (it.type === 'carousel') return <EleCarousel key={key} {...it} />;
        if (it.type === 'notice-bar') return <EleNotice key={key} {...it} />;
        if (it.type === 'break-line') return <EleBreakLine key={key} {...it} />;
        if (it.type === 'white-space') return <EleWhiteSpace key={key} {...it} />;
        if (it.type === 'box-bar') return <EleNavigationBox key={key} {...it} />;
        if (it.type === 'fab') return <EleFab key={key} {...it} />;
        if (it.type === 'store-location') return <EleStoreLocation key={key} {...it} />;
        if (it.type === 'popup') return <ElePopup key={key} {...it} />;
        if (it.type === 'footer-tabs') return <EleFooterTabs key={key} {...it} />;
        if (it.type === 'qrcode') return <EleQrcode key={key} {...it} />;
        if (it.type === 'more-actions') return <EleMoreActions key={key} {...it} />;
        if (it.type === 'listof') return <Listof key={key} {...it} />;
        if (it.type === 'rich-text') return <EleRichText key={key} {...it} />;
        if (it.type === 'ele-card') return <EleCard key={key} {...it} />;

        if (it.type === 'form') return <EleForm key={key} {...it} fields={it.kids} />;

        if (it.type === 'flex') {
          return (
            // Taro && wechat-mini-program could not support self reference, using it as mini-program component
            <View key={key} className='flex-row' style={{ flex: it.flex || 1 }}>
              <View style={{ width: '100%', height: '100%' }}>
                {/* eslint-disable-next-line react/jsx-no-undef */ // @ts-ignore
                isH5() ? <EleFlex {...it} /> : <EleFlexBox {...it} />}
              </View>
            </View>
          );
        }
      })}
    </View>
  );
}

EleFlex.options = {
  multipleSlots: true,
};

EleFlex.defaultProps = {
  flex: 1,
  kids: [], //children的同义词，不用children，微信有问题
  customStyle: {},
};

EleFlex.config = {
  component: true,
  usingComponents: {
    'ele-flex-box': './ele-flex',
  },
};
export default EleFlex;
