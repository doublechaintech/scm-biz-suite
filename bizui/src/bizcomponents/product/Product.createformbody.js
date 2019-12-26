import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import SelectObject from '../../components/SelectObject'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './Product.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import ProductBase from './Product.base'
import appLocaleName from '../../common/Locale.tool'
const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input
<<<<<<< HEAD

=======
const {fieldLabels} = ProductBase
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const testValues = {};
/*
const testValues = {
  name: '啤酒',
  origin: '四川',
  remark: '可口可乐，销售百年的糖水，获得了全世界额青睐',
  brand: '品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品',
  parentCategoryId: 'LTC000001',
}
*/

const imageKeys = [
  'picture',
]


class ProductCreateFormBody extends Component {
  state = {
    previewVisible: false,
    previewImage: '',
    convertedImagesValues: {},
  }

  componentDidMount() {
	
    
    
  }

  handlePreview = (file) => {
    console.log('preview file', file)
    this.setState({
      previewImage: file.url || file.thumbUrl,
      previewVisible: true,
    })
  }

 



  handleChange = (event, source) => {
    console.log('get file list from change in update change:', source)

    const { fileList } = event
    const { convertedImagesValues } = this.state

    convertedImagesValues[source] = fileList
    this.setState({ convertedImagesValues })
    console.log('/get file list from change in update change:', source)
  }
	
  

  render() {
    const { form, dispatch, submitting, role } = this.props
    const { convertedImagesValues } = this.state
	const userContext = null
    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
<<<<<<< HEAD
    const {fieldLabels} = ProductBase
=======
    
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
    const {ProductService} = GlobalComponents
    
    const capFirstChar = (value)=>{
    	//const upper = value.replace(/^\w/, c => c.toUpperCase());
  		const upper = value.charAt(0).toUpperCase() + value.substr(1);
  		return upper
  	}
    
    
    const tryinit  = (fieldName) => {
      const { owner } = this.props
      if(!owner){
      	return null
      }
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return null
      }
      return owner.id
    }
    
    const availableForEdit= (fieldName) =>{
      const { owner } = this.props
      if(!owner){
      	return true
      }
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return true
      }
      return false
    
    }
	const formItemLayout = {
      labelCol: { span: 6 },
      wrapperCol: { span: 12 },
    }
    const switchFormItemLayout = {

      labelCol: { span: 6 },
      wrapperCol: { span: 12 },

    }
    
    const internalRenderTitle = () =>{
      const linkComp=<a onClick={goback}  > <Icon type="double-left" style={{marginRight:"10px"}} /> </a>
<<<<<<< HEAD
      return (<div>{linkComp}{appLocaleName(userContext,"CreateNew")}产品</div>)
=======
      return (<div>{linkComp}{appLocaleName(userContext,"CreateNew")}{window.trans('product')}</div>)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
    }
	
	return (
      <div>
        <Card title={!this.props.hideTitle&&appLocaleName(userContext,"BasicInfo")} className={styles.card} bordered={false}>
          <Form >
          	<Row gutter={16}>
           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.name} {...formItemLayout}>
                  {getFieldDecorator('name', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="名称" />
=======
                    <Input size="large"  placeHolder={fieldLabels.name} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.origin} {...formItemLayout}>
                  {getFieldDecorator('origin', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="产地" />
=======
                    <Input size="large"  placeHolder={fieldLabels.origin} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.remark} {...formItemLayout}>
                  {getFieldDecorator('remark', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="备注" />
=======
                    <Input size="large"  placeHolder={fieldLabels.remark} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.brand} {...formItemLayout}>
                  {getFieldDecorator('brand', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="品牌" />
=======
                    <Input size="large"  placeHolder={fieldLabels.brand} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>


       
 
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.parentCategory} {...formItemLayout}>
                  {getFieldDecorator('parentCategoryId', {
                  	initialValue: tryinit('parentCategory'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('parentCategory')}
                    targetType={"parentCategory"} 
                    requestFunction={ProductService.requestCandidateParentCategory}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

           



			 </Row>
          </Form>
        </Card>






       <Card title={<div>{appLocaleName(userContext,"Attachment")} <Popover title={appLocaleName(userContext,"ScanQRCodetoUploadfromSmartPhone")} content={<div><img src='./qrtest.png'/></div>}><Icon type="qrcode" ></Icon></Popover></div>} className={styles.card} bordered={false}>
          <Form >
            <Row gutter={16}>     
           

              <Col lg={6} md={12} sm={24}>
                <ImageComponent
<<<<<<< HEAD
                  buttonTitle="图片"
=======
                  buttonTitle={fieldLabels.picture}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  handlePreview={this.handlePreview}
                  handleChange={event => this.handleChange(event, 'picture')}
                  fileList={convertedImagesValues.picture}
                />
              </Col>

             </Row>
          </Form>
        </Card>
         



      
       </div>
    )
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(ProductCreateFormBody))





