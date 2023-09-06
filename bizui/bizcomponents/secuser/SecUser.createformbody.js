import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import CandidateList from '../../components/CandidateList'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './SecUser.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import SecUserBase from './SecUser.base'
import appLocaleName from '../../common/Locale.tool'
const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input
const {fieldLabels} = SecUserBase
const testValues = {};
import PrivateImageEditInput from '../../components/PrivateImageEditInput'
import RichEditInput from '../../components/RichEditInput'
import SmallTextInput from '../../components/SmallTextInput'

const imageKeys = [
]


class SecUserCreateFormBody extends Component {
  state = {
    previewVisible: false,
    previewImage: '',
    convertedImagesValues: {},
  }

  componentDidMount() {



    const {initValue} = this.props
    if(!initValue || initValue === null){
      return
    }

    const formValue = SecUserBase.unpackObjectToFormValues(initValue)
    this.props.form.setFieldsValue(formValue);




  }

  handlePreview = (file) => {
    console.log('preview file', file)
    this.setState({
      previewImage: file.url || file.thumbUrl,
      previewVisible: true,
    })
  }




  handleImageChange = (event, source) => {

    const {handleImageChange} = this.props
    if(!handleImageChange){
      console.log('FAILED GET PROCESS FUNCTION TO HANDLE IMAGE VALUE CHANGE', source)
      return
    }

    const { convertedImagesValues } = this.state
    const { fileList } = event
    convertedImagesValues[source] = fileList
    this.setState({ convertedImagesValues })
    handleImageChange(event, source)


  }


  render() {
    const { form, dispatch, submitting, role } = this.props
    const { convertedImagesValues } = this.state
	const userContext = null
    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const { owner } = this.props
    const {SecUserService} = GlobalComponents

    const capFirstChar = (value)=>{
    	//const upper = value.replace(/^\w/, c => c.toUpperCase());
  		const upper = value.charAt(0).toUpperCase() + value.substr(1);
  		return upper
  	}
    

    const tryinit  = (fieldName) => {

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
      return (<div>{linkComp}{appLocaleName(userContext,"CreateNew")}{window.trans('sec_user')}</div>)
    }

	return (
      <div>
        <Card title={!this.props.hideTitle&&appLocaleName(userContext,"BasicInfo")} className={styles.card} bordered={false}>
          <Form >
          	<Row gutter={16}>


              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.login} {...formItemLayout}>
                  {getFieldDecorator('login', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <SmallTextInput minLength={0} maxLength={256} size="large"  placeholder={fieldLabels.login} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.mobile} {...formItemLayout}>
                  {getFieldDecorator('mobile', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <SmallTextInput minLength={0} maxLength={11} size="large"  placeholder={fieldLabels.mobile} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.email} {...formItemLayout}>
                  {getFieldDecorator('email', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <SmallTextInput minLength={0} maxLength={256} size="large"  placeholder={fieldLabels.email} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.pwd} {...formItemLayout}>
                  {getFieldDecorator('pwd', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <SmallTextInput minLength={3} maxLength={28} size="large"  placeholder={fieldLabels.pwd} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.weixinOpenid} {...formItemLayout}>
                  {getFieldDecorator('weixinOpenid', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <SmallTextInput minLength={0} maxLength={128} size="large"  placeholder={fieldLabels.weixinOpenid} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.weixinAppid} {...formItemLayout}>
                  {getFieldDecorator('weixinAppid', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <SmallTextInput minLength={0} maxLength={128} size="large"  placeholder={fieldLabels.weixinAppid} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.accessToken} {...formItemLayout}>
                  {getFieldDecorator('accessToken', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <SmallTextInput minLength={0} maxLength={128} size="large"  placeholder={fieldLabels.accessToken} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.verificationCode} {...formItemLayout}>
                  {getFieldDecorator('verificationCode', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <SmallTextInput minLength={0} maxLength={9999999} size="large"  placeholder={fieldLabels.verificationCode} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.verificationCodeExpire} {...formItemLayout}>
                  {getFieldDecorator('verificationCodeExpire', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <DatePicker size="large" showTime format="YYYY-MM-DD HH:mm" minuteStep={5}  placeholder={fieldLabels.verificationCodeExpire} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.lastLoginTime} {...formItemLayout}>
                  {getFieldDecorator('lastLoginTime', {
                    rules: [{ required: false, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <DatePicker size="large" showTime format="YYYY-MM-DD HH:mm" minuteStep={5}  placeholder={fieldLabels.lastLoginTime} />
                  )}
                </Form.Item>
              </Col>



 
              <Col lg={24} md={24} sm={24} style={{"display":"none"}}>
                <Form.Item label={fieldLabels.domain} {...formItemLayout}>
                  {getFieldDecorator('domainId', {
                  	initialValue: tryinit('domain'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(


                  <CandidateList
		                 disabled={!availableForEdit('domain')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"assign"}
		                 listType={"sec_user"}
		                 targetType={"user_domain"}

                    requestFunction={SecUserService.queryCandidates}  />



                  )}
                </Form.Item>
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
}))(Form.create()(SecUserCreateFormBody))





