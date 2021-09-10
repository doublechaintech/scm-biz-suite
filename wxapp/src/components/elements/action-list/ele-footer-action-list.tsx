import _ from 'lodash';
import EleActionList, { EleActionListProps } from './ele-action-list';
import './styles.scss';

function EleFooterActionList(props: EleActionListProps) {
  const { mode = ['full'] } = props;
  const theMode = _.concat(['footer'], mode);
  return <EleActionList {...props} mode={theMode} />;
}

EleFooterActionList.defaultProps = {
  list: [],
};

export default EleFooterActionList;
