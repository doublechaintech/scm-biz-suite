import React, { Component } from 'react';
import {
  AutoComplete,
  Card,
  Button,
  Form,
  Icon,
  Col,
  Row,
  DatePicker,
  TimePicker,
  Input,
  Select,
  Popover,
  Switch,Radio
} from 'antd';
import { notification } from 'antd'
import { connect } from 'dva';
import PageHeaderLayout from '../../layouts/PageHeaderLayout';
//import PictureEdit from '../../components/PictureEdit'
//import OSSPictureEdit from '../../components/PictureEdit'
import { ImageComponent } from '../../axios/tools';
import FooterToolbar from '../../components/FooterToolbar';
//import Radio../components/ImageUpload'
import styles from './Book.createform.less';
import { mapBackToImageValues, mapFromImageValues } from '../../axios/tools';
import GlobalComponents from '../../custcomponents';
import BookStoreExService from './Store.serviceex'


const { Option } = Select;
const { RangePicker } = DatePicker;
const { TextArea } = Input;
const fieldLabels = {
  id: 'ID',
  storeId:'商店序号',
  scannedIsbn:'扫描二维码或者手动输入',
  bookCopyVendorId:'客户ID',
  bookCopySharingType:'共享类型',
  bookRecommendId:'建议类目',
  bookName: '书的名字',
  bookCover: '书的封面',
  bookAuthor: '书的作者',
  bookPublisher: '图书出版者',
  bookPubdate: '书的作用',
  listPrice: '列出的价格',
  bookIsbn13: '书Isbn13',
  bookIsbn10: '书Isbn10',
  bookRecommend: '书推荐',
  bookPlaza: '本广场',
  platform: '平台',
};
const testValues = {};
/*
const testValues = {
  bookName: '飘',
  bookAuthor: '吕之华',
  bookPublisher: '中信出版社',
  bookPubdate: '2017-04-29',
  listPrice: '61.69',
  bookIsbn13: '978-7-505-71566-0',
  bookIsbn10: '',
  bookRecommendId: 'BR000001',
  bookPlazaId: 'BP000001',
  platformId: 'BSP000001',
}
*/
const imageURLPrefix = '//localhost:2090';

const imageKeys = ['bookCover'];

class BookLaunchForm extends Component {
  state = {
    previewVisible: false,
    previewImage: '',
    convertedImagesValues: {},
    executeResult:{},
    dynamicFormInited: false
  };

  componentDidMount() {
    // const { getFieldDecorator,setFieldsValue } = this.props.form
    const { setFieldsValue } = this.props.form;
    //setFieldsValue(testValues)

    
  }
  shouldComponentUpdate() {
    return true;
  }
  handlePreview = file => {
    console.log('preview file', file);
    this.setState({
      previewImage: file.url || file.thumbUrl,
      previewVisible: true,
    });
  };




launchBookByEmployee = (parameters) => {
  //const { BookService } = GlobalComponents;

  const storeId='S000001';
 
  const future = BookStoreExService.putBookOnShelf('storeId',  parameters);
  //console.log(future);

  future.then(executeResult => {
    console.log("adding result", executeResult)
    if(!executeResult.class){
      notification.error({
        message: "服务器端出错",
        description: "服务器出错，请尝试重新登录",
      })
      return
    }

    if(executeResult.class.indexOf("Exception")>0){

      notification.error({
        message: "状态错误",
        description: executeResult.message,
      })
      return
    }
    notification.success({
      message: "执行成功",
      description: executeResult.message,
    })
    const {dynamicFormInited}=this.state
    const {setFieldsValue} = this.props.form
    setFieldsValue({bookCopyIdOrQrcode:""})
    

  });
  
};



  handleEnterOnScanISBN = (event) => {
    const { form, dispatch, submitting } = this.props;
    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form;
    //console.log("event",event,event.target.value)
    validateFieldsAndScroll((error, values) => {
        if (error) {
          console.log('code go here', error);
          return;
        }
        console.log('collected values', values)
        this.launchBookByEmployee(values)


    })


  }

  render() {
    const { form, dispatch, submitting } = this.props;
    const { convertedImagesValues } = this.state;

    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form;
    

    const goback = () => {
      const  owner  = this.props.store;
      dispatch({
        type: `${owner.type}/goback`,
        payload: { id: owner.id, type: 'book', listName: '书列表' },
      });
    };
    
    const formItemLayout = {
      labelCol: { span: 10 },
      wrapperCol: { span: 14 },
    };

    const tryinit = () => {
      
      const  owner  = this.props.store;
      
      return owner.id;
    }
    const {executeResult} = this.state
    
 

    

    return (
      <PageHeaderLayout
        title="批量上架"
        content="请尽量使用扫描枪扫二维码"
        wrapperClassName={styles.advancedForm}
      >

      
        <Card title="扫描输入" className={styles.card} bordered={false}>
        <Form>
            <Row gutter={16}>
            <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.storeId} {...formItemLayout}>
                  {getFieldDecorator('storeId', {
                    initialValue: tryinit(),
                    rules: [{ required: true, message: '请输入店的序号' }],

                  })(<Input placeholder="请输入店的序号" disabled={true}/>)}
                </Form.Item>
              </Col>
              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.scannedIsbn} {...formItemLayout}>
                  {getFieldDecorator('bookCopyIdOrQrcode', {
                    rules: [{ required: true, message: '请使用扫描枪输入' }],
                  })(<Input autoFocus autocompelete={"off"} placeholder="请使用扫描枪输入" onPressEnter={this.handleEnterOnScanISBN}/>)}
                </Form.Item>
              </Col>


            </Row> 
            
            
            </Form>
        </Card>
      

       

        <FooterToolbar>
         
         
          <Button type="primary" onClick={()=>this.handleEnterOnScanISBN} loading={submitting}>
            手工提交
          </Button>
          <Button type="danger" onClick={goback} loading={submitting}>
            放弃
          </Button>
        </FooterToolbar>
      </PageHeaderLayout>
    );
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
  store: state._store
}))(Form.create()(BookLaunchForm));
