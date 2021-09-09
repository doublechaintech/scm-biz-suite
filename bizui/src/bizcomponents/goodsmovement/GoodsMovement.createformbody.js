import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import CandidateList from '../../components/CandidateList'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './GoodsMovement.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import GoodsMovementBase from './GoodsMovement.base'
import appLocaleName from '../../common/Locale.tool'
const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input
const {fieldLabels} = GoodsMovementBase
const testValues = {};
import PrivateImageEditInput from '../../components/PrivateImageEditInput'
import RichEditInput from '../../components/RichEditInput'
import SmallTextInput from '../../components/SmallTextInput'

const imageKeys = [
]


class GoodsMovementCreateFormBody extends Component {
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

    const formValue = GoodsMovementBase.unpackObjectToFormValues(initValue)
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
    const {GoodsMovementService} = GlobalComponents

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
      return (<div>{linkComp}{appLocaleName(userContext,"CreateNew")}{window.trans('goods_movement')}</div>)
    }

	return (
      <div>
        <Card title={!this.props.hideTitle&&appLocaleName(userContext,"BasicInfo")} className={styles.card} bordered={false}>
          <Form >
          	<Row gutter={16}>


              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.moveTime} {...formItemLayout}>
                  {getFieldDecorator('moveTime', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <DatePicker size="large" showTime format="YYYY-MM-DD HH:mm" minuteStep={5}  placeholder={fieldLabels.moveTime} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.facility} {...formItemLayout}>
                  {getFieldDecorator('facility', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <SmallTextInput minLength={1} maxLength={16} size="large"  placeholder={fieldLabels.facility} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.facilityId} {...formItemLayout}>
                  {getFieldDecorator('facilityId', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <SmallTextInput minLength={1} maxLength={16} size="large"  placeholder={fieldLabels.facilityId} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.fromIp} {...formItemLayout}>
                  {getFieldDecorator('fromIp', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <SmallTextInput minLength={4} maxLength={48} size="large"  placeholder={fieldLabels.fromIp} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.sessionId} {...formItemLayout}>
                  {getFieldDecorator('sessionId', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <SmallTextInput minLength={8} maxLength={124} size="large"  placeholder={fieldLabels.sessionId} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.latitude} {...formItemLayout}>
                  {getFieldDecorator('latitude', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <SmallTextInput minLength={-90.0} maxLength={90.0} size="large"  placeholder={fieldLabels.latitude} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.longitude} {...formItemLayout}>
                  {getFieldDecorator('longitude', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <SmallTextInput minLength={-180.0} maxLength={180.0} size="large"  placeholder={fieldLabels.longitude} />
                  )}
                </Form.Item>
              </Col>



 
              <Col lg={24} md={24} sm={24} >
                <Form.Item label={fieldLabels.goods} {...formItemLayout}>
                  {getFieldDecorator('goodsId', {
                  	initialValue: tryinit('goods'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(


                  <CandidateList
		                 disabled={!availableForEdit('goods')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"assign"}
		                 listType={"goods_movement"}
		                 targetType={"goods"}

                    requestFunction={GoodsMovementService.queryCandidates}  />



                  )}
                </Form.Item>
              </Col>





			 </Row>
          </Form>
        </Card>



        <Card title={fieldLabels.userAgent} className={styles.card} bordered={false}>
          <Form >
          	<Row gutter={16}>
              <Col lg={4} md={4} sm={4}></Col>
              <Col lg={16} md={16} sm={16}>
                <Form.Item>
                  {getFieldDecorator('userAgent', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <TextArea rows={8} placeholder={appLocaleName(userContext,"PleaseInput")} />
                  )}
                </Form.Item>
              </Col>
              <Col lg={4} md={4} sm={4}></Col>

          </Row>
          </Form>
        </Card>







       </div>
    )
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(GoodsMovementCreateFormBody))





