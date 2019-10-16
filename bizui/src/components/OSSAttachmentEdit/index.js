import { Upload, Icon, Modal } from 'antd';
import axios from 'axios';
import { getURLPrefix } from '../../axios/tools';
import { notification } from 'antd'
const appendStyle=(imageLocation, style)=>{

  if(!imageLocation){
    return imageLocation
  }
  


  if(!imageLocation.indexOf){
    return imageLocation
  }
  if(imageLocation.indexOf("?")<0){
    return imageLocation+"?x-oss-process=style/"+style
  }
  return imageLocation.replace("small",style)
  
}

const appendToObjectStyle=(imageLocation, style)=>{
  if(typeof imageLocation=="object"){
    const url=appendStyle(imageLocation.url,style)
    console.log("changed url" , url,"from", imageLocation)
    const finalLocation = {...imageLocation, url}
    console.log("finalLocation url" , finalLocation)
    return  finalLocation
  
  }
  return appendStyle(imageLocation, style)
}



const resizeDispayImage=(imageLocation, style)=>{
  if (Array.isArray(imageLocation)) {
    
    return imageLocation.map(imageLocation=>appendToObjectStyle(imageLocation,style))
    
  }
  return appendStyle(imageLocation,style)
}

const resizeDispayImageInList=(imageLocation)=>resizeDispayImage(imageLocation,"small")

const resizeDispayImageForPreview=(imageLocation)=>resizeDispayImage(imageLocation,"xlarge")

const client = self => {
  console.log('self', self);
  const { token } = self.state;
  console.log('token------------', token);
  if (!token) {
    console.err('Token could not be null');
    return;
  }
  return new window.OSS.Wrapper({
    endpoint: token.endpoint,
    accessKeyId: token.accessKeyId,
    accessKeySecret: token.accessKeySecret,
    stsToken: token.securityToken,
    region: token.region,
    bucket: token.bucket,
  });
};

const uploadPath = (path, file) => {
  return `${path}/${file.name.split('.')[0]}-${file.uid}.${file.type.split('/')[1]}`;
};

const uploadToOss = (self, path, file) => {
  const url = uploadPath(path, file);
  return new Promise((resolve, reject) => {
    client(self)
      .multipartUpload(url, file)
      .then(data => {
        resolve(data);
      })
      .catch(error => {
        reject(error);
      });
  });
};

export default class OSSPictureEdit extends React.Component {
  state = {
    previewVisible: false,
    previewImage: '',
    fileList: [],
    token: {},
  };

  beforeUpload = file => {
    let reader = new FileReader();
    const { token } = this.state;
    const OSS_IMAGE_FILE_PATH = token.userHome;

    reader.readAsDataURL(file);
    console.log('The file is', file);
    const { buttonTitle, handleChange, handlePreview } = this.props;
    reader.onloadend = () => {
      uploadToOss(this, OSS_IMAGE_FILE_PATH, file).then(data => {
        console.log('data from server', data);
        
        notification.success({
          message: `上传成功`,
          description: `上传成功`,
        })
        

        const fileList = [
          {
            uid: file.uid,
            name: data.name,
            status: 'done',
            type: data.type,
            result: token.prefix + '/' + encodeURIComponent(data.name),
            url: token.prefix + '/' + encodeURIComponent(data.name),
            response: token.prefix + '/' + encodeURIComponent(data.name),
          },
        ];
        const event = { fileList };
        handleChange(event);
      });
    };
    return false;
  };

  componentDidMount() {
    const getSTSURL = () => {
      const url = new URL(window.location);

      return (
        getURLPrefix() + 'secUserManager/testoss/'
      );
    };

    axios.get(getSTSURL(),{headers:{"X-App-Version":35}}).then(res => {
      const token = res.data;
      this.setState({ token });
    });
  }
  componentWillReceiveProps() {
    const { fileList } = this.props;
    this.setState({ fileList });
  }
  handleCancel = () => this.setState({ previewVisible: false });

  handlePreview = file => {
    console.log("file for preview is ", file)
    if(!file){
     
      return
    }
    

    const previewFile = appendToObjectStyle(file,"xlarge")
    console.log('preview file', previewFile);
    console.log('previewImage: previewFile.url || previewFile.thumbUrl', previewFile.url || previewFile.thumbUrl);
    

    this.setState({
      previewImage: previewFile.url || previewFile.thumbUrl,
      previewVisible: true,
    })
  }

  handleChange = ({ fileList }) => this.setState({ fileList });

  render() {
    const { previewVisible, previewImage } = this.state;
    const { fileList } = this.props;
    const { buttonTitle, handleChange, handlePreview } = this.props;
    //const {fileList} = this.state;
    const internalFileList = fileList ? fileList : [];
    console.log('file list in render', fileList);
    const suffix = ' | 图片预览';
    const modalTitle = buttonTitle ? buttonTitle + suffix : suffix;

    const uploadButton = (
      <div>
        <Icon type="plus" />
        <div className="ant-upload-text">{buttonTitle}</div>
      </div>
    );
    return (
      <div className="clearfix">
        <Upload
          
          listType="picture-card"
          fileList={resizeDispayImageInList(internalFileList)}
          onPreview={this.handlePreview}
          onChange={handleChange}
          multiple={false}
          beforeUpload={this.beforeUpload}
        >
          <Icon type="file-excel"/>
          {internalFileList.length >= 1 ? null : uploadButton}
        </Upload>
        <Modal
          visible={previewVisible}
          title={modalTitle}
          footer={null}
          onCancel={this.handleCancel}
        >
          <img alt={buttonTitle} style={{ width: '100%' }} src={previewImage} />
        </Modal>
      </div>
    );
  }
}
