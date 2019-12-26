import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import SelectObject from '../../components/SelectObject'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './TransportTruck.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import TransportTruckBase from './TransportTruck.base'
import appLocaleName from '../../common/Locale.tool'
const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input
<<<<<<< HEAD

=======
const {fieldLabels} = TransportTruckBase
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const testValues = {};
/*
const testValues = {
  name: '运货卡车',
  plateNumber: '川AK5',
<<<<<<< HEAD
  contactNumber: '02887654321',
  vehicleLicenseNumber: 'VL9198',
  engineNumber: 'EN00102',
  makeDate: '2019-08-31',
=======
  contactNumber: '2797418730',
  vehicleLicenseNumber: 'VL9198',
  engineNumber: 'EN00102',
  makeDate: '2018-08-06',
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  mileage: '100万公里',
  bodyColor: '红色',
  ownerId: 'TF000001',
}
*/

const imageKeys = [
]


class TransportTruckCreateFormBody extends Component {
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
    const {fieldLabels} = TransportTruckBase
=======
    
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
    const {TransportTruckService} = GlobalComponents
    
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
      return (<div>{linkComp}{appLocaleName(userContext,"CreateNew")}运输车</div>)
=======
      return (<div>{linkComp}{appLocaleName(userContext,"CreateNew")}{window.trans('transport_truck')}</div>)
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
                <Form.Item label={fieldLabels.plateNumber} {...formItemLayout}>
                  {getFieldDecorator('plateNumber', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="车牌号码" />
=======
                    <Input size="large"  placeHolder={fieldLabels.plateNumber} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.contactNumber} {...formItemLayout}>
                  {getFieldDecorator('contactNumber', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="联系电话" />
=======
                    <Input size="large"  placeHolder={fieldLabels.contactNumber} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.vehicleLicenseNumber} {...formItemLayout}>
                  {getFieldDecorator('vehicleLicenseNumber', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="汽车牌照号码" />
=======
                    <Input size="large"  placeHolder={fieldLabels.vehicleLicenseNumber} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.engineNumber} {...formItemLayout}>
                  {getFieldDecorator('engineNumber', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="发动机号" />
=======
                    <Input size="large"  placeHolder={fieldLabels.engineNumber} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.makeDate} {...formItemLayout}>
                  {getFieldDecorator('makeDate', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <DatePicker size="large" format="YYYY-MM-DD" placeholder="制造日期" />
=======
                    <DatePicker size="large" format="YYYY-MM-DD"  placeHolder={fieldLabels.makeDate}/>
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.mileage} {...formItemLayout}>
                  {getFieldDecorator('mileage', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="里程" />
=======
                    <Input size="large"  placeHolder={fieldLabels.mileage} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.bodyColor} {...formItemLayout}>
                  {getFieldDecorator('bodyColor', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="车身颜色" />
=======
                    <Input size="large"  placeHolder={fieldLabels.bodyColor} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>


       
 
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.owner} {...formItemLayout}>
                  {getFieldDecorator('ownerId', {
                  	initialValue: tryinit('owner'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('owner')}
                    targetType={"owner"} 
                    requestFunction={TransportTruckService.requestCandidateOwner}/>
                  
                 
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
}))(Form.create()(TransportTruckCreateFormBody))





