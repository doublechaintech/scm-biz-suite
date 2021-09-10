import { useRef } from 'react';
import EleRichText from '@/components/elements/ele-rich-text';

import EleForm from '@/components/form/ele-form';
import NavigationService from '@/nice-router/navigation-service';
import { isEmpty, isNotEmpty } from '@/nice-router/nice-router-util';
import { usePageTitle, usePullDown } from '@/service/use-service';
import { View } from '@tarojs/components';
import EleActionList from '@/components/elements/action-list/ele-action-list';
import { useSelector } from 'react-redux';
import _ from 'lodash';
import { ActionLike } from '@/nice-router/nice-router-types';
import ActionUtil from '@/nice-router/action-util';
import FormSteps from './form-steps';
import './styles.scss';

function GenericformPage() {
  const formRef = useRef(null);
  const root = useSelector((state) => state.genericform);
  const { id, groupList = [], fieldList = [], stepList = [], actionList = [], content } = root;
  usePageTitle(root);
  usePullDown(root);

  const handleActionClick = async (action: ActionLike = {}) => {
    const { code } = action;
    if (code === 'reset') {
      // @ts-ignore
      formRef.current.resetFields();
      return;
    }
    if (ActionUtil.isSubmitAction(code)) {
      await handleSubmit(action);
      return;
    }
    // 其他请求，就直接执行action，把defaultValues传回去
    await NavigationService.post(action, defaultValues);
  };

  const handleSubmit = async (action) => {
    console.log('11111', formRef);
    // @ts-ignore
    const result = await formRef.current.validateFields();
    const { errors, values } = result;
    if (isEmpty(errors)) {
      console.log('form-values', values);
      await NavigationService.post(action, values, {
        asForm: true,
        navigationMethod: 'replace',
      });
      return;
    }
    console.log('form-errors：', errors);
  };

  const getDefaultValues = () => {
    const defaultValues = {};
    for (const group of groupList) {
      const { fieldList: fields = [] } = group;
      for (const field of fields) {
        const { name, value } = field;
        if (!_.isNil(value)) {
          defaultValues[name] = value;
        }
      }
    }
    return defaultValues;
  };
  const footerActionList = actionList.map((it) => ({
    uiType: ActionUtil.isSubmitAction(it.code) ? 'primary' : 'secondary',
    ...it,
    onClick: handleActionClick.bind(this, it),
  }));
  const defaultValues = getDefaultValues();
  console.log('generic-form initial defaultValues', defaultValues);
  console.log('generic-form groupList', groupList);
  console.log('generic-form fieldList', fieldList);
  return (
    <View className='generic-form-page'>
      {isNotEmpty(content) && <EleRichText content={content} />}
      {stepList.length > 0 && <FormSteps steps={stepList} />}
      <EleForm
        formKey={id}
        ref={formRef}
        groupList={groupList}
        fieldList={fieldList}
        defaultValues={defaultValues}
        handleActionClick={handleActionClick}
      />
      <EleActionList mode='full' items={footerActionList} />
    </View>
  );
}

export default GenericformPage;
