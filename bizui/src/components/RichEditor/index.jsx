import React, { Component, Fragment } from 'react';
import { Editor } from '@tinymce/tinymce-react';
import { Progress, Modal } from 'antd';
import oss from 'ali-oss';
import moment from 'moment';
import { random, trim, curryRight } from 'lodash';

// TODO: 根据项目的具体实施情况，提供获取OSSToken 的接口

// const valid_elements = `
// a, abbr, address, article, aside, b, bdi, bdo[dir], big, blockquote, br, caption, center, cite, code,
// col[span|width], colgroup[span|width], dd, del, div, dl, em, fieldset, font, footer, h1, h2, h3, h4, h5, h6,
// header, hr, i, img[atl|src|height|width], ins, label, legend, li, mark, nav, ol[start|type], p, pre, q, rt,
// ruby, s, section, small, span, strong, sub, sup, table[width], tbody, tfoot, td[colspan|height|rowspan|width],
// th[colspan|height|rowspan|width], thead, tr[colspan|height|rowspan|width], tt, u, ul
// `

const client = token => {
  const {
    region = '',
    accessKeyId = '',
    accessKeySecret = '',
    bucket = '',
    SecurityToken = '',
    endpoint = '',
  } = token;
  return oss({
    region,
    accessKeyId,
    accessKeySecret,
    bucket,
    stsToken: SecurityToken,
    endpoint,
  });
};

const getUploadPath = (blobInfo, userHome) => {
  let fileName = blobInfo.filename();
  let dotIndex = fileName.lastIndexOf('.');
  const suffix = fileName.substring(dotIndex + 1, fileName.length);
  const name = fileName.substring(0, dotIndex);
  const randomPath = moment().format('YYYY/MMDD/hhmmss_') + random(1000000, 9999999);
  const remoteFilePath = `${userHome}/${randomPath}_${name}.${suffix}`;
  console.log('remoteFilePath', remoteFilePath);
  return remoteFilePath;
};

function loadServerImage(uri, style) {
  if (!uri) {
    console.warn('image uri could not be', uri);
    return uri;
  }
  let url = uri || '';
  if (
    !/^(http|https):/.test(url) || // 不是http（本地文件）
    url.indexOf('x-oss-process') > -1 || // 或者已经包含style
    (url.indexOf('?') > -1 && url.indexOf('=') > -1)
  ) {
    // 如果已经添加了参数
    return url;
  }
  return url + style;
}

const curriedLoadImgWithStyle = curryRight(loadServerImage);
const loadTinyImg = curriedLoadImgWithStyle('?x-oss-process=style/tiny');
const loadSmallImg = curriedLoadImgWithStyle('?x-oss-process=style/small');
const loadMiddleImg = curriedLoadImgWithStyle('?x-oss-process=style/middle');
const loadNormalImg = curriedLoadImgWithStyle('?x-oss-process=style/normal');
const loadLargeImg = curriedLoadImgWithStyle('?x-oss-process=style/large');
const loadXLargeImg = curriedLoadImgWithStyle('?x-oss-process=style/xlarge');
const loadOriginImg = curriedLoadImgWithStyle('?x-oss-process=style/origin');
const loadThumbnailImg = curriedLoadImgWithStyle('?x-oss-process=style/thumbnail');

const getImageUrl = (uri, size) => {
  let url = trim(uri || '');
  // 有时候 OSS 返回的图片路径会附带 uploadId 导致图片无法访问到
  const uploadIdIndex = url.lastIndexOf('?uploadId=');
  if (uploadIdIndex > 0) {
    console.log('uploadIdIndex', uploadIdIndex);
    url = url.substring(0, uploadIdIndex);
  }
  let result = url;
  if (url) {
    switch (size) {
      case 'thumbnail':
        result = loadThumbnailImg(url);
        break;
      case 'tiny':
        result = loadTinyImg(url);
        break;
      case 'small':
        result = loadSmallImg(url);
        break;
      case 'middle':
        result = loadMiddleImg(url);
        break;
      case 'normal':
        result = loadNormalImg(url);
        break;
      case 'large':
        result = loadLargeImg(url);
        break;
      case 'xlarge':
        result = loadXLargeImg(url);
        break;
      case 'origin':
        result = loadOriginImg(url);
        break;
      default:
        result = url;
    }
  }
  return result;
};

class RichEditor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      content: '',
      ossToken: {},
      progress: 0,
    };
  }

  componentDidMount() {
    const { content = '' } = this.props;
    this.setState({ content });
    this.getToken();
  }

  // TODO: 需要根据具体的项目实现 OSSToken 的获取
  getToken = async () => {
    /*const loginResp = await login()
    console.log('adminLogin', loginResp);
    const selectAppResp = await selectApp();
    console.log('selectAppResp', selectAppResp);
    const ossTokenResp = await getOSSToken()
    console.log('ossTokenResp', ossTokenResp);
    const {data={}} = ossTokenResp
    this.setState({ossToken: data})*/
  };

  handleEditorChange = content => {
    console.log('handleEditorChange', content);
    const { onEditorChange } = this.props;
    this.setState({ content });
    if (typeof onEditorChange === 'function') {
      onEditorChange(content);
    }
  };

  progress = async (p = 0) => {
    console.log('progress', p);
    if (p > 0) {
      this.setState({ progress: 100 * p });
    }
    if (p >= 1) {
      this.setState({ progress: 0 });
    }
  };

  render() {
    const { content = '', progress = 0 } = this.state;
    const {
      height = 800,
      placeholder = '请输入内容',
      apiKey = 'r3lgalooz3dady4ma2yyqqop3pg722okrj3mx95pkxj8ewhj',
      readonly,
      imageSize = '',
    } = this.props;
    return (
      <Fragment>
        <Editor
          initialValue={content}
          apiKey={apiKey}
          init={{
            height,
            placeholder,
            min_height: 450,
            menubar: true,
            language: 'zh_CN',
            skin: 'oxide-dark',
            readonly: readonly,
            branding: false,
            elementpath: false,
            plugins:
              'print preview searchreplace autolink directionality visualblocks visualchars fullscreen image link media template code codesample table charmap hr pagebreak nonbreaking anchor insertdatetime advlist lists wordcount imagetools textpattern paste emoticons autosave autoresize',
            toolbar1: `undo redo paste searchreplace removeformat| forecolor backcolor bold italic underline strikethrough| alignleft aligncenter alignright   |
                      bullist numlist | blockquote subscript superscript|
                      table image media  emoticons charmap hr pagebreak insertdatetime `,
            toolbar2: 'styleselect formatselect fontselect fontsizeselect|fullscreen restoredraft',
            fontsize_formats: '12px 14px 16px 18px 24px 36px 48px 56px 72px',
            autosave_ask_before_unload: true,
            autosave_interval: '60s',
            resize: 'both',
            toolbar_mode: 'sliding',
            remove_trailing_brs: true,
            schema: 'html5',
            pagebreak_split_block: true,
            paste_data_images: true,
            paste_as_text: true,
            paste_enable_default_filters: true,
            paste_word_valid_elements:
              'table[width],tr,td[colspan|rowspan|width],th[colspan|rowspan|width],thead,tfoot,tbody',
            paste_webkit_styles: 'none',
            forced_root_block: 'div',
            images_upload_handler: (blobInfo, success, failure) => {
              const { ossToken = {} } = this.state;
              const { userHome = '' } = ossToken;
              const url = getUploadPath(blobInfo, userHome);
              client(ossToken)
                .multipartUpload(url, blobInfo.blob(), { progress: this.progress })
                .then(result => {
                  console.log('multipartUpload', result);
                  const imageUrl = getImageUrl(result.res.requestUrls[0], imageSize);
                  success(imageUrl);
                })
                .catch(err => {
                  console.log('err', err);
                  failure(err);
                });
            },
          }}
          onEditorChange={this.handleEditorChange.bind(this)}
        />
        <Modal
          visible={progress > 0}
          footer={null}
          title="图片上传中"
          closable={false}
          maskClosable={false}
          destroyOnClose
          width={800}
        >
          <Progress type="circle" percent={progress} style={{ textAlign: 'center' }} />
        </Modal>
      </Fragment>
    );
  }
}

export default RichEditor;
