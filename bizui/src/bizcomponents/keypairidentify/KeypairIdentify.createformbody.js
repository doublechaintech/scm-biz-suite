import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import CandidateList from '../../components/CandidateList'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './KeypairIdentify.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import KeypairIdentifyBase from './KeypairIdentify.base'
import appLocaleName from '../../common/Locale.tool'
const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input
const {fieldLabels} = KeypairIdentifyBase
const testValues = {};
/*
const testValues = {
  keyTypeId: 'PKT000001',
  secUserId: 'SU000001',
  publicKey: '    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n',
}
*/

const imageKeys = [
]


class KeypairIdentifyCreateFormBody extends Component {
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
    const {KeypairIdentifyService} = GlobalComponents
    
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
      return (<div>{linkComp}{appLocaleName(userContext,"CreateNew")}{window.trans('keypair_identify')}</div>)
    }
	
	return (
      <div>
        <Card title={!this.props.hideTitle&&appLocaleName(userContext,"BasicInfo")} className={styles.card} bordered={false}>
          <Form >
          	<Row gutter={16}>
           


       
 
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.keyType} {...formItemLayout}>
                  {getFieldDecorator('keyTypeId', {
                  	initialValue: tryinit('keyType'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  
                  <CandidateList 
		                 disabled={!availableForEdit('keyType')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"assign"}
		                 listType={"keypair_identify"} 
		                 targetType={"public_key_type"} 
                 
                    requestFunction={KeypairIdentifyService.queryCandidates}  />
                  	
                  
                  
                  )}
                </Form.Item>
              </Col>

           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.secUser} {...formItemLayout}>
                  {getFieldDecorator('secUserId', {
                  	initialValue: tryinit('secUser'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  
                  <CandidateList 
		                 disabled={!availableForEdit('secUser')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"assign"}
		                 listType={"keypair_identify"} 
		                 targetType={"sec_user"} 
                 
                    requestFunction={KeypairIdentifyService.queryCandidates}  />
                  	
                  
                  
                  )}
                </Form.Item>
              </Col>

           



			 </Row>
          </Form>
        </Card>



        <Card title={fieldLabels.publicKey} className={styles.card} bordered={false}>
          <Form >
          	<Row gutter={16}>
              <Col lg={24} md={24} sm={24}>
                <Form.Item>
                  {getFieldDecorator('publicKey', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <TextArea rows={16} placeholder={appLocaleName(userContext,"PleaseInput")} />
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
}))(Form.create()(KeypairIdentifyCreateFormBody))





