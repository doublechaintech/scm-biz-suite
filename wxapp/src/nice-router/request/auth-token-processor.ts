import _ from 'lodash';
import AuthTools from '../auth-tools';
import { isNotEmpty, log } from '../nice-router-util';

const AuthTokenProcessor = async (chain) => {
  const token = await AuthTools.getTokenAsync();
  const { requestParams } = chain;
  const { headers = {} } = requestParams;

  log('set Authorization token to Request Header:', token);
  const theParam: any = {
    ...requestParams,
    headers: {
      ...headers,
      Authorization: token,
    },
  };
  return chain.proceed(theParam).then(async (theData) => {
    const authorization = _.get(theData, 'headers.authorization', '');
    console.log('aaaaaaa', authorization, theData);
    if (isNotEmpty(authorization)) {
      await AuthTools.saveTokenAsync(authorization);
    }
    return theData;
  });
};

export default AuthTokenProcessor;
