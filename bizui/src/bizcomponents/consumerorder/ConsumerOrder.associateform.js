import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch,Modal } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './ConsumerOrder.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import ConsumerOrderBase from './ConsumerOrder.base'
import SelectObject from '../../components/SelectObject'


const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input

const testValues = {};
/*
const testValues = {
  title: '消费订单',
  consumerId: 'RSM000001',
  storeId: 'RS000001',
}
*/


const imageKeys = [
]


class ConsumerOrderAssociateForm extends Component {
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
    const {ConsumerOrderService} = GlobalComponents
 const {ConsumerOrderLineItemModalTable} = GlobalComponents;
 const {ConsumerOrderShippingGroupModalTable} = GlobalComponents;
 const {ConsumerOrderPaymentGroupModalTable} = GlobalComponents;
 const {ConsumerOrderPriceAdjustmentModalTable} = GlobalComponents;
 const {RetailStoreMemberGiftCardConsumeRecordModalTable} = GlobalComponents;


    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const {fieldLabels} = ConsumerOrderBase
    
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
                <Form.Item label={fieldLabels.title} {...formItemLayout}>
                  {getFieldDecorator('title', {
                    rules: [{ required: true, message: '请输入头衔' }],
                  })(
                    <Input placeholder="请输入头衔" />
                  )}
                </Form.Item>
              </Col>

            </Row>


       
        









       
            <Row gutter={16}>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.consumer} {...formItemLayout}>
                  {getFieldDecorator('consumerId', {
                  	initialValue: tryinit('consumer'),
                    rules: [{ required: true, message: '请输入消费者' }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('consumer')}
                    targetType={"consumer"} 
                    requestFunction={ConsumerOrderService.requestCandidateConsumer}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.store} {...formItemLayout}>
                  {getFieldDecorator('storeId', {
                  	initialValue: tryinit('store'),
                    rules: [{ required: true, message: '请输入商场' }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('store')}
                    targetType={"store"} 
                    requestFunction={ConsumerOrderService.requestCandidateStore}/>
  
                  )}
                </Form.Item>
              </Col>

            </Row>
         
       

			</Form>
			
			
			
			
        </Card>
        
	<ConsumerOrderLineItemModalTable data={data.consumerOrderLineItemList} owner={owner} />
	<ConsumerOrderShippingGroupModalTable data={data.consumerOrderShippingGroupList} owner={owner} />
	<ConsumerOrderPaymentGroupModalTable data={data.consumerOrderPaymentGroupList} owner={owner} />
	<ConsumerOrderPriceAdjustmentModalTable data={data.consumerOrderPriceAdjustmentList} owner={owner} />
	<RetailStoreMemberGiftCardConsumeRecordModalTable data={data.retailStoreMemberGiftCardConsumeRecordList} owner={owner} />
        
        
        
      </Modal>)
    
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(ConsumerOrderAssociateForm))




