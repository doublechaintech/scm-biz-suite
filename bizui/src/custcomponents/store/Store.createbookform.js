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
  Select,Modal,
  Popover,
  Switch,Radio
} from 'antd';

import { connect } from 'dva';
import PageHeaderLayout from '../../layouts/PageHeaderLayout';
//import PictureEdit from '../../components/PictureEdit'
//import OSSPictureEdit from '../../components/PictureEdit'
import { ImageComponent,playSound } from '../../axios/tools';
import FooterToolbar from '../../components/FooterToolbar';
//import Radio../components/ImageUpload'
import  styles from './Book.createform.less';
import { mapBackToImageValues, mapFromImageValues } from '../../axios/tools';
import GlobalComponents from '../../custcomponents';
import BookStoreExService from './Store.serviceex'
import { notification } from 'antd'

const { Option } = Select;
const { RangePicker } = DatePicker;
const { TextArea } = Input;
const fieldLabels = {
  id: 'ID',
  storeId:'商店序号',
  scannedIsbn:'扫描ISBN',
  bookCopyVendorId:'客户ID',
  bookCopySharingType:'共享类型',
  bookRecommendId:'建议类目',
  bookName: '书的名字',
  bookCover: '书的封面',
  bookAuthor: '作者',
  bookPublisher: '出版社',
  bookPubdate: '出版日期',
  listPrice: '市场价',
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

class BookCreateForm extends Component {
  state = {
    previewVisible: false,
    previewImage: '',
    convertedImagesValues: {},
    addingResult:{},
    candidateBookRecommends:{},
    dynamicFormInited: false,
    modalVisible: false,
  };

  componentDidMount() {
    // const { getFieldDecorator,setFieldsValue } = this.props.form
    const { setFieldsValue } = this.props.form;
    //setFieldsValue(testValues)
    this.executeCandidateBookRecommendSearch("")
    
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

  executeCandidateBookRecommendSearch = filterKey => {
    const { BookService } = GlobalComponents;

    const id = ''; //not used for now
    const pageNo = 1;
    const future = BookService.requestCandidateBookRecommend(
      'bookRecommend',
      id,
      filterKey,
      pageNo
    );
    console.log(future);

    future.then(candidateBookRecommendList => {
      this.setState({
        candidateBookRecommendList,
      });
    });
  };
  handleCandidateBookRecommendSearch = value => {
    this.executeCandidateBookRecommendSearch(value);
  };


  handleImageChange = (event, source) => {
    console.log('get file list from change in update change:', source);

    const { fileList } = event;
    const { convertedImagesValues } = this.state;

    convertedImagesValues[source] = fileList;
    this.setState({ convertedImagesValues });
    console.log('/get file list from change in update change:', source);
  };

  executeAddBook = (parameters) => {
    //const { BookService } = GlobalComponents;

    const storeId='S000001';
   
    const future = BookStoreExService.actionBookWarehousingWithIsbn(
      'storeId',
      parameters
    );
    //console.log(future);

    future.then(addingResult => {
      console.log("adding result", addingResult)

      const {dynamicFormInited}=this.state
      const {setFieldsValue} = this.props.form
 
      if(!addingResult){
        return null
      }
      if(addingResult.class!='com.terapico.shuxiang.book.BookWarehouseForm'){
        return null
      }
      
      if(!!addingResult.formMessageList&&addingResult.formMessageList.length>0){

        notification.error({
          message: "失败",
          description: addingResult.formMessageList[0].title,
        })
        playSound("inventory-error")
      }else{
        playSound("newbook")
      }



      if(dynamicFormInited){
        var formData = this.props.form.getFieldsValue();
        console.log("form data", formData, dynamicFormInited);
        addingResult.formFieldList.filter(
          item=>item.parameterName!="bookRecommendId"
          &&item.parameterName!="storeId"
          &&item.parameterName!="bookCopyVendorId"
          &&item.parameterName!="bookRecommendId"
          &&item.parameterName!="bookCover"
          
        ).map((item)=>{
          const value={};
          value[item.parameterName] = item.defaultValue
          setFieldsValue(value);
          
        })
        
        


      }


      addingResult.formFieldList.filter(item=>item.parameterName==="bookCover").map((item)=>{

        if(!item.defaultValue){
          return
        }
        const { convertedImagesValues } = this.state;
        /*
        const prefix="https://images.weserv.nl/?url=";
        const prefixLength="https://".length;
        const url=prefix+item.defaultValue.substring(prefixLength);

        console.log("url:", url);
           
        */   
       const fileList= [{ uid: item.parameterName, url: item.defaultValue}] 
        convertedImagesValues[item.parameterName] = fileList;
        this.setState({ convertedImagesValues });
      })
      
      this.setState({
        addingResult,
        dynamicFormInited: true
      });
      setFieldsValue({scannedIsbn:""})

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
        this.executeAddBook(values)


    })


  }

  render() {
    const { form, dispatch, submitting } = this.props;
    const { convertedImagesValues } = this.state;

    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form;
    
    const addManully = () => {
      validateFieldsAndScroll((error, values) => {
        if (error) {
          console.log('code go here', error);
          return;
        }

        const { owner } = this.props;
        const imagesValues = mapBackToImageValues(convertedImagesValues);

        const parameters = { ...values, ...imagesValues };
        console.log("parameters", parameters)
      });
    };

    const goback = () => {
      const { owner } = this.props;
      dispatch({
        type: `${owner.type}/goback`,
        payload: { id: owner.id, type: 'book', listName: '书列表' },
      });
    };
    const errors = getFieldsError();
    const getErrorInfo = () => {
      const errorCount = Object.keys(errors).filter(key => errors[key]).length;
      if (!errors || errorCount === 0) {
        return null;
      }
      // eslint-disable-next-line no-unused-vars
      const scrollToField = fieldKey => {
        const labelNode = document.querySelector('label[for="${fieldKey}"]');
        if (labelNode) {
          labelNode.scrollIntoView(true);
        }
      };
      const errorList = Object.keys(errors).map(key => {
        if (!errors[key]) {
          return null;
        }
        return (
          <li key={key} className={styles.errorListItem} onClick={() => scrollToField(key)}>
            <Icon type="cross-circle-o" className={styles.errorIcon} />
            <div className={styles.errorMessage}>{errors[key][0]}</div>
            <div className={styles.errorField}>{fieldLabels[key]}</div>
          </li>
        );
      });
      return (
        <span className={styles.errorIcon}>
          <Popover
            title="表单校验信息"
            content={errorList}
            overlayClassName={styles.errorPopover}
            trigger="click"
            getPopupContainer={trigger => trigger.parentNode}
          >
            <Icon type="exclamation-circle" />
          </Popover>
          {errorCount}
        </span>
      );
    };

    
    const {candidateBookRecommendList} = this.state
    if(!candidateBookRecommendList){
      return (<div>等等</div>)
    }

    const tryinit = fieldName => {
      
      const  owner  = this.props.store;
      return owner.id;
    };

    const availableForEdit = fieldName => {
      const { owner } = this.props;
      const { referenceName } = owner;
      if (referenceName != fieldName) {
        return true;
      }
      return false;
    };
    const formItemLayout = {
      labelCol: { span: 10 },
      wrapperCol: { span: 14 },
    };

    const modalFormItemLayout = {
      labelCol: { span: 4 },
      wrapperCol: { span: 20 },
    };

    const switchFormItemLayout = {
      labelCol: { span: 14 },
      wrapperCol: { span: 4 },
    };



    const {addingResult} = this.state
    
    const formItem=(item)=>{

      return (
        <Form.Item key={item.localeKey} label={item.label} {...formItemLayout}>
          {getFieldDecorator(item.parameterName, {
            rules: [{ required: false, message: '请输入书的名字' }],
            initialValue: item.defaultValue,
            value:item.defaultValue
          })(<Input placeholder="请输入书的名字" disabled={true}/>)}
        </Form.Item>
      )
    }

    
    const closeModal = () =>{
      this.setState({modalVisible:false})

    }
    const showModal = () =>{
      this.setState({modalVisible:true})

    }
    const showCreateLossAssessmentDialog=()=>{
      this.setState({modalVisible:true})
    }
    const createLossAssessment=()=>{

      validateFieldsAndScroll(["bookCopyId","storeId","bookCopyVendorId","bookId","discount","lostAssessmentDesc"],(error, values) => {

       
  //const url = `${PREFIX}employeeManager/createLossAssessmentWithBook/storeId/bookId/bookCopyId/customId/idOfDiscount/comment/`
    
        const parameters={customId:values.bookCopyVendorId,idOfDiscount:values.discount, comment:values.lostAssessmentDesc, ...values}
        console.log("createLossAssessment values from form",parameters)
        const future = BookStoreExService.createLossAssessmentWithBook(
          parameters
        )
      //console.log(future);
  
      future.then(result => {
        this.setState({modalVisible:false})
        notification.success({
          message: "操作成功",
          description: "操作成功",
        })
        
      })

        




      })


    }
    
    const showCreateLossAssessmentModel = () =>{
      //onOk={() => this.confirmAfterDelete()}
      //onCancel={() => this.confirmAfterDelete()}
      const modalVisible = this.state.modalVisible
      return (
        <Modal
          title="定损"
          visible={modalVisible}
          onCancel={closeModal}
          onOk={createLossAssessment}
          width={600}
          style={{ top: 40 }}
        >

        <Form.Item label={"重新定损折扣"} {...modalFormItemLayout}>
                  {getFieldDecorator('discount', {
                    rules: [{ required: false, message: '请输入' }],
                    
                  })(<Radio.Group  >
                    <Radio.Button value="LD000002">9折</Radio.Button>
                    <Radio.Button value="LD000003">8折</Radio.Button>
                    <Radio.Button value="LD000004">7折</Radio.Button>
                    <Radio.Button value="LD000005">6折</Radio.Button>
                    
                  </Radio.Group>)}



                </Form.Item>

                <Form.Item label={'定损备注'} {...modalFormItemLayout}>
                  {getFieldDecorator('lostAssessmentDesc', {
                   
                    rules: [{ required: false, message: '请使用扫描枪输入' }],
                  })(<TextArea rows={4} />)}
                </Form.Item>




         </Modal>)
      
    }

    const showDynamicForm =()=>{
      if(!addingResult){
        return null
      }
      if(addingResult.class!='com.terapico.shuxiang.book.BookWarehouseForm'){
        return null
      }
      
     
      
      return (
        
            <Row gutter={16}>
        {addingResult.formFieldList.filter(item=>
          item.fieldGroup=="基本信息"&&item.parameterName!="bookCover"
          ).map(item=>{return formItem(item)})}
            </Row>
          )

    }
/*

{<Button type="primary" onClick={addManully} loading={submitting}>
            手工提交
          </Button>
          <Button type="danger" onClick={goback} loading={submitting}>
            删除最后一本
          </Button>}

*/


    const deleteLastBookCopy=()=>{

      validateFieldsAndScroll(["bookCopyId"],(error, values) => {


      const  store  = this.props.store;

      const parameters={storeId:store.id,bookCopyId:values.bookCopyId,bookCopyVersion:'1',tokensExpr:'none'}
      const future = BookStoreExService.deleteBookCopyFromStore(
        parameters
      );
      //console.log(future);
  
      future.then(delteResult => {
        notification.success({
          message: "操作成功",
          description: "操作成功",
        })
      })


      })
      

    }

    
    const showActions =()=>{
      if(!addingResult){
        return null
      }
      if(addingResult.class!='com.terapico.shuxiang.book.BookWarehouseForm'){
        return null
      }
      
      /*
       <Button type="danger" onClick={goback} loading={submitting}>
            删除最后一本
          </Button>
          return ( <FooterToolbar>
          
     
          {addingResult.formActionList.map(item=>(
            <Button key={item.label} type={item.level}>{item.label}</Button>
          ))}
        </FooterToolbar>
        
          )
      
      */
     return ( <FooterToolbar>
          
     
          <Button type="danger" onClick={deleteLastBookCopy} loading={submitting}>
            删除最后一本
          </Button>
          <Button type="danger" onClick={showCreateLossAssessmentDialog} loading={submitting}>
            定损
          </Button>
    </FooterToolbar>)

    }


    return (
      <PageHeaderLayout
        title="新书入库"
        content="请尽量使用扫描枪操作"
        
      >

      <Card title="锁定设置" className={styles.card} bordered={false}>
          <Form>
            <Row gutter={16}>
              <Col lg={6} md={6} sm={12}>
                <Form.Item key="__" label={fieldLabels.storeId} {...formItemLayout}>
                  {getFieldDecorator('storeId', {
                    initialValue: tryinit('store'),
                    rules: [{ required: true, message: '请输入店的序号' }],

                  })(<Input placeholder="请输入店的序号" disabled={true}/>)}
                </Form.Item>
              </Col>
             
              <Col lg={6} md={6} sm={12}>
                <Form.Item label={fieldLabels.bookCopyVendorId} {...formItemLayout}>
                  {getFieldDecorator('bookCopyVendorId', {

                    rules: [{ required: true, message: '请输入' }],
                    initialValue:""
                  })(<Input placeholder="请输入" />)}
                </Form.Item>
              </Col>    
              
              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.bookRecommendId} {...formItemLayout}>
                {getFieldDecorator('bookRecommendId', {
                  	initialValue: 'BR000001',
                    rules: [{ required: true, message: '请输入图书推荐' }],
                  })(
                  
                  <AutoComplete
                    dataSource={candidateBookRecommendList.candidates}
                    
                    
                    onSearch={this.handleCandidateBookRecommendSearch}
                    placeholder="请输入图书推荐"
                  
                  >
                  {candidateBookRecommendList.candidates.map(item=>{
                return (<Option key={item.id}>{`${item.name}(${item.id})`}</Option>);
            })}
                  
                  </AutoComplete>
                  )}
                </Form.Item>
              </Col> 
              <Col lg={6} md={6} sm={12}>
                <Form.Item label={fieldLabels.bookCopySharingType} {...formItemLayout}>
                  {getFieldDecorator('bookCopySharingType', {
                    rules: [{ required: true, message: '请输入' }],
                    initialValue: "共享",
                  })(<Radio.Group  >
                    <Radio.Button value="捐赠">捐赠</Radio.Button>
                    <Radio.Button value="共享">共享</Radio.Button>
                    
                  </Radio.Group>)}
                </Form.Item>
              </Col> 
              

            </Row> 
            
            
            </Form>
        </Card>
        <Card title="扫描输入" className={styles.card} bordered={false}>
        <Form>
            <Row gutter={16}>
              
              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.scannedIsbn} {...formItemLayout}>
                  {getFieldDecorator('scannedIsbn', {
                    rules: [{ required: true, message: '请使用扫描枪输入' }],
                  })(<Input autoFocus autocompelete={"off"} placeholder="请使用扫描枪输入" onPressEnter={this.handleEnterOnScanISBN}/>)}
                </Form.Item>

                 {showDynamicForm()}   

              </Col>
              <Col lg={12} md={12} sm={24}>
              <ImageComponent className={styles.bookCoverUpload}
                  buttonTitle="书的封面"
                  handlePreview={this.handlePreview}
                  handleImageChange={event => this.handleImageChange(event, 'bookCover')}
                  fileList={convertedImagesValues.bookCover}
                />
              </Col>

            </Row> 
            
            
            </Form>
        </Card>
        {showActions()}
        {showCreateLossAssessmentModel()}
      </PageHeaderLayout>
    );
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
  store: state._store
}))(Form.create()(BookCreateForm));
