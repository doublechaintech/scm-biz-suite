import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import SelectObject from '../../components/SelectObject'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './StorageSpace.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import StorageSpaceBase from './StorageSpace.base'
import appLocaleName from '../../common/Locale.tool'
const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input
<<<<<<< HEAD

=======
const {fieldLabels} = StorageSpaceBase
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const testValues = {};
/*
const testValues = {
  location: '成都龙泉驿飞鹤路20号存货区',
<<<<<<< HEAD
  contactNumber: '02887654321',
  totalArea: '1876平方米',
  latitude: '41.52547554642271',
  longitude: '131.52565174473716',
=======
  contactNumber: '2252397530',
  totalArea: '1876平方米',
  latitude: '42.6424382361263',
  longitude: '130.83779528713052',
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  warehouseId: 'W000001',
}
*/

const imageKeys = [
]


class StorageSpaceCreateFormBody extends Component {
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
    const {fieldLabels} = StorageSpaceBase
=======
    
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
    const {StorageSpaceService} = GlobalComponents
    
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
      return (<div>{linkComp}{appLocaleName(userContext,"CreateNew")}存货区</div>)
=======
      return (<div>{linkComp}{appLocaleName(userContext,"CreateNew")}{window.trans('storage_space')}</div>)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
    }
	
	return (
      <div>
        <Card title={!this.props.hideTitle&&appLocaleName(userContext,"BasicInfo")} className={styles.card} bordered={false}>
          <Form >
          	<Row gutter={16}>
           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.location} {...formItemLayout}>
                  {getFieldDecorator('location', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="位置" />
=======
                    <Input size="large"  placeHolder={fieldLabels.location} />
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
                <Form.Item label={fieldLabels.totalArea} {...formItemLayout}>
                  {getFieldDecorator('totalArea', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="总面积" />
=======
                    <Input size="large"  placeHolder={fieldLabels.totalArea} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.latitude} {...formItemLayout}>
                  {getFieldDecorator('latitude', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="纬度" />
=======
                    <Input size="large"  placeHolder={fieldLabels.latitude} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.longitude} {...formItemLayout}>
                  {getFieldDecorator('longitude', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="经度" />
=======
                    <Input size="large"  placeHolder={fieldLabels.longitude} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>


       
 
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.warehouse} {...formItemLayout}>
                  {getFieldDecorator('warehouseId', {
                  	initialValue: tryinit('warehouse'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('warehouse')}
                    targetType={"warehouse"} 
                    requestFunction={StorageSpaceService.requestCandidateWarehouse}/>
                  
                 
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
}))(Form.create()(StorageSpaceCreateFormBody))





