import { forwardRef, useEffect, useImperativeHandle, useMemo, useState } from 'react';
import { isNotEmpty, noop, parseJSON } from '@/nice-router/nice-router-util';
import { View } from '@tarojs/components';
import _ from 'lodash';
import EleFlex from '@/genericpage/ele-flex';
import EleActionList from '@/components/elements/action-list/ele-action-list';
import SectionBar from '../section-bar/section-bar';
import FormItem from './form-item';
import FormUtil from './form-util';
import './ele-form.scss';
import validator from './validator';

// 参考 https://github.com/react-component/form

type EleFormProps = {
  // TODO 需要测试，优化
  formKey?: string;
  defaultValues?: object;
  onFieldChange?: Function;
  fieldList?: any[];
  groupList?: any[];
  showRequired?: boolean;
  bordered?: boolean;
  handleActionClick?: any;
};

const getFields = (groupList, fieldList) => {
  if (isNotEmpty(groupList)) {
    let result = [];
    groupList.map((it) => {
      if (it.fieldList) {
        result = result.concat(it.fieldList);
      }
    });
    return result;
  }
  return fieldList;
};

const getGroups = (groupList, fieldList) => {
  const groups = isNotEmpty(groupList) ? groupList : [{ id: 'base-group', fieldList }];
  return groups
    .filter((it) => !it.hidden)
    .map((group) => {
      const { fieldList: groupFields = [] } = group;
      const fields = groupFields.filter((field) => !field.hidden);
      return {
        ...group,
        fieldList: fields,
      };
    });
};

function EleForm(props: EleFormProps, ref) {
  const {
    defaultValues = {},
    onFieldChange,
    fieldList = [],
    groupList = [],
    showRequired = true,
    bordered = true,
  } = props;
  // console.log('generic-form initial defaultValues,eeeeee', defaultValues)
  //以name为key
  const [fieldValues, setFieldValues] = useState(defaultValues);
  const [fieldErrors, setFieldErrors] = useState({});

  useEffect(() => setFieldValues(defaultValues), [defaultValues]);

  const groups = useMemo(() => getGroups(groupList, fieldList), [groupList, fieldList]);

  const handleFieldChange = async (name, value) => {
    // 记录处理错误信息
    const errors = await _validateField(name, value);
    console.log('xxxxxxx', name, errors, value);
    if (isNotEmpty(errors)) {
      setFieldErrors((preState) => ({
        ...preState,
        [name]: errors,
      }));
    } else {
      setFieldErrors((preState) => {
        const result = _.clone(preState);
        _.omit(result, name);
        return result;
      });
    }
    // 记录值
    setFieldValues((preState) => ({
      ...preState,
      [name]: value,
    }));

    if (_.isFunction(onFieldChange)) {
      onFieldChange(name, fieldValues);
    }
  };

  const resetFields = () => {
    setFieldValues(defaultValues);
    setFieldErrors({});
  };

  const validateFields = async () => {
    const fields = getFields(groupList, fieldList);
    const errors = {};
    for (const field of fields) {
      const { name } = field;
      const value = fieldValues[name];
      const e = await _validateField(name, value);
      if (isNotEmpty(e)) {
        console.log('set errors', e);
        errors[name] = e;
      }
    }
    setFieldErrors(errors);
    return {
      errors: fieldErrors,
      values: fieldValues,
    };
  };

  useImperativeHandle(ref, () => ({
    validateFields,
    resetFields,
  }));

  // 导出，外用
  // this.validateFields = validateFields
  // this.resetFields = resetFields

  const _validateField = (name, value) => {
    const fields = getFields(groupList, fieldList);
    const field = fields.find((it) => it.name === name);
    if (!field || field.type === 'display-field') {
      return Promise.resolve();
    }
    // @ts-ignore
    return validator(field, value).then((errors) => {
      return errors;
    });
  };

  const { handleActionClick = noop } = props;

  return (
    <View className='ele-form'>
      {groups.map((groupItem) => {
        const { name: groupId, title, brief, fieldList: fields = [], actionList: groupActionList = [] } = groupItem;

        const actionList = groupActionList.map((it) => ({
          ...it,
          onClick: () => handleActionClick(it),
        }));

        return (
          <View key={groupId}>
            {isNotEmpty(title) && <SectionBar title={title} brief={brief} />}

            <View className='ele-form-fields'>
              {fields.map((it) => {
                const field = FormUtil.mergeConfig(it);
                const { name, type } = field;
                const value = fieldValues[name];
                const key = name + '_'; // key重做，因为有taro bug

                if (type === 'display-field' && isNotEmpty(field.value)) {
                  const ele = _.isString(field.value) ? parseJSON(field.value) : field.value;
                  return <EleFlex key={key} {...ele} />;
                }
                const errors = fieldErrors[name];

                return (
                  <FormItem
                    key={key}
                    bordered={bordered}
                    {...field}
                    showRequired={showRequired}
                    value={value}
                    errors={errors}
                    onChange={handleFieldChange}
                  />
                );
              })}
            </View>

            {isNotEmpty(groupActionList) && (
              <View className='ele-form-group-actions'>
                <EleActionList mode={['small', 'right']} items={actionList} />
              </View>
            )}
          </View>
        );
      })}
    </View>
  );
}

export default forwardRef(EleForm);
