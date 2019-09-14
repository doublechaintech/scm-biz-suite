import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch,Modal } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './SupplierProduct.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import SupplierProductBase from './SupplierProduct.base'
import SelectObject from '../../components/SelectObject'
import appLocaleName from '../../common/Locale.tool'

const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input

const testValues = {};
/*
const testValues = {
  productName: '黑人牙膏',
  productDescription: '最好的黑人牙膏，只卖3块喽',
  productUnit: '件',
  supplierId: 'GS000001',
}
*/


const imageKeys = [
]


class SupplierProductAssociateForm extends Component {
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
    const {SupplierProductService} = GlobalComponents
    const userContext = null
    
 const {ProductSupplyDurationModalTable} = GlobalComponents;


    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const {fieldLabels} = SupplierProductBase
    
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
                <Form.Item label={fieldLabels.productName} {...formItemLayout}>
                  {getFieldDecorator('productName', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="品名" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.productDescription} {...formItemLayout}>
                  {getFieldDecorator('productDescription', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="产品描述" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.productUnit} {...formItemLayout}>
                  {getFieldDecorator('productUnit', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <Input size="large" placeholder="产品单元" />
                  )}
                </Form.Item>
              </Col>

            </Row>


       
        









       
            <Row gutter={16}>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.supplier} {...formItemLayout}>
                  {getFieldDecorator('supplierId', {
                  	initialValue: tryinit('supplier'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('supplier')}
                    targetType={"supplier"} 
                    requestFunction={SupplierProductService.requestCandidateSupplier}/>
  
                  )}
                </Form.Item>
              </Col>

            </Row>
         
       

			</Form>
			
			
			
			
        </Card>
        
	<ProductSupplyDurationModalTable data={data.productSupplyDurationList} owner={owner} />
        
        
        
      </Modal>)
    
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(SupplierProductAssociateForm))




