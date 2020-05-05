import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import CandidateList from '../../components/CandidateList'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './ProvinceCenterEmployee.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import ProvinceCenterEmployeeBase from './ProvinceCenterEmployee.base'
import appLocaleName from '../../common/Locale.tool'
const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input
const {fieldLabels} = ProvinceCenterEmployeeBase
const testValues = {};
/*
const testValues = {
  name: '刘强',
  mobile: '13999998888',
  email: 'wangdehong@yatang.cn',
  founded: '2017-10-09',
  departmentId: 'PCD000001',
  provinceCenterId: 'RSPC000001',
}
*/

const imageKeys = [
]


class ProvinceCenterEmployeeCreateFormBody extends Component {
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
    const {ProvinceCenterEmployeeService} = GlobalComponents
    
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
      return (<div>{linkComp}{appLocaleName(userContext,"CreateNew")}{window.trans('province_center_employee')}</div>)
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
                    <Input size="large"  placeHolder={fieldLabels.name} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.mobile} {...formItemLayout}>
                  {getFieldDecorator('mobile', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large"  placeHolder={fieldLabels.mobile} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.email} {...formItemLayout}>
                  {getFieldDecorator('email', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large"  placeHolder={fieldLabels.email} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.founded} {...formItemLayout}>
                  {getFieldDecorator('founded', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <DatePicker size="large" format="YYYY-MM-DD"  placeHolder={fieldLabels.founded}/>
                  )}
                </Form.Item>
              </Col>


       
 
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.department} {...formItemLayout}>
                  {getFieldDecorator('departmentId', {
                  	initialValue: tryinit('department'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  
                  <CandidateList 
		                 disabled={!availableForEdit('department')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"assign"}
		                 listType={"province_center_employee"} 
		                 targetType={"province_center_department"} 
                 
                    requestFunction={ProvinceCenterEmployeeService.queryCandidates}  />
                  	
                  
                  
                  )}
                </Form.Item>
              </Col>

           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.provinceCenter} {...formItemLayout}>
                  {getFieldDecorator('provinceCenterId', {
                  	initialValue: tryinit('provinceCenter'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  
                  <CandidateList 
		                 disabled={!availableForEdit('provinceCenter')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"assign"}
		                 listType={"province_center_employee"} 
		                 targetType={"retail_store_province_center"} 
                 
                    requestFunction={ProvinceCenterEmployeeService.queryCandidates}  />
                  	
                  
                  
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
}))(Form.create()(ProvinceCenterEmployeeCreateFormBody))





