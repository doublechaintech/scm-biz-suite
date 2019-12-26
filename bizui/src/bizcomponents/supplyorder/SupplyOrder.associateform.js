import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch,Modal } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './SupplyOrder.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import SupplyOrderBase from './SupplyOrder.base'
import SelectObject from '../../components/SelectObject'
import appLocaleName from '../../common/Locale.tool'

const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input

const testValues = {};
/*
const testValues = {
  title: '双链给供货商下的订单',
<<<<<<< HEAD
  totalAmount: '2919925248.00',
=======
  totalAmount: '2959247872.00',
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  buyerId: 'RSCC000001',
  sellerId: 'GS000001',
  confirmationId: 'SOC000001',
  approvalId: 'SOA000001',
  processingId: 'SOP000001',
  pickingId: 'SOP000001',
  shipmentId: 'SOS000001',
  deliveryId: 'SOD000001',
}
*/


const imageKeys = [
]


class SupplyOrderAssociateForm extends Component {
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
    const {SupplyOrderService} = GlobalComponents
    const userContext = null
    
 const {SupplyOrderLineItemModalTable} = GlobalComponents;
 const {SupplyOrderShippingGroupModalTable} = GlobalComponents;
 const {SupplyOrderPaymentGroupModalTable} = GlobalComponents;
 const {GoodsModalTable} = GlobalComponents;


    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const {fieldLabels} = SupplyOrderBase
    
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
          title={appLocaleName(userContext,"CreateNew")}
          visible={visible}
          onOk={onCancel}
          onCancel={onCancel}
          width={920}
          style={{ top: 40}}
        >
        <Card title={appLocaleName(userContext,"BasicInfo")}  className={styles.card} style={{ backgroundColor:"#eee" }}>
          <Form >
            <Row gutter={16}>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.title} {...formItemLayout}>
                  {getFieldDecorator('title', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="头衔" />
=======
                    <Input size="large"  placeHolder={fieldLabels.title} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.totalAmount} {...formItemLayout}>
                  {getFieldDecorator('totalAmount', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeholder="总金额" />
=======
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeHolder={fieldLabels.totalAmount} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

            </Row>


       
        









       
            <Row gutter={16}>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.buyer} {...formItemLayout}>
                  {getFieldDecorator('buyerId', {
                  	initialValue: tryinit('buyer'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('buyer')}
                    targetType={"buyer"} 
                    requestFunction={SupplyOrderService.requestCandidateBuyer}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.seller} {...formItemLayout}>
                  {getFieldDecorator('sellerId', {
                  	initialValue: tryinit('seller'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('seller')}
                    targetType={"seller"} 
                    requestFunction={SupplyOrderService.requestCandidateSeller}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.confirmation} {...formItemLayout}>
                  {getFieldDecorator('confirmationId', {
                  	initialValue: tryinit('confirmation'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('confirmation')}
                    targetType={"confirmation"} 
                    requestFunction={SupplyOrderService.requestCandidateConfirmation}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.approval} {...formItemLayout}>
                  {getFieldDecorator('approvalId', {
                  	initialValue: tryinit('approval'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('approval')}
                    targetType={"approval"} 
                    requestFunction={SupplyOrderService.requestCandidateApproval}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.processing} {...formItemLayout}>
                  {getFieldDecorator('processingId', {
                  	initialValue: tryinit('processing'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('processing')}
                    targetType={"processing"} 
                    requestFunction={SupplyOrderService.requestCandidateProcessing}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.picking} {...formItemLayout}>
                  {getFieldDecorator('pickingId', {
                  	initialValue: tryinit('picking'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('picking')}
                    targetType={"picking"} 
                    requestFunction={SupplyOrderService.requestCandidatePicking}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.shipment} {...formItemLayout}>
                  {getFieldDecorator('shipmentId', {
                  	initialValue: tryinit('shipment'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('shipment')}
                    targetType={"shipment"} 
                    requestFunction={SupplyOrderService.requestCandidateShipment}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.delivery} {...formItemLayout}>
                  {getFieldDecorator('deliveryId', {
                  	initialValue: tryinit('delivery'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('delivery')}
                    targetType={"delivery"} 
                    requestFunction={SupplyOrderService.requestCandidateDelivery}/>
  
                  )}
                </Form.Item>
              </Col>

            </Row>
         
       

			</Form>
			
			
			
			
        </Card>
        
	<SupplyOrderLineItemModalTable data={data.supplyOrderLineItemList} owner={owner} />
	<SupplyOrderShippingGroupModalTable data={data.supplyOrderShippingGroupList} owner={owner} />
	<SupplyOrderPaymentGroupModalTable data={data.supplyOrderPaymentGroupList} owner={owner} />
	<GoodsModalTable data={data.goodsList} owner={owner} />
        
        
        
      </Modal>)
    
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(SupplyOrderAssociateForm))




