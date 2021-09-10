import { useSelector } from 'react-redux';
import GenericPageBase from './generic-page-base';

export default () => {
  const root = useSelector((state) => state.genericpage);
  return <GenericPageBase {...root} />;
};
