import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch,Modal } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './ReportLine.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import ReportLineBase from './ReportLine.base'
import SelectObject from '../../components/SelectObject'


const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input

const testValues = {};
/*
const testValues = {
  name: '2017年',
  january: '119375648.00',
  february: '100253344.00',
  march: '11138936.00',
  april: '13020443.00',
  may: '87859480.00',
  june: '90931376.00',
  july: '115397384.00',
  august: '89434728.00',
  september: '121831928.00',
  october: '88505328.00',
  november: '99682640.00',
  december: '92239424.00',
  ownerId: 'R000001',
}
*/


const imageKeys = [
]


class ReportLineAssociateForm extends Component {
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
    const {ReportLineService} = GlobalComponents


    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const {fieldLabels} = ReportLineBase
    
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
    
    return (
 <Modal
          title="创建新的支付"
          visible={visible}
          onOk={onCancel}
          onCancel={onCancel}
          width={920}
          style={{ top: 40}}
        >
        <Card title="基础信息"  className={styles.card} style={{ backgroundColor:"#eee" }}>
          <Form >
            <Row gutter={16}>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.name} {...formItemLayout}>
                  {getFieldDecorator('name', {
                    rules: [{ required: true, message: '请输入名称' }],
                  })(
                    <Input placeholder="请输入名称" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.january} {...formItemLayout}>
                  {getFieldDecorator('january', {
                    rules: [{ required: true, message: '请输入一月' }],
                  })(
                    <Input placeholder="请输入一月" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.february} {...formItemLayout}>
                  {getFieldDecorator('february', {
                    rules: [{ required: true, message: '请输入二月' }],
                  })(
                    <Input placeholder="请输入二月" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.march} {...formItemLayout}>
                  {getFieldDecorator('march', {
                    rules: [{ required: true, message: '请输入三月' }],
                  })(
                    <Input placeholder="请输入三月" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.april} {...formItemLayout}>
                  {getFieldDecorator('april', {
                    rules: [{ required: true, message: '请输入四月' }],
                  })(
                    <Input placeholder="请输入四月" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.may} {...formItemLayout}>
                  {getFieldDecorator('may', {
                    rules: [{ required: true, message: '请输入五月' }],
                  })(
                    <Input placeholder="请输入五月" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.june} {...formItemLayout}>
                  {getFieldDecorator('june', {
                    rules: [{ required: true, message: '请输入六月' }],
                  })(
                    <Input placeholder="请输入六月" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.july} {...formItemLayout}>
                  {getFieldDecorator('july', {
                    rules: [{ required: true, message: '请输入七月' }],
                  })(
                    <Input placeholder="请输入七月" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.august} {...formItemLayout}>
                  {getFieldDecorator('august', {
                    rules: [{ required: true, message: '请输入八月' }],
                  })(
                    <Input placeholder="请输入八月" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.september} {...formItemLayout}>
                  {getFieldDecorator('september', {
                    rules: [{ required: true, message: '请输入九月' }],
                  })(
                    <Input placeholder="请输入九月" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.october} {...formItemLayout}>
                  {getFieldDecorator('october', {
                    rules: [{ required: true, message: '请输入十月' }],
                  })(
                    <Input placeholder="请输入十月" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.november} {...formItemLayout}>
                  {getFieldDecorator('november', {
                    rules: [{ required: true, message: '请输入十一月' }],
                  })(
                    <Input placeholder="请输入十一月" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.december} {...formItemLayout}>
                  {getFieldDecorator('december', {
                    rules: [{ required: true, message: '请输入十二月' }],
                  })(
                    <Input placeholder="请输入十二月" />
                  )}
                </Form.Item>
              </Col>

            </Row>


       
        









       
            <Row gutter={16}>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.owner} {...formItemLayout}>
                  {getFieldDecorator('ownerId', {
                  	initialValue: tryinit('owner'),
                    rules: [{ required: true, message: '请输入业主' }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('owner')}
                    targetType={"owner"} 
                    requestFunction={ReportLineService.requestCandidateOwner}/>
  
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
}))(Form.create()(ReportLineAssociateForm))




