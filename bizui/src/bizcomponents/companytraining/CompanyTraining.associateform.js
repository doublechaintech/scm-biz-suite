import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch,Modal } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './CompanyTraining.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import CompanyTrainingBase from './CompanyTraining.base'
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
  title: '入职培训',
<<<<<<< HEAD
  timeStart: '2016-04-29',
=======
  timeStart: '2017-09-06',
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  durationHours: '3',
  companyId: 'RSCC000001',
  instructorId: 'I000001',
  trainingCourseTypeId: 'TCT000001',
}
*/


const imageKeys = [
]


class CompanyTrainingAssociateForm extends Component {
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
    const {CompanyTrainingService} = GlobalComponents
<<<<<<< HEAD
=======
    const userContext = null
    
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
 const {EmployeeCompanyTrainingModalTable} = GlobalComponents;


    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const {fieldLabels} = CompanyTrainingBase
    
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
                <Form.Item label={fieldLabels.title} {...formItemLayout}>
                  {getFieldDecorator('title', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入头衔' }],
                  })(
                    <Input placeholder="请输入头衔" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="头衔" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.timeStart} {...formItemLayout}>
                  {getFieldDecorator('timeStart', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入时间开始' }],
                  })(
                    <DatePicker format="YYYY-MM-DD" placeholder="请输入时间开始" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <DatePicker size="large" format="YYYY-MM-DD" placeholder="时间开始" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.durationHours} {...formItemLayout}>
                  {getFieldDecorator('durationHours', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入持续时间' }],
                  })(
                    <Input placeholder="请输入持续时间" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="持续时间" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

            </Row>


       
        









       
            <Row gutter={16}>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.company} {...formItemLayout}>
                  {getFieldDecorator('companyId', {
                  	initialValue: tryinit('company'),
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入公司' }],
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  })(
                <SelectObject 
                    disabled={!availableForEdit('company')}
                    targetType={"company"} 
                    requestFunction={CompanyTrainingService.requestCandidateCompany}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.instructor} {...formItemLayout}>
                  {getFieldDecorator('instructorId', {
                  	initialValue: tryinit('instructor'),
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入讲师' }],
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  })(
                <SelectObject 
                    disabled={!availableForEdit('instructor')}
                    targetType={"instructor"} 
                    requestFunction={CompanyTrainingService.requestCandidateInstructor}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.trainingCourseType} {...formItemLayout}>
                  {getFieldDecorator('trainingCourseTypeId', {
                  	initialValue: tryinit('trainingCourseType'),
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入培训课程类型' }],
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  })(
                <SelectObject 
                    disabled={!availableForEdit('trainingCourseType')}
                    targetType={"trainingCourseType"} 
                    requestFunction={CompanyTrainingService.requestCandidateTrainingCourseType}/>
  
                  )}
                </Form.Item>
              </Col>

            </Row>
         
       

			</Form>
			
			
			
			
        </Card>
        
	<EmployeeCompanyTrainingModalTable data={data.employeeCompanyTrainingList} owner={owner} />
        
        
        
      </Modal>)
    
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(CompanyTrainingAssociateForm))




