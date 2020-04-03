import { Upload, Icon, Modal } from 'antd';

import styles from './index.less'

const fileMapper=[
  {type:"jpg",cover: "file-image"},
  {type:"jpeg",cover: "file-image"},
  {type:"png",cover: "file-image"},
  {type:"gif",cover: "file-image"},
  {type:"xls",cover: "file-excel"},
  {type:"xlsx",cover: "file-excel"},
  {type:"pdf",cover: "file-pdf"},
  {type:"doc",cover: "file-word"},
  {type:"docx",cover: "file-word"},
  {type:"zip",cover: "file-zip"},
  {type:"rar",cover: "file-zip"},
  {type:"txt",cover: "file-text"},

]
const coverIconFromFileName=(fileName)=>{
  if(!fileName){
    return "file-unknown";
  }
  

  const firstFileSufix = fileName.split('.').pop().toLowerCase();
  

  const types = fileMapper.filter(item=>item.type===firstFileSufix)

  if(!types){
    return  ("file-unknown")
  }
  if(types.length === 0){
    return ("file-unknown")
  }

  const firstType = types[0]
  
  return (firstType.cover)

}
const resizeDispayImageInList=(imageLocation)=>resizeDispayImage(imageLocation,"small")

const resizeDispayImageForPreview=(imageLocation)=>resizeDispayImage(imageLocation,"xlarge")


const notImageFile=(imageLocation)=>{
  const mapperList = ["pdf","zip","doc","docx","xls","xlsx"]
  if(!imageLocation){
    return true
  }
  const firstFileSufix = imageLocation.split('.').pop().toLowerCase();
  const types=mapperList.filter(item=>item===firstFileSufix);
  return types.length === 1

}
const resizeDispayImage=(imageLocation, style)=>{


  if(!imageLocation){
    return imageLocation
  }
  if(!imageLocation.indexOf){
    return imageLocation
  }


  if(notImageFile(imageLocation)){
    return imageLocation // ignore path
  }

  if(imageLocation.indexOf("?")<0){
    return `${imageLocation}?x-oss-process=style/${style}`
  }


  return imageLocation.replace("small",style)

}



export default class ImagePreview extends React.Component {
  state = {
    previewVisible: false,
    previewImage: '',
   
  };

  


  componentDidMount() {
    

  }
  componentWillReceiveProps(){
    

  }
  handleCancel = () => this.setState({ previewVisible: false })



  handlePreview = (event, imageLocation) => {
    console.log("preview file", imageLocation)
    this.setState({
      previewImage: resizeDispayImageForPreview(imageLocation),
      previewVisible: true,
    });
  }
  
  handleChange = ({ fileList }) => this.setState({ fileList })

  render() {
   
    const {imageLocation,imageTitle,showTitleUnderImage, imageStyle, imageSize} = this.props;
    const {previewVisible,previewImage} = this.state;
    // const {fileList} = this.state;
    const suffix = " | 图片预览";
    const modalTitle = imageTitle?imageTitle+suffix:suffix;
    const internalImageStyle = imageStyle || {height:80, width:80}

    if(notImageFile(imageLocation)){
      return  <div className="clearfix" style={{textAlign:"center"}} >
        <a href={imageLocation} target="_blank">
        <Icon type={coverIconFromFileName(imageLocation)} style={{fontSize:100}}/>
        </a>
        </div>
    }
    


    return (

      <div  style={{textAlign:"center"}}>
        <img
          src={resizeDispayImageInList(imageLocation)}
         
          style={internalImageStyle}
          title={imageLocation}
          alt={imageLocation}
          onClick={(event)=>this.handlePreview(event,imageLocation)}
        >


           
        </img>
        {showTitleUnderImage&&(<span style={{"display": "block"}}>{imageTitle}</span>)}
        <Modal visible={previewVisible} title={modalTitle} footer={null} 
          onCancel={this.handleCancel}   width="100%">
          <img alt={imageTitle}  src={previewImage}  style={{"width": "100%"}}/>
        </Modal>
      </div>
    );
  }
}