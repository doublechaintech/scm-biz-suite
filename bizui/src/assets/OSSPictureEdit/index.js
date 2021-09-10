import { Upload, Icon, Modal } from 'antd';

export default class OSSPictureEdit extends React.Component {
  state = {
    previewVisible: false,
    previewImage: '',
    fileList: [],
  };




  componentDidMount() {
    

  }
  componentWillReceiveProps(){
    const { fileList} = this.props;
    this.setState({ fileList });

  }
  handleCancel = () => this.setState({ previewVisible: false })

  handlePreview = (file) => {
    console.log("preview file", file)
    this.setState({
      previewImage: file.url || file.thumbUrl,
      previewVisible: true,
    });
  }

  handleChange = ({ fileList }) => this.setState({ fileList })

  render() {
    const { previewVisible, previewImage} = this.state;
    const {fileList} = this.props;
    //const {fileList} = this.state;
    const internalFileList = fileList?fileList:[];
    console.log("file list in render", fileList);
    
    const {buttonTitle, handleChange,handlePreview } = this.props;
    const uploadButton = (
      <div>
        <Icon type="plus" />
        <div className="ant-upload-text">{buttonTitle}</div>
      </div>
    );
    return (
      <div className="clearfix">
        <Upload
          action="//localhost:2090/upload/"
          listType="picture-card"
          fileList={internalFileList}
          onPreview={this.handlePreview}
          onChange={handleChange}
          multiple={false}
        >
          {internalFileList.length >= 1 ? null : uploadButton}
        </Upload>
        <Modal visible={previewVisible} footer={null} onCancel={this.handleCancel}>
          <img alt="example" style={{ width: '100%' }} src={previewImage} />
        </Modal>
      </div>
    );
  }
}