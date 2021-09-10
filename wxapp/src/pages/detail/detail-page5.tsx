import { useSelector } from 'react-redux';
import DetailPageBase from './detail-page-base';
import './styles.scss';

export default () => {
  const root = useSelector((state) => state.detail5);
  return <DetailPageBase {...root} />;
};
