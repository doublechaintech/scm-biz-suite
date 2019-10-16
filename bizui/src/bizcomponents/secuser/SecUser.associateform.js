import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch,Modal } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './SecUser.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import SecUserBase from './SecUser.base'
import SelectObject from '../../components/SelectObject'
<<<<<<< HEAD

=======
import appLocaleName from '../../common/Locale.tool'
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854

const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input

const testValues = {};
/*
const testValues = {
  login: 'login',
  mobile: '13900000001',
  email: '',
  pwd: 'C183EC89F92A462CF45B95504792EC4625E847C90536EEFE512D1C9DB8602E95',
<<<<<<< HEAD
  verificationCode: '0',
  verificationCodeExpire: '2019-01-02 04:42:16',
  lastLoginTime: '2019-01-06 11:04:32',
=======
  weixinOpenid: 'wx123456789abcdefghijklmn',
  weixinAppid: 'wxapp12098410239840',
  accessToken: 'jwt_token_12345678',
  verificationCode: '0',
  verificationCodeExpire: '2019-09-19 08:22:00',
  lastLoginTime: '2019-09-13 00:35:07',
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  domainId: 'UD000001',
}
*/


const imageKeys = [
]


class SecUserAssociateForm extends Component {
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
	const { form, dispatch, submitting, role,data,owner,toggleAssociatePaymentVisible,visible,onCancel, onCreate } = this.props
    const { convertedImagesValues } = this.state
    const {SecUserService} = GlobalComponents
<<<<<<< HEAD
=======
    const userContext = null
    
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
 const {UserAppModalTable} = GlobalComponents;
 const {LoginHistoryModalTable} = GlobalComponents;


    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const {fieldLabels} = SecUserBase
    
    const capFirstChar = (value)=>{
    	//const upper = value.replace(/^\w/, c => c.toUpperCase());
  		const upper = value.charAt(0).toUpperCase() + value.substr(1);
  		return upper
  	}
    
    
    

    
    
    const tryinit  = (fieldName, candidates) => {
      
      if(candidates&&candidates.length==1){
          return candidates[0].id
      }
      const { owner } = this.props
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return null
      }
      return owner.id
    }
    
    const availableForEdit= (fieldName) =>{
      const { owner } = this.props
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
      labelCol: { span: 14 },
      wrapperCol: { span: 4 },
    }
<<<<<<< HEAD
    
    return (
 <Modal
          title="创建新的支付"
=======
   
    return (
 <Modal
          title={appLocaleName(userContext,"CreateNew")}
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
          visible={visible}
          onOk={onCancel}
          onCancel={onCancel}
          width={920}
          style={{ top: 40}}
        >
<<<<<<< HEAD
        <Card title="基础信息"  className={styles.card} style={{ backgroundColor:"#eee" }}>
=======
        <Card title={appLocaleName(userContext,"BasicInfo")}  className={styles.card} style={{ backgroundColor:"#eee" }}>
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
          <Form >
            <Row gutter={16}>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.login} {...formItemLayout}>
                  {getFieldDecorator('login', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入登录' }],
                  })(
                    <Input placeholder="请输入登录" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="登录" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.mobile} {...formItemLayout}>
                  {getFieldDecorator('mobile', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入手机' }],
                  })(
                    <Input placeholder="请输入手机" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="手机号码" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.email} {...formItemLayout}>
                  {getFieldDecorator('email', {
<<<<<<< HEAD
                    rules: [{ required: false, message: '请输入电子邮件' }],
                  })(
                    <Input placeholder="请输入电子邮件" />
=======
                    rules: [{ required: false, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="电子邮件" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.pwd} {...formItemLayout}>
                  {getFieldDecorator('pwd', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入PWD' }],
                  })(
                    <Input placeholder="请输入PWD" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="密码" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.weixinOpenid} {...formItemLayout}>
                  {getFieldDecorator('weixinOpenid', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="微信openid" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.weixinAppid} {...formItemLayout}>
                  {getFieldDecorator('weixinAppid', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="微信Appid" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.accessToken} {...formItemLayout}>
                  {getFieldDecorator('accessToken', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="访问令牌" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.verificationCode} {...formItemLayout}>
                  {getFieldDecorator('verificationCode', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入验证码' }],
                  })(
                    <Input placeholder="请输入验证码" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="验证码" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.verificationCodeExpire} {...formItemLayout}>
                  {getFieldDecorator('verificationCodeExpire', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入验证码过期' }],
                  })(
                    <DatePicker showTime format="YYYY-MM-DD HH:mm" minuteStep={5} placeholder="请输入验证码过期" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <DatePicker size="large" showTime format="YYYY-MM-DD HH:mm" minuteStep={5} placeholder="验证码过期" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.lastLoginTime} {...formItemLayout}>
                  {getFieldDecorator('lastLoginTime', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入最后登录时间' }],
                  })(
                    <DatePicker showTime format="YYYY-MM-DD HH:mm" minuteStep={5} placeholder="请输入最后登录时间" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <DatePicker size="large" showTime format="YYYY-MM-DD HH:mm" minuteStep={5} placeholder="最后登录时间" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

            </Row>


       
        









       
            <Row gutter={16}>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.domain} {...formItemLayout}>
                  {getFieldDecorator('domainId', {
                  	initialValue: tryinit('domain'),
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入域' }],
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  })(
                <SelectObject 
                    disabled={!availableForEdit('domain')}
                    targetType={"domain"} 
                    requestFunction={SecUserService.requestCandidateDomain}/>
  
                  )}
                </Form.Item>
              </Col>

            </Row>
         
       

			</Form>
			
			
			
			
        </Card>
        
	<UserAppModalTable data={data.userAppList} owner={owner} />
	<LoginHistoryModalTable data={data.loginHistoryList} owner={owner} />
        
        
        
      </Modal>)
    
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(SecUserAssociateForm))




