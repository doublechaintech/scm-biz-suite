import { View } from '@tarojs/components';
import PropTypes from 'prop-types';
import './base-page.scss';

function BasePage(props) {
  return <View className='base-page'>{props.children}</View>;
}

BasePage.propTypes = {
  children: PropTypes.object,
  shareAction: PropTypes.object,
};

BasePage.defaultProps = {
  checkPhone: false,
  shareAction: {},
};

export default BasePage;
