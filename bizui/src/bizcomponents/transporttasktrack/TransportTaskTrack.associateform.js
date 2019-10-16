import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch,Modal } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './TransportTaskTrack.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import TransportTaskTrackBase from './TransportTaskTrack.base'
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
<<<<<<< HEAD
  trackTime: '2016-09-13',
  latitude: '31.584733757333822',
  longitude: '105.79507235739935',
=======
  trackTime: '2019-09-20',
  latitude: '32.10511921320399',
  longitude: '103.63709211400734',
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  movementId: 'TT000001',
}
*/


const imageKeys = [
]


class TransportTaskTrackAssociateForm extends Component {
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
    const {TransportTaskTrackService} = GlobalComponents
<<<<<<< HEAD
=======
    const userContext = null
    
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854


    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const {fieldLabels} = TransportTaskTrackBase
    
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
                <Form.Item label={fieldLabels.trackTime} {...formItemLayout}>
                  {getFieldDecorator('trackTime', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入跟踪时间' }],
                  })(
                    <DatePicker format="YYYY-MM-DD" placeholder="请输入跟踪时间" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <DatePicker size="large" format="YYYY-MM-DD" placeholder="跟踪时间" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.latitude} {...formItemLayout}>
                  {getFieldDecorator('latitude', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入纬度' }],
                  })(
                    <Input placeholder="请输入纬度" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="纬度" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.longitude} {...formItemLayout}>
                  {getFieldDecorator('longitude', {
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入经度' }],
                  })(
                    <Input placeholder="请输入经度" />
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="经度" />
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  )}
                </Form.Item>
              </Col>

            </Row>


       
        









       
            <Row gutter={16}>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.movement} {...formItemLayout}>
                  {getFieldDecorator('movementId', {
                  	initialValue: tryinit('movement'),
<<<<<<< HEAD
                    rules: [{ required: true, message: '请输入运动' }],
=======
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
                  })(
                <SelectObject 
                    disabled={!availableForEdit('movement')}
                    targetType={"movement"} 
                    requestFunction={TransportTaskTrackService.requestCandidateMovement}/>
  
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
}))(Form.create()(TransportTaskTrackAssociateForm))




