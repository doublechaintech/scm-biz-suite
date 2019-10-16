import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch,Modal } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './PotentialCustomerContact.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import PotentialCustomerContactBase from './PotentialCustomerContact.base'
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
  name: '和连载客户的联系记录',
<<<<<<< HEAD
  contactDate: '2016-10-13',
=======
  contactDate: '2017-09-20',
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  contactMethod: '电话',
  description: '转化希望很大',
  potentialCustomerId: 'PC000001',
  cityPartnerId: 'CP000001',
  contactToId: 'PCCP000001',
}
*/


const imageKeys = [
]


class PotentialCustomerContactAssociateForm extends Component {
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
    const {PotentialCustomerContactService} = GlobalComponents
<<<<<<< HEAD
=======
    const userContext = null
    
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854


    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const {fieldLabels} = PotentialCustomerContactBase
    
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
                <Form.Item label={fieldLabels.name} {...formItemLayout}>
                  {getFieldDecorator('name', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入名称' }],
                  })(
                    <Input placeholder="请输入名称" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="名称" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.contactDate} {...formItemLayout}>
                  {getFieldDecorator('contactDate', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入接触日期' }],
                  })(
                    <DatePicker format="YYYY-MM-DD" placeholder="请输入接触日期" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <DatePicker size="large" format="YYYY-MM-DD" placeholder="接触日期" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.contactMethod} {...formItemLayout}>
                  {getFieldDecorator('contactMethod', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入接触法' }],
                  })(
                    <Input placeholder="请输入接触法" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="接触法" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.description} {...formItemLayout}>
                  {getFieldDecorator('description', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入描述' }],
                  })(
                    <Input placeholder="请输入描述" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="描述" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

            </Row>


       
        









       
            <Row gutter={16}>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.potentialCustomer} {...formItemLayout}>
                  {getFieldDecorator('potentialCustomerId', {
                  	initialValue: tryinit('potentialCustomer'),
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入潜在的客户' }],
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  })(
                <SelectObject 
                    disabled={!availableForEdit('potentialCustomer')}
                    targetType={"potentialCustomer"} 
                    requestFunction={PotentialCustomerContactService.requestCandidatePotentialCustomer}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.cityPartner} {...formItemLayout}>
                  {getFieldDecorator('cityPartnerId', {
                  	initialValue: tryinit('cityPartner'),
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入城市合伙人' }],
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  })(
                <SelectObject 
                    disabled={!availableForEdit('cityPartner')}
                    targetType={"cityPartner"} 
                    requestFunction={PotentialCustomerContactService.requestCandidateCityPartner}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.contactTo} {...formItemLayout}>
                  {getFieldDecorator('contactToId', {
                  	initialValue: tryinit('contactTo'),
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入接触' }],
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  })(
                <SelectObject 
                    disabled={!availableForEdit('contactTo')}
                    targetType={"contactTo"} 
                    requestFunction={PotentialCustomerContactService.requestCandidateContactTo}/>
  
                  )}
                </Form.Item>
              </Col>

            </Row>
         
       

			</Form>
			
			
			
			
        </Card>
        
        
        
        
      </Modal>)
    
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(PotentialCustomerContactAssociateForm))




