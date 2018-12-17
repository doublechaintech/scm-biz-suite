import { get, post,PREFIX,joinParameters,joinPostParameters } from '../axios/tools'
import GlobalComponents from '../custcomponents';

const execute = (url) => {
  return get({
    url: `${PREFIX}${url}`,
  })
}


const ActionCenterService = { execute }
export default ActionCenterService


