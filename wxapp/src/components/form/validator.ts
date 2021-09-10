import { isEmpty } from '@/nice-router/nice-router-util';
import Schema from 'async-validator';
import _ from 'lodash';

//valid OOTB type:
// const VALIDATOR_OOTB_TYP = [
//   'string',
//   'number',
//   'boolean',
//   'method',
//   'regexp',
//   'integer',
//   'float',
//   'array',
//   'object',
//   'enum',
//   'date',
//   'url',
//   'hex',
//   'email',
//   'any',
// ]

// const TYPE_MAPPING = {
//   text: 'string',
//   'long-text': 'string',
//   textarea: 'string',
//   phone: 'string',
//   money: 'integer',
//   double: 'number',
//   decimal: 'number',
//   switch: 'boolean',
// }

const numberLikeType = ['integer', 'number', 'float', 'decimal', 'double', 'money'];

function transformValue(type, value) {
  if (isEmpty(value)) {
    return value;
  }
  const isNumberLike = numberLikeType.includes(type);
  return isNumberLike ? _.toNumber(value) : value;
}

// function getSpecialValidator(rule, type) {
//   console.log('for field type', type, ':', rule, 'with special validator? no...')
//   return null
// }

function handleErrors(errors = [], fields) {
  console.log('fields', fields);
  // @ts-ignore
  return errors.map((err) => err?.message);
}

const validator = (
  field: {
    name: string;
    rules: object[];
    type: string;
  },
  value
) => {
  const { name, rules = [], type } = field || {};
  if (isEmpty(name) || isEmpty(rules)) {
    return Promise.resolve();
  }

  // const ruleList = rules.map((it) => {
  //   const rule = { ...it }
  //   // // 强制把type塞回去
  //   // if (
  //   //   (isNotEmpty(it.max) || isNotEmpty(it.min) || isNotEmpty(it.type) || isNotEmpty(it.required)) &&
  //   //   VALIDATOR_OOTB_TYP.includes(validatorType)
  //   // ) {
  //   //   rule.type = validatorType
  //   // }
  //
  //   // const specialValidator = getSpecialValidator(it, type)
  //   // if (isFunction(specialValidator)) {
  //   //   rule.validator = specialValidator
  //   // }
  //   return rule
  // })

  // processedRules.push({
  //   type: validatorType, // 通过增加rule方式做类型检测
  // })
  const schema = new Schema({ [name]: rules });
  const fieldValue = transformValue(type, value);
  const source = { [name]: fieldValue };
  // console.log('validate field:', name, 'type:', type, 'value:', value, '->', fieldValue, 'rules:', rules)
  return schema
    .validate(source)
    .then((res) => {
      console.log('validate result', res);
      return [];
    })
    .catch(({ errors, fields }) => {
      return handleErrors(errors, fields);
    });
};

export default validator;
