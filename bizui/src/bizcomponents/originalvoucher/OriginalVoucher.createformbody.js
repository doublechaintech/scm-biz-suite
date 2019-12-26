import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import SelectObject from '../../components/SelectObject'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './OriginalVoucher.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import OriginalVoucherBase from './OriginalVoucher.base'
import appLocaleName from '../../common/Locale.tool'
const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input
<<<<<<< HEAD

=======
const {fieldLabels} = OriginalVoucherBase
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const testValues = {};
/*
const testValues = {
  title: '这是手写的发票',
  madeBy: '李亚青',
  receivedBy: '本公司',
  voucherType: '原始凭证',
  belongsToId: 'AD000001',
<<<<<<< HEAD
=======
  creationId: 'OVC000001',
  confirmationId: 'OVC000001',
  auditingId: 'OVA000001',
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
}
*/

const imageKeys = [
  'voucherImage',
]


class OriginalVoucherCreateFormBody extends Component {
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
    const {fieldLabels} = OriginalVoucherBase
=======
    
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
    const {OriginalVoucherService} = GlobalComponents
    
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
      return (<div>{linkComp}{appLocaleName(userContext,"CreateNew")}原始凭证</div>)
=======
      return (<div>{linkComp}{appLocaleName(userContext,"CreateNew")}{window.trans('original_voucher')}</div>)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
    }
	
	return (
      <div>
        <Card title={!this.props.hideTitle&&appLocaleName(userContext,"BasicInfo")} className={styles.card} bordered={false}>
          <Form >
          	<Row gutter={16}>
           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.title} {...formItemLayout}>
                  {getFieldDecorator('title', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="头衔" />
=======
                    <Input size="large"  placeHolder={fieldLabels.title} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.madeBy} {...formItemLayout}>
                  {getFieldDecorator('madeBy', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="由" />
=======
                    <Input size="large"  placeHolder={fieldLabels.madeBy} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.receivedBy} {...formItemLayout}>
                  {getFieldDecorator('receivedBy', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="受" />
=======
                    <Input size="large"  placeHolder={fieldLabels.receivedBy} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.voucherType} {...formItemLayout}>
                  {getFieldDecorator('voucherType', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="凭证类型" />
=======
                    <Input size="large"  placeHolder={fieldLabels.voucherType} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>


       
 
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.belongsTo} {...formItemLayout}>
                  {getFieldDecorator('belongsToId', {
                  	initialValue: tryinit('belongsTo'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('belongsTo')}
                    targetType={"belongsTo"} 
                    requestFunction={OriginalVoucherService.requestCandidateBelongsTo}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

           

<<<<<<< HEAD
=======
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.creation} {...formItemLayout}>
                  {getFieldDecorator('creationId', {
                  	initialValue: tryinit('creation'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('creation')}
                    targetType={"creation"} 
                    requestFunction={OriginalVoucherService.requestCandidateCreation}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.confirmation} {...formItemLayout}>
                  {getFieldDecorator('confirmationId', {
                  	initialValue: tryinit('confirmation'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('confirmation')}
                    targetType={"confirmation"} 
                    requestFunction={OriginalVoucherService.requestCandidateConfirmation}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.auditing} {...formItemLayout}>
                  {getFieldDecorator('auditingId', {
                  	initialValue: tryinit('auditing'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('auditing')}
                    targetType={"auditing"} 
                    requestFunction={OriginalVoucherService.requestCandidateAuditing}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

           

>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe


			 </Row>
          </Form>
        </Card>






       <Card title={<div>{appLocaleName(userContext,"Attachment")} <Popover title={appLocaleName(userContext,"ScanQRCodetoUploadfromSmartPhone")} content={<div><img src='./qrtest.png'/></div>}><Icon type="qrcode" ></Icon></Popover></div>} className={styles.card} bordered={false}>
          <Form >
            <Row gutter={16}>     
           

              <Col lg={6} md={12} sm={24}>
                <ImageComponent
<<<<<<< HEAD
                  buttonTitle="凭证图像"
=======
                  buttonTitle={fieldLabels.voucherImage}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  handlePreview={this.handlePreview}
                  handleChange={event => this.handleChange(event, 'voucherImage')}
                  fileList={convertedImagesValues.voucherImage}
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
}))(Form.create()(OriginalVoucherCreateFormBody))





