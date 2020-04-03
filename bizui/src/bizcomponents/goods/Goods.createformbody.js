import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import SelectObject from '../../components/SelectObject'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './Goods.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import GoodsBase from './Goods.base'
import appLocaleName from '../../common/Locale.tool'
const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input
const {fieldLabels} = GoodsBase
const testValues = {};
/*
const testValues = {
  name: '可口可乐',
  rfid: 'RF99192',
  uom: '件',
  maxPackage: '9',
  expireTime: '2017-05-24',
  skuId: 'S000001',
  receivingSpaceId: 'RS000001',
  goodsAllocationId: 'GA000001',
  smartPalletId: 'SP000001',
  shippingSpaceId: 'SS000001',
  transportTaskId: 'TT000001',
  retailStoreId: 'RS000001',
  bizOrderId: 'SO000001',
  retailStoreOrderId: 'RSO000001',
}
*/

const imageKeys = [
]


class GoodsCreateFormBody extends Component {
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
    
    const {GoodsService} = GlobalComponents
    
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
      return (<div>{linkComp}{appLocaleName(userContext,"CreateNew")}{window.trans('goods')}</div>)
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
                <Form.Item label={fieldLabels.rfid} {...formItemLayout}>
                  {getFieldDecorator('rfid', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large"  placeHolder={fieldLabels.rfid} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.uom} {...formItemLayout}>
                  {getFieldDecorator('uom', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large"  placeHolder={fieldLabels.uom} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.maxPackage} {...formItemLayout}>
                  {getFieldDecorator('maxPackage', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large"  placeHolder={fieldLabels.maxPackage} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.expireTime} {...formItemLayout}>
                  {getFieldDecorator('expireTime', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <DatePicker size="large" format="YYYY-MM-DD"  placeHolder={fieldLabels.expireTime}/>
                  )}
                </Form.Item>
              </Col>


       
 
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.sku} {...formItemLayout}>
                  {getFieldDecorator('skuId', {
                  	initialValue: tryinit('sku'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('sku')}
                    targetType={"sku"} 
                    requestFunction={GoodsService.requestCandidateSku}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.receivingSpace} {...formItemLayout}>
                  {getFieldDecorator('receivingSpaceId', {
                  	initialValue: tryinit('receivingSpace'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('receivingSpace')}
                    targetType={"receivingSpace"} 
                    requestFunction={GoodsService.requestCandidateReceivingSpace}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.goodsAllocation} {...formItemLayout}>
                  {getFieldDecorator('goodsAllocationId', {
                  	initialValue: tryinit('goodsAllocation'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('goodsAllocation')}
                    targetType={"goodsAllocation"} 
                    requestFunction={GoodsService.requestCandidateGoodsAllocation}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.smartPallet} {...formItemLayout}>
                  {getFieldDecorator('smartPalletId', {
                  	initialValue: tryinit('smartPallet'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('smartPallet')}
                    targetType={"smartPallet"} 
                    requestFunction={GoodsService.requestCandidateSmartPallet}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.shippingSpace} {...formItemLayout}>
                  {getFieldDecorator('shippingSpaceId', {
                  	initialValue: tryinit('shippingSpace'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('shippingSpace')}
                    targetType={"shippingSpace"} 
                    requestFunction={GoodsService.requestCandidateShippingSpace}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.transportTask} {...formItemLayout}>
                  {getFieldDecorator('transportTaskId', {
                  	initialValue: tryinit('transportTask'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('transportTask')}
                    targetType={"transportTask"} 
                    requestFunction={GoodsService.requestCandidateTransportTask}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.retailStore} {...formItemLayout}>
                  {getFieldDecorator('retailStoreId', {
                  	initialValue: tryinit('retailStore'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('retailStore')}
                    targetType={"retailStore"} 
                    requestFunction={GoodsService.requestCandidateRetailStore}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.bizOrder} {...formItemLayout}>
                  {getFieldDecorator('bizOrderId', {
                  	initialValue: tryinit('bizOrder'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('bizOrder')}
                    targetType={"bizOrder"} 
                    requestFunction={GoodsService.requestCandidateBizOrder}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.retailStoreOrder} {...formItemLayout}>
                  {getFieldDecorator('retailStoreOrderId', {
                  	initialValue: tryinit('retailStoreOrder'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('retailStoreOrder')}
                    targetType={"retailStoreOrder"} 
                    requestFunction={GoodsService.requestCandidateRetailStoreOrder}/>
                  
                 
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
}))(Form.create()(GoodsCreateFormBody))





