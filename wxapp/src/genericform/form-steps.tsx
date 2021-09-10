import NavigationService from '@/nice-router/navigation-service';
import { View } from '@tarojs/components';
import { AtSteps } from 'taro-ui';

import { CandidateValue } from '@/nice-router/nice-router-types';
import './styles.scss';

type FormStepsProps = {
  steps: CandidateValue[];
};

function FormSteps({ steps }: FormStepsProps) {
  const handleChange = (current) => {
    NavigationService.view(
      steps[current],
      {},
      {
        navigationMethod: 'replace',
      }
    );
  };

  const stepList = steps.map((it) => ({ ...it, desc: it.brief || '' }));
  let selectedIdx = steps.findIndex((it) => it.selected);
  return (
    <View className='form-steps'>
      <AtSteps items={stepList} current={selectedIdx} onChange={handleChange} />
    </View>
  );
}

FormSteps.defaultProps = {
  steps: [],
};
export default FormSteps;
