import React from 'react';
import { toRpx } from '@/utils/index';
import { Canvas } from '@tarojs/components';
import Taro from '@tarojs/taro';
import _ from 'lodash';
import ErrorCorrectLevel from 'qr.js/lib/ErrorCorrectLevel';
import QRCodeImpl from 'qr.js/lib/QRCode';

// 修改自 https://github.com/xueyida/QRcode.taro/blob/master/QRCodeCanvas.js
const defaultCanvasId = 'qrcode-canvase';

type EleQrcodeProps = {
  size: number;
  level?: string;
  bgColor: string;
  fgColor: string;
  logoSize?: number;
  logo?: number;
  text: 'string';
  customStyle?: React.CSSProperties;
};

export default class EleQrcode extends React.PureComponent<EleQrcodeProps> {
  static defaultProps = {
    size: 200,
    level: 'L',
    bgColor: '#fff',
    fgColor: '#000000',
    logoSize: 100,
    logo: null,
    text: 'https://www.github.com/kala888',
  };

  componentDidMount() {
    this.update();
  }

  componentDidUpdate() {
    this.update();
  }

  convertStr(str) {
    let out = '';
    for (let i = 0; i < str.length; i++) {
      let charcode = str.charCodeAt(i);
      if (charcode < 0x0080) {
        out += String.fromCharCode(charcode);
      } else if (charcode < 0x0800) {
        out += String.fromCharCode(0xc0 | (charcode >> 6));
        out += String.fromCharCode(0x80 | (charcode & 0x3f));
      } else if (charcode < 0xd800 || charcode >= 0xe000) {
        out += String.fromCharCode(0xe0 | (charcode >> 12));
        out += String.fromCharCode(0x80 | ((charcode >> 6) & 0x3f));
        out += String.fromCharCode(0x80 | (charcode & 0x3f));
      } else {
        // This is a surrogate pair, so we'll reconsitute the pieces and work
        // from that
        i++;
        charcode = 0x10000 + (((charcode & 0x3ff) << 10) | (str.charCodeAt(i) & 0x3ff));
        out += String.fromCharCode(0xf0 | (charcode >> 18));
        out += String.fromCharCode(0x80 | ((charcode >> 12) & 0x3f));
        out += String.fromCharCode(0x80 | ((charcode >> 6) & 0x3f));
        out += String.fromCharCode(0x80 | (charcode & 0x3f));
      }
    }
    return out;
  }

  update() {
    const { text, size, level, bgColor, fgColor, logoSize = '100', logo = '' } = this.props;
    const qrcode = new QRCodeImpl(-1, ErrorCorrectLevel[level]);
    qrcode.addData(this.convertStr(text));
    qrcode.make();
    // @ts-ignore
    const canvas = Taro.createCanvasContext(defaultCanvasId, this.$scope);
    if (!canvas) {
      return;
    }

    const cells = qrcode.modules;
    if (cells === null) {
      return;
    }
    const tileW = size / cells.length;
    const tileH = size / cells.length;
    // const scale = window.devicePixelRatio || 1
    // ctx.scale(scale, scale)

    cells.forEach(function(row, rdx) {
      row.forEach(function(cell, cdx) {
        if (canvas) {
          canvas.fillStyle = cell ? fgColor : bgColor;
        }
        const w = Math.ceil((cdx + 1) * tileW) - Math.floor(cdx * tileW);
        const h = Math.ceil((rdx + 1) * tileH) - Math.floor(rdx * tileH);
        canvas && canvas.fillRect(Math.round(cdx * tileW), Math.round(rdx * tileH), w, h);
      });
    });
    canvas.save();
    if (!_.isNil(logo)) {
      // @ts-ignore
      canvas.drawImage(logo, (size - logoSize) / 2, (size - logoSize) / 2, logoSize, logoSize);
    }
    canvas.draw();
  }

  render() {
    // style:{marginTop: '400px'}
    const { size, customStyle = {} } = this.props;
    const itemWith = toRpx(size);
    const canvasStyle = { height: itemWith, width: itemWith, ...customStyle };
    return <Canvas canvasId={defaultCanvasId} style={canvasStyle} />;
  }
}
