import Taro from '@tarojs/taro';

export default class OverlayLoading {
  static async showLoadingModal(text: string = '正在处理中') {
    await Taro.showLoading({ title: text, mask: true });
  }

  static hideLoadingModal() {
    Taro.hideLoading();
  }
}
