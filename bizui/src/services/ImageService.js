
import { postForm } from './http'
import {getURLPrefix} from '../axios/tools'

const PREFIX = getURLPrefix()
const uploadOneImage = (parameters) => {
  const url = `${PREFIX}changeRequestService/uploadOneImage/name/mimeType/encodeContent/`
  const requestParameters = {...parameters}
  return postForm({url,requestParameters})
}


export default {uploadOneImage}


