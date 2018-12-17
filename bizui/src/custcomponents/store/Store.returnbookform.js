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
  scannedIsbn:'扫描二维码或者手动输入书本序号',
  bookCopyVendorId:'借书者',
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

const sampleData={
  "class": "com.terapico.shuxiang.borrowinghistory.BorrowingHistory",
  "displayName": "重新定位（经典重译版）",
  "id": "BH000029",
  "lendingDatetime": 1535444948000,
  "bookName": "重新定位（经典重译版）",
  "borrower": {
      "class": "com.terapico.shuxiang.customer.Customer",
      "displayName": "书香",
      "id": "C000003",
      "nickName": "书香",
      "logoImage": "https://wx.qlogo.cn/mmopen/vi_32/pldHJtJTYWXkznqtvRsP0dXt31PTdAS0OjMjgj6pAqCMWOEDOBzsHaZgjNsZccxurAnHCEIpB10IwMqI4cWdibw/132",
      "mobileNumber": "177****1560",
      "realName": "戚燕锋",
      "sexuality": "男",
      "memberServiceStartDate": 1533571200000,
      "memberServiceExpireDate": 1592841600000
  },
  "borrowerMemberLevel": "尊贵会员",
  "borrowerMemberServiceExpiredDatetime": 1592927999000,
  "book": {
      "class": "com.terapico.shuxiang.book.Book",
      "displayName": "重新定位（经典重译版）",
      "id": "B000014",
      "bookName": "重新定位（经典重译版）",
      "bookCover": "https://images.weserv.nl/?url=img3.doubanio.com/view/subject/m/public/s29560346.jpg",
      "bookAuthor": "[美] 杰克·特劳特（Jack Trout）,史蒂夫·里夫金（Steve Rivkin）",
      "bookPublisher": "机械工业出版社",
      "bookPubdate": 1506787200000,
      "listPrice": 49.0,
      "bookIsbn13": "9787111578253"
  },
  "bookCopy": {
      "class": "com.terapico.shuxiang.bookcopy.BookCopy",
      "displayName": "共享",
      "id": "BC000028",
      "bookCopySharingType": "共享",
      "evaluationPrice": 49.0,
      "wxaId": "https://shuxiang.ycinfotech.cn/shuxiang/wxaService/bookCopyScanned/BC000028/",
      "createTime": 1535000988000,
      "lastUpdateTime": 1535000988000,
      "version": 16
  },
  "bookCopySharingType": "共享",
  "lendingStore": {
      "class": "com.terapico.shuxiang.store.Store",
      "displayName": "慕和南道",
      "id": "S000001",
      "storeName": "慕和南道",
      "storeSubname": "亲子综合馆",
      "storeAddress": "慕和南道二期",
      "storeOpenTime": "9:00~22:00",
      "storeOpenTimeSecond": "周末不休",
      "storeRoomNumber": "16-02-804",
      "longitude": 104.050862
  },
  "lendingStoreType": "社区",
  "freeLendingDays": 30,
  "freeLendingExpiredDatetime": 1538036948000,
  "overduePay": 0.8,
  "returnDatetime": 1535496663749,
  "returnStore": {
      "class": "com.terapico.shuxiang.store.Store",
      "displayName": "慕和南道",
      "id": "S000001",
      "storeName": "慕和南道",
      "storeSubname": "亲子综合馆",
      "storeAddress": "慕和南道二期",
      "storeOpenTime": "9:00~22:00",
      "storeOpenTimeSecond": "周末不休",
      "storeRoomNumber": "16-02-804",
      "longitude": 104.050862
  },
  "lendingDays": 0,
  "freeLendingExpired": false,
  "lastUpdateTime": 1535496663750,
  "borrowingStatus": {
      "class": "com.terapico.shuxiang.borrowingstatus.BorrowingStatus",
      "displayName": "已归还",
      "id": "BS000001",
      "name": "已归还",
      "code": "Returned",
      "version": 1
  },
  "version": 2,
  "borrowingExpiredSkuCurrentPageNumber": 1
}


class BookReturnForm extends Component {
  state = {
    previewVisible: false,
    previewImage: '',
    convertedImagesValues: {},
    returnResult:{},
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


createLossAssessment = (parameters) =>{
  const {returnResult} = this.state
  //employeeManager/createNewLossAssessment/idOfBorrowingHistory/idOfDiscount/comment/
  const requestValues={idOfBorrowingHistory:returnResult.id,
    idOfDiscount:parameters.discount,
    comment:parameters.lostAssessmentDesc,...parameters
    
  }
  console.log("request values", requestValues)
  const future = BookStoreExService.createLossAssessment(
    requestValues
  )

  future.then(lossResult =>{

    console.log("lossResult",lossResult)
    notification.success({
      message: "操作成功",
      description: "操作成功, 新的价格是 "+lossResult.bookCopyEvaluationPrice+"(参考 "+lossResult.id+")",
    })
  })


}

returnBookByEmployee = (parameters) => {
  //const { BookService } = GlobalComponents;

  
 
  const future = BookStoreExService.returnBookByEmployee(
    'storeId',
    parameters
  );
  //console.log(future);
  const {dynamicFormInited}=this.state
  const {setFieldsValue} = this.props.form
  future.then(returnResult => {
    console.log("returnResult result", returnResult)
    if(!returnResult.class){
      notification.error({
        message: "服务器端出错",
        description: "服务器出错，请尝试重新登录",
      })
      setFieldsValue({bookCopyIdOrQrcode:""})
      return
    }

    if(returnResult.class.indexOf("Exception")>0){

      notification.error({
        message: "状态错误",
        description: returnResult.message,
      })
      setFieldsValue({bookCopyIdOrQrcode:""})
      return
    }
    notification.success({
      message: "执行成功",
      description: returnResult.message,
    })

    this.setState({returnResult})


    
    setFieldsValue({bookCopyIdOrQrcode:""})
   
    

  });
};


assessLost = (event) => {
  const { form, dispatch, submitting } = this.props;
  const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form;
  const {returnResult} = this.state
  //console.log("event",event,event.target.value)
  validateFieldsAndScroll((error, values) => {
      
    console.log("value from form",values)
    if(!values.discount){
      notification.error({
        message: "请输入定损折扣",
        description:"请输入定损折扣",
      })
      return
    }
    if(!values.lostAssessmentDesc){
      notification.error({
        message: "请输入定损描述",
        description: "请输入定损描述",
      })
      return
    }
    this.createLossAssessment(values)
  })


}

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
        this.returnBookByEmployee(values)


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


    const {returnResult} = this.state
    
    const showBookCopyDetail = (returnResult) =>{
      if(!returnResult){
        return null
      }
      if(!returnResult.class){
        return null
      }
      if(returnResult.class!='com.terapico.shuxiang.borrowinghistory.BorrowingHistory'){
        return <div>该书已经归还</div>
      }
      
      const {setFieldsValue,getFieldsValue} = this.props.form
      const oldValues=getFieldsValue()
      
      
      


      return (<Card title={`图书信息: ${returnResult.book.bookName}`} className={styles.card} bordered={false}> <Row gutter={16}>
      <Col lg={24} md={24} sm={24}> </Col>

        <Form.Item label={'市场价'} {...formItemLayout}>
                  <Input disabled={true} value={returnResult.book.listPrice}/>
                </Form.Item>
                <Form.Item label={'最近评估价格'} {...formItemLayout}>
                   <Input disabled={true} value={returnResult.bookCopy.evaluationPrice}/>
                </Form.Item>
                <Form.Item label={"重新定损折扣"} {...formItemLayout}>
                  {getFieldDecorator('discount', {
                    rules: [{ required: false, message: '请输入' }],
                    sampleData
                  })(<Radio.Group  >
                    <Radio.Button value="LD000002">9折</Radio.Button>
                    <Radio.Button value="LD000003">8折</Radio.Button>
                    <Radio.Button value="LD000004">7折</Radio.Button>
                    <Radio.Button value="LD000005">6折</Radio.Button>
                    
                  </Radio.Group>)}



                </Form.Item>

                <Form.Item label={'定损备注'} {...formItemLayout}>
                  {getFieldDecorator('lostAssessmentDesc', {
                   
                    rules: [{ required: false, message: '请使用扫描枪输入' }],
                  })(<TextArea rows={4} />)}
                </Form.Item>

          <Button type="danger" onClick={this.assessLost}>重新定损</Button>
      </Row> </Card>

        



      )



    }
  

    

    return (
      <PageHeaderLayout
        title="批量还书"
        content="请尽量使用扫描枪扫二维码"
        wrapperClassName={styles.advancedForm}
      >

      
        <Card title="扫描输入" className={styles.card} bordered={false}>
        <Form>
            <Row gutter={16}>
              
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.scannedIsbn} {...formItemLayout}>
                  {getFieldDecorator('bookCopyIdOrQrcode', {
                    rules: [{ required: false, message: '请使用扫描枪输入' }],
                  })(<Input autoFocus autocompelete={"off"} placeholder="请使用扫描枪输入" onPressEnter={this.handleEnterOnScanISBN}/>)}
                </Form.Item>
              </Col>
              
            </Row> 
            
            
            </Form>

        </Card>
        {showBookCopyDetail(returnResult)} 
        
       

        
      </PageHeaderLayout>
    );
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
  store: state._store
}))(Form.create()(BookReturnForm));
