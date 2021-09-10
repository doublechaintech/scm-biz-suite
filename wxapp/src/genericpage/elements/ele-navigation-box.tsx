/*
 * Copyright(c) 2020 nice-router
 *    Date: 2020/4/26 下午12:05
 *    Author: Kala
 */
import NavigationBox from '@/components/navigation/navigation-box';
import classNames from 'classnames';
import './styles.scss';

function EleNavigationBox(props) {
  const { kids, className } = props;

  const rootClass = classNames('ele-navigation-box', className);

  return <NavigationBox items={kids} className={rootClass} />;
}

EleNavigationBox.defaultProps = {
  kids: [],
};

export default EleNavigationBox;
